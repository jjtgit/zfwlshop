package com.zfwl.zhengfeishop.net;

/**
 * Created by 修梦 on 2020/4/9.
 * Describe:请求的成功与失败的方法
 */
public interface RequestCallBack {
    void onSuccess(String result);
    void onFailUre(String msg);
}
