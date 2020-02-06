package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.GoodDetailEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.MenuEntity;
import com.dytj.goodcard.model.TradeOrderInfoEntity;
import com.dytj.goodcard.presenter.TbGoodDetailContact;
import com.dytj.goodcard.presenter.TbGoodDetailPresenter;
import com.dytj.goodcard.presenter.TradeOrderInfoContact;
import com.dytj.goodcard.presenter.TradeOrderInfoPresenter;
import com.dytj.goodcard.utils.MyToast;
import com.dytj.goodcard.view.CircleRelativeLayout;
import com.lzj.gallery.library.views.BannerViewPager;
import com.yanzhenjie.sofia.Sofia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.core.widget.NestedScrollView;

public class TbGoodDetailActivity extends LifecycleBaseActivity<TbGoodDetailPresenter> implements TbGoodDetailContact.view, View.OnClickListener  {

    public static final String TB_GOOD_DETAIL_REQUEST = "tbGoodDetailRequest";
    private String goodId;

//    ImageView banner;
    NestedScrollView scrollView;
    TextView txTitle;
    ImageButton myBack;
    CircleRelativeLayout btnLeft;
    RelativeLayout topView;

    private BannerViewPager homeBanner;

    TextView tv_price;
    TextView tv_tip_price;
    TextView tv_taobao_price;
    TextView tv_sale_num;
    TextView tv_good_title;
    TextView tv_coump_price;
    TextView tv_shop_name;


