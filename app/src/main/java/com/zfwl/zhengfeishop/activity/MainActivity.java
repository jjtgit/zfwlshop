package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.contract.BaseContract;
import com.zfwl.zhengfeishop.fragment.ClassifyFragment;
import com.zfwl.zhengfeishop.fragment.HomeFragment;
import com.zfwl.zhengfeishop.fragment.MyFragment;
import com.zfwl.zhengfeishop.fragment.ShopCarFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class MainActivity extends BaseActivity implements BaseContract.IBaseView {

    private FrameLayout fragmentLayout;
    private LinearLayout homeLayout,classifyLayout,shopcarLayout,myLayout;
    private HomeFragment homeFragment;
    private ClassifyFragment classifyFragment;
    private ShopCarFragment shopCarFragment;
    private MyFragment myFragment;
    private FragmentTransaction fragmentTransaction;
    private ImageView imgHome,imgClassify,imgShopCar,imgMy;
    private TextView titleHome,titleClassify,titleShopCar,titleMy,numberShopcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册订阅者
        EventBus.getDefault().register(this);
        //获取id
        fragmentLayout=findViewById(R.id.fragment);
        homeLayout=findViewById(R.id.home_fragment);
        classifyLayout=findViewById(R.id.classify_fragment);
        shopcarLayout=findViewById(R.id.shopcar_fragment);
        myLayout=findViewById(R.id.my_fragment);
        imgHome=findViewById(R.id.img_home);
        imgClassify=findViewById(R.id.img_classify);
        imgShopCar=findViewById(R.id.img_shopcar);
        imgMy=findViewById(R.id.img_my);
        titleHome=findViewById(R.id.title_home);
        titleClassify=findViewById(R.id.title_classify);
        titleShopCar=findViewById(R.id.title_shopcar);
        titleMy=findViewById(R.id.title_my);
        numberShopcar=findViewById(R.id.number_shopcar);
        //获取四个fragment
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        shopCarFragment = new ShopCarFragment();
        myFragment = new MyFragment();
        //获取fragment的控制，默认展示首页
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment,homeFragment).show(homeFragment);
        fragmentTransaction.add(R.id.fragment,classifyFragment).hide(classifyFragment);
        fragmentTransaction.add(R.id.fragment,shopCarFragment).hide(shopCarFragment);
        fragmentTransaction.add(R.id.fragment,myFragment).hide(myFragment);
        fragmentTransaction.commit();
        //选择首页
        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHome();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.show(homeFragment)
                        .hide(classifyFragment)
                        .hide(shopCarFragment)
                        .hide(myFragment);
               fragmentTransaction.commit();
            }
        });
        //选择分类
        classifyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClassify();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.show(classifyFragment)
                        .hide(homeFragment)
                        .hide(shopCarFragment)
                        .hide(myFragment);
                fragmentTransaction.commit();
            }
        });
        //选择购物车
        shopcarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShopCar();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.show(shopCarFragment)
                        .hide(homeFragment)
                        .hide(classifyFragment)
                        .hide(myFragment);
                fragmentTransaction.commit();
            }
        });
        //选择我的
        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMy();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.show(myFragment)
                        .hide(homeFragment)
                        .hide(classifyFragment)
                        .hide(shopCarFragment);
                fragmentTransaction.commit();
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String numm){
        int change=Integer.parseInt(numm);
        if (change<1){
            numberShopcar.setVisibility(View.GONE);
        }else if(change>99){
            numberShopcar.setVisibility(View.VISIBLE);
            numberShopcar.setText("99+");
        }else {
            numberShopcar.setVisibility(View.VISIBLE);
            numberShopcar.setText(change+"");
        }
    }
    @Override
    public void onFailUre(String msg) {

    }

    @Override
    public void onSuccessGet(String result) {

    }

    @Override
    public void onSuccessTwoGet(String result) {

    }

    @Override
    public void onSuccessThreeGet(String result) {

    }

    @Override
    public void onSuccessPost(String result) {

    }

    @Override
    public void onSuccessTwoPost(String result) {

    }

    @Override
    public void onSuccessPostPic(String result) {

    }
    private void showHome() {
        //改变图片
        imgHome.setBackground(getResources().getDrawable(R.mipmap.home_red));
        imgClassify.setBackground(getResources().getDrawable(R.mipmap.classify_ash));
        imgShopCar.setBackground(getResources().getDrawable(R.mipmap.shop_car_ash));
        imgMy.setBackground(getResources().getDrawable(R.mipmap.my_ash));
        //改变字体
        titleHome.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titleClassify.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleShopCar.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleMy.setTextColor(this.getResources().getColor(R.color.colorUnselected));
    }
    private void showClassify() {
        //改变图片
        imgHome.setBackground(getResources().getDrawable(R.mipmap.home_ash));
        imgClassify.setBackground(getResources().getDrawable(R.mipmap.classify_red));
        imgShopCar.setBackground(getResources().getDrawable(R.mipmap.shop_car_ash));
        imgMy.setBackground(getResources().getDrawable(R.mipmap.my_ash));
        //改变字体
        titleHome.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleClassify.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titleShopCar.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleMy.setTextColor(this.getResources().getColor(R.color.colorUnselected));
    }
    private void showShopCar() {
        //改变图片
        imgHome.setBackground(getResources().getDrawable(R.mipmap.home_ash));
        imgClassify.setBackground(getResources().getDrawable(R.mipmap.classify_ash));
        imgShopCar.setBackground(getResources().getDrawable(R.mipmap.shop_car_red));
        imgMy.setBackground(getResources().getDrawable(R.mipmap.my_ash));
        //改变字体
        titleHome.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleClassify.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleShopCar.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titleMy.setTextColor(this.getResources().getColor(R.color.colorUnselected));
    }
    private void showMy() {
        //改变图片
        imgHome.setBackground(getResources().getDrawable(R.mipmap.home_ash));
        imgClassify.setBackground(getResources().getDrawable(R.mipmap.classify_ash));
        imgShopCar.setBackground(getResources().getDrawable(R.mipmap.shop_car_ash));
        imgMy.setBackground(getResources().getDrawable(R.mipmap.my_red));
        //改变字体
        titleHome.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleClassify.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleShopCar.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        titleMy.setTextColor(this.getResources().getColor(R.color.colorSelect));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销EventBus
        EventBus.getDefault().unregister(this);
    }
}
