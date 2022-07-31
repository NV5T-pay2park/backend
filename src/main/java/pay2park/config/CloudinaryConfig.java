package pay2park.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    CloudinaryConfig() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "pay2park-cdn",
                "api_key", "367463311317758",
                "api_secret", "kiBCsRp-2V6qZiJ4bYzw1GGWm5w"
        ));
        SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();
    }
}
