package pay2park.service.checkinout;

import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;

import java.io.IOException;

public interface CheckOutService {
    ResponseObject checkOut(CheckOutData checkOutData) throws IOException;
}
