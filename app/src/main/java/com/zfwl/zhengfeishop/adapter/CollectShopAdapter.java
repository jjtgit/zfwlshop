package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.bean.CollectShopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/6/9.
 * Describe:收藏商品
 */
public class CollectShopAdapter extends RecyclerView.Adapter<CollectShopAdapter.ViewHolder>{

    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;
    private Context context;
    private List<CollectShopBean> listshop;
    private OnItemClickListener mOnItemClickListener;


    public CollectShopAdapter(Context context) {
        this.context = context;
    }

    public void notifyAdapter(List<CollectShopBean> shoplist,boolean isAdd){
        if (!isAdd){
            this.listshop=shoplist;
        }else {
            this.listshop.addAll(shoplist);
        }
        notifyDataSetChanged();
    }

    public List<CollectShopBean> getListshop() {
        if (listshop==null){
            listshop=new ArrayList<>();
        }
        return listshop;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.collect_post_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context).load(R.mipmap.collect_shop_img)
                .apply(new RequestOptions().error(R.mipmap.collect_shop_img).placeholder(R.mipmap.collect_shop_img))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                .into(holder.imgCollect);
        holder.nameshopCollect.setText(listshop.get(position).getNameShop());
        holder.subtractCollect.setText(listshop.get(position).getSubtractCollect());
        holder.priceCollect.setText(listshop.get(position).getPriceCollect());
        if (mEditMode==MYLIVE_MODE_CHECK){
            holder.notSelectCollect.setVisibility(View.GONE);
        }else {
            holder.notSelectCollect.setVisibility(View.VISIBLE);
            if (listshop.get(position).isSelect()){
                holder.notSelectCollect.setImageResource(R.mipmap.more_select);
            }else {
                holder.notSelectCollect.setImageResource(R.mipmap.not_select);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClickListener(holder.getAdapterPosition(),listshop);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listshop.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView notSelectCollect,imgCollect,carCollect;
        private TextView nameshopCollect,activityTextcollect,subtractCollect,priceCollect,placeholderCollect;
        private LinearLayout activityCollecct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notSelectCollect=itemView.findViewById(R.id.not_select_collect);
            imgCollect=itemView.findViewById(R.id.img_collect);
            carCollect=itemView.findViewById(R.id.car_collect);
            nameshopCollect=itemView.findViewById(R.id.nameshop_collect);
            activityTextcollect=itemView.findViewById(R.id.activity_textcollect);
            subtractCollect=itemView.findViewById(R.id.subtract_collect);
            priceCollect=itemView.findViewById(R.id.price_collect);
            placeholderCollect=itemView.findViewById(R.id.placeholder_collect);
            activityCollecct=itemView.findViewById(R.id.activity_collecct);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos,List<CollectShopBean> listshop);
    }
    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }
}
