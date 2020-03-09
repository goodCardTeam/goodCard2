package com.dytj.goodcard.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.mvpBase.BasePresenter;

public class WebActivity  extends LifecycleBaseActivity<BasePresenter>
        implements View.OnClickListener {

    private WebView mWebView;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ToolBarStyle(0);
        setBack(true);
        initView();
        initData();
    }

    public static void start(Activity activity,String url) {
        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra("url",url);
        activity.startActivity(intent);
    }

    private void initData() {
        String url=getIntent().getStringExtra("url");
        mWebView.loadUrl(url);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());
        title=mWebView.getTitle();
        setTitle(title);
    }

    private void initView() {
        mWebView=findViewById(R.id.web);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {


    }
}
