package com.dytj.leekbox.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseFragment;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.RainbowEntity;
import com.dytj.leekbox.presenter.RainbowContact;
import com.dytj.leekbox.presenter.RainbowPresenter;
import com.dytj.leekbox.ui.activity.PointActivity;
import com.dytj.leekbox.view.galleryView.BlurBitmapUtils;
import com.dytj.leekbox.view.galleryView.CardAdapter;
import com.dytj.leekbox.view.galleryView.CardScaleHelper;
import com.dytj.leekbox.view.galleryView.ViewSwitchUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.Nullable;
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
public class RainbowFragment extends LifecycleBaseFragment<RainbowPresenter> implements RainbowContact.view, View.OnClickListener {

    private View view;

    private TextView title;
    private RecyclerView mRecyclerView;
    private CardScaleHelper mCardScaleHelper;
    private List<Integer> mList = new ArrayList<>();
    private ImageView mBlurView;
    private Runnable mBlurRunnable;
    private int mLastPos = -1;
    private TextView menu;
    public static final String RAINBOW="rainbow";


    @Override
    public RainbowPresenter initPresenter() {
        return new RainbowPresenter(this, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_rain_bow, null);
        setContentView(view);
        super.onCreateView(inflater,container,savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        initView();
        initData();
        return view;


    }

    private void initData() {
        title.setText("彩虹堂");
        title.setTextColor(getActivity().getResources().getColor(R.color.white));
//        getDataList();
        for (int i = 0; i < 10; i++) {
            mList.add(R.drawable.pic4);
            mList.add(R.drawable.pic5);
            mList.add(R.drawable.pic6);
        }


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new CardAdapter(mList));
        // mRecyclerView绑定scale效果
        mCardScaleHelper = new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(2);
        mCardScaleHelper.attachToRecyclerView(mRecyclerView);

        initBlurBackground();
        getRainbowList();

    }

    private void initView() {
        mBlurView = view.findViewById(R.id.blurView);
        menu=view.findViewById(R.id.menu);
        menu.setOnClickListener(this);
        menu.setVisibility(View.VISIBLE);
        menu.setTextColor(getActivity().getResources().getColor(R.color.white));
        menu.setText("积分市场");
        mRecyclerView = view.findViewById(R.id.recyclerView);
        title = view.findViewById(R.id.title);
    }

    private void initBlurBackground() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    notifyBackgroundChange();
                }
            }
        });

        notifyBackgroundChange();
    }

    private void notifyBackgroundChange() {
        if (mLastPos == mCardScaleHelper.getCurrentItemPos()) return;
        mLastPos = mCardScaleHelper.getCurrentItemPos();
        final int resId = mList.get(mCardScaleHelper.getCurrentItemPos());
        mBlurView.removeCallbacks(mBlurRunnable);
        mBlurRunnable = new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
                ViewSwitchUtils.startSwitchBackgroundAnim(mBlurView, BlurBitmapUtils.getBlurBitmap(mBlurView.getContext(), bitmap, 15));
            }
        };
        mBlurView.postDelayed(mBlurRunnable, 200);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu:
                PointActivity.start(getActivity());
                break;
        }
    }

    @Override
    public void setRainbowListData(JsonResponse<RainbowEntity> response, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }

    private void getRainbowList(){
        HashMap params = new HashMap();
        presenter.getData(params, RAINBOW);
    }
}
