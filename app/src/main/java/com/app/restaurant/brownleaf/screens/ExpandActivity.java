package com.app.restaurant.brownleaf.screens;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.adapter.ExpandableRestaurantListAdapter;
import com.app.restaurant.brownleaf.adapter.OnCartItemSelectedListener;
import com.app.restaurant.brownleaf.model.ItemDetails;
import com.app.restaurant.brownleaf.model.RestaurantInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mobilecoe-imac6 on 03/04/17.
 */
public class ExpandActivity extends Activity implements OnCartItemSelectedListener,ExpandableListView.OnGroupExpandListener {

    private TextView titleTxt;
    private ImageView headerBgImg;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<ItemDetails>> listDataChild;
    private ExpandableRestaurantListAdapter listAdapter;
    private List<RestaurantInfo> restaurantInfoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_restaurant_details);

        init();


    }

    private void init() {

        // preparing list data
        populateList();

        expListView = (ExpandableListView) findViewById(R.id.lvExp);


        listAdapter = new ExpandableRestaurantListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupExpandListener(this);


//        //expand child view
//        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
//            expListView.expandGroup(i);
//        }


    }


    private void populateList() {

        restaurantInfoList.clear();

        List<ItemDetails> items = new ArrayList();
        ItemDetails itemDetails = new ItemDetails("Cappuccino (Regular)", "Cappuccino (Regular)", 20);
        items.add(itemDetails);
        itemDetails = new ItemDetails("Assam Tea (Regular)", "Assam Tea (Regular)", 10);
        items.add(itemDetails);

        List<String> itemsTitles = new ArrayList();
        itemsTitles.add("Beverages");


        RestaurantInfo restaurantInfo_1 = new RestaurantInfo("Coffee Shop", "99/31 Dum Dum Kolkata", "9433431380", 75);
        restaurantInfo_1.setItemTypeTitles(itemsTitles);
        restaurantInfo_1.setItemList(items);

        restaurantInfoList.add(restaurantInfo_1);

        List<String> itemsTitlesSnacks = new ArrayList();
        itemsTitles.add("Snacks");


        RestaurantInfo restaurantInfo_2 = new RestaurantInfo("Coffee Shop", "99/31 Dum Dum Kolkata", "9433431380", 75);
        restaurantInfo_2.setItemTypeTitles(itemsTitlesSnacks);
        restaurantInfo_2.setItemList(items);

        restaurantInfoList.add(restaurantInfo_2);


        prepareListData();
    }

    /*
    * Preparing the list data
    */
    private void prepareListData() {

        //selectedPosition
        RestaurantInfo restaurantInfo = restaurantInfoList.get(0);


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap();


        for (int index = 0; index < restaurantInfo.getItemTypeTitles().size(); index++) {

            // Adding child data
            listDataHeader = restaurantInfo.getItemTypeTitles();

            // Adding child data
            List<ItemDetails> items_selected = restaurantInfo.getItemList();

            listDataChild.put(listDataHeader.get(index), items_selected); // Header, Child data

        }


    }

    @Override
    public void onCartItemSelected(ItemDetails itemDetails, int position) {

    }

    @Override
    public void onGroupExpand(int groupPosition) {
        int len = listAdapter.getGroupCount();

        for (int i = 0; i < len; i++) {
            if (i != groupPosition) {
                expListView.collapseGroup(i);
            }
        }
    }
}
