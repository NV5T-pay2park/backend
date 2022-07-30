package pay2park.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pay2park.model.ResponseObject;
import pay2park.service.image.ImageService;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping("uploadImage")
    public ResponseEntity<ResponseObject> upload(@RequestBody List<MultipartFile> multipartFiles, @RequestBody int parkingLotID) {
        ResponseObject responseObject = imageService.insertImage(multipartFiles, parkingLotID);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
    @DeleteMapping("deleteImage")
    public ResponseEntity<ResponseObject> deleteImage(@RequestParam String id) {
        ResponseObject responseObject = imageService.deleteImage(id);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
    @GetMapping("getAllImageByParkingLot")
    public ResponseEntity<ResponseObject> getAllImageByParkingLot(@RequestParam int parkingLotID) {
        ResponseObject responseObject = imageService.getAllImageByParkingLot(parkingLotID);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
    @GetMapping("getImageByID")
    public ResponseEntity<ResponseObject> getImageByID(@RequestParam String id) {
        ResponseObject responseObject = imageService.getImageByID(id);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
}
