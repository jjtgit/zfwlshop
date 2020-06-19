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

public class AmendpassDetailsActivity extends Base2Activity {

    private LinearLayout returnDetails;
    private EditText passwordEddetails,affirmPasswordEddetails;
    private TextView notConfirmDetails,confirmTextDetails;
    private int pd=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amendpass_details);
        returnDetails=findViewById(R.id.return_details);
        passwordEddetails=findViewById(R.id.password_eddetails);
        affirmPasswordEddetails=findViewById(R.id.affirm_password_eddetails);
        notConfirmDetails=findViewById(R.id.not_confirm_details);
        confirmTextDetails=findViewById(R.id.confirm_text_details);
        init();
    }

    private void init() {
        passwordEddetails.addTextChangedListener(new TextWatcher() {
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
                    affirmPasswordEddetails.addTextChangedListener(new TextWatcher() {
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
                                    confirmTextDetails.setVisibility(View.VISIBLE);
                                    notConfirmDetails.setVisibility(View.GONE);
                                }else {
                                    confirmTextDetails.setVisibility(View.GONE);
                                    notConfirmDetails.setVisibility(View.VISIBLE);
                                }
                            }else {
                                confirmTextDetails.setVisibility(View.GONE);
                                notConfirmDetails.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }else {
                    pd=0;
                }
            }
        });
        //确定
        confirmTextDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ispsd(passwordEddetails.getText().toString())){
                    Toast.makeText(AmendpassDetailsActivity.this, "密码不可为单一的字母或数字", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!passwordEddetails.getText().toString().equals(affirmPasswordEddetails.getText().toString())){
                    Toast.makeText(AmendpassDetailsActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(AmendpassDetailsActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AmendpassDetailsActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });
        //返回
        returnDetails.setOnClickListener(new View.OnClickListener() {
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
