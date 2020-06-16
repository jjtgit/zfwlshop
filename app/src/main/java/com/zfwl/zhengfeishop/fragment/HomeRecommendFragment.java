package com.zfwl.zhengfeishop.fragment;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.RecommendAdapter;

/**
 * Created by 修梦 on 2020/5/13.
 * Describe:推荐fragment
 */
public class HomeRecommendFragment extends BaseFragment{

    private RecyclerView recommendRv;
    private RecommendAdapter recommendAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.home_recommend_fragment;
    }

    @Override
    protected void initView(View view) {
        recommendRv=view.findViewById(R.id.recommend_rv);
        recommendAdapter = new RecommendAdapter(getActivity());
        recommendRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recommendRv.setAdapter(recommendAdapter);
    }

    @Override
    protected void initData() {

    }
}
