package pay2park.service.serviceInterface;

import org.json.JSONObject;
import pay2park.model.entityRequest.QuickPayData;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;

public interface QuickPayService {
    JSONObject quickPay(QuickPayData quickPayData) throws IOException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidKeyException;
}