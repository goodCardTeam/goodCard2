package com.dytj.goodcard.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.model.LoginEntity;
import com.dytj.goodcard.model.RegisterEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.activity.LoginActivity;
import com.dytj.goodcard.ui.activity.SplashActivity;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class LoginPresenter extends BasePresenterImpl<LoginContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public LoginPresenter(LoginContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }

    /**
     * 获取数据
     */
    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (LoginActivity.REQUEST_LOGIN.equals(tag)) {
            login(userNetWork, map);
        }else if(LoginActivity.REQUEST_REGISTER.equals(tag)){
            register(userNetWork,map);
        }else if(LoginActivity.REQUEST_SMS.equals(tag)){
            getSms(userNetWork,map);
        }else if(SplashActivity.REQUEST_REFRESH.equals(tag)){
            refreshToken(userNetWork,map);
        }
    }


    /**
     * 登录的网络请求
     *
     * @param userNetWork
     */
    private void login(UserNetWork userNetWork, HashMap params) {
        userNetWork.userLogin(params, new Observer<JsonResponse<LoginEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<LoginEntity> loginEntity) {
                if (loginEntity.getCode()==0) {
                    view.setData(loginEntity, LoginActivity.REQUEST_LOGIN);
                    view.showLoadingDialog("成功");
                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, loginEntity.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
                view.ErrorData(e);
                view.dismissLoadingDialog();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 注册
     * @param userNetWork
     * @param map
     */
    private void register(UserNetWork userNetWork, HashMap map) {
        userNetWork.userRegister(map, new Observer<RegisterEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterEntity registerEntity) {
                if (registerEntity.getCode()==0) {
                    view.setRegisterData(registerEntity, LoginActivity.REQUEST_REGISTER);
                    view.showLoadingDialog("成功");
                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, registerEntity.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
                view.ErrorData(e);
                view.dismissLoadingDialog();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 获取验证码
     * @param userNetWork
     * @param map
     */
    private void getSms(UserNetWork userNetWork,HashMap map){
        userNetWork.usergetSms(map, new Observer<JsonResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse jsonResponse) {
                if (jsonResponse.getCode()==0) {
                    view.setSmsData(jsonResponse, LoginActivity.REQUEST_SMS);
                    view.showLoadingDialog("成功");
                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, jsonResponse.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
                view.ErrorData(e);
                view.dismissLoadingDialog();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 刷新token
     * @param userNetWork
     * @param map
     */
    private void refreshToken(UserNetWork userNetWork, HashMap map) {
        userNetWork.refreshToken(map, new Observer<JsonResponse<LoginEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<LoginEntity> loginEntity) {
                if (loginEntity.getCode()==0) {
                    view.setRefreshData(loginEntity, SplashActivity.REQUEST_REFRESH);
                    view.showLoadingDialog("成功");
                } else {
                    Toast.makeText(mActivity, loginEntity.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
                view.ErrorData(e);
                view.dismissLoadingDialog();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
