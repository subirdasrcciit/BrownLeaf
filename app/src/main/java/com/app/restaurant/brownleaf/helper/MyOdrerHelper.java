package com.app.restaurant.brownleaf.helper;

import com.app.restaurant.brownleaf.model.Orders;
import com.app.restaurant.brownleaf.model.PriceQuantity;
import com.app.restaurant.brownleaf.util.Utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by mobilecoe-imac6 on 16/01/17.
 */
public class MyOdrerHelper {


    private static MyOdrerHelper myOdrerHelper;

    private MyOdrerHelper() {
    }

    public static MyOdrerHelper getInstance() {
        if (myOdrerHelper == null) {
            myOdrerHelper = new MyOdrerHelper();
        }
        return myOdrerHelper;
    }


    public int totalPriceCount(List<Orders> orders) {
        int total = 0;
        if (orders != null) {
            for (Orders order : orders) {
                if (order != null) {

                    int quantity = Utility.getIntValueFromString(order.getQuantity());

                    total += order.getPrice() * quantity;
                }
            }
        }
        return total;
    }

    public List<Orders> getPrepareOrderData() {

        List<Orders> ordersList = new ArrayList<>();

        if (FoodListHelper.getInstance().getListPosition_QuantityMap() != null) {

            Iterator it = FoodListHelper.getInstance().getListPosition_QuantityMap().entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                PriceQuantity priceQuantity = (PriceQuantity) pair.getValue();
                if (priceQuantity != null && priceQuantity.getQuantityTxt() != null) {

                    Orders order = new Orders();

                    int quantity = Utility.getIntValueFromString(priceQuantity.getQuantityTxt().getText().toString());

                    order.setPrice(Utility.getIntValueFromString(priceQuantity.getPrice()));

                    order.setQuantity(String.valueOf(quantity));
                    order.setItemName(priceQuantity.getItemName());

                    ordersList.add(order);
                }
            }
        }


        return ordersList;
    }


}
