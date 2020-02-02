package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.LunBoTuEntity;
import com.dytj.goodcard.presenter.BuyContact;
import com.dytj.goodcard.presenter.BuyPresenter;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.presenter.TestPresenter;

public class AboutActivity extends LifecycleBaseActivity<TestPresenter> implements TestContact.view, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, AboutActivity.class);
        activity.startActivity(intent);
    }

    private void initView() {
        ToolBarStyle(0);
        setBack(true);
        setTitle("关于我们");
    }

    @Override
    public TestPresenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setData(LunBoTuEntity lunBoTuEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
