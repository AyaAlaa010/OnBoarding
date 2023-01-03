package com.example.onboarding.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private RetrofitClient(){}
    private static Retrofit retrofit;
    public static NetworkIMP getApi() {
        if (retrofit == null) {
            retrofit=new Retrofit.Builder().baseUrl("https://api.time2travel.biz/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()  )
                    .build();

        }
        return retrofit.create(NetworkIMP.class);
    }



}