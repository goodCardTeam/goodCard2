package com.dytj.goodcard.utils;

import android.app.Activity;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.model.JsonResponse;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zeng on 2019/5/5.
 */

public class AutonymUtils {
    /**
     * 刷新token
     *
     * @param activity
     * @param myAutonymListeners
     */

    public static void refreshToken(Activity activity, final MyAutonymListener myAutonymListeners) {
        UserNetWork userNetWork = new UserNetWork();
        HashMap<String, Object> map = new HashMap<>();
        userNetWork.getUserRecordEntity(map, new Observer<JsonResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                //取消网络请求
                //d.dispose();
            }

            @Override
            public void onNext(JsonResponse jsonResponse) {
                if (jsonResponse.getCode()==0) {
                    //网络请求成功
                    myAutonymListeners.onSuccessful(jsonResponse);
                } else {
                    myAutonymListeners.onFailure();
                }
            }

            @Override
            public void onError(Throwable e) {
                //网络请求失败
                myAutonymListeners.onFailure();
            }

            @Override
            public void onComplete() {
                //网络请求完成
            }
        });
    }
}
