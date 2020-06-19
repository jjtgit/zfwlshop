package com.zfwl.zhengfeishop.activity;
//订单详情页面
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.bean.SiteEventBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OrderFormDetailsActivity extends Base2Activity {

    private ImageView returnOfdetails,imgOfdetails,shopimgOfdetails,carriageOfdetails;
    private TextView stateOfdetails,timeStateOfdetails,siteOfdetails,usernameOfdetails,usertimeOfdetails,nameOfdetails,
            shopnameOfdetails,thisOfdetails,priceOfdetails,amountOfdetails,freightOfdetails,titleStateOfdetails,
            titleTimeOfdetails,titlePaymentOfdetails,paymentStateOfdetails,deliveryModeOfdetails,deliveryTimeOfdetails,
            invoiceOfdetails,shoppriceOfdetails,integralOfdetails,totalOfdetails,paymentDetails,remindDetails,cancelsDetails,
            affirmDetails,logisticsDetails,cancelDetails,evaluateDetails,deleteDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form_details);
        EventBus.getDefault().register(this);
        returnOfdetails=findViewById(R.id.return_ofdetails);
        imgOfdetails=findViewById(R.id.img_ofdetails);
        shopimgOfdetails=findViewById(R.id.shopimg_ofdetails);
        carriageOfdetails=findViewById(R.id.carriage_ofdetails);
        stateOfdetails=findViewById(R.id.state_ofdetails);
        timeStateOfdetails=findViewById(R.id.time_state_ofdetails);
        siteOfdetails=findViewById(R.id.site_ofdetails);
        usernameOfdetails=findViewById(R.id.username_ofdetails);
        usertimeOfdetails=findViewById(R.id.usertime_ofdetails);
        nameOfdetails=findViewById(R.id.name_ofdetails);
        shopnameOfdetails=findViewById(R.id.shopname_ofdetails);
        thisOfdetails=findViewById(R.id.this_ofdetails);
        priceOfdetails=findViewById(R.id.price_ofdetails);
        amountOfdetails=findViewById(R.id.amount_ofdetails);
        freightOfdetails=findViewById(R.id.freight_ofdetails);
        titleStateOfdetails=findViewById(R.id.title_state_ofdetails);
        titleTimeOfdetails=findViewById(R.id.title_time_ofdetails);
        titlePaymentOfdetails=findViewById(R.id.title_payment_ofdetails);
        paymentStateOfdetails=findViewById(R.id.payment_state_ofdetails);
        deliveryModeOfdetails=findViewById(R.id.delivery_mode_ofdetails);
        deliveryTimeOfdetails=findViewById(R.id.delivery_time_ofdetails);
        invoiceOfdetails=findViewById(R.id.invoice_ofdetails);
        shoppriceOfdetails=findViewById(R.id.shopprice_ofdetails);
        integralOfdetails=findViewById(R.id.integral_ofdetails);
        totalOfdetails=findViewById(R.id.total_ofdetails);
        paymentDetails=findViewById(R.id.payment_details);
        remindDetails=findViewById(R.id.remind_details);
        cancelsDetails=findViewById(R.id.cancels_details);
        affirmDetails=findViewById(R.id.affirm_details);
        logisticsDetails=findViewById(R.id.logistics_details);
        cancelDetails=findViewById(R.id.cancel_details);
        evaluateDetails=findViewById(R.id.evaluate_details);
        shopnameOfdetails=findViewById(R.id.shopname_ofdetails);
        thisOfdetails=findViewById(R.id.this_ofdetails);
        deleteDetails=findViewById(R.id.delete_details);
        init();
    }
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onMessageEvent(SiteEventBean eventBean){
        siteOfdetails.setText(eventBean.getTitlesite());
        usernameOfdetails.setText(eventBean.getNamesite());
        usertimeOfdetails.setText(eventBean.getCellphonesite());
    }

    private void init() {
        int id = getIntent().getIntExtra("id", 0);
        if (id==0){
            //待付款
            stateOfdetails.setText("待付款");
            timeStateOfdetails.setText("还剩23小时58分自动取消");
            imgOfdetails.setVisibility(View.VISIBLE);
            carriageOfdetails.setVisibility(View.GONE);
            paymentDetails.setVisibility(View.VISIBLE);
            cancelsDetails.setVisibility(View.VISIBLE);
            remindDetails.setVisibility(View.GONE);
            affirmDetails.setVisibility(View.GONE);
            logisticsDetails.setVisibility(View.GONE);
            cancelDetails.setVisibility(View.GONE);
            evaluateDetails.setVisibility(View.GONE);
            deleteDetails.setVisibility(View.GONE);
        }else if (id==1){
            //待发货
            stateOfdetails.setText("买家已付款");
            timeStateOfdetails.setText("卖家尽快为您发货请耐心等待");
            carriageOfdetails.setVisibility(View.VISIBLE);
            imgOfdetails.setVisibility(View.GONE);
            paymentDetails.setVisibility(View.GONE);
            cancelsDetails.setVisibility(View.GONE);
            remindDetails.setVisibility(View.VISIBLE);
            affirmDetails.setVisibility(View.GONE);
            logisticsDetails.setVisibility(View.GONE);
            cancelDetails.setVisibility(View.GONE);
            evaluateDetails.setVisibility(View.GONE);
            deleteDetails.setVisibility(View.GONE);
        }else if (id==2){
            //待收货
            stateOfdetails.setText("卖家已发货");
            timeStateOfdetails.setText("还剩11天23小时自动确认");
            imgOfdetails.setVisibility(View.GONE);
            carriageOfdetails.setVisibility(View.VISIBLE);
            paymentDetails.setVisibility(View.GONE);
            cancelsDetails.setVisibility(View.GONE);
            remindDetails.setVisibility(View.GONE);
            affirmDetails.setVisibility(View.VISIBLE);
            logisticsDetails.setVisibility(View.VISIBLE);
            cancelDetails.setVisibility(View.VISIBLE);
            evaluateDetails.setVisibility(View.GONE);
            deleteDetails.setVisibility(View.GONE);
        }else if (id==3){
            //待评价
            stateOfdetails.setText("买家已确认收货");
            timeStateOfdetails.setText("可以请您给商家评价一下吗");
            imgOfdetails.setVisibility(View.GONE);
            carriageOfdetails.setVisibility(View.GONE);
            paymentDetails.setVisibility(View.GONE);
            cancelsDetails.setVisibility(View.GONE);
            remindDetails.setVisibility(View.GONE);
            affirmDetails.setVisibility(View.GONE);
            logisticsDetails.setVisibility(View.GONE);
            cancelDetails.setVisibility(View.GONE);
            evaluateDetails.setVisibility(View.VISIBLE);
            deleteDetails.setVisibility(View.GONE);
        }else if (id==4){
            stateOfdetails.setText("已取消");
            timeStateOfdetails.setText("系统自动取消订单");
            imgOfdetails.setVisibility(View.GONE);
            carriageOfdetails.setVisibility(View.GONE);
            paymentDetails.setVisibility(View.GONE);
            cancelsDetails.setVisibility(View.GONE);
            remindDetails.setVisibility(View.GONE);
            affirmDetails.setVisibility(View.GONE);
            logisticsDetails.setVisibility(View.GONE);
            cancelDetails.setVisibility(View.GONE);
            evaluateDetails.setVisibility(View.GONE);
            deleteDetails.setVisibility(View.VISIBLE);
        }
        //修改地址
        imgOfdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("pd",0);
                intent.setClass(OrderFormDetailsActivity.this, SiteActivity.class);
                startActivity(intent);
            }
        });
        //返回
        returnOfdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
