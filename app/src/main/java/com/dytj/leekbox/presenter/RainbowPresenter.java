package com.dytj.leekbox.presenter;

import android.app.Activity;

import com.dytj.leekbox.api.UserNetWork;
import com.dytj.leekbox.api.baseFile.OkHttp3Utils;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.RainbowEntity;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.mvpBase.BasePresenterImpl;
import com.dytj.leekbox.ui.fragment.CardFragment;
import com.dytj.leekbox.ui.fragment.RainbowFragment;

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
        if (RainbowFragment.RAINBOW.equals(tag)) {
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
                    view.setRainbowListData(tradeListEntity, RainbowFragment.RAINBOW);
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
