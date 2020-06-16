package com.zfwl.zhengfeishop.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.activity.CollectPostActivity;
import com.zfwl.zhengfeishop.activity.ContactActivity;
import com.zfwl.zhengfeishop.activity.CouponsActivity;
import com.zfwl.zhengfeishop.activity.IntegralActivity;
import com.zfwl.zhengfeishop.activity.LoginActivity;
import com.zfwl.zhengfeishop.activity.MyMessagesActivity;
import com.zfwl.zhengfeishop.activity.OrderFormActivity;
import com.zfwl.zhengfeishop.activity.RefundActivity;
import com.zfwl.zhengfeishop.activity.SetMyActivity;
import com.zfwl.zhengfeishop.activity.SiteActivity;
import com.zfwl.zhengfeishop.activity.StoreActivity;
import com.zfwl.zhengfeishop.activity.UserMessageActivity;

import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * Created by 修梦 on 2020/4/16.
 * Describe:
 */
public class MyFragment extends BaseFragment{

    private ImageView setImgmy,messageMy;
    private LinearLayout personageLayout,orderFormMy,commentLayout,paymentLayout,collectLayout,integralLayout,
            couponsLayout,aftersaleLayout,collectShopLayout,storeLayout,instationMessageLayout,serviceLayout,
            distributionLayout,siteLayout;

    @Override
    protected int getLayoutView() {
        return R.layout.my_fragment;
    }

    @Override
    protected void initView(View view) {
        setImgmy=view.findViewById(R.id.set_imgmy);
        personageLayout=view.findViewById(R.id.personage_layout);
        orderFormMy=view.findViewById(R.id.order_form_my);
        paymentLayout=view.findViewById(R.id.payment_layout);
        collectLayout=view.findViewById(R.id.collect_layout);
        commentLayout=view.findViewById(R.id.comment_layout);
        integralLayout=view.findViewById(R.id.integral_layout);
        couponsLayout=view.findViewById(R.id.coupons_layout);
        aftersaleLayout=view.findViewById(R.id.aftersale_layout);
        collectShopLayout=view.findViewById(R.id.collect_shop_layout);
        storeLayout=view.findViewById(R.id.store_layout);
        instationMessageLayout=view.findViewById(R.id.instation_message_layout);
        serviceLayout=view.findViewById(R.id.service_layout);
        distributionLayout=view.findViewById(R.id.distribution_layout);
        siteLayout=view.findViewById(R.id.site_layout);
        messageMy=view.findViewById(R.id.message_my);
        init();
    }

    private void init() {
        //设置
        setImgmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), SetMyActivity.class));
            }
        });
        //个人信息
        personageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), UserMessageActivity.class));
            }
        });
        //我的订单
        orderFormMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("order",0);
                intent.setClass(getActivity(),OrderFormActivity.class);
                getActivity().startActivity(intent);
            }
        });
        //待付款
        paymentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("order",1);
                intent.setClass(getActivity(),OrderFormActivity.class);
                getActivity().startActivity(intent);
            }
        });
        //待收货
        collectLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("order",3);
                intent.setClass(getActivity(),OrderFormActivity.class);
                getActivity().startActivity(intent);
            }
        });
        //待付款
        commentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("order",4);
                intent.setClass(getActivity(),OrderFormActivity.class);
                getActivity().startActivity(intent);
            }
        });
        //退货售后
        aftersaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), RefundActivity.class));
            }
        });
        //我的积分
        integralLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), IntegralActivity.class));
            }
        });
        //我的优惠卷
        couponsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), CouponsActivity.class));
            }
        });
        //收藏的商品
        collectShopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), CollectPostActivity.class));
            }
        });
        //收藏的店铺
        storeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), StoreActivity.class));
            }
        });
        //站内消息
        instationMessageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), MyMessagesActivity.class));
            }
        });
        //客服消息
        serviceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), ContactActivity.class));
            }
        });
        //地址管理
        siteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), SiteActivity.class));
            }
        });
        //登入
        messageMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }
}
