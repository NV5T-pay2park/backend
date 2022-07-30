package pay2park.service.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import pay2park.model.websocket.SocketMessageData;

@Service
public class SocketImpl implements Socket {

    @Autowired
    SimpMessagingTemplate template;

    @Override
    public boolean sendToMerchant(int parkingLotID, SocketMessageData socketMessageData) {
        template.convertAndSend("/user/" + parkingLotID + "/merchant" , socketMessageData);
        return true;
    }

    @Override
    public boolean RequestToEnterLicensePlate(int parkingLotID) {
        SocketMessageData socketMessageData = new SocketMessageData(-1, "“enter license plate and vehicle type”");
        return sendToMerchant(parkingLotID, socketMessageData);
    }

    @Override
    public boolean SendCheckInSuccessful(int parkingLotID) {
        SocketMessageData socketMessageData = new SocketMessageData(0, "checkin success");
        return sendToMerchant(parkingLotID, socketMessageData);
    }

    @Override
    public boolean SendCheckInFail(int parkingLotID) {
        SocketMessageData socketMessageData = new SocketMessageData(1, "checkin fail");
        return sendToMerchant(parkingLotID, socketMessageData);
    }
}
