package pay2park.service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.ParkingLotImage;
import pay2park.repository.ParkingLotImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ParkingLotImageRepository parkingLotImageRepository;
    @Override
    public Optional<ParkingLotImage> getOneImage(String id) {
        return parkingLotImageRepository.findById(id);
    }
    @Override
    public List<ParkingLotImage> getAllImageByParkingLot(int id) {
        //lay image theo parking_lot_id
//        return parkingLotImageRepository.findById(id);
        return null;
    }
    @Override
    public void insertImage(ParkingLotImage image) {
        parkingLotImageRepository.save(image);
    }
    @Override
    public void deleteImage(String id) {
        parkingLotImageRepository.deleteById(id);
    }
    @Override
    public boolean isExists(String id) {
        return parkingLotImageRepository.existsById(id);
    }
}
