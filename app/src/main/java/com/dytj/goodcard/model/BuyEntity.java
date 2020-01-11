package com.dytj.goodcard.model;

/**
 * Created by MaRufei
 * on 2019-12-28.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class BuyEntity {

    /**
     * trade : {"id":17,"user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":"2000","left":"2000","price":"0.00222","status":0,"status_text":"交易中"}
     */

    private TradeBean trade;

    public TradeBean getTrade() {
        return trade;
    }

    public void setTrade(TradeBean trade) {
        this.trade = trade;
    }

    public static class TradeBean {
        /**
         * id : 17
         * user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 2000
         * left : 2000
         * price : 0.00222
         * status : 0
         * status_text : 交易中
         */

        private int id;
        private UserBean user;
        private String point;
        private String left;
        private String price;
        private int status;
        private String status_text;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getLeft() {
            return left;
        }

        public void setLeft(String left) {
            this.left = left;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }

        public static class UserBean {
            /**
             * tel : 152****5510
             * avatar_url : http://112.74.127.99:5016/images/default.png
             */

            private String tel;
            private String avatar_url;

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }
        }
    }
}
