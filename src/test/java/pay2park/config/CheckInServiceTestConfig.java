package pay2park.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import pay2park.service.checkinout.CheckInService;

@Profile("testMockCheckInService")
@Configuration
public class CheckInServiceTestConfig {
    @Bean
    @Primary
    public CheckInService checkInService() {
        return Mockito.mock(CheckInService.class);
    }
}
