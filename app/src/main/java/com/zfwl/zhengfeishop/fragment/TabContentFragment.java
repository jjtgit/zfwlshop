package com.zfwl.zhengfeishop.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.BookingAdapter;



/**
 * Created by 修梦 on 2020/5/14.
 * Describe:拼团秒杀fragment
 */
public class TabContentFragment extends BaseFragment{

    private RecyclerView rvBooking;
    private String title;
    private BookingAdapter bookingAdapter;


    //回调用来接收参数
    public static TabContentFragment getiniturl(String title) {
        TabContentFragment tabContentFragment = new TabContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        tabContentFragment.setArguments(bundle);
        return tabContentFragment;
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_tab;

    }

    @Override
    protected void initView(View view) {
        rvBooking=view.findViewById(R.id.rv_booking);
        bookingAdapter = new BookingAdapter(getActivity());
        title = getArguments().getString("title");
        rvBooking.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvBooking.setAdapter(bookingAdapter);

    }

    @Override
    protected void initData() {

    }

}
