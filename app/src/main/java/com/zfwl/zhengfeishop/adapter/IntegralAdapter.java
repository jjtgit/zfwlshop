package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;

/**
 * Created by 修梦 on 2020/6/1.
 * Describe:积分适配器
 */
public class IntegralAdapter extends RecyclerView.Adapter<IntegralAdapter.ViewHolder>{

    private Context context;

    public IntegralAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.integral_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameIntegral.setText("购买商品送积分"+position);
        holder.timeIntegral.setText("2020-02-1"+position+" 16:00");
        if (position%2==0){
            holder.numIntegral.setText("+6"+position);
        }else {
            holder.numIntegral.setTextColor(context.getResources().getColor(R.color.textGray));
            holder.numIntegral.setText("-6"+position);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameIntegral,timeIntegral,numIntegral;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameIntegral=itemView.findViewById(R.id.name_integral);
            timeIntegral=itemView.findViewById(R.id.time_integral);
            numIntegral=itemView.findViewById(R.id.num_integral);
        }
    }

}
