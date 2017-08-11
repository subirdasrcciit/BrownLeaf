package com.app.restaurant.brownleaf.model;

/**
 * Created by mobilecoe-imac6 on 10/01/17.
 */
public class FoodItems {

    private String itemId, foodItemName, foodIngredient,foodPrice,imageName;

    public FoodItems() {
    }

    public FoodItems(String orderId, String foodItemName, String foodIngredient,String foodPrice,String imageName) {
        this.itemId = orderId;
        this.foodItemName = foodItemName;
        this.foodIngredient = foodIngredient;
        this.foodPrice = foodPrice;
        this.imageName = imageName;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public String getFoodIngredient() {
        return foodIngredient;
    }

    public void setFoodIngredient(String foodIngredient) {
        this.foodIngredient = foodIngredient;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
