package pay2park.service.image;

import pay2park.model.entityFromDB.ParkingLotImage;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Optional<ParkingLotImage> getOneImage(String id);

    List<ParkingLotImage> getAllImageByParkingLot(int id);

    void insertImage(ParkingLotImage image);

    void deleteImage(String id);

    boolean isExists(String id);
}
