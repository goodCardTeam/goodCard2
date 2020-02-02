package com.dytj.goodcard.ui.adapter;


import android.content.Context;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by MaRufei
 * on 2019-12-17.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private int defaultImg= com.lzj.gallery.library.R.mipmap.ic_banner_error;//默认图片


    public ViewHolder(Context context, View itemView, ViewGroup parent) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }


    public static ViewHolder get(Context context, ViewGroup parent, int layoutId) {

        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        ViewHolder holder = new ViewHolder(context, itemView, parent);
        return holder;
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getmTextView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);

            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends ImageView> T getmImageView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 点击事件
     *
     * @param viewId
     * @param listener
     * @return
     */
    public ViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置TextView
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = (TextView) mViews.get(viewId);
        if (null == tv) {
            tv = mConvertView.findViewById(viewId);
            mViews.put(viewId, tv);
        }
        tv.setText(text);
        return this;
    }

    public ViewHolder setTextLine(int viewId, String text) {
        TextView tv = (TextView) mViews.get(viewId);
        if (null == tv) {
            tv = mConvertView.findViewById(viewId);
            mViews.put(viewId, tv);
        }
        tv.setText(text);
        tv.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
        return this;
    }


    /**
     * 设置ImageView
     *
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImage(int viewId, int resId) {
        ImageView view = (ImageView) mViews.get(viewId);
        if (null == view) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        view.setImageResource(resId);
        return this;
    }

    /**
     * 设置textview背景颜色
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setTextBackgroundColor(int viewId, int color) {
        TextView tv = (TextView) mViews.get(viewId);
        if (null == tv) {
            tv = mConvertView.findViewById(viewId);
            mViews.put(viewId, tv);
        }
        tv.setBackgroundColor(color);
        return this;
    }

    /**
     * 设置TextView字体颜色
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setTextColor(int viewId, int color) {
        TextView tv = (TextView) mViews.get(viewId);
        if (null == tv) {
            tv = mConvertView.findViewById(viewId);
            mViews.put(viewId, tv);
        }
        tv.setTextColor(color);
        return this;
    }


    /**
     * 加载图片
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageResource(int viewId,String url){
        ImageView iv=(ImageView) mViews.get(viewId);
        if(null==iv){
            iv=mConvertView.findViewById(viewId);
            mViews.put(viewId,iv);
        }
//        Glide.with(mContext).load(url).into(iv);
        //设置图片圆角角度
        RoundedCorners roundedCorners= new RoundedCorners(6);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300, 300).error(defaultImg).dontAnimate();

        Glide.with(mContext)
                .load(url)
                .apply(options)
                .into(iv);
        return this;
    }

}