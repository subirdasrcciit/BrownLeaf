package com.app.restaurant.brownleaf.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mobilecoe-imac6 on 03/04/17.
 */
public class RestaurantInfo implements Serializable {

    private String title, address, phoneNum;
    private int distance;
    private List<String> itemTypeTitles;
    private List<ItemDetails> itemList;

    public RestaurantInfo() {
    }

    public RestaurantInfo(String title, String address, String phoneNum,int dist) {
        this.title = title;
        this.address = address;
        this.phoneNum = phoneNum;
        this.distance = dist;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<String> getItemTypeTitles() {
        return itemTypeTitles;
    }

    public void setItemTypeTitles(List<String> itemTypeTitles) {
        this.itemTypeTitles = itemTypeTitles;
    }

    public List<ItemDetails> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDetails> itemList) {
        this.itemList = itemList;
    }
}
