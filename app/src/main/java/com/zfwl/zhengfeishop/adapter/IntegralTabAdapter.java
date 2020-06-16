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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/15.
 * Describe:
 */
public class IntegralTabAdapter extends RecyclerView.Adapter<IntegralTabAdapter.ViewHolder>{

    private Context context;

    private int variable=0;
    private HashMap<Integer, Boolean> map;
    private  int mPosition;

    private String[] title = {
            "全部",
            "0～999",
            "1000～4999",
            "5000～9999",
            "10000～99999",
            "100000以上"
    };

    public IntegralTabAdapter(Context context) {
        this.context = context;
    }


    private List<String> list=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.tab_integral,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        for (int i=0;i<title.length;i++){
            if (i==0){
                list.clear();
                list.add(title[i]);
            }else {
                list.add(title[i]);
            }
        }
        holder.nameTab.setText(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListener.onClick(position);
            }
        });
        if (position==getmPosition()){
            holder.nameTab.setTextColor(Color.parseColor("#DE1D13"));
            holder.nameTab.setBackgroundResource(R.drawable.tab_select_ellipse);
        }else {
            holder.nameTab.setTextColor(Color.parseColor("#999999"));
            holder.nameTab.setBackgroundResource(R.drawable.tab_ellipse);
        }
       /* holder.nameTab.setTextColor(Color.parseColor("#DE1D13"));
        holder.nameTab.setBackgroundResource(R.drawable.tab_select_ellipse);*/
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTab=itemView.findViewById(R.id.name_tab);
        }
    }
   public interface GetListener {

        void onClick(int position);
    }

    private GetListener getListener;

    public void setGetListener(GetListener getListener) {
        this.getListener = getListener;
    }

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }
}
