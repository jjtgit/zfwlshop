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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zfwl.zhengfeishop.R;

/**
 * Created by 修梦 on 2020/5/15.
 * Describe:领劵中心
 */
public class LeadItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private final int BANNER = 0;
    private final int HOT = 1;

    public LeadItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==BANNER){
            view = LayoutInflater.from(context).inflate(R.layout.lead_item_img, parent, false);
            return new ViewHolderImg(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.lead_item1, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==BANNER){
            Glide.with(context).load(R.mipmap.banner_img)
                    .apply(new RequestOptions().error(R.mipmap.banner_img).placeholder(R.mipmap.banner_img))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderImg)holder).imgLead);
        }else {
            ((ViewHolder)holder).priceLead.setText("2"+position);
            ((ViewHolder)holder).nameLead.setText("半仙专卖劵"+position);
            ((ViewHolder)holder).timeLead.setText("有效期至：2020—11—2"+position);
            ((ViewHolder)holder).textLead.setText("满"+position+"元可用、限购买半仙");
            if (position%2==0){
                ((ViewHolder)holder).getLead.setVisibility(View.VISIBLE);
                ((ViewHolder)holder).notGetLead.setVisibility(View.GONE);
            }else {
                ((ViewHolder)holder).getLead.setVisibility(View.GONE);
                ((ViewHolder)holder).notGetLead.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return BANNER;
        }else {
            return HOT;
        }
    }

    public class ViewHolderImg extends RecyclerView.ViewHolder{

        private ImageView imgLead;

        public ViewHolderImg(@NonNull View itemView) {
            super(itemView);
            imgLead=itemView.findViewById(R.id.img_lead);
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView priceLead,nameLead,timeLead,textLead,getLead,notGetLead;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            priceLead=itemView.findViewById(R.id.price_lead);
            nameLead=itemView.findViewById(R.id.name_lead);
            timeLead=itemView.findViewById(R.id.time_lead);
            textLead=itemView.findViewById(R.id.text_lead);
            getLead=itemView.findViewById(R.id.get_lead);
            notGetLead=itemView.findViewById(R.id.not_get_lead);
        }
    }

}
