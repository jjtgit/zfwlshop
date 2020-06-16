package com.zfwl.zhengfeishop.model;

import android.util.Log;

import com.zfwl.zhengfeishop.contract.BaseContract;
import com.zfwl.zhengfeishop.net.OKHttpCallBack;
import com.zfwl.zhengfeishop.net.RequestCallBack;
import com.zfwl.zhengfeishop.utils.OKHTTPUtils;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:封装Model类
 */
public class BaseModel implements BaseContract.IBaseModel {

    @Override
    public void doGet(String apiUrl, HashMap<String, Object> params, final RequestCallBack requestCallBack) {
        OKHTTPUtils.getInstance().doGet(apiUrl, params, new OKHttpCallBack() {
            @Override
            public void onSuccess(String result) {
                if (requestCallBack!=null){
                    requestCallBack.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (requestCallBack!=null){
                    requestCallBack.onFailUre("网络异常，请稍后再试");
                    Log.e("get",msg);
                }
            }
        });
    }

    @Override
    public void doTwoGet(String apiUrl, HashMap<String, Object> params, final RequestCallBack requestCallBack) {
        OKHTTPUtils.getInstance().dpTwoGet(apiUrl, params, new OKHttpCallBack() {
            @Override
            public void onSuccess(String result) {
                if (requestCallBack!=null){
                    requestCallBack.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (requestCallBack!=null){
                    requestCallBack.onFailUre("网络异常，请稍后再试");
                    Log.e("twoget",msg);
                }
            }
        });
    }

    @Override
    public void doThreeGet(String apiUrl, HashMap<String, Object> params, final RequestCallBack requestCallBack) {
        OKHTTPUtils.getInstance().doThreeGet(apiUrl, params, new OKHttpCallBack() {
            @Override
            public void onSuccess(String result) {
                if (requestCallBack!=null){
                    requestCallBack.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (requestCallBack!=null){
                    requestCallBack.onFailUre("网络异常，请稍后再试");
                    Log.e("threeget",msg);
                }
            }
        });
    }

    @Override
    public void doPost(String apiUrl, HashMap<String, Object> params, final RequestCallBack requestCallBack) {
        OKHTTPUtils.getInstance().doPost(apiUrl, params, new OKHttpCallBack() {
            @Override
            public void onSuccess(String result) {
                if (requestCallBack!=null){
                    requestCallBack.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (requestCallBack!=null){
                    requestCallBack.onFailUre("网络异常，请稍后再试");
                    Log.e("post",msg);
                }
            }
        });
    }

    @Override
    public void doTwoPost(String apiUrl, HashMap<String, Object> params, final RequestCallBack requestCallBack) {
        OKHTTPUtils.getInstance().doTwoPost(apiUrl, params, new OKHttpCallBack() {
            @Override
            public void onSuccess(String result) {
                if (requestCallBack!=null){
                    requestCallBack.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (requestCallBack!=null){
                    requestCallBack.onFailUre("网络异常，请稍后再试");
                    Log.e("twopost",msg);
                }
            }
        });
    }

    @Override
    public void doPostPic(String apiUrl, MultipartBody.Part multipartBody, final RequestCallBack requestCallBack) {
        OKHTTPUtils.getInstance().doPostPic(apiUrl, multipartBody, new OKHttpCallBack() {
            @Override
            public void onSuccess(String result) {
                if (requestCallBack!=null){
                    requestCallBack.onSuccess(result);
                }
            }

            @Override
            public void onFailUre(String msg) {
                if (requestCallBack!=null){
                    requestCallBack.onFailUre("网络异常，请稍后再试");
                    Log.e("postpic",msg);
                }
            }
        });
    }
}
