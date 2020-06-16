package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.bean.StoreAdapterBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/6/9.
 * Describe:收藏店铺的adapter
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{

    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;
    private Context context;
    private List<StoreAdapterBean> liststore;
    private OnItemClickListener mOnItemClickListener;

    public StoreAdapter(Context context) {
        this.context = context;
    }

    public void notifyAdapter(List<StoreAdapterBean> storelist,boolean isAdd){
        if (!isAdd){
            this.liststore=storelist;
        }else {
            this.liststore.addAll(storelist);
        }
        notifyDataSetChanged();
    }

    public List<StoreAdapterBean> getListstore() {
        if (liststore==null){
            liststore=new ArrayList<>();
        }
        return liststore;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.store_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.round_head)
                .apply(new RequestOptions().error(R.mipmap.round_head).placeholder(R.mipmap.round_head))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.imgHeadStore);
        holder.nameshopStore.setText(liststore.get(position).getNameShopStore());
        holder.attentionStore.setText(liststore.get(position).getAttentionStore());
        holder.labelStore1.setText(liststore.get(position).getLabelStore1());
        holder.labelStore2.setText(liststore.get(position).getLabelStore2());
        if (mEditMode==MYLIVE_MODE_CHECK){
            holder.notSelectStore.setVisibility(View.GONE);
        }else {
            holder.notSelectStore.setVisibility(View.VISIBLE);
            if (liststore.get(position).isSelect()){
                holder.notSelectStore.setImageResource(R.mipmap.more_select);
            }else {
                holder.notSelectStore.setImageResource(R.mipmap.not_select);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClickListener(holder.getAdapterPosition(),liststore);
            }
        });
    }

    @Override
    public int getItemCount() {
        return liststore.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgHeadStore,notSelectStore;
        private TextView nameshopStore,attentionStore,labelStore1,labelStore2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHeadStore=itemView.findViewById(R.id.img_head_store);
            nameshopStore=itemView.findViewById(R.id.nameshop_store);
            attentionStore=itemView.findViewById(R.id.attention_store);
            labelStore1=itemView.findViewById(R.id.label_store1);
            labelStore2=itemView.findViewById(R.id.label_store2);
            notSelectStore=itemView.findViewById(R.id.not_select_store);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos,List<StoreAdapterBean> listshop);
    }
    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }

}
