package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.FreshAdapter;

//本地服饰
public class ThisLocalityCostumeActivity extends Base2Activity {

    private ImageView returnCostume;
    private RecyclerView rvCostume;
    private FreshAdapter freshAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_locality_costume);
        //获取id
        returnCostume=findViewById(R.id.return_costume);
        rvCostume=findViewById(R.id.rv_costume);
        freshAdapter = new FreshAdapter(this);
        init();
    }

    private void init() {
        rvCostume.setLayoutManager(new GridLayoutManager(this,2));
        rvCostume.setAdapter(freshAdapter);
        //返回
        returnCostume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
