package com.zfwl.zhengfeishop.activity;
//我的地址
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.SiteAdapter;

public class SiteActivity extends Base2Activity {

    private ImageView returnOfdetails;
    private RecyclerView rvSite;
    private TextView buttenSite;
    private SiteAdapter siteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        returnOfdetails=findViewById(R.id.return_ofdetails);
        rvSite=findViewById(R.id.rv_site);
        buttenSite=findViewById(R.id.butten_site);
        siteAdapter = new SiteAdapter(this);
        init();
    }

    private void init() {
        rvSite.setLayoutManager(new LinearLayoutManager(this));
        rvSite.setAdapter(siteAdapter);
        //新建地址
        buttenSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("pd",0);
                intent.setClass(SiteActivity.this,SiteMyActivity.class);
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
    public void Finshs(){
        finish();
    }
}
