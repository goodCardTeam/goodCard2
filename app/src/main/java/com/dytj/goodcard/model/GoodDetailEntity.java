package com.dytj.goodcard.model;

import java.util.List;

public class GoodDetailEntity {

    /**
     * category_id : 50011167
     * category_name : 羽绒服
     * click_url : //s.click.taobao.com/t?e=m=2&s=8Xa/PFHXqxlw4vFB6t2Z2ueEDrYVVa64Dne87AjQPk9yINtkUhsv0ODeEGbUmdcuu4orzXpSVFHjT12OcAcHVMhyDTBdPItcsNQRgCGSPJiCxExFRhv2am1Oj6X8AnrkTmIFkCwUT1UCv/ctrzKV/edxs416Jy/NC2TKqEFvn7inXTIMRtDNDixYWk/mMjF4zY2heEKaR20HnbuuAZo1YuXCtfVOE0WGxg5p7bh+FbQ=&scm=1007.15023.81719.0&pvid=7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;originalFloorId:3756;pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e;app_pvid:59590_11.132.118.147_500_1577506314033&union_lens=lensId:MAPI@1577506314@0b847693_0d67_16f4ab41824_e53f@01
     * commission_rate : 9.0
     * coupon_amount : 100
     * coupon_click_url : //uland.taobao.com/coupon/edetail?e=mLU3k1U/KN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0+c5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b+n3oRHM5v+iV10TOhVplj/n412/D5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN/hsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3/Se53seAQX44d+zmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId:MAPI@1577506314@0b847693_0d67_16f4ab41824_e53f@01
     * coupon_end_time : 1577807999000
     * coupon_info : 满179.00元减100元
     * coupon_remain_count : 95000
     * coupon_share_url : //uland.taobao.com/coupon/edetail?e=mLU3k1U/KN8NfLV8niU3R5TgU2jJNKOfU1BGIDN741G0+c5Gzwi6geKSfLX1rbqQLGbJes29FQq2QeBl4W2u76Q4b+n3oRHM5v+iV10TOhVplj/n412/D5ozO2UE2w82cSx3mKTxOk7W6H799vT0xmhMDxN/hsAjUtdoUJIEg8oBjOtraWMhmQmmHhW2ZPZ78lAdaFJu8XQ3/Se53seAQX44d+zmctAY&&app_pvid=59590_11.132.118.147_500_1577506314033&ptl=floorId:3756;app_pvid:59590_11.132.118.147_500_1577506314033;tpp_pvid:7a9d3fe5-7c04-48d3-bf06-c4679fa5069e&union_lens=lensId:MAPI@1577506314@0b847693_0d67_16f4ab41824_e53f@01
     * coupon_start_fee : 179.0
     * coupon_start_time : 1577462400000
     * coupon_total_count : 100000
     * item_description : []
     * item_id : 602442927978
     * level_one_category_id : 30
     * level_one_category_name : 男装
     * nick : 富贵鸟男装旗舰店
     * pict_url : //img.alicdn.com/bao/uploaded/i2/810959940/O1CN01TBNl6J2NIZTKmHxhe_!!0-item_pic.jpg
     * seller_id : 810959940
     * shop_title : 富贵鸟男装旗舰店
     * small_images : {"string":["//img.alicdn.com/i3/810959940/O1CN01Tbrc322NIZTNr32Rw_!!0-item_pic.jpg"]}
     * title : 富贵鸟冬季轻薄款羽绒服男短款青年潮帅气外套白鸭绒新款爆款中年
     * user_type : 1
     * volume : 275
     * zk_final_price : 179
     * yongjin : 8.06
     * jifen : 8.06
     */

    private String category_id;
    private String category_name;
    private String click_url;
    private String commission_rate;
    private String coupon_amount;
    private String coupon_click_url;
    private String coupon_end_time;
    private String coupon_info;
    private String coupon_remain_count;
    private String coupon_share_url;
    private String coupon_start_fee;
    private String coupon_start_time;
    private String coupon_total_count;
    private String item_id;
    private String level_one_category_id;
    private String level_one_category_name;
    private String nick;
    private String pict_url;
    private String seller_id;
    private String shop_title;
    private SmallImagesBean small_images;
    private String title;
    private String user_type;
    private String volume;
    private String zk_final_price;
    private double yongjin;
    private double jifen;
    private List<?> item_description;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getClick_url() {
        return click_url;
    }

    public void setClick_url(String click_url) {
        this.click_url = click_url;
    }

    public String getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(String commission_rate) {
        this.commission_rate = commission_rate;
    }

    public String getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(String coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    public String getCoupon_click_url() {
        return coupon_click_url;
    }

    public void setCoupon_click_url(String coupon_click_url) {
        this.coupon_click_url = coupon_click_url;
    }

    public String getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(String coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }

    public String getCoupon_info() {
        return coupon_info;
    }

    public void setCoupon_info(String coupon_info) {
        this.coupon_info = coupon_info;
    }

    public String getCoupon_remain_count() {
        return coupon_remain_count;
    }

    public void setCoupon_remain_count(String coupon_remain_count) {
        this.coupon_remain_count = coupon_remain_count;
    }

    public String getCoupon_share_url() {
        return coupon_share_url;
    }

    public void setCoupon_share_url(String coupon_share_url) {
        this.coupon_share_url = coupon_share_url;
    }

    public String getCoupon_start_fee() {
        return coupon_start_fee;
    }

    public void setCoupon_start_fee(String coupon_start_fee) {
        this.coupon_start_fee = coupon_start_fee;
    }

    public String getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(String coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public String getCoupon_total_count() {
        return coupon_total_count;
    }

    public void setCoupon_total_count(String coupon_total_count) {
        this.coupon_total_count = coupon_total_count;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getLevel_one_category_id() {
        return level_one_category_id;
    }

    public void setLevel_one_category_id(String level_one_category_id) {
        this.level_one_category_id = level_one_category_id;
    }

    public String getLevel_one_category_name() {
        return level_one_category_name;
    }

    public void setLevel_one_category_name(String level_one_category_name) {
        this.level_one_category_name = level_one_category_name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPict_url() {
        return pict_url;
    }

    public void setPict_url(String pict_url) {
        this.pict_url = pict_url;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getShop_title() {
        return shop_title;
    }

    public void setShop_title(String shop_title) {
        this.shop_title = shop_title;
    }

    public SmallImagesBean getSmall_images() {
        return small_images;
    }

    public void setSmall_images(SmallImagesBean small_images) {
        this.small_images = small_images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }

    public double getYongjin() {
        return yongjin;
    }

    public void setYongjin(double yongjin) {
        this.yongjin = yongjin;
    }

    public double getJifen() {
        return jifen;
    }

    public void setJifen(double jifen) {
        this.jifen = jifen;
    }

    public List<?> getItem_description() {
        return item_description;
    }

    public void setItem_description(List<?> item_description) {
        this.item_description = item_description;
    }

    public static class SmallImagesBean {
        private List<String> string;

        public List<String> getString() {
            return string;
        }

        public void setString(List<String> string) {
            this.string = string;
        }
    }
}
