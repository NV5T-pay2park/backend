package pay2park.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;
import pay2park.service.parking.ParkingService;


import java.io.IOException;
import java.util.List;


@RestController
    @RequestMapping("/api/")
    public class ParkingController {
        @Autowired
        private ParkingService parkingService;

        @GetMapping("/getAllParking")
        @ResponseBody
        public ResponseObject getAllParking() throws IOException {

            List<ParkingListData> data = parkingService.getAllParking();
            return
                    new ResponseObject(HttpStatus.OK, "get all parking successfully", data) ;
        }



        @GetMapping("/getAllParking/{parkingLotId}")
        @ResponseBody
        public ResponseObject getParkingById(@PathVariable(value="parkingLotId") Integer parkingLotId)  {

            ParkingDetailData data = parkingService.getParkingById(parkingLotId);
            return
                    new ResponseObject(HttpStatus.OK, "get parking by id successfully ", data);
        }


        @GetMapping("/getParking")
        @ResponseBody
        public ResponseObject getParkingWithPagination(@RequestParam String coordinates,@RequestParam String stringSearch, @RequestParam String vehicleTypes) throws IOException {



            return
                    new ResponseObject(HttpStatus.OK, "get parking successfully", "search") ;
        }


    }
