package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.presenter.MyTradeOrderPresenter;
import com.dytj.goodcard.ui.adapter.CardVpAdapter;
import com.dytj.goodcard.ui.fragment.CardFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MyTradeOrderActivity extends LifecycleBaseActivity<MyTradeOrderPresenter> implements View.OnClickListener {

    private TabLayout cardTab;
    private ViewPager cardFragment;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatusYesBar();
        setContentView(R.layout.activity_my_trade_order);
        ToolBarStyle(0);
        setBack(true);
        setTitle("我的订单");
        initView();
        initData();

    }

    @Override
    public MyTradeOrderPresenter initPresenter() {
        return null;
    }

    private void initData() {
        List<String> listTitle = new ArrayList<>();
        listTitle.add("已完成");
        listTitle.add("待付款");
        listTitle.add("待收款");
        listTitle.add("已取消");
        for (int i = 0; i < listTitle.size(); i++) {
            String status = "";
            if (i == 0) {
                status = "20";
            } else if (i == 1) {
                status = "0";
            } else if (i == 2) {
                status = "10";
            } else if (i == 3) {
                status = "-10";
            }

            CardFragment cardFragment = CardFragment.newInstance(status);
            fragmentList.add(cardFragment);
        }

        CardVpAdapter myFragmentAdapter = new CardVpAdapter(getSupportFragmentManager(),
                fragmentList
                , listTitle);

        cardFragment.setAdapter(myFragmentAdapter);

        cardTab.setupWithViewPager(cardFragment);

    }

    private void initView() {
        cardTab = findViewById(R.id.my_trade_order_tab);
        cardFragment = findViewById(R.id.my_trade_order_fragment);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MyTradeOrderActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myBack:
                AppManager.getAppManager().finishActivity(this);
                break;
        }
    }
}
