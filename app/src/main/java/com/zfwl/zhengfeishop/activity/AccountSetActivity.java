package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;

public class AccountSetActivity extends Base2Activity {

    private LinearLayout returnAmend,siteMoreAccount,accountMoreAccount;
    private ImageView headAccount,personageMoreAccount,relevanceMoreAccount,setMoreAccount;
    private TextView phoneAccount,nameAccount,qiutAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_set);
        returnAmend=findViewById(R.id.return_amend);
        siteMoreAccount=findViewById(R.id.site_more_account);
        accountMoreAccount=findViewById(R.id.account_more_account);
        headAccount=findViewById(R.id.head_account);
        personageMoreAccount=findViewById(R.id.personage_more_account);
        relevanceMoreAccount=findViewById(R.id.relevance_more_account);
        setMoreAccount=findViewById(R.id.set_more_account);
        phoneAccount=findViewById(R.id.phone_account);
        nameAccount=findViewById(R.id.name_account);
        qiutAccount=findViewById(R.id.qiut_account);
        init();
    }

    private void init() {
        //个人信息
        personageMoreAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountSetActivity.this, UserMessageActivity.class));
            }
        });
        //地址
        siteMoreAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("pd",1);
                intent.setClass(AccountSetActivity.this, SiteActivity.class);
                startActivity(intent);
            }
        });
        //修改密码
        accountMoreAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountSetActivity.this, AmendPasswordActivity.class));
            }
        });
        //关联账号
        relevanceMoreAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //设置
        setMoreAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountSetActivity.this, SetMyActivity.class));
            }
        });
        //返回
        returnAmend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
