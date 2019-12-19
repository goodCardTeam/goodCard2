package com.dytj.leekbox.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dytj.leekbox.R;
import com.dytj.leekbox.model.MenuEntity;
import com.dytj.leekbox.view.GridViewForScrollView;
import com.dytj.leekbox.view.ListViewForScrollView;

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
public class MenuItemLvAdapter extends BaseAdapter {
    private List<MenuEntity> list=new ArrayList<>();
    private Context mContext;

    public void setList(List<MenuEntity> list) {
        this.list = list;
    }

    public MenuItemLvAdapter(Context context){
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
            convertView=View.inflate(mContext, R.layout.item_menu,null);
            viewHolder.menu_title=convertView.findViewById(R.id.menu_title);
            viewHolder.menu_lv=convertView.findViewById(R.id.menu_lv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.menu_title.setText(list.get(position).getTitle());
        MenuLvAdapter adapter=new MenuLvAdapter(mContext);
        adapter.setList(list.get(position).getMenuItemEntityList());
        viewHolder.menu_lv.setAdapter(adapter);
        return convertView;
    }

    class ViewHolder{
        TextView menu_title;
        GridViewForScrollView menu_lv;
    }
}
