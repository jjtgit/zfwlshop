package com.zfwl.zhengfeishop.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;


public class LoginActivity extends Base2Activity {

    private TextView loginText,loginButton,forgetLgoin;
    private LinearLayout returnLayout;
    private EditText nameEdit,passwordEdit;
    private String name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams. SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_login);
        loginText=findViewById(R.id.login_text);
        returnLayout=findViewById(R.id.return_layout);
        nameEdit=findViewById(R.id.name_edit);
        passwordEdit=findViewById(R.id.password_edit);
        loginButton=findViewById(R.id.login_button);
        forgetLgoin=findViewById(R.id.forget_lgoin);
        init();
    }

    private void init() {
        //注册
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignActivity.class));
            }
        });
        //登入
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                name = nameEdit.getText().toString();
                password=passwordEdit.getText().toString();
                if (name.equals("")){
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if (password.equals("")){
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(LoginActivity.this, "登入成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //忘记密码
        forgetLgoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,AmendPasswordActivity.class));
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
