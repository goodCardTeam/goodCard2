package com.dytj.goodcard.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.mvpBase.BasePresenter;
import com.dytj.goodcard.mvpBase.BaseView;
import com.dytj.goodcard.utils.Event;
import com.dytj.goodcard.utils.EventBusUtil;
import com.dytj.goodcard.utils.MyToast;
import com.dytj.goodcard.utils.OSHelper;
import com.dytj.goodcard.utils.PreferenceHelper;
import com.dytj.goodcard.utils.StatusBarUtil;
import com.dytj.goodcard.utils.SystemToolUtils;
import com.dytj.goodcard.utils.ToolUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleRegistryOwner;

public abstract class LifecycleBaseActivity<P extends BasePresenter> extends CheckPermissionsActivity
        implements LifecycleRegistryOwner, BaseView {
    // 是否允许全屏
    //  private boolean mAllowFullScreen = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    private long time;
    public boolean wasBackground = false;    //声明一个布尔变量,记录当前的活动背景
    public UserNetWork userNetWork;
    protected P presenter;
    private int sTheme;

    @Override
    public LifecycleRegistry getLifecycle() {
        return this.mRegistry;
    }

    public LifecycleRegistry getmRegistry() {
        return mRegistry;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatusBar();
        switch (0) {
            case 0:
                sTheme = R.style.AppThemeLightBlue;
                break;
            case 1:
                sTheme = R.style.AppThemeDeepBlue;
                break;
            case 2:
                sTheme = R.style.AppThemeGreen;
                break;
            case 3:
                sTheme = R.style.AppThemePink;
                break;
            case 4:
                break;

        }
        setTheme(sTheme);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //透明状态栏
            window.setStatusBarColor(Color.TRANSPARENT);
            //透明导航栏
//            window.setNavigationBarColor(Color.TRANSPARENT);

        }
        setContentView(R.layout.view_title_bar);
        AppManager.getAppManager(this).addActivity(this);
        if (userNetWork == null) {
            userNetWork = new UserNetWork();
        }
        presenter = initPresenter();

        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isApplicationBroughtToBackground()) {
            //Logger.i("task: 从前台进入后台");
            wasBackground = true;
            doForAndBack(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    /*if (isBackground(this)&&JUCApplication.getInstance().isRestart){
      System.out.println("hotfix回调-点击home键调取了-回到后台");
      SophixManager.getInstance().killProcessSafely();
      JUCApplication.getInstance().setRestart(false);
    }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager(this).finishActivity(this);
        if (presenter != null) {
            presenter.detach();//在presenter中解绑释放view
            presenter = null;
        }

        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        if (wasBackground) {
            //Logger.i("task: 从后台回到前台");
            wasBackground = false;
            doForAndBack(this);
        }
        // isBackground(this);
    }

    /**
     * 在子类中初始化对应的presenter
     *
     * @return 相应的presenter
     */
    public abstract P initPresenter();

    public void setStatusNoBar() {
//    StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary),0);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.red_6729), 45);
    }

    public void setStatusYesBar() {
        StatusBarUtil.setTranslucent(this, 40);
        StatusBarUtil.setDarkStatusIcon(this, true);
    }


    //判断当前的应用程序是不是在运行
    //需要申请GETTask权限
    private boolean isApplicationBroughtToBackground() {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            String packageName = topActivity.getPackageName();
            if (!topActivity.getPackageName().equals(getPackageName())) {
                return true;
            }
        }
        return false;
    }


    private void doForAndBack(Context context) {
        if (wasBackground) {
            //进入后台操作
            //String str = this.getClass().toString().trim();
            time = System.currentTimeMillis();
        } else {
            //进入前台操作
            long time2 = System.currentTimeMillis();
            Log.e(time + "", time2 + "////" + (time - time2));
            if (time != -1 && time2 - time > 120 * 1000) {
                checkFirstOpen();
                time = -1;
            }
        }
    }

    private void checkFirstOpen() {
        if (!TextUtils.isEmpty(getAccess_token())) {
            //设置过密码
            boolean isFingerPrintEnable = PreferenceHelper.readBoolean(getUserId(), AppConfig.IS_PREFER_FINGERPRINT_ENABLE, false);
            if (!TextUtils.isEmpty(getGestureKey()) || isFingerPrintEnable) {
                boolean isPreferGestureEnable = PreferenceHelper.readBoolean(getUserId(), AppConfig.IS_PREFER_GESTURE_ENABLE, false);
            }
        }
    }

    //找到指定的Activity
    public Activity getActivity(Class className) {

        return AppManager.getAppManager().findActivity(className);
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    //结束指定的Activity
    public void endActivity(Class className) {
        AppManager.getAppManager().finishActivity(className);
    }

    //添加使用全局Toast1的提示(在底部)
    public void showShortToastBottom(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        MyToast.showMyToast(getApplicationContext(), message, Toast.LENGTH_SHORT);
    }

    //添加使用全局Toast2的提示（居中）
    public void showShortToastCenter(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        MyToast.showMyToast2(getApplicationContext(), message, Toast.LENGTH_SHORT);
    }

    //添加使用全局Toast2的提示（带图标的toast--成功）
    public void showShortToastIconOk(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        MyToast.showMyToastIconOk(getApplicationContext(), message, Toast.LENGTH_SHORT);
    }

    //添加使用全局Toast2的提示（带图标的toast--失败）
    public void showShortToastIconError(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        MyToast.showMyToastIconError(getApplicationContext(), message, Toast.LENGTH_SHORT);
    }

    /**
     * 当前登录状况下token，未登录字符串为空
     *
     * @return token
     */
    public String getAccess_token() {
        String token = "";
        try {
            token = PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_TOKEN_TAG, "");
        } catch (Exception e) {
            e.printStackTrace();
            token = "";
        }
        return token;
    }

    //获得当前登录的userId
    public String getUserId() {
        try {
            return PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_USERID_TAG, "");//userid保存
        } catch (Exception e) {
            Log.e("error_userid", e.getMessage() + "");
            e.printStackTrace();
            return "";
        }
    }

    //获取手势密码
    public String getGestureKey() {
        try {
            String lockKey = PreferenceHelper.readString(getUserId(), AppConfig.PREFER_GESTUREKEY_TAG, "");
            return lockKey;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取最近使用手机号
     *
     * @return phone  在登录状态下返回的是当前登录的手机号
     */
    public String getLatestPhone() {
        String phone = "";
        try {
            phone = PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_LTPHONE_TAG, "");
        } catch (Exception e) {
            e.printStackTrace();
            phone = "";
        }
        return phone;
    }

    /**
     * 是否实名认证
     *
     * @return
     */
    public boolean isAuthentify() {
        boolean isAuthentify = false;
        String userId = getUserId();
        if (!TextUtils.isEmpty(userId)) {
            isAuthentify = PreferenceHelper.readBoolean(userId, AppConfig.PREFER_IS_REALNAME, false);
        }
        return isAuthentify;
    }

    //得到注册渠道编号
    public String getRegisterChannelCode() {
        String umChannelCode = "";//注册渠道编号
    /*
       应用宝 097
      OPPO 096
      华为 095
      小米 094
      Vivo 093
      百度 092
      360 091
     */
        //友盟渠道名
        String umChannelStr = SystemToolUtils.getChannel(this, "UMENG_CHANNEL");
        if (umChannelStr == null) {
            umChannelCode = "";
            return umChannelCode;
        }
        switch (umChannelStr) {
            case "1_应用宝":
                umChannelCode = "097";
                break;
            case "15_oppo软件商店":
                umChannelCode = "096";
                break;
            case "7_华为":
                umChannelCode = "095";
                break;
            case "2_小米应用市场":
                umChannelCode = "094";
                break;
            case "19_vivo应用市场":
                umChannelCode = "093";
                break;
            case "9_百度":
                umChannelCode = "092";
                break;
            case "18_360平台":
                umChannelCode = "091";
                break;
        }
        if (TextUtils.isEmpty(umChannelCode)) {
            //注册来源 001:前台注册 002：后台添加 003：手机APP 004:手机WAP
            umChannelCode = "003";
        }
        return umChannelCode;
    }

    /**
     * 重写 getResource 方法，防止系统字体影响
     *
     * @return
     */
    @Override
    public Resources getResources() {//禁止app字体大小跟随系统字体大小调节
        Resources resources = super.getResources();
        if (resources != null && resources.getConfiguration().fontScale != 1.0f) {
            android.content.res.Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showLoadingDialog(String msg) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {

    }

    /**
     * ToolBar样式
     *
     * @param type 0 白  1 左右渐变 2 上下渐变
     */
    public void ToolBarStyle(int type) {
        switch (type) {
            case 0:
                findViewById(R.id.title_bar_tob).setBackgroundColor(getResources().getColor(R.color.white));
                ((TextView) findViewById(R.id.title)).setTextColor(getResources().getColor(R.color.gray_3));
                ((ImageButton) findViewById(R.id.myBack)).setImageResource(R.mipmap.arrow_left);
                ((TextView) findViewById(R.id.menu)).setTextColor(getResources().getColor(R.color.gray_3));
                setDarkStatusIcon(true);
                findViewById(R.id.title_line).setVisibility(View.VISIBLE);
                break;
            case 1:
//                findViewById(R.id.title_bar_tob).setBackgroundColor(getResources().getColor(R.color.transparent));
                ((TextView) findViewById(R.id.title)).setTextColor(getResources().getColor(R.color.white));
                ((ImageButton) findViewById(R.id.myBack)).setImageResource(R.mipmap.arrow_left_w);
                ((TextView) findViewById(R.id.menu)).setTextColor(getResources().getColor(R.color.white));
                setDarkStatusIcon(false);
                findViewById(R.id.title_line).setVisibility(View.GONE);
                break;
            case 2:
//                findViewById(R.id.title_bar_tob).setBackgroundResource(R.mipmap.toolbar_style_2);
                ((TextView) findViewById(R.id.title)).setTextColor(getResources().getColor(R.color.white));
                ((ImageButton) findViewById(R.id.myBack)).setImageResource(R.mipmap.arrow_left_w);
                ((TextView) findViewById(R.id.menu)).setTextColor(getResources().getColor(R.color.white));

                setDarkStatusIcon(false);
                break;
//            case 3:
//                findViewById(R.id.title_bar_tob).setBackgroundResource(R.drawable.style_color_3);
//                ((TextView) findViewById(R.id.title)).setTextColor(getResources().getColor(R.color.white));
//                ((ImageButton) findViewById(R.id.back)).setImageResource(R.drawable.ic_back);
//                ((TextView) findViewById(R.id.menu)).setTextColor(getResources().getColor(R.color.white));
//
//                setDarkStatusIcon(false);
//                break;
        }
    }

    /**
     * 状态栏 亮暗
     *
     * @param bDark
     */
    public void setDarkStatusIcon(boolean bDark) {

        //如果是Android 6.0以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = getWindow().getDecorView();
            if (decorView != null) {
                int vis = decorView.getSystemUiVisibility();
                if (bDark) {
                    vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                } else {
                    vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
                decorView.setSystemUiVisibility(vis);
            }
        }

        if (OSHelper.isMIUI()) {
            setMiuiStatusBarDarkMode(this, bDark);
        }


        if (OSHelper.isFlyme()) {
            setMeizuStatusBarDarkIcon(this, bDark);
        }

    }

    /**
     * MIUI 系统
     *
     * @param activity
     * @param darkmode 字体颜色为黑色。
     * @return
     */
    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Flyme 系统
     *
     * @param activity
     * @param dark     字体颜色
     * @return
     */
    public static boolean setMeizuStatusBarDarkIcon(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
//                LogUtil.e(TAG, e.getMessage());
            }
        }
        return result;
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        RelativeLayout titlebar = findViewById(R.id.title_bar_tob);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) titlebar.getLayoutParams();
        //获取状态栏高度 加上 要设置的标题栏高度 等于 标题栏实际高度
        layoutParams.height = ToolUtils.getStatusHeight() + ToolUtils.dp2px(48);
        titlebar.setLayoutParams(layoutParams);

        TextView tv = findViewById(R.id.title);

//        if (BuildConfig.LogShow) {
//            tv.setText(title + "(测试)");
//        } else {
        tv.setText(title);
//        }
    }

    /**
     * 设置状态栏颜色
     *
     * @param color
     */
    public void setZT(String color, boolean bDark) {
        RelativeLayout titlebar = findViewById(R.id.title_bar_tob);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) titlebar.getLayoutParams();
        //获取状态栏高度 加上 要设置的标题栏高度 等于 标题栏实际高度
        layoutParams.height = ToolUtils.getStatusHeight();
        titlebar.setLayoutParams(layoutParams);
        titlebar.setBackgroundColor(Color.parseColor(color));

        setDarkStatusIcon(bDark);
    }

    /**
     * 是否有返回键
     *
     * @param isvisible
     */
    public void setBack(boolean isvisible) {
        ImageButton backBtn = findViewById(R.id.myBack);
        if (isvisible) {
            backBtn.setVisibility(View.VISIBLE);
        } else {
            backBtn.setVisibility(View.GONE);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                onBackPressed();
                finish();
            }
        });

    }

    /**
     * 设置菜单
     *
     * @param objects 图片或者文字/文字或者颜色/颜色
     */
    public void setMenu(Object... objects) {
        TextView MENU = findViewById(R.id.menu);
        if (objects.length > 0) {
            MENU.setVisibility(View.VISIBLE);
            MENU.setOnClickListener((View.OnClickListener) this);
            //判断是不是图
            if (objects[0] instanceof Integer) {

                Drawable drawableleft = getResources().getDrawable((Integer) objects[0]);
                drawableleft.setBounds(0, 0, drawableleft.getIntrinsicWidth(), drawableleft.getMinimumHeight());
                MENU.setCompoundDrawables(drawableleft, null, null, null);//只放左边

                //判断是不是字
                if (objects.length > 1 && objects[1] instanceof String) {

                    MENU.setText((String) objects[1]);

                    //判断是不是颜色
                    if (objects.length > 2 && objects[2] instanceof Integer) {

                        MENU.setTextColor(getResources().getColor((Integer) objects[2]));

                    }
                }
            }

            //判断是不是字
            if (objects[0] instanceof String) {

                MENU.setText((String) objects[0]);
                //判断是不是颜色
                if (objects.length > 1 && objects[1] instanceof Integer) {
                    MENU.setTextColor(getResources().getColor((Integer) objects[1]));
                }
            }
        } else {
            MENU.setVisibility(View.GONE);
        }
    }
}