    private int scrollHeight;
    private int scrollAlpha = 0;
    private float scrollScale = 0;
    private boolean isCommitColor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_good_detail);
        goodId = getIntent().getStringExtra("goodId");

        initView();
        initData();
    }

    /**
     * 沉浸式状态栏
     */
    private void onStatusBar() {
        Sofia.with(this)
                .statusBarDarkFont()
                .invasionStatusBar()
                .fitsSystemWindowView(topView)
                .navigationBarBackground(Color.BLACK);
    }

    private void initScrollView() {
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY <= scrollHeight) {
                    //开启滑动过快
                    isCommitColor = false;

                    scrollScale = (float) scrollY / scrollHeight;
                    scrollAlpha = (int) (255 * scrollScale);

                    //文字由透明变为黑色
                    txTitle.setTextColor(Color.argb(scrollAlpha, 0, 0, 0));

                    //背景由透明变为白色
                    topView.setBackgroundColor(Color.argb(scrollAlpha, 255, 255, 255));

                    //按钮背景由黑变白
                    btnLeft.setColor(Color.argb(255, scrollAlpha, scrollAlpha, scrollAlpha));
//                    btnRight.setColor(Color.argb(255, scrollAlpha, scrollAlpha, scrollAlpha));

                    //按钮文字由白变黑
                    scrollAlpha = 255 - scrollAlpha;
//                    btnRightIcon.setTextColor(Color.argb(255, scrollAlpha, scrollAlpha, scrollAlpha));
//                    btnLeftIcon.setTextColor(Color.argb(255, scrollAlpha, scrollAlpha, scrollAlpha));
                } else {
                    if (!isCommitColor) {
                        //防止滑动过快bug
                        isCommitColor = true;

                        //文字由透明变为黑色
                        txTitle.setTextColor(Color.BLACK);
                        //背景由透明变为白色
                        topView.setBackgroundColor(Color.WHITE);

                        //按钮背景由黑变白
                        btnLeft.setColor(Color.WHITE);
//                        btnRight.setColor(Color.WHITE);

                        //按钮文字由白变黑
//                        btnRightIcon.setTextColor(Color.BLACK);
//                        btnLeftIcon.setTextColor(Color.BLACK);
                    }
                }
            }
        });
    }

    private void initView() {
        myBack = findViewById(R.id.myBack);
        scrollView = findViewById(R.id.scrollView);
//        banner = findViewById(R.id.banner);
        homeBanner = findViewById(R.id.home_banner);
        txTitle = findViewById(R.id.txTitle);
        btnLeft = findViewById(R.id.btnLeft);
        topView = findViewById(R.id.topView);

        tv_price = findViewById(R.id.tv_price);
        tv_tip_price = findViewById(R.id.tv_tip_price);
        tv_taobao_price = findViewById(R.id.tv_taobao_price);

        tv_sale_num = findViewById(R.id.tv_sale_num);
        tv_good_title = findViewById(R.id.tv_good_title);
        tv_coump_price = findViewById(R.id.tv_coump_price);
        tv_shop_name = findViewById(R.id.tv_shop_name);


        onStatusBar();
        scrollHeight = homeBanner.getLayoutParams().height;
        initScrollView();

        myBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initData() {
        List urlList = new ArrayList<>();
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543221773&di=c63f30c7809e518cafbff961bcd9ec2a&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0116605851154fa8012060c8587ca1.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042541&di=3ad9deeefff266e76d1f5d57a58f63d1&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F00%2F69%2F99%2F66%2F9fce5755f081660431464492a9aeb003.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042539&di=95bd41d43c335e74863d9bb540361906&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019a0558be22d6a801219c77d0578a.jpg%402o.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542627042539&di=cdd54bffd2aac448c70ae6b416a004d4&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01edb3555ea8100000009af0ba36f5.jpg%401280w_1l_2o_100sh.jpg");

        homeBanner.initBanner(urlList, true)//开启3D画廊效果
                .addPageMargin(-12, 20)//参数1page之间的间距,参数2中间item距离边界的间距
                .addPoint(6)//添加指示器
                .addStartTimer(3)//自动轮播间隔
                .addPointBottom(7)
                .addRoundCorners(5)//圆角
                .finishConfig()//这句必须加
                .addBannerListener(new BannerViewPager.OnClickBannerListener() {
                    @Override
                    public void onBannerClick(int position) {
                        //点击item
//                        showShort("效果1点击" + position);
                        Log.i("test", "--------------position:" + position);
                    }
                });
        homeBanner.setFocusable(true);
        homeBanner.setFocusableInTouchMode(true);

        HashMap map = new HashMap<>();
        map.put("id",goodId);
        presenter.getData(map, TB_GOOD_DETAIL_REQUEST);
    }


//    public static void start(Activity activity, String tradeOrderId) {
//        Intent intent = new Intent(activity, TbGoodDetailActivity.class);
//        intent.putExtra("tradeOrderId", tradeOrderId);
//        activity.startActivity(intent);
//    }

    @Override
    public TbGoodDetailPresenter initPresenter() {
        return new TbGoodDetailPresenter(this, this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_complain_commit:
//                String content=etComplainContent.getText().toString();
//                if(TextUtils.isEmpty(content)){
//                    MyToast.showMyToast2(getApplicationContext(),"请先输入投诉内容", Toast.LENGTH_SHORT);
//                    return;
//                }
//                HashMap map = new HashMap();
//                map.put("trade_order_id", tradeOrderId);
//                map.put("content", content);
//                presenter.getData(map, TRADE_ORDER_COMPLAIN_REQUEST);
                break;
        }
    }


    @Override
    public void setGoodDetail(JsonResponse<GoodDetailEntity> goodDetailEntityJsonResponse, String tag) {
        Log.i("tag","111111111111111");
        tv_price.setText("￥"+(Double.parseDouble(goodDetailEntityJsonResponse.getData().getZk_final_price()) -
                Double.parseDouble(goodDetailEntityJsonResponse.getData().getCoupon_amount())));
//        tv_tip_price.setText("");
        tv_taobao_price.setText("淘宝价 ￥"+goodDetailEntityJsonResponse.getData().getZk_final_price());

        tv_sale_num.setText("已售："+goodDetailEntityJsonResponse.getData().getVolume());
        tv_good_title.setText(goodDetailEntityJsonResponse.getData().getTitle());
        tv_coump_price.setText(goodDetailEntityJsonResponse.getData().getCoupon_amount()+"");
        tv_shop_name.setText(goodDetailEntityJsonResponse.getData().getShop_title());

    }

    @Override
    public void ErrorData(Throwable e) {

    }

}
