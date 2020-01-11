package com.dytj.goodcard.model;

import java.util.List;

/**
 * Created by MaRufei
 * on 2019-12-22.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class RainbowEntity {

    private List<CardsBean> cards;

    public List<CardsBean> getCards() {
        return cards;
    }

    public void setCards(List<CardsBean> cards) {
        this.cards = cards;
    }

    public static class CardsBean {
        /**
         * id : 1
         * name : 英勇白卡（体验卡）
         * point : 1000
         * month_rate : 10%
         * days : 30
         */

        private int id;
        private String name;
        private int point;
        private String month_rate;
        private int days;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public String getMonth_rate() {
            return month_rate;
        }

        public void setMonth_rate(String month_rate) {
            this.month_rate = month_rate;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }
    }
}
