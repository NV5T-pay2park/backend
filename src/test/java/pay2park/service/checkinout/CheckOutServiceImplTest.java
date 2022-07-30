package pay2park.service.checkinout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import pay2park.model.checkinout.CheckOutData;
import pay2park.model.checkinout.PreCheckOutData;
import pay2park.model.entityFromDB.*;
import pay2park.model.payment.OrderData;
import pay2park.model.payment.ResponseOrderData;
import pay2park.model.payment.ResponseQueryData;
import pay2park.repository.*;
import pay2park.service.payment.CreateOrderService;
import pay2park.service.payment.CreateOrderServiceImpl;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class CheckOutServiceImplTest {

    @Mock
    TicketsRepository ticketsRepository;
    @Mock
    EndUserRepository endUserRepository;
    @Mock
    ParkingLotRepository parkingLotRepository;
    @Mock
    PriceTicketRepository priceTicketRepository;
    @Mock
    PaymentUrlRepository paymentUrlRepository;

    @InjectMocks
    CheckOutServiceImpl checkOutServiceImpl = new CheckOutServiceImpl();

    @BeforeEach
    void setMockOutput() throws IOException {
        when(ticketsRepository.existsById(1L)).thenReturn(true);
        when(ticketsRepository.existsById(2L)).thenReturn(false);
        when(ticketsRepository.existsById(3L)).thenReturn(true);
        when(parkingLotRepository.existsById(1)).thenReturn(true);
        when(endUserRepository.existsById(1)).thenReturn(true);
    }

    @DisplayName("Test pre checkout function - data not valid")
    @Test
    void testDataIsValid() {
        PreCheckOutData preCheckOutData = new PreCheckOutData(2L, 1, 1);
        assertEquals(false, checkOutServiceImpl.checkDataIsValid(preCheckOutData));
    }

    @DisplayName("Test get current time function - data not valid")
    @Test
    void testGetCurrentTimeString() {

        assertEquals(6, checkOutServiceImpl.getCurrentTimeString("yyMMdd").length());
    }

    @DisplayName("Test calculate amount of ticket function")
    @Test
    void testCalculateAmount() {
        List<PriceTicket> priceTicketList = new ArrayList<>();
        PriceTicket priceTicket1 = new PriceTicket(new PriceTicketId(1, 0, 0), new ParkingLot(), new VehicleType(), 0, 3000, 4);
        priceTicketList.add(priceTicket1);
        assertEquals(3000, checkOutServiceImpl.calculateAmountOfTicket(1, priceTicketList));
    }


    @DisplayName("Test preCheckout - data not valid")
    @Test
    void testPreCheckout1() {
        PreCheckOutData preCheckOutData = new PreCheckOutData(2L, 1, 1);
        assertEquals(HttpStatus.FOUND, checkOutServiceImpl.preCheckOut(preCheckOutData).getStatus());
    }

    @DisplayName("Test preCheckout - ticket was created")
    @Test
    void testPreCheckout2() {
        PreCheckOutData preCheckOutData = new PreCheckOutData(1L, 1, 1);
        Ticket ticket = new Ticket();
        ticket.setCheckOutTime(Instant.now());
        when(ticketsRepository.findById(1L)).thenReturn(Optional.of(ticket));

        assertEquals(HttpStatus.FOUND, checkOutServiceImpl.preCheckOut(preCheckOutData).getStatus());
        assertEquals("Ticket was checked out before", checkOutServiceImpl.preCheckOut(preCheckOutData).getMessage());
    }

    @BeforeEach
    void setMockOutput3() {
        when(ticketsRepository.findById(1L)).thenReturn(java.util.Optional.of(new Ticket()));
    }

    @DisplayName("Test preCheckout - ok ")
    @Test
    void testPreCheckout3() {
        PreCheckOutData preCheckOutData = new PreCheckOutData(1L, 1, 1);
        when(checkOutServiceImpl.checkDataIsValid(preCheckOutData)).thenReturn(true);
        assertEquals(HttpStatus.OK, checkOutServiceImpl.preCheckOut(preCheckOutData).getStatus());
    }


    @DisplayName("Test Checkout - amount of ticket < 0")
    @Test
    void testCheckout1() throws IOException, URISyntaxException, InterruptedException {
        CheckOutData checkOutData = new CheckOutData(3L, 1);
        Ticket ticket = new Ticket();
        ticket.setId(3L);
        ticket.setCheckInTime(Instant.now());
        when(ticketsRepository.findById(3L)).thenReturn(Optional.of(ticket));
        assertEquals("payment failed with amount of ticket", checkOutServiceImpl.checkOut(checkOutData).getMessage());

    }

    @DisplayName("Test Checkout - payment fail 1")
    @Test
    void testCheckout2() throws IOException, URISyntaxException, InterruptedException {
        CheckOutData checkOutData = new CheckOutData(3L, 1);
        Ticket ticket = new Ticket();
        ticket.setId(3L);
        ticket.setParkingLot(new ParkingLot());
        ticket.setCheckInTime(Instant.now().minusMillis(1000));
        ticket.setCheckOutTime(Instant.now().plusMillis(1000));
        when(ticketsRepository.findById(3L)).thenReturn(Optional.of(ticket));

        List<PriceTicket> priceTicketList = new ArrayList<>();
        PriceTicket priceTicket1 = new PriceTicket(new PriceTicketId(3, 0, 0), new ParkingLot(), new VehicleType(), 0, 3000, 4);
        priceTicketList.add(priceTicket1);
        when(priceTicketRepository.getPriceTicketByParkingLotIdAndVehicleType(ticket.getParkingLot(), ticket.getVehicleType())).thenReturn(priceTicketList);


        when(ticketsRepository.findById(3L)).thenReturn(Optional.of(ticket));
        String appTransId = checkOutServiceImpl.getCurrentTimeString("yyMMdd") + "_" + checkOutData.getEndUserID() + checkOutData.getTicketID().toString();
        when(paymentUrlRepository.existsById(appTransId)).thenReturn(true);
        ResponseQueryData responseQueryData = new ResponseQueryData(2);
        //assertEquals("checkout failed because ZLP server", checkOutServiceImpl.checkOut(checkOutData).getMessage());

    }

    @DisplayName("Test Checkout - payment fail 2")
    @Test
    void testCheckout3() throws IOException, URISyntaxException, InterruptedException {
        CheckOutData checkOutData = new CheckOutData(3L, 1);
        Ticket ticket = new Ticket();
        ticket.setId(3L);
        ticket.setParkingLot(new ParkingLot());
        ticket.setCheckInTime(Instant.now().minusMillis(1000));
        ticket.setCheckOutTime(Instant.now().plusMillis(1000));
        when(ticketsRepository.findById(3L)).thenReturn(Optional.of(ticket));
        List<PriceTicket> priceTicketList = new ArrayList<>();
        PriceTicket priceTicket1 = new PriceTicket(new PriceTicketId(3,0,0), new ParkingLot(),new VehicleType(),0,3000,4);
        priceTicketList.add(priceTicket1);
        when(priceTicketRepository.getPriceTicketByParkingLotIdAndVehicleType(ticket.getParkingLot(), ticket.getVehicleType())).thenReturn(priceTicketList);
        when(ticketsRepository.findById(3L)).thenReturn(Optional.of(ticket));
        String appTransId = checkOutServiceImpl.getCurrentTimeString("yyMMdd") + "_" + checkOutData.getEndUserID() + checkOutData.getTicketID().toString();
        when(paymentUrlRepository.existsById(appTransId)).thenReturn(false);
        OrderData orderData = new OrderData(checkOutData.getTicketID(), (long) checkOutData.getEndUserID(), 6000);
        ResponseOrderData responseOrderData = new ResponseOrderData();
        responseOrderData.setReturnCode(2);
        //when(createOrderService.createOrder(orderData)).thenReturn(responseOrderData);
        //assertEquals("checkout failed because ZLP server", checkOutServiceImpl.checkOut(checkOutData).getMessage());

    }
}