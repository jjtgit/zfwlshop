package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.IntegralAdapter;

public class IntegralActivity extends Base2Activity {

    private RecyclerView rvIntegral;
    private IntegralAdapter integralAdapter;
    private ImageView returnMyintegral;
    private TextView integralShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        rvIntegral=findViewById(R.id.rv_integral);
        returnMyintegral=findViewById(R.id.return_myintegral);
        integralShop=findViewById(R.id.integral_shop);
        init();
    }

    private void init() {
        integralAdapter = new IntegralAdapter(this);
        rvIntegral.setLayoutManager(new LinearLayoutManager(this));
        rvIntegral.setAdapter(integralAdapter);
        //返回
        returnMyintegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //积分商城
        integralShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntegralActivity.this,IntegralShopActivity.class));
            }
        });
    }
}
