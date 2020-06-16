package com.zfwl.zhengfeishop.activity;
//我的订单
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.fragment.AllOformFragment;
import com.zfwl.zhengfeishop.fragment.EvaluateOformFragment;
import com.zfwl.zhengfeishop.fragment.PaymentOformFragment;
import com.zfwl.zhengfeishop.fragment.ReceivingOformFragment;
import com.zfwl.zhengfeishop.fragment.ShipmentsOformFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderFormActivity extends Base2Activity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private LinearLayout returnform,allLayout,paymentLayout,shipmentLayout,receivingLayout,evaluateLayout;
    private TextView allOform,paymentOform,shipmentsOform,receivingOform,evaluateOform;
    private View allView,paymentView,shipmentsView,receivingView,evaluateView;
    private ViewPager viewpageOform;
    private AllOformFragment allOformFragment;
    private PaymentOformFragment paymentOformFragment;
    private ShipmentsOformFragment shipmentsOformFragment;
    private ReceivingOformFragment receivingOformFragment;
    private EvaluateOformFragment evaluateOformFragment;
    private List<Fragment> fragmentList;
    private VpAdapter vpAdapter;
    private int orderint=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        returnform=findViewById(R.id.return_oform);
        allOform=findViewById(R.id.all_oform);
        paymentOform=findViewById(R.id.payment_oform);
        shipmentsOform=findViewById(R.id.shipments_oform);
        receivingOform=findViewById(R.id.receiving_oform);
        evaluateOform=findViewById(R.id.evaluate_oform);
        allView=findViewById(R.id.all_view);
        paymentView=findViewById(R.id.payment_view);
        shipmentsView=findViewById(R.id.shipments_view);
        receivingView=findViewById(R.id.receiving_view);
        evaluateView=findViewById(R.id.evaluate_view);
        viewpageOform=findViewById(R.id.viewpage_oform);
        allLayout=findViewById(R.id.all_layout);
        paymentLayout=findViewById(R.id.payment_layout);
        shipmentLayout=findViewById(R.id.shipment_layout);
        receivingLayout=findViewById(R.id.receiving_layout);
        evaluateLayout=findViewById(R.id.evaluate_layout);
        //设置点击
        viewpageOform.addOnPageChangeListener(this);
        allLayout.setOnClickListener(this);
        paymentLayout.setOnClickListener(this);
        shipmentLayout.setOnClickListener(this);
        receivingLayout.setOnClickListener(this);
        evaluateLayout.setOnClickListener(this);
        //获取fragment
        allOformFragment = new AllOformFragment();
        paymentOformFragment = new PaymentOformFragment();
        shipmentsOformFragment = new ShipmentsOformFragment();
        receivingOformFragment = new ReceivingOformFragment();
        evaluateOformFragment = new EvaluateOformFragment();
        fragmentList=new ArrayList<>();
        fragmentList.add(allOformFragment);
        fragmentList.add(paymentOformFragment);
        fragmentList.add(shipmentsOformFragment);
        fragmentList.add(receivingOformFragment);
        fragmentList.add(evaluateOformFragment);
        init();
    }

    private void init() {
        vpAdapter=new VpAdapter(getSupportFragmentManager());
        viewpageOform.setAdapter(vpAdapter);
        int order = getIntent().getIntExtra("order", 0);
        orderint=order;
        if (orderint==0){
            viewpageOform.setCurrentItem(orderint);
        }else if (orderint==1){
            viewpageOform.setCurrentItem(orderint);
        }else if (orderint==3){
            viewpageOform.setCurrentItem(orderint);
        }else if (orderint==4){
            viewpageOform.setCurrentItem(orderint);
        }
        //返回
        returnform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.all_layout:
               viewpageOform.setCurrentItem(0);
               break;
            case R.id.payment_layout:
                viewpageOform.setCurrentItem(1);
                break;
            case R.id.shipment_layout:
                viewpageOform.setCurrentItem(2);
                break;
            case R.id.receiving_layout:
                viewpageOform.setCurrentItem(3);
                break;
            case R.id.evaluate_layout:
                viewpageOform.setCurrentItem(4);
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
                showAll();
                break;
            case 1:
                showPayment();
                break;
            case 2:
                showShipments();
                break;
            case 3:
                showReceiving();
                break;
            case 4:
                showEvaluate();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    //选择全部
    private void showAll(){
        //改变字体颜色
        allOform.setTextColor(this.getResources().getColor(R.color.colorSelect));
        paymentOform.setTextColor(this.getResources().getColor(R.color.unselected));
        shipmentsOform.setTextColor(this.getResources().getColor(R.color.unselected));
        receivingOform.setTextColor(this.getResources().getColor(R.color.unselected));
        evaluateOform.setTextColor(this.getResources().getColor(R.color.unselected));
        allView.setVisibility(View.VISIBLE);
        paymentView.setVisibility(View.GONE);
        shipmentsView.setVisibility(View.GONE);
        receivingView.setVisibility(View.GONE);
        evaluateView.setVisibility(View.GONE);
    }
    //选择待付款
    private void showPayment(){
        //改变字体颜色
        allOform.setTextColor(this.getResources().getColor(R.color.unselected));
        paymentOform.setTextColor(this.getResources().getColor(R.color.colorSelect));
        shipmentsOform.setTextColor(this.getResources().getColor(R.color.unselected));
        receivingOform.setTextColor(this.getResources().getColor(R.color.unselected));
        evaluateOform.setTextColor(this.getResources().getColor(R.color.unselected));
        allView.setVisibility(View.GONE);
        paymentView.setVisibility(View.VISIBLE);
        shipmentsView.setVisibility(View.GONE);
        receivingView.setVisibility(View.GONE);
        evaluateView.setVisibility(View.GONE);
    }
    //选择待发货
    private void showShipments(){
        //改变字体颜色
        allOform.setTextColor(this.getResources().getColor(R.color.unselected));
        paymentOform.setTextColor(this.getResources().getColor(R.color.unselected));
        shipmentsOform.setTextColor(this.getResources().getColor(R.color.colorSelect));
        receivingOform.setTextColor(this.getResources().getColor(R.color.unselected));
        evaluateOform.setTextColor(this.getResources().getColor(R.color.unselected));
        allView.setVisibility(View.GONE);
        paymentView.setVisibility(View.GONE);
        shipmentsView.setVisibility(View.VISIBLE);
        receivingView.setVisibility(View.GONE);
        evaluateView.setVisibility(View.GONE);
    }
    //选择待收货
    private void showReceiving(){
        //改变字体颜色
        allOform.setTextColor(this.getResources().getColor(R.color.unselected));
        paymentOform.setTextColor(this.getResources().getColor(R.color.unselected));
        shipmentsOform.setTextColor(this.getResources().getColor(R.color.unselected));
        receivingOform.setTextColor(this.getResources().getColor(R.color.colorSelect));
        evaluateOform.setTextColor(this.getResources().getColor(R.color.unselected));
        allView.setVisibility(View.GONE);
        paymentView.setVisibility(View.GONE);
        shipmentsView.setVisibility(View.GONE);
        receivingView.setVisibility(View.VISIBLE);
        evaluateView.setVisibility(View.GONE);
    }
    //选择待评价
    private void showEvaluate(){
        //改变字体颜色
        allOform.setTextColor(this.getResources().getColor(R.color.unselected));
        paymentOform.setTextColor(this.getResources().getColor(R.color.unselected));
        shipmentsOform.setTextColor(this.getResources().getColor(R.color.unselected));
        receivingOform.setTextColor(this.getResources().getColor(R.color.unselected));
        evaluateOform.setTextColor(this.getResources().getColor(R.color.colorSelect));
        allView.setVisibility(View.GONE);
        paymentView.setVisibility(View.GONE);
        shipmentsView.setVisibility(View.GONE);
        receivingView.setVisibility(View.GONE);
        evaluateView.setVisibility(View.VISIBLE);
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
