package com.zfwl.zhengfeishop.activity;
//修改昵称
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;

public class AmendNicknameActivity extends Base2Activity {

    private LinearLayout returnLayout;
    private EditText nicknameAmend;
    private TextView notSaveAmend,saveAmend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amend_nickname);
        returnLayout=findViewById(R.id.return_layout);
        nicknameAmend=findViewById(R.id.nickname_amend);
        notSaveAmend=findViewById(R.id.not_save_amend);
        saveAmend=findViewById(R.id.save_amend);
        init();
    }

    private void init() {
        //获取昵称
        nicknameAmend.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")){
                    notSaveAmend.setVisibility(View.GONE);
                    saveAmend.setVisibility(View.VISIBLE);
                }else {
                    notSaveAmend.setVisibility(View.VISIBLE);
                    saveAmend.setVisibility(View.GONE);
                }
            }
        });
        //保存
        saveAmend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AmendNicknameActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        //返回
        returnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
