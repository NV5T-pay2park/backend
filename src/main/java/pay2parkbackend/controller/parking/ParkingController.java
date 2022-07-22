package pay2parkbackend.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2parkbackend.model.ResponseObject;
import pay2parkbackend.service.parking.ParkingService;


import java.io.IOException;


    @RestController
    @RequestMapping("/api/")
    public class ParkingController {
        @Autowired
        private ParkingService parkingService;

        @GetMapping("/getAllParking")
        @ResponseBody
        public ResponseObject getAllParking() throws IOException {

            var data = parkingService.getAllParking();
            return
                    new ResponseObject(HttpStatus.OK, "get all parking successfully", data) ;
        }

        @GetMapping("/getAllParking/{parkingLotId}")
        @ResponseBody
        public ResponseObject getParkingById(@PathVariable(value="parkingLotId") Long parkingLotId)  {

            var data = parkingService.getParkingById(parkingLotId);
            return
                    new ResponseObject(HttpStatus.OK, "get parking by id successfully ", data);
        }


    }

