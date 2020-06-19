package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.activity.SiteMyActivity;
import com.zfwl.zhengfeishop.bean.SiteEventBean;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 修梦 on 2020/6/4.
 * Describe:
 */
public class SiteAdapter extends RecyclerView.Adapter<SiteAdapter.ViewHolder>{

    private Context context;
    private ItemOnClickInterface itemOnClickInterface;


    public SiteAdapter(Context context) {
        this.context = context;
    }
    //回调接口
    public interface ItemOnClickInterface {
        void onItemClick(View view, int position);
    }

    //定义回调方法
    public void setItemOnClickInterface(ItemOnClickInterface itemOnClickInterface) {
        this.itemOnClickInterface = itemOnClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.site_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.nameSite.setText("半仙"+position);
        holder.cellphoneSite.setText("1562696339"+position);
        if (position==0){
            holder.defaultSite.setVisibility(View.VISIBLE);
        }else {
            holder.defaultSite.setVisibility(View.GONE);
        }
        holder.titleSite.setText("山东省聊城市冠县武训大道与杭州路交汇处振飞物流"+position);
        holder.compileSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("pd",1);
                intent.putExtra("namesite",holder.nameSite.getText());
                intent.putExtra("cellphonesite",holder.cellphoneSite.getText());
                intent.putExtra("defaultsite",position);
                intent.putExtra("sites","山东省聊城市冠县"+position);
                intent.putExtra("titlesite",holder.titleSite.getText());
                intent.setClass(context, SiteMyActivity.class);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new SiteEventBean(holder.nameSite.getText().toString(),holder.cellphoneSite.getText().toString(),holder.titleSite.getText().toString()));
                if (itemOnClickInterface!=null){
                    itemOnClickInterface.onItemClick(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameSite,cellphoneSite,defaultSite,titleSite;
        private LinearLayout compileSite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameSite=itemView.findViewById(R.id.name_site);
            cellphoneSite=itemView.findViewById(R.id.cellphone_site);
            defaultSite=itemView.findViewById(R.id.default_site);
            titleSite=itemView.findViewById(R.id.title_site);
            compileSite=itemView.findViewById(R.id.compile_site);
        }
    }
}
