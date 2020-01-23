package com.dytj.goodcard.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.presenter.TestPresenter;

public class ResultActivity extends LifecycleBaseActivity<TestPresenter> implements View.OnClickListener {


    private Button bt_close;

    private ImageView iv_r;

    private TextView tv_r, tv_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ToolBarStyle(0);
        setBack(true);
        setTitle("认证结果");
        bt_close = (Button) findViewById(R.id.bt_close);

        boolean succeed = getIntent().getBooleanExtra("result", false);
        String msg = getIntent().getStringExtra("msg");

        iv_r = (ImageView) findViewById(R.id.iv_r);
        tv_r = (TextView) findViewById(R.id.tv_r);
        tv_msg = (TextView) findViewById(R.id.tv_msg);

        tv_msg.setText(msg);

        if (!succeed) {
            iv_r.setImageResource(R.mipmap.icon_failed);
            tv_r.setText(getIntent().getStringExtra("hint"));
            bt_close.setText("重新认证");
        }
        bt_close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.rl_back:
//                finish();
//                break;
            case R.id.bt_close:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public TestPresenter initPresenter() {
        return null;
    }
}
