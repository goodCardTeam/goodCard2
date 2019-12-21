package com.dytj.leekbox.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.dytj.leekbox.MyApplication;

import java.util.Map;


/**
 * Created by MaRufei
 * on 17/7/18.
 * Email: www.867814102@qq.com
 * Phone：132 1358 0912
 * Purpose: TODO 存储工具
 */

public class SaveUtils {

    public static String PREFERENCE_NAME = "huoge";

    /**
     * 存储 String
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setString(String key, String value) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }


    /**
     * 读取 String
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        String str=settings.getString(key, null);
        Log.e("aaa","str:"+str);
        return str;
    }

    /**
     * 存储 Int
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setInt(String key, int value) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }


    /**
     * 读取 Int
     *
     * @param key
     * @return
     */
    public static int getInt(String key) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, -1);

    }

    /**
     * 存储 Long
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setLong(String key, long value) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * 读取 Long
     *
     * @param key
     * @return
     */
    public static long getLong(String key) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, -1);
    }

    /**
     * 存储 Float
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setFloat(String key, float value) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }


    /**
     * 读取 Float
     *
     * @param key
     * @return
     */
    public static float getFloat(String key) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getFloat(key, -1);
    }

    /**
     * 存储 Boolean
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setBoolean(String key, boolean value) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * 读取 Boolean
     *
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, false);
    }

    /**
     * 删除某个键值对
     *
     * @param key
     */
    public static void removeData(String key) {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
    }

    /**
     * 删除value是空的 键值对
     */
    public static void removeManyData() {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Map<String, String> map = (Map<String, String>) settings.getAll();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Log.i("获取的key：" + entry.getKey(), "获取的value:" + settings.getString(entry.getKey(), ""));
            String value = settings.getString(entry.getKey(), "");
            if (TextUtils.isEmpty(value)) {
                editor.remove(entry.getKey());
            }

        }
    }

    /**
     * 删除所有键值对
     */
    public static void removeAllData() {
        SharedPreferences settings = MyApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Map<String, String> map = (Map<String, String>) settings.getAll();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            editor.remove(entry.getKey());
        }
    }
}
