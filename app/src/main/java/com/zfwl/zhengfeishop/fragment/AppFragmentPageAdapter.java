package com.zfwl.zhengfeishop.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 修梦 on 2020/5/13.
 * Describe:fragment的适配器
 */
public class AppFragmentPageAdapter extends FragmentPagerAdapter {

    public List<Fragment> mFragmentList;

    public AppFragmentPageAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        mFragmentList=fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList==null?null:mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList==null?0:mFragmentList.size();
    }
}
