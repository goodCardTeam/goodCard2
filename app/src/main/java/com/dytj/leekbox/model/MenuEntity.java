package com.dytj.leekbox.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MaRufei
 * on 2019-12-11.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class MenuEntity implements Serializable {
    String title;
    List<MenuItemEntity> menuItemEntityList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuItemEntity> getMenuItemEntityList() {
        return menuItemEntityList;
    }

    public void setMenuItemEntityList(List<MenuItemEntity> menuItemEntityList) {
        this.menuItemEntityList = menuItemEntityList;
    }

    public static class MenuItemEntity implements Serializable {
        private String name;
        private String imgUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
