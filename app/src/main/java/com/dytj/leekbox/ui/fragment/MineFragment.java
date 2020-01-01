package com.dytj.leekbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dytj.leekbox.AppConfig;
import com.dytj.leekbox.AppManager;
import com.dytj.leekbox.R;
import com.dytj.leekbox.base.LifecycleLazyFragment;
import com.dytj.leekbox.presenter.TestContact;
import com.dytj.leekbox.ui.activity.LoginActivity;
import com.dytj.leekbox.utils.PreferenceHelper;
import com.dytj.leekbox.utils.StatusBarUtil;

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
        }
    }
}
