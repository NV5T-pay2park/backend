package pay2park.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pay2park.model.ResponseObject;
import pay2park.service.image.ImageService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ImageController {
//    @Autowired
//    ImageService imageService;
    @PostMapping("uploadImage")
    public ResponseEntity<ResponseObject> upload(@RequestParam MultipartFile multipartFile) {
        return null;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseObject> deleteImage(@RequestParam("id") String id) {
        return null;
    }
}
