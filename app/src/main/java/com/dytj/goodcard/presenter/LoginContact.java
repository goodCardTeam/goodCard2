package com.dytj.goodcard.presenter;

import com.dytj.goodcard.model.LoginEntity;
import com.dytj.goodcard.model.RegisterEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.mvpBase.BasePresenter;
import com.dytj.goodcard.mvpBase.BaseView;

import java.util.HashMap;

/*
 * 创建时间:  2019/4/7 on 11:13
 * 用于设置Presenter里设置数据和获取数据的方法
 */
public interface LoginContact {

    interface view extends BaseView {
        /**
         * 设置登录数据源
         * 用于网络请求成功失败后，回调给view的方法
         * @param loginEntity
         */
        void setData(JsonResponse<LoginEntity> loginEntity, String tag);

        /**
         * 注册数据源
         * @param registerData
         * @param tag
         */
        void setRegisterData(RegisterEntity registerData,String tag);

        /**
         * 获取短信
         * @param jsonResponse
         */
        void setSmsData(JsonResponse jsonResponse, String tag);

        /**
         * 刷新token
         * @param tag
         */
        void setRefreshData(JsonResponse<LoginEntity> loginEntity,String tag);


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
