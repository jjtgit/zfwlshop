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
 * Created by 修梦 on 2020/5/29.
 * Describe:全部订单adapter
 */
public class AllOformAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private final int ONE = 0;
    private final int TWO = 1;
    private final int THREE = 2;
    private final int FOUR = 3;
    private final int FIVE=4;

    public AllOformAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==ONE){
            view= LayoutInflater.from(context).inflate(R.layout.payment_oform,parent,false);
            return new ViewHolderPayment(view);
        }else if (getItemViewType(viewType)==TWO){
            view=LayoutInflater.from(context).inflate(R.layout.shipments_oform,parent,false);
            return new ViewHolderShipments(view);
        }else if (getItemViewType(viewType)==THREE){
            view=LayoutInflater.from(context).inflate(R.layout.receiving_oform,parent,false);
            return new ViewHolderReceiving(view);
        }else if (getItemViewType(viewType)==FOUR){
            view=LayoutInflater.from(context).inflate(R.layout.evaluate_oform,parent,false);
            return new ViewHolderEvaluate(view);
        }else {
            view=LayoutInflater.from(context).inflate(R.layout.receiving_cancel,parent,false);
            return new ViewHolderCancel(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==ONE){
            Glide.with(context).load(R.mipmap.img_order_form)
                    .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderPayment)holder).imgPayment);
            ((ViewHolderPayment)holder).nameShop.setText("半仙商城旗舰店"+position);
            ((ViewHolderPayment)holder).textPayment.setText("待付款"+position);
            ((ViewHolderPayment)holder).namePayment.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
            ((ViewHolderPayment)holder).categoryPayment.setText("类别分类：户外防晒；");
            ((ViewHolderPayment)holder).weightPayment.setText("净含量：50ml");
            ((ViewHolderPayment)holder).pricePayment.setText("235.0"+position);
            ((ViewHolderPayment)holder).quantityPayment.setText("共"+position+"件商品");
            //付款
            ((ViewHolderPayment)holder).paymentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "去付款了", Toast.LENGTH_SHORT).show();
                }
            });
            ((ViewHolderPayment)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("id",0);
                    intent.setClass(context, OrderFormDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }else if (getItemViewType(position)==TWO){
            Glide.with(context).load(R.mipmap.img_order_form)
                    .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderShipments)holder).imgShipments);
            ((ViewHolderShipments)holder).nameShopShipments.setText("半仙商城旗舰店"+position);
            ((ViewHolderShipments)holder).textShipments.setText("待发货"+position);
            ((ViewHolderShipments)holder).nameShipments.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
            ((ViewHolderShipments)holder).categoryShipments.setText("类别分类：户外防晒；");
            ((ViewHolderShipments)holder).weightShipments.setText("净含量：50ml");
            ((ViewHolderShipments)holder).priceShipments.setText("235.0"+position);
            ((ViewHolderShipments)holder).quantityShipments.setText("共"+position+"件商品");
            //付款
            ((ViewHolderShipments)holder).relationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "联系卖家", Toast.LENGTH_SHORT).show();
                }
            });
            ((ViewHolderShipments)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("id",1);
                    intent.setClass(context, OrderFormDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }else if (getItemViewType(position)==THREE){
            Glide.with(context).load(R.mipmap.img_order_form)
                    .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderReceiving)holder).imgReceiving);
            ((ViewHolderReceiving)holder).nameShopReceiving.setText("半仙商城旗舰店"+position);
            ((ViewHolderReceiving)holder).textReceiving.setText("卖家已发货"+position);
            ((ViewHolderReceiving)holder).nameReceiving.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
            ((ViewHolderReceiving)holder).categoryReceiving.setText("类别分类：户外防晒；");
            ((ViewHolderReceiving)holder).weightReceiving.setText("净含量：50ml");
            ((ViewHolderReceiving)holder).priceReceiving.setText("235.0"+position);
            ((ViewHolderReceiving)holder).quantityReceiving.setText("共"+position+"件商品");
            //查看物流
            ((ViewHolderReceiving)holder).cancelReceiving.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "查看物流", Toast.LENGTH_SHORT).show();
                }
            });
            //付款
            ((ViewHolderReceiving)holder).receivingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "确认收货", Toast.LENGTH_SHORT).show();
                }
            });
            ((ViewHolderReceiving)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("id",2);
                    intent.setClass(context, OrderFormDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }else if (getItemViewType(position)==FOUR){
            Glide.with(context).load(R.mipmap.img_order_form)
                    .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderEvaluate)holder).imgEvaluate);
            ((ViewHolderEvaluate)holder).nameShopEvaluate.setText("半仙商城旗舰店"+position);
            ((ViewHolderEvaluate)holder).textEvaluate.setText("购买成功"+position);
            ((ViewHolderEvaluate)holder).nameEvaluate.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
            ((ViewHolderEvaluate)holder).categoryEvaluate.setText("类别分类：户外防晒；");
            ((ViewHolderEvaluate)holder).weightEvaluate.setText("净含量：50ml");
            ((ViewHolderEvaluate)holder).priceEvaluate.setText("235.0"+position);
            ((ViewHolderEvaluate)holder).quantityEvaluate.setText("共"+position+"件商品");
            //付款
            ((ViewHolderEvaluate)holder).evaluateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "评价", Toast.LENGTH_SHORT).show();
                }
            });
            ((ViewHolderEvaluate)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("id",3);
                    intent.setClass(context, OrderFormDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }else if (getItemViewType(position)==FIVE){
            Glide.with(context).load(R.mipmap.img_order_form)
                    .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderCancel)holder).imgRecancel);
            ((ViewHolderCancel)holder).nameShopCancel.setText("半仙商城旗舰店"+position);
            ((ViewHolderCancel)holder).textCancel.setText("已取消"+position);
            ((ViewHolderCancel)holder).nameCancel.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
            ((ViewHolderCancel)holder).categoryCancel.setText("类别分类：户外防晒；");
            ((ViewHolderCancel)holder).weightCancel.setText("净含量：50ml");
            ((ViewHolderCancel)holder).priceCancel.setText("235.0"+position);
            ((ViewHolderCancel)holder).quantityCancel.setText("共"+position+"件商品");
            //删除订单
            ((ViewHolderCancel)holder).cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "删除订单", Toast.LENGTH_SHORT).show();
                }
            });
            ((ViewHolderCancel)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("id",4);
                    intent.setClass(context, OrderFormDetailsActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%5==0){
            return ONE;
        }else if (position%5==1){
            return TWO;
        }else if (position%5==2){
            return THREE;
        }else if (position%5==3){
            return FOUR;
        }else {
            return FIVE;
        }
    }

    //待付款
    public class ViewHolderPayment extends RecyclerView.ViewHolder{

        private TextView nameShop,textPayment,namePayment,categoryPayment,weightPayment,pricePayment,quantityPayment,cancelButton,paymentButton;
        private ImageView imgPayment;

        public ViewHolderPayment(@NonNull View itemView) {
            super(itemView);
            nameShop=itemView.findViewById(R.id.name_shop);
            textPayment=itemView.findViewById(R.id.text_payment);
            namePayment=itemView.findViewById(R.id.name_payment);
            categoryPayment=itemView.findViewById(R.id.category_payment);
            weightPayment=itemView.findViewById(R.id.weight_payment);
            pricePayment=itemView.findViewById(R.id.price_payment);
            quantityPayment=itemView.findViewById(R.id.quantity_payment);
            cancelButton=itemView.findViewById(R.id.cancel_button);
            paymentButton=itemView.findViewById(R.id.payment_button);
            imgPayment=itemView.findViewById(R.id.img_payment);
        }
    }

    //待发货
    public class ViewHolderShipments extends RecyclerView.ViewHolder{

        private TextView nameShopShipments,textShipments,nameShipments,categoryShipments,weightShipments,priceShipments,quantityShipments,relationButton;
        private ImageView imgShipments;

        public ViewHolderShipments(@NonNull View itemView) {
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

    //待收货
    public class ViewHolderReceiving extends RecyclerView.ViewHolder{

        private TextView nameShopReceiving,textReceiving,nameReceiving,categoryReceiving,weightReceiving,priceReceiving,quantityReceiving,cancelReceiving,receivingButton;
        private ImageView imgReceiving;

        public ViewHolderReceiving(@NonNull View itemView) {
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

    //待评价
    public class ViewHolderEvaluate extends RecyclerView.ViewHolder{

        private TextView nameShopEvaluate,textEvaluate,nameEvaluate,categoryEvaluate,weightEvaluate,priceEvaluate,quantityEvaluate,evaluateButton;
        private ImageView imgEvaluate;

        public ViewHolderEvaluate(@NonNull View itemView) {
            super(itemView);
            nameShopEvaluate=itemView.findViewById(R.id.name_shop_evaluate);
            textEvaluate=itemView.findViewById(R.id.text_evaluate);
            nameEvaluate=itemView.findViewById(R.id.name_evaluate);
            categoryEvaluate=itemView.findViewById(R.id.category_evaluate);
            weightEvaluate=itemView.findViewById(R.id.weight_evaluate);
            priceEvaluate=itemView.findViewById(R.id.price_evaluate);
            quantityEvaluate=itemView.findViewById(R.id.quantity_evaluate);
            evaluateButton=itemView.findViewById(R.id.evaluate_button);
            imgEvaluate=itemView.findViewById(R.id.img_evaluate);
        }
    }
    //已取消
    public class ViewHolderCancel extends RecyclerView.ViewHolder{

        private TextView nameShopCancel,textCancel,nameCancel,categoryCancel,weightCancel,priceCancel,quantityCancel,cancelButton;
        private ImageView imgRecancel;

        public ViewHolderCancel(@NonNull View itemView) {
            super(itemView);
            nameShopCancel=itemView.findViewById(R.id.name_shop_cancel);
            textCancel=itemView.findViewById(R.id.text_cancel);
            nameCancel=itemView.findViewById(R.id.name_cancel);
            categoryCancel=itemView.findViewById(R.id.category_cancel);
            weightCancel=itemView.findViewById(R.id.weight_cancel);
            priceCancel=itemView.findViewById(R.id.price_cancel);
            quantityCancel=itemView.findViewById(R.id.quantity_cancel);
            cancelButton=itemView.findViewById(R.id.cancel_button);
            imgRecancel=itemView.findViewById(R.id.img_recancel);
        }
    }

}
