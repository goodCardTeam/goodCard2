package com.dytj.leekbox.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.TradeOrderInfoEntity;
import com.dytj.leekbox.presenter.RainbowContact;
import com.dytj.leekbox.presenter.RainbowPresenter;
import com.dytj.leekbox.presenter.TradeOrderInfoContact;
import com.dytj.leekbox.presenter.TradeOrderInfoPresenter;
import com.dytj.leekbox.utils.MyToast;
import com.dytj.leekbox.utils.ToolUtils;
import com.google.gson.Gson;

import java.util.HashMap;

public class TradeOrderInfoActivity extends LifecycleBaseActivity<TradeOrderInfoPresenter> implements TradeOrderInfoContact.view, View.OnClickListener {
    public static final String TRADE_ORDER_INFO_REQUEST = "tradeOrderInfoRequest";

    /**
     * 订单id
     */
    private String tradeOrderId;
    private TextView infoNo;
    private ImageView infoCopy;
    private TextView infoStatus;
    private TextView infoBuyerName;
    private TextView infoBuyerTel;
    private TextView infoNumber;
    private TextView infoPrice;
    private TextView infoBuyerTotal;
    private TextView infoBuyerTime;
    private TextView infoPay;
    private TextView infoSellName;
    private TextView infoRealName;
    private TextView infoPayMoney;
    private TextView infoPayTime;
    private TextView infoFinishTime;
    /**
     * 订单号
     */
    private String orderNo;

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

    public static void start(Activity activity, String tradeOrderId) {
        Intent intent = new Intent(activity, TradeOrderInfoActivity.class);
        intent.putExtra("tradeOrderId", tradeOrderId);
        activity.startActivity(intent);
    }

    private void initView() {
        infoNo = findViewById(R.id.trade_order_info_no);
        infoCopy = findViewById(R.id.trade_order_info_copy);
        infoCopy.setOnClickListener(this);
        infoStatus = findViewById(R.id.trade_order_info_status);
        infoBuyerName = findViewById(R.id.trade_order_info_buyer_name);
        infoBuyerTel = findViewById(R.id.trade_order_info_buyer_tel);
        infoNumber = findViewById(R.id.trade_order_info_buyer_number);
        infoPrice = findViewById(R.id.trade_order_info_buyer_price);
        infoBuyerTotal = findViewById(R.id.trade_order_info_buyer_total);
        infoBuyerTime = findViewById(R.id.trade_order_info_buyer_time);
        infoPay = findViewById(R.id.trade_order_info_sell_pay);
        infoSellName = findViewById(R.id.trade_order_info_sell_name);
        infoRealName = findViewById(R.id.trade_order_info_sell_real_name);
        infoPayMoney = findViewById(R.id.trade_order_info_sell_total);
        infoPayTime = findViewById(R.id.trade_order_info_sell_pay_time);
        infoFinishTime = findViewById(R.id.trade_order_info_sell_f_time);
    }

    private void initData() {
        tradeOrderId = getIntent().getStringExtra("tradeOrderId");
        getTradeOrderInfo();
    }

    private void getTradeOrderInfo() {
        HashMap params = new HashMap();
        params.put("trade_order_id", tradeOrderId);
        presenter.getData(params, TRADE_ORDER_INFO_REQUEST);
    }

    @Override
    public TradeOrderInfoPresenter initPresenter() {
        return new TradeOrderInfoPresenter(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trade_order_info_copy:
                if(TextUtils.isEmpty(orderNo)){
                    MyToast.showMyToast2(TradeOrderInfoActivity.this,"订单号不存在", Toast.LENGTH_SHORT);
                    return;
                }
                ToolUtils.copyText(getApplicationContext(),orderNo);
                break;
        }
    }

    @Override
    public void tradeOrderInfoRequest(JsonResponse<TradeOrderInfoEntity> tradeListEntity, String tag) {
        Gson gson=new Gson();
        Log.e("aaa","订单详情："+gson.toJson(tradeListEntity));
        try {
            TradeOrderInfoEntity bean = tradeListEntity.getData();
            orderNo=bean.getOrder().getOrder_no();
            infoNo.setText(bean.getOrder().getOrder_no());
            infoStatus.setText(bean.getOrder().getStatus_text());
            infoBuyerName.setText(bean.getOrder().getUser().getTel());
            infoBuyerTel.setText(bean.getOrder().getUser().getTel());
            infoNumber.setText(String.valueOf(bean.getOrder().getPoint()));
            infoPrice.setText(bean.getOrder().getPrice());
            infoBuyerTime.setText(bean.getOrder().getCreated_at());
            if(null==bean.getOrder().getWechat()&&null!=bean.getOrder().getAlipay()){
                infoPay.setText("支付宝");
                infoSellName.setText(bean.getOrder().getAlipay().getAccount());
                infoRealName.setText(bean.getOrder().getAlipay().getName());
            }else if(null!=bean.getOrder().getWechat()&&null==bean.getOrder().getAlipay()){
                infoPay.setText("微信");
            }
            infoPayTime.setText(bean.getOrder().getReceive_time());
            infoFinishTime.setText(bean.getOrder().getSend_time());
        } catch (Exception e) {

        }

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
