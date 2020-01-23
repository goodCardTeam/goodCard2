package com.dytj.goodcard.utils;

/**
 * Created by MaRufei
 * on 2020-01-11.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class Constants {
    public static final int USER_TYPE_BUYER = 1;
    public static final int USER_TYPE_SELLER = 2;
    public static final int ORDER_TYPE_CANCEL = -10;
    public static final int ORDER_TYPE_PAY = 0;
    public static final int ORDER_TYPE_GET = 10;
    public static final int ORDER_TYPE_FINNISH = 20;
    public static final String OUTPUT_TYPE = "output_type";
    public static final String ACTION_SEQUENCE = "action_sequence";
    public static final String DETECT_COMPLEXITY = "detect_complexity";
    /**
     *  输出类型
     */
    public static final String OUTTYPE = "outType";
    /**
     * 传入活体检测的动作序列
     */
    public static final String EXTRA_MOTION_SEQUENCE = "com.linkface.liveness.motionSequence";
    /**
     * 是否打开语音提示
     */
    public static final String SOUND_NOTICE = "soundNotice";
    /**
     * 设置复杂度
     */
    public static final String COMPLEXITY = "complexity";

    // motion value
    public static final String BLINK = "BLINK";
    public static final String NOD = "NOD";
    public static final String MOUTH = "MOUTH";
    public static final String YAW = "YAW";
    // outtype value
    public static final String SINGLEIMG = "singleImg";
    public static final String MULTIIMG = "multiImg";
    public static final String VIDEO = "video";
    public static final String FULLVIDEO = "fullVideo";
    // complexity value
    public static final String EASY = "easy";
    public static final String NORMAL = "normal";
    public static final String HARD = "hard";
    public static final String HELL = "hell";
}
