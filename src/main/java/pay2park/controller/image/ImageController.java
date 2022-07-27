package pay2park.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pay2park.model.ResponseObject;
import pay2park.service.image.ImageService;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping("uploadImage")
    public ResponseEntity<ResponseObject> upload(@RequestParam MultipartFile multipartFile, @RequestParam int parkingLotID) {
        ResponseObject responseObject = imageService.insertImage(multipartFile, parkingLotID);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
    @DeleteMapping("deleteImage")
    public ResponseEntity<ResponseObject> deleteImage(@RequestParam("id") String id) {
        ResponseObject responseObject = imageService.deleteImage(id);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
}
