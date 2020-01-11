package com.dytj.goodcard.presenter;

import android.app.Activity;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.api.baseFile.OkHttp3Utils;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.TradeListEntity;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.fragment.CardFragment;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class CardPresenter extends BasePresenterImpl<CardContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public CardPresenter(CardContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (CardFragment.TRADE_LIST.equals(tag)) {
            tradeList(userNetWork,map);
        }
    }

    /**
     * 获取交易列表
     * @param userNetWork
     * @param params
     */
    private void tradeList(UserNetWork userNetWork, HashMap params) {
        userNetWork.tradeList(params, new Observer<JsonResponse<TradeListEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<TradeListEntity> tradeListEntity) {
                if (tradeListEntity.getCode()==0) {
                    view.setTradeListData(tradeListEntity, CardFragment.TRADE_LIST);
//                    view.showLoadingDialog("成功");
//                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
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
