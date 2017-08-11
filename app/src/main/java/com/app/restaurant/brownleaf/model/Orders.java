package com.app.restaurant.brownleaf.model;

/**
 * Created by mobilecoe-imac6 on 16/01/17.
 */
public class Orders {
    String quantity;
    int price;
    String itemName;



    public Orders(){

    }

    public Orders(String quantity,int price,String itemName){

        this.quantity = quantity;
        this.price = price;
        this.itemName = itemName;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
