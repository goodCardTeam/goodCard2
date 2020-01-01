package com.dytj.leekbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dytj.leekbox.AppManager;
import com.dytj.leekbox.MyApplication;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleBaseActivity;
import com.dytj.leekbox.model.LunBoTuEntity;
import com.dytj.leekbox.presenter.TestContact;
import com.dytj.leekbox.presenter.TestPresenter;
import com.dytj.leekbox.ui.adapter.MainVpAdapter;
import com.dytj.leekbox.ui.fragment.HomeFragment;
import com.dytj.leekbox.ui.fragment.MineFragment;
import com.dytj.leekbox.ui.fragment.NewsFragment;
import com.dytj.leekbox.ui.fragment.ActiveFragment;
import com.dytj.leekbox.view.MyViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class Main2Activity extends LifecycleBaseActivity<TestContact.presenter>
        implements TestContact.view, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private HashMap<Object, Object> map;
    private MyViewPager vpShow;
    private RadioButton rbFirst, rbSecond, rbThree, rbFour;
    private RadioGroup rgBottom;
    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private MineFragment mineFragment;
    private ActiveFragment activeFragment;
    private MainVpAdapter adapter;

    long[] mHits = new long[2];
    boolean showToast = true;

    /**
     * 盛放fragment容器
     */
    private List<Fragment> listFragnet = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusYesBar();
        setContentView(R.layout.activity_main2);
        map = new HashMap<>();
        initView();
        initData();
        initEvent();
    }

    public static void start(Activity activity){
        Intent intent=new Intent(activity,Main2Activity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    private void initEvent() {
        //默认进入第一个tab页
        int currentPage = 0;
        switch (currentPage) {
            case 0:
                //设置主页第一个分页被选中
                rbFirst.setSelected(true);
                rbFirst.setChecked(true);
                break;
            case 1:
                //设置主页第一个分页被选中
                rbSecond.setSelected(true);
                rbSecond.setChecked(true);
                break;
            case 2:
                //设置主页第一个分页被选中
                rbThree.setSelected(true);
                rbThree.setChecked(true);
                break;
            case 3:
                //设置主页第一个分页被选中
                rbFour.setSelected(true);
                rbFour.setChecked(true);
                break;
        }

        homeFragment = new HomeFragment();
        newsFragment = new NewsFragment();
        mineFragment = new MineFragment();
        listFragnet.add(homeFragment);
        listFragnet.add(newsFragment);
        listFragnet.add(activeFragment);
        listFragnet.add(mineFragment);


        rgBottom.setOnCheckedChangeListener(this);
        adapter = new MainVpAdapter(getSupportFragmentManager());
        vpShow.setAdapter(adapter);
        vpShow.setCurrentItem(currentPage);
        vpShow.setOffscreenPageLimit(5);
        vpShow.addOnPageChangeListener(this);
    }

    private void initData() {
        presenter.getData(map, "first");
    }

    private void initView() {
        vpShow = findViewById(R.id.vp_show);
        rbFirst = findViewById(R.id.rb0);
        rbSecond = findViewById(R.id.rb1);
        rbThree = findViewById(R.id.rb2);
        rbFour = findViewById(R.id.rb3);
        rgBottom = findViewById(R.id.rg_bottom);
    }

    @Override
    public TestContact.presenter initPresenter() {
        return new TestPresenter(this, Main2Activity.this);
    }

    @Override
    public void setData(LunBoTuEntity lunBoTuEntity, String tag) {

    }

    @Override
    public void ErrorData(Throwable e) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb0:
                vpShow.setCurrentItem(0);
                break;
            case R.id.rb1:
                vpShow.setCurrentItem(1);
                break;
            case R.id.rb2:
                vpShow.setCurrentItem(3);
                break;
            case R.id.rb3:
                vpShow.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (vpShow.getCurrentItem()) {
                case 0:
                    rbFirst.setChecked(true);
                    break;
                case 1:
                    rbSecond.setChecked(true);
                    break;
                case 3:
                    rbThree.setChecked(true);
                    break;
                case 2:
                    rbFour.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);// 数组向左移位操作
        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
        if (mHits[0] >= (SystemClock.uptimeMillis() - 2000)) {
            AppManager.getAppManager().AppExit(MyApplication.getInstance().getApplicationContext());
            finish();
        } else {
            showToast = true;
        }
        if (showToast) {
            Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_LONG).show();
            showToast = false;
        }
    }
}
