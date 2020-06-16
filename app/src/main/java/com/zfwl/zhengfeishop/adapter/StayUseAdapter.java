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
 * Describe:未使用的优惠卷的adapter
 */
public class StayUseAdapter extends RecyclerView.Adapter<StayUseAdapter.ViewHolder>{
    
    private Context context;

    public StayUseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.coupons_stayuse,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.priceStayuse.setText("2"+position);
        holder.nameStayuse.setText("半仙专卖劵"+position);
        holder.timeStayuse.setText("有效期至：2020-11-1"+position);
        holder.limitStayuse.setText("满1"+position+"元可用、限购买半仙");
        holder.useButtonStayuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "立即使用", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView priceStayuse,nameStayuse,timeStayuse,limitStayuse,useButtonStayuse;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceStayuse=itemView.findViewById(R.id.price_stayuse);
            nameStayuse=itemView.findViewById(R.id.name_stayuse);
            timeStayuse=itemView.findViewById(R.id.time_stayuse);
            limitStayuse=itemView.findViewById(R.id.limit_stayuse);
            useButtonStayuse=itemView.findViewById(R.id.use_button_stayuse);
        }
    }
    
}
