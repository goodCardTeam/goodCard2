package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.RainbowEntity;
import com.dytj.goodcard.presenter.RainbowContact;
import com.dytj.goodcard.presenter.RainbowPresenter;
import com.dytj.goodcard.view.galleryView.BlurBitmapUtils;
import com.dytj.goodcard.view.galleryView.CardAdapter;
import com.dytj.goodcard.view.galleryView.CardScaleHelper;
import com.dytj.goodcard.view.galleryView.ViewSwitchUtils;

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
    int [] bacArrays=new int[]{R.drawable.card_white,R.drawable.card_blue,R.drawable.card_yellow,
            R.drawable.card_purple,R.drawable.card_red,R.drawable.card_black};
    private CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow);
        ToolBarStyle(0);
        setBack(true);
        setTitle("彩虹堂");
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


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter=new CardAdapter(RainbowActivity.this);
        mRecyclerView.setAdapter(adapter);
        // mRecyclerView绑定scale效果
        mCardScaleHelper = new CardScaleHelper();
        mCardScaleHelper.setCurrentItemPos(0);
        mCardScaleHelper.attachToRecyclerView(mRecyclerView);


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
        List<RainbowEntity.CardsBean> cardList = response.getData().getCards();
        if (null==cardList){
            return;
        }
        for (int i = 0; i < cardList.size(); i++) {
            mList.add(R.drawable.pic4);
        }
        adapter.setCardList(cardList);
        adapter.setmList(mList);
        initBlurBackground();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
