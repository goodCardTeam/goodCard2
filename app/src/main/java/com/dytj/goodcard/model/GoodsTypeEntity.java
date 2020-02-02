package com.dytj.goodcard.model;

/**
 * Created by MaRufei
 * on 2020-01-30.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class GoodsTypeEntity {

    /**
     * material_id : 3756
     * name : 综合
     * sort : 0
     */

    private int material_id;
    private String name;
    private int sort;

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
