package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.RefundAdapter;

public class RefundActivity extends Base2Activity {

    private ImageView returnRefund;
    private RecyclerView reRefund;
    private RefundAdapter refundAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund);
        returnRefund=findViewById(R.id.return_refund);
        reRefund=findViewById(R.id.re_refund);
        init();
    }

    private void init() {
        refundAdapter = new RefundAdapter(this);
        reRefund.setLayoutManager(new LinearLayoutManager(this));
        reRefund.setAdapter(refundAdapter);
        //返回
        returnRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
