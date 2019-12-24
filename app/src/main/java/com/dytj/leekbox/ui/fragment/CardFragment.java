package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dytj.leekbox.R;
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

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by MaRufei
 * on 2019-12-11.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class CardFragment extends LifecycleBaseFragment<CardPresenter> implements CardContact.view {
    private View view;
    public static final String TRADE_LIST = "tradeList";
    /**
     * 1.积分转交 2.积分获取
     */
    private int type;
    private RecyclerView cardRv;
    private SmartRefreshLayout cardRefresh;

    /**
     * 判断是买入还是卖出标识
     */
    String tradeType = "";

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

    private static final String TRADE_BUY="2";

    private static final String TRADE_SELL="1";

    @Override
    public CardPresenter initPresenter() {
        return new CardPresenter(this, getActivity());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater,container,savedInstanceState);
        view = View.inflate(getActivity(), R.layout.fragment_card, null);
        setContentView(view);
        super.onCreateView(inflater,container,savedInstanceState);
        initView();
        initListener();
        initData();
        return view;
    }

    private void initListener() {
        cardRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                myRefreshlayout = refreshLayout;
                listData.clear();
                currentPage = 1;
                getTradeList();
            }
        });

        cardRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                myLoadMoreLayout = refreshLayout;
                if (pages > currentPage) {
                    currentPage++;
                    getTradeList();
                } else {
                    myLoadMoreLayout.finishLoadMore(true);
                    MyToast.showMyToast2(getActivity(), "没有更多数据了",Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void initData() {
//        type=getActivity().getIntent().getIntExtra("type",0);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type", 0);
        }

        if (type == 1) {
            tradeType = TRADE_BUY;
        } else {
            tradeType = TRADE_SELL;
        }
        getTradeList();
    }

    private void initView() {
        cardRefresh=view.findViewById(R.id.card_refresh);

        cardRv=view.findViewById(R.id.card_rv);
        //设置LayoutManager为LinearLayoutManager
        cardRv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public static CardFragment newInstance(int type) {
        CardFragment myFragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    /**
     * 获取交易列表
     */
    private void getTradeList() {
        HashMap params = new HashMap();
        params.put("page", currentPage);
        params.put("per_page", "10");
        params.put("trade_type", tradeType);
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
        cardRv.setAdapter(new CommonAdapter<TradeListEntity.TradesBean>(getActivity(), R.layout.card_item, listData)
        {
            @Override
            public void convert(ViewHolder holder, TradeListEntity.TradesBean bean )
            {
                holder.setText(R.id.card_item_price,"￥"+bean.getPrice());
                holder.setText(R.id.card_item_point,String.valueOf(bean.getPoint()));
                if(TRADE_BUY.equals(tradeType)){
                    holder.setText(R.id.card_item_trade,"买入积分");
                }else {
                    holder.setText(R.id.card_item_trade,"卖出积分");
                }
                holder.setOnClickListener(R.id.card_item_trade, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(TRADE_BUY.equals(tradeType)){

                        }
                    }
                });
            }
        });
    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
