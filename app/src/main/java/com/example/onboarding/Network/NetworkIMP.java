package com.example.onboarding.Network;

import com.example.onboarding.ApllicationPojo.LoginPojo.LoginRequest;
import com.example.onboarding.ApllicationPojo.LoginPojo.LoginResponse;
import com.example.onboarding.ApllicationPojo.OTPPojo.OTPRequest;
import com.example.onboarding.ApllicationPojo.OTPPojo.OTPResponse;
import com.example.onboarding.ApllicationPojo.RegisterPojo.RegisterRequest;
import com.example.onboarding.ApllicationPojo.RegisterPojo.RegisterResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Single;

public interface NetworkIMP {


    @POST("api/register")
    Single<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("api/login")
    Single<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("api/loginOtp")
    Single<OTPResponse> sendOTP(@Body OTPRequest otpRequest);

}
