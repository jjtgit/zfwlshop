package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.activity.ClassifyDetailsActivity;

/**
 * Created by 修梦 on 2020/5/23.
 * Describe:分类嵌套的子条目
 */
public class ClassifyTwoItemAdapter extends RecyclerView.Adapter<ClassifyTwoItemAdapter.ViewHolder>{

    private Context context;
    private int mPosition;

    public ClassifyTwoItemAdapter(Context context, int mPosition) {
        this.context = context;
        this.mPosition = mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.classify_twoitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(R.mipmap.home_shop_img)
                .apply(new RequestOptions().error(R.mipmap.home_shop_img).placeholder(R.mipmap.home_shop_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(1)))
                .into(holder.imgTwoitem);
        holder.nameTwoitem.setText("电饭锅"+position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ClassifyDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTwoitem;
        private ImageView imgTwoitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTwoitem=itemView.findViewById(R.id.name_twoitem);
            imgTwoitem=itemView.findViewById(R.id.img_twoitem);
        }
    }

}
