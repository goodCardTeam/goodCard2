package com.dytj.leekbox.presenter;

import android.app.Activity;

import com.dytj.leekbox.api.UserNetWork;
import com.dytj.leekbox.api.baseFile.OkHttp3Utils;
import com.dytj.leekbox.model.BuyEntity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.TradeOrderInfoEntity;
import com.dytj.leekbox.mvpBase.BasePresenterImpl;
import com.dytj.leekbox.ui.activity.BuyActivity;
import com.dytj.leekbox.ui.activity.TradeOrderInfoActivity;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class TradeOrderInfoPresenter extends BasePresenterImpl<TradeOrderInfoContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public TradeOrderInfoPresenter(TradeOrderInfoContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (TradeOrderInfoActivity.TRADE_ORDER_INFO_REQUEST.equals(tag)) {
            tradeOrderInfoRequest(userNetWork,map);
        }
    }

    /**
     * 获取交易列表
     * @param userNetWork
     * @param params
     */
    private void tradeOrderInfoRequest(UserNetWork userNetWork, HashMap params) {
        userNetWork.tradeOrderInfoRequest(params, new Observer<JsonResponse<TradeOrderInfoEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<TradeOrderInfoEntity> buyEntity) {
                if (buyEntity.getCode()==0) {
                    view.tradeOrderInfoRequest(buyEntity, TradeOrderInfoActivity.TRADE_ORDER_INFO_REQUEST);
//                    view.showLoadingDialog("成功");
//                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    OkHttp3Utils.toLogin(mActivity,buyEntity.getCode(),buyEntity.getMsg());
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
