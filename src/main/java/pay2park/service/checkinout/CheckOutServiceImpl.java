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
import pay2park.extension.Extension;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;
import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.TicketsRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    @Override
    public ResponseObject checkOut(CheckOutData checkOutData) throws IOException {
        if (!checkDataIsValid(checkOutData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", "");
        }
        if (!checkTicketIsValid(checkOutData)) {
            return new ResponseObject(HttpStatus.FOUND, "Ticket is not valid", "");
        }
        Long ticketID = checkOutData.getTicketID();
        Instant checkOutTime = Extension.getCheckInTime();
 //     ticketsRepository.updateTicket(checkOutTime, ticketID);
        //

        // call api thanh toan
        Map<String, String> config = new HashMap<String, String>(){{
            put("endpoint", "http://localhost:8080/api/"+"createOrder");
        }};
        Map<String, Object> param= new HashMap<String, Object>(){{
            put("userId", 1);
            put("ticketId", 2);
            put("amount", 15000); // translation missing: en.docs.shared.sample_code.comments.app_trans_id

        }};
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

        return new ResponseObject(HttpStatus.OK, "alo", "");
    }

    private boolean checkDataIsValid(CheckOutData checkOutData) {
//        boolean checkTicketIsExist = ticketsRepository.
//                existsById(checkOutData.getTicketID());
//        boolean checkEndUserIDIsExist = endUserRepository.
//                existsById(checkOutData.getEndUserID());
//        boolean checkParkingLotIDIsExist = parkingLotRepository.
//                existsById(checkOutData.getParkingLotID());
//        boolean checkLicensePlateIsValid = checkOutData.getLicensePlate().length() > 0;
//        return checkEndUserIDIsExist && checkTicketIsExist && checkParkingLotIDIsExist && checkLicensePlateIsValid;
        return true;
    }

    private boolean checkTicketIsValid(CheckOutData checkOutData) {
//        Optional<EndUser> endUser = endUserRepository.
//                findById(checkOutData.getEndUserID());
//        Optional<ParkingLot> parkingLot = parkingLotRepository.
//                findById(checkOutData.getParkingLotID());
//        List<Ticket> tickets = ticketsRepository.getTicketByEndUserIDAndParkingLot(endUser.get(), parkingLot.get());
//        if (tickets.size() == 0) return false;
//        Ticket ticket = tickets.get(0);
//        return Objects.equals(ticket.getLicensePlates(), checkOutData.getLicensePlate());
        return true;
    }
}
