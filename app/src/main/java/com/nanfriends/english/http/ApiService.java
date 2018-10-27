package com.nanfriends.english.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {

    String BASE_URL="http://192.168.114.101:8080/test/";

    @FormUrlEncoded
    @POST("log.do")
    Call<ResponseBody> login(@Field("username") String username,@Field("pwd") String password,@Field("vcode") String code);

    @GET("getCode.do")
    Call<ResponseBody> getCode();

    @FormUrlEncoded
    @POST("register.do")
    Call<ResponseBody> register(@FieldMap Map<String,String> param);

    /**
     * 根据不同类型获取不同题型列表
     * @param id 类型
     * @return 响应数据
     */
    @GET("txList.do")
    Call<ResponseBody> getReaderOrListen(@Path("id") int id);

    /**
     * 获取问题和选项
     * @param id 阅读或听力id
     * @return 响应数据
     */
    @GET("problem.do")
    Call<ResponseBody> getProblems(@Path("id") int id);

    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url);
}
