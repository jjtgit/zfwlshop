package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zfwl.zhengfeishop.R;
import com.zfwl.zhengfeishop.activity.RefundDetailsActivity;

/**
 * Created by 修梦 on 2020/6/2.
 * Describe:退款售后的adapter
 */
public class RefundAdapter extends RecyclerView.Adapter<RefundAdapter.ViewHolder>{

    private Context context;

    public RefundAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.refund_adapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(R.mipmap.img_order_form)
                .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgRefund);
        holder.nameShopRefund.setText("半仙商城旗舰店"+position);
        holder.textRefund.setText("已退款"+position);
        holder.nameRefund.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
        holder.categoryRefund.setText("类别分类：户外防晒；");
        holder.weightRefund.setText("净含量：50ml");
        holder.priceRefund.setText("退款：￥ 10"+position);
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "删除记录", Toast.LENGTH_SHORT).show();
            }
        });
        holder.refundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",position);
                intent.setClass(context, RefundDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgRefund;
        private TextView nameShopRefund,textRefund,nameRefund,categoryRefund,weightRefund,priceRefund,deleteButton,refundButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRefund=itemView.findViewById(R.id.img_refund);
            nameShopRefund=itemView.findViewById(R.id.name_shop_refund);
            textRefund=itemView.findViewById(R.id.text_refund);
            nameRefund=itemView.findViewById(R.id.name_refund);
            categoryRefund=itemView.findViewById(R.id.category_refund);
            weightRefund=itemView.findViewById(R.id.weight_refund);
            priceRefund=itemView.findViewById(R.id.price_refund);
            deleteButton=itemView.findViewById(R.id.delete_button);
            refundButton=itemView.findViewById(R.id.refund_button);
        }
    }

}
