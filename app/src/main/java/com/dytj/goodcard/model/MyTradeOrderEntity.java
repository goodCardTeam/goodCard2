package com.dytj.goodcard.model;

import java.util.List;

/**
 * Created by MaRufei
 * on 2019-12-29.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class MyTradeOrderEntity {

    /**
     * orders : [{"id":1,"order_no":"15782189675985","user_type":2,"user":{"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"},"trade_user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":1000,"price":"0.002","sum":"2.000","pay_sum":"2.00","payment_type":1,"wechat":null,"alipay":{"account":"user_2@qq.com","name":"张三","qrcode":""},"status":20,"status_text":"已完成","created_at":"2020-01-05 18:09:27","send_time":"2020-01-05 18:09:38","receive_time":"2020-01-05 18:09:44"}]
     * per_page : 10
     * pages : 1
     * page : 1
     * total : 1
     */

    private int per_page;
    private int pages;
    private int page;
    private int total;
    private List<OrdersBean> orders;

    @Override
    public String toString() {
        return "MyTradeOrderEntity{" +
                "per_page=" + per_page +
                ", pages=" + pages +
                ", page=" + page +
                ", total=" + total +
                ", orders=" + orders +
                '}';
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OrdersBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersBean> orders) {
        this.orders = orders;
    }

    public static class OrdersBean {
        /**
         * id : 1
         * order_no : 15782189675985
         * user_type : 2
         * user : {"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * trade_user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 1000
         * price : 0.002
         * sum : 2.000
         * pay_sum : 2.00
         * payment_type : 1
         * wechat : null
         * alipay : {"account":"user_2@qq.com","name":"张三","qrcode":""}
         * status : 20
         * status_text : 已完成
         * created_at : 2020-01-05 18:09:27
         * send_time : 2020-01-05 18:09:38
         * receive_time : 2020-01-05 18:09:44
         */

        private int id;
        private String order_no;
        /**
         * 卖单1，买单2
         */
        private int user_type;
        private UserBean user;
        private TradeUserBean trade_user;
        private int point;
        private String price;
        private String sum;
        private String pay_sum;
        private int payment_type;
        private Object wechat;
        private AlipayBean alipay;
        private int status;
        private String status_text;
        private String created_at;
        private String send_time;
        private String receive_time;

        @Override
        public String toString() {
            return "OrdersBean{" +
                    "id=" + id +
                    ", order_no='" + order_no + '\'' +
                    ", user_type=" + user_type +
                    ", user=" + user +
                    ", trade_user=" + trade_user +
                    ", point=" + point +
                    ", price='" + price + '\'' +
                    ", sum='" + sum + '\'' +
                    ", pay_sum='" + pay_sum + '\'' +
                    ", payment_type=" + payment_type +
                    ", wechat=" + wechat +
                    ", alipay=" + alipay +
                    ", status=" + status +
                    ", status_text='" + status_text + '\'' +
                    ", created_at='" + created_at + '\'' +
                    ", send_time='" + send_time + '\'' +
                    ", receive_time='" + receive_time + '\'' +
                    '}';
        }

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
             * tel : 152****5511
             * avatar_url : http://112.74.127.99:5016/images/default.png
             */

            private String tel;
            private String avatar_url;

            @Override
            public String toString() {
                return "UserBean{" +
                        "tel='" + tel + '\'' +
                        ", avatar_url='" + avatar_url + '\'' +
                        '}';
            }

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

            private String tel;
            private String avatar_url;

            @Override
            public String
            toString() {
                return "TradeUserBean{" +
                        "tel='" + tel + '\'' +
                        ", avatar_url='" + avatar_url + '\'' +
                        '}';
            }

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
             * account : user_2@qq.com
             * name : 张三
             * qrcode :
             */

            private String account;
            private String name;
            private String qrcode;

            @Override
            public String toString() {
                return "AlipayBean{" +
                        "account='" + account + '\'' +
                        ", name='" + name + '\'' +
                        ", qrcode='" + qrcode + '\'' +
                        '}';
            }

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
