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
public class PastDueAdapter extends RecyclerView.Adapter<PastDueAdapter.ViewHolder>{

    private Context context;

    public PastDueAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.coupons_pastdue,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pricePastDue.setText("2"+position);
        holder.namePastDue.setText("半仙专卖劵"+position);
        holder.timePastDue.setText("有效期至：2020-11-1"+position);
        holder.limitPastDue.setText("满1"+position+"元可用、限购买半仙");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView pricePastDue,namePastDue,timePastDue,limitPastDue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pricePastDue=itemView.findViewById(R.id.price_pastdue);
            namePastDue=itemView.findViewById(R.id.name_pastdue);
            timePastDue=itemView.findViewById(R.id.time_pastdue);
            limitPastDue=itemView.findViewById(R.id.limit_pastdue);
        }
    }

}
