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
     * orders : []
     * per_page : 10
     * pages : 1
     * page : 1
     * total : 0
     */

    private int per_page;
    private int pages;
    private int page;
    private int total;
    private List<?> orders;

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

    public List<?> getOrders() {
        return orders;
    }

    public void setOrders(List<?> orders) {
        this.orders = orders;
    }
}
