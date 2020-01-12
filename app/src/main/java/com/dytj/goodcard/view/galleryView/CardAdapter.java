package com.dytj.goodcard.view.galleryView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dytj.goodcard.R;

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

    public CardAdapter(Context context,List<Integer> mList) {
        this.context=context;
        this.mList = mList;
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
        }
        else if(position==2){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_yellow));
        }
        else if(position==3){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_purple));
        }
        else if(position==4){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_red));
        }
        else if(position==5){
            holder.rainbow_bac.setBackground(context.getResources().getDrawable(R.drawable.card_black));
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final LinearLayout rainbow_bac;

        public ViewHolder(final View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            rainbow_bac=itemView.findViewById(R.id.rainbow_bac);
        }

    }

}
