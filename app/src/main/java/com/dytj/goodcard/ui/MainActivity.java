package com.dytj.goodcard.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.model.LunBoTuEntity;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.presenter.TestPresenter;

import java.util.HashMap;

public class MainActivity extends LifecycleBaseActivity<TestContact.presenter> implements TestContact.view {

    private TextView textView;
    private HashMap<Object, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<>();
        initView();
        initData();

    }

    private void initData() {
        presenter.getData(map, "first");
    }

    private void initView() {
        textView = findViewById(R.id.main_text);
    }

    /**
     * 初始化presenter
     *
     * @return 对应的presenter
     */
    @Override
    public TestContact.presenter initPresenter() {
        return new TestPresenter(this, MainActivity.this);
    }

    /**
     * 设置数据
     * 刷新界面
     *
     * @param lunBoTuEntity 数据源
     */
    @Override
    public void setData(LunBoTuEntity lunBoTuEntity, String tag) {
        if ("LunBoTu".equals(tag)) {
            String imageUrl = lunBoTuEntity.getResult().getList().get(0).getImageUrl();
            System.out.println("图片地址:" + imageUrl);
        }
    }

    @Override
    public void ErrorData(Throwable e) {

    }

    @Override
    public void showLoadingDialog(String msg) {
        textView.setText(msg);
    }

    @Override
    public void dismissLoadingDialog() {

    }

}
