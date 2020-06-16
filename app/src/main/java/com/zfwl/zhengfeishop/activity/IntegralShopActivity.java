package com.zfwl.zhengfeishop.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.fragment.IntegralFragment;

public class IntegralShopActivity extends Base2Activity {

    public ImageView returnIntegral;
    public TabLayout tabIntegral;
    public ViewPager pageIntegral;
    public String[] title = {
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
        setContentView(R.layout.activity_integral_shop);
        returnIntegral=findViewById(R.id.return_integral);
        tabIntegral=findViewById(R.id.tab_integral);
        pageIntegral=findViewById(R.id.page_integral);
        init();
    }

    private void init() {
        tabIntegral.setupWithViewPager(pageIntegral);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pageIntegral.setAdapter(adapter);
        tabIntegral.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabIntegral.setTabGravity(TabLayout.GRAVITY_FILL);
        tabIntegral.setTabMode(TabLayout.MODE_SCROLLABLE);
        //返回
        returnIntegral.setOnClickListener(new View.OnClickListener() {
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
            Fragment f = new IntegralFragment();
            Bundle bundle = new Bundle();
            bundle.putString("integral", title[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }
}
