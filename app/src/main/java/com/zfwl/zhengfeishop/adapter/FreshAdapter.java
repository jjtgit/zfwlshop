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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/13.
 * Describe:本地适配
 */
public class FreshAdapter extends RecyclerView.Adapter<FreshAdapter.ViewHolder>{

    private Context context;
    private List<String> list;

    public FreshAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<String> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fresh_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.this_locality_img)
                .apply(new RequestOptions().error(R.mipmap.this_locality_img).placeholder(R.mipmap.this_locality_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgFresh);
        holder.nameFresh.setText("半仙超市"+position);
        holder.distanceFresh.setText("3"+position+"km");
        holder.introduceFresh.setText("故事很多，未来能有多长。道不尽世间的沧桑，诉不完人生的悲凉。故事还长，你就别再失望。");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFresh;
        private TextView nameFresh,distanceFresh,introduceFresh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFresh=itemView.findViewById(R.id.img_fresh);
            nameFresh=itemView.findViewById(R.id.name_fresh);
            distanceFresh=itemView.findViewById(R.id.distance_fresh);
            introduceFresh=itemView.findViewById(R.id.introduce_fresh);
        }
    }

}
