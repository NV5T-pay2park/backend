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
        public ResponseObject getParkingById(
                @PathVariable(value="parkingLotId") Integer parkingLotId, @RequestParam String coordinates) throws IOException {
            ParkingDetailData data = parkingService.getParkingById(parkingLotId, coordinates);
            return
                    new ResponseObject(HttpStatus.OK, "get parking by id successfully ", data);
        }


        @GetMapping("/filterParking")
        @ResponseBody
        public ResponseObject filterParking(@RequestParam String coordinates, @RequestParam String vehicleTypes) throws IOException {

            var data = parkingService.filterParking(coordinates, vehicleTypes);
            return
                    new ResponseObject(HttpStatus.OK, "filter parking successfully ", data);
        }

        @GetMapping("/searchParking")
        @ResponseBody
        public ResponseObject searchParking(@RequestParam String stringSearch) throws IOException {
            var data = parkingService.searchParking(stringSearch);
            return
                    new ResponseObject(HttpStatus.OK, "search parking successfully ", data);
        }



    }

