package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleLazyFragment;
import com.dytj.leekbox.model.MenuEntity;
import com.dytj.leekbox.presenter.TestContact;
import com.dytj.leekbox.ui.activity.MyTradeOrderActivity;
import com.dytj.leekbox.ui.adapter.MenuItemLvAdapter;
import com.dytj.leekbox.view.ListViewForScrollView;
import com.lzj.gallery.library.views.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class HomeFragment extends LifecycleLazyFragment implements View.OnClickListener {
    private BannerViewPager homeBanner;
    private Toast toast;
    private View view;
    private LinearLayout homeBt1;
    private ListViewForScrollView homeMenu;
    private MenuItemLvAdapter adapter;

    @Override
    public TestContact.presenter initPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_home, null);
        initView();
        initData();
        return view;
    }

    private void initData() {
        List urlList = new ArrayList<>();
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543221773&di=c63f30c7809e518cafbff961bcd9ec2a&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0116605851154fa8012060c8587ca1.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042541&di=3ad9deeefff266e76d1f5d57a58f63d1&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F69%2F99%2F66%2F9fce5755f081660431464492a9aeb003.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042539&di=95bd41d43c335e74863d9bb540361906&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019a0558be22d6a801219c77d0578a.jpg%402o.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042539&di=cdd54bffd2aac448c70ae6b416a004d4&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01edb3555ea8100000009af0ba36f5.jpg%401280w_1l_2o_100sh.jpg");

        homeBanner.initBanner(urlList, true)//开启3D画廊效果
                .addPageMargin(-12, 20)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPoint(6)//添加指示器
                .addStartTimer(3)//自动轮播间隔
                .addPointBottom(7)
                .addRoundCorners(5)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
                        showShort("效果1点击" + position);
                        Log.i("test", "--------------position:" + position);
                    }
                });

        List<MenuEntity> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setTitle("一级分类" + i);
            List<MenuEntity.MenuItemEntity> menuItemEntityList = new ArrayList<>();
            for (int k = 0; k < 4; k++) {
                MenuEntity.MenuItemEntity menuItemEntity = new MenuEntity.MenuItemEntity();
                menuItemEntity.setName("二级分类" + k);
                menuItemEntityList.add(menuItemEntity);
            }
            menuEntity.setMenuItemEntityList(menuItemEntityList);
            list.add(menuEntity);
        }
        adapter.setList(list);
        adapter.notifyDataSetChanged();
        homeBanner.setFocusable(true);
        homeBanner.setFocusableInTouchMode(true);
    }

    private void initView() {
        homeBanner = view.findViewById(R.id.home_banner);
        homeBt1 = view.findViewById(R.id.home_bt1);
        homeBt1.setOnClickListener(this);
        homeMenu = view.findViewById(R.id.home_menu);
        adapter = new MenuItemLvAdapter(getActivity());
        homeMenu.setAdapter(adapter);
    }

    /**
     * @param text
     */
    public void showShort(String text) {
        if (toast == null) toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        else toast.setText(text);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_bt1:
                MyTradeOrderActivity.start(getActivity());
                break;
        }
    }
}
