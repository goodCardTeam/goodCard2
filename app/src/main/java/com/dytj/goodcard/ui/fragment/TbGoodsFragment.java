package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseFragment;
import com.dytj.goodcard.base.LifecycleLazyFragment;
import com.dytj.goodcard.model.GoodsListEntity;
import com.dytj.goodcard.model.GoodsTypeEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.presenter.TbGoodsContact;
import com.dytj.goodcard.presenter.TbGoodsPresenter;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.ui.adapter.CommonAdapter;
import com.dytj.goodcard.ui.adapter.ViewHolder;
import com.dytj.goodcard.utils.RecyclerViewSpacesItemDecoration;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class TbGoodsFragment extends LifecycleBaseFragment<TbGoodsPresenter> implements TbGoodsContact.view {
    private View view;
    private RecyclerView goodsRv;
    public static final String REQUEST_TB_LIST="request_tb_list";
    private int goodsId=-1;
    private  List<GoodsListEntity.DataBeanX> list=new ArrayList<>();

    @Override
    public TbGoodsPresenter initPresenter() {
        return new TbGoodsPresenter(this,getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_tb_goods, null);
        setContentView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        initView();
        initData();
        return view;
    }

    private void initData() {
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Bundle bundle = getArguments();
        goodsId=bundle.getInt("goodsId",-1);
        if (goodsId<=0){
            return;
        }
        HashMap map = new HashMap<>();
        map.put("material_id",String.valueOf(goodsId));
        presenter.getData(map, REQUEST_TB_LIST);


    }

    private void initView() {
        goodsRv=view.findViewById(R.id.tb_goods_rv);
        //设置LayoutManager为LinearLayoutManager
        goodsRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.TOP_DECORATION,20);//top间距

//        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,100);//底部间距

        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.LEFT_DECORATION,15);//左间距

        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.RIGHT_DECORATION,15);//右间距

        goodsRv.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
//        textview.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG ); //中间横线
    }

    public static TbGoodsFragment newInstance(int goodsId) {
        TbGoodsFragment myFragment = new TbGoodsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("goodsId", goodsId);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void getGoodsTypeResponse(JsonResponse<List<GoodsTypeEntity>> tradeListEntity, String tag) {

    }

    @Override
    public void getGoodsListResponse(JsonResponse<GoodsListEntity> entity, String tag) {
        if (null!=entity.getData()&&null!=entity.getData().getData()) {
            list.addAll(entity.getData().getData());
            goodsRv.setAdapter(new CommonAdapter<GoodsListEntity.DataBeanX>(getActivity(), R.layout.item_goods, list) {
                @Override
                public void convert(ViewHolder holder, GoodsListEntity.DataBeanX data) {
                    String title=data.getData().getTitle();
                    String shopTitle=data.getData().getShop_title();
                    String amount=data.getCommission_rate();
                    String monthNumber=data.getData().getVolume();
                    String point=String.valueOf(data.getJifen());
                    String totalPrice=data.getZk_final_price();
                    String picUrl=data.getData().getPict_url();
                    float finalPrice=Float.valueOf(totalPrice)-Float.valueOf(amount);
                    DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
                    String p=decimalFormat.format(finalPrice);//format 返回的是字符串
                    holder.setText(R.id.tv_goods_title,title);
                    holder.setText(R.id.tv_goods_shop,shopTitle);
                    holder.setText(R.id.tv_goods_number,"月销"+monthNumber+"件");
                    holder.setText(R.id.tv_goods_amount,amount);
                    holder.setText(R.id.tv_goods_point,point);
                    holder.setTextLine(R.id.tv_goods_total,"￥"+totalPrice);
                    holder.setText(R.id.tv_goods_final,"￥"+p);
                    holder.setImageResource(R.id.iv_goods_pic,"https:"+picUrl);

                }
            });
        }
    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
