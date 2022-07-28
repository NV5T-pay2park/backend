package pay2park.service.payment;

import pay2park.model.entityFromDB.PaymentUrl;
import pay2park.model.payment.QueryUrlData;

import java.io.IOException;
import java.net.URISyntaxException;

public interface QueryPaymentUrlService {
    PaymentUrl queryPaymentUrl(int endUserId, int ticketId) throws IOException, URISyntaxException;
}
