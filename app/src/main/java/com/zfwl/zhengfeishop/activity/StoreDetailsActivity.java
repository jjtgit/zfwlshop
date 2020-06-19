package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.utils.RatingBarUtils;

public class StoreDetailsActivity extends Base2Activity {

    private RatingBarUtils rbEvaluate;
    private LinearLayout attentionLayout;
    private TextView notAttentionLayout;
    private int pd=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        rbEvaluate=findViewById(R.id.rb_evaluate);
        attentionLayout=findViewById(R.id.attention_layout);
        notAttentionLayout=findViewById(R.id.not_attention_layout);
        init();
    }

    private void init() {
        //关注
        if (pd==0){
            attentionLayout.setVisibility(View.VISIBLE);
            notAttentionLayout.setVisibility(View.GONE);
        }else {
            attentionLayout.setVisibility(View.GONE);
            notAttentionLayout.setVisibility(View.VISIBLE);
        }
        //关注
        attentionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd=1;
                attentionLayout.setVisibility(View.GONE);
                notAttentionLayout.setVisibility(View.VISIBLE);
            }
        });
        //取消关注
        notAttentionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd=0;
                attentionLayout.setVisibility(View.VISIBLE);
                notAttentionLayout.setVisibility(View.GONE);
            }
        });
        //评分
        rbEvaluate.setClickable(false);
        float v= (float) 3.5;
        rbEvaluate.setStar(v);
       /* rbEvaluate.setOnRatingChangeListener(new RatingBarUtils.OnRatingChangeListener() {

            @Override
            public void onRatingChange(float ratingCount) {
                round = Math.round(ratingCount);

            }
        });*/
    }
}
