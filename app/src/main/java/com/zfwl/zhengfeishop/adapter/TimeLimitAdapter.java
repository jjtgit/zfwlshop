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

/**
 * Created by 修梦 on 2020/5/12.
 * Describe:限时抢购adapter
 */
public class TimeLimitAdapter extends RecyclerView.Adapter<TimeLimitAdapter.ViewHoler>{

    public Context context;

    public TimeLimitAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_timelimit,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Glide.with(context).load(R.mipmap.timelimit_img)
                .apply(new RequestOptions().error(R.mipmap.timelimit_img).placeholder(R.mipmap.timelimit_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                .into(holder.imgTimelimit );
        holder.noePriceTimelimit.setText("889");
        holder.originalPriceTimelimit.setText("￥1999");
        holder.originalPriceTimelimit.setPaintFlags(holder.originalPriceTimelimit.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHoler extends RecyclerView.ViewHolder{

        private TextView noePriceTimelimit,originalPriceTimelimit;
        private ImageView imgTimelimit;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            imgTimelimit=itemView.findViewById(R.id.img_timelimit);
            noePriceTimelimit=itemView.findViewById(R.id.noe_price_timelimit);
            originalPriceTimelimit=itemView.findViewById(R.id.original_price_timelimit);
        }
    }

}
