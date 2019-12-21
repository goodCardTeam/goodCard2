package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseFragment;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.presenter.CardContact;
import com.dytj.leekbox.presenter.CardPresenter;

import java.util.HashMap;

import androidx.annotation.Nullable;

/**
 * Created by MaRufei
 * on 2019-12-11.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class CardFragment extends LifecycleBaseFragment<CardPresenter> implements CardContact.view {
    private View view;
    public static final String TRADE_LIST = "tradeList";
    /**
     * 1.积分转交 2.积分获取
     */
    private int type;

    @Override
    public CardPresenter initPresenter() {
        return new CardPresenter(this, getActivity());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater,container,savedInstanceState);
        view = View.inflate(getActivity(), R.layout.fragment_card, null);
        setContentView(view);
        super.onCreateView(inflater,container,savedInstanceState);
        initView();
        initData();
        return view;
    }

    private void initData() {
//        type=getActivity().getIntent().getIntExtra("type",0);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type", 0);
        }
        String tradeType = "";
        if (type == 1) {
            tradeType = "2";
        } else {
            tradeType = "1";
        }
        getTradeList(tradeType);
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

    /**
     * 获取交易列表
     */
    private void getTradeList(String trade_type) {
        HashMap params = new HashMap();
        params.put("page", "1");
        params.put("per_page", "10");
        params.put("trade_type", trade_type);
        presenter.getData(params, TRADE_LIST);
    }

    @Override
    public void setTradeListData(TradeListEntity tradeListEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
