package com.zfwl.zhengfeishop.presenter;

import com.zfwl.zhengfeishop.contract.BaseContract;
import com.zfwl.zhengfeishop.model.BaseModel;
import com.zfwl.zhengfeishop.net.RequestCallBack;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:封装Presenter层
 */
public class BasePresenter extends BaseContract.BasePresenter {

    private BaseModel model;
    private BaseContract.IBaseView view;

    public BasePresenter( BaseContract.IBaseView view) {
        this.model = new BaseModel();
        this.view = view;
    }

    @Override
    public void showGet(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doGet(apiUrl, params, new RequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessGet(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showTwoGet(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doTwoGet(apiUrl, params, new RequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessTwoGet(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showThreeGet(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doThreeGet(apiUrl, params, new RequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessThreeGet(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showPost(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doPost(apiUrl, params, new RequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessPost(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showTwoPost(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doTwoPost(apiUrl, params, new RequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessTwoPost(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showPostPic(String apiUrl, MultipartBody.Part multipartBody) {
        if (model!=null){
            model.doPostPic(apiUrl, multipartBody, new RequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessPostPic(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }
}
