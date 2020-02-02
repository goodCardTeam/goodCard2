package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.LunBoTuEntity;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.presenter.TestPresenter;

public class CertificationActivity extends LifecycleBaseActivity<TestPresenter> implements TestContact.view, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        ToolBarStyle(0);
        setBack(true);
        setTitle("实名认证");
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, CertificationActivity.class);
        activity.startActivity(intent);
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
