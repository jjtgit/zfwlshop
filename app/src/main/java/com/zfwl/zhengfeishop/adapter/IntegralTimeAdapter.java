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
 * Created by 修梦 on 2020/5/15.
 * Describe:
 */
public class IntegralTimeAdapter extends RecyclerView.Adapter<IntegralTimeAdapter.ViewHolder> {

    private Context context;

    public IntegralTimeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.integral_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.this_locality_img)
                .apply(new RequestOptions().error(R.mipmap.this_locality_img).placeholder(R.mipmap.this_locality_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgFresh);
        holder.nameFresh.setText("智能数码半仙");
        holder.conversionIntegral.setText("234人兑换");
        holder.textIntegral.setText("2000 积分");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgFresh;
        public TextView nameFresh,textIntegral,conversionIntegral;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFresh=itemView.findViewById(R.id.img_fresh);
            nameFresh=itemView.findViewById(R.id.name_fresh);
            textIntegral=itemView.findViewById(R.id.text_integral);
            conversionIntegral=itemView.findViewById(R.id.conversion_integral);
        }
    }

}
