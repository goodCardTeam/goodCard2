package com.dytj.leekbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dytj.leekbox.AppManager;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.CreateTradeOrderEntity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.presenter.CreatTradeOrderContact;
import com.dytj.leekbox.presenter.CreatTradeOrderPresenter;
import com.dytj.leekbox.utils.Event;
import com.dytj.leekbox.utils.EventBusCodeUtil;
import com.dytj.leekbox.utils.EventBusUtil;

import java.util.HashMap;

public class CreateTradeOrderActivity extends LifecycleBaseActivity<CreatTradeOrderPresenter> implements CreatTradeOrderContact.view , View.OnClickListener  {

    public static final String REQUEST_SELL = "request_sell";
    private ImageButton myBack;
    private TextView title;
    private TextView sellCommit;
    private int tradeId;
    private String price;
    private TextView sellSinglePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trade_order);
        initView();
        initData();
    }

    public static void start(Activity activity,int trade_id,String price) {
        Intent intent = new Intent(activity, CreateTradeOrderActivity.class);
        intent.putExtra("price",price);
        intent.putExtra("trade_id",trade_id);
        activity.startActivity(intent);
    }

    private void initData() {
        title.setText("卖给TA");
        tradeId=getIntent().getIntExtra("trade_id",0);
        price=getIntent().getStringExtra("price");
        sellSinglePrice.setText(price);
    }

    private void initView() {
        myBack = findViewById(R.id.myBack);
        myBack.setVisibility(View.VISIBLE);
        myBack.setImageResource(R.mipmap.arrow_left_w);
        myBack.setOnClickListener(this);
        title = findViewById(R.id.title);
        sellCommit=findViewById(R.id.sell_commit);
        sellCommit.setOnClickListener(this);
        sellSinglePrice=findViewById(R.id.sell_single_price);
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
                sell();
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
    private void sell() {
        HashMap map = new HashMap<>();
        map.put("trade_id", tradeId);
        map.put("point", "1000");
        presenter.getData(map, REQUEST_SELL);
    }
}
