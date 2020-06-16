package com.zfwl.zhengfeishop.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.IntegralTabAdapter;
import com.zfwl.zhengfeishop.adapter.IntegralTimeAdapter;

/**
 * Created by 修梦 on 2020/5/15.
 * Describe:积分商城的fragment
 */
public class IntegralFragment extends BaseFragment{

    private RecyclerView rvIntegral,tabRvlayout;
    private IntegralTabAdapter integralTabAdapter;
    private LinearLayoutManager linearLayoutManager;
    private IntegralTimeAdapter integralTimeAdapter;

    //回调用来接收参数
    public static IntegralFragment getiniturl(String title) {
        IntegralFragment integralFragment = new IntegralFragment();
        Bundle bundle = new Bundle();
        bundle.putString("integral", title);
        integralFragment.setArguments(bundle);
        return integralFragment;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_integral;
    }

    @Override
    protected void initView(View view) {
        tabRvlayout=view.findViewById(R.id.tab_rvlayout);
        rvIntegral=view.findViewById(R.id.rv_integral);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        integralTabAdapter = new IntegralTabAdapter(getActivity());
        integralTimeAdapter = new IntegralTimeAdapter(getActivity());
        rvIntegral.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rvIntegral.setAdapter(integralTimeAdapter);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        tabRvlayout.setLayoutManager(linearLayoutManager);
        tabRvlayout.setAdapter(integralTabAdapter);
        integralTabAdapter.setGetListener(new IntegralTabAdapter.GetListener() {
            @Override
            public void onClick(int position) {
                integralTabAdapter.setmPosition(position);
                integralTabAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
