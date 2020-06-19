package com.zfwl.zhengfeishop.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SignActivity extends Base2Activity {

    private EditText phoneEdit,verificationCodeEdit;
    private TextView sendCode,verificationCode,notNextstepButton,nextstepButton;
    private LinearLayout returnSign;
    private CountDownTimer timer;
    private int pd=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams. SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_sign);
        phoneEdit=findViewById(R.id.phone_edit);
        verificationCodeEdit=findViewById(R.id.verification_code_edit);
        sendCode=findViewById(R.id.send_code);
        verificationCode=findViewById(R.id.verification_code);
        notNextstepButton=findViewById(R.id.not_nextstep_button);
        nextstepButton=findViewById(R.id.nextstep_button);
        returnSign=findViewById(R.id.return_sign);
        init();
    }

    private void init() {
        //倒计时
        timer= new CountDownTimer(5*1000,1000){

            @Override
            public void onTick(long l) {
                verificationCode.setText("重新发送("+l/1000+")");
            }

            @Override
            public void onFinish() {
                sendCode.setVisibility(View.VISIBLE);
                verificationCode.setVisibility(View.GONE);
            }
        };
        //下一步
        phoneEdit.addTextChangedListener(new TextWatcher() {
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
                    verificationCodeEdit.addTextChangedListener(new TextWatcher() {
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
                                    notNextstepButton.setVisibility(View.VISIBLE);
                                    nextstepButton.setVisibility(View.GONE);
                                }else {
                                    notNextstepButton.setVisibility(View.GONE);
                                    nextstepButton.setVisibility(View.VISIBLE);
                                }
                            }else {
                                notNextstepButton.setVisibility(View.GONE);
                                nextstepButton.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }else {
                    pd=0;
                }
            }
        });

        nextstepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneEdit.getText().toString();
                String verification = verificationCodeEdit.getText().toString();
                if (phone.equals("")){
                    Toast.makeText(SignActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }else if (verification.equals("")){
                    Toast.makeText(SignActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }else {
                    notNextstepButton.setVisibility(View.GONE);
                    nextstepButton.setVisibility(View.VISIBLE);
                }
            }
        });
        //发送验证码
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phoneEdit.getText().equals("")){
                    Toast.makeText(SignActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }else if (!isChinaPhoneLegal( phoneEdit.getText().toString())){
                    Toast.makeText(SignActivity.this, "手机号不正确", Toast.LENGTH_SHORT).show();
                } else {
                    verificationCode.setVisibility(View.VISIBLE);
                    sendCode.setVisibility(View.GONE);
                   timer.start();
                }
            }
        });

        //展示下一步
        notNextstepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignActivity.this,SignDetailsActivity.class));
            }
        });
        //返回
        returnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
