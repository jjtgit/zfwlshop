package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.ClassifyShopAdapter;

/**
 * Created by 修梦 on 2020/5/24.
 * Describe:分类的价格fragment
 */
public class ClassifyPriceFragment extends BaseFragment{

    private RecyclerView fragmentClassify;
    private ClassifyShopAdapter classifyShopAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_classify_synthesize;
    }

    @Override
    protected void initView(View view) {
        fragmentClassify=view.findViewById(R.id.fragment_classify);
        fragmentClassify.setLayoutManager(new GridLayoutManager(getActivity(),2));
        classifyShopAdapter = new ClassifyShopAdapter(getActivity());
        fragmentClassify.setAdapter(classifyShopAdapter);
    }

    @Override
    protected void initData() {

    }
}
