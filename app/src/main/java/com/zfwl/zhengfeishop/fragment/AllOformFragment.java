package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.AllOformAdapter;

/**
 * Created by 修梦 on 2020/5/28.
 * Describe:全部订单
 */
public class AllOformFragment extends BaseFragment{

    private RecyclerView rvOrderform;
    private AllOformAdapter allOformAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.order_form_fragment;
    }

    @Override
    protected void initView(View view) {
        rvOrderform=view.findViewById(R.id.rv_orderform);
        allOformAdapter = new AllOformAdapter(getActivity());
        rvOrderform.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvOrderform.setAdapter(allOformAdapter);
    }

    @Override
    protected void initData() {

    }
}
