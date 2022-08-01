package pay2park.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import pay2park.model.websocket.SocketConnectData;
import pay2park.model.websocket.SocketMessageData;
import pay2park.service.websocket.Socket;

@RestController
@CrossOrigin
public class SocketController {

//    @Autowired
//    SimpMessagingTemplate template;
    @Autowired
    Socket socket;

    @PostMapping("/sendToMerchant/{parkingLotID}")
    public boolean sendToMerchant(@RequestBody SocketMessageData socketMessageData, @PathVariable int parkingLotID) {
        socket.sendToMerchant(parkingLotID, socketMessageData);
//        template.convertAndSend("/user/" + String.valueOf(parkingLotID) , socketMessageData);
        return true;
    }

    @MessageMapping("/connect")
    public boolean receiveMessage(@Payload SocketConnectData socketConnectData) {
        System.out.println("connect: " + socketConnectData.getParkingLotID());
        return true;
    }
}