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
 * Describe:积分商城
 */
public class HomeIntegralAdapter extends RecyclerView.Adapter<HomeIntegralAdapter.ViewHome>{

    public Context context;

    public HomeIntegralAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_integral,parent,false);
        return new ViewHome(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHome holder, int position) {
        Glide.with(context).load(R.mipmap.timelimit_img)
                .apply(new RequestOptions().error(R.mipmap.timelimit_img).placeholder(R.mipmap.timelimit_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                .into(holder.imgIntegral );
        holder.nameIntegral.setText("这是一双鞋");
        holder.priceIntegral.setText("998");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHome extends RecyclerView.ViewHolder{

        private ImageView imgIntegral;
        private TextView priceIntegral,nameIntegral;

        public ViewHome(@NonNull View itemView) {
            super(itemView);
            imgIntegral=itemView.findViewById(R.id.img_integral);
            nameIntegral=itemView.findViewById(R.id.name_integral);
            priceIntegral=itemView.findViewById(R.id.price_integral);
        }
    }

}
