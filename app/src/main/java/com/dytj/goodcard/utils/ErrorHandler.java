package com.dytj.goodcard.utils;

import android.app.Activity;

import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.AppManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.view.DialogView;
import com.google.gson.Gson;

import retrofit2.HttpException;

/**
 * Created by zeng on 2018/11/14.
 */

public class ErrorHandler {
    private static String data = "{\"Success\": false,\"StatusCode\": 500,\"Message\": \"处理失败\", \"ErrorInfo\": {\"ErrorMessage\": \"网络请求错误\",\"ErrorCode\": \"404\" },\"Result\": null}";

    public static JsonResponse handle(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException error = (HttpException) throwable;
            try {
                String string = error.response().errorBody().string();
                if (isJSONValid(string)) {
                    return new Gson().fromJson(string, JsonResponse.class);
                } else {
                    return new Gson().fromJson(data, JsonResponse.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throwable.printStackTrace();
            return null;
        }
    }

    public static String errorMessage(Throwable e) {
        JsonResponse errBody = ErrorHandler.handle(e);
        if (errBody != null) {
            final Activity activity = AppManager.topActivity();
            //用户类型
            final String userType = PreferenceHelper.readString(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_IS_USERTYPE, "");
            String errorCode = errBody.getMsg();
            if (activity != null && !activity.isDestroyed()) {
                if ("401".equals(errorCode)) {
                    //token失效了
                    try {
                        PreferenceHelper.write(PreferenceHelper.DEFAULT_FILE_NAME, AppConfig.PREFER_TOKEN_TAG, "");
                        DialogView dialogView = new DialogView(activity, 180, 180, R.layout.my_dialog, R.style.dialog) {
                            @Override
                            public void isdismiss(int tag) {
                                if (tag == DialogView.CANCEL_BUTTON_CLICK) {
//                                    activity.startActivity(new Intent(activity, RoleChangeActivity.class));
                                }
                            }
                        };
                        dialogView.showdialog2("温馨提示", "登录失效，请重新登录", "去登录", "");
                    } catch (Exception es) {
                        es.printStackTrace();
                    }
                }
            }
            return errBody.getMsg();
        }
        return "";
    }

    public final static boolean isJSONValid(String jsonInString) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
