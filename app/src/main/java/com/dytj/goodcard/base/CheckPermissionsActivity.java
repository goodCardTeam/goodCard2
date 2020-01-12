/**
 *
 */
package com.dytj.goodcard.base;

import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

/**
 * 继承了Activity，实现Android6.0的运行时权限检测
 * 需要进行运行时权限检测的Activity可以继承这个类
 *
 * Created by MaRufei
 * on 2019-12-28.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class CheckPermissionsActivity extends FragmentActivity {
    private String TAG = "CheckPermissionsActivity";
    /**
     * 需要进行检测的权限数组
     */
    protected String[] needPermissions;

    public static final int PERMISSON_REQUESTCODE = 0X13;

    /**
     * 判断是否需要检测，防止不停的弹框
     */
    public boolean isNeedCheck = true;

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void setPermission(String[] strings) {
        needPermissions = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            needPermissions[i] = strings[i];
            Log.e(TAG, "Permissions:" + needPermissions[i]);
        }

        Log.e(TAG, "进入----setPermission方法");
        if (Build.VERSION.SDK_INT >= 23
                && getApplicationInfo().targetSdkVersion >= 23) {
            if (isNeedCheck) {
                checkPermissions(needPermissions);
            }
        }
    }


    /**
     * @param permissions
     * @since 2.5.0
     */
    private void checkPermissions(String[] permissions) {
        Log.e(TAG, "进入------checkPermissions方法");
        try {
            if (Build.VERSION.SDK_INT >= 23
                    && getApplicationInfo().targetSdkVersion >= 23) {
                //获取权限列表
                List<String> needRequestPermissonList = findDeniedPermissions(permissions);
                if (null != needRequestPermissonList
                        && needRequestPermissonList.size() > 0) {
                    //如果有需要申请的权限就去申请

                    //list.toarray将集合转化为数组
                    ActivityCompat.requestPermissions(this,
                            needRequestPermissonList.toArray(new String[needRequestPermissonList.size()]),
                            PERMISSON_REQUESTCODE);
                    Log.e(TAG, "requestPermissions方法执行-------");
                } else {
                    //如果没有申请的权限就进行需要的操作
                    onAccreditSucceed();
                }
            }
        } catch (Throwable e) {
        }
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     */
    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<String>();
        //for (循环变量类型 循环变量名称 : 要被遍历的对象)
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(this,
                    perm) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    this, perm)) {
                needRequestPermissonList.add(perm);
            }
        }
        return needRequestPermissonList;
    }

    /**
     * 检测是否所有的权限都已经授权
     *
     * @param grantResults
     * @return
     * @since 2.5.0
     */
    public boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(grantResults)) {
                onAccreditFailure();
            } else {
                onAccreditSucceed();
            }
        }
    }

    /**
     * 有授权执行的方法(子类重写)
     */
    public void onAccreditSucceed() {
    }

    /**
     * 没有授权执行的方法(子类重写)
     */
    public void onAccreditFailure() {
    }
}
