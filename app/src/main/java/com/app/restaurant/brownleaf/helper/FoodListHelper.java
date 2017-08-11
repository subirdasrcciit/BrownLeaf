package com.app.restaurant.brownleaf.helper;

import android.widget.TextView;

import com.app.restaurant.brownleaf.model.PriceQuantity;
import com.app.restaurant.brownleaf.screens.NavMenuActivity;
import com.app.restaurant.brownleaf.util.Utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mobilecoe-imac6 on 13/01/17.
 */
public class FoodListHelper {

    private static HashMap<Integer, PriceQuantity> listPosition_QuantityMap;
    private static FoodListHelper foodListHelper;
    private static NavMenuActivity navMenuActivity;

    private FoodListHelper() {
    }

    public static FoodListHelper getInstance() {
        if (foodListHelper == null) {
            foodListHelper = new FoodListHelper();
        }
        return foodListHelper;
    }

    public void setToPriceQuantityMap(int position, PriceQuantity priceQuantity) {

        if (listPosition_QuantityMap == null) {
            listPosition_QuantityMap = new HashMap<>();
        }


        listPosition_QuantityMap.put(position, priceQuantity);

    }

    public HashMap<Integer, PriceQuantity> getListPosition_QuantityMap() {
        return listPosition_QuantityMap;
    }


    public void setItemIncrement(TextView orderItemNumberTxt) {

        int number = Utility.getIntValueFromString(orderItemNumberTxt.getText() + "");
        if (number >= 0 && number < 99) {
            number++;
            orderItemNumberTxt.setText(number + "");
        }

    }

    public void setItemDecrement(TextView orderItemNumberTxt) {

        int number = Utility.getIntValueFromString(orderItemNumberTxt.getText() + "");
        if (number > 0) {
            number--;
            orderItemNumberTxt.setText(number + "");
        } else if (number == 0) {
            orderItemNumberTxt.setText("0" + "");
        }

    }


    public boolean isValidationChecked() {

        if (getListPosition_QuantityMap() != null) {
            Iterator it = getListPosition_QuantityMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                PriceQuantity priceQuantity = (PriceQuantity) pair.getValue();
                if (priceQuantity != null && priceQuantity.getQuantityTxt() != null) {

                    int quantity = Utility.getIntValueFromString(priceQuantity.getQuantityTxt().getText().toString());

                    if (quantity > 0) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    public NavMenuActivity getNavMenuActivity() {
        return navMenuActivity;
    }

    public void setNavMenuActivity(NavMenuActivity navMenuActivity) {
        FoodListHelper.navMenuActivity = navMenuActivity;
    }

    public int getImageId(String imageName) {

        int resId = -1;

        try {
            imageName = imageName.substring(1, imageName.length());

            int tempNumber = imageName.indexOf('.');

            imageName = imageName.substring(0, tempNumber);

            resId = Utility.getDrawableFromStringName(imageName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resId;
        }

    }
}
