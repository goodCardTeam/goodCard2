package com.dytj.goodcard.presenter;

import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.TradeOrderInfoEntity;
import com.dytj.goodcard.mvpBase.BasePresenter;
import com.dytj.goodcard.mvpBase.BaseView;

import java.util.HashMap;

/*
 * 创建时间:  2019/4/7 on 11:13
 * 用于设置Presenter里设置数据和获取数据的方法
 */
public interface TradeOrderInfoContact {

    interface view extends BaseView {
        /**
         * 买入积分
         * 用于网络请求成功失败后，回调给view的方法
         * @param tradeListEntity
         */
        void tradeOrderInfoRequest(JsonResponse<TradeOrderInfoEntity> tradeListEntity, String tag);

        /**
         * 确认打款
         * @param tradeOrderPayEntity
         * @param tag
         */
        void tradeOrderPayRequest(JsonResponse tradeOrderPayEntity, String tag);

        /**
         *
         * 确认收款
         * @param tradeOrderGetMoneyEntity
         * @param tag
         */
        void tradeOrderGetMoneyRequest(JsonResponse tradeOrderGetMoneyEntity, String tag);


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
