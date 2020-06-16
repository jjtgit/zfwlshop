package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.PaymentOformAdapter;

/**
 * Created by 修梦 on 2020/5/28.
 * Describe:待付款订单
 */
public class PaymentOformFragment extends BaseFragment{

    private RecyclerView rvOrderform;
    private PaymentOformAdapter paymentOformAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.order_form_fragment;
    }

    @Override
    protected void initView(View view) {
        rvOrderform=view.findViewById(R.id.rv_orderform);
        paymentOformAdapter = new PaymentOformAdapter(getActivity());
        rvOrderform.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrderform.setAdapter(paymentOformAdapter);
    }

    @Override
    protected void initData() {

    }
}
