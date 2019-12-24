package com.dytj.leekbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.dytj.leekbox.AppManager;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.presenter.CardContact;
import com.dytj.leekbox.presenter.CardPresenter;
import com.dytj.leekbox.ui.adapter.CardVpAdapter;
import com.dytj.leekbox.ui.fragment.CardFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class CardActivity extends LifecycleBaseActivity<CardPresenter> implements View.OnClickListener {

    private TabLayout cardTab;
    private ViewPager cardFragment;
    private List<Fragment> fragmentList = new ArrayList<>();
    private ImageButton myBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusYesBar();
        setContentView(R.layout.activity_card);
        initView();
        initData();

    }

    @Override
    public CardPresenter initPresenter() {
        return null;
    }

    private void initData() {
        List<String> listTitle = new ArrayList<>();
        listTitle.add("积分获取");
        listTitle.add("积分转交");
        for (int i = 0; i < listTitle.size(); i++) {
            int type=i+1;
            CardFragment cardFragment = CardFragment.newInstance(type);
            fragmentList.add(cardFragment);
        }

        CardVpAdapter myFragmentAdapter = new CardVpAdapter(getSupportFragmentManager(),
                fragmentList
                , listTitle);

        cardFragment.setAdapter(myFragmentAdapter);

        cardTab.setupWithViewPager(cardFragment);

    }

    private void initView() {
        cardTab = findViewById(R.id.card_tab);
        cardFragment = findViewById(R.id.card_fragment);
        myBack=findViewById(R.id.myBack);
        myBack.setOnClickListener(this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, CardActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myBack:
                AppManager.getAppManager().finishActivity(this);
                break;
        }
    }
}
