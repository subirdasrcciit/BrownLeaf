package com.app.restaurant.brownleaf.screens.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.restaurant.brownleaf.BrownLeafApp;
import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.adapter.FoodListAdapter;
import com.app.restaurant.brownleaf.connection.IHttpResponse;
import com.app.restaurant.brownleaf.database.DatabaseFactory;
import com.app.restaurant.brownleaf.helper.FoodListHelper;
import com.app.restaurant.brownleaf.model.FoodItems;
import com.app.restaurant.brownleaf.screens.MyOrderActivity;
import com.app.restaurant.brownleaf.util.Utility;

import java.util.List;

public class FoodListFragment extends Fragment implements IHttpResponse {


    private Button confirmOrderBtn;
    private RecyclerView recyclerView;
    private FoodListAdapter foodListAdapter;

    public static Fragment newInstance() {
        FoodListFragment fragment = new FoodListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        confirmOrderBtn = (Button) view.findViewById(R.id.confirmOrderBtn);
        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmOrder();
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

    }
    private void confirmOrder() {

        if (FoodListHelper.getInstance().isValidationChecked()) {

            DatabaseFactory.saveInfoToDatabase();

            Intent intent = new Intent(getActivity(), MyOrderActivity.class);
            startActivity(intent);
        } else {
            Utility.showToast(getActivity(), Utility.getString(R.string.please_order_food_with_proper_quantity));
        }


    }

    @Override
    public void onSuccess(List<FoodItems> foodItemsList) {

        if(foodItemsList!=null){
            foodListAdapter = new FoodListAdapter(foodItemsList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BrownLeafApp.getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(foodListAdapter);
            foodListAdapter.notifyDataSetChanged();
        }

    }


}
