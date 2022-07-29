package pay2park.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.exception.ResourceNotFoundException;
import pay2park.model.entityFromDB.PaymentUrl;
import pay2park.model.payment.QueryUrlData;
import pay2park.repository.PaymentUrlRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Service
public class QueryPaymentUrlServiceImpl implements QueryPaymentUrlService {
    @Autowired
    private PaymentUrlRepository paymentUrlRepository;

    @Override
    public PaymentUrl queryPaymentUrl(int endUserId, int ticketId) {
        String appTransId = getCurrentTimeString("yyMMdd") + "_" + endUserId + ticketId;
        PaymentUrl paymentUrl = paymentUrlRepository.findById(appTransId).orElseThrow(() -> new ResourceNotFoundException("Payment url not exist with app_tran_id: " + appTransId));
        return paymentUrl;
    }

    public static String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }
}
