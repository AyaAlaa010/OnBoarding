package com.example.onboarding.ApllicationPojo.LoginPojo;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("user_id")
    private int user_id;

    @SerializedName("registered_email")
    private String registered_email;

    @SerializedName("error")
    private String error;

    public String getError() {
        return error;
    }

    public LoginResponse(int user_id, String registered_email, String error) {
        this.user_id = user_id;
        this.registered_email = registered_email;
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRegistered_email() {
        return registered_email;
    }

    public void setRegistered_email(String registered_email) {
        this.registered_email = registered_email;
    }



}
