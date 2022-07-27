package pay2park;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Map;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Pay2parkBackendApplication {
	public static void main(String[] args) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "pay2park-cdn",
				"api_key", "367463311317758",
				"api_secret", "kiBCsRp-2V6qZiJ4bYzw1GGWm5w"
		));
		SingletonManager manager = new SingletonManager();
		manager.setCloudinary(cloudinary);
		manager.init();
		SpringApplication.run(Pay2parkBackendApplication.class, args);
	}

}
