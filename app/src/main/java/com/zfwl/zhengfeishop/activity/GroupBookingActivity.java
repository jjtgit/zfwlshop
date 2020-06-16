package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.fragment.TabContentFragment;

import java.util.ArrayList;
import java.util.List;

//拼团秒杀
public class GroupBookingActivity extends BaseActivity {

    private TabLayout tabBooking;
    private ViewPager pageBooking;
    private ImageView returnBooking;
    private String[] title = {
            "头条",
            "新闻新闻",
            "娱乐新闻",
            "体育新闻",
            "科技新闻",
            "美女新闻",
            "财经新闻",
            "汽车新闻",
            "房子新闻",
            "头条新闻"
    };
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_booking);
        //获取id
        tabBooking=findViewById(R.id.tab_booking);
        pageBooking=findViewById(R.id.page_booking);
        returnBooking=findViewById(R.id.return_booking);
        init();
    }

    private void init() {
        tabBooking.setupWithViewPager(pageBooking);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pageBooking.setAdapter(adapter);
        tabBooking.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabBooking.setTabGravity(TabLayout.GRAVITY_FILL);
        tabBooking.setTabMode(TabLayout.MODE_SCROLLABLE);

        //返回
        returnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new TabContentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }

}
