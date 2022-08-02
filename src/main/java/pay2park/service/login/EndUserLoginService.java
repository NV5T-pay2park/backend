package pay2park.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.login.EndUserLoginData;
import pay2park.repository.EndUserRepository;

import java.util.List;

@Service
public class EndUserLoginService {
    @Autowired
    EndUserRepository endUserRepository;

    public ResponseObject login(EndUserLoginData data) {

        if (!isValidLoginData(data))
            return new ResponseObject(HttpStatus.FOUND, "ZaloPayId is invalid", null);
        List<EndUser> userList;
        while (true) {
            userList = endUserRepository.getEndUserBaseOnZalopayID(data.getZalopayID());
            if (userList.size() == 1) break;
            if (userList.size() > 1) {
                return new ResponseObject(HttpStatus.FOUND, "Can't mapping user", null);
            }
            EndUser newEndUser = new EndUser(data.getZalopayID(), data.getFirstName(), data.getLastName());
            endUserRepository.save(newEndUser);
        }
        int endUserID = userList.get(0).getId();
        data.setEndUserID(endUserID);
        return new ResponseObject(HttpStatus.OK, "Success", data);
    }

    boolean isValidLoginData(EndUserLoginData loginData) {
        String zalopayID = loginData.getZalopayID();
        if (zalopayID.equals("")) return false;
        for (int i = 0; i < zalopayID.length(); ++i) {
            if (zalopayID.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    }
}
