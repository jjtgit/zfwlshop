package com.zfwl.zhengfeishop.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.utils.CommomDialog;
import com.zfwl.zhengfeishop.utils.MailboxDialog;

public class ContactActivity extends Base2Activity {

    private LinearLayout returnContact,homeMoreContact,mailboxMoreContact;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        returnContact=findViewById(R.id.return_contact);
        homeMoreContact=findViewById(R.id.home_more_contact);
        mailboxMoreContact=findViewById(R.id.mailbox_more_contact);
        initData();
    }

    private void initData() {
        //手机号
        homeMoreContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CommomDialog commomDialog  = new CommomDialog(ContactActivity.this, R.style.DialogTheme, "手机号", new CommomDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, boolean confirm) {
                        dialog.dismiss();
                    }
                });
                commomDialog.setTitle("18653125098").show();
            }
        });
        //邮箱复制
        mailboxMoreContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MailboxDialog mailboxDialog = new MailboxDialog(ContactActivity.this, R.style.DialogTheme, "zhenfei@sc.com.cn", new MailboxDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, boolean confirm) {
                        dialog.dismiss();
                    }
                });
                mailboxDialog.setTitle("zhenfei@sc.com.cn").show();
            }
        });
        //返回
        returnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
