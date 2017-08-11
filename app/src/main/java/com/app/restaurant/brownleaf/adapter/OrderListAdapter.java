package com.app.restaurant.brownleaf.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.model.Orders;

import java.util.List;

/**
 * Created by mobilecoe-imac6 on 10/01/17.
 */
public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {

    private List<Orders> ordersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTxt, quantityTxt, priceTxt;

        public MyViewHolder(View view) {
            super(view);

            itemTxt = (TextView) view.findViewById(R.id.itemTxt);
            quantityTxt = (TextView) view.findViewById(R.id.quantityTxt);
            priceTxt = (TextView) view.findViewById(R.id.priceTxt);

        }
    }


    public OrderListAdapter(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Orders orders = ordersList.get(position);

        holder.itemTxt.setText(String.valueOf(position + 1));
        holder.quantityTxt.setText(orders.getQuantity());
        holder.priceTxt.setText(String.valueOf(orders.getPrice()));


    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }


}
