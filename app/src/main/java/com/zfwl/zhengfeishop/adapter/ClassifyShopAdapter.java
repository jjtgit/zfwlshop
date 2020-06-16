package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zfwl.zhengfeishop.R;

/**
 * Created by 修梦 on 2020/5/25.
 * Describe:分类里面的适配器
 */
public class ClassifyShopAdapter extends RecyclerView.Adapter<ClassifyShopAdapter.ViewHolder>{

    private Context context;

    public ClassifyShopAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.classify_shop_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.home_shop_img1)
                .apply(new RequestOptions().error(R.mipmap.home_shop_img1).placeholder(R.mipmap.home_shop_img1))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgSclassify);
        holder.nameSclassify.setText("彩色灯泡灯"+position);
        holder.synopsisSclassify.setText("优质材质，放心使用");
        holder.priceSclassify.setText("36"+position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgSclassify;
        private TextView nameSclassify,synopsisSclassify,priceSclassify;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSclassify=itemView.findViewById(R.id.img_sclassify);
            nameSclassify=itemView.findViewById(R.id.name_sclassify);
            synopsisSclassify=itemView.findViewById(R.id.synopsis_sclassify);
            priceSclassify=itemView.findViewById(R.id.price_sclassify);
        }
    }

}
