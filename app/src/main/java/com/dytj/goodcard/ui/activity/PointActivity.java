package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.TradeListEntity;
import com.dytj.goodcard.presenter.CardContact;
import com.dytj.goodcard.presenter.CardPresenter;
import com.dytj.goodcard.ui.adapter.CommonAdapter;
import com.dytj.goodcard.ui.adapter.ViewHolder;
import com.dytj.goodcard.utils.Event;
import com.dytj.goodcard.utils.EventBusCodeUtil;
import com.dytj.goodcard.utils.MyToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class PointActivity extends LifecycleBaseActivity<CardPresenter> implements CardContact.view , View.OnClickListener {

    private SmartRefreshLayout pointRefresh;
    private RecyclerView pointRv;

    public static final String TRADE_LIST = "tradeList";
    /**
     * 数据源
     */
    private  List<TradeListEntity.TradesBean> listData=new ArrayList<>();

    /**
     * 当前页 默认为1
     */
    private int currentPage=1;
    private RefreshLayout myRefreshlayout;
    private RefreshLayout myLoadMoreLayout;
    /**
     * 总页数
     */
    private int pages;
    private TextView menu;
    private TextView title;
    private ImageButton myBack;
    private TextView pointBuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatusYesBar();
        setContentView(R.layout.activity_point);
        ToolBarStyle(0);
        setBack(true);
        setTitle("积分市场");
        setMenu("我的交易",R.color.gray_3);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        getTradeList();
    }

    private void initListener() {
        pointRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                myRefreshlayout = refreshLayout;
                listData.clear();
                currentPage = 1;
                getTradeList();
            }
        });

        pointRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                myLoadMoreLayout = refreshLayout;
                if (pages > currentPage) {
                    currentPage++;
                    getTradeList();
                } else {
                    myLoadMoreLayout.finishLoadMore(true);
                    MyToast.showMyToast2(PointActivity.this, "没有更多数据了", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @Override
    public CardPresenter initPresenter() {
        return new CardPresenter(this, this);
    }

    private void initView() {
        pointRefresh = findViewById(R.id.point_refresh);
        pointRv = findViewById(R.id.point_rv);
        //设置LayoutManager为LinearLayoutManager
        pointRv.setLayoutManager(new LinearLayoutManager(this));
        pointBuy=findViewById(R.id.point_buy);
        pointBuy.setOnClickListener(this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, PointActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 获取交易列表
     */
    private void getTradeList() {
        HashMap params = new HashMap();
        params.put("page", currentPage);
        params.put("per_page", "10");
        presenter.getData(params, TRADE_LIST);
    }

    @Override
    public void setTradeListData(JsonResponse<TradeListEntity> tradeListEntity, String tag) {
        //刷新成功
        if (myRefreshlayout != null) {
            myRefreshlayout.finishRefresh(true);
        }
        if (myLoadMoreLayout != null) {
            myLoadMoreLayout.finishLoadMore(true);
        }
        pages=tradeListEntity.getData().getPages();
        currentPage=tradeListEntity.getData().getPage();
        List<TradeListEntity.TradesBean> trades=tradeListEntity.getData().getTrades();
        listData.addAll(trades);
        pointRv.setAdapter(new CommonAdapter<TradeListEntity.TradesBean>(this, R.layout.card_item, listData)
        {
            @Override
            public void convert(ViewHolder holder, final TradeListEntity.TradesBean bean )
            {
                holder.setText(R.id.card_item_price,"￥"+bean.getPrice());
                holder.setText(R.id.card_item_point,String.valueOf(bean.getLeft()));
                holder.setText(R.id.card_item_tel,bean.getUser().getTel());
                holder.setOnClickListener(R.id.card_item_trade, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(TextUtils.isEmpty(bean.getPrice())||bean.getId()<=0){
                            return;
                        }
                        CreateTradeOrderActivity.start(PointActivity.this,bean.getId(),bean.getPrice());
                    }
                });
            }
        });
    }

    @Override
    public void ErrorData(Throwable e) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myBack:
                AppManager.getAppManager().finishActivity();
                break;
            case R.id.menu:
                MyTradeOrderActivity.start(this);
                break;
            case R.id.point_buy:
                BuyActivity.start(this);
                break;
        }
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceived(Event event) {
        switch (event.getCode()){
            case EventBusCodeUtil.EventCode.A:
                listData.clear();
                currentPage=1;
                getTradeList();
                break;
        }
    }
}
