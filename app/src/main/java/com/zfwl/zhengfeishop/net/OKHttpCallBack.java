package com.zfwl.zhengfeishop.net;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:http网络请求框架判断成功与失败的方法
 */
public interface OKHttpCallBack {
    void onSuccess(String result);
    void onFailUre(String msg);
}
