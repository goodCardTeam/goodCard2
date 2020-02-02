package com.dytj.goodcard.ui.fragment;

import android.os.Bundle;
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
import com.dytj.goodcard.ui.activity.LoginActivity;
import com.dytj.goodcard.utils.PreferenceHelper;

import androidx.annotation.Nullable;

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
        }
    }
}
