package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;

/**
 * Created by 修梦 on 2020/6/1.
 * Describe:已使用优惠卷的adapter
 */
public class EndUseAdapter extends RecyclerView.Adapter<EndUseAdapter.ViewHolder>{

    private Context context;

    public EndUseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.coupons_enduse,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.priceEnduse.setText("2"+position);
        holder.nameEnduse.setText("半仙专卖劵"+position);
        holder.timeEnduse.setText("有效期至：2020-11-1"+position);
        holder.limitEnduse.setText("满1"+position+"元可用、限购买半仙");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView priceEnduse,nameEnduse,timeEnduse,limitEnduse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceEnduse=itemView.findViewById(R.id.price_enduse);
            nameEnduse=itemView.findViewById(R.id.name_enduse);
            timeEnduse=itemView.findViewById(R.id.time_enduse);
            limitEnduse=itemView.findViewById(R.id.limit_enduse);
        }
    }

}
