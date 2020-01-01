package com.dytj.leekbox.model;


import java.util.List;

/**
 * Created by MaRufei on 2018/10/20.
 */

public class TradeListEntity {


    /**
     * trades : [{"id":46,"user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":100000,"left":100000,"price":"0.002","status":0,"status_text":"交易中"},{"id":45,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":2000,"left":2000,"price":"0.450","status":0,"status_text":"交易中"},{"id":44,"user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":2000,"left":2000,"price":"0.002","status":0,"status_text":"交易中"},{"id":43,"user":{"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":2000,"left":2000,"price":"0.002","status":0,"status_text":"交易中"},{"id":42,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":68,"left":68,"price":"22.000","status":0,"status_text":"交易中"},{"id":41,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":30,"left":30,"price":"3.100","status":0,"status_text":"交易中"},{"id":40,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":60,"left":60,"price":"2.100","status":0,"status_text":"交易中"},{"id":39,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":15,"left":15,"price":"3.200","status":0,"status_text":"交易中"},{"id":38,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":4,"left":4,"price":"3.100","status":0,"status_text":"交易中"},{"id":37,"user":{"tel":"132****0912","avatar_url":"http://112.74.127.99:5016/images/default.png"},"point":3,"left":3,"price":"1.200","status":0,"status_text":"交易中"}]
     * per_page : 10
     * pages : 4
     * page : 1
     * total : 34
     */

    private int per_page;
    private int pages;
    private int page;
    private int total;
    private List<TradesBean> trades;

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

    public List<TradesBean> getTrades() {
        return trades;
    }

    public void setTrades(List<TradesBean> trades) {
        this.trades = trades;
    }

    public static class TradesBean {
        /**
         * id : 46
         * user : {"tel":"152****5510","avatar_url":"http://112.74.127.99:5016/images/default.png"}
         * point : 100000
         * left : 100000
         * price : 0.002
         * status : 0
         * status_text : 交易中
         */

        private int id;
        private UserBean user;
        private int point;
        private int left;
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

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
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
