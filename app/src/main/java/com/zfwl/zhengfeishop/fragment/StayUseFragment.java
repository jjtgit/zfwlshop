package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.StayUseAdapter;

/**
 * Created by 修梦 on 2020/6/1.
 * Describe:未使用的优惠卷
 */
public class StayUseFragment extends BaseFragment{

    private RecyclerView rvCoupons;
    private StayUseAdapter stayUseAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.coupons_fragment;
    }

    @Override
    protected void initView(View view) {
        rvCoupons=view.findViewById(R.id.rv_coupons);
        stayUseAdapter = new StayUseAdapter(getActivity());
        rvCoupons.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCoupons.setAdapter(stayUseAdapter);
    }

    @Override
    protected void initData() {

    }
}
