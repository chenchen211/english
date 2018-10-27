package com.nanfriends.english.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    String BASE_URL="http://192.168.114.101:8080/test/";

    @FormUrlEncoded
    @POST("log.do")
    Call<ResponseBody> login(String username,String password,String code);

    @GET("getCode.do")
    Call<ResponseBody> getCode();

    @FormUrlEncoded
    @POST("register.do")
    Call<ResponseBody> register(@FieldMap Map<String,String> param);
}
