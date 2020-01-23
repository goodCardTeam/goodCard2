package com.dytj.goodcard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.chuanglan.cllc.CLLCSDKManager;
import com.chuanglan.cllc.listener.InitStateListener;
import com.dytj.goodcard.base.MyLifecycleHandler;
import com.dytj.goodcard.ui.activity.LivenessActivity;
import com.dytj.goodcard.ui.activity.LoginActivity;
import com.dytj.goodcard.utils.Constants;
import com.dytj.goodcard.utils.PreferenceHelper;
import com.dytj.goodcard.utils.TTAdManagerHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.bugly.Bugly;

import java.util.List;


/**
 * Created by zeng on 2019/4/9.
 */
public class MyApplication extends Application {
    private static Context context;
    public static MyApplication instance;
    /**
     * 打开的activity
     **/
    private static List<Activity> activities;
    private int activityCount = 0;//activity的count数
    private boolean isForeground = true;//是否在前台

    public static String PROCESS_NAME_XXXX = "process_name_xxxx";

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, R.color.blue_app);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            public ClassicsFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public static MyApplication getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = (MyApplication) getApplicationContext();
        context = (MyApplication) getApplicationContext();
        //初始化Bugly
        Bugly.init(getApplicationContext(), AppConfig.BUGLY_APP_ID, false);
        //初始化穿山甲
        initAdConfig();
        //初始化人脸识别
//        initOcr();
        registerActivityLifecycleCallbacks(new MyLifecycleHandler());
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                activityCount++;
                if (activityCount > 0) {
                    isForeground = true;
                }
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                activityCount--;
                if (0 == activityCount) {
                    isForeground = false;
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private void initAdConfig(){
        TTAdManagerHolder.init(this);
    }





    private void showToast(final String text) {

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
