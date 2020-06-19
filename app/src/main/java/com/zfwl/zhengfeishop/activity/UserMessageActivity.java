package com.zfwl.zhengfeishop.activity;
//个人信息
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;

public class UserMessageActivity extends Base2Activity {

    private LinearLayout returnLayout,headLayout,nicknameLayout,sexLayout,birthdayLayout;
    private ImageView headImg;
    private TextView nameText,nicknameText,sexText,birthdayText;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);
        returnLayout=findViewById(R.id.return_layout);
        headLayout=findViewById(R.id.head_layout);
        nicknameLayout=findViewById(R.id.nickname_layout);
        sexLayout=findViewById(R.id.sex_layout);
        birthdayLayout=findViewById(R.id.birthday_layout);
        headImg=findViewById(R.id.head_img);
        nameText=findViewById(R.id.name_text);
        nicknameText=findViewById(R.id.nickname_text);
        sexText=findViewById(R.id.sex_text);
        birthdayText=findViewById(R.id.birthday_text);
        init();
    }

    private void init() {
        //上传头像

        //修改昵称
        nicknameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserMessageActivity.this,AmendNicknameActivity.class ));
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
