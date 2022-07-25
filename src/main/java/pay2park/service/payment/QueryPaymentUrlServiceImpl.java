package pay2park.service.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.exception.ResourceNotFoundException;
import pay2park.model.entityFromDB.PaymentUrl;
import pay2park.repository.PaymentUrlRepository;

@Service
public class QueryPaymentUrlServiceImpl implements  QueryPaymentUrlService{
    @Autowired
    private PaymentUrlRepository paymentUrlRepository;

    @Override
    public PaymentUrl queryPaymentUrl(String appTransId){
        PaymentUrl paymentUrl =  paymentUrlRepository.findById(appTransId).orElseThrow(() -> new ResourceNotFoundException("Payment url not exist with app_tran_id: "+appTransId));
        return paymentUrl;
    }

}
