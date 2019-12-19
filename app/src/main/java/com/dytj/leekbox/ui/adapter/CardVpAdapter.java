package com.dytj.leekbox.ui.adapter;

import com.dytj.leekbox.ui.fragment.CardFragment;
import com.dytj.leekbox.ui.fragment.HomeFragment;
import com.dytj.leekbox.ui.fragment.MineFragment;
import com.dytj.leekbox.ui.fragment.NewsFragment;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/8/3.
 */
public class CardVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public CardVpAdapter(FragmentManager fm, List<Fragment> mFragments, List<String> mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

}
