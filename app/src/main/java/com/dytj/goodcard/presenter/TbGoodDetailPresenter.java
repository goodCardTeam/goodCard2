package com.dytj.goodcard.presenter;

import android.app.Activity;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.api.baseFile.OkHttp3Utils;
import com.dytj.goodcard.model.BuyEntity;
import com.dytj.goodcard.model.GoodDetailEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.activity.BuyActivity;
import com.dytj.goodcard.ui.activity.TbGoodDetailActivity;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 *
 */
public class TbGoodDetailPresenter extends BasePresenterImpl<TbGoodDetailContact.view> implements TbGoodDetailContact.presenter {
    private Activity mActivity;

    public TbGoodDetailPresenter(TbGoodDetailContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (TbGoodDetailActivity.TB_GOOD_DETAIL_REQUEST.equals(tag)) {
            goodDetailRequest(userNetWork,map);
        }
    }

    /**
     * @param userNetWork
     * @param params
     */
    private void goodDetailRequest(UserNetWork userNetWork, HashMap params) {
        userNetWork.tbGoodDetailRequest(params, new Observer<JsonResponse<GoodDetailEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<GoodDetailEntity> entityJsonResponse) {
                if (entityJsonResponse.getCode()==0) {
                    view.setGoodDetail(entityJsonResponse, TbGoodDetailActivity.TB_GOOD_DETAIL_REQUEST);
//                    view.showLoadingDialog("成功");
//                    Toast.makeText(mActivity, "请求成功", Toast.LENGTH_SHORT).show();
                } else {
                    OkHttp3Utils.toLogin(mActivity,entityJsonResponse.getCode(),entityJsonResponse.getMsg());
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
