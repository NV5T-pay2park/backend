package pay2park.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.repositories.EndUserRepository;

import java.util.Map;

@Service
public class CheckOutServiceImpl implements CheckOutService{
    @Autowired
    EndUserRepository endUserRepository;
    @Override
    public Map<String, Object> checkOut() {
        return null;
    }
}
