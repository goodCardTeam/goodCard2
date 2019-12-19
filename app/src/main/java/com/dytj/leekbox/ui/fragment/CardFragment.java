package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseFragment;
import com.dytj.leekbox.base.LifecycleLazyFragment;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.presenter.CardContact;
import com.dytj.leekbox.presenter.CardPresenter;
import com.dytj.leekbox.presenter.TestContact;

import androidx.annotation.Nullable;

/**
 * Created by MaRufei
 * on 2019-12-11.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class CardFragment extends LifecycleBaseFragment<CardPresenter>  implements CardContact.view {
    private View view;
    /**
     * 1.积分转交 2.积分获取
     */
    private int type;

    @Override
    public CardPresenter initPresenter() {
        return null;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_card, null);
        initView();
        initData();
        return view;
    }

    private void initData() {
//        type=getActivity().getIntent().getIntExtra("type",0);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type",0);
        }

    }

    private void initView() {

    }

    public static CardFragment newInstance(int type) {
        CardFragment myFragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void setData(TradeListEntity tradeListEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
