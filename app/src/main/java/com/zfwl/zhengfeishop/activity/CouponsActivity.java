package com.zfwl.zhengfeishop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.fragment.EndUseFragment;
import com.zfwl.zhengfeishop.fragment.PastDueFragment;
import com.zfwl.zhengfeishop.fragment.StayUseFragment;

import java.util.ArrayList;
import java.util.List;

public class CouponsActivity extends Base2Activity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private ImageView returnCoupons;
    private View stayuseView,enduseView,pastdueView;
    private TextView stayuseCoupons,enduserCoupons,pastdueCoupons;
    private LinearLayout stayuseLayout,enduseLayout,pastdueLayout;
    private ViewPager viewpageCoupons;
    private StayUseFragment stayUseFragment;
    private PastDueFragment pastDueFragment;
    private EndUseFragment endUseFragment;
    private List<Fragment> fragmentList;
    private VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
        returnCoupons=findViewById(R.id.return_coupons);
        stayuseView=findViewById(R.id.stayuse_view);
        enduseView=findViewById(R.id.enduse_view);
        pastdueView=findViewById(R.id.pastdue_view);
        stayuseCoupons=findViewById(R.id.stayuse_coupons);
        enduserCoupons=findViewById(R.id.enduser_coupons);
        pastdueCoupons=findViewById(R.id.pastdue_coupons);
        stayuseLayout=findViewById(R.id.stayuse_layout);
        enduseLayout=findViewById(R.id.enduse_layout);
        pastdueLayout=findViewById(R.id.pastdue_layout);
        viewpageCoupons=findViewById(R.id.viewpage_coupons);
        //设置点击
        viewpageCoupons.addOnPageChangeListener(this);
        stayuseLayout.setOnClickListener(this);
        enduseLayout.setOnClickListener(this);
        pastdueLayout.setOnClickListener(this);
        //获取fragment
        stayUseFragment = new StayUseFragment();
        endUseFragment = new EndUseFragment();
        pastDueFragment = new PastDueFragment();
        //添加fragment
        fragmentList=new ArrayList<>();
        fragmentList.add(stayUseFragment);
        fragmentList.add(endUseFragment);
        fragmentList.add(pastDueFragment);

        init();
    }

    private void init() {
        vpAdapter = new VpAdapter(getSupportFragmentManager());
        viewpageCoupons.setAdapter(vpAdapter);
        //返回
        returnCoupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.stayuse_layout:
                viewpageCoupons.setCurrentItem(0);
                break;
            case R.id.enduse_layout:
                viewpageCoupons.setCurrentItem(1);
                break;
            case R.id.pastdue_layout:
                viewpageCoupons.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                showStayUse();
                break;
            case 1:
                showEndUse();
                break;
            case 2:
                showPastDue();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //显示未使用劵
    public void showStayUse(){
        //改变字体
        stayuseCoupons.setTextColor(this.getResources().getColor(R.color.colorSelect));
        enduserCoupons.setTextColor(this.getResources().getColor(R.color.unselected));
        pastdueCoupons.setTextColor(this.getResources().getColor(R.color.unselected));
        stayuseView.setVisibility(View.VISIBLE);
        enduseView.setVisibility(View.GONE);
        pastdueView.setVisibility(View.GONE);
    }
    //显示未使用劵
    public void showEndUse(){
        //改变字体
        stayuseCoupons.setTextColor(this.getResources().getColor(R.color.unselected));
        enduserCoupons.setTextColor(this.getResources().getColor(R.color.colorSelect));
        pastdueCoupons.setTextColor(this.getResources().getColor(R.color.unselected));
        stayuseView.setVisibility(View.GONE);
        enduseView.setVisibility(View.VISIBLE);
        pastdueView.setVisibility(View.GONE);
    }
    //显示未使用劵
    public void showPastDue(){
        //改变字体
        stayuseCoupons.setTextColor(this.getResources().getColor(R.color.unselected));
        enduserCoupons.setTextColor(this.getResources().getColor(R.color.unselected));
        pastdueCoupons.setTextColor(this.getResources().getColor(R.color.colorSelect));
        stayuseView.setVisibility(View.GONE);
        enduseView.setVisibility(View.GONE);
        pastdueView.setVisibility(View.VISIBLE);
    }
    //fragment的适配器
    class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
