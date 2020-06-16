package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.transformers.Transformer;
import com.zfwl.zhengfeishop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/23.
 * Describe:分类右侧数据adapter
 */
public class ClassifyItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    public Context context;
    private final int BANNER = 0;
    private final int HOT = 1;
    private List<String> listBanner;
    ArrayList<String> list=new ArrayList<>();
    private int mPosition;

    public ClassifyItemAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==BANNER){
            view = LayoutInflater.from(context).inflate(R.layout.classify_item, parent, false);
            return new ViewHolderBanner(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.classify_itme1, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==BANNER){
            listBanner=new ArrayList<>();
            listBanner.add("http://img5.imgtn.bdimg.com/it/u=1308452466,3663840021&fm=26&gp=0.jpg");
            listBanner.add("http://img2.imgtn.bdimg.com/it/u=3922344982,423380743&fm=214&gp=0.jpg");
            listBanner.add("http://img1.cheshi-img.com/product/1_1024/p/60800/60849/5ea259b021877.jpg");
            listBanner.add("http://a4.att.hudong.com/22/59/19300001325156131228593878903.jpg");
            listBanner.add("http://e.hiphotos.baidu.com/zhidao/pic/item/d62a6059252dd42a1c362a29033b5bb5c9eab870.jpg");
            for (int i=0;i<listBanner.size();i++){
                String img= listBanner.get(i);
                if (i==0){
                    list.clear();
                    list.add(img);
                }else {
                    list.add(img);
                }
            }
            ((ViewHolderBanner)holder).xbnnerClassify.setData(list,null);
            //调起
            ((ViewHolderBanner)holder).xbnnerClassify.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(context).load(list.get(position))
                            .apply(new RequestOptions().error(R.mipmap.home_banner).placeholder(R.mipmap.home_banner))
                            .apply( RequestOptions.bitmapTransform(new RoundedCorners(8)))
                            .into((ImageView) view);
                }
            });
            //切换的动画
            ((ViewHolderBanner)holder).xbnnerClassify.setPageTransformer(Transformer.Default);
            //点击事件
            ((ViewHolderBanner)holder).xbnnerClassify.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, final int position) {
                    Toast.makeText(context, "点击了第"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            ((ViewHolder)holder).nameItemClassify.setText("百岁山"+position);
            ClassifyTwoItemAdapter classifyTwoItemAdapter = new ClassifyTwoItemAdapter(context, position);
            classifyTwoItemAdapter.setmPosition(position);
            ((ViewHolder)holder).rvItemClassify.setNestedScrollingEnabled(false);;
            ((ViewHolder)holder).rvItemClassify.setLayoutManager(new GridLayoutManager(context,3));
            ((ViewHolder)holder).rvItemClassify.setAdapter(classifyTwoItemAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return BANNER;
        }else {
            return HOT;
        }
    }

    public class ViewHolderBanner extends RecyclerView.ViewHolder{

        private XBanner xbnnerClassify;

        public ViewHolderBanner(@NonNull View itemView) {
            super(itemView);
            xbnnerClassify=itemView.findViewById(R.id.xbnner_classify);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameItemClassify;
        private RecyclerView rvItemClassify;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameItemClassify=itemView.findViewById(R.id.name_item_classify);
            rvItemClassify=itemView.findViewById(R.id.rv_item_classify);
        }
    }

}
