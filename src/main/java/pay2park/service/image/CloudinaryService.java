package pay2park.service.image;

import org.springframework.web.multipart.MultipartFile;
import pay2park.model.cloudinary.CloudinaryResponse;

import java.io.IOException;

public interface CloudinaryService {
    CloudinaryResponse uploadImage(MultipartFile multipartFile) throws IOException;
    CloudinaryResponse deleteImage(String id) throws IOException;
}
