package com.zfwl.zhengfeishop.contract;

import com.zfwl.zhengfeishop.net.RequestCallBack;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:抽取网络接口类
 */
public interface BaseContract {
    abstract class BasePresenter{
        public abstract void showGet(String apiUrl, HashMap<String,Object> params);
        public abstract void showTwoGet(String apiUrl, HashMap<String,Object> params);
        public abstract void showThreeGet(String apiUrl, HashMap<String,Object> params);
        public abstract void showPost(String apiUrl, HashMap<String,Object> params);
        public abstract void showTwoPost(String apiUrl, HashMap<String,Object> params);
        public abstract void showPostPic(String apiUrl, MultipartBody.Part multipartBody);
    }
    interface IBaseModel{
        void doGet(String apiUrl, HashMap<String,Object> params, RequestCallBack requestCallBack);
        void doTwoGet(String apiUrl, HashMap<String,Object> params, RequestCallBack requestCallBack);
        void doThreeGet(String apiUrl, HashMap<String,Object> params, RequestCallBack requestCallBack);
        void doPost(String apiUrl, HashMap<String,Object> params, RequestCallBack requestCallBack);
        void doTwoPost(String apiUrl, HashMap<String,Object> params, RequestCallBack requestCallBack);
        void doPostPic(String apiUrl, MultipartBody.Part multipartBody, RequestCallBack requestCallBack);
    }
    interface IBaseView{
        void onFailUre(String msg);
        void onSuccessGet(String result);
        void onSuccessTwoGet(String result);
        void onSuccessThreeGet(String result);
        void onSuccessPost(String result);
        void onSuccessTwoPost(String result);
        void onSuccessPostPic(String result);
    }
}
