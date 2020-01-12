package com.dytj.goodcard.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.TradeOrderInfoEntity;
import com.dytj.goodcard.presenter.TradeOrderInfoContact;
import com.dytj.goodcard.presenter.TradeOrderInfoPresenter;
import com.dytj.goodcard.utils.Constants;
import com.dytj.goodcard.utils.MyToast;
import com.dytj.goodcard.utils.ToolUtils;
import com.google.gson.Gson;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class TradeOrderInfoActivity extends LifecycleBaseActivity<TradeOrderInfoPresenter> implements TradeOrderInfoContact.view, View.OnClickListener {
    public static final String TRADE_ORDER_INFO_REQUEST = "tradeOrderInfoRequest";
    public static final String TRADE_ORDER_PAY_REQUEST = "tradeOrderPayRequest";
    public static final String TRADE_ORDER_GET_MONEY_REQUEST = "tradeOrderGetMoneyRequest";
    /**
     * 需要进行检测的权限数组
     */
    private String[] permissions = new String[]{
            Manifest.permission.READ_PHONE_STATE};

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
    /**
     * 订单状态
     */
    private int status = -1;
    /**
     * 1.买家 2.卖家
     */
    private int user_type = -1;
    private Button tradeOrderTel;
    private Button tradeOrderCommit;
    private Button tradeOrderCancel;
    private static final int REQUEST_COMPLAIN = -10;
    private static final int REQUEST_CANCEL = 0;
    private static final int REQUEST_GET_SURE = 1;
    private static final int REQUEST_PAY_SURE = 2;

    /**
     * 卖家手机号
     */
    private String tradeUserTel;

    /**
     * 买家手机号
     */
    private String userTel;

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
        tradeOrderTel = findViewById(R.id.trade_order_info_tel);
        tradeOrderTel.setOnClickListener(this);
        tradeOrderCommit = findViewById(R.id.trade_order_info_commit);
        tradeOrderCommit.setOnClickListener(this);
        tradeOrderCancel = findViewById(R.id.trade_order_info_cancel);
        tradeOrderCancel.setOnClickListener(this);
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
                if (TextUtils.isEmpty(orderNo)) {
                    MyToast.showMyToast2(TradeOrderInfoActivity.this, "订单号不存在", Toast.LENGTH_SHORT);
                    return;
                }
                ToolUtils.copyText(getApplicationContext(), orderNo);
                break;
            case R.id.trade_order_info_cancel:
                break;
            case R.id.trade_order_info_tel:
                setPermission(permissions);
                break;
            case R.id.trade_order_info_commit:
                commit();
                break;
            default:
                break;
        }
    }

    private void commit() {
        int tag = (int) tradeOrderCommit.getTag();
        switch (tag) {
            case REQUEST_GET_SURE:
                HashMap params = new HashMap();
                params.put("trade_order_id", tradeOrderId);
                presenter.getData(params, TRADE_ORDER_GET_MONEY_REQUEST);
                break;
            case REQUEST_PAY_SURE:
                HashMap map = new HashMap();
                map.put("trade_order_id", tradeOrderId);
                map.put("payment_type", 1);
                presenter.getData(map, TRADE_ORDER_PAY_REQUEST);
                break;
            case REQUEST_COMPLAIN:
                ComplainActivity.start(TradeOrderInfoActivity.this,tradeOrderId);
                break;
        }
    }

    @Override
    public void tradeOrderInfoRequest(JsonResponse<TradeOrderInfoEntity> tradeListEntity, String tag) {
        Gson gson = new Gson();
        Log.e("aaa", "订单详情：" + gson.toJson(tradeListEntity));
        try {
            TradeOrderInfoEntity bean = tradeListEntity.getData();
            if (null == bean.getOrder()) {
                return;
            }
            status = bean.getOrder().getStatus();
            if (status == Constants.ORDER_TYPE_PAY ||
                    status == Constants.ORDER_TYPE_GET) {
                infoStatus.setTextColor(getResources().getColor(R.color.red_6729));
            } else if (status == Constants.ORDER_TYPE_FINNISH) {
                infoStatus.setTextColor(getResources().getColor(R.color.green_25));
            }
            user_type = bean.getOrder().getUser_type();
            orderNo = bean.getOrder().getOrder_no();
            tradeUserTel = bean.getTrade_user_tel();
            userTel = bean.getUser_tel();
            infoNo.setText(bean.getOrder().getOrder_no());
            infoStatus.setText(bean.getOrder().getStatus_text());
            infoBuyerName.setText(bean.getOrder().getUser().getTel());
            infoBuyerTel.setText(bean.getOrder().getUser().getTel());
            infoNumber.setText(String.valueOf(bean.getOrder().getPoint()));
            infoPrice.setText(bean.getOrder().getPrice());
            infoBuyerTime.setText(bean.getOrder().getCreated_at());
            if (null == bean.getOrder().getWechat() && null != bean.getOrder().getAlipay()) {
                infoPay.setText("支付宝");
                infoSellName.setText(bean.getOrder().getAlipay().getAccount());
                infoRealName.setText(bean.getOrder().getAlipay().getName());
            } else if (null != bean.getOrder().getWechat() && null == bean.getOrder().getAlipay()) {
                infoPay.setText("微信");
            }
            infoPayTime.setText(bean.getOrder().getReceive_time());
            infoFinishTime.setText(bean.getOrder().getSend_time());
            setButtonShow();
        } catch (Exception e) {

        }

    }

    @Override
    public void tradeOrderPayRequest(JsonResponse tradeOrderPayEntity, String tag) {
        if (tradeOrderPayEntity.getCode() == 0) {
            MyToast.showMyToast2(getApplicationContext(), "支付成功", Toast.LENGTH_SHORT);
            AppManager.getAppManager().finishActivity();
        }
    }

    @Override
    public void tradeOrderGetMoneyRequest(JsonResponse tradeOrderGetMoneyEntity, String tag) {
        if (tradeOrderGetMoneyEntity.getCode() == 0) {
            MyToast.showMyToast2(getApplicationContext(), "确认收款成功", Toast.LENGTH_SHORT);
            AppManager.getAppManager().finishActivity();
        }
    }

    @Override
    public void tradeOrderComplainRequest(JsonResponse jsonResponse, String tag) {

    }

    /**
     * 设置按钮展示情况
     */
    private void setButtonShow() {
        if (user_type == Constants.USER_TYPE_BUYER) {//买家
            if (status == Constants.ORDER_TYPE_CANCEL ||
                    status == Constants.ORDER_TYPE_FINNISH) {//取消
                tradeOrderCommit.setText("投诉");
                tradeOrderCommit.setTag(REQUEST_COMPLAIN);
                tradeOrderCommit.setVisibility(View.VISIBLE);
            } else if (status == Constants.ORDER_TYPE_GET) {//待收款
                tradeOrderCommit.setText("确认收款");
                tradeOrderCommit.setTag(REQUEST_GET_SURE);
                tradeOrderCommit.setVisibility(View.VISIBLE);
                tradeOrderCancel.setText("取消");
                tradeOrderCancel.setTag(REQUEST_CANCEL);
                tradeOrderCancel.setVisibility(View.VISIBLE);
            }
        } else if (user_type == Constants.USER_TYPE_SELLER) {//卖家
            if (status == Constants.ORDER_TYPE_CANCEL ||
                    status == Constants.ORDER_TYPE_FINNISH) {//取消
                tradeOrderCommit.setText("投诉");
                tradeOrderCommit.setTag(REQUEST_COMPLAIN);
                tradeOrderCommit.setVisibility(View.VISIBLE);
            } else if (status == Constants.ORDER_TYPE_PAY) {//待支付
                tradeOrderCommit.setText("确认打款");
                tradeOrderCommit.setTag(REQUEST_PAY_SURE);
                tradeOrderCommit.setVisibility(View.VISIBLE);
                tradeOrderCancel.setText("取消");
                tradeOrderCancel.setTag(REQUEST_CANCEL);
                tradeOrderCancel.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void ErrorData(Throwable e) {

    }

    /**
     * 拨打手机号
     */
    private void callPhone() {
        String phoneNum = "";
        if (user_type == Constants.USER_TYPE_BUYER) {
            phoneNum = tradeUserTel;
        } else {
            phoneNum = userTel;
        }
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
        if (ActivityCompat.checkSelfPermission(TradeOrderInfoActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    /**
     * 授权成功
     */
    @Override
    public void onAccreditSucceed() {
        super.onAccreditSucceed();
        callPhone();
    }

    /**
     * 授权失败
     */
    @Override
    public void onAccreditFailure() {
        super.onAccreditFailure();
        MyToast.showMyToast2(getApplicationContext(),"请先授权后再进行操作",Toast.LENGTH_SHORT);
    }
}
