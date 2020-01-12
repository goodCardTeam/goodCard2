package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.TradeOrderInfoEntity;
import com.dytj.goodcard.presenter.TradeOrderInfoContact;
import com.dytj.goodcard.presenter.TradeOrderInfoPresenter;
import com.dytj.goodcard.utils.MyToast;

import java.util.HashMap;

public class ComplainActivity extends LifecycleBaseActivity<TradeOrderInfoPresenter> implements TradeOrderInfoContact.view, View.OnClickListener  {

    public static final String TRADE_ORDER_COMPLAIN_REQUEST = "tradeOrderComplainRequest";
    private String tradeOrderId;
    private EditText etComplainContent;
    private Button btnComplainCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        ToolBarStyle(0);
        setBack(true);
        setTitle("投诉");
        initView();
        initData();
    }

    private void initView() {
        etComplainContent=findViewById(R.id.et_complain_content);
        btnComplainCommit=findViewById(R.id.btn_complain_commit);
        btnComplainCommit.setOnClickListener(this);
    }

    private void initData() {
        tradeOrderId = getIntent().getStringExtra("tradeOrderId");
    }


    public static void start(Activity activity, String tradeOrderId) {
        Intent intent = new Intent(activity, ComplainActivity.class);
        intent.putExtra("tradeOrderId", tradeOrderId);
        activity.startActivity(intent);
    }

    @Override
    public TradeOrderInfoPresenter initPresenter() {
        return new TradeOrderInfoPresenter(this, this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_complain_commit:
                String content=etComplainContent.getText().toString();
                if(TextUtils.isEmpty(content)){
                    MyToast.showMyToast2(getApplicationContext(),"请先输入投诉内容", Toast.LENGTH_SHORT);
                    return;
                }
                HashMap map = new HashMap();
                map.put("trade_order_id", tradeOrderId);
                map.put("content", content);
                presenter.getData(map, TRADE_ORDER_COMPLAIN_REQUEST);
                break;
        }
    }

    @Override
    public void tradeOrderInfoRequest(JsonResponse<TradeOrderInfoEntity> tradeListEntity, String tag) {

    }

    @Override
    public void tradeOrderPayRequest(JsonResponse tradeOrderPayEntity, String tag) {

    }

    @Override
    public void tradeOrderGetMoneyRequest(JsonResponse tradeOrderGetMoneyEntity, String tag) {

    }

    @Override
    public void tradeOrderComplainRequest(JsonResponse jsonResponse, String tag) {
        if(jsonResponse.getCode()==0){
            AppManager.getAppManager().finishActivity();
        }
    }

    @Override
    public void tradeOrderCancelRequest(JsonResponse jsonResponse, String tag) {

    }


    @Override
    public void ErrorData(Throwable e) {

    }
}
