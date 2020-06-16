package com.zfwl.zhengfeishop.fragment;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.adapter.ClassifyItemAdapter;
import com.zfwl.zhengfeishop.bean.ClassSideslipBean;

/**
 * Created by 修梦 on 2020/4/17.
 * Describe:动态的fragment类
 */
public class ContentFragment extends BaseFragment {

    private RecyclerView rvContent;
    private ClassifyItemAdapter classifyItemAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.contentfragment;
    }

    @Override
    protected void initView(View view) {
        rvContent=view.findViewById(R.id.rv_content);
        ClassSideslipBean.DatasBean classfy = (ClassSideslipBean.DatasBean) getArguments().getSerializable("classfy");
        classifyItemAdapter = new ClassifyItemAdapter(getActivity());
        rvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContent.setAdapter(classifyItemAdapter);
    }

    @Override
    protected void initData() {

    }
}
