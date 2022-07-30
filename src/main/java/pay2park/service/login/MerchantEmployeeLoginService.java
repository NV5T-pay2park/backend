package pay2park.service.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.Merchant;
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
        String password = requestData.getPassword();
        if (!isValidPassword(phone, password)) {
            return new ResponseObject(HttpStatus.FOUND, "invalid username ", null);
        }

        MerchantEmployee merchantEmployee = merchantEmployeeRepository
                .getMerchantEmployeeByPhoneAndPassword(phone, Hash.getHash(password)).get(0);

        Permission permission = permissionRepository.getPermissionById(
                merchantEmployee.getPermission().getId()
        ).get(0);

        MerchantEmployeePermissions responsePermissions = new MerchantEmployeePermissions();
        responsePermissions.setAllowAdd(permission.getAllowAdd() == 1);
        responsePermissions.setAllowEdit(permission.getAllowEdit() == 1);
        responsePermissions.setAllowDelete(permission.getAllowDelete() == 1);
        responsePermissions.setAllowExport(permission.getAllowExport() == 1);

        MerchantEmployeeResponseLoginData responseData = new MerchantEmployeeResponseLoginData();
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
    
    boolean isValidPassword(String phone, String password) {
        List<String> passwordList =  merchantEmployeeRepository.password(phone);
        if (passwordList.size() != 1) return false;
        return passwordList.get(0).equals(Hash.getHash(password));
    }
}
