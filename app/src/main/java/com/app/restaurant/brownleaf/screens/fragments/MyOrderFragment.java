package com.app.restaurant.brownleaf.screens.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.restaurant.brownleaf.BrownLeafApp;
import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.adapter.OrderListAdapter;
import com.app.restaurant.brownleaf.database.DatabaseFactory;
import com.app.restaurant.brownleaf.helper.MyOdrerHelper;
import com.app.restaurant.brownleaf.model.Orders;
import com.app.restaurant.brownleaf.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class MyOrderFragment extends Fragment {

    private String tableNo = "04";
    private String date = "14-Jan-2017";
    private String time = "12PM - 2PM";

    private RecyclerView recyclerView;
    private OrderListAdapter orderListAdapter;
    private List<Orders> ordersList = new ArrayList<>();

    public TextView totalPriceTxt, tableNumberTxt, dateTxt, timeTxt;

    public static MyOrderFragment newInstance() {
        MyOrderFragment fragment = new MyOrderFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);

        init(view);

        return view;
    }

    private void init(View v) {

        totalPriceTxt = (TextView) v.findViewById(R.id.totalPriceTxt);
        tableNumberTxt = (TextView) v.findViewById(R.id.tableNumberTxt);
        tableNumberTxt.setText(tableNo);
        dateTxt = (TextView) v.findViewById(R.id.dateTxt);
        dateTxt.setText(date);
        timeTxt = (TextView) v.findViewById(R.id.timeTxt);
        timeTxt.setText(time);


        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        if (ordersList != null) {
            ordersList.clear();
        }

        ordersList = DatabaseFactory.getStoredInfoFromDB();

        orderListAdapter = new OrderListAdapter(ordersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(BrownLeafApp.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderListAdapter);

        totalPriceTxt.setText(Utility.getString(R.string.total_price, String.valueOf(MyOdrerHelper.getInstance().totalPriceCount(ordersList))));

    }


}
