package com.example.ranggarizky.mvplatihan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by RanggaRizky on 4/2/2017.
 */
public class User {

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("password")
    @Expose
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_id() {
        return user_id;
    }
}
