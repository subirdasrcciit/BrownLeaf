package com.app.restaurant.brownleaf.connection;

import com.app.restaurant.brownleaf.model.FoodItems;

import java.util.List;

/**
 * Created by mobilecoe-imac6 on 19/01/17.
 */
public interface IHttpResponse {

   public void onSuccess(List<FoodItems> foodItemsList);
}
