package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.fragment.TimeLimitFragment;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeLimitActivity extends BaseActivity {

    private ImageView returnTimeLimit;
    private TabLayout tabTimeLimit;
    private ViewPager pageTimeLimit;
    private String tabText;
    private int min;
    private String[] title = {
            "02:00已开枪",
            "04:00已开枪",
            "06:00已开枪",
            "08:00已开抢",
            "10:00已开抢",
            "12:00已开抢",
            "14:00抢购中",
            "16:00即将开始",
            "18:00即将开始",
            "20:00即将开始",
            "22:00即将开始",
            "24:00即将开始"
    };
    private MyPagerAdapter adapter;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_limit);
        returnTimeLimit=findViewById(R.id.return_time_limit);
        tabTimeLimit=findViewById(R.id.tab_time_limit);
        pageTimeLimit=findViewById(R.id.page_time_limit);
        init();
    }

    private void init() {
        Date date = new Date(System.currentTimeMillis());
        long msecond = System.currentTimeMillis();
        long mmsecond = msecond%1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        time = simpleDateFormat.format(date);
        String times = time.substring(0, 2);
        int i = Integer.parseInt(times);
        if (i<2){
            min=11;
        }else if (2<=i&&i<4){
            min=0;
        } else if (4<=i&&i<6){
            min=1;
        } else if (6<=i&&i<8){
            min=2;
        } else if (8<=i&&i<10){
            min=3;
        } else if (10<=i&&i<12){
            min=4;
        } else if (12<=i&&i<14){
            min=5;
        } else if (14<=i&&i<16){
            min=6;
        } else if (16<=i&&i<18){
            min=7;
        } else if (18<=i&&i<20){
            min=8;
        }  else if (20<=i&&i<22){
            min=9;
        }else if (22<=i&&i<24){
            min=10;
        }
        tabTimeLimit.setupWithViewPager(pageTimeLimit);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pageTimeLimit.setAdapter(adapter);
        tabTimeLimit.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabTimeLimit.setTabGravity(TabLayout.GRAVITY_FILL);
        tabTimeLimit.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabTimeLimit.getTabAt(min).select();
        tabTimeLimit.setSelectedTabIndicatorHeight(0);

        //返回
        returnTimeLimit.setOnClickListener(new View.OnClickListener() {
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
            String titles = title[position];
            String substring = titles.substring(0, 5);
            String substring1 = titles.substring(5);
            String s=substring+"\n"+substring1;
            return s;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new TimeLimitFragment();
            Bundle bundle = new Bundle();
            bundle.putString("timelimit", title[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }
}
