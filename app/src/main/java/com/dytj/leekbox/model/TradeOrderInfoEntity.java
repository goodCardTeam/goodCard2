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
     * order : {"id":2,"order_no":"15782330051795","user_type":1,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"trade_user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":1000,"price":"0.002","sum":"2.000","pay_sum":"2.00","payment_type":0,"wechat":null,"alipay":{"account":"user_3@qq.com","name":"张三","qrcode":""},"status":-10,"status_text":"已取消","created_at":"2020-01-05 22:03:25","send_time":"","receive_time":""}
     * left_seconds : 0
     * user_tel : 13213580912
     * trade_user_tel : 15251815510
     */

    private OrderBean order;
    private int left_seconds;
    private String user_tel="";
    private String trade_user_tel="";

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

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getTrade_user_tel() {
        return trade_user_tel;
    }

    public void setTrade_user_tel(String trade_user_tel) {
        this.trade_user_tel = trade_user_tel;
    }

    public static class OrderBean {
        /**
         * id : 2
         * order_no : 15782330051795
         * user_type : 1
         * user : {"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * trade_user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 1000
         * price : 0.002
         * sum : 2.000
         * pay_sum : 2.00
         * payment_type : 0
         * wechat : null
         * alipay : {"account":"user_3@qq.com","name":"张三","qrcode":""}
         * status : -10
         * status_text : 已取消
         * created_at : 2020-01-05 22:03:25
         * send_time :
         * receive_time :
         */

        private int id;
        private String order_no="";
        private int user_type;
        private UserBean user;
        private TradeUserBean trade_user;
        private int point;
        private String price="";
        private String sum="";
        private String pay_sum="";
        private int payment_type;
        private Object wechat;
        private AlipayBean alipay;
        private int status;
        private String status_text="";
        private String created_at="";
        private String send_time="";
        private String receive_time="";

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

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
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

        public int getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(int payment_type) {
            this.payment_type = payment_type;
        }

        public Object getWechat() {
            return wechat;
        }

        public void setWechat(Object wechat) {
            this.wechat = wechat;
        }

        public AlipayBean getAlipay() {
            return alipay;
        }

        public void setAlipay(AlipayBean alipay) {
            this.alipay = alipay;
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

        public String getSend_time() {
            return send_time;
        }

        public void setSend_time(String send_time) {
            this.send_time = send_time;
        }

        public String getReceive_time() {
            return receive_time;
        }

        public void setReceive_time(String receive_time) {
            this.receive_time = receive_time;
        }

        public static class UserBean {
            /**
             * tel : 132****0912
             * avatar_url : http://112.74.127.99:5016/images/default.png
             */

            private String tel="";
            private String avatar_url="";

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
             * tel : 152****5510
             * avatar_url : http://112.74.127.99:5016/images/default.png
             */

            private String tel="";
            private String avatar_url="";

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

        public static class AlipayBean {
            /**
             * account : user_3@qq.com
             * name : 张三
             * qrcode :
             */

            private String account="";
            private String name="";
            private String qrcode="";

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

            public String getQrcode() {
                return qrcode;
            }

            public void setQrcode(String qrcode) {
                this.qrcode = qrcode;
            }
        }
    }


}
