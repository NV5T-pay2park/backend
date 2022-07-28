package pay2park.service.websocket;

import pay2park.model.websocket.SocketMessageData;

public interface Socket {
    public boolean sendToMerchant(int parkingLotID, SocketMessageData socketMessageData);
    public boolean RequestToEnterLicensePlate(int parkingLotID);
    public boolean SendCheckInSuccessful(int parkingLotID);
    public boolean SendCheckInFail(int parkingLotID);
}
