package pay2park.service.payment;

import pay2park.model.entityFromDB.PaymentUrl;

import java.io.IOException;
import java.net.URISyntaxException;

public interface QueryPaymentUrlService {
    PaymentUrl queryPaymentUrl(String appTransId) throws IOException, URISyntaxException;
}
