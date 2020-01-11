package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.BuyEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.presenter.BuyContact;
import com.dytj.goodcard.presenter.BuyPresenter;
import com.dytj.goodcard.utils.Event;
import com.dytj.goodcard.utils.EventBusCodeUtil;
import com.dytj.goodcard.utils.EventBusUtil;
import com.dytj.goodcard.utils.MyToast;

import java.text.DecimalFormat;
import java.util.HashMap;

public class BuyActivity extends LifecycleBaseActivity<BuyPresenter> implements BuyContact.view, View.OnClickListener {

    private TextView buyYesterdayPrice;
    private ImageView buyReduce;
    private EditText buySinglePrice;
    private ImageView buyAdd;
    private EditText buyNum;
    private TextView buyFinalPrice;
    private Button buyCommit;
    public static final String REQUEST_BUY = "request_buy";
    private double buyPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ToolBarStyle(0);
        setBack(true);
        setTitle("我要买");
        initView();
        initListener();
        initData();
    }

    private void initListener() {
        buySinglePrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp = s.toString();
                buySinglePrice.setSelection(temp.length());
                int posDot = temp.indexOf(".");
                if (posDot == 0) {
                    buySinglePrice.setText("0" + temp);
                } else if (posDot > 0 && temp.length() - posDot - 1 > 3) {
                    s.delete(posDot + 4, posDot + 5);
                }
                if (TextUtils.isEmpty(buySinglePrice.getText().toString())) {
                    buyFinalPrice.setText("--");
                    return;
                }
                buyPrice = Double.parseDouble(buySinglePrice.getText().toString());
                getTotalPrice();
            }
        });
        buyNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(buyNum.getText().toString())) {
                    buyFinalPrice.setText("--");
                    return;
                }
                getTotalPrice();
            }
        });

    }

    private void initData() {
    }

    private void initView() {
        buyYesterdayPrice = findViewById(R.id.buy_yesterday_price);
        buyReduce = findViewById(R.id.buy_reduce);
        buyReduce.setOnClickListener(this);
        buySinglePrice = findViewById(R.id.buy_single_price);
        buyAdd = findViewById(R.id.buy_add);
        buyAdd.setOnClickListener(this);
        buyNum = findViewById(R.id.buy_num);
        buyFinalPrice = findViewById(R.id.buy_final_price);
        buyCommit = findViewById(R.id.buy_commit);
        buyCommit.setOnClickListener(this);
    }

    @Override
    public BuyPresenter initPresenter() {
        return new BuyPresenter(this, this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, BuyActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myBack:
                AppManager.getAppManager().finishActivity();
                break;
            case R.id.buy_reduce:
                buySinglePrice.setSelection(buySinglePrice.length());
                try {
                    buyPrice = Double.parseDouble(buySinglePrice.getText().toString());
                    if (buyPrice <= 0) {
                        return;
                    }
                    buyPrice = buyPrice - 0.001;
                } catch (Exception e) {
                    MyToast.showMyToast2(BuyActivity.this, "请输入正确的价格", Toast.LENGTH_SHORT);
                }
                DecimalFormat df1 = new DecimalFormat("#.000");
                buySinglePrice.setText(String.valueOf(df1.format(buyPrice)));
                getTotalPrice();
                break;
            case R.id.buy_add:
                buySinglePrice.setSelection(buySinglePrice.length());
                try {
                    buyPrice = Double.parseDouble(buySinglePrice.getText().toString());
                    buyPrice = buyPrice + 0.001;
                } catch (Exception e) {
                    MyToast.showMyToast2(BuyActivity.this, "请输入正确的价格", Toast.LENGTH_SHORT);
                }
                DecimalFormat df2 = new DecimalFormat("#.000");
                buySinglePrice.setText(String.valueOf(df2.format(buyPrice)));
                getTotalPrice();
                break;
            case R.id.buy_commit:
                if (TextUtils.isEmpty(buySinglePrice.getText().toString())) {
                    MyToast.showMyToast2(BuyActivity.this, "请先输入交易单价", Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(buyNum.getText().toString())) {
                    MyToast.showMyToast2(BuyActivity.this, "请先输入交易数量", Toast.LENGTH_SHORT);
                    return;
                }
                buyPointRequest();
                break;
            default:
                break;
        }
    }

    @Override
    public void buyPointRequest(JsonResponse<BuyEntity> tradeListEntity, String tag) {
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
     * 挂单
     */
    private void buyPointRequest() {
        HashMap map = new HashMap<>();
        map.put("point", buyNum.getText().toString().trim());
        map.put("price", buySinglePrice.getText().toString().trim());
        presenter.getData(map, REQUEST_BUY);
    }

    private void getTotalPrice() {
        if (TextUtils.isEmpty(buySinglePrice.getText().toString()) ||
                TextUtils.isEmpty(buyNum.getText().toString())) {
            return;
        }
        double totalPrice = buyPrice * Integer.parseInt(buyNum.getText().toString());
        DecimalFormat df3 = new DecimalFormat("#.00");
        buyFinalPrice.setText(String.valueOf(df3.format(totalPrice)));

    }
}
