package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.bean.ClassSideslipBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/22.
 * Describe:分类测试的数据
 */
public class ClassSideslipAdapter extends RecyclerView.Adapter<ClassSideslipAdapter.ViewHolder>{

    private Context context;
    private List<ClassSideslipBean.DatasBean> list;

    private onClike mOnClike;

    public void setmOnClike(onClike mOnClike) {
        this.mOnClike = mOnClike;
    }
    public interface onClike{
        void onClikes(View view,int i);
    }

    public ClassSideslipAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<ClassSideslipBean.DatasBean> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.calss_sideslip_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setId(position);
        holder.titleSideslip.setText(list.get(position).getShowName());
        if (list.get(position).isChick()){
            holder.itemView.setBackgroundColor(Color.parseColor("#F6F6F6"));
            holder.viewSideslip.setVisibility(View.VISIBLE);
            holder.titleSideslip.setTextColor(context.getResources().getColor(R.color.colorSelect));
        }else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.viewSideslip.setVisibility(View.GONE);
            holder.titleSideslip.setTextColor(context.getResources().getColor(R.color.textGray));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClike.onClikes(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleSideslip;
        private View viewSideslip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleSideslip=itemView.findViewById(R.id.title_sideslip);
            viewSideslip=itemView.findViewById(R.id.view_sideslip);
        }
    }
}
