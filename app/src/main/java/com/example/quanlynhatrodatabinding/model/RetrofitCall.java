package com.example.quanlynhatrodatabinding.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitCall {

    @FormUrlEncoded
    @POST("checkLogin")
    Call<UserResponse> checkLogin(@Field("account") String account, @Field("password") String password);

    @FormUrlEncoded
    @POST("createUser")
    Call<UserResponse> createUser(@Field("account") String account, @Field("password") String password);

    @FormUrlEncoded
    @GET("getAllRenters")
    Call<Renter> getAllRenters();
}
