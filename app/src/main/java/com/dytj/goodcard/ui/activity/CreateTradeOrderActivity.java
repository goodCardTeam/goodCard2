package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.CreateTradeOrderEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.presenter.CreatTradeOrderContact;
import com.dytj.goodcard.presenter.CreatTradeOrderPresenter;
import com.dytj.goodcard.utils.Event;
import com.dytj.goodcard.utils.EventBusCodeUtil;
import com.dytj.goodcard.utils.EventBusUtil;
import com.dytj.goodcard.utils.MyToast;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CreateTradeOrderActivity extends LifecycleBaseActivity<CreatTradeOrderPresenter> implements CreatTradeOrderContact.view , View.OnClickListener  {

    public static final String REQUEST_SELL = "request_sell";
    private TextView sellCommit;
    private int tradeId;
    private String price;
    private TextView sellSinglePrice;
    private EditText sellNum;
    private TextView sellFinalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trade_order);
        ToolBarStyle(0);
        setBack(true);
        setTitle("卖给TA");
        initView();
        initListener();
        initData();
    }

    private void initListener() {
        sellNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(sellNum.getText().toString())){
                    sellFinalPrice.setText("--");
                    return;
                }
                getTotalPrice();
            }
        });
    }

    public static void start(Activity activity,int trade_id,String price) {
        Intent intent = new Intent(activity, CreateTradeOrderActivity.class);
        intent.putExtra("price",price);
        intent.putExtra("trade_id",trade_id);
        activity.startActivity(intent);
    }

    private void initData() {
        tradeId=getIntent().getIntExtra("trade_id",0);
        price=getIntent().getStringExtra("price");
        sellSinglePrice.setText(price);
    }

    private void initView() {
        sellCommit=findViewById(R.id.sell_commit);
        sellCommit.setOnClickListener(this);
        sellSinglePrice=findViewById(R.id.sell_single_price);
        sellNum=findViewById(R.id.sell_num);
        sellFinalPrice=findViewById(R.id.sell_final_price);
    }

    @Override
    public CreatTradeOrderPresenter initPresenter() {
        return new CreatTradeOrderPresenter(this,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myBack:
                AppManager.getAppManager().finishActivity();
                break;
            case R.id.sell_commit:
                String sellNumStr=sellNum.getText().toString();
                if(TextUtils.isEmpty(sellNumStr)){
                    MyToast.showMyToast2(getApplicationContext(),"请先输入卖出数量", Toast.LENGTH_SHORT);
                    return;
                }
                double sellNumDouble=Double.parseDouble(sellNumStr);
                if(sellNumDouble<1000){
                    MyToast.showMyToast2(getApplicationContext(),"卖出数量最少为1000个", Toast.LENGTH_SHORT);
                    return;
                }
                sell(sellNumStr);
                break;
        }
    }

    @Override
    public void createOrder(JsonResponse<CreateTradeOrderEntity> createTradeOrderEntity, String tag) {
        AppManager.getAppManager().finishActivity();
        sendEventA();
    }

    @Override
    public void ErrorData(Throwable e) {

    }

    public void sendEventA() {
        EventBusUtil.sendEvent(new Event(EventBusCodeUtil.EventCode.A));
    }

    /**
     * 卖积分，创建订单
     */
    private void sell(String str) {
        HashMap map = new HashMap<>();
        map.put("trade_id", tradeId);
        map.put("point", str);
        presenter.getData(map, REQUEST_SELL);
    }

    private void getTotalPrice() {
        if (TextUtils.isEmpty(sellNum.getText().toString())) {
            return;
        }
        double sellPrice=Double.parseDouble(price);
        double totalPrice = sellPrice * Integer.parseInt(sellNum.getText().toString());
        DecimalFormat df3 = new DecimalFormat("#.00");
        sellFinalPrice.setText(String.valueOf(df3.format(totalPrice)));

    }
}
