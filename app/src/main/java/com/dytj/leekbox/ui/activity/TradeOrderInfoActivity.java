package com.dytj.leekbox.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.TradeOrderInfoEntity;
import com.dytj.leekbox.presenter.RainbowContact;
import com.dytj.leekbox.presenter.RainbowPresenter;
import com.dytj.leekbox.presenter.TradeOrderInfoContact;
import com.dytj.leekbox.presenter.TradeOrderInfoPresenter;

import java.util.HashMap;

public class TradeOrderInfoActivity extends LifecycleBaseActivity<TradeOrderInfoPresenter> implements TradeOrderInfoContact.view, View.OnClickListener {
    public static final String TRADE_ORDER_INFO_REQUEST="tradeOrderInfoRequest";

    /**
     * 订单id
     */
    private String tradeOrderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_order_info);
        ToolBarStyle(0);
        setBack(true);
        setTitle("订单详情");
        initView();
        initData();
    }

    public static void start(Activity activity,String tradeOrderId) {
        Intent intent = new Intent(activity, TradeOrderInfoActivity.class);
        intent.putExtra("tradeOrderId",tradeOrderId);
        activity.startActivity(intent);
    }

    private void initView() {

    }

    private void initData() {
        tradeOrderId=getIntent().getStringExtra("tradeOrderInfo");
        getTradeOrderInfo();
    }

    private void getTradeOrderInfo() {
        HashMap params = new HashMap();
        params.put("trade_order_id",tradeOrderId);
        presenter.getData(params, TRADE_ORDER_INFO_REQUEST);
    }

    @Override
    public TradeOrderInfoPresenter initPresenter() {
        return new TradeOrderInfoPresenter(this,this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void tradeOrderInfoRequest(JsonResponse<TradeOrderInfoEntity> tradeListEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
