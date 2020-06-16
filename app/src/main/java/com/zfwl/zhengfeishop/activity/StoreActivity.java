package com.zfwl.zhengfeishop.activity;
//收藏的店铺
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.StoreAdapter;
import com.zfwl.zhengfeishop.bean.CollectShopBean;
import com.zfwl.zhengfeishop.bean.StoreAdapterBean;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends Base2Activity implements View.OnClickListener, StoreAdapter.OnItemClickListener {

    private ImageView returnStore;
    private TextView deleteImgStore,checkAllStore,textStore;
    private RecyclerView rvStore;
    private LinearLayout buttenStore;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private StoreAdapter storeAdapter=null;
    private List<StoreAdapterBean> liststore=new ArrayList<>();
    private int mEditMode = MYLIVE_MODE_CHECK;
    private boolean isSelectAll = false;
    private boolean editorStatus = false;
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        returnStore=findViewById(R.id.return_store);
        deleteImgStore=findViewById(R.id.delete_img_store);
        checkAllStore=findViewById(R.id.check_all_store);
        textStore=findViewById(R.id.text_store);
        rvStore=findViewById(R.id.rv_store);
        buttenStore=findViewById(R.id.butten_store);
        storeAdapter=new StoreAdapter(this);
        //设置点击事件
        deleteImgStore.setOnClickListener(this);
        checkAllStore.setOnClickListener(this);
        textStore.setOnClickListener(this);
        storeAdapter.setOnItemClickListener(this);
        initData();
    }

    private void initData() {
        rvStore.setLayoutManager(new LinearLayoutManager(this));
        rvStore.setAdapter(storeAdapter);
        for (int i=0;i<10;i++){
            StoreAdapterBean storeAdapterBean = new StoreAdapterBean();
            storeAdapterBean.setNameShopStore("珀莱雅官方旗舰店"+i);
            storeAdapterBean.setAttentionStore(i+"7.1万人关注");
            storeAdapterBean.setLabelStore1("促销");
            storeAdapterBean.setLabelStore2("上新");
            liststore.add(storeAdapterBean);
            storeAdapter.notifyAdapter(liststore,false);
        }
        //返回
        returnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.delete_img_store:
                updataEditMode();
                break;
            case R.id.check_all_store:
                selectAllMain();
                break;
            case R.id.text_store:
                deleteItem();
                break;
        }
    }

    private void deleteItem() {
        for (int i = storeAdapter.getListstore().size(), j =0 ; i > j; i--) {
            StoreAdapterBean storeAdapterBean = storeAdapter.getListstore().get(i - 1);
            if (storeAdapterBean.isSelect()) {
                storeAdapter.getListstore().remove(storeAdapterBean);
                index--;
            }
        }
        index = 0;
        storeAdapter.notifyDataSetChanged();
    }

    //全选
    private void selectAllMain() {
        if (storeAdapter==null) return;
        if (!isSelectAll){
            for (int i = 0,j =storeAdapter.getListstore().size() ; i<j;i++) {
                storeAdapter.getListstore().get(i).setSelect(true);
            }
            index=storeAdapter.getListstore().size();
            checkAllStore.setText("取消全选");
            isSelectAll=true;
        }else {
            for (int i = 0,j=storeAdapter.getListstore().size(); i < j; i++) {
                storeAdapter.getListstore().get(i).setSelect(false);
            }
            index=0;
            checkAllStore.setText("全选");
            isSelectAll=false;
        }
        storeAdapter.notifyDataSetChanged();
    }

    //显示全部
    private void updataEditMode() {
        mEditMode = mEditMode == MYLIVE_MODE_CHECK ? MYLIVE_MODE_EDIT : MYLIVE_MODE_CHECK;
        if (mEditMode==MYLIVE_MODE_EDIT){
            deleteImgStore.setText("取消");
            checkAllStore.setVisibility(View.VISIBLE);
            buttenStore.setVisibility(View.VISIBLE);
            for (int i = 0,j=storeAdapter.getListstore().size(); i < j; i++) {
                storeAdapter.getListstore().get(i).setSelect(false);
            }
            index=0;
            isSelectAll=false;
            editorStatus=true;
        }else {
            deleteImgStore.setText("编辑");
            checkAllStore.setVisibility(View.GONE);
            buttenStore.setVisibility(View.GONE);
            editorStatus=false;
        }
        storeAdapter.setEditMode(mEditMode);
    }

    @Override
    public void onItemClickListener(int pos, List<StoreAdapterBean> listshop) {
        if (editorStatus){
            StoreAdapterBean storeAdapterBean = listshop.get(pos);
            boolean select = storeAdapterBean.isSelect();
            if (!select){
                index++;
                storeAdapterBean.setSelect(true);
                if (index==listshop.size()){
                    isSelectAll=true;
                    checkAllStore.setText("取消全选");
                }
            }else {
                storeAdapterBean.setSelect(false);
                index--;
                isSelectAll=false;
                checkAllStore.setText("全选");
            }
            storeAdapter.notifyDataSetChanged();
        }
    }
}
