package pay2park.service;

import org.springframework.stereotype.Service;
import pay2park.model.Ticket;

import java.util.List;
import java.util.Map;

@Service
public interface CheckInService {
    Map<String, Object> checkIn(Map<String, Object> checkInData);
}
