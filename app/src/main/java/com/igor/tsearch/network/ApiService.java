package com.igor.tsearch.network;

import com.igor.tsearch.model.TwitterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    // TODO move to formurlencoded
    @FormUrlEncoded
    @POST("register")
    Call<TwitterResponse> register(@Field("phone") String phone);
