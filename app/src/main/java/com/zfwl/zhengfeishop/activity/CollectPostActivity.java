package com.zfwl.zhengfeishop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.CollectShopAdapter;
import com.zfwl.zhengfeishop.bean.CollectShopBean;

import java.util.ArrayList;
import java.util.List;

public class CollectPostActivity extends Base2Activity implements View.OnClickListener, CollectShopAdapter.OnItemClickListener {

    private ImageView returnColleccct;
    private TextView checkAllColleccct,buttenCollect,deleteImgColleccct;
    private LinearLayout butten;
    private RecyclerView rvCollect;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private CollectShopAdapter collectShopAdapter=null;
    private List<CollectShopBean> listshop=new ArrayList<>();
    private int mEditMode = MYLIVE_MODE_CHECK;
    private boolean isSelectAll = false;
    private boolean editorStatus = false;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_post);
        returnColleccct=findViewById(R.id.return_colleccct);
        deleteImgColleccct=findViewById(R.id.delete_img_colleccct);
        checkAllColleccct=findViewById(R.id.check_all_colleccct);
        rvCollect=findViewById(R.id.rv_collect);
        butten=findViewById(R.id.butten);
        buttenCollect=findViewById(R.id.butten_collect);
        //设置点击事件
        deleteImgColleccct.setOnClickListener(this);
        checkAllColleccct.setOnClickListener(this);
        butten.setOnClickListener(this);
        buttenCollect.setOnClickListener(this);
        initData();
    }

    private void initData() {

        collectShopAdapter = new CollectShopAdapter(this);
        collectShopAdapter.setOnItemClickListener(this);
        rvCollect.setLayoutManager(new LinearLayoutManager(this));
        rvCollect.setAdapter(collectShopAdapter);
        for (int i=0;i<10;i++){
            CollectShopBean shopBean = new CollectShopBean();
            shopBean.setNameShop("曼秀雷敦新碧轻透防晒凝乳水男秀雷敦女"+i);
            shopBean.setSubtractCollect("满200减5"+i);
            shopBean.setPriceCollect("5"+i);
            listshop.add(shopBean);
            collectShopAdapter.notifyAdapter(listshop,false);
        }
        //返回
        returnColleccct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.delete_img_colleccct:
                updataEditMode();
                break;
            case R.id.check_all_colleccct:
                selectAllMain();
                break;
            case R.id.butten_collect:
                deleteItem();
                break;
        }
    }
    //删除
    private void deleteItem() {
        for (int i = collectShopAdapter.getListshop().size(), j =0 ; i > j; i--) {
            CollectShopBean collectShopBean = collectShopAdapter.getListshop().get(i - 1);
            if (collectShopBean.isSelect()) {
                collectShopAdapter.getListshop().remove(collectShopBean);
                index--;
            }
        }
        index = 0;
        collectShopAdapter.notifyDataSetChanged();
    }

    //全选
    private void selectAllMain() {
        if (collectShopAdapter==null) return;
        if (!isSelectAll){
            for (int i = 0,j =collectShopAdapter.getListshop().size() ; i<j;i++) {
                collectShopAdapter.getListshop().get(i).setSelect(true);
            }
            index=collectShopAdapter.getListshop().size();
            checkAllColleccct.setText("取消全选");
            isSelectAll=true;
        }else {
            for (int i = 0,j=collectShopAdapter.getListshop().size(); i < j; i++) {
                collectShopAdapter.getListshop().get(i).setSelect(false);
            }
            index=0;
            checkAllColleccct.setText("全选");
            isSelectAll=false;
        }
        collectShopAdapter.notifyDataSetChanged();
    }
    //显示全选
    private void updataEditMode() {
        mEditMode = mEditMode == MYLIVE_MODE_CHECK ? MYLIVE_MODE_EDIT : MYLIVE_MODE_CHECK;
        if (mEditMode==MYLIVE_MODE_EDIT){
            deleteImgColleccct.setText("取消");
            checkAllColleccct.setVisibility(View.VISIBLE);
            butten.setVisibility(View.VISIBLE);
            for (int i = 0,j=collectShopAdapter.getListshop().size(); i < j; i++) {
                collectShopAdapter.getListshop().get(i).setSelect(false);
            }
            index=0;
            isSelectAll=false;
            editorStatus=true;
        }else {
            deleteImgColleccct.setText("编辑");
            checkAllColleccct.setVisibility(View.GONE);
            butten.setVisibility(View.GONE);
            editorStatus=false;
        }
        collectShopAdapter.setEditMode(mEditMode);
    }

    @Override
    public void onItemClickListener(int pos, List<CollectShopBean> listshop) {
        if (editorStatus){
            CollectShopBean collectShopBean = listshop.get(pos);
            boolean select = collectShopBean.isSelect();
            if (!select){
                index++;
                collectShopBean.setSelect(true);
                if (index==listshop.size()){
                    isSelectAll=true;
                    checkAllColleccct.setText("取消全选");
                }
            }else {
                collectShopBean.setSelect(false);
                index--;
                isSelectAll=false;
                checkAllColleccct.setText("全选");
            }
            collectShopAdapter.notifyDataSetChanged();
        }
    }
}
