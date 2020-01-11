package com.dytj.goodcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.LoginEntity;
import com.dytj.goodcard.model.RegisterEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.presenter.LoginContact;
import com.dytj.goodcard.presenter.LoginPresenter;

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
    public void setData(JsonResponse<LoginEntity> loginEntity, String tag) {

    }

    @Override
    public void setRegisterData(RegisterEntity registerData, String tag) {

    }

    @Override
    public void setSmsData(JsonResponse jsonResponse, String tag) {

    }

    @Override
    public void setRefreshData(JsonResponse<LoginEntity> loginEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
