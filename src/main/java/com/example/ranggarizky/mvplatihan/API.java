package com.example.ranggarizky.mvplatihan;


import com.example.ranggarizky.mvplatihan.model.ResponseApi;
import com.example.ranggarizky.mvplatihan.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ranggarizky on 6/4/2016.
 */
public interface API {
    //variable base URL
    public static String baseURL = "http://namineyouth.id/salesparameter/api/";
    //public static String baseURL = "http://192.168.43.92/nami/android/api/";
    //public static String baseURL = "http://10.65.2.16/nami/android/api/";

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();
    Retrofit client = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @FormUrlEncoded
    @POST("login.php")
    public Call<ResponseApi> login(@Field("user_id") String uid,@Field("password")String pass);

}

