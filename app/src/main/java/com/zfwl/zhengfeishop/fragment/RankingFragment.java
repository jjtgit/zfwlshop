package com.zfwl.zhengfeishop.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.RankingAdapter;

/**
 * Created by 修梦 on 2020/5/15.
 * Describe:排行榜fragment
 */
public class RankingFragment extends BaseFragment{

    private RecyclerView rvRanking;
    private RankingAdapter rankingAdapter;

    //回调用来接收参数
    public static RankingFragment getiniturl(String title) {
        RankingFragment rankingFragment = new RankingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ranking", title);
        rankingFragment.setArguments(bundle);
        return rankingFragment;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_ranking;
    }

    @Override
    protected void initView(View view) {
        rvRanking=view.findViewById(R.id.rv_ranking);
        String ranking = getArguments().getString("ranking");
        rankingAdapter = new RankingAdapter(getActivity());
        rvRanking.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRanking.setAdapter(rankingAdapter);
    }

    @Override
    protected void initData() {

    }
}
