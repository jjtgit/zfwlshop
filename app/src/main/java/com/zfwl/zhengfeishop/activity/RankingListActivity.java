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
import com.zfwl.zhengfeishop.fragment.RankingFragment;

public class RankingListActivity extends BaseActivity {

    private TabLayout tabRanking;
    private ViewPager pageRanking;
    private ImageView returnRanking;
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
        setContentView(R.layout.activity_ranking_list);
        tabRanking=findViewById(R.id.tab_ranking);
        pageRanking=findViewById(R.id.page_ranking);
        returnRanking=findViewById(R.id.return_ranking);
        init();
    }

    private void init() {
        tabRanking.setupWithViewPager(pageRanking);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pageRanking.setAdapter(adapter);
        tabRanking.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabRanking.setTabGravity(TabLayout.GRAVITY_FILL);
        tabRanking.setTabMode(TabLayout.MODE_SCROLLABLE);

        //返回
        returnRanking.setOnClickListener(new View.OnClickListener() {
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
            Fragment f = new RankingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ranking", title[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }

}
