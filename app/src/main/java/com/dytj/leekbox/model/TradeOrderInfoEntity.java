package com.dytj.leekbox.model;

/**
 * Created by MaRufei
 * on 2019-12-28.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class TradeOrderInfoEntity {


    /**
     * order : {"id":18,"order_no":"15775067520009","user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"trade_user":{"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":100,"sum":"0.200","pay_sum":"0.20","status":-10,"status_text":"已取消","created_at":"2019-12-27 18:39:01"}
     * left_seconds : 0
     * trade_user_alipay : {"account":"123@qq.com","name":"张三"}
     */

    private OrderBean order;
    private int left_seconds;
    private TradeUserAlipayBean trade_user_alipay;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public int getLeft_seconds() {
        return left_seconds;
    }

    public void setLeft_seconds(int left_seconds) {
        this.left_seconds = left_seconds;
    }

    public TradeUserAlipayBean getTrade_user_alipay() {
        return trade_user_alipay;
    }

    public void setTrade_user_alipay(TradeUserAlipayBean trade_user_alipay) {
        this.trade_user_alipay = trade_user_alipay;
    }

    public static class OrderBean {
        /**
         * id : 18
         * order_no : 15775067520009
         * user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * trade_user : {"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 100
         * sum : 0.200
         * pay_sum : 0.20
         * status : -10
         * status_text : 已取消
         * created_at : 2019-12-27 18:39:01
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

    public static class TradeUserAlipayBean {
        /**
         * account : 123@qq.com
         * name : 张三
         */

        private String account;
        private String name;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
