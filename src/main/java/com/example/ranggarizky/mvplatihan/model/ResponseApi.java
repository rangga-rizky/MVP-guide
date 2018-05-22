package com.example.ranggarizky.mvplatihan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ranggarizky on 1/19/2017.
 */
public class ResponseApi {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("error")
    @Expose
    private String error;


    @SerializedName("checkin_id")
    @Expose
    private String checkin_id;


    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void setCheckin_id(String checkin_id) {
        this.checkin_id = checkin_id;
    }

    public String getCheckin_id() {
        return checkin_id;
    }
}
