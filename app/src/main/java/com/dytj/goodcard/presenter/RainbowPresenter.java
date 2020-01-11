package com.dytj.goodcard.presenter;

import android.app.Activity;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.api.baseFile.OkHttp3Utils;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.RainbowEntity;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.fragment.ActiveFragment;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class RainbowPresenter extends BasePresenterImpl<RainbowContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public RainbowPresenter(RainbowContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (ActiveFragment.RAINBOW.equals(tag)) {
            rainbowList(userNetWork,map);
        }
    }

    /**
     * 获取交易列表
     * @param userNetWork
     * @param params
     */
    private void rainbowList(UserNetWork userNetWork, HashMap params) {
        userNetWork.rainbowList(params, new Observer<JsonResponse<RainbowEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<RainbowEntity> tradeListEntity) {
                if (tradeListEntity.getCode()==0) {
                    view.setRainbowListData(tradeListEntity, ActiveFragment.RAINBOW);
                } else {
                    OkHttp3Utils.toLogin(mActivity,tradeListEntity.getCode(),tradeListEntity.getMsg());
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
