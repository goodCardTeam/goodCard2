package com.dytj.leekbox.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.dytj.leekbox.AppConfig;
import com.dytj.leekbox.R;
import com.dytj.leekbox.api.baseFile.OkHttp3Utils;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.presenter.LoginContact;
import com.dytj.leekbox.presenter.LoginPresenter;
import com.dytj.leekbox.utils.PreferenceHelper;

import java.util.HashMap;

public class SplashActivity extends LifecycleBaseActivity<LoginPresenter>
        implements LoginContact.view {

    public static final String REQUEST_REFRESH="refresh";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String token=PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.AUTHORIZATION, "");
            if(TextUtils.isEmpty(token)){
                LoginActivity.start(SplashActivity.this);
                return;
            }
            refreshToken();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();
    }

    private void initData() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
//                    Message message=Message.obtain();
//                    message.what=0;
                    handler.sendEmptyMessage(0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(this, SplashActivity.this);
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
        if(REQUEST_REFRESH.equals(tag)){
            String authorization=loginEntity.getData().getToken_type()+" "+loginEntity.getData().getAccess_token();
            try {
                PreferenceHelper.write(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.AUTHORIZATION,authorization);
                PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME,AppConfig.AUTHORIZATION,"");
                Log.e("aaa","author:"+authorization);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Main2Activity.start(this);
        }
    }

    @Override
    public void ErrorData(Throwable e) {

    }

    /**
     * 刷新token
     */
    private void refreshToken(){
        HashMap params=new HashMap();
        params.put("Authorization", PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.AUTHORIZATION,""));
        presenter.getData(params, REQUEST_REFRESH);
    }
}
