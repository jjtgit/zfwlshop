package com.zfwl.zhengfeishop.utils;


import com.zfwl.zhengfeishop.api.BaseApi;
import com.zfwl.zhengfeishop.net.OKHttpCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:okHttp网络工具类
 */
public class OKHTTPUtils {

    private  OkHttpClient okHttpClient;
    private static OKHTTPUtils mInstance;
    private final RetrofitUtils retrofitUtils;

    public OKHTTPUtils(){
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
               .cookieJar(new CookieJar() {
                   private final HashMap<String,List<Cookie>> cookieStore=new HashMap<>();;
                   @Override
                   public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(),cookies);
                   }

                   @Override
                   public List<Cookie> loadForRequest(HttpUrl url) {
                       List<Cookie> cookies = cookieStore.get(url.host());
                       return cookies!=null?cookies:new ArrayList<Cookie>();
                   }
               })
                .addInterceptor(loggingInterceptor)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BaseApi.BASE_API)
                .build();
        retrofitUtils=retrofit.create(RetrofitUtils.class);
    }
    //get请求
    public void doGet(String apiUrl, HashMap<String,Object> params, final OKHttpCallBack callBack){
        retrofitUtils.doGet(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result = responseBody.string();
                        if(callBack!=null){
                            callBack.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBack!=null){
                            String message = throwable.getMessage();
                            callBack.onFailUre(message);
                        }
                    }
                });
        }
        //twoget请求
        public void dpTwoGet(String apiUrl,HashMap<String,Object> params,final OKHttpCallBack callBack){
        retrofitUtils.doTwoGet(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result=responseBody.string();
                        if (callBack!=null){
                            callBack.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBack!=null){
                            String message = throwable.getMessage();
                            callBack.onFailUre(message);
                        }
                    }
                });
        }
    //threeget请求
    public void doThreeGet(String apiUrl,HashMap<String,Object> params,final OKHttpCallBack callBack){
        retrofitUtils.doThreeGet(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result=responseBody.string();
                        if (callBack!=null){
                            callBack.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBack!=null){
                            String message = throwable.getMessage();
                            callBack.onFailUre(message);
                        }
                    }
                });
    }
        //post请求
        public void doPost(String apiUrl,HashMap<String,Object> params,final OKHttpCallBack callBack){
        retrofitUtils.doPost(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result=responseBody.string();
                        if (callBack!=null){
                            callBack.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBack!=null){
                            String message = throwable.getMessage();
                            callBack.onFailUre(message);
                        }
                    }
                });
        }
    //twopost请求
    public void doTwoPost(String apiUrl,HashMap<String,Object> params,final OKHttpCallBack callBack){
        retrofitUtils.doTwoGet(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result=responseBody.string();
                        if (callBack!=null){
                            callBack.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBack!=null){
                            String message = throwable.getMessage();
                            callBack.onFailUre(message);
                        }
                    }
                });
    }
    //上传图片
    public void doPostPic(String apiUrl, MultipartBody.Part multipartBody,final OKHttpCallBack callBack){
        Observable<ResponseBody> observable = retrofitUtils.doPostPic(apiUrl, multipartBody);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result = responseBody.string().toString();
                        if (callBack!=null){
                            callBack.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callBack!=null){
                            String message = throwable.getMessage();
                            callBack.onFailUre(message);
                        }
                    }
                });
    }
    //单例
    public static OKHTTPUtils getInstance(){
        if (mInstance==null){
            synchronized (OKHTTPUtils.class){
                if (mInstance==null){
                    mInstance=new OKHTTPUtils();
                }
            }
        }
        return mInstance;
    }
    //关闭OkHTTP
    public void OkHttpCancel(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
