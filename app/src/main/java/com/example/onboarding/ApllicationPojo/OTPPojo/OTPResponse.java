package com.example.onboarding.ApllicationPojo.OTPPojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OTPResponse {
    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("token")
    @Expose
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public OTPResponse(User user, String token) {
        this.user = user;
        this.token = token;
    }
}
