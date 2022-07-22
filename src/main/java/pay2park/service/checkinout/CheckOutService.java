package pay2park.service.checkinout;

import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;

public interface CheckOutService {
    ResponseObject checkOut(CheckOutData checkOutData);
}
