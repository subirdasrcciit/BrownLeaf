package com.app.restaurant.brownleaf.database;

import com.app.restaurant.brownleaf.BrownLeafApp;
import com.app.restaurant.brownleaf.database.datamodel.OrderDetailsDao;
import com.app.restaurant.brownleaf.helper.MyOdrerHelper;
import com.app.restaurant.brownleaf.model.Orders;
import com.app.restaurant.brownleaf.util.Utility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobilecoe-imac6 on 18/01/17.
 */
public class DatabaseFactory {

    private static DatabaseHelper databaseHelper = null;

    // This is how, DatabaseHelper can be initialized for future use
    public static DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(BrownLeafApp.getContext(), DatabaseHelper.class);
        }
        return databaseHelper;
    }


    public static void releaseHelper() {

        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper =null;
        }
    }


    public static void saveInfoToDatabase() {

        try {

            List<Orders> ordersList = MyOdrerHelper.getInstance().getPrepareOrderData();

            if (ordersList != null && ordersList.size() > 0) {

                try {

                    OrderDetailsDao orderDetailsDao = new OrderDetailsDao();

                    orderDetailsDao.orders = Utility.getStringFromList(ordersList);


                    // This is how, a reference of DAO object can be done
                    final Dao<OrderDetailsDao, Integer> itemDao = DatabaseFactory.getHelper().getOrderDetailsDao();

                    //This is the way to insert data into a database table
                    itemDao.create(orderDetailsDao);


                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DatabaseFactory.releaseHelper();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Orders> getStoredInfoFromDB() {

        List<Orders> ordersList = new ArrayList<>();
        Dao<OrderDetailsDao, Integer> orderDetailsDao;
        List<OrderDetailsDao> detailsDaoList;

        try {

            orderDetailsDao = DatabaseFactory.getHelper().getOrderDetailsDao();

            detailsDaoList = orderDetailsDao.queryForAll();

            Gson gson = new Gson();

            ordersList = gson.fromJson(detailsDaoList.get(detailsDaoList.size()-1).orders, new TypeToken<ArrayList<Orders>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseFactory.releaseHelper();
        }


        return ordersList;
    }


}
