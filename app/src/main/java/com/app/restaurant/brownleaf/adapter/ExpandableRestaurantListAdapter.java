package com.app.restaurant.brownleaf.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.customviews.CircleImageView;
import com.app.restaurant.brownleaf.model.ItemDetails;
import com.app.restaurant.brownleaf.util.Constants;
import com.app.restaurant.brownleaf.util.Utility;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mobilecoe-imac6 on 03/04/17.
 */
public class ExpandableRestaurantListAdapter extends BaseExpandableListAdapter {

    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<ItemDetails>> _listDataChild;
    private OnCartItemSelectedListener cartItemSelectedListener;
    private Activity activity;

    public ExpandableRestaurantListAdapter(Activity activity, List<String> listDataHeader,
                                           HashMap<String, List<ItemDetails>> listChildData) {
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.cartItemSelectedListener = (OnCartItemSelectedListener) activity;
        this.activity = activity;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final ItemDetails itemDetails = (ItemDetails) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.restaurant_details_list_row_item, null);
        }

        TextView titleTxt = (TextView) convertView
                .findViewById(R.id.titleTxt);
        titleTxt.setText(itemDetails.getTitle());

        TextView descriptionTxt = (TextView) convertView
                .findViewById(R.id.descriptionTxt);
        descriptionTxt.setText(itemDetails.getDesc());

        TextView priceTxt = (TextView) convertView
                .findViewById(R.id.priceTxt);
        priceTxt.setText(Utility.getString(R.string.display_price, String.valueOf(itemDetails.getPrice())));


        CircleImageView BannerImg = (CircleImageView) convertView
                .findViewById(R.id.BannerImg);
        Utility.setCircularImageBorderColor(BannerImg, 5, Constants.ORANGE_COLOR);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartItemSelectedListener.onCartItemSelected(itemDetails, childPosition);
            }
        });


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.restaurant_details_grp_list_row_item, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.grpHeaderTxt);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        ImageView expandedImg = (ImageView) convertView
                .findViewById(R.id.expandedImg);


        if (isExpanded) {
            expandedImg.setImageResource(R.drawable.minus);
        } else {
            expandedImg.setImageResource(R.drawable.add);
        }


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}