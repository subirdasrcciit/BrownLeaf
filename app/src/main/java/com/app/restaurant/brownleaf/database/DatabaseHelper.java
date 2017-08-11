package com.app.restaurant.brownleaf.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.app.restaurant.brownleaf.database.datamodel.OrderDetailsDao;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by mobilecoe-imac6 on 18/01/17.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME    = "orm_lite_order.db";
    private static final int    DATABASE_VERSION = 1;

    private Dao<OrderDetailsDao, Integer> orderDetailsDao = null;
//    private Dao<ItemDetailsDao, Integer> itemDetailsDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, OrderDetailsDao.class);
//            TableUtils.createTable(connectionSource, ItemDetailsDao.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, OrderDetailsDao.class, true);
//            TableUtils.dropTable(connectionSource, ItemDetailsDao.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* Order Details */

    public Dao<OrderDetailsDao, Integer> getOrderDetailsDao() throws SQLException {
        if (orderDetailsDao == null) {
            orderDetailsDao = getDao(OrderDetailsDao.class);
        }

        return orderDetailsDao;
    }


//     /* Item Details */
//
//    public Dao<ItemDetailsDao, Integer> getItemDetailsDao() throws SQLException {
//        if (itemDetailsDao == null) {
//            itemDetailsDao = getDao(ItemDetailsDao.class);
//        }
//
//        return itemDetailsDao;
//    }


    @Override
    public void close() {
        orderDetailsDao = null;
//        itemDetailsDao = null;

        super.close();
    }
}