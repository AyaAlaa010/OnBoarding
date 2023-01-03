package com.example.onboarding.ApllicationPojo.OTPPojo;

import com.google.gson.annotations.SerializedName;

public class OTPRequest {
   @SerializedName ("app")
   private String app;

    @SerializedName ("user_id")
    private int user_id;

    @SerializedName ("otp")
    private int otp;

    public OTPRequest(String app, int user_id, int otp) {
        this.app = app;
        this.user_id = user_id;
        this.otp = otp;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
