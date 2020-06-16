package com.zfwl.zhengfeishop.adapter;

import android.content.Context;
import android.graphics.Paint;
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
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.transformers.Transformer;
import com.zfwl.zhengfeishop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 修梦 on 2020/5/15.
 * Describe:排行榜的adapter
 */
public class RankingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public Context context;
    private final int BANNER = 0;
    private final int HOT = 1;
    private List<String> listBanner;
    final ArrayList<String> list=new ArrayList<>();

    public RankingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==BANNER){
            view = LayoutInflater.from(context).inflate(R.layout.tab_content_xbanner, parent, false);
            return new ViewHolderBanner(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.ranking_fragment_item, parent, false);
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
            ((ViewHolderBanner)holder).xbanerRanking.setData(list,null);
            //调起
            ((ViewHolderBanner)holder).xbanerRanking.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(context).load(list.get(position))
                            .apply(new RequestOptions().error(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background))
                            .apply( RequestOptions.bitmapTransform(new RoundedCorners(8)))
                            .into((ImageView) view);
                }
            });
            //切换的动画
            ((ViewHolderBanner)holder).xbanerRanking.setPageTransformer(Transformer.Default);
            //点击事件
            ((ViewHolderBanner)holder).xbanerRanking.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, final int position) {
                    Toast.makeText(context, "点击了第"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Glide.with(context).load(R.mipmap.booking_img)
                    .apply(new RequestOptions().error(R.mipmap.booking_img).placeholder(R.mipmap.booking_img))
                    .apply( RequestOptions.bitmapTransform(new RoundedCorners(3)))
                    .into(((ViewHolder)holder).imgRanking );
            if (position==1){
                ((ViewHolder)holder).imgOneRanking.setVisibility(View.VISIBLE);
                ((ViewHolder)holder).imgTwoRanking.setVisibility(View.GONE);
                ((ViewHolder)holder).imgThreeRanking.setVisibility(View.GONE);
            }else if (position==2){
                ((ViewHolder)holder).imgOneRanking.setVisibility(View.GONE);
                ((ViewHolder)holder).imgTwoRanking.setVisibility(View.VISIBLE);
                ((ViewHolder)holder).imgThreeRanking.setVisibility(View.GONE);
            }else if (position==3){
                ((ViewHolder)holder).imgOneRanking.setVisibility(View.GONE);
                ((ViewHolder)holder).imgTwoRanking.setVisibility(View.GONE);
                ((ViewHolder)holder).imgThreeRanking.setVisibility(View.VISIBLE);
            }else {
                ((ViewHolder)holder).imgOneRanking.setVisibility(View.GONE);
                ((ViewHolder)holder).imgTwoRanking.setVisibility(View.GONE);
                ((ViewHolder)holder).imgThreeRanking.setVisibility(View.GONE);
            }
            ((ViewHolder)holder).nameItemRanking.setText(position+"榨汁机家用水果小型全自动果");
            ((ViewHolder)holder).workOffRanking.setText("已累计售出"+position+"件");
            ((ViewHolder)holder).priceItemRanking.setText("9"+position);

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

    public class ViewHolderBanner extends RecyclerView.ViewHolder{

        private XBanner xbanerRanking;

        public ViewHolderBanner(@NonNull View itemView) {
            super(itemView);
            xbanerRanking=itemView.findViewById(R.id.xbanner_booking);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgRanking,imgOneRanking,imgTwoRanking,imgThreeRanking;
        private TextView nameItemRanking,workOffRanking,priceItemRanking;
        private LinearLayout shopCarRanking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRanking=itemView.findViewById(R.id.img_ranking);
            imgOneRanking=itemView.findViewById(R.id.img_one_ranking);
            imgTwoRanking=itemView.findViewById(R.id.img_two_ranking);
            imgThreeRanking=itemView.findViewById(R.id.img_three_ranking);
            nameItemRanking=itemView.findViewById(R.id.name_item_ranking);
            workOffRanking=itemView.findViewById(R.id.work_off_ranking);
            priceItemRanking=itemView.findViewById(R.id.price_item_ranking);
            shopCarRanking=itemView.findViewById(R.id.shop_car_ranking);
        }
    }

}
