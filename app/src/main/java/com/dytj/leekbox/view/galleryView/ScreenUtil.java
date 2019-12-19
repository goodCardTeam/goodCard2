package com.dytj.leekbox.view.galleryView;

import android.content.Context;

/**
 * Created by MaRufei
 * on 2019-12-18.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class ScreenUtil {
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
