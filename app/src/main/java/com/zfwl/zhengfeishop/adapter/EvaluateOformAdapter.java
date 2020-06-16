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
public class EvaluateOformAdapter extends RecyclerView.Adapter<EvaluateOformAdapter.ViewHolder>{

    private Context context;

    public EvaluateOformAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.evaluate_oform,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(R.mipmap.img_order_form)
                .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .into(holder.imgEvaluate);
        holder.nameShopEvaluate.setText("半仙商城旗舰店"+position);
        holder.textEvaluate.setText("购买成功"+position);
        holder.nameEvaluate.setText(position+"曼秀雷敦新碧轻透防晒水凝乳，防晒离美肤,专业护肤");
        holder.categoryEvaluate.setText("类别分类：户外防晒；");
        holder.weightEvaluate.setText("净含量：50ml");
        holder.priceEvaluate.setText("235.0"+position);
        holder.quantityEvaluate.setText("共"+position+"件商品");
        //付款
        holder.evaluateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "评价", Toast.LENGTH_SHORT).show();
            }
        });
        //订单详情
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("id",3);
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

        private TextView nameShopEvaluate,textEvaluate,nameEvaluate,categoryEvaluate,weightEvaluate,priceEvaluate,quantityEvaluate,evaluateButton;
        private ImageView imgEvaluate;

        public ViewHolder(@NonNull View itemView) {
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

}
