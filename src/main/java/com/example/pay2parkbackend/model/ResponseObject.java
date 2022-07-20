package com.example.pay2parkbackend.model;

import java.util.Objects;

public class ResponseObject {
    private String status;
    private String message;
    private Object data;
    public ResponseObject() {}

    public ResponseObject(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
