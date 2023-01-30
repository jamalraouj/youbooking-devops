package com.youbooking.youbooking.controller.vm;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public class ResponseVm implements Serializable {

    private HttpStatus httpStatus;
    private String message;
    private List<Object> Data;

    public ResponseVm() {
    }

    public ResponseVm(HttpStatus httpStatus, String message, List<Object> data) {
        this.httpStatus = httpStatus;
        this.message = message;
        Data = data;
    }

    public ResponseVm(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List<Object> data) {
        Data = data;
    }

    public List<Object> getData() {
        return Data;
    }
}
