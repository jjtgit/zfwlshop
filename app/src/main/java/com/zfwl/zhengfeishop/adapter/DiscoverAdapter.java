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
 * Created by 修梦 on 2020/5/27.
 * Describe:
 */
public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder>{

    private Context context;

    public DiscoverAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.discover_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textDiscover.setText("新品半仙"+position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textDiscover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textDiscover=itemView.findViewById(R.id.text_discover);
        }
    }
}
