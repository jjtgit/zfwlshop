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
import com.zfwl.zhengfeishop.activity.OrderFormDetailsActivity;

/**
 * Created by 修梦 on 2020/5/28.
 * Describe:待收货的adapter
 */
public class ReceivingOformAdapter extends RecyclerView.Adapter<ReceivingOformAdapter.ViewHolder>{

    private Context context;

    public ReceivingOformAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.receiving_oform,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.img_order_form)
                .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgReceiving);
        holder.nameShopReceiving.setText("半仙商城旗舰店"+position);
        holder.textReceiving.setText("卖家已发货"+position);
        holder.nameReceiving.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
        holder.categoryReceiving.setText("类别分类：户外防晒；");
        holder.weightReceiving.setText("净含量：50ml");
        holder.priceReceiving.setText("235.0"+position);
        holder.quantityReceiving.setText("共"+position+"件商品");
        //查看物流
        holder.cancelReceiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "查看物流", Toast.LENGTH_SHORT).show();
            }
        });
        //付款
        holder.receivingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "确认收货", Toast.LENGTH_SHORT).show();
            }
        });
        //订单详情
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",2);
                intent.setClass(context, OrderFormDetailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameShopReceiving,textReceiving,nameReceiving,categoryReceiving,weightReceiving,priceReceiving,quantityReceiving,cancelReceiving,receivingButton;
        private ImageView imgReceiving;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameShopReceiving=itemView.findViewById(R.id.name_shop_receiving);
            textReceiving=itemView.findViewById(R.id.text_receiving);
            nameReceiving=itemView.findViewById(R.id.name_receiving);
            categoryReceiving=itemView.findViewById(R.id.category_receiving);
            weightReceiving=itemView.findViewById(R.id.weight_receiving);
            priceReceiving=itemView.findViewById(R.id.price_receiving);
            quantityReceiving=itemView.findViewById(R.id.quantity_receiving);
            cancelReceiving=itemView.findViewById(R.id.cancel_receiving);
            receivingButton=itemView.findViewById(R.id.receiving_button);
            imgReceiving=itemView.findViewById(R.id.img_receiving);
        }
    }

}
