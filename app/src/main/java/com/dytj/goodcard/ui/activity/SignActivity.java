package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.R;
import com.dytj.goodcard.utils.MyToast;
import com.dytj.goodcard.utils.TTAdManagerHolder;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSign;
    private TTAdNative mTTAdNative;
    private TTRewardVideoAd mttRewardVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initView();
        openAd();
    }

    private void initView() {
        btnSign=findViewById(R.id.btn_sign);
        btnSign.setOnClickListener(this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, SignActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign:
                if (mttRewardVideoAd != null) {
                    //step6:在获取到广告后展示
                    //该方法直接展示广告
//                    mttRewardVideoAd.showRewardVideoAd(RewardVideoActivity.this);

                    //展示广告，并传入广告展示的场景
                    mttRewardVideoAd.showRewardVideoAd(SignActivity.this);
                    mttRewardVideoAd = null;
                } else {
                    MyToast.showMyToast2(SignActivity.this, "请先加载广告", Toast.LENGTH_SHORT);
                }
                break;

        }
    }

    private void openAd() {
        //step1:初始化sdk
        TTAdManager ttAdManager = TTAdManagerHolder.get();
        //step2:(可选，强烈建议在合适的时机调用):申请部分权限，如read_phone_state,防止获取不了imei时候，下载类广告没有填充的问题。
        TTAdManagerHolder.get().requestPermissionIfNecessary(this);
        //step3:创建TTAdNative对象,用于调用广告请求接口
        mTTAdNative = ttAdManager.createAdNative(getApplicationContext());

        AdSlot adSlot = new AdSlot.Builder()
                .setCodeId(AppConfig.AD_VEDIO_ID)
                .setSupportDeepLink(true)
                .setAdCount(2)
                .setImageAcceptedSize(1080, 1920)
                .setRewardName("金币") //奖励的名称
                .setRewardAmount(3)   //奖励的数量
                //必传参数，表来标识应用侧唯一用户；若非服务器回调模式或不需sdk透传
                //可设置为空字符串
                .setUserID("user123")
                .setOrientation(TTAdConstant.VERTICAL)  //设置期望视频播放的方向，为TTAdConstant.HORIZONTAL或TTAdConstant.VERTICAL
                .setMediaExtra("media_extra") //用户透传的信息，可不传
                .build();
        mTTAdNative.loadRewardVideoAd(adSlot, new TTAdNative.RewardVideoAdListener() {
            @Override
            public void onError(int code, String message) {
                MyToast.showMyToast2(SignActivity.this,message,Toast.LENGTH_SHORT);
            }
            //视频广告加载后的视频文件资源缓存到本地的回调
            @Override
            public void onRewardVideoCached() {
                MyToast.showMyToast2(SignActivity.this, "rewardVideoAd video cached", Toast.LENGTH_SHORT);
            }
            //视频广告素材加载到，如title,视频url等，不包括视频文件
            @Override
            public void onRewardVideoAdLoad(TTRewardVideoAd ad) {
                MyToast.showMyToast2(SignActivity.this, "rewardVideoAd loaded", Toast.LENGTH_SHORT);
                mttRewardVideoAd = ad;
                //mttRewardVideoAd.setShowDownLoadBar(false);
                mttRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() {

                    @Override
                    public void onAdShow() {
                        MyToast.showMyToast2(SignActivity.this, "rewardVideoAd show", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onAdVideoBarClick() {
                        MyToast.showMyToast2(SignActivity.this, "rewardVideoAd bar click", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onAdClose() {
                        MyToast.showMyToast2(SignActivity.this, "rewardVideoAd close", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onVideoComplete() {
                        MyToast.showMyToast2(SignActivity.this, "rewardVideoAd complete", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onVideoError() {

                    }

                    @Override
                    public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName) {
                        MyToast.showMyToast2(SignActivity.this, "verify:"+rewardVerify+" amount:"+rewardAmount+
                                        " name:"+rewardName,
                                Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onSkippedVideo() {

                    }
                });
                mttRewardVideoAd.setDownloadListener(new TTAppDownloadListener() {
                    @Override
                    public void onIdle() {

                    }

                    @Override
                    public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {

                    }

                    @Override
                    public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {

                    }

                    @Override
                    public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {

                    }

                    @Override
                    public void onDownloadFinished(long totalBytes, String fileName, String appName) {

                    }

                    @Override
                    public void onInstalled(String fileName, String appName) {

                    }
                });
            }
        });
    }
}
