package com.dytj.goodcard.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.dytj.goodcard.AppConfig;
import com.dytj.goodcard.MyApplication;
import com.dytj.goodcard.api.baseFile.BaseNetWork;
import com.dytj.goodcard.model.BuyEntity;
import com.dytj.goodcard.model.CreateTradeOrderEntity;
import com.dytj.goodcard.model.GoodDetailEntity;
import com.dytj.goodcard.model.GoodsListEntity;
import com.dytj.goodcard.model.GoodsTypeEntity;
import com.dytj.goodcard.model.LoginEntity;
import com.dytj.goodcard.model.LunBoTuEntity;
import com.dytj.goodcard.model.MessageEntity;
import com.dytj.goodcard.model.MyTradeOrderEntity;
import com.dytj.goodcard.model.RainbowEntity;
import com.dytj.goodcard.model.RegisterEntity;
import com.dytj.goodcard.model.TradeListEntity;
import com.dytj.goodcard.model.JsonResponse;
import com.dytj.goodcard.model.TradeOrderInfoEntity;
import com.dytj.goodcard.model.UserRechargeWay;
import com.dytj.goodcard.utils.SystemToolUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by zeng on 2019/4/9.
 */

public class UserNetWork extends BaseNetWork {

    protected final NetService service = getRetrofit().create(NetService.class);
    protected final NetService service2 = getRetrofit2().create(NetService.class);

    private interface NetService {

        /**
         * 用户登录
         */
        @FormUrlEncoded
        @POST("api/login")
        Observable<JsonResponse<LoginEntity>> userLogin(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 用户注册
         */
        @FormUrlEncoded
        @POST("api/register")
        Observable<RegisterEntity> userRegister(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 刷新token
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/refresh")
        Observable<JsonResponse<LoginEntity>> refreshToken(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 获取验证码
         * @return
         */
        @FormUrlEncoded
        @POST("api/sms")
        Observable<JsonResponse> userGetSms(@FieldMap HashMap<String,Object> modificationPassWordEntryMap);

        /**
         * 买卖列表
         */
        @FormUrlEncoded
        @POST("api/trades")
        Observable<JsonResponse<TradeListEntity>> tradeList(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 彩虹卡列表
         */
        @FormUrlEncoded
        @POST("api/cards")
        Observable<JsonResponse<RainbowEntity>> rainbowList(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 买入积分
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trades/add")
        Observable<JsonResponse<BuyEntity>> buyPointRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 我的积分交易订单列表
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/my")
        Observable<JsonResponse<MyTradeOrderEntity>> myTradeOrderRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 创建积分交易订单
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/add")
        Observable<JsonResponse<CreateTradeOrderEntity>> createTradeOrderRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 积分交易订单详情
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/detail")
        Observable<JsonResponse<TradeOrderInfoEntity>> tradeOrderInfoRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);


        /**
         * 确认收款
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/receive")
        Observable<JsonResponse> tradeOrderGetMoneyRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);


        /**
         * 确认打款
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/send")
        Observable<JsonResponse> tradeOrderPayRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 投诉
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/complain")
        Observable<JsonResponse> tradeOrderComplainRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 取消订单
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/trade-orders/cancel")
        Observable<JsonResponse> tradeOrderCancelRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 获取淘宝商品分类
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/tbk/category")
        Observable<JsonResponse<List<GoodsTypeEntity>>> tbGoodsTypeRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);

        /**
         * 获取淘宝商品列表
         * @param modificationPassWordEntryMap
         * @return
         */
        @FormUrlEncoded
        @POST("api/tbk/products")
        Observable<JsonResponse<GoodsListEntity>> tbGoodsListRequest(@FieldMap HashMap<String, Object> modificationPassWordEntryMap);


        /**
         *
         * @param map
         * @return
         */
        @FormUrlEncoded
        @POST("api/tbk/goods")
        Observable<JsonResponse<GoodDetailEntity>> tbGoodDetailRequest(@FieldMap HashMap<String, Object> map);


        //获取消息列表
        @GET("api/AppPrivate/get_messages")
        Observable<MessageEntity> toGetMessageEntity(@QueryMap HashMap<String, Object> modificationPassWordEntryMap);

        //查询app充值和提现用原生还是H5页
        @GET("public/dialog?")
        Observable<UserRechargeWay> getUserRechargeWay(@QueryMap HashMap<String, Object> modificationPassWordEntryMap);

        //获取首页轮播图
        @GET("api/AppPubilc/get_lunbotu")
        Observable<LunBoTuEntity> toGetLunBoTuEntity();

        //获取首页轮播图
        @GET("api/AppPubilc/get_lunbotu")
        Observable<LunBoTuEntity> toGetLunBoTuEntity2();

        //刷新token
        @FormUrlEncoded
        @POST("directlink/user/active/record")
        Observable<JsonResponse> getUserRecordEntity(@FieldMap HashMap<String, Object> paramMap);
    }

    //登录
    public void userLogin(HashMap<String, Object> paramMap, Observer<JsonResponse<LoginEntity>> observer) {
        getSign(paramMap);
        setSubscribe(service.userLogin(paramMap), observer);
    }

    //注册
    public void userRegister(HashMap<String, Object> paramMap, Observer<RegisterEntity> observer) {
        getSign(paramMap);
        setSubscribe(service.userRegister(paramMap), observer);
    }

    //获取验证码
    public void usergetSms(HashMap<String, Object> paramMap, Observer<JsonResponse> observer) {
        getSign(paramMap);
        setSubscribe(service.userGetSms(paramMap), observer);
    }

    //获取消息列表
    public void toGetMessageEntity(HashMap<String, Object> paramMap, Observer<MessageEntity> observer) {
        setSubscribe(service.toGetMessageEntity(paramMap), observer);
    }

    //查询app充值和提现用原生还是H5页
    public void getUserRechargeWay(HashMap<String, Object> paramMap, Observer<UserRechargeWay> observer) {
        setSubscribe(service.getUserRechargeWay(paramMap), observer);
    }

    //首页轮播图
    public void toGetLunBoTuEntity(Observer<LunBoTuEntity> observer) {
        setSubscribe(service.toGetLunBoTuEntity(), observer);
    }

    //首页轮播图
    public void toGetLunBoTuEntity2(Observer<LunBoTuEntity> observer) {
        setSubscribe(service2.toGetLunBoTuEntity2(), observer);
    }

    //刷新token
    public void getUserRecordEntity(HashMap<String, Object> paramMap, Observer<JsonResponse> observer) {
        setSubscribe(service.getUserRecordEntity(paramMap), observer);
    }
//    ----------------------------------------------------------------------------------------------

    /**
     * 买卖列表
     * @param paramMap
     * @param observer
     */
    public void tradeList(HashMap<String, Object> paramMap, Observer<JsonResponse<TradeListEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.tradeList(paramMap),observer);
    }

    /**
     * 彩虹卡列表
     * @param paramMap
     * @param observer
     */
    public void rainbowList(HashMap<String, Object> paramMap, Observer<JsonResponse<RainbowEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.rainbowList(paramMap),observer);
    }

    /**
     * 刷新token
     * @param paramMap
     * @param observer
     */
    public void refreshToken(HashMap<String, Object> paramMap, Observer<JsonResponse<LoginEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.refreshToken(paramMap),observer);
    }

