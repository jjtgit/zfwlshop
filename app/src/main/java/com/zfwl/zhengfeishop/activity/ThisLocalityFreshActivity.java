package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.FreshAdapter;
//本地生鲜
public class ThisLocalityFreshActivity extends Base2Activity {

    private RecyclerView rvFresh;
    private ImageView returnFresh;
    private FreshAdapter freshAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_locality_fresh);
        //获取id
        returnFresh=findViewById(R.id.return_fresh);
        rvFresh=findViewById(R.id.rv_fresh);
        freshAdapter = new FreshAdapter(this);
        init();
    }

    private void init() {
        rvFresh.setLayoutManager(new GridLayoutManager(this,2));
        rvFresh.setAdapter(freshAdapter);
        //返回
        returnFresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
