package com.igor.tsearch.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;

    private ApiService ApiService;


    public RetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                //.addInterceptor(new BasicAuthInterceptor("rocket", "rocket"))
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        retrofit = new Retrofit.Builder().baseUrl(ApiProperties.HOST + ApiProperties.API_VERSION)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)

                .build();

        ApiService = retrofit.create(ApiService.class);
    }
    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }

        return instance;
    }
    public ApiService getApiService() {
        return ApiService;
    }


}
