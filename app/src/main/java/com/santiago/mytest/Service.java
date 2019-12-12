package com.santiago.mytest;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Service {

    @Headers("Content-Type: application/json")
    @POST("auth")
    Call<Manager> login(@Body Manager.Request params);
}
