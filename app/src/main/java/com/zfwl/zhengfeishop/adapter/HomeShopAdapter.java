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
 * Created by 修梦 on 2020/5/12.
 * Describe:团购商城
 */
public class HomeShopAdapter extends RecyclerView.Adapter<HomeShopAdapter.ViewHome>{

    public Context context;

    public HomeShopAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_shopgroup,parent,false);
        return new ViewHome(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHome holder, int position) {
        Glide.with(context).load(R.mipmap.home_shop_img)
                .apply(new RequestOptions().error(R.mipmap.home_shop_img).placeholder(R.mipmap.home_shop_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                .into(holder.imgShopgroup );
        holder.priceShopgroup.setText("998");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHome extends RecyclerView.ViewHolder{

        private ImageView imgShopgroup;
        private TextView priceShopgroup;

        public ViewHome(@NonNull View itemView) {
            super(itemView);
            imgShopgroup=itemView.findViewById(R.id.img_shopgroup);
            priceShopgroup=itemView.findViewById(R.id.price_shopgroup);
        }
    }

}
