package pay2park.service.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pay2park.model.cloudinary.CloudinaryResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//@Service
public class CloudinaryServiceImpl {//implements CloudinaryService {
//    @Autowired
//    Cloudinary cloudinary;
//    @Autowired
//    private Environment env;
//    @Autowired
//    public void cloudConfig() {
//        Map<String, String> valuesConfig = new HashMap<>();
//        valuesConfig.put("cloud_name", env.getProperty("cloudinary.cloud_name"));
//        valuesConfig.put("api_key", env.getProperty("cloudinary.api_key"));
//        valuesConfig.put("api_secret", env.getProperty("cloudinary.api_secret"));
//        cloudinary = new Cloudinary(valuesConfig);
//    }
//    @Override
//    public CloudinaryResponse uploadImage(MultipartFile multipartFile) throws IOException {
//        File file = convert(multipartFile);
//        CloudinaryResponse cloudinaryResponse = (CloudinaryResponse) cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
//        file.delete();
//        return cloudinaryResponse;
//    }
//
//    @Override
//    public CloudinaryResponse deleteImage(String id) throws IOException {
//        return (CloudinaryResponse) cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
//    }
//    private File convert(MultipartFile multipartFile) throws IOException {
//        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
//        FileOutputStream fo = new FileOutputStream(file);
//        fo.write(multipartFile.getBytes());
//        fo.close();
//        return file;
//    }
}
