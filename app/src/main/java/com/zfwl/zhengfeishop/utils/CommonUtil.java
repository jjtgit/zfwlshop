package com.zfwl.zhengfeishop.utils;

import android.content.Context;

/**
 * Created by 修梦 on 2020/4/17.
 * Describe:吸顶效果工具类
 */
public class CommonUtil {
    public static int dp2px(Context context, float dpValue) {
        if (null == context) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

//...

    public static int getScreenWidth(Context context) {
        if (null == context) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
