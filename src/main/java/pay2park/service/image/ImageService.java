package pay2park.service.image;

import org.springframework.web.multipart.MultipartFile;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.ParkingLotImage;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    ResponseObject getOneImage(String id);

    ResponseObject getAllImageByParkingLot(int id);

    void insertImage(MultipartFile multipartFile);

    void deleteImage(String id);

    boolean isExists(String id);
}