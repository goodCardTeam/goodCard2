package com.dytj.goodcard.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.LoginEntity;
import com.dytj.goodcard.model.RegisterEntity;
import com.dytj.goodcard.model.UserInfoEntity;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.activity.LoginActivity;
import com.dytj.goodcard.ui.activity.SplashActivity;
import com.dytj.goodcard.ui.fragment.MineFragment;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class UserInfoPresenter extends BasePresenterImpl<UserInfoContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public UserInfoPresenter(UserInfoContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }

    /**
     * 获取数据
     */
    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (MineFragment.USER_INFO.equals(tag)) {
            getUserInfoRequest(userNetWork, map);
        }
    }


    /**
     * 登录的网络请求
     *
     * @param userNetWork
     */
    private void getUserInfoRequest(UserNetWork userNetWork, HashMap params) {
        userNetWork.getUserInfoRequest(params, new Observer<JsonResponse<UserInfoEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<UserInfoEntity> entity) {
                if (entity.getCode()==0) {
                    view.setUserInfoData(entity, MineFragment.USER_INFO);
                    view.showLoadingDialog("成功");
                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mActivity, entity.getMsg(), Toast.LENGTH_SHORT).show();
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
