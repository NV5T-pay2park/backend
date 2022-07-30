package pay2park.service.websocket;

import pay2park.model.websocket.SocketMessageData;

public interface Socket {
    boolean sendToMerchant(int parkingLotID, SocketMessageData socketMessageData);
    boolean RequestToEnterLicensePlate(int parkingLotID);
    boolean SendCheckInSuccessful(int parkingLotID);
    boolean SendCheckInFail(int parkingLotID);
}
