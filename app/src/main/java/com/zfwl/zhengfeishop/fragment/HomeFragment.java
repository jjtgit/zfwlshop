package com.zfwl.zhengfeishop.fragment;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.transformers.Transformer;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.activity.GroupBookingActivity;
import com.zfwl.zhengfeishop.activity.IntegralShopActivity;
import com.zfwl.zhengfeishop.activity.LeadTroopsActivity;
import com.zfwl.zhengfeishop.activity.RankingListActivity;
import com.zfwl.zhengfeishop.activity.SearchActivity;
import com.zfwl.zhengfeishop.activity.StoreDetailsActivity;
import com.zfwl.zhengfeishop.activity.ThisLocalityCostumeActivity;
import com.zfwl.zhengfeishop.activity.ThisLocalityFreshActivity;
import com.zfwl.zhengfeishop.activity.ThisSupermarketActivity;
import com.zfwl.zhengfeishop.activity.TimeLimitActivity;
import com.zfwl.zhengfeishop.adapter.HomeIntegralAdapter;
import com.zfwl.zhengfeishop.adapter.HomeShopAdapter;
import com.zfwl.zhengfeishop.adapter.TimeLimitAdapter;
import com.zfwl.zhengfeishop.utils.AnimationNestedScrollView;
import com.zfwl.zhengfeishop.utils.CommonUtil;
import com.zfwl.zhengfeishop.utils.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements View.OnClickListener,ViewPager.OnPageChangeListener{

    private AnimationNestedScrollView sv_view;
    private LinearLayout ll_search,recommendLayout,preferenceLayout,electricLayout,cateLayout,freshLayout,costumeLayout,supermarketLayout,
            integralLayout,bookingLayout,rankingLayout,leadLayout,timeLimitLayout,timelimitMoreLayout,grouppurchaseMoreLayout,integralMoreLayout,
            messageHome;
    private TextView tv_title,nameRecommend,titleRecommend,namePreference,titlePreference,nameElectric,titleElectric,nameCate,titleCate;
    private View viewRecommend,viewPreference,viewElectric,viewCate;
    private List<String>listBanner;
    final ArrayList<String> list=new ArrayList<>();
    private float LL_SEARCH_MIN_TOP_MARGIN, LL_SEARCH_MAX_TOP_MARGIN, LL_SEARCH_MAX_WIDTH, LL_SEARCH_MIN_WIDTH, TV_TITLE_MAX_TOP_MARGIN;
    private ViewGroup.MarginLayoutParams searchLayoutParams, titleLayoutParams;
    private XBanner xbannerHome;
    private RecyclerView timelimitRv,shopRv,integralRv;
    private TimeLimitAdapter timeLimitAdapter;
    private LinearLayoutManager linearLayoutManager,linearLayoutManager1,linearLayoutManager2;
    private HomeShopAdapter homeShopAdapter;
    private HomeIntegralAdapter homeIntegralAdapter;
    private HomeRecommendFragment homeRecommendFragment;
    private HomePreferenceFragment homePreferenceFragment;
    private HomeElectricFragment homeElectricFragment;
    private HomeCateFragment homeCateFragment;
    private MyViewPager pageRecommend;
    private List<Fragment> fragmentList;
    private VpAdapter vpAdapter;

    @Override
    protected int getLayoutView() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        //获取id
        sv_view =view.findViewById (R.id.search_sv_view);
        ll_search =view.findViewById(R.id.search_ll_search);
        tv_title =view.findViewById(R.id.search_iv_back);
        xbannerHome=view.findViewById(R.id.xbanner_home);
        timelimitRv=view.findViewById(R.id.timelimit_rv);
        shopRv=view.findViewById(R.id.shop_rv);
        integralRv=view.findViewById(R.id.integral_rv);
        nameRecommend=view.findViewById(R.id.name_recommend);
        namePreference=view.findViewById(R.id.name_preference);
        nameElectric=view.findViewById(R.id.name_electric);
        nameCate=view.findViewById(R.id.name_cate );
        titleRecommend=view.findViewById(R.id.title_recommend);
        titlePreference=view.findViewById(R.id.title_preference);
        titleElectric=view.findViewById(R.id.title_electric);
        titleCate=view.findViewById(R.id.title_cate);
        viewRecommend=view.findViewById(R.id.view_recommend);
        viewPreference=view.findViewById(R.id.view_preference);
        viewElectric=view.findViewById(R.id.view_electric);
        viewCate=view.findViewById(R.id.view_cate);
        pageRecommend=view.findViewById(R.id.page_recommend);
        recommendLayout=view.findViewById(R.id.recommend_layout);
        preferenceLayout=view.findViewById(R.id.preference_layout);
        electricLayout=view.findViewById(R.id.electric_layout);
        cateLayout=view.findViewById(R.id.cate_layout);
        freshLayout=view.findViewById(R.id.fresh_layout);
        costumeLayout=view.findViewById(R.id.costume_layout);
        integralLayout=view.findViewById(R.id.integral_layout);
        bookingLayout=view.findViewById(R.id.booking_layout);
        supermarketLayout=view.findViewById(R.id.supermarket_layout);
        rankingLayout=view.findViewById(R.id.ranking_layout);
        leadLayout=view.findViewById(R.id.lead_layout);
        timeLimitLayout=view.findViewById(R.id.time_limit_layout);
        timelimitMoreLayout=view.findViewById(R.id.timelimit_more_layout);
        grouppurchaseMoreLayout=view.findViewById(R.id.grouppurchase_more_layout);
        integralMoreLayout=view.findViewById(R.id.integral_more_layout);
        messageHome=view.findViewById(R.id.message_home);
        pageRecommend.addOnPageChangeListener(this);
        preferenceLayout.setOnClickListener(this);
        electricLayout.setOnClickListener(this);
        recommendLayout.setOnClickListener(this);
        cateLayout.setOnClickListener(this);
        //获取四个fragment
        homeRecommendFragment = new HomeRecommendFragment();
        homePreferenceFragment = new HomePreferenceFragment();
        homeElectricFragment = new HomeElectricFragment();
        homeCateFragment = new HomeCateFragment();
        fragmentList=new ArrayList<>();
        fragmentList.add(homeRecommendFragment);
        fragmentList.add(homePreferenceFragment);
        fragmentList.add(homeElectricFragment);
        fragmentList.add(homeCateFragment);
        //限时秒杀
        linearLayoutManager = new LinearLayoutManager(getActivity());
        timeLimitAdapter = new TimeLimitAdapter(getActivity());
        //团购商城
        linearLayoutManager1 = new LinearLayoutManager(getActivity());
        homeShopAdapter = new HomeShopAdapter(getActivity());
        //积分商城
        linearLayoutManager2=new LinearLayoutManager(getActivity());
        homeIntegralAdapter = new HomeIntegralAdapter(getActivity());
        initis();

    }

    private void initis() {
        searchLayoutParams = (ViewGroup.MarginLayoutParams) ll_search.getLayoutParams();
        titleLayoutParams = (ViewGroup.MarginLayoutParams) tv_title.getLayoutParams();

        LL_SEARCH_MIN_TOP_MARGIN = CommonUtil.dp2px(getActivity(), 31f);//布局关闭时顶部距离
        LL_SEARCH_MAX_TOP_MARGIN = CommonUtil.dp2px(getActivity(), 79f);//布局默认展开时顶部距离
        LL_SEARCH_MAX_WIDTH = CommonUtil.getScreenWidth(getActivity()) - CommonUtil.dp2px(getActivity(), 30f);//布局默认展开时的宽度
        LL_SEARCH_MIN_WIDTH = CommonUtil.getScreenWidth(getActivity()) - CommonUtil.dp2px(getActivity(), 110f);//布局关闭时的宽度
        TV_TITLE_MAX_TOP_MARGIN = CommonUtil.dp2px(getActivity(), 20f);

        sv_view.setOnAnimationScrollListener(new AnimationNestedScrollView.OnAnimationScrollChangeListener() {
            @Override
            public void onScrollChanged(float dy) {
                float searchLayoutNewTopMargin = LL_SEARCH_MAX_TOP_MARGIN - dy;
                float searchLayoutNewWidth = LL_SEARCH_MAX_WIDTH - dy * 3f;//此处 * 1.3f 可以设置搜索框宽度缩放的速率

                float titleNewTopMargin = (float) (TV_TITLE_MAX_TOP_MARGIN - dy * 0.5);

                //处理布局的边界问题
                searchLayoutNewWidth = searchLayoutNewWidth < LL_SEARCH_MIN_WIDTH ? LL_SEARCH_MIN_WIDTH : searchLayoutNewWidth;

                if (searchLayoutNewTopMargin < LL_SEARCH_MIN_TOP_MARGIN) {
                    searchLayoutNewTopMargin = LL_SEARCH_MIN_TOP_MARGIN;
                }

                if (searchLayoutNewWidth < LL_SEARCH_MIN_WIDTH) {
                    searchLayoutNewWidth = LL_SEARCH_MIN_WIDTH;
                }

                float titleAlpha = 255 * titleNewTopMargin / TV_TITLE_MAX_TOP_MARGIN;
                if (titleAlpha < 0) {
                    titleAlpha = 0;
                }

                //设置相关控件的LayoutParams  此处使用的是MarginLayoutParams，便于设置params的topMargin属性
                tv_title.setTextColor(tv_title.getTextColors().withAlpha((int) titleAlpha));
                titleLayoutParams.topMargin = (int) titleNewTopMargin;
                tv_title.setLayoutParams(titleLayoutParams);

                searchLayoutParams.topMargin = (int) searchLayoutNewTopMargin;
                searchLayoutParams.width = (int) searchLayoutNewWidth;
                ll_search.setLayoutParams(searchLayoutParams);
            }
        });
        listBanner=new ArrayList<>();
        listBanner.add("http://img5.imgtn.bdimg.com/it/u=1308452466,3663840021&fm=26&gp=0.jpg");
        listBanner.add("http://img2.imgtn.bdimg.com/it/u=3922344982,423380743&fm=214&gp=0.jpg");
        listBanner.add("http://img1.cheshi-img.com/product/1_1024/p/60800/60849/5ea259b021877.jpg");
        listBanner.add("http://a4.att.hudong.com/22/59/19300001325156131228593878903.jpg");
        listBanner.add("http://e.hiphotos.baidu.com/zhidao/pic/item/d62a6059252dd42a1c362a29033b5bb5c9eab870.jpg");
        for (int i=0;i<listBanner.size();i++){
            String img= listBanner.get(i);
            list.add(img);
        }
        xbannerHome.setData(list,null);
        //调起
        xbannerHome.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(list.get(position))
                        .apply(new RequestOptions().error(R.mipmap.home_banner).placeholder(R.mipmap.home_banner))
                        .apply( RequestOptions.bitmapTransform(new RoundedCorners(20)))
                        .into((ImageView) view);
            }
        });
        //切换的动画
        xbannerHome.setPageTransformer(Transformer.Default);
        //点击事件
        xbannerHome.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, final int position) {
                Toast.makeText(getActivity(), "点击了第"+position, Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        timelimitRv.setLayoutManager(linearLayoutManager);
        timelimitRv.setAdapter(timeLimitAdapter);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        shopRv.setLayoutManager(linearLayoutManager1);
        shopRv.setAdapter(homeShopAdapter);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        integralRv.setLayoutManager(linearLayoutManager2);
        integralRv.setAdapter(homeIntegralAdapter);
        vpAdapter = new VpAdapter(getChildFragmentManager());
        pageRecommend.setAdapter(vpAdapter);
        //本地生鲜
        freshLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThisLocalityFreshActivity.class);
                getActivity().startActivity(intent);
            }
        });
        //本地服饰
        costumeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), ThisLocalityCostumeActivity.class));
            }
        });
        //本地超市
        supermarketLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), ThisSupermarketActivity.class));
            }
        });
        //拼团秒杀
        bookingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), GroupBookingActivity.class));
            }
        });
        //排行榜
        rankingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), RankingListActivity.class));
            }
        });
        //领劵中心
        leadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), LeadTroopsActivity.class));
            }
        });
        //积分商城
        integralLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), IntegralShopActivity.class));
            }
        });
        //限时抢购
        timeLimitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), TimeLimitActivity.class));
            }
        });
        ll_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });
        //限时更多
        timelimitMoreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), TimeLimitActivity.class));
            }
        });
        //团购更多
        grouppurchaseMoreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), GroupBookingActivity.class));
            }
        });
        //积分更多
        integralMoreLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), IntegralShopActivity.class));
            }
        });
        //信息
        messageHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), StoreDetailsActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }
    private void showRecommend() {
        //选中效果
        viewRecommend.setVisibility(View.VISIBLE);
        viewPreference.setVisibility(View.GONE);
        viewElectric.setVisibility(View.GONE);
        viewCate.setVisibility(View.GONE);
        //改变字体
        nameRecommend.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titleRecommend.setTextColor(this.getResources().getColor(R.color.colorSelect));
        namePreference.setTextColor(this.getResources().getColor(R.color.unselected));
        titlePreference.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        nameElectric.setTextColor(this.getResources().getColor(R.color.unselected));
        titleElectric.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        nameCate.setTextColor(this.getResources().getColor(R.color.unselected));
        titleCate.setTextColor(this.getResources().getColor(R.color.colorUnselected));
    }
    private void showPreference() {
        //选中效果
        viewRecommend.setVisibility(View.GONE);
        viewPreference.setVisibility(View.VISIBLE);
        viewElectric.setVisibility(View.GONE);
        viewCate.setVisibility(View.GONE);
        //改变字体
        nameRecommend.setTextColor(this.getResources().getColor(R.color.unselected));
        titleRecommend.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        namePreference.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titlePreference.setTextColor(this.getResources().getColor(R.color.colorSelect));
        nameElectric.setTextColor(this.getResources().getColor(R.color.unselected));
        titleElectric.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        nameCate.setTextColor(this.getResources().getColor(R.color.unselected));
        titleCate.setTextColor(this.getResources().getColor(R.color.colorUnselected));
    }
    private void showElectric() {
        //选中效果
        viewRecommend.setVisibility(View.GONE);
        viewPreference.setVisibility(View.GONE);
        viewElectric.setVisibility(View.VISIBLE);
        viewCate.setVisibility(View.GONE);
        //改变字体
        nameRecommend.setTextColor(this.getResources().getColor(R.color.unselected));
        titleRecommend.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        namePreference.setTextColor(this.getResources().getColor(R.color.unselected));
        titlePreference.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        nameElectric.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titleElectric.setTextColor(this.getResources().getColor(R.color.colorSelect));
        nameCate.setTextColor(this.getResources().getColor(R.color.unselected));
        titleCate.setTextColor(this.getResources().getColor(R.color.colorUnselected));
    }
    private void showCate() {
        //选中效果
        viewRecommend.setVisibility(View.GONE);
        viewPreference.setVisibility(View.GONE);
        viewElectric.setVisibility(View.GONE);
        viewCate.setVisibility(View.VISIBLE);
        //改变字体
        nameRecommend.setTextColor(this.getResources().getColor(R.color.unselected));
        titleRecommend.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        namePreference.setTextColor(this.getResources().getColor(R.color.unselected));
        titlePreference.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        nameElectric.setTextColor(this.getResources().getColor(R.color.unselected));
        titleElectric.setTextColor(this.getResources().getColor(R.color.colorUnselected));
        nameCate.setTextColor(this.getResources().getColor(R.color.colorSelect));
        titleCate.setTextColor(this.getResources().getColor(R.color.colorSelect));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.recommend_layout:
                pageRecommend.setCurrentItem(0);
                break;
            case R.id.preference_layout:
                pageRecommend.setCurrentItem(1);
                break;
            case R.id.electric_layout:
                pageRecommend.setCurrentItem(2);
                break;
            case R.id.cate_layout:
                pageRecommend.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                showRecommend();
                break;
            case 1:
                showPreference();
                break;
            case 2:
                showElectric();
                break;
            case 3:
                showCate();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


}
