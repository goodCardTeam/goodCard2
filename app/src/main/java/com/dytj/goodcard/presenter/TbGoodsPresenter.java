package com.dytj.goodcard.presenter;

import android.app.Activity;
import android.util.Log;

import com.dytj.goodcard.api.UserNetWork;
import com.dytj.goodcard.api.baseFile.OkHttp3Utils;
import com.dytj.goodcard.model.BuyEntity;
import com.dytj.goodcard.model.GoodsListEntity;
import com.dytj.goodcard.model.GoodsTypeEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.mvpBase.BasePresenterImpl;
import com.dytj.goodcard.ui.activity.BuyActivity;
import com.dytj.goodcard.ui.fragment.NewsFragment;
import com.dytj.goodcard.ui.fragment.TbGoodsFragment;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *  P层示例
 * 创建时间:  2019/4/7 on 11:17
 *
 */
public class TbGoodsPresenter extends BasePresenterImpl<TbGoodsContact.view> implements TestContact.presenter {
    private Activity mActivity;

    public TbGoodsPresenter(TbGoodsContact.view view, Activity activity) {
        super(view);
        mActivity = activity;
    }


    @Override
    public void getData(HashMap<Object, Object> map, String tag) {
        UserNetWork userNetWork = new UserNetWork();
        if (NewsFragment.REQUEST_TB_TYPE.equals(tag)) {
            tbGoodsTypeRequest(userNetWork,map);
        }else if(TbGoodsFragment.REQUEST_TB_LIST.equals(tag)){
            tbGoodsListRequest(userNetWork,map);
        }
    }

    /**
     * 获取淘宝客商品分类
     * @param userNetWork
     * @param params
     */
    private void tbGoodsTypeRequest(UserNetWork userNetWork, HashMap params) {
        userNetWork.tbGoodsTypeRequest(params, new Observer<JsonResponse<List<GoodsTypeEntity>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<List<GoodsTypeEntity>> entity) {
                if (entity.getCode()==0) {
                    view.getGoodsTypeResponse(entity, NewsFragment.REQUEST_TB_TYPE);
                } else {
                    OkHttp3Utils.toLogin(mActivity,entity.getCode(),entity.getMsg());
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

    /**
     * 获取淘宝订单列表
     * @param userNetWork
     * @param params
     */
    private void tbGoodsListRequest(UserNetWork userNetWork,HashMap params){
        userNetWork.tbGoodsListRequest(params, new Observer<JsonResponse<GoodsListEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonResponse<GoodsListEntity> entity) {
                Gson gson=new Gson();
                Log.e("aaa","gson:"+gson.toJson(entity));
                if (entity.getCode()==0) {
                    view.getGoodsListResponse(entity, TbGoodsFragment.REQUEST_TB_LIST);
                } else {
                    OkHttp3Utils.toLogin(mActivity,entity.getCode(),entity.getMsg());
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
