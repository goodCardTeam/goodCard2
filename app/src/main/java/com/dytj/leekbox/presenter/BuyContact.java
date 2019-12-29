package com.dytj.leekbox.presenter;

import com.dytj.leekbox.model.BuyEntity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.mvpBase.BasePresenter;
import com.dytj.leekbox.mvpBase.BaseView;

import java.util.HashMap;

/*
 * 创建时间:  2019/4/7 on 11:13
 * 用于设置Presenter里设置数据和获取数据的方法
 */
public interface BuyContact {

    interface view extends BaseView {
        /**
         * 买入积分
         * 用于网络请求成功失败后，回调给view的方法
         * @param tradeListEntity
         */
        void buyPointRequest(JsonResponse<BuyEntity> tradeListEntity, String tag);


        void ErrorData(Throwable e);
    }

    interface presenter extends BasePresenter {
        /**
         * 获取数据
         * 用于view层发起网络请求，获取数据
         */
        void getData(HashMap<Object, Object> map, String tag);
    }
}
