package com.zfwl.zhengfeishop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by 修梦 on 2020/4/16.
 * Describe:总体的fragment控制
 */
public abstract class BaseFragment extends Fragment {

    //定义懒加载判断
    private boolean isFirst=true;
    private boolean isPrepare;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutView(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepare=true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        restStart();
    }

    private void restStart() {
        isFirst=true;
        isPrepare=false;
    }

    protected abstract int getLayoutView();
    protected abstract void initView(View view);
    protected abstract void initData();
}
