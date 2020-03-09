package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.mvpBase.BasePresenter;
import com.dytj.goodcard.presenter.RainbowPresenter;
import com.dytj.goodcard.utils.PreferenceHelper;

public class SettingActivity extends LifecycleBaseActivity<BasePresenter>
        implements View.OnClickListener {

    private Button mineLoginOut;
    private LinearLayout mineAbout;
    private LinearLayout mineCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ToolBarStyle(0);
        setBack(true);
        setTitle("设置");
        initView();
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, SettingActivity.class);
        activity.startActivity(intent);
    }

    private void initView() {
        mineLoginOut=findViewById(R.id.mine_login_out);
        mineLoginOut.setOnClickListener(this);
        mineAbout=findViewById(R.id.mine_about);
        mineAbout.setOnClickListener(this);
        mineCustomer=findViewById(R.id.mine_customer);
        mineCustomer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_login_out:
                try {
                    PreferenceHelper.write(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.AUTHORIZATION, "");
                    AppManager.getAppManager().AppExit(getApplicationContext());
                    LoginActivity.start(SettingActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.mine_about:
                AboutActivity.start(SettingActivity.this);
                break;
            case R.id.mine_customer:
                PayActivity.start(SettingActivity.this);
                break;
        }
    }
}
