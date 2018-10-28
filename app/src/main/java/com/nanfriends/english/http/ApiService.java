package com.nanfriends.english.http;

import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.SProblem;

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

    String BASE_URL="http://192.168.114.100:8080/test/";

    @FormUrlEncoded
    @POST("log.do")
    Call<ResponseBody> login(@Field("username") String username,@Field("pwd") String password,@Field("vcode") String code);

    @GET("getCode.do")
    Call<ResponseBody> getCode();

    @FormUrlEncoded
    @POST("registe.do")
    Call<ResponseBody> register(@FieldMap Map<String,String> param);

    /**
     * 根据不同类型获取不同题型列表
     * @param id 类型
     * @return 响应数据
     */
    @GET("list.do?action=kulist&tid={id}")
    Call<Question> getReaderOrListen(@Path("id") int id);

    /**
     * 获取问题和选项
     * @param id 阅读或听力id
     * @return 响应数据
     */
    @GET("list.do?action=xiaoList&id={id}")
    Call<SProblem> getProblems(@Path("id") int id);

    /**
     * 获取阅读理解和翻译
     * @param tx 题型
     * @return 响应数据
     */
    @GET("list.do?action=twList&tx={tx}")
    Call<SProblem> getWrite(@Path("tx") int tx);

    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url);
}
