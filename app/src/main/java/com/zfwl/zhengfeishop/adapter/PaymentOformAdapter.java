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
 * Describe:待付款的adapter
 */
public class PaymentOformAdapter extends RecyclerView.Adapter<PaymentOformAdapter.ViewHolder>{

    private Context context;

    public PaymentOformAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.payment_oform,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.img_order_form)
                .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgPayment);
        holder.nameShop.setText("半仙商城旗舰店"+position);
        holder.textPayment.setText("待付款"+position);
        holder.namePayment.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
        holder.categoryPayment.setText("类别分类：户外防晒；");
        holder.weightPayment.setText("净含量：50ml");
        holder.pricePayment.setText("235.0"+position);
        holder.quantityPayment.setText("共"+position+"件商品");
        //付款
        holder.paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "去付款了", Toast.LENGTH_SHORT).show();  
            }
        });
        //订单详情
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",0);
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

        private TextView nameShop,textPayment,namePayment,categoryPayment,weightPayment,pricePayment,quantityPayment,paymentButton;
        private ImageView imgPayment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameShop=itemView.findViewById(R.id.name_shop);
            textPayment=itemView.findViewById(R.id.text_payment);
            namePayment=itemView.findViewById(R.id.name_payment);
            categoryPayment=itemView.findViewById(R.id.category_payment);
            weightPayment=itemView.findViewById(R.id.weight_payment);
            pricePayment=itemView.findViewById(R.id.price_payment);
            quantityPayment=itemView.findViewById(R.id.quantity_payment);
            paymentButton=itemView.findViewById(R.id.payment_button);
            imgPayment=itemView.findViewById(R.id.img_payment);
        }
    }

}
