package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.ReceivingOformAdapter;

/**
 * Created by 修梦 on 2020/5/28.
 * Describe:待收货订单
 */
public class ReceivingOformFragment extends BaseFragment{

    private RecyclerView rvOrderform;
    private ReceivingOformAdapter receivingOformAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.order_form_fragment;
    }

    @Override
    protected void initView(View view) {
        rvOrderform=view.findViewById(R.id.rv_orderform);
        receivingOformAdapter = new ReceivingOformAdapter(getActivity());
        rvOrderform.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrderform.setAdapter(receivingOformAdapter);
    }

    @Override
    protected void initData() {

    }
}
