package com.dytj.leekbox.ui.adapter;

import com.dytj.leekbox.ui.fragment.HomeFragment;
import com.dytj.leekbox.ui.fragment.MineFragment;
import com.dytj.leekbox.ui.fragment.NewsFragment;
import com.dytj.leekbox.ui.fragment.ActiveFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/8/3.
 */
public class MainVpAdapter extends FragmentPagerAdapter {
    private HomeFragment home1Fragment = null;
    private NewsFragment home2Fragment = null;
    private MineFragment home3Fragment = null;
    private ActiveFragment home4Fragment = null;


    public MainVpAdapter(FragmentManager fm) {
        super(fm);
        home1Fragment = new HomeFragment();
        home2Fragment = new NewsFragment();
        home3Fragment = new MineFragment();
        home4Fragment = new ActiveFragment();

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = home1Fragment;
                break;
            case 1:
                fragment = home2Fragment;
                break;
            case 3:
                fragment = home3Fragment;
                break;
            case 2:
                fragment = home4Fragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

}