    /**
     * 买入积分
     * @param paramMap
     * @param observer
     */
    public void buyPointRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<BuyEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.buyPointRequest(paramMap),observer);
    }

    /**
     * 我的积分交易订单
     * @param paramMap
     * @param observer
     */
    public void myTradeOrderRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<MyTradeOrderEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.myTradeOrderRequest(paramMap),observer);
    }

    /**
     * 创建交易订单
     * @param paramMap
     * @param observer
     */
    public void createTradeOrderRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<CreateTradeOrderEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.createTradeOrderRequest(paramMap),observer);
    }

    /**
     * 交易订单详情
     * @param paramMap
     * @param observer
     */
    public void tradeOrderInfoRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<TradeOrderInfoEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.tradeOrderInfoRequest(paramMap),observer);
    }

    /**
     * 确认收款
     * @param paramMap
     * @param observer
     */
    public void tradeOrderGetMoneyRequest(HashMap<String, Object> paramMap, Observer<JsonResponse> observer){
        getSign(paramMap);
        setSubscribe(service.tradeOrderGetMoneyRequest(paramMap),observer);
    }

    /**
     * 确认打款
     * @param paramMap
     * @param observer
     */
    public void tradeOrderPayRequest(HashMap<String, Object> paramMap, Observer<JsonResponse> observer){
        getSign(paramMap);
        setSubscribe(service.tradeOrderPayRequest(paramMap),observer);
    }

    /**
     * 投诉
     * @param paramMap
     * @param observer
     */
    public void tradeOrderComplainRequest(HashMap<String, Object> paramMap, Observer<JsonResponse> observer){
        getSign(paramMap);
        setSubscribe(service.tradeOrderComplainRequest(paramMap),observer);
    }

    /**
     * 取消订单
     * @param paramMap
     * @param observer
     */
    public void tradeOrderCancelRequest(HashMap<String, Object> paramMap, Observer<JsonResponse> observer){
        getSign(paramMap);
        setSubscribe(service.tradeOrderCancelRequest(paramMap),observer);
    }

    /**
     * 获取淘宝客商品分类
     * @param paramMap
     * @param observer
     */
    public void tbGoodsTypeRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<List<GoodsTypeEntity>>> observer){
        getSign(paramMap);
        setSubscribe(service.tbGoodsTypeRequest(paramMap),observer);
    }

    /**
     * 获取淘宝客商品列表
     * @param paramMap
     * @param observer
     */
    public void tbGoodsListRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<GoodsListEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.tbGoodsListRequest(paramMap),observer);
    }

    /**
     * 获取淘宝客商品详情
     * @param paramMap
     * @param observer
     */
    public void tbGoodDetailRequest(HashMap<String, Object> paramMap, Observer<JsonResponse<GoodDetailEntity>> observer){
        getSign(paramMap);
        setSubscribe(service.tbGoodDetailRequest(paramMap),observer);
    }

    /**
     * 获取签名
     * @param paramMap
     */
    private void getSign(HashMap<String, Object> paramMap){
        String timesTamp= String.valueOf(System.currentTimeMillis());
        String randomString=getRandomString(16);
        String versionName= MyApplication.getAppVersionName();
        paramMap.put("timestamp",timesTamp);
        paramMap.put("nonce_str",randomString);
        paramMap.put("version",versionName);
        String sign=SystemToolUtils.getKeyValue(paramMap);
        String signMd5=md5(sign);
        paramMap.put("sign",signMd5.toUpperCase());
    }


    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * MD5加密
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest((string +"key="+ AppConfig.MD5_KEY).getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }




}
