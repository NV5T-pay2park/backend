package pay2park.service.serviceInterface;

import pay2park.model.entityRequest.CheckOutData;
import pay2park.model.entityResponse.ResponseObject;

import java.util.Map;

public interface CheckOutService {
    ResponseObject checkOut(CheckOutData checkOutData);
}
