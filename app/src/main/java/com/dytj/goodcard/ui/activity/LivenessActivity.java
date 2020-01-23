package com.dytj.goodcard.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chuanglan.cllc.CLLCSDKManager;
import com.chuanglan.cllc.constant.LivenessState;
import com.chuanglan.cllc.listener.LivenessListener;
import com.chuanglan.cllc.modle.CLLCImageResult;
import com.chuanglan.cllc.modle.CLLCParameter;
import com.chuanglan.cllc.tool.CLLCSensorManager;
import com.dytj.goodcard.R;
import com.dytj.goodcard.base.LifecycleBaseActivity;
import com.dytj.goodcard.presenter.TestPresenter;
import com.dytj.goodcard.ui.listener.OcrAlertDialogListener;
import com.dytj.goodcard.utils.CLLCMediaPlayer;
import com.dytj.goodcard.utils.Constants;
import com.dytj.goodcard.view.CLLCAlertDialog;
import com.dytj.goodcard.view.FaceDetectRoundView;
import com.dytj.goodcard.view.LFGifView;
import com.dytj.goodcard.view.timeview.CircleTimeView;
import com.dytj.goodcard.view.timeview.contoller.TimeViewContoller;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class LivenessActivity extends LifecycleBaseActivity<TestPresenter> {

    private static final int CURRENT_ANIMATION = -1;

    /**
     * 传入活体检测的动作序列
     */
    public static final String EXTRA_MOTION_SEQUENCE = "com.linkface.liveness.motionSequence";

    /**
     *  输出类型
     */
    public static final String OUTTYPE = "outType";

    /**
     * 是否打开语音提示
     */
    public static final String SOUND_NOTICE = "soundNotice";

    /**
     * 设置复杂度
     */
    public static final String COMPLEXITY = "complexity";

    /**
     * 设置检测人姓名
     */
    public static final String NAME = "name";


    /**
     * 设置检测人身份证号码
     */
    public static final String CAR_NO = "cardNo";



    private Context mContext;

    private LFGifView mGvView;
    private TimeViewContoller mTimeViewContoller;
    private CircleTimeView mTimeView;
    private TextView mNoteTextView;
    private ViewGroup mVGBottomDots;
    private RelativeLayout rl_back;

    private int[] mDetectList = null;
    private String[] mMotionList = null;

    private boolean mSoundNoticeOrNot = false;   //声音控制
    private CLLCMediaPlayer mMediaPlayer = new CLLCMediaPlayer();
    private CLLCAlertDialog cllcAlertDialog;

    private CLLCSensorManager cllcSensorManager;

    private ProgressDialog m_Dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liveness);
        ToolBarStyle(0);
        setBack(true);
        setTitle("实名认证");
        mContext = this;
        initView();
    }


    private void initView() {
        mGvView = (LFGifView) findViewById(R.id.id_gv_play_action);
        mTimeView = (CircleTimeView) findViewById(R.id.t_view);
        mTimeViewContoller = new TimeViewContoller(mTimeView);
        mNoteTextView = (TextView) findViewById(R.id.noteText);


        Bundle bundle = getIntent().getExtras();
        String detects = bundle.getString(LivenessActivity.EXTRA_MOTION_SEQUENCE);
        mMotionList = detects.split("\\s+");

        String motions =bundle.getString(LivenessActivity.EXTRA_MOTION_SEQUENCE);
        String[] splitStrings = motions.split("\\s+");

        mDetectList = new int[splitStrings.length];

        for (int i = 0; i < splitStrings.length; i++) {
            if (splitStrings[i].equalsIgnoreCase(Constants.BLINK)) {
                mDetectList[i] = LivenessState.BLINK;
            } else if (splitStrings[i].equalsIgnoreCase(Constants.NOD)) {
                mDetectList[i] = LivenessState.NOD;
            } else if (splitStrings[i].equalsIgnoreCase(Constants.MOUTH)) {
                mDetectList[i] = LivenessState.MOUTH;
            } else if (splitStrings[i].equalsIgnoreCase(Constants.YAW)) {
                mDetectList[i] = LivenessState.YAW;
            }
        }

        /**
         *  设置声音标志位
         */
        mSoundNoticeOrNot = bundle.getBoolean(LivenessActivity.SOUND_NOTICE);

        /**
         *  设置检测动作
         */
        CLLCParameter parameter = new CLLCParameter();
        //动作序列
        parameter.setMotionList(mDetectList);
        //输出类型
        parameter.setOutputType(bundle.getString(LivenessActivity.OUTTYPE));
        //难易程度
        parameter.setComplexity(bundle.getString(LivenessActivity.COMPLEXITY));
        //姓名
        parameter.setName(getIntent().getStringExtra(LivenessActivity.NAME));
        //身份证号
        parameter.setCardNo(getIntent().getStringExtra(LivenessActivity.CAR_NO));

        CLLCSDKManager.getInstance().setCLLCParameter(parameter);
        CLLCSDKManager.getInstance().setLivenessListener(new LivenessListener() {
            /**
             *  活体检测流程回调
             */
            @Override
            public void onLivenessDetect(int value, int status, byte[] livenessEncryptResult, byte[] videoResult, CLLCImageResult[] imageResult) {
                onLivenessDetectCallBack(value,status,livenessEncryptResult,videoResult,imageResult);
            }

            /**
             *  后台开始人证对比
             */
            @Override
            public void startVerify() {
                showDialog();
            }

            /**
             *  人证对比返回()
             */
            @Override
            public void verifyResult(int code, String result) {
                dismissDialog();
                if(code == 0){
                    /**
                     *  result 的解析仅限 默认URL 请求回调数据解析  自定义URL 数据非此解析方案
                     */
                    dataAnalysis(result);
                }else {
                    skipResultActivity(false,result,result);
                }
            }
        },null);


        mVGBottomDots = (ViewGroup) findViewById(R.id.viewGroup);
        if (mDetectList.length >= 1) {
            for (int i = 0; i < mDetectList.length; i++) {
                TextView tvBottomCircle = new TextView(this);
                tvBottomCircle.setBackgroundResource(R.drawable.drawable_liveness_detect_bottom_cicle_bg_selector);
                tvBottomCircle.setEnabled(true);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FaceDetectRoundView.dp2px(LivenessActivity.this,6),
                        FaceDetectRoundView.dp2px(LivenessActivity.this,6));
                layoutParams.leftMargin = FaceDetectRoundView.dp2px(LivenessActivity.this,6);
                mVGBottomDots.addView(tvBottomCircle, layoutParams);
            }
        }

        cllcSensorManager = new CLLCSensorManager(this);

    }


    private void startAnimation(int animation) {
        if (animation != CURRENT_ANIMATION) {
            mGvView.setMovieResource(animation);
            if (isDialogShowing(null)) {
                return;
            }
        }
        mTimeViewContoller.start();
        mTimeViewContoller.setCallBack(new TimeViewContoller.CallBack() {
            @Override
            public void onTimeEnd() {
                setLivenessState(true);
                showDialog("动作超时");
            }
        });
    }

    private void updateUi(int stringId, int animationId, int number) {
        mNoteTextView.setText(getStringWithID(stringId));
        if (animationId != 0) {
            startAnimation(animationId);
        }
        if (number - 2 >= 0) {
            View childAt = mVGBottomDots.getChildAt(number - 2);
            childAt.setEnabled(false);
        }
        playSoundNotice(number);
    }

    private void playSoundNotice(int step) {
        if (step > 0) {
            if (mDetectList[step - 1]== 0) {
                if (mSoundNoticeOrNot) {
                    mMediaPlayer.setMediaSource(mContext, "notice_blink.mp3", true);
                }
            } else if (mDetectList[step - 1] == 1) {
                if (mSoundNoticeOrNot) {
                    mMediaPlayer.setMediaSource(mContext, "notice_nod.mp3", true);
                }
            } else if (mDetectList[step - 1] == 2) {
                if (mSoundNoticeOrNot) {
                    mMediaPlayer.setMediaSource(mContext, "notice_mouth.mp3", true);
                }
            } else if (mDetectList[step - 1] == 3) {
                if (mSoundNoticeOrNot) {
                    mMediaPlayer.setMediaSource(mContext, "notice_yaw.mp3", true);
                }
            }
        }
    }

    private String getStringWithID(int id) {
        return getResources().getString(id);
    }

    private boolean isDialogShowing(String msg) {
        if(cllcAlertDialog != null && cllcAlertDialog.isShowing()){
            if(msg != null) {
                cllcAlertDialog.setMsg(msg);
            }
            return true;
        }
        return false;
    }


    private void onLivenessDetectCallBack(final int value, final int status, final byte[] livenessEncryptResult, final byte[] videoResult, final CLLCImageResult[] imageResult) {

        if (value == LivenessState.BLINK) {       //眨眼睛
            Log.e("sdsdfafdsfdsa", "--------眨眼睛----------->" + value);
            updateUi(R.string.note_blink, R.raw.raw_detect_blink, status + 1);
        } else if (value == LivenessState.NOD) {    //请点点头
            Log.e("sdsdfafdsfdsa", "--------请点点头----------->" + value);
            updateUi(R.string.note_nod, R.raw.raw_detect_nod, status + 1);
        } else if (value == LivenessState.MOUTH) {  //请张张嘴
            Log.e("sdsdfafdsfdsa", "--------请张张嘴----------->" + value);
            updateUi(R.string.note_mouth, R.raw.raw_detect_mouth, status + 1);
        } else if (value == LivenessState.YAW) {    //请瑶瑶头
            Log.e("sdsdfafdsfdsa", "--------请瑶瑶头----------->" + value);
            updateUi(R.string.note_yaw, R.raw.raw_detect_yaw, status + 1);
        } else if (value == LivenessState.SUCCESS) { //成功
            updateTheLastStepUI(mVGBottomDots);
            /**
             *  处理图片（用户自己可以处理图片 视频保存）
             */
//                    saveFinalEncrytFile(livenessEncryptResult, videoResult, imageResult);
        } else if (value == LivenessState.TRACKING_MISSED) { //采集失败，再试一次吧（追踪目标丢失）
            showDialog("追踪目标丢失");
        } else if (value == LivenessState.PREPARE) {
            //准备
        } else if (value == LivenessState.START) { //开始
            removeDetectWaitUI();
        }else if(value == LivenessState.ERROR){ //SDK异常
            String msg;
            switch (status) {
                case 1002:
                    msg = "未获取到图片数据";
                    break;
                case 1003:
                    msg = "内部错误";
                    break;
                case 1004:
                    msg = "包名绑定错误";
                    break;
                case 1005:
                    msg = "sdk初始化失败,模型加载失败";
                    break;
                case 1006:
                    msg = "license过期";
                    break;
                case 1007:
                    msg = "license读取失败";
                    break;
                default:
                    msg = "未知异常";
                    break;
            }

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            onErrorHappen();
        }
    }


    public void onErrorHappen() {
        finish();
    }

    private void hideIndicateView() {
        if (mGvView != null) {
            mGvView.setVisibility(View.GONE);
        }
        if (mVGBottomDots != null) {
            mVGBottomDots.setVisibility(View.GONE);
        }
        if (mNoteTextView != null) {
            mNoteTextView.setVisibility(View.GONE);
        }
    }

    private void showIndicateView() {
        if (mGvView != null) {
            mGvView.setVisibility(View.VISIBLE);
        }
        if (mVGBottomDots != null) {
            mVGBottomDots.setVisibility(View.VISIBLE);
        }
        if (mNoteTextView != null) {
            mNoteTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cllcSensorManager.registerListener(mSensorEventListener);
        if (isDialogShowing(null)) {
            mMediaPlayer.stop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        cllcSensorManager.unregisterListener(mSensorEventListener);
        mMediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimeViewContoller != null) {
            mTimeViewContoller.remove();
            mTimeViewContoller = null;
        }
        ocrAlertDialogClose();
        dismissDialog();
    }

    @Override
    public TestPresenter initPresenter() {
        return null;
    }

    private void updateTheLastStepUI(ViewGroup viewGroup) {
        mMediaPlayer.release();

        hideTimeContoller();

        hideIndicateView();
    }


    private void showDialog(String msg) {
        if (isDialogShowing(msg)) {
            return;
        }

        if (mDetectList.length >= 1) {
            for (int i = 0; i < mDetectList.length; i++) {
                View childAt = mVGBottomDots.getChildAt(i);
                if (childAt != null) {
                    childAt.setEnabled(true);
                }
            }
        }

        hideTimeContoller();

        hideIndicateView();

        setLivenessState(true);

        cllcAlertDialog = new CLLCAlertDialog(mContext,msg, new OcrAlertDialogListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  设置动画恢复
                 *
                 *  showIndicateView 动画UI显示
                 *  restartAnimationAndLiveness  重置检测判断逻辑
                 */
                showIndicateView();

                restartAnimationAndLiveness();
            }
        });
        if (((Activity) mContext).isFinishing()) {
            return;
        }
        cllcAlertDialog.show();
        mMediaPlayer.release();
    }

    public void ocrAlertDialogClose(){
        if(cllcAlertDialog != null){
            if(cllcAlertDialog.isShowing()){
                cllcAlertDialog.dismiss();
            }
            cllcAlertDialog = null;
        }
    }

    private void hideTimeContoller() {
        if (mTimeViewContoller != null) {
            mTimeViewContoller.hide();
        }
    }


    private void restartAnimationAndLiveness() {
        setLivenessState(false);
        if (mDetectList.length >= 1) {
            View childAt = mVGBottomDots.getChildAt(0);
            childAt.setEnabled(false);
        }
        mMediaPlayer.release();
        removeDetectWaitUI();
    }


    private void setLivenessState(boolean pause) {
        if (pause) {
            CLLCSDKManager.getInstance().stopLiveness();
        } else {
            CLLCSDKManager.getInstance().startLiveness();
        }
    }


    /**
     * 传感器状态监听
     */
    SensorEventListener mSensorEventListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            /**
             *  添加传感器检测
             */
            CLLCSDKManager.getInstance().addSequentialInfo(event.sensor.getType(), event.values);
        }
    };

    public void saveFinalEncrytFile(byte[] livenessEncryptResult, byte[] videoResult, CLLCImageResult[] imageResult) {
        /**
         * 用户自己处理图片或视频数据
         */
    }

    private void skipResultActivity(boolean result, String hint, String msg){
        Intent intent = new Intent(LivenessActivity.this,ResultActivity.class);
        intent.putExtra("result",result);
        intent.putExtra("msg",msg);
        if(!result){
            intent.putExtra("hint",hint);
        }
        startActivity(intent);

        finish();
    }

    private void removeDetectWaitUI() {
        switch (mDetectList[0]){
            case LivenessState.BLINK:
                updateUi(R.string.note_blink, R.raw.raw_detect_blink, 1);
                break;
            case LivenessState.NOD:
                updateUi(R.string.note_nod, R.raw.raw_detect_nod, 1);
                break;
            case LivenessState.MOUTH:
                updateUi(R.string.note_mouth, R.raw.raw_detect_mouth, 1);
                break;
            case LivenessState.YAW:
                updateUi(R.string.note_yaw, R.raw.raw_detect_yaw, 1);
                break;
        }
    }

    private void dataAnalysis(String result){
        try {
            JSONObject jsonObject = new JSONObject(result);
            if(jsonObject.getString("code").equals("200000")){
                JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                String status = jsonObject1.getString("status");
                if(status.equals("OK")){
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("identity");
                    if(jsonObject2.getBoolean("validity")) {
                        if(jsonObject1.has("confidence")) {
                            if (jsonObject1.getDouble("confidence") > 0.7) {
                                /**
                                 * confidence 置信度。值为 0~1，值越大表示两张照片属于同一个人的可能性越大
                                 *  0.4  十分之一错误率
                                 *  0.5  百分之一错误率
                                 *  0.6  千分之一错误率
                                 *  0.7  万分之一错误率
                                 *  0.8  十万分之一错误率
                                 *  0.9  百万分之一错误率
                                 */

                                skipResultActivity(true, "认证成功", result);
                            } else {
                                skipResultActivity(false, "活体照片与身份证照片置信度过低", result);
                            }
                        }else {
                            skipResultActivity(false,getErrorMsg(jsonObject2.getString("reason")),result);
                        }
                    }else {
                        skipResultActivity(false,"姓名与身份证号不匹配",result);
                    }
                }else {
                    switch (status){
                        case "PHOTO_SERVICE_ERROR":
                            skipResultActivity(false,getErrorMsg(jsonObject1.getString("reason")),result);
                            break;
                        case "ENCODING_ERROR":
                            skipResultActivity(false,"参数非UTF-8编码",result);
                            break;
                        case "IMAGE_ID_NOT_EXIST":
                            skipResultActivity(false,"图片不存在",result);
                            break;
                        case "IMAGE_FILE_SIZE_TOO_BIG":
                            skipResultActivity(false,"图片体积过大",result);
                            break;
                        case "NO_FACE_DETECTED":
                            skipResultActivity(false,"上传图片未检测出人脸",result);
                            break;
                        case "CORRUPT_IMAGE":
                            skipResultActivity(false,"不是图片文件或图片文件已经损坏",result);
                            break;
                        case "INVALID_IMAGE_FORMAT_OR_SIZE":
                            skipResultActivity(false,"图片大小或者格式不符合要求",result);
                            break;
                        case "INVALID_ARGUMENT":
                            skipResultActivity(false,getErrorMsg(jsonObject1.getString("reason")),result);
                            break;
                        case "RATE_LIMIT_EXCEEDED":
                            skipResultActivity(false,"调用频率超出限额",result);
                            break;
                        case "OUT_OF_QUOTA":
                            skipResultActivity(false,"调用次数超出限额",result);
                            break;
                        case "NOT_FOUND":
                            skipResultActivity(false,"请求路径错误",result);
                            break;
                        case "INTERNAL_ERROR":
                            skipResultActivity(false,"服务器内部错误",result);
                            break;
                        default:
                            skipResultActivity(false,"数据源服务服务出错",result);
                            break;
                    }
                }
            }else {
                skipResultActivity(false,jsonObject.getString("message"),result);
            }
        } catch (JSONException e) {
            skipResultActivity(false,e.toString(),result);
        }
    }

    private String getErrorMsg(String reason) {
        String msg;
        switch (reason) {
            case "Gongan photo doesn’t exist":
                msg = "姓名和身份证号匹配，近照不存在";
                break;
            case "Name and idcard number doesn’t match":
                msg = "姓名与身份证号不匹配";
                break;
            case "Invalid idcard number":
                msg = "查无此身份证号";
                break;
            case "Gongan service timeout":
                msg = "接口获取超时";
                break;
            case "Gongan service is unavailable temporarily":
                msg = "服务不可用";
                break;
            case "Network error":
                msg = "网络错误";
                break;
            case "Invalid name":
                msg = "身份证姓名有误";
                break;
            default:
                msg = "认证失败";
                break;
        }
        return msg;
    }

    private void showDialog(){
        if(m_Dialog == null) {
            m_Dialog = ProgressDialog.show(LivenessActivity.this, "请等待...", "正在校验...", true);
        }else {
            if(!m_Dialog.isShowing()){
                m_Dialog.dismiss();
                m_Dialog = null;
                showDialog();
            }
        }
    }

    private void dismissDialog(){
        if(m_Dialog != null) {
            m_Dialog.dismiss();
            m_Dialog = null;
        }
    }
}



