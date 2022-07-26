package pay2park.service.checkinout;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.exception.ResourceNotFoundException;
import pay2park.extension.Extension;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;

import pay2park.model.checkinout.PreCheckOutData;
import pay2park.model.entityFromDB.PaymentUrl;
import pay2park.model.entityFromDB.Ticket;

import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.PaymentUrlRepository;
import pay2park.repository.TicketsRepository;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
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

    @Override
    public ResponseObject preCheckOut(PreCheckOutData checkOutData) throws IOException {
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
    public ResponseObject checkOut(CheckOutData checkOutData) throws IOException, InterruptedException {

        // Tính tiền các thứ nhận lại amount
        Long amount = 5000L;
        Long ticketID = checkOutData.getTicketID();
        Integer endUserId = checkOutData.getEndUserID();

        // call api thanh toan
        Map<String, String> config = new HashMap<String, String>(){{
            put("endpoint", "http://localhost:8080/api/"+"createOrder");
        }};
        Map<String, Object> param = new HashMap<String, Object>(){{
            put("userId", endUserId);
            put("ticketId", ticketID);
            put("amount", amount);

        }};
        String appTransId = getCurrentTimeString("yyMMdd") +"_"+ endUserId.toString() + ticketID.toString();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(config.get("endpoint"));

        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, Object> e : param.entrySet()) {
            params.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
        }

        // Content-Type: application/x-www-form-urlencoded
        post.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse res = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
        StringBuilder resultJsonStr = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            resultJsonStr.append(line);
        }

        JSONObject result = new JSONObject(resultJsonStr.toString());
        for (String key : result.keySet()) {
            System.out.format("%s = %s\n", key, result.get(key));
        }
        if (result.get("returnCode").equals(2)){
            return new ResponseObject(HttpStatus.FOUND, "payment failed", "");
        }

        paymentUrlRepository.save(new PaymentUrl(appTransId, result.get("orderUrl").toString(), result.get("zpTransToken").toString()));

        // query order status
        Boolean flag = false;
        int counter = 0;
        while (true){
            Thread.sleep(3000);

            Map<String, Object> param1 = new HashMap<String, Object>(){{
                put("appTransId", appTransId);
            }};
            CloseableHttpClient client1 = HttpClients.createDefault();
            HttpPost post1 = new HttpPost("http://localhost:8080/api/"+"queryOrder");

            List<NameValuePair> params1 = new ArrayList<>();
            for (Map.Entry<String, Object> e : param1.entrySet()) {
                params1.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
            }

            // Content-Type: application/x-www-form-urlencoded
            post1.setEntity(new UrlEncodedFormEntity(params1));

            CloseableHttpResponse res1 = client1.execute(post1);
            BufferedReader rd1 = new BufferedReader(new InputStreamReader(res1.getEntity().getContent()));
            StringBuilder resultJsonStr1 = new StringBuilder();
            String line1;

            while ((line1 = rd1.readLine()) != null) {
                resultJsonStr1.append(line1);
            }

            JSONObject result1 = new JSONObject(resultJsonStr1.toString());
            if(result1.get("returnCode").equals(1)){
                flag = true;
                break;
            }
            counter += 1;
            if (counter == 20) break;
        }
        if (flag.equals(true)){
            Instant time = Instant.now();
            ticketsRepository.updateTicketStatus(ticketID, time);

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
}








