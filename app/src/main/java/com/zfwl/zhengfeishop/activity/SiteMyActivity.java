package com.zfwl.zhengfeishop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.bean.ShoppingCarDataBean;
import com.zfwl.zhengfeishop.utils.JDCityPicker;
import com.zfwl.zhengfeishop.utils.RoundCornerDialog;

import java.util.List;


public class SiteMyActivity extends Base2Activity {

    private ImageView returnMysite,deleteImgSite,selectImg,notImg;
    private TextView buttenSite,regionText,titleHeader;
    private EditText nameEdit,homeEdit,detailedAddressEdit;
    public JDCityPicker jdCityPicker;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_my);
        intent = getIntent();
        int pd = getIntent().getIntExtra("pd", 0);
        String namesite = intent.getStringExtra("namesite");
        String cellphonesite = intent.getStringExtra("cellphonesite");
        int defaultsite = intent.getIntExtra("defaultsite", 0);
        String sites = intent.getStringExtra("sites");
        String titlesite = intent.getStringExtra("titlesite");
        returnMysite=findViewById(R.id.return_mysite);
        deleteImgSite=findViewById(R.id.delete_img_site);
        selectImg=findViewById(R.id.select_img);
        notImg=findViewById(R.id.not_img);
        buttenSite=findViewById(R.id.butten_site);
        nameEdit=findViewById(R.id.name_edit);
        homeEdit=findViewById(R.id.home_edit);
        regionText=findViewById(R.id.region_text);
        detailedAddressEdit=findViewById(R.id.detailed_address_edit);
        titleHeader=findViewById(R.id.title_header);
        if (pd==0){
            titleHeader.setText("新建收货地址");
            deleteImgSite.setVisibility(View.GONE);
        }else if (pd==1){
            deleteImgSite.setVisibility(View.VISIBLE);
            titleHeader.setText("编辑收货地址");
            nameEdit.setText(namesite);
            homeEdit.setText(cellphonesite);
            regionText.setText(sites);
            detailedAddressEdit.setText(titlesite);
            if (defaultsite==0){
                selectImg.setVisibility(View.VISIBLE);
                notImg.setVisibility(View.GONE);
            }else {
                selectImg.setVisibility(View.GONE);
                notImg.setVisibility(View.VISIBLE);
            }
        }
        init();
    }

    private void init() {
        //选择地址
        regionText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                bgAlpha(0.7f);
                jdCityPicker = new JDCityPicker(SiteMyActivity.this, new JDCityPicker.onCitySelect() {
                    @Override
                    public void onSelect(String province, String city, String area) {
                        regionText.setText(province + city + area);
                    }
                });
                jdCityPicker.showAtLocation(regionText, Gravity.BOTTOM, 0, 0);

                jdCityPicker.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        bgAlpha(1.0f);
                    }
                });

            }
        });
        //设置为默认
        notImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImg.setVisibility(View.VISIBLE);
                notImg.setVisibility(View.GONE);
            }
        });
        //设置为不默认
        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImg.setVisibility(View.GONE);
                notImg.setVisibility(View.VISIBLE);
            }
        });
        //删除
        deleteImgSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDeleteDialog();
            }
        });
        //返回
        returnMysite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //背景变暗
    private void bgAlpha(float f) {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.alpha = f;
        getWindow().setAttributes(layoutParams);
    }
    //删除弹框
    private void showDeleteDialog() {
        View view = View.inflate(SiteMyActivity.this, R.layout.dialog_two_btn, null);
        final RoundCornerDialog roundCornerDialog = new RoundCornerDialog(SiteMyActivity.this, 0, 0, view, R.style.RoundCornerDialog);
        roundCornerDialog.show();
        roundCornerDialog.setCanceledOnTouchOutside(true);// 设置点击屏幕Dialog不消失
        roundCornerDialog.setOnKeyListener(keylistener);//设置点击返回键Dialog不消失

        TextView tv_message = (TextView) view.findViewById(R.id.tv_message);
        TextView tv_logout_confirm = (TextView) view.findViewById(R.id.tv_logout_confirm);
        TextView tv_logout_cancel = (TextView) view.findViewById(R.id.tv_logout_cancel);
        tv_message.setText("是否删除该地址？");

        //确定
        tv_logout_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundCornerDialog.dismiss();
                Toast.makeText(SiteMyActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        //取消
        tv_logout_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundCornerDialog.dismiss();
            }
        });
    }
    DialogInterface.OnKeyListener keylistener = new DialogInterface.OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                return true;
            } else {
                return false;
            }
        }
    };
}
