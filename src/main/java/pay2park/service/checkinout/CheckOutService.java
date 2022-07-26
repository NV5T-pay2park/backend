package pay2park.service.checkinout;

import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;
import pay2park.model.checkinout.PreCheckOutData;

import java.io.IOException;

public interface CheckOutService {
    ResponseObject preCheckOut(PreCheckOutData preCheckOutData) throws IOException;
    ResponseObject checkOut(CheckOutData checkOutData) throws IOException;
}
