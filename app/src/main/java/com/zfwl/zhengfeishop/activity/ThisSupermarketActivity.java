package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.FreshAdapter;

public class ThisSupermarketActivity extends Base2Activity {

    private RecyclerView rvSupermarket;
    private ImageView returnSupermarket;
    private FreshAdapter freshAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_supermarket);
        //获取id
        rvSupermarket=findViewById(R.id.rv_supermarket);
        returnSupermarket=findViewById(R.id.return_supermarket);
        freshAdapter = new FreshAdapter(this);
        init();
    }

    private void init() {
        rvSupermarket.setLayoutManager(new GridLayoutManager(this,2));
        rvSupermarket.setAdapter(freshAdapter);
        //返回
        returnSupermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
