package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.EndUseAdapter;


/**
 * Created by 修梦 on 2020/6/1.
 * Describe:已使用的优惠卷
 */
public class EndUseFragment extends BaseFragment{

    private RecyclerView rvCoupons;
    private EndUseAdapter endUseAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.coupons_fragment;
    }

    @Override
    protected void initView(View view) {
        rvCoupons=view.findViewById(R.id.rv_coupons);
        endUseAdapter = new EndUseAdapter(getActivity());
        rvCoupons.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCoupons.setAdapter(endUseAdapter);
    }

    @Override
    protected void initData() {

    }
}
