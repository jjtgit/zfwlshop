package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;

public class RefundDetailsActivity extends Base2Activity {

    private ImageView returnRedetails;
    private TextView refundRedetails,timeRefundRedetails,moneyRedetails,nameRedetails,shopnameRedetails,
            thisRedetails,priceRedetails,causeRedetails,causePriceRedetails,applyforRedetails,numberRedetails,
            relationDetails,phoneDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_details);
        int id = getIntent().getIntExtra("id",0);
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        returnRedetails=findViewById(R.id.return_redetails);
        refundRedetails=findViewById(R.id.refund_redetails);
        timeRefundRedetails=findViewById(R.id.time_refund_redetails);
        moneyRedetails=findViewById(R.id.money_redetails);
        nameRedetails=findViewById(R.id.name_redetails);
        shopnameRedetails=findViewById(R.id.shopname_redetails);
        thisRedetails=findViewById(R.id.this_redetails);
        priceRedetails=findViewById(R.id.price_redetails);
        causeRedetails=findViewById(R.id.cause_redetails);
        causePriceRedetails=findViewById(R.id.cause_price_redetails);
        applyforRedetails=findViewById(R.id.applyfor_redetails);
        numberRedetails=findViewById(R.id.number_redetails);
        relationDetails=findViewById(R.id.relation_details);
        phoneDetails=findViewById(R.id.phone_details);
        init();
    }

    private void init() {
        //返回
        returnRedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
