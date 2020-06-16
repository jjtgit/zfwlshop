package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.MessageAdapter;

public class MyMessagesActivity extends Base2Activity implements MessageAdapter.ItemOnClickInterface{

    private LinearLayout integralMylayout;
    private RecyclerView rvMymessages;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_messages);
        integralMylayout=findViewById(R.id.integral_mylayout);
        rvMymessages=findViewById(R.id.rv_mymessages);
        messageAdapter = new MessageAdapter(this);
        messageAdapter.setItemOnClickInterface(this);
        init();
    }

    private void init() {
        rvMymessages.setLayoutManager(new LinearLayoutManager(this));
        rvMymessages.setAdapter(messageAdapter);
        //返回
        integralMylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {

        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }
}
