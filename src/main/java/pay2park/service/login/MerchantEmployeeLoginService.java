package pay2park.service.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.MerchantEmployee;
import pay2park.model.entityFromDB.Permission;
import pay2park.model.login.MerchantEmployeePermissions;
import pay2park.model.login.MerchantEmployeeRequestLoginData;
import pay2park.model.login.MerchantEmployeeResponseLoginData;
import pay2park.repository.MerchantEmployeeRepository;
import pay2park.repository.PermissionRepository;
import pay2park.security.Hash;

import java.util.List;

@Service
public class MerchantEmployeeLoginService {
    @Autowired
    MerchantEmployeeRepository merchantEmployeeRepository;
    @Autowired
    PermissionRepository permissionRepository;

    public ResponseObject login(MerchantEmployeeRequestLoginData requestData) {
        String phone = requestData.getPhone();
        if (!isValidPhoneLoginData(phone)) {
            return new ResponseObject(HttpStatus.FOUND, "invalid phone number", null);
        }

        String userName = requestData.getUserName();
        if (userName != null && !isValidUserName(userName)) {
            return new ResponseObject(HttpStatus.FOUND, "invalid user name", null);
        }

        String password = requestData.getPassword();
        if (!isValidPassword(phone, userName, password)) {
            return new ResponseObject(HttpStatus.FOUND, "wrong password", null);
        }

        List<MerchantEmployee> merchantEmployees = merchantEmployeeRepository
                .getMerchantEmployeeByPhoneAndUserNameAndPassword(phone, userName, Hash.getHash(password));
        if (merchantEmployees.size() < 1) {
            return new ResponseObject(HttpStatus.FOUND, "this user is not created before", null);
        }
        MerchantEmployee merchantEmployee = merchantEmployees.get(0);

        Permission permission = permissionRepository.getPermissionById(
                merchantEmployee.getPermission().getId()
        ).get(0);

        MerchantEmployeePermissions responsePermissions = new MerchantEmployeePermissions();
        responsePermissions.setAllowAdd(permission.getAllowAdd() == 1);
        responsePermissions.setAllowEdit(permission.getAllowEdit() == 1);
        responsePermissions.setAllowDelete(permission.getAllowDelete() == 1);
        responsePermissions.setAllowExport(permission.getAllowExport() == 1);

        MerchantEmployeeResponseLoginData responseData = new MerchantEmployeeResponseLoginData();
        responseData.setUserId(merchantEmployee.getId());
        responseData.setPhone(merchantEmployee.getPhone());
        responseData.setUserName(merchantEmployee.getUserName());
        responseData.setPermissions(responsePermissions);
        return new ResponseObject(HttpStatus.OK, "Success", responseData);
    }

    boolean isValidPhoneLoginData(String phone) {
        for (int i = 0; i < phone.length(); ++i)
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9')
                return false;
        return true;
    }

    boolean isValidUserName(String userName) {
        for (int i = 0; i < userName.length(); ++i)
            if (userName.charAt(i) == ' ') return false;
        return true;
    }
    
    boolean isValidPassword(String phone, String userName, String password) {
        List<String> passwordList =  merchantEmployeeRepository.password(phone, userName);
        if (passwordList.size() != 1) return false;
        return passwordList.get(0).equals(Hash.getHash(password));
    }
}
