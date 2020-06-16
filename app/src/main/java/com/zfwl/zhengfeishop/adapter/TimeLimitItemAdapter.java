package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.graphics.Paint;
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
import com.zfwl.zhengfeishop.utils.SaleProgressView;

/**
 * Created by 修梦 on 2020/5/18.
 * Describe:限时抢购详细页面adapter
 */
public class TimeLimitItemAdapter extends RecyclerView.Adapter<TimeLimitItemAdapter.ViewHolder>{

    private Context context;

    public TimeLimitItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.timelimit_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.time_img)
                .apply(new RequestOptions().error(R.mipmap.time_img).placeholder(R.mipmap.time_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                .into(holder.imgTimeItem );
        holder.nameTimeItem.setText(position+"55英寸4K高清智能网络彩电屏是的撒的撒打算打算的撒多");
        holder.propertyTimeItem1.setText("全面屏"+position);
        holder.propertyTimeItem2.setText("4K高清"+position);
        holder.nowthePrice.setText("￥ 329"+position);
        holder.formerlyPriceItem.setText("￥987"+position);
        holder.formerlyPriceItem.setPaintFlags(holder.formerlyPriceItem.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.robBottenItem.setText("抢购中"+position);
        holder.SpviewTimeitem.setTotalAndCurrentCount(100,100);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgTimeItem;
        private TextView nameTimeItem,propertyTimeItem1,propertyTimeItem2,nowthePrice,formerlyPriceItem,
                robBottenItem;
        private SaleProgressView SpviewTimeitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTimeItem=itemView.findViewById(R.id.img_timeitem);
            nameTimeItem=itemView.findViewById(R.id.name_timeitem);
            propertyTimeItem1=itemView.findViewById(R.id.property_timeitem1);
            propertyTimeItem2=itemView.findViewById(R.id.property_timeitem2);
            nowthePrice=itemView.findViewById(R.id.nowthe_price);
            formerlyPriceItem=itemView.findViewById(R.id.formerly_price_item);
            robBottenItem=itemView.findViewById(R.id.rob_botten_item);
            SpviewTimeitem=itemView.findViewById(R.id.spview_timeitem);
        }
    }

}
