package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleLazyFragment;
import com.dytj.goodcard.presenter.TestContact;

import androidx.annotation.Nullable;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class NewsFragment extends LifecycleLazyFragment {
    @Override
    public TestContact.presenter initPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_news, null);
        return view;
    }
}
