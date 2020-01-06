package com.dytj.leekbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dytj.leekbox.AppManager;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.JsonResponse;
import com.dytj.leekbox.model.RainbowEntity;
import com.dytj.leekbox.presenter.RainbowContact;
import com.dytj.leekbox.presenter.RainbowPresenter;
import com.dytj.leekbox.view.galleryView.BlurBitmapUtils;
import com.dytj.leekbox.view.galleryView.CardAdapter;
import com.dytj.leekbox.view.galleryView.CardScaleHelper;
import com.dytj.leekbox.view.galleryView.ViewSwitchUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RainbowActivity extends LifecycleBaseActivity<RainbowPresenter> implements RainbowContact.view, View.OnClickListener {

    private TextView title;
    private RecyclerView mRecyclerView;
    private CardScaleHelper mCardScaleHelper;
    private List<Integer> mList = new ArrayList<>();
    private ImageView mBlurView;
    private Runnable mBlurRunnable;
    private int mLastPos = -1;
    private TextView menu;
    public static final String RAINBOW = "rainbow";
    private ImageButton myBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow);
        ToolBarStyle(0);
        setBack(true);
        setTitle("我要买");
        setMenu("积分市场",R.color.gray_3);
        initView();
        initData();
    }

    @Override
    public RainbowPresenter initPresenter() {
        return new RainbowPresenter(this, this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, RainbowActivity.class);
        activity.startActivity(intent);
    }


    private void initData() {
        for (int i = 0; i < 10; i++) {
            mList.add(R.drawable.pic4);
            mList.add(R.drawable.pic5);
            mList.add(R.drawable.pic6);
        }


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new CardAdapter(mList));
        // mRecyclerView绑定scale效果
        mCardScaleHelper = new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(0);
        mCardScaleHelper.attachToRecyclerView(mRecyclerView);

        initBlurBackground();
        getRainbowList();
    }

    private void initView() {
        mBlurView = findViewById(R.id.blurView);
        mRecyclerView = findViewById(R.id.recyclerView);
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

    private void getRainbowList() {
        HashMap params = new HashMap();
        presenter.getData(params, RAINBOW);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.myBack:
                AppManager.getAppManager().finishActivity();
                break;
            case R.id.menu:
                PointActivity.start(this);
                break;
        }
    }

    @Override
    public void setRainbowListData(JsonResponse<RainbowEntity> response, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
