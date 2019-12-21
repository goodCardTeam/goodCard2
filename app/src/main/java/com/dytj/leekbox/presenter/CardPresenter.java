package com.dytj.leekbox.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.dytj.leekbox.MyApplication;
import com.dytj.leekbox.api.UserNetWork;
import com.dytj.leekbox.api.baseFile.OkHttp3Utils;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.model.TradeSimpleResult;
import com.dytj.leekbox.mvpBase.BasePresenterImpl;
import com.dytj.leekbox.ui.activity.LoginActivity;
import com.dytj.leekbox.ui.fragment.CardFragment;
import com.dytj.leekbox.utils.MyToast;

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
        userNetWork.tradeList(params, new Observer<TradeListEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TradeListEntity tradeListEntity) {
                if (tradeListEntity.getCode()==0) {
                    view.setTradeListData(tradeListEntity, "tradeList");
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
