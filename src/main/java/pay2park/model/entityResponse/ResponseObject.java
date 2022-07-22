package pay2park.model.entityResponse;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class ResponseObject {
    private HttpStatus status;
    private String message;
    private Object data;
    public ResponseObject() {}

    public ResponseObject(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Objects data) {
        this.data = data;
    }
}

