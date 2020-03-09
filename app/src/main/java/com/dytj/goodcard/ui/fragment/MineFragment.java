package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseFragment;
import com.dytj.goodcard.base.LifecycleLazyFragment;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.UserInfoEntity;
import com.dytj.goodcard.presenter.TbGoodsContact;
import com.dytj.goodcard.presenter.TbGoodsPresenter;
import com.dytj.goodcard.presenter.TestContact;
import com.dytj.goodcard.presenter.UserInfoContact;
import com.dytj.goodcard.presenter.UserInfoPresenter;
import com.dytj.goodcard.ui.activity.AboutActivity;
import com.dytj.goodcard.ui.activity.CertificationActivity;
import com.dytj.goodcard.ui.activity.LoginActivity;
import com.dytj.goodcard.ui.activity.PayActivity;
import com.dytj.goodcard.ui.activity.SettingActivity;
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
public class MineFragment extends LifecycleBaseFragment<UserInfoPresenter> implements UserInfoContact.view, View.OnClickListener {
    private View view;
    private LinearLayout mineAuth;
    private LinearLayout mineCustomer;
    private LinearLayout mineOrder;
    private ImageView mineSetting;
    private ImageView mineHeader;
    private TextView mineName;
    private TextView mineTel;
    private TextView minePointTotal;
    private TextView minePointUsed;
    private TextView minePointFreeze;
    public static String USER_INFO = "userInfo";
    private TextView mineVerified;
    /**
     * 是否实名认证
     */
    private int isVerified;

    @Override
    public UserInfoPresenter initPresenter() {
        return new UserInfoPresenter(this, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        setContentView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        initView();
        initData();
        return view;
    }

    private void initData() {
        getUserInfo();
    }

    private void getUserInfo() {
        HashMap map = new HashMap<>();
        presenter.getData(map, USER_INFO);
    }

    private void initView() {
        mineAuth = view.findViewById(R.id.mine_auth);
        mineAuth.setOnClickListener(this);
        mineOrder = view.findViewById(R.id.mine_order);
        mineOrder.setOnClickListener(this);
        mineSetting = view.findViewById(R.id.mine_setting);
        mineSetting.setOnClickListener(this);
        mineHeader = view.findViewById(R.id.mine_header);
        mineName = view.findViewById(R.id.mine_name);
        mineTel = view.findViewById(R.id.mine_tel);
        minePointTotal = view.findViewById(R.id.mine_point_total);
        minePointUsed = view.findViewById(R.id.mine_point_total);
        minePointFreeze = view.findViewById(R.id.mine_point_freeze);
        mineVerified=view.findViewById(R.id.mine_verified);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_auth:
                if(isVerified==0){
                    CertificationActivity.start(getActivity());
                }
                break;
            case R.id.mine_order:
                submitPrivacyGrantResult(true);
                showShare();
                break;
            case R.id.mine_setting:
                SettingActivity.start(getActivity());
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

    @Override
    public void setUserInfoData(JsonResponse<UserInfoEntity> response, String tag) {
        if (response == null || response.getData() == null || response.getData().getUser() == null) {
            return;
        }
        String name = response.getData().getUser().getNickname();
        String tel=response.getData().getUser().getTel();
        String inviteCode=response.getData().getUser().getInvite_code();
        String headerUrl=response.getData().getUser().getAvatar_url();
        int usedPoint=response.getData().getUser().getPoint();
        int lockedPoint=response.getData().getUser().getLocked_point();
        int totalPoint=usedPoint+lockedPoint;
        isVerified=response.getData().getUser().getIs_verified();
        mineName.setText(name);
        mineTel.setText(tel);
        minePointUsed.setText(String.valueOf(usedPoint));
        minePointFreeze.setText(String.valueOf(lockedPoint));
        minePointTotal.setText(String.valueOf(totalPoint));
        if(isVerified==0){
            mineVerified.setText("未认证");
            mineVerified.setTextColor(getActivity().getResources().getColor(R.color.red_6729));
        }else{
            mineVerified.setText("已认证");
            mineVerified.setTextColor(getActivity().getResources().getColor(R.color.green_25));
        }
    }

    @Override
    public void ErrorData(Throwable e) {

    }
}
