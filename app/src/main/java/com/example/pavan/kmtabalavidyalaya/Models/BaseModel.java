package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by kai on 21/4/16.
 */
public class BaseModel {
    private String status;
    private String message;
    private String code;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}