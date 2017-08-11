package com.app.restaurant.brownleaf.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.helper.FoodListHelper;
import com.app.restaurant.brownleaf.model.FoodItems;
import com.app.restaurant.brownleaf.model.PriceQuantity;
import com.app.restaurant.brownleaf.util.Utility;

import java.util.List;

/**
 * Created by mobilecoe-imac6 on 10/01/17.
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> {

    private List<FoodItems> foodItemsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView foodItemNameTxt, foodIngredientTxt, foodPriceTxt, orderItemNumberTxt;
        public ImageView thumbnailImg, upImg, downImg;

        public MyViewHolder(View view) {
            super(view);

            foodItemNameTxt = (TextView) view.findViewById(R.id.foodItemNameTxt);
            foodIngredientTxt = (TextView) view.findViewById(R.id.foodIngredientTxt);
            foodPriceTxt = (TextView) view.findViewById(R.id.foodPriceTxt);
            orderItemNumberTxt = (TextView) view.findViewById(R.id.orderItemNumberTxt);

            thumbnailImg = (ImageView) view.findViewById(R.id.thumbImg);
            upImg = (ImageView) view.findViewById(R.id.upImg);
            downImg = (ImageView) view.findViewById(R.id.downImg);
        }
    }


    public FoodListAdapter(List<FoodItems> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        FoodItems foodItems = foodItemsList.get(position);

        try {

            holder.foodItemNameTxt.setText(foodItems.getFoodItemName());
            holder.foodIngredientTxt.setText(foodItems.getFoodIngredient());
            holder.foodPriceTxt.setText(Utility.getString(R.string.food_price, foodItems.getFoodPrice()));
            holder.thumbnailImg.setImageResource(FoodListHelper.getInstance().getImageId(foodItems.getImageName()));


            holder.upImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FoodListHelper.getInstance().setItemIncrement(holder.orderItemNumberTxt);
                }
            });
            holder.downImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FoodListHelper.getInstance().setItemDecrement(holder.orderItemNumberTxt);
                }
            });


            PriceQuantity priceQuantity = new PriceQuantity(foodItems.getFoodPrice(), holder.orderItemNumberTxt, foodItems.getFoodItemName());

            FoodListHelper.getInstance().setToPriceQuantityMap(position, priceQuantity);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return foodItemsList.size();
    }

}
