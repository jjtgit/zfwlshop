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
 * Describe:待发货的adapter
 */
public class ShipmentOformAdapter extends RecyclerView.Adapter<ShipmentOformAdapter.ViewHolder>{

    private Context context;

    public ShipmentOformAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.shipments_oform,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.img_order_form)
                .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgShipments);
        holder.nameShopShipments.setText("半仙商城旗舰店"+position);
        holder.textShipments.setText("待发货"+position);
        holder.nameShipments.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
        holder.categoryShipments.setText("类别分类：户外防晒；");
        holder.weightShipments.setText("净含量：50ml");
        holder.priceShipments.setText("235.0"+position);
        holder.quantityShipments.setText("共"+position+"件商品");

        //付款
        holder.relationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "联系卖家", Toast.LENGTH_SHORT).show();
            }
        });
        //订单详情
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",1);
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

        private TextView nameShopShipments,textShipments,nameShipments,categoryShipments,weightShipments,priceShipments,quantityShipments,relationButton;
        private ImageView imgShipments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameShopShipments=itemView.findViewById(R.id.name_shop_shipments);
            textShipments=itemView.findViewById(R.id.text_shipments);
            nameShipments=itemView.findViewById(R.id.name_shipments);
            categoryShipments=itemView.findViewById(R.id.category_shipments);
            weightShipments=itemView.findViewById(R.id.weight_shipments);
            priceShipments=itemView.findViewById(R.id.price_shipments);
            quantityShipments=itemView.findViewById(R.id.quantity_shipments);
            relationButton=itemView.findViewById(R.id.relation_button);
            imgShipments=itemView.findViewById(R.id.img_shipments);
        }
    }

}
