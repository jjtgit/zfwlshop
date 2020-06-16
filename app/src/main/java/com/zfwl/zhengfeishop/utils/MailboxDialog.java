package com.zfwl.zhengfeishop.utils;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;

/**
 * Created by 修梦 on 2020/6/10.
 * Describe:自定义diaog
 */
public class MailboxDialog extends Dialog implements View.OnClickListener {

    private TextView homeDialog;
    private TextView submitTxt;
    private TextView cancelTxt;


    private Context mContext;
    private String content;
    private OnCloseListener listener;
    private String positiveName;
    private String negativeName;
    private String title;


    public MailboxDialog(Context context, int themeResId, String content, OnCloseListener listener) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
        this.listener = listener;
    }



    public MailboxDialog setTitle(String title){
        this.title = title;
        return this;
    }


    public MailboxDialog setPositiveButton(String name){
        this.positiveName = name;
        return this;
    }


    public MailboxDialog setNegativeButton(String name){
        this.negativeName = name;
        return this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_mailbox_layout);
        setCanceledOnTouchOutside(false);
        initView();
    }


    private void initView(){
        homeDialog = (TextView)findViewById(R.id.home_dialog);
        submitTxt = (TextView)findViewById(R.id.submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView)findViewById(R.id.cancel);
        cancelTxt.setOnClickListener(this);


        if(!TextUtils.isEmpty(positiveName)){
            submitTxt.setText(positiveName);
        }


        if(!TextUtils.isEmpty(negativeName)){
            cancelTxt.setText(negativeName);
        }


        if(!TextUtils.isEmpty(title)){
            homeDialog.setText(title);
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                if(listener != null){
                    listener.onClick(this, false);
                }
                this.dismiss();
                break;
            case R.id.submit:
                if(listener != null){
                    listener.onClick(this, true);
                    ClipboardManager cmb = (ClipboardManager)mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    cmb.setText(content.trim());
                    // 创建一个剪贴数据集，包含一个普通文本数据条目（需要复制的数据）
                    ClipData clipData = ClipData.newPlainText(null, content);
                    // 把数据集设置（复制）到剪贴板
                    cmb.setPrimaryClip(clipData);
                    Toast.makeText(mContext, "复制成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    public interface OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    }

}
