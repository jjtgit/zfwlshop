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
 * Created by 修梦 on 2020/5/13.
 * Describe:推荐的adapter
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder>{

    private Context context;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recommend_title,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.home_shop_img1)
                .apply(new RequestOptions().error(R.mipmap.home_shop_img1).placeholder(R.mipmap.home_shop_img1))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgShop );
        holder.nameShop.setText("这是半仙");
        holder.introduceShop.setText("好用，放心，质量杠杠的");
        holder.priceShop.setText("998");
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgShop;
        private TextView nameShop,introduceShop,priceShop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgShop=itemView.findViewById(R.id.img_shop);
            nameShop=itemView.findViewById(R.id.name_shop);
            introduceShop=itemView.findViewById(R.id.introduce_shop);
            priceShop=itemView.findViewById(R.id.price_shop);
        }
    }

}
