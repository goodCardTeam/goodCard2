package com.dytj.leekbox.model;

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
     * orders : [{"id":17,"order_no":"15775067520008","user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"trade_user":{"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":100,"sum":"0.200","pay_sum":"0.20","status":20,"status_text":"已完成","created_at":"2019-12-27 18:37:58"}]
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
         * id : 17
         * order_no : 15775067520008
         * user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * trade_user : {"tel":"152****5511","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 100
         * sum : 0.200
         * pay_sum : 0.20
         * status : 20
         * status_text : 已完成
         * created_at : 2019-12-27 18:37:58
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
