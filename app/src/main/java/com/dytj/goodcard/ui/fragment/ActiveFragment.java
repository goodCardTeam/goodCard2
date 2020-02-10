package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseFragment;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.RainbowEntity;
import com.dytj.goodcard.presenter.RainbowContact;
import com.dytj.goodcard.presenter.RainbowPresenter;
import com.dytj.goodcard.ui.activity.RainbowActivity;
import com.dytj.goodcard.ui.activity.SignActivity;
import com.dytj.goodcard.ui.adapter.CommonAdapter;
import com.dytj.goodcard.ui.adapter.ViewHolder;
import com.dytj.goodcard.view.galleryView.CardScaleHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class ActiveFragment extends LifecycleBaseFragment<RainbowPresenter> implements RainbowContact.view, View.OnClickListener {

    private View view;
    private RecyclerView mRecyclerView;
    private CardScaleHelper mCardScaleHelper;
    private List<Integer> mList = new ArrayList<>();
    private ImageView mBlurView;
    private Runnable mBlurRunnable;
    private int mLastPos = -1;
    private TextView menu;
    public static final String RAINBOW = "rainbow";
    private RecyclerView activeRv;


    @Override
    public RainbowPresenter initPresenter() {
        return new RainbowPresenter(this, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_active, null);
        setContentView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        initView();
        initData();
        return view;


    }

    private void initData() {
        final List<String> list = new ArrayList<>();
        list.add("彩虹堂");
        list.add("每日签到");
        activeRv.setAdapter(new CommonAdapter<String>(getActivity(), R.layout.item_active, list) {
            @Override
            public void convert(ViewHolder holder, final String s) {
                holder.setText(R.id.item_active_name, s);
                holder.setOnClickListener(R.id.item_active_layout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                            RainbowActivity.start(getActivity());
                        if(s.equals(list.get(0))){
                            RainbowActivity.start(getActivity());
                        }else if(s.equals(list.get(1))){
                            SignActivity.start(getActivity());
                        }

                    }

                });
            }
        });
    }

    private void initView() {
        activeRv = view.findViewById(R.id.active_rv);
        //设置LayoutManager为LinearLayoutManager
        activeRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public void setRainbowListData(JsonResponse<RainbowEntity> response, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }

}
