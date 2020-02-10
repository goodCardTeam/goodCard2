package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dytj.goodcard.R;
import com.dytj.goodcard.api.baseFile.PersistentCookieStore;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.base.LifecycleBaseFragment;
import com.dytj.goodcard.base.LifecycleLazyFragment;
import com.dytj.goodcard.model.GoodsListEntity;
import com.dytj.goodcard.model.GoodsTypeEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.presenter.TbGoodsContact;
import com.dytj.goodcard.presenter.TbGoodsPresenter;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.ui.activity.Main2Activity;
import com.dytj.goodcard.ui.adapter.CardVpAdapter;
import com.dytj.goodcard.utils.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class NewsFragment extends LifecycleBaseFragment<TbGoodsPresenter> implements TbGoodsContact.view {
    private View view;
    private TabLayout mTab;
    private ViewPager mViewPager;
    public static final String REQUEST_TB_TYPE="request_tb_type";
    private List<GoodsTypeEntity> typeList=new ArrayList<>();
    private List<Fragment> fragmentList=new ArrayList<>();
    private List<String> titleList=new ArrayList<>();
    private AppBarLayout appbarLayout;
    private LinearLayout llSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_news, null);
        setContentView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        initView();
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        appbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("aaa","偏移量："+i);
                if(i<-200){
                    Log.e("aaa","偏移量：操作1------");
//                    llSearch.setVisibility(View.VISIBLE);
                    AnimationUtils.showAndHiddenAnimation(llSearch, AnimationUtils.AnimationState.STATE_SHOW,500);
                }else if(i>=-200){
                    Log.e("aaa","偏移量：操作2------");
                    llSearch.setVisibility(View.GONE);
//                    AnimationUtils.showAndHiddenAnimation(llSearch, AnimationUtils.AnimationState.STATE_HIDDEN,500);

                }
            }
        });
    }

    private void initData() {
        HashMap map = new HashMap<>();
        presenter.getData(map, REQUEST_TB_TYPE);
    }

    private void initView() {
        appbarLayout=view.findViewById(R.id.appbar_layout);
        mTab=view.findViewById(R.id.goods_tab);
        mViewPager=view.findViewById(R.id.goods_vp);
        llSearch=view.findViewById(R.id.news_ll_search);
    }

    @Override
    public void getGoodsTypeResponse(JsonResponse<List<GoodsTypeEntity>> tradeListEntity, String tag) {
        typeList.clear();
        fragmentList.clear();
        titleList.clear();
        if (null==tradeListEntity.getData()) {
            return;
        }
        typeList.addAll(tradeListEntity.getData());
        for(int i=0;i<typeList.size();i++){
            TbGoodsFragment fragment=TbGoodsFragment.newInstance(typeList.get(i).getMaterial_id());
            fragmentList.add(fragment);
            titleList.add(typeList.get(i).getName());
        }
        CardVpAdapter myFragmentAdapter = new CardVpAdapter(getActivity().getSupportFragmentManager(),
                fragmentList
                , titleList);

        mViewPager.setAdapter(myFragmentAdapter);

        mTab.setupWithViewPager(mViewPager);

    }

    @Override
    public void getGoodsListResponse(JsonResponse<GoodsListEntity> entityJsonResponse, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }

    @Override
    public TbGoodsPresenter initPresenter() {
        return new TbGoodsPresenter(this,getActivity());
    }
}
