package com.ouyachou.app.ws.responses;

import java.util.Date;

public class ErrorMessage {

    private Date timestap;
    private String message;

    public Date getTimestap() {
        return timestap;
    }

    public void setTimestap(Date timestap) {
        this.timestap = timestap;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(Date timestap, String message) {
        this.timestap = timestap;
        this.message = message;
    }
}
