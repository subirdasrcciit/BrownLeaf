package com.app.restaurant.brownleaf.database.datamodel;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

/**
 * Created by mobilecoe-imac6 on 18/01/17.
 */
public class OrderDetailsDao implements Serializable {

    // Primary key defined as an auto generated integer
    // If the database table column name differs than the Model class variable name, the way to map to use columnName
    @DatabaseField(generatedId = true, columnName = "order_id")
    public int oderId;

     // Define a String type field to hold order date
    @DatabaseField(columnName = "oder_date")
    public String orderDate = "16th-Jan-2017";

    // Define a String type field to hold table no
    @DatabaseField(columnName = "table_no")
    public String tableNo = "04";

    // Define a String type field to hold time of order
    @DatabaseField(columnName = "order_time")
    public String orderTime ="12PM-2PM";

//    // Foreign key defined to hold associations
//    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
//    public ItemDetailsDao itemDetails;


    @DatabaseField(columnName = "all_item_order")
    public String orders ="";


    // Default constructor is needed for the SQLite, so make sure you also have it
    public OrderDetailsDao() {

    }

    //For our own purpose, so it's easier to create a OrderDetailsDao object
    public OrderDetailsDao(final String orderDate, final String tableNo, final String orderTime,final String orders) {
        this.orderDate = orderDate;
        this.tableNo = tableNo;
        this.orderTime = orderTime;
        this.orders = orders;
    }

}
