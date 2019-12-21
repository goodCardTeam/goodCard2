package com.dytj.leekbox.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.dytj.leekbox.api.UserNetWork;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.model.TradeSimpleResult;
import com.dytj.leekbox.mvpBase.BasePresenterImpl;
import com.dytj.leekbox.ui.activity.LoginActivity;

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
        }
    }


    /**
     * 登录的网络请求
     *
     * @param userNetWork
     */
    private void login(UserNetWork userNetWork, HashMap params) {
        userNetWork.userLogin(params, new Observer<LoginEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginEntity loginEntity) {
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
        userNetWork.usergetSms(map, new Observer<TradeSimpleResult>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TradeSimpleResult tradeSimpleResult) {
                if (tradeSimpleResult.getCode()==0) {
                    view.setSmsData(tradeSimpleResult, LoginActivity.REQUEST_SMS);
                    view.showLoadingDialog("成功");
                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, tradeSimpleResult.getMsg(), Toast.LENGTH_SHORT).show();
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
