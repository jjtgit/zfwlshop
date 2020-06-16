package com.zfwl.zhengfeishop.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.TimeLimitItemAdapter;

/**
 * Created by 修梦 on 2020/5/15.
 * Describe:限时抢购fragment
 */
public class TimeLimitFragment extends BaseFragment{

    private RecyclerView rvTimelimit;
    private LinearLayout changeTheLayout;
    private ImageView imgTimelimit1,imgTimelimit2,imgTimelimit3;
    private TextView priceTimelimit1,priceTimelimit2,priceTimelimit3;
    private TimeLimitItemAdapter timeLimitItemAdapter;

    //回调用来接收参数
    public static TimeLimitFragment getiniturl(String title) {
        TimeLimitFragment rankingFragment = new TimeLimitFragment();
        Bundle bundle = new Bundle();
        bundle.putString("timelimit", title);
        rankingFragment.setArguments(bundle);
        return rankingFragment;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_time_limit;
    }
    @Override
    protected void initView(View view) {
        rvTimelimit=view.findViewById(R.id.rv_timelimit);
        changeTheLayout=view.findViewById(R.id.change_the_layout);
        imgTimelimit1=view.findViewById(R.id.img_timelimit1);
        imgTimelimit2=view.findViewById(R.id.img_timelimit2);
        imgTimelimit3=view.findViewById(R.id.img_timelimit3);
        priceTimelimit1=view.findViewById(R.id.price_timelimit1);
        priceTimelimit2=view.findViewById(R.id.price_timelimit2);
        priceTimelimit3=view.findViewById(R.id.price_timelimit3);
        String ranking = getArguments().getString("timelimit");
        timeLimitItemAdapter = new TimeLimitItemAdapter(getActivity());
        rvTimelimit.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTimelimit.setAdapter(timeLimitItemAdapter);
    }

    @Override
    protected void initData() {

    }
}
