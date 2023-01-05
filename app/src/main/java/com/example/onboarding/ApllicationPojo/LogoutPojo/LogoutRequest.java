package com.example.onboarding.ApllicationPojo.LogoutPojo;

import com.google.gson.annotations.SerializedName;

public class LogoutRequest {
    @SerializedName("app")
    String app;
    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public LogoutRequest(String app) {
        this.app = app;
    }
}
