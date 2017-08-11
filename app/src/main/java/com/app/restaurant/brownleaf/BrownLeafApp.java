package com.app.restaurant.brownleaf;

import android.app.Application;
import android.content.Context;

import com.app.restaurant.brownleaf.util.Constants;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

/**
 * Created by mobilecoe-imac6 on 12/01/17.
 */
public class BrownLeafApp extends Application {


    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        MobileCenter.start(this, Constants.MOBILE_CENTER_KEY,
                Analytics.class, Crashes.class);
    }

    public static Context getContext(){
        return mContext;
    }
}
