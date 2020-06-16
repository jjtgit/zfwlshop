package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.LeadItemAdapter;

public class LeadTroopsActivity extends BaseActivity {

    private ImageView returnLead,imgLead;
    private RecyclerView rvLead;
    private LeadItemAdapter leadItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_troops);
        returnLead= findViewById(R.id.return_lead);
        imgLead=findViewById(R.id.img_lead);
        rvLead=findViewById(R.id.rv_lead);
        leadItemAdapter = new LeadItemAdapter(this);
        init();
    }

    private void init() {
        rvLead.setLayoutManager(new LinearLayoutManager(this));
        rvLead.setAdapter(leadItemAdapter);
        //返回
        returnLead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
