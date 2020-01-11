package com.dytj.goodcard.model;

/**
 * Created by MaRufei
 * on 2019-12-30.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class CreateTradeOrderEntity {

    /**
     * order : {"id":19,"order_no":"15777081489694","user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"trade_user":{"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":100,"sum":"0.200","pay_sum":"0.20","status":0,"status_text":"待打款","created_at":"2019-12-30 20:15:48"}
     */

    private OrderBean order;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * id : 19
         * order_no : 15777081489694
         * user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * trade_user : {"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 100
         * sum : 0.200
         * pay_sum : 0.20
         * status : 0
         * status_text : 待打款
         * created_at : 2019-12-30 20:15:48
         */

        private int id;
        private String order_no;
        private UserBean user;
        private TradeUserBean trade_user;
        private int point;
        private String sum;
        private String pay_sum;
        private int status;
        private String status_text;
        private String created_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public TradeUserBean getTrade_user() {
            return trade_user;
        }

        public void setTrade_user(TradeUserBean trade_user) {
            this.trade_user = trade_user;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public String getPay_sum() {
            return pay_sum;
        }

        public void setPay_sum(String pay_sum) {
            this.pay_sum = pay_sum;
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

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
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

        public static class TradeUserBean {
            /**
             * tel : 152****5511
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
