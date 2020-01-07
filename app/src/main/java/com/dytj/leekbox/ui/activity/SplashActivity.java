package com.dytj.leekbox.ui.activity;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.dytj.leekbox.AppConfig;
import com.dytj.leekbox.R;
import com.dytj.leekbox.api.baseFile.OkHttp3Utils;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.presenter.LoginContact;
import com.dytj.leekbox.presenter.LoginPresenter;
import com.dytj.leekbox.ui.MainActivity;
import com.dytj.leekbox.utils.MyToast;
import com.dytj.leekbox.utils.PreferenceHelper;
import com.dytj.leekbox.utils.TTAdManagerHolder;
import com.dytj.leekbox.utils.WeakHandler;

import java.util.HashMap;

public class SplashActivity extends LifecycleBaseActivity<LoginPresenter>
        implements LoginContact.view, WeakHandler.IHandler {
    /**
     * 需要进行检测的权限数组
     */
    private String[] permissions = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

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

    private static final String TAG = "SplashActivity";
    private TTAdNative mTTAdNative;
    private FrameLayout mSplashContainer;
    //是否强制跳转到主页面
    private boolean mForceGoMain;

    //开屏广告加载发生超时但是SDK没有及时回调结果的时候，做的一层保护。
    private final WeakHandler mHandler = new WeakHandler(this);
    //开屏广告加载超时时间,建议大于3000,这里为了冷启动第一次加载到广告并且展示,示例设置了3000ms
    private static final int AD_TIME_OUT = 3000;
    private static final int MSG_GO_MAIN = 1;
    //开屏广告是否已经加载
    private boolean mHasLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setDarkStatusIcon(true);
        setPermission(permissions);
        initData();
    }

    private void initData() {
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    sleep(3000);
////                    Message message=Message.obtain();
////                    message.what=0;
//                    handler.sendEmptyMessage(0);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

        mSplashContainer = (FrameLayout) findViewById(R.id.splash_container);
        //step2:创建TTAdNative对象
        mTTAdNative = TTAdManagerHolder.get().createAdNative(this);
        //在合适的时机申请权限，如read_phone_state,防止获取不了imei时候，下载类广告没有填充的问题
        //在开屏时候申请不太合适，因为该页面倒计时结束或者请求超时会跳转，在该页面申请权限，体验不好
        // TTAdManagerHolder.getInstance(this).requestPermissionIfNecessary(this);
        //定时，AD_TIME_OUT时间到时执行，如果开屏广告没有加载则跳转到主页面
        mHandler.sendEmptyMessageDelayed(MSG_GO_MAIN, AD_TIME_OUT);
        //加载开屏广告
        loadSplashAd();
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

    @Override
    public void handleMsg(Message msg) {

    }

    @Override
    protected void onResume() {
        //判断是否该跳转到主页面
        if (mForceGoMain) {
            mHandler.removeCallbacksAndMessages(null);
            goToMainActivity();
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mForceGoMain = true;
    }

    /**
     * 加载开屏广告
     */
    private void loadSplashAd() {
        //step3:创建开屏广告请求参数AdSlot,具体参数含义参考文档
        AdSlot adSlot = new AdSlot.Builder()
                .setCodeId("887291923")
                .setSupportDeepLink(true)
                .setImageAcceptedSize(1080, 1920)
                .build();
        //step4:请求广告，调用开屏广告异步请求接口，对请求回调的广告作渲染处理
        mTTAdNative.loadSplashAd(adSlot, new TTAdNative.SplashAdListener() {
            @Override
            @MainThread
            public void onError(int code, String message) {
                Log.d(TAG, message);
                mHasLoaded = true;
                showToast(message);
                goToMainActivity();
            }

            @Override
            @MainThread
            public void onTimeout() {
                mHasLoaded = true;
                showToast("开屏广告加载超时");
                goToMainActivity();
            }


            @Override
            @MainThread
            public void onSplashAdLoad(TTSplashAd ad) {
                Log.d(TAG, "开屏广告请求成功");
                mHasLoaded = true;
                mHandler.removeCallbacksAndMessages(null);
                if (ad == null) {
                    return;
                }
                //获取SplashView
                View view = ad.getSplashView();
                if (view != null) {
                    mSplashContainer.removeAllViews();
                    //把SplashView 添加到ViewGroup中,注意开屏广告view：width >=70%屏幕宽；height >=50%屏幕高
                    mSplashContainer.addView(view);
                    //设置不开启开屏广告倒计时功能以及不显示跳过按钮,如果这么设置，您需要自定义倒计时逻辑
                    //ad.setNotAllowSdkCountdown();
                }else {
                    goToMainActivity();
                }

                //设置SplashView的交互监听器
                ad.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() {
                    @Override
                    public void onAdClicked(View view, int type) {
                        Log.d(TAG, "onAdClicked");
                        showToast("开屏广告点击");
                    }

                    @Override
                    public void onAdShow(View view, int type) {
                        Log.d(TAG, "onAdShow");
                        showToast("开屏广告展示");
                    }

                    @Override
                    public void onAdSkip() {
                        Log.d(TAG, "onAdSkip");
                        showToast("开屏广告跳过");
                        goToMainActivity();

                    }

                    @Override
                    public void onAdTimeOver() {
                        Log.d(TAG, "onAdTimeOver");
                        showToast("开屏广告倒计时结束");
                        goToMainActivity();
                    }
                });
                if(ad.getInteractionType() == TTAdConstant.INTERACTION_TYPE_DOWNLOAD) {
                    ad.setDownloadListener(new TTAppDownloadListener() {
                        boolean hasShow = false;

                        @Override
                        public void onIdle() {

                        }

                        @Override
                        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                            if (!hasShow) {
                                showToast("下载中...");
                                hasShow = true;
                            }
                        }

                        @Override
                        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                            showToast("下载暂停...");

                        }

                        @Override
                        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                            showToast("下载失败...");

                        }

                        @Override
                        public void onDownloadFinished(long totalBytes, String fileName, String appName) {

                        }

                        @Override
                        public void onInstalled(String fileName, String appName) {

                        }
                    });
                }
            }
        }, AD_TIME_OUT);
    }

    /**
     * 跳转到主页面
     */
    private void goToMainActivity() {
        String token=PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.AUTHORIZATION, "");
        if(TextUtils.isEmpty(token)){
            LoginActivity.start(SplashActivity.this);
            return;
        }
        refreshToken();
    }

    private void showToast(String msg) {
        MyToast.showMyToast2(getApplicationContext(),msg, Toast.LENGTH_SHORT);
    }
}
