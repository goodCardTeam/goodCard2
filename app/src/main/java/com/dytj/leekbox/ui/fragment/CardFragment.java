package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseFragment;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.MyTradeOrderEntity;
import com.dytj.leekbox.model.TradeListEntity;
import com.dytj.leekbox.presenter.CardContact;
import com.dytj.leekbox.presenter.CardPresenter;
import com.dytj.leekbox.presenter.MyTradeOrderContact;
import com.dytj.leekbox.presenter.MyTradeOrderPresenter;
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
public class CardFragment extends LifecycleBaseFragment<MyTradeOrderPresenter> implements MyTradeOrderContact.view {
    private View view;
    public static final String TRADE_LIST = "tradeList";
    /**
     * -10:已取消0:待打款10:待收款20:已完成
     */
    private String status;
    private RecyclerView cardRv;
    private SmartRefreshLayout cardRefresh;

    /**
     * 数据源
     */
    private List<MyTradeOrderEntity.OrdersBean> listData = new ArrayList<>();

    /**
     * 当前页 默认为1
     */
    private int currentPage = 1;
    private RefreshLayout myRefreshlayout;
    private RefreshLayout myLoadMoreLayout;
    /**
     * 总页数
     */
    private int pages;


    @Override
    public MyTradeOrderPresenter initPresenter() {
        return new MyTradeOrderPresenter(this, getActivity());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_card, null);
        setContentView(view);
        super.onCreateView(inflater, container, savedInstanceState);
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
                    MyToast.showMyToast2(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    private void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getString("status");
        }

        getTradeList();
    }

    private void initView() {
        cardRefresh = view.findViewById(R.id.card_refresh);

        cardRv = view.findViewById(R.id.card_rv);
        //设置LayoutManager为LinearLayoutManager
        cardRv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    public static CardFragment newInstance(String status) {
        CardFragment myFragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("status", status);
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
        params.put("status", status);
        params.put("trade_id", "14");
        presenter.getData(params, TRADE_LIST);
    }

    @Override
    public void setTradeListData(JsonResponse<MyTradeOrderEntity> orderEntity, String tag) {
        //刷新成功
        if (myRefreshlayout != null) {
            myRefreshlayout.finishRefresh(true);
        }
        if (myLoadMoreLayout != null) {
            myLoadMoreLayout.finishLoadMore(true);
        }
        pages = orderEntity.getData().getPages();
        currentPage = orderEntity.getData().getPage();
        List<MyTradeOrderEntity.OrdersBean> orders = orderEntity.getData().getOrders();
        if (null != orders) {
            listData.addAll(orders);
        }
        cardRv.setAdapter(new CommonAdapter<MyTradeOrderEntity.OrdersBean>(getActivity(), R.layout.item_trade_order, listData) {
            @Override
            public void convert(ViewHolder holder, MyTradeOrderEntity.OrdersBean bean) {
            }
        });
    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
