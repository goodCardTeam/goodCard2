package com.dytj.leekbox.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by MaRufei on 2018/10/20.
 */

public class TradeListEntity extends TradeSimpleResult implements Serializable {


    /**
     * trades : [{"id":4,"trade_type":1,"point":2000,"left":2000,"price":"0.002"},{"id":2,"trade_type":1,"point":2000,"left":2000,"price":"0.002"},{"id":1,"trade_type":1,"point":1000,"left":1000,"price":"0.001"}]
     * per_page : 10
     * pages : 1
     * page : 1
     * total : 3
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
         * id : 4
         * trade_type : 1
         * point : 2000
         * left : 2000
         * price : 0.002
         */

        private int id;
        private int trade_type;
        private int point;
        private int left;
        private String price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(int trade_type) {
            this.trade_type = trade_type;
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
    }
}
