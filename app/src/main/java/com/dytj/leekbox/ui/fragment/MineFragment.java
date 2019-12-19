package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleLazyFragment;
import com.dytj.leekbox.presenter.TestContact;
import com.dytj.leekbox.utils.StatusBarUtil;

import androidx.annotation.Nullable;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class MineFragment extends LifecycleLazyFragment {
    @Override
    public TestContact.presenter initPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        return view;
    }
}
