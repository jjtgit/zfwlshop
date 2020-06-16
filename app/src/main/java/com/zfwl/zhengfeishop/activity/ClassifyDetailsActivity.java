package com.zfwl.zhengfeishop.activity;
//分类的fragment
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.fragment.ClassifyPriceFragment;
import com.zfwl.zhengfeishop.fragment.ClassifySalesVolumeFragment;
import com.zfwl.zhengfeishop.fragment.ClassifySynthesizeFragment;

public class ClassifyDetailsActivity extends Base2Activity {

    private FrameLayout fragmentCsdetail;
    private ImageView returnCsdetails,priceLowRed,priceLowAsh,pricceHighAsh,pricceHighRed;
    private EditText editCsdetails;
    private TextView synthesizeCsderail,salesVolumeCsderail,priceCsderail;
    private RelativeLayout priceLayout;
    private ClassifySynthesizeFragment classifySynthesizeFragment;
    private ClassifySalesVolumeFragment classifySalesVolumeFragment;
    private ClassifyPriceFragment classifyPriceFragment;
    private FragmentTransaction fragmentTransaction;
    private int price=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_details);
        fragmentCsdetail=findViewById(R.id.fragment_csdetail);
        returnCsdetails=findViewById(R.id.return_csdetails);
        editCsdetails=findViewById(R.id.edit_csdetails);
        synthesizeCsderail=findViewById(R.id.synthesize_csderail);
        salesVolumeCsderail=findViewById(R.id.sales_volume_csderail);
        priceLayout=findViewById(R.id.price_layout);
        priceCsderail=findViewById(R.id.price_csderail);
        priceLowRed=findViewById(R.id.price_low_red);
        priceLowAsh=findViewById(R.id.price_low_ash);
        pricceHighAsh=findViewById(R.id.price_high_ash);
        pricceHighRed=findViewById(R.id.price_high_red);
        init();
    }

    private void init() {
        //获取fragment
        classifySynthesizeFragment = new ClassifySynthesizeFragment();
        classifySalesVolumeFragment = new ClassifySalesVolumeFragment();
        classifyPriceFragment = new ClassifyPriceFragment();
        //获取fragment的控制，默认展示综合
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_csdetail,classifySynthesizeFragment).show(classifySynthesizeFragment);
        fragmentTransaction.add(R.id.fragment_csdetail,classifySalesVolumeFragment).hide(classifySalesVolumeFragment);
        fragmentTransaction.add(R.id.fragment_csdetail,classifyPriceFragment).hide(classifyPriceFragment);
        fragmentTransaction.commit();
        //选择综合
        synthesizeCsderail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsynthesize();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.show(classifySynthesizeFragment)
                        .hide(classifySalesVolumeFragment)
                        .hide(classifyPriceFragment);
                fragmentTransaction.commit();
            }
        });
        //选择了销量
        salesVolumeCsderail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSalesVolume();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.show(classifySalesVolumeFragment)
                        .hide(classifySynthesizeFragment)
                        .hide(classifyPriceFragment);
                fragmentTransaction.commit();
            }
        });
        //选择了价格
        priceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price==1){
                    showPriceHigh();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.show(classifyPriceFragment)
                            .hide(classifySynthesizeFragment)
                            .hide(classifySalesVolumeFragment);
                    fragmentTransaction.commit();
                    price=2;
                    Toast.makeText(ClassifyDetailsActivity.this, "低到高", Toast.LENGTH_SHORT).show();
                }else if (price==2){
                    showPriceLow();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.show(classifyPriceFragment)
                            .hide(classifySynthesizeFragment)
                            .hide(classifySalesVolumeFragment);
                    fragmentTransaction.commit();
                    price=1;
                    Toast.makeText(ClassifyDetailsActivity.this, "高到低", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //返回
        returnCsdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //选择了综合
    private void showsynthesize() {
        synthesizeCsderail.setTextColor(this.getResources().getColor(R.color.colorSelect));
        salesVolumeCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        priceCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        pricceHighAsh.setVisibility(View.VISIBLE);
        pricceHighRed.setVisibility(View.GONE);
        priceLowAsh.setVisibility(View.VISIBLE);
        priceLowRed.setVisibility(View.GONE);
    }
    //选择了销量
    private void showSalesVolume() {
        synthesizeCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        salesVolumeCsderail.setTextColor(this.getResources().getColor(R.color.colorSelect));
        priceCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        pricceHighAsh.setVisibility(View.VISIBLE);
        pricceHighRed.setVisibility(View.GONE);
        priceLowAsh.setVisibility(View.VISIBLE);
        priceLowRed.setVisibility(View.GONE);
    }
    //选择了价格从低到高
    private void showPriceHigh() {
        synthesizeCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        salesVolumeCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        priceCsderail.setTextColor(this.getResources().getColor(R.color.colorSelect));
        pricceHighAsh.setVisibility(View.GONE);
        pricceHighRed.setVisibility(View.VISIBLE);
        priceLowAsh.setVisibility(View.VISIBLE);
        priceLowRed.setVisibility(View.GONE);
    }
    //选择了价格从高到低
    private void showPriceLow() {
        synthesizeCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        salesVolumeCsderail.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        priceCsderail.setTextColor(this.getResources().getColor(R.color.colorSelect));
        pricceHighAsh.setVisibility(View.VISIBLE);
        pricceHighRed.setVisibility(View.GONE);
        priceLowAsh.setVisibility(View.GONE);
        priceLowRed.setVisibility(View.VISIBLE);
    }
}
