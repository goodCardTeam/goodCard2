package com.dytj.goodcard.presenter;

import android.app.Activity;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.api.baseFile.OkHttp3Utils;
import com.dytj.goodcard.model.CreateTradeOrderEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.activity.CreateTradeOrderActivity;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class CreatTradeOrderPresenter extends BasePresenterImpl<CreatTradeOrderContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public CreatTradeOrderPresenter(CreatTradeOrderContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (CreateTradeOrderActivity.REQUEST_SELL.equals(tag)) {
            createTradeOrderRequest(userNetWork,map);
        }
    }

    /**
     * 获取交易列表
     * @param userNetWork
     * @param params
     */
    private void createTradeOrderRequest(UserNetWork userNetWork, HashMap params) {
        userNetWork.createTradeOrderRequest(params, new Observer<JsonResponse<CreateTradeOrderEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<CreateTradeOrderEntity> createTradeOrderEntity) {
                if (createTradeOrderEntity.getCode()==0) {
                    view.createOrder(createTradeOrderEntity, CreateTradeOrderActivity.REQUEST_SELL);
//                    view.showLoadingDialog("成功");
//                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    OkHttp3Utils.toLogin(mActivity,createTradeOrderEntity.getCode(),createTradeOrderEntity.getMsg());
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
