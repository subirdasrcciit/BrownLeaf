package com.app.restaurant.brownleaf.parser;

import com.app.restaurant.brownleaf.model.FoodItems;
import com.app.restaurant.brownleaf.util.Constants;
import com.app.restaurant.brownleaf.util.Utility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobilecoe-imac6 on 19/01/17.
 */
public class MyParser {

    private static MyParser myParser;

    private MyParser() {
    }

    public static MyParser getInstance() {
        if (myParser == null) {
            myParser = new MyParser();
        }
        return myParser;
    }


    public List<FoodItems> executeParseJson(String response) {

        List<FoodItems> foodItemsList = new ArrayList<>();

        try {
            if (!Utility.isEmpty(response)) {

                JSONObject jsonRootObject = new JSONObject(response);

                if (jsonRootObject != null) {

                    //----------------------Breakfast---------------------------------
                    JSONArray jsonBreakFastArray = jsonRootObject.optJSONArray(Constants.BREAKFAST);


                    if (jsonBreakFastArray != null)
                        populateDataIntoList(jsonBreakFastArray, foodItemsList, 101, 5);

                    //----------------------Meals---------------------------------
                    JSONArray jsonMealArray = jsonRootObject.optJSONArray(Constants.MEALS);

                    if (jsonMealArray != null)
                        populateDataIntoList(jsonMealArray, foodItemsList, 201, 2);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodItemsList;
    }

    private void populateDataIntoList(JSONArray jsonArray, List<FoodItems> foodItemsList, int initial, int cont) {

        try {

            JSONObject jsonObject = jsonArray.getJSONObject(0);
            int tempCount = 0;

            while (true) {

                JSONObject tempJsonObject = jsonObject.optJSONObject(String.valueOf(initial));

                if (tempJsonObject != null) {
                    FoodItems foodItems = new FoodItems();

                    foodItems.setItemId(String.valueOf(initial));
                    foodItems.setFoodIngredient(tempJsonObject.optString(Constants.DESCRIPTION));
                    foodItems.setFoodItemName(tempJsonObject.optString(Constants.NAME));
                    foodItems.setFoodPrice(tempJsonObject.optString(Constants.PRICE));
                    foodItems.setImageName(tempJsonObject.optString(Constants.IMAGE));

                    foodItemsList.add(foodItems);
                }


                initial++;

                tempCount++;

                if (tempCount == cont) {
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
