package com.zfwl.zhengfeishop.fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;


import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.ClassSideslipAdapter;
import com.zfwl.zhengfeishop.bean.ClassSideslipBean;

import java.util.List;

/**
 * Created by 修梦 on 2020/4/16.
 * Describe:
 */
public class ClassifyFragment extends BaseFragment implements ClassSideslipAdapter.onClike{

    private RecyclerView rvClass;
    private FrameLayout fragmentClass;
    private ClassSideslipAdapter classSideslipAdapter;
    private ClassSideslipBean classSideslipBean;
    private List<ClassSideslipBean.DatasBean> datas;
    private ContentFragment contentFragment;

    @Override
    protected int getLayoutView() {
        return R.layout.classify_fragment;
    }

    @Override
    protected void initView(View view) {
        rvClass=view.findViewById(R.id.rv_class);
        fragmentClass=view.findViewById(R.id.fragment_class);
        classSideslipAdapter = new ClassSideslipAdapter(getActivity());
        rvClass.setLayoutManager(new LinearLayoutManager(getActivity()));
        classSideslipAdapter.setmOnClike(this);
        init();
    }

    private void init() {
        //模拟数据
        String response = "{\"datas\": [{\"id\": \"56\",\"showName\": \"清新\"},{\"id\": \"57\",\"showName\": \"复古\"},{\"id\": \"58\", \"showName\": \"古风\"},{\"id\": \"59\", \"showName\": \"盐系\"},{ \"id\": \"141\", \"showName\": \"暗黑\"},{  \"id\": \"62\", \"showName\": \"花草\"},{\"id\": \"63\", \"showName\": \"复杂分飞\"}," +
                "{ \"id\": \"64\", \"showName\": \"人物\" },{ \"id\": \"65\",  \"showName\": \"文字字母\"},{\"id\": \"67\", \"showName\": \"基础款\"},{\"id\": \"68\",\"showName\": \"风景\"},{ \"id\": \"70\", \"showName\": \"动物\"},{ \"id\": \"71\", \"showName\": \"动物啥\"},{ \"id\": \"72\", \"showName\": \"动物们\"}]}\n";
        classSideslipBean = new Gson().fromJson(response, ClassSideslipBean.class);
        datas = classSideslipBean.getDatas();
        dealWithData(datas);
    }

    private void dealWithData(List<ClassSideslipBean.DatasBean> datas) {
        classSideslipAdapter.setList(datas);
        rvClass.setAdapter(classSideslipAdapter);
        datas.get(0).setChick(true);
        //创建fragment
        contentFragment = new ContentFragment();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_class,contentFragment);
        //传递数据
        Bundle bundle = new Bundle();
        bundle.putSerializable("classfy",datas.get(0));
        contentFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClikes(View view, int i) {
        ClassSideslipBean.DatasBean datasBean = datas.get(i);
        for (int j=0;j<datas.size();j++){
            if (datas.get(j).getShowName().equals(datasBean.getShowName())){
                datas.get(j).setChick(true);
            }else {
                datas.get(j).setChick(false);
            }
        }
        //刷新
        classSideslipAdapter.notifyDataSetChanged();
        String showName = datas.get(i).getShowName();
        Toast.makeText(getActivity(), showName, Toast.LENGTH_SHORT).show();
        //创建fragment
        contentFragment = new ContentFragment();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_class,contentFragment);
        //传递数据
        Bundle bundle = new Bundle();
        bundle.putSerializable("classfy",datas.get(i));
        contentFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }
}
