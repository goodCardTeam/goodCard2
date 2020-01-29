package com.dytj.goodcard.view.galleryView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.R;
import com.dytj.goodcard.model.RainbowEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by jameson on 8/30/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<Integer> mList = new ArrayList<>();
    private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();
    private Context context;
    List<RainbowEntity.CardsBean> cardList=new ArrayList<>();

    public CardAdapter(Context context) {
        this.context=context;
    }

    public void setmList(List<Integer> mList) {
        this.mList = mList;
    }

    public void setCardList(List<RainbowEntity.CardsBean> cardList) {
        this.cardList = cardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card_item, parent, false);
        mCardAdapterHelper.onCreateViewHolder(parent, itemView);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());
        holder.mImageView.setImageResource(mList.get(position));
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.mImageView.getContext(),""+position,Toast.LENGTH_LONG).show();
            }
        });
        if(position==0){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_white));
        }
        else if(position==1){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_blue));
            setTextColor(holder);
        }
        else if(position==2){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_yellow));
            setTextColor(holder);
        }
        else if(position==3){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_purple));
            setTextColor(holder);
        }
        else if(position==4){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_red));
            setTextColor(holder);
        }
        else if(position==5){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_black));
            setTextColor(holder);
        }
        if (cardList.size()>0) {
            holder.mTitle.setText(cardList.get(position).getName());
            holder.mPoint.setText("所需积分: " + cardList.get(position).getPoint());
            holder.mPeriod.setText("周期: " + cardList.get(position).getDays()+"天");
            holder.mRate.setText("回报率: " + cardList.get(position).getMonth_rate());
            holder.mIns.setText("简介: " + "开发还是空的尖峰时刻京东方快速解答付款时间的付款时间大富科技时代峰峻SDK加粉和");
        }

    }

    private void setTextColor(ViewHolder holder){
        holder.mTitle.setTextColor(context.getResources().getColor(R.color.white));
        holder.mPoint.setTextColor(context.getResources().getColor(R.color.white_da));
        holder.mPeriod.setTextColor(context.getResources().getColor(R.color.white_da));
        holder.mRate.setTextColor(context.getResources().getColor(R.color.white_da));
        holder.mIns.setTextColor(context.getResources().getColor(R.color.white_da));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final LinearLayout rainbow_bac;
        private final TextView mTitle;
        private final ImageView mPic;
        private final TextView mPoint;
        private final TextView mPeriod;
        private final TextView mRate;
        private final TextView mIns;

        public ViewHolder(final View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            rainbow_bac=itemView.findViewById(R.id.rainbow_bac);
            mTitle=itemView.findViewById(R.id.rainbow_item_title);
            mPic=itemView.findViewById(R.id.rainbow_item_pic) ;
            mPoint=itemView.findViewById(R.id.rainbow_item_point);
            mPeriod=itemView.findViewById(R.id.rainbow_item_period);
            mRate=itemView.findViewById(R.id.rainbow_item_rate);
            mIns=itemView.findViewById(R.id.rainbow_item_ins);
        }

    }

}
