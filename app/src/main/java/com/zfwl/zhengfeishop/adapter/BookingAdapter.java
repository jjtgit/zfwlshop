package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.graphics.Paint;
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
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.transformers.Transformer;
import com.zfwl.zhengfeishop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/14.
 * Describe:拼团秒杀的适配器
 */
public class BookingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public Context context;
    private final int BANNER = 0;
    private final int HOT = 1;
    private List<String> listBanner;
    ArrayList<String> list=new ArrayList<>();

    public BookingAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==BANNER) {
            view = LayoutInflater.from(context).inflate(R.layout.tab_content_xbanner, parent, false);
            return new ViewHolderBanner(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_booking, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==BANNER){
            listBanner=new ArrayList<>();
            listBanner.add("http://img5.imgtn.bdimg.com/it/u=1308452466,3663840021&fm=26&gp=0.jpg");
            listBanner.add("http://img2.imgtn.bdimg.com/it/u=3922344982,423380743&fm=214&gp=0.jpg");
            listBanner.add("http://img1.cheshi-img.com/product/1_1024/p/60800/60849/5ea259b021877.jpg");
            listBanner.add("http://a4.att.hudong.com/22/59/19300001325156131228593878903.jpg");
            listBanner.add("http://e.hiphotos.baidu.com/zhidao/pic/item/d62a6059252dd42a1c362a29033b5bb5c9eab870.jpg");
            for (int i=0;i<listBanner.size();i++){
                String img= listBanner.get(i);
                if (i==0){
                    list.clear();
                    list.add(img);
                }else {
                    list.add(img);
                }
            }
            ((ViewHolderBanner)holder).xbannerBooking.setData(list,null);
            //调起
            ((ViewHolderBanner)holder).xbannerBooking.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(context).load(list.get(position))
                            .apply(new RequestOptions().error(R.mipmap.home_banner).placeholder(R.mipmap.home_banner))
                            .apply( RequestOptions.bitmapTransform(new RoundedCorners(20)))
                            .into((ImageView) view);
                }
            });
            //切换的动画
            ((ViewHolderBanner)holder).xbannerBooking.setPageTransformer(Transformer.Default);
            //点击事件
            ((ViewHolderBanner)holder).xbannerBooking.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, final int position) {
                    Toast.makeText(context, "点击了第"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Glide.with(context).load(R.mipmap.booking_img)
                    .apply(new RequestOptions().error(R.mipmap.booking_img).placeholder(R.mipmap.booking_img))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                    .into(((ViewHolder)holder).imgItemBooking );
            ((ViewHolder)holder).nameItemBooking.setText(position+"榨汁机家用水果小型全自动果");
            ((ViewHolder)holder).numItemBooking.setText("已团"+position+"件");
            ((ViewHolder)holder).priceBooking.setText("￥98"+position);
            ((ViewHolder)holder).notPriceBooking.setText("￥121"+position);
            ((ViewHolder)holder).notPriceBooking.setPaintFlags(((ViewHolder)holder).notPriceBooking.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            ((ViewHolder)holder).numberItemBooking.setText(position+"人团");
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


     class ViewHolderBanner extends RecyclerView.ViewHolder{

        private XBanner xbannerBooking;

        public ViewHolderBanner(@NonNull View itemView) {
            super(itemView);
            xbannerBooking=itemView.findViewById(R.id.xbanner_booking);
        }
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameItemBooking,numItemBooking,priceBooking,notPriceBooking,numberItemBooking;
        private ImageView imgItemBooking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemBooking=itemView.findViewById(R.id.img_item_booking);
            nameItemBooking=itemView.findViewById(R.id.name_item_booking);
            numItemBooking=itemView.findViewById(R.id.num_item_booking);
            priceBooking=itemView.findViewById(R.id.price_booking);
            notPriceBooking=itemView.findViewById(R.id.not_price_booking);
            numberItemBooking=itemView.findViewById(R.id.number_item_booking);
        }
    }

}
