package com.zfwl.zhengfeishop.utils;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:Retrofit工具类
 */
public interface RetrofitUtils {
    @GET
    Observable<ResponseBody> doGet(@Url String url, @QueryMap HashMap<String,Object> params);

    @GET
    Observable<ResponseBody> doTwoGet(@Url String url,@QueryMap HashMap<String,Object> params);

    @GET
    Observable<ResponseBody> doThreeGet(@Url String url,@QueryMap HashMap<String,Object> params);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> doPost(@Url String url,@QueryMap HashMap<String,Object> params);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> doTwoPost(@Url String url,@QueryMap HashMap<String,Object> params);

    //上传图片
    @POST
    @Multipart
    Observable<ResponseBody> doPostPic(@Url String url, @Part MultipartBody.Part multipartBody);

}
