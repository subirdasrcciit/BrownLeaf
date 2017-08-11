package com.app.restaurant.brownleaf.model;

import android.widget.TextView;

/**
 * Created by mobilecoe-imac6 on 16/01/17.
 */
public class PriceQuantity {

    String price;
    TextView quantityTxt;
    String itemName;

    public PriceQuantity(String price,TextView quantityTxt,String itemName){

        this.price = price;
        this.quantityTxt = quantityTxt;
        this.itemName = itemName;

    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public TextView getQuantityTxt() {
        return quantityTxt;
    }

    public void setQuantityTxt(TextView quantityTxt) {
        this.quantityTxt = quantityTxt;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
