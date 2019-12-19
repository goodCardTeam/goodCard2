package com.dytj.leekbox.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.model.TradeSimpleResult;
import com.dytj.leekbox.presenter.LoginContact;
import com.dytj.leekbox.presenter.LoginPresenter;
import com.dytj.leekbox.presenter.TestPresenter;

public class ForgetPwdActivity extends LifecycleBaseActivity<LoginPresenter>
        implements LoginContact.view, View.OnClickListener {

    private String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        initData();
    }

    private void initData() {
        tel=getIntent().getStringExtra("tel");
    }

    public static void start(Activity activity,String tel){
        Intent intent=new Intent(activity,ForgetPwdActivity.class);
        intent.putExtra("tel",tel);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(this, ForgetPwdActivity.this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setData(LoginEntity loginEntity, String tag) {

    }

    @Override
    public void setRegisterData(RegisterEntity registerData, String tag) {

    }

    @Override
    public void setSmsData(TradeSimpleResult tradeSimpleResult, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
