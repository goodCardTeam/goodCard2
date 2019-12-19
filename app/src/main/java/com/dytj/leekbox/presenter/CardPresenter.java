package com.dytj.leekbox.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.dytj.leekbox.api.UserNetWork;
import com.dytj.leekbox.model.LoginEntity;
import com.dytj.leekbox.model.RegisterEntity;
import com.dytj.leekbox.model.TradeSimpleResult;
import com.dytj.leekbox.mvpBase.BasePresenterImpl;
import com.dytj.leekbox.ui.activity.LoginActivity;

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

    }
}
