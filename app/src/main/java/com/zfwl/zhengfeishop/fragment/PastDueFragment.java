package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.PastDueAdapter;

/**
 * Created by 修梦 on 2020/6/1.
 * Describe:已过期的优惠卷
 */
public class PastDueFragment extends BaseFragment{

    private RecyclerView rvCoupons;
    private PastDueAdapter pastDueAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.coupons_fragment;
    }

    @Override
    protected void initView(View view) {
        rvCoupons=view.findViewById(R.id.rv_coupons);
        rvCoupons.setLayoutManager(new LinearLayoutManager(getActivity()));
        pastDueAdapter = new PastDueAdapter(getActivity());
        rvCoupons.setAdapter(pastDueAdapter);
    }

    @Override
    protected void initData() {

    }
}
