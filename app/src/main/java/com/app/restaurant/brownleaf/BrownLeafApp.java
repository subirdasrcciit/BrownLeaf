package com.app.restaurant.brownleaf;

import android.app.Application;
import android.content.Context;

/**
 * Created by mobilecoe-imac6 on 12/01/17.
 */
public class BrownLeafApp extends Application {


    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
