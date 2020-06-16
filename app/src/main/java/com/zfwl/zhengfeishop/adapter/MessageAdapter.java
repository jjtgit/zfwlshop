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
 * Created by 修梦 on 2020/6/10.
 * Describe:站内消息的Adapter
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private final int ONE = 0;
    private final int TWO = 1;
    private final int THREE = 2;
    public ItemOnClickInterface itemOnClickInterface;

    public MessageAdapter(Context context) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==ONE){
           view= LayoutInflater.from(context).inflate(R.layout.message1_adapter,parent,false);
           return new ViewHolderMessage1(view);
        }else if (getItemViewType(viewType)==TWO){
            view=LayoutInflater.from(context).inflate(R.layout.message2_adapter,parent,false);
            return new ViewHolderMessage2(view);
        }else {
            view=LayoutInflater.from(context).inflate(R.layout.message3_adapter,parent,false);
            return new ViewHolderMessage3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==ONE){
            ((ViewHolderMessage1)holder).nameMessage1.setText("优惠券过期提醒"+position);
            ((ViewHolderMessage1)holder).timeMessage1.setText("2020-04-16 23:2"+position);
            ((ViewHolderMessage1)holder).titleMessage1.setText("您有两张价值40元的优惠券今日到期,快去用掉今日到期，快去用掉吧。"+position);
            ((ViewHolderMessage1)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ViewHolderMessage1)holder).remindMessage1.setVisibility(View.GONE);
                }
            });
            ((ViewHolderMessage1)holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemOnClickInterface.onItemClick(view,position);
                    return false;
                }
            });
        }else if (getItemViewType(position)==TWO){
            Glide.with(context).load(R.mipmap.img_order_form)
                    .apply(new RequestOptions().error(R.mipmap.img_order_form).placeholder(R.mipmap.img_order_form))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderMessage2)holder).imgMessage2);
            ((ViewHolderMessage2)holder).nameMessage2.setText("优惠券过期提醒"+position);
            ((ViewHolderMessage2)holder).timeMessage2.setText("2020-04-16 23:2"+position);
            ((ViewHolderMessage2)holder).titleMessage2.setText("您有两张价值40元的优惠券今日到期,快去用掉今日到期，快去用掉吧。"+position);
            ((ViewHolderMessage2)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ViewHolderMessage2)holder).remindMessage2.setVisibility(View.GONE);
                }
            });
            ((ViewHolderMessage2)holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemOnClickInterface.onItemClick(view,position);
                    return false;
                }
            });
        }else {
            Glide.with(context).load(R.mipmap.message_activity_img)
                    .apply(new RequestOptions().error(R.mipmap.message_activity_img).placeholder(R.mipmap.message_activity_img))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(5)))
                    .into(((ViewHolderMessage3)holder).headimgMessage3);
            ((ViewHolderMessage3)holder).nameMessage3.setText("优惠券过期提醒"+position);
            ((ViewHolderMessage3)holder).timeMessage3.setText("2020-04-16 23:2"+position);
            ((ViewHolderMessage3)holder).titleMessage3.setText("您有两张价值40元的优惠券今日到期,快去用掉今日到期，快去用掉吧。"+position);
            ((ViewHolderMessage3)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((ViewHolderMessage3)holder).remindMessage3.setVisibility(View.GONE);
                }
            });
            ((ViewHolderMessage3)holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemOnClickInterface.onItemClick(view,position);
                    return false;
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
        if (position%3==0){
            return ONE;
        }else if (position%3==1){
            return TWO;
        }else {
            return THREE;
        }
    }

    public class ViewHolderMessage1 extends RecyclerView.ViewHolder{

        private TextView nameMessage1,remindMessage1,timeMessage1,titleMessage1;

        public ViewHolderMessage1(@NonNull View itemView) {
            super(itemView);
            nameMessage1=itemView.findViewById(R.id.name_message1);
            remindMessage1=itemView.findViewById(R.id.remind_message1);
            timeMessage1=itemView.findViewById(R.id.time_message1);
            titleMessage1=itemView.findViewById(R.id.title_message1);
        }
    }
    public class ViewHolderMessage2 extends RecyclerView.ViewHolder{

        private TextView nameMessage2,remindMessage2,timeMessage2,titleMessage2;
        private ImageView imgMessage2;

        public ViewHolderMessage2(@NonNull View itemView) {
            super(itemView);
            nameMessage2=itemView.findViewById(R.id.name_message2);
            remindMessage2=itemView.findViewById(R.id.remind_message2);
            timeMessage2=itemView.findViewById(R.id.time_message2);
            titleMessage2=itemView.findViewById(R.id.title_message2);
            imgMessage2=itemView.findViewById(R.id.img_message2);
        }
    }
    public class ViewHolderMessage3 extends RecyclerView.ViewHolder{

        private TextView nameMessage3,remindMessage3,timeMessage3,titleMessage3;
        private ImageView headimgMessage3;

        public ViewHolderMessage3(@NonNull View itemView) {
            super(itemView);
            nameMessage3=itemView.findViewById(R.id.name_message3);
            remindMessage3=itemView.findViewById(R.id.remind_message3);
            timeMessage3=itemView.findViewById(R.id.time_message3);
            titleMessage3=itemView.findViewById(R.id.title_message3);
            headimgMessage3=itemView.findViewById(R.id.headimg_message3);
        }
    }
}
