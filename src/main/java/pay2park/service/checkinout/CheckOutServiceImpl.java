package pay2park.service.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.exception.ResourceNotFoundException;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;

import pay2park.model.checkinout.PreCheckOutData;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PaymentUrl;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.entityFromDB.Ticket;

import pay2park.model.payment.OrderData;
import pay2park.model.payment.QueryData;
import pay2park.model.payment.ResponseOrderData;
import pay2park.model.payment.ResponseQueryData;
import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.PaymentUrlRepository;
import pay2park.repository.TicketsRepository;
import pay2park.service.payment.CreateOrderService;
import pay2park.service.payment.QueryOrderService;


import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    EndUserRepository endUserRepository;
    @Autowired
    TicketsRepository ticketsRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;
    @Autowired
    PaymentUrlRepository paymentUrlRepository;
    @Autowired
    CreateOrderService createOrderService;
    @Autowired
    QueryOrderService queryOrderService;

    @Override
    public ResponseObject preCheckOut(PreCheckOutData checkOutData){
        if (!checkDataIsValid(checkOutData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", "");
        }

        Ticket ticket = ticketsRepository.findById(checkOutData.getTicketID()).orElseThrow(() -> new ResourceNotFoundException("Ticket not exist with id: "+ checkOutData.getTicketID()));
        if (ticket.getCheckOutTime() != null){
            return new ResponseObject(HttpStatus.FOUND, "Ticket was checked out before", "");
        }
        return new ResponseObject(HttpStatus.OK, "Pre checkout successfully", ticket.getLicensePlates());
    }


    @Override
    public ResponseObject checkOut(CheckOutData checkOutData) throws IOException, InterruptedException, URISyntaxException {


        // Calculate amount of ticket
        Long amount = 60000L;
        Long ticketID = checkOutData.getTicketID();
        Integer endUserId = checkOutData.getEndUserID();

        // Check checkout
        String appTransId = getCurrentTimeString("yyMMdd") + "_" + endUserId + ticketID.toString();
        boolean appTransIdExist = paymentUrlRepository.existsById(appTransId);

        if (!appTransIdExist) {

            // call api payment
            OrderData orderData = new OrderData(ticketID, (long) endUserId, amount);
            ResponseOrderData responseOrderData = createOrderService.createOrder(orderData);
            if (responseOrderData.getReturnCode() == 2) {
                return new ResponseObject(HttpStatus.FOUND, "payment failed", "");
            }
            paymentUrlRepository.save(new PaymentUrl(appTransId, responseOrderData.getOrderUrl(), responseOrderData.getZpTransToken()));
        }

        // query order status
        Boolean flag = false;
        int counter = 0;
        while (true) {
            Thread.sleep(3000);
            QueryData queryData = new QueryData(appTransId);
            ResponseQueryData responseQueryData = queryOrderService.queryOrder(queryData);

            if (responseQueryData.getReturnCode() == 1) {
                flag = true;
                break;
            }
            counter += 1;
            if (counter == 200) break;
        }
        if (flag.equals(true)) {
            // update ticket checkout time and slot of parking
            Instant time = Instant.now();
            Ticket ticketUpdate = ticketsRepository.findById(ticketID).orElseThrow(() -> new ResourceNotFoundException("Ticket not exist with id: " + ticketID));
            ticketUpdate.setCheckOutTime(time);
            ticketsRepository.save(ticketUpdate);
            ParkingLot parkingLotUpdate = parkingLotRepository.findById(ticketUpdate.getParkingLot().getId()).orElseThrow(() -> new ResourceNotFoundException("Ticket not exist with id: " + ticketID));
            int newSlotRemaining = parkingLotUpdate.getNumberSlotRemaining() + 1;
            parkingLotUpdate.setNumberSlotRemaining(newSlotRemaining);
            parkingLotRepository.save(parkingLotUpdate);

            return new ResponseObject(HttpStatus.OK, "checkout successfully", "");
        }

        return new ResponseObject(HttpStatus.FOUND, "checkout failed", "");
    }

    private boolean checkDataIsValid(PreCheckOutData preCheckOutData) {
        boolean checkTicketIsExist = ticketsRepository.
                existsById(preCheckOutData.getTicketID());
        boolean checkEndUserIDIsExist = endUserRepository.
                existsById(preCheckOutData.getEndUserID());
        boolean checkParkingLotIDIsExist = parkingLotRepository.
                existsById(preCheckOutData.getParkingLotID());
        return checkEndUserIDIsExist && checkTicketIsExist && checkParkingLotIDIsExist;
    }

    public String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }

    private int calculateAmountOfTicket(double parkingHour, PriceTicket[] PriceTickets) {
        int result = 0;
        for (int i = 0; i < PriceTickets.length; i++) {
            double time = 0;
            if (i + 1 < PriceTickets.length && parkingHour > PriceTickets[i+1].getPeriodTime()) {
                time = PriceTickets[i+1].getPeriodTime() - PriceTickets[i].getPeriodTime();
            }
            else {
                time = parkingHour - PriceTickets[i].getPeriodTime();
            }
            int units = (int) Math.ceil(time / PriceTickets[i].getUnit());
            result += units * PriceTickets[i].getPrice();
        }
        return result;
    }
}