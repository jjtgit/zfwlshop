package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignDetailsActivity extends Base2Activity {

    private LinearLayout returnSigndet;
    private EditText nameEditSigndet,passwordEditSigndet,affirmPasswordEdiSigndett;
    private TextView notLoginButtonSigndet,loginButtonSigndet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_details);
        returnSigndet=findViewById(R.id.return_signdet);
        nameEditSigndet=findViewById(R.id.name_edit_signdet);
        passwordEditSigndet=findViewById(R.id.password_edit_signdet);
        affirmPasswordEdiSigndett=findViewById(R.id.affirm_password_edi_signdett);
        notLoginButtonSigndet=findViewById(R.id.not_login_button_signdet);
        loginButtonSigndet=findViewById(R.id.login_button_signdet);
        init();
    }

    private void init() {
        nameEditSigndet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")){
                    passwordEditSigndet.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (!editable.toString().equals("")){
                                affirmPasswordEdiSigndett.addTextChangedListener(new TextWatcher() {
                                    @Override
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                    }

                                    @Override
                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                    }

                                    @Override
                                    public void afterTextChanged(Editable editable) {
                                        if (!editable.toString().equals("")){
                                            loginButtonSigndet.setVisibility(View.VISIBLE);
                                            notLoginButtonSigndet.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                //注册
                loginButtonSigndet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = nameEditSigndet.getText().toString();
                        String password = passwordEditSigndet.getText().toString();
                        String affirmPassword = affirmPasswordEdiSigndett.getText().toString();
                        if (!ispsd(password)){
                            Toast.makeText(SignDetailsActivity.this, "密码不可为单一的字母或数字", Toast.LENGTH_SHORT).show();
                            return;
                        }else if (!password.equals(affirmPassword)){
                            Toast.makeText(SignDetailsActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                            return;
                        }else {
                            Toast.makeText(SignDetailsActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignDetailsActivity.this,LoginActivity.class));
                            finish();
                        }
                    }
                });
            }
        });
        //返回
        returnSigndet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public static boolean ispsd(String password) {
        Pattern p = Pattern
                .compile("^[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]");
        Matcher m = p.matcher(password);

        return m.matches();
    }
}
