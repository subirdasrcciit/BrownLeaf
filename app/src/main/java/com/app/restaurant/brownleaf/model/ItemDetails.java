package com.app.restaurant.brownleaf.model;

import java.io.Serializable;

/**
 * Created by mobilecoe-imac6 on 28/02/17.
 */
public class ItemDetails implements Serializable {
    String title, desc;
    int price;


    public ItemDetails() {

    }

    public ItemDetails(String title, String desc, int price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
