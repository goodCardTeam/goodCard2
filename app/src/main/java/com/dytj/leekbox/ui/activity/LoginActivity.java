package com.dytj.leekbox.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.leekbox.AppConfig;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.presenter.LoginContact;
import com.dytj.leekbox.presenter.LoginPresenter;
import com.dytj.leekbox.utils.PreferenceHelper;
import com.dytj.leekbox.utils.ToolUtils;

import java.util.HashMap;

import androidx.cardview.widget.CardView;

/**
 * Created by MaRufei
 * on 2019-09-24.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class LoginActivity extends LifecycleBaseActivity<LoginPresenter>
        implements LoginContact.view, View.OnClickListener {


    /**
     * 抬高view1
     */
    ObjectAnimator animator01;

    /**
     * 抬高view2
     */
    ObjectAnimator animator02;

    /**
     * 压低view1
     */
    ObjectAnimator animator03;

    /**
     * 压低view2
     */
    ObjectAnimator animator04;

    /**
     * 横向放大view1
     */
    ObjectAnimator animator05;

    /**
     * 横向放大view2
     */
    ObjectAnimator animator06;

    /**
     * 横向缩小view1
     */
    ObjectAnimator animator07;

    /**
     * 横向缩小view2
     */
    ObjectAnimator animator08;

    /**
     * 当前是否正在获取验证码
     */
    boolean isGetOtping = false;
    private CardView otpView;
    private CardView pwdView;
    private ImageView otpPhoneClearView;
    private ImageView otpPwdClearView;
    private Button btnRegister;
    private LinearLayout llRegisterIns;
    private LinearLayout llRegisterSend;
    private ImageView ivPasswordClose;
    private ImageView ivPhoneClose;
    private EditText etLoginOtpAccount;
    private EditText etLoginOtpOtp;
    private EditText editPhone;
    private EditText editPassword;
    private Button loginOtpLogin;
    private Button loginOtpForget;
    private TextView btnSend;

    public static final String REQUEST_LOGIN="login";
    public static final String REQUEST_REGISTER="register";
    public static final String REQUEST_SMS="sms";
    private EditText editCode;
    private RelativeLayout rlInvite;
    private EditText editInvite;
    private ImageView ivInviteClose;
    private CountDownTimer timer;
    /**
     * 登录手机号
     */
    private String tel;
    /**
     * 登录密码
     */
    private String password;

    @Override
    public LoginPresenter initPresenter() {
        return new LoginPresenter(this, LoginActivity.this);
    }

    @Override
    public void setData(JsonResponse<LoginEntity> loginEntity, String tag) {
        if(REQUEST_LOGIN.equals(tag)){
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
    public void setRegisterData(RegisterEntity registerData, String tag) {

        if(REQUEST_REGISTER.equals(tag)){
            tel=editPhone.getText().toString().trim();
            password=editPassword.getText().toString().trim();
            login();
        }
    }

    @Override
    public void setSmsData(JsonResponse jsonResponse, String tag) {
        if(REQUEST_SMS.equals(tag)){
            timer.start();
        }
    }

    @Override
    public void setRefreshData(JsonResponse<LoginEntity> loginEntity, String tag) {

    }


    @Override
    public void ErrorData(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        editPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    ivPhoneClose.setVisibility(View.VISIBLE);
                }else {
                    ivPhoneClose.setVisibility(View.GONE);
                }
            }
        });
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    ivPasswordClose.setVisibility(View.VISIBLE);
                }else {
                    ivPasswordClose.setVisibility(View.GONE);
                }
            }
        });

        etLoginOtpAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    otpPhoneClearView.setVisibility(View.VISIBLE);
                }else {
                    otpPhoneClearView.setVisibility(View.GONE);
                }
            }
        });

        etLoginOtpOtp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    otpPwdClearView.setVisibility(View.VISIBLE);
                }else {
                    otpPwdClearView.setVisibility(View.GONE);
                }
            }
        });

        editInvite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    ivInviteClose.setVisibility(View.VISIBLE);
                }else {
                    ivInviteClose.setVisibility(View.GONE);
                }
            }
        });

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnSend.setEnabled(false);
                btnSend.setText("已发送(" + millisUntilFinished / 1000 + ")");
            }
            @Override
            public void onFinish() {
                btnSend.setEnabled(true);
                btnSend.setText("重新获取");
            }
        };


    }

    private void initData() {

    }

    public static void start(Activity activity){
        Intent intent=new Intent(activity,LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    private void initView() {

        otpView = findViewById(R.id.login_otp_view);
        otpView.setOnClickListener(this);
        pwdView = findViewById(R.id.login_pwd_view);
        pwdView.setOnClickListener(this);
        otpPhoneClearView = findViewById(R.id.login_otp_account_clean);
        otpPhoneClearView.setOnClickListener(this);
        otpPwdClearView = findViewById(R.id.login_otp_otp_clean);
        otpPwdClearView.setOnClickListener(this);
        btnRegister=findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
        llRegisterIns=findViewById(R.id.ll_register_ins);
        llRegisterSend=findViewById(R.id.ll_register_send);
        ivPasswordClose=findViewById(R.id.iv_password_close);
        ivPasswordClose.setOnClickListener(this);
        ivPhoneClose=findViewById(R.id.iv_phone_close);
        ivPhoneClose.setOnClickListener(this);
        etLoginOtpAccount=findViewById(R.id.et_login_otp_account);
        etLoginOtpOtp=findViewById(R.id.et_login_otp_otp);
        editPhone=findViewById(R.id.edit_phone);
        editPassword=findViewById(R.id.edit_password);

        loginOtpLogin=findViewById(R.id.login_otp_login);
        loginOtpLogin.setOnClickListener(this);
        loginOtpForget=findViewById(R.id.login_otp_forget);
        loginOtpForget.setOnClickListener(this);
        btnSend=findViewById(R.id.btn_send);
        btnSend.setOnClickListener(this);
        editCode=findViewById(R.id.edit_code);

        rlInvite=findViewById(R.id.rl_invite);
        editInvite=findViewById(R.id.edit_invite);
        ivInviteClose=findViewById(R.id.iv_invite_close);
        ivInviteClose.setOnClickListener(this);

        /**
         * 抬高view1
         */
        animator01 = ObjectAnimator.ofFloat(otpView, "elevation",
                Float.valueOf(ToolUtils.dp2px(5F)), Float.valueOf(ToolUtils.dp2px(10F)));
        /**
         * 抬高view2
         */
        animator02 = ObjectAnimator.ofFloat(pwdView, "elevation",
                Float.valueOf(ToolUtils.dp2px(5F)), Float.valueOf(ToolUtils.dp2px(10F)));
        /**
         * 压低view1
         */
        animator03 = ObjectAnimator.ofFloat(otpView, "elevation",
                Float.valueOf(ToolUtils.dp2px(10F)), Float.valueOf(ToolUtils.dp2px(5F)));
        /**
         * 压低view2
         */
        animator04 = ObjectAnimator.ofFloat(pwdView, "elevation",
                Float.valueOf(ToolUtils.dp2px(10F)), Float.valueOf(ToolUtils.dp2px(5F)));
        /**
         * 横向放大view1
         */
        animator05 = ObjectAnimator.ofFloat(otpView, "scaleX", 0.93F, 1F);
        /**
         * 横向放大view2
         */
        animator06 = ObjectAnimator.ofFloat(pwdView, "scaleX", 0.93F, 1F);
        /**
         * 横向缩小view1
         */
        animator07 = ObjectAnimator.ofFloat(otpView, "scaleX", 1F, 0.93F);
        /**
         * 横向缩小view2
         */
        animator08 = ObjectAnimator.ofFloat(pwdView, "scaleX", 1F, 0.93F);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_otp_view:
                pwdView.setEnabled(true);
                otpView.setEnabled(false);
                btnRegister.setVisibility(View.GONE);
                llRegisterIns.setVisibility(View.VISIBLE);
                llRegisterSend.setVisibility(View.GONE);
                rlInvite.setVisibility(View.GONE);
                AnimatorSet set_1 = new AnimatorSet();
                set_1.setDuration(300);
                set_1.setInterpolator(new AccelerateDecelerateInterpolator());
                set_1.playTogether(animator01, animator04, animator05, animator08);
                set_1.start();
                break;
            case R.id.login_pwd_view:
                otpView.setEnabled(true);
                pwdView.setEnabled(false);
                btnRegister.setVisibility(View.VISIBLE);
                llRegisterIns.setVisibility(View.GONE);
                llRegisterSend.setVisibility(View.VISIBLE);
                rlInvite.setVisibility(View.VISIBLE);
                AnimatorSet set_2 = new AnimatorSet();
                set_2.setDuration(300);
                set_2.setInterpolator(new AccelerateDecelerateInterpolator());
                set_2.playTogether(animator02, animator03, animator06, animator07);
                set_2.start();
                break;
            case R.id.login_otp_account_clean:
                otpPhoneClearView.setVisibility(View.GONE);
                etLoginOtpAccount.setText("");
                break;
            case R.id.login_otp_otp_clean:
                otpPwdClearView.setVisibility(View.GONE);
                etLoginOtpOtp.setText("");
                break;
            case R.id.btn_register://注册
                checkRegisterParams();
                break;
            case R.id.iv_password_close:
                ivPasswordClose.setVisibility(View.GONE);
                editPassword.setText("");
                break;
            case R.id.iv_phone_close:
                ivPhoneClose.setVisibility(View.GONE);
                editPhone.setText("");
                break;
            case R.id.iv_invite_close:
                ivInviteClose.setVisibility(View.GONE);
                editInvite.setText("");
                break;
            case R.id.login_otp_login://登录
                checkLoginParams();
                break;
            case R.id.login_otp_forget://忘记密码
                break;
            case R.id.btn_send://发送验证码
                sendSms();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    /**
     * 登录检查参数配置
     */
    private void checkLoginParams(){
        if(TextUtils.isEmpty(etLoginOtpAccount.getText().toString())){
            Toast.makeText(this,"请先输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(etLoginOtpOtp.getText().toString())){
            Toast.makeText(this,"请先输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        login();
    }

    /**
     * 注册检查参数配置
     */
    private void checkRegisterParams(){
        if(TextUtils.isEmpty(editPhone.getText().toString())){
            Toast.makeText(this,"请先输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(editCode.getText().toString())){
            Toast.makeText(this,"请先输入验证码",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(editPassword.getText().toString())){
            Toast.makeText(this,"请先输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        register();
    }

    /**
     * 登录
     */
    private void login(){
        HashMap params=new HashMap();
        tel=etLoginOtpAccount.getText().toString().trim();
        password=etLoginOtpOtp.getText().toString().trim();
        params.put("tel",tel);
        params.put("password",password);
        presenter.getData(params, REQUEST_LOGIN);
    }

    /**
     * 注册
     */
    private void register(){
        HashMap params=new HashMap();
        params.put("tel",editPhone.getText().toString().trim());
        params.put("vercode",editCode.getText().toString().trim());
        params.put("password",editPassword.getText().toString().trim());
        String inventCode=editInvite.getText().toString().trim();
        if(TextUtils.isEmpty(inventCode)){
            inventCode="";
        }
        params.put("invite_code",inventCode);
        presenter.getData(params,REQUEST_REGISTER);
    }

    /**
     * 发送验证码
     */
    private void sendSms(){
        if(TextUtils.isEmpty(editPhone.getText().toString())){
            Toast.makeText(this,"请先输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap params=new HashMap();
        params.put("tel",editPhone.getText().toString().trim());
        params.put("type","1");
        presenter.getData(params,REQUEST_SMS);
    }
}
