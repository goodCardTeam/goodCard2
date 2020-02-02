package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chuanglan.cllc.CLLCSDKManager;
import com.chuanglan.cllc.listener.InitStateListener;
import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.LunBoTuEntity;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.presenter.TestPresenter;
import com.dytj.goodcard.utils.MyToast;

public class CertificationActivity extends LifecycleBaseActivity<TestPresenter> implements TestContact.view, View.OnClickListener {

    private EditText certificationNumber;
    private EditText certificationName;
    private Button certificationCommit;
    public static String CARD_ID = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";
    public static String NAME = "^(([a-zA-Z+\\.?\\·?a-zA-Z+]{2,30}$)|([\\u4e00-\\u9fa5+\\·?\\u4e00-\\u9fa5+]{2,30}$))";
    /**
     * 需要进行检测的权限数组
     */
    private String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.VIBRATE,
            Manifest.permission.CAMERA};
    private String name;
    private String cardNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);
        ToolBarStyle(0);
        setBack(true);
        setTitle("实名认证");
        initView();
    }

    private void initView() {
        certificationNumber = findViewById(R.id.certification_number);
        certificationName = findViewById(R.id.certification_name);
        certificationCommit = findViewById(R.id.certification_commit);
        certificationCommit.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.certification_commit:
                name = certificationName.getText().toString().trim();
                cardNo = certificationNumber.getText().toString().trim();
                if (TextUtils.isEmpty(cardNo)) {
                    MyToast.showMyToast2(getApplicationContext(), "身份证号码不能为空", Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    MyToast.showMyToast2(getApplicationContext(), "身份证姓名不能为空", Toast.LENGTH_SHORT);
                    return;
                }
                if (!cardNo.matches(CARD_ID)) {
                    MyToast.showMyToast2(getApplicationContext(), "身份证号码格式不正确", Toast.LENGTH_SHORT);
                    return;
                }
                if (!name.matches(NAME)) {
                    MyToast.showMyToast2(getApplicationContext(), "身份证姓名不正确", Toast.LENGTH_SHORT);
                    return;
                }
                setPermission(permissions);
                break;
        }
    }

    @Override
    public void setData(LunBoTuEntity lunBoTuEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }


    /**
     * 授权成功
     */
    @Override
    public void onAccreditSucceed() {
        super.onAccreditSucceed();
        Log.e("aaa", "授权成功");
        initOcr();
    }

    /**
     * 授权失败
     */
    @Override
    public void onAccreditFailure() {
        super.onAccreditFailure();
        MyToast.showMyToast2(getApplicationContext(), "请先授权后再进行操作", Toast.LENGTH_SHORT);
    }

    public void initOcr() {
        Log.e("aaa", "开始授权");
        CLLCSDKManager.getInstance().init(getApplicationContext(), AppConfig.OCR_JSON,
                AppConfig.OCR_APP_ID, AppConfig.OCR_APP_KEY,
                new InitStateListener() {
                    @Override
                    public void getInitStatus(int code, String msg) {
                        Log.e("aaa", "code:" + code + " --msg:" + msg);
                        if (code == 1000) {
                            startLiveness(CertificationActivity.this);
                        }
                    }
                });
    }

    public void startLiveness(Context context) {

        try {
            Bundle bundle = new Bundle();

            /**
             * OUTPUT_TYPE 配置, 传入的outputType类型为singleImg （单图），multiImg （多图），video（低质量视频），fullvideo（高质量视频）
             */
            bundle.putString(LivenessActivity.OUTTYPE, "video");

            /**
             * EXTRA_MOTION_SEQUENCE 动作检测序列配置，支持四种检测动作， BLINK(眨眼), MOUTH（张嘴）, NOD（点头）, YAW（摇头）, 各个动作以空格隔开。 推荐第一个动作为BLINK。
             * 默认配置为"BLINK MOUTH NOD YAW"
             */
            bundle.putString(LivenessActivity.EXTRA_MOTION_SEQUENCE, "BLINK MOUTH NOD YAW");

            /**
             * SOUND_NOTICE 配置, 传入的soundNotice为boolean值，true为打开, false为关闭。
             */
            bundle.putBoolean(LivenessActivity.SOUND_NOTICE, false);

            /**
             * COMPLEXITY 配置, 传入的complexity类型为normal,支持四种难度，easy, normal, hard, hell.
             */
            bundle.putString(LivenessActivity.COMPLEXITY, "hard");

            Intent intent = new Intent(context, LivenessActivity.class)
                    .putExtras(bundle)
                    .putExtra(LivenessActivity.NAME, name)
                    .putExtra(LivenessActivity.CAR_NO, cardNo);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
