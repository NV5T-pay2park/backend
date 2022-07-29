package pay2park.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.login.LoginData;
import pay2park.repository.EndUserRepository;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    EndUserRepository endUserRepository;

    public ResponseObject login(LoginData data) {

        if (!isValidLoginData(data))
            return new ResponseObject(HttpStatus.FOUND, "ZaloPayId is invalid", "");
        List<EndUser> userList;
        while (true) {
            userList = endUserRepository.getEndUserBaseOnZalopayID(data.getZalopayID());
            if (userList.size() == 1) break;
            if (userList.size() > 1) {
                return new ResponseObject(HttpStatus.FOUND, "Can't mapping user", "");
            }
            EndUser newEndUser = new EndUser();
            newEndUser.setEmail("NaN");
            newEndUser.setFirstName("NaN");
            newEndUser.setLastName("NaN");
            newEndUser.setGender(1);
            newEndUser.setPhone("NaN");
            newEndUser.setZalopayId(data.getZalopayID());
            endUserRepository.save(newEndUser);
        }
        int endUserID = userList.get(0).getId();
        data.setEndUserID(endUserID);
        return new ResponseObject(HttpStatus.OK, "Success", data);
    }

    boolean isValidLoginData(LoginData loginData) {
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
