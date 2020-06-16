package com.zfwl.zhengfeishop.utils;

import android.app.Dialog;
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
public class CommomDialog extends Dialog implements View.OnClickListener {

    private TextView homeDialog;
    private TextView submitTxt;
    private TextView cancelTxt;


    private Context mContext;
    private String content;
    private OnCloseListener listener;
    private String positiveName;
    private String negativeName;
    private String title;


    public CommomDialog(Context context, int themeResId, String content, OnCloseListener listener) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
        this.listener = listener;
    }



    public CommomDialog setTitle(String title){
        this.title = title;
        return this;
    }


    public CommomDialog setPositiveButton(String name){
        this.positiveName = name;
        return this;
    }


    public CommomDialog setNegativeButton(String name){
        this.negativeName = name;
        return this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_commom_layout);
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
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:" + "18653125098");
                    intent.setData(data);
                    mContext.startActivity(intent);
                }
                break;
        }
    }


    public interface OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    }

}
