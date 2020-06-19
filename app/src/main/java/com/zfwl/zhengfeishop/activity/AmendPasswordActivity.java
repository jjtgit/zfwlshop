package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import java.util.regex.PatternSyntaxException;

public class AmendPasswordActivity extends Base2Activity {

    private LinearLayout returnAmend;
    private EditText phoneEdamend,verificationCodeEdamend;
    private TextView verificationCode,notConfirmText,confirmText,sendCodeAmend,verificationCodeAmend;
    private int pd=0;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amend_password);
        returnAmend=findViewById(R.id.return_amend);
        phoneEdamend=findViewById(R.id.phone_edamend);
        verificationCodeEdamend=findViewById(R.id.verification_code_edamend);
        confirmText=findViewById(R.id.confirm_text);
        notConfirmText=findViewById(R.id.not_confirm_text);
        sendCodeAmend=findViewById(R.id.send_code_amend);
        verificationCodeAmend=findViewById(R.id.verification_code_amend);
        init();
    }

    private void init() {
        //倒计时
        timer= new CountDownTimer(5*1000,1000){

            @Override
            public void onTick(long l) {
                verificationCodeAmend.setText("重新发送("+l/1000+")");
            }

            @Override
            public void onFinish() {
                sendCodeAmend.setVisibility(View.VISIBLE);
                verificationCodeAmend.setVisibility(View.GONE);
            }
        };
        //手机号
        phoneEdamend.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().equals("")){
                   pd=1;
                    //验证码
                    verificationCodeEdamend.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if (!editable.toString().equals("")){
                                if (pd==1){
                                    confirmText.setVisibility(View.VISIBLE);
                                    notConfirmText.setVisibility(View.GONE);
                                }else {
                                    confirmText.setVisibility(View.GONE);
                                    notConfirmText.setVisibility(View.VISIBLE);
                                }
                            }else {
                                confirmText.setVisibility(View.GONE);
                                notConfirmText.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }else {
                   pd=0;
                }
            }
        });

        //发送验证码
        sendCodeAmend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phoneEdamend.getText().toString().equals("")){
                    Toast.makeText(AmendPasswordActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if (!isChinaPhoneLegal(phoneEdamend.getText().toString())){
                    Toast.makeText(AmendPasswordActivity.this, "手机号错误", Toast.LENGTH_SHORT).show();
                }else {
                    sendCodeAmend.setVisibility(View.GONE);
                    verificationCodeAmend.setVisibility(View.VISIBLE);
                    timer.start();
                }
            }
        });
        //返回
        returnAmend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //下一步
        confirmText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AmendPasswordActivity.this,AmendpassDetailsActivity.class));
            }
        });
    }
    public static boolean isChinaPhoneLegal(String str)
            throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
