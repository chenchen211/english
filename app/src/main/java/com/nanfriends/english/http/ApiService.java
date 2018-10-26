package com.nanfriends.english.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    public static final String BASE_URL="http://127.0.0.1/";

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(String username,String password,String code);

    @GET("verify")
    Call<ResponseBody> getCode();

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(@FieldMap Map<String,String> param);
}
