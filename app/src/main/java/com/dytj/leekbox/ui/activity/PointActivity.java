package com.dytj.leekbox.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.leekbox.AppManager;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.base.LifecycleBaseFragment;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.presenter.CardContact;
import com.dytj.leekbox.presenter.CardPresenter;
import com.dytj.leekbox.ui.adapter.CommonAdapter;
import com.dytj.leekbox.ui.adapter.ViewHolder;
import com.dytj.leekbox.utils.MyToast;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusYesBar();
        setContentView(R.layout.activity_point);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        title.setText("积分市场");
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
        title = findViewById(R.id.title);
        myBack=findViewById(R.id.myBack);
        myBack.setImageResource(R.mipmap.arrow_left_w);
        myBack.setVisibility(View.VISIBLE);
        myBack.setOnClickListener(this);
        menu=findViewById(R.id.menu);
        menu.setText("我的交易");
        menu.setVisibility(View.VISIBLE);
        menu.setTextColor(getResources().getColor(R.color.white));
        menu.setOnClickListener(this);
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
            public void convert(ViewHolder holder, TradeListEntity.TradesBean bean )
            {
                holder.setText(R.id.card_item_price,"￥"+bean.getPrice());
                holder.setText(R.id.card_item_point,String.valueOf(bean.getPoint()));
                holder.setOnClickListener(R.id.card_item_trade, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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

                break;
        }
    }
}
