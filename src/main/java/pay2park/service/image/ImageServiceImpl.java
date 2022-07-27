package pay2park.service.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pay2park.model.ResponseObject;
import pay2park.model.cloudinary.CloudinaryResponse;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;
import pay2park.repository.ParkingLotImageRepository;
import pay2park.repository.ParkingLotRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    ParkingLotImageRepository parkingLotImageRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;
    @Autowired
    private Environment env;
    private final Map<String, String> configCloudinary = Map.of(
            "cloud_name", "pay2park-cdn",
            "api_key", "367463311317758",
            "api_secret", "kiBCsRp-2V6qZiJ4bYzw1GGWm5w");
    Cloudinary cloudinary = new Cloudinary(configCloudinary);
    @Override
    public ResponseObject getOneImage(String id) {
        Optional<ParkingLotImage> parkingLotImage = parkingLotImageRepository.findById(id);
        return parkingLotImage.map(lotImage -> new ResponseObject(HttpStatus.OK, "Success", lotImage))
                .orElseGet(() -> new ResponseObject(HttpStatus.FOUND, "ID is not valid", ""));
    }
    @Override
    public ResponseObject getAllImageByParkingLot(int parkingLotId) {
        if(!checkParkingLotID(parkingLotId)) {
            return new ResponseObject(HttpStatus.FOUND, "Parking lot ID is not valid", "");
        }
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotId);
        List<ParkingLotImage> responseData = parkingLotImageRepository.getAllImageByParkingLot(parkingLot.get());
        return new ResponseObject(HttpStatus.OK, "Success", responseData);
    }
    @Override
    public ResponseObject insertImage(MultipartFile multipartFile, ParkingLot parkingLot) {
        try {
            BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
            if(bufferedImage == null){
                return new ResponseObject(HttpStatus.FOUND, "File error", "");
            }
            CloudinaryResponse cloudinaryResponse = upload(multipartFile);
            ParkingLotImage parkingLotImage = new ParkingLotImage();
            parkingLotImage.setId(cloudinaryResponse.getPublicIp());
            parkingLotImage.setUrl(cloudinaryResponse.getUrl());
            parkingLotImage.setParkingLot(parkingLot);
            parkingLotImageRepository.save(parkingLotImage);
            return new ResponseObject(HttpStatus.OK, "Success", parkingLotImage);
        } catch (IOException e) {
            return new ResponseObject(HttpStatus.FOUND, "File error", "");
        }
    }
    @Override
    public ResponseObject deleteImage(String id) {
        if(!isExists(id)) return new ResponseObject(HttpStatus.FOUND, "Image is not exist", "");
        CloudinaryResponse cloudinaryResponse = delete(id);
        parkingLotImageRepository.deleteById(id);
        return new ResponseObject(HttpStatus.OK, "Success", "");
    }
    public boolean isExists(String id) {
        return parkingLotImageRepository.existsById(id);
    }
    private boolean checkParkingLotID(int parkingLotID) {
        return parkingLotRepository.existsById(parkingLotID);
    }
    public CloudinaryResponse upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        CloudinaryResponse cloudinaryResponse = (CloudinaryResponse) cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return cloudinaryResponse;
    }
    public CloudinaryResponse delete(String id) {
        try {
            return (CloudinaryResponse) cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
