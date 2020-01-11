package com.dytj.goodcard.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dytj.goodcard.R;
import com.dytj.goodcard.model.MenuEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaRufei
 * on 2019-12-11.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class MenuLvAdapter extends BaseAdapter {
    private List<MenuEntity.MenuItemEntity> list=new ArrayList<>();
    private Context mContext;

    public void setList(List<MenuEntity.MenuItemEntity> list) {
        this.list = list;
    }

    public MenuLvAdapter(Context context){
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(mContext, R.layout.item_lv_menu,null);
            viewHolder.menu_lv_title=convertView.findViewById(R.id.menu_lv_title);
            viewHolder.menu_lv_pic=convertView.findViewById(R.id.menu_lv_pic);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.menu_lv_title.setText(list.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView menu_lv_title;
        ImageView menu_lv_pic;
    }
}
