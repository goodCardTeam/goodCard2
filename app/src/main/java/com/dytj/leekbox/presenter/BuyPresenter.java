package com.dytj.leekbox.presenter;

import android.app.Activity;

import com.dytj.leekbox.api.UserNetWork;
import com.dytj.leekbox.api.baseFile.OkHttp3Utils;
import com.dytj.leekbox.model.BuyEntity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.mvpBase.BasePresenterImpl;
import com.dytj.leekbox.ui.activity.BuyActivity;
import com.dytj.leekbox.ui.fragment.CardFragment;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class BuyPresenter extends BasePresenterImpl<BuyContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public BuyPresenter(BuyContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (BuyActivity.REQUEST_BUY.equals(tag)) {
            buyPointRequest(userNetWork,map);
        }
    }

    /**
     * 获取交易列表
     * @param userNetWork
     * @param params
     */
    private void buyPointRequest(UserNetWork userNetWork, HashMap params) {
        userNetWork.buyPointRequest(params, new Observer<JsonResponse<BuyEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<BuyEntity> buyEntity) {
                if (buyEntity.getCode()==0) {
                    view.buyPointRequest(buyEntity, CardFragment.TRADE_LIST);
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
