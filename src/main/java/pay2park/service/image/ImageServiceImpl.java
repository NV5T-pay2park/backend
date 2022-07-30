package pay2park.service.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;
import pay2park.repository.ParkingLotImageRepository;
import pay2park.repository.ParkingLotRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    ParkingLotImageRepository parkingLotImageRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;
    private final Cloudinary cloudinary = Singleton.getCloudinary();

    @Override
    public ResponseObject getImageByID(String id) {
        Optional<ParkingLotImage> parkingLotImage = parkingLotImageRepository.findById(id);
        return parkingLotImage.map(image -> new ResponseObject(HttpStatus.OK, "Success", image.getUrl()))
                .orElseGet(() -> new ResponseObject(HttpStatus.FOUND, "ID is not valid", ""));
    }

    @Override
    public ResponseObject getAllImageByParkingLot(int parkingLotId) {
        if (!checkParkingLotID(parkingLotId)) {
            return new ResponseObject(HttpStatus.FOUND, "Parking lot ID is not valid", "");
        }
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotId);
        List<ParkingLotImage> responseData = parkingLotImageRepository.getAllImageByParkingLot(parkingLot.get());
        return new ResponseObject(HttpStatus.OK, "Success", responseData);
    }

    @Override
    public ResponseObject insertImage(List<MultipartFile> multipartFiles, int parkingLotID) {
        if(multipartFiles.size() == 0) {
            new ResponseObject(HttpStatus.FOUND, "File error", "");
        }
        if (!checkImageList(multipartFiles)) {
            new ResponseObject(HttpStatus.FOUND, "File error", "");
        }
        List<byte[]> imageByteList = getImageByteList(multipartFiles);
        if (imageByteList.size() != multipartFiles.size()) {
            new ResponseObject(HttpStatus.FOUND, "File error", "");
        }
        List<ParkingLotImage> parkingLotImages = new ArrayList<>();
        for(byte[] imageBytes : imageByteList) {
            Map cloudinaryResponse = uploadImage(imageBytes);
            ParkingLotImage parkingLotImage = new ParkingLotImage();
            Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotID);
            parkingLotImage.setId(cloudinaryResponse.get("public_id").toString());
            parkingLotImage.setUrl(cloudinaryResponse.get("url").toString());
            parkingLotImage.setParkingLot(parkingLot.get());
            parkingLotImages.add(parkingLotImage);
        }
        parkingLotImageRepository.saveAll(parkingLotImages);
        return new ResponseObject(HttpStatus.OK, "Success", parkingLotImages);
    }

    @Override
    public ResponseObject deleteImage(String id) {
        if (!isExists(id)) return new ResponseObject(HttpStatus.FOUND, "Image is not exist", "");
        try {
            Map deleteResult = null;
            deleteResult = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
            parkingLotImageRepository.deleteById(id);
            return new ResponseObject(HttpStatus.OK, "Success", deleteResult);
        } catch (IOException e) {
            return new ResponseObject(HttpStatus.FOUND, "Found", "");
        }

    }

    public boolean isExists(String id) {
        return parkingLotImageRepository.existsById(id);
    }
    private boolean checkParkingLotID(int parkingLotID) {
        return parkingLotRepository.existsById(parkingLotID);
    }
    private boolean checkImageList(List<MultipartFile> multipartFiles) {
        for(MultipartFile multipartFile:multipartFiles) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(multipartFile.getInputStream());
            } catch (IOException e) {
                return false;
            }
            if (bufferedImage == null) {
                return false;
            }
        }
        return true;
    }
    private List<byte[]> getImageByteList (List<MultipartFile> multipartFiles) {
        List<byte[]> imageByteList = new ArrayList<>();
        for(MultipartFile multipartFile:multipartFiles) {
            try {
                imageByteList.add(multipartFile.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return imageByteList;
    }
    private Map uploadImage(byte[] imageBytes) {
        Map cloudinaryResponse;
        try {
            cloudinaryResponse = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
            return cloudinaryResponse;
        } catch (IOException e) {
            return new HashMap();
        }
    }
}
