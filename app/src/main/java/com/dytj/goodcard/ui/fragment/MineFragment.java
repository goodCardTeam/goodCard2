package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleLazyFragment;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.ui.activity.AboutActivity;
import com.dytj.goodcard.ui.activity.CertificationActivity;
import com.dytj.goodcard.ui.activity.LoginActivity;
import com.dytj.goodcard.ui.activity.PayActivity;
import com.dytj.goodcard.utils.PreferenceHelper;
import com.mob.MobSDK;
import com.mob.OperationCallback;

import java.util.HashMap;

import androidx.annotation.Nullable;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by MaRufei
 * on 2019-09-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class MineFragment extends LifecycleLazyFragment implements View.OnClickListener {
    private View view;
    private Button mineLoginOut;
    private LinearLayout mineAbout;
    private LinearLayout mineAuth;
    private LinearLayout mineCustomer;
    private LinearLayout mineOrder;

    @Override
    public TestContact.presenter initPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        initView();
        return view;
    }

    private void initView() {
        mineLoginOut=view.findViewById(R.id.mine_login_out);
        mineLoginOut.setOnClickListener(this);
        mineAbout=view.findViewById(R.id.mine_about);
        mineAbout.setOnClickListener(this);
        mineAuth=view.findViewById(R.id.mine_auth);
        mineAuth.setOnClickListener(this);
        mineCustomer=view.findViewById(R.id.mine_customer);
        mineCustomer.setOnClickListener(this);
        mineOrder=view.findViewById(R.id.mine_order);
        mineOrder.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_login_out:
                try {
                    PreferenceHelper.write(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.AUTHORIZATION, "");
                    AppManager.getAppManager().AppExit(getApplicationContext());
                    LoginActivity.start(getActivity());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.mine_about:
                AboutActivity.start(getActivity());
                break;
            case R.id.mine_auth:
                CertificationActivity.start(getActivity());
                break;
            case R.id.mine_customer:
                PayActivity.start(getActivity());
                break;
            case R.id.mine_order:
                submitPrivacyGrantResult(true);
                showShare();
                break;

        }
    }

    private void submitPrivacyGrantResult(boolean granted) {
        MobSDK.submitPolicyGrantResult(granted, new OperationCallback<Void>() {
            @Override
            public void onComplete(Void data) {
                Log.d("aaa", "隐私协议授权结果提交：成功");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("aaa", "隐私协议授权结果提交：失败");
            }
        });
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle("好卡分享");
        // titleUrl QQ和QQ空间跳转链接
//        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，确保SDcard下面存在此张图片
//        oks.setImagePath(getActivity().getResources().getResourceName(R.mipmap.logo));
        oks.setImageUrl("https://c-ssl.duitang.com/uploads/item/201704/10/20170410095843_SEvMy.jpeg");
        // url在微信、Facebook等平台中使用
        oks.setUrl("http://www.baidu.com");
        // 启动分享GUI
        oks.show(getActivity());
        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d("aaa", "分享完成");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("aaa", "分享失败");
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("aaa", "分享取消");
            }
        });

    }
}
