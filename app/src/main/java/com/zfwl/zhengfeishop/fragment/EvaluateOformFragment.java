package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.EvaluateOformAdapter;

/**
 * Created by 修梦 on 2020/5/28.
 * Describe:待评价订单
 */
public class EvaluateOformFragment extends BaseFragment{

    private RecyclerView rvOrderform;
    private EvaluateOformAdapter evaluateOformAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.order_form_fragment;
    }

    @Override
    protected void initView(View view) {
        rvOrderform=view.findViewById(R.id.rv_orderform);
        evaluateOformAdapter = new EvaluateOformAdapter(getActivity());
        rvOrderform.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrderform.setAdapter(evaluateOformAdapter);
    }

    @Override
    protected void initData() {

    }
}
