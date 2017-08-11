package com.app.restaurant.brownleaf;

import android.app.Application;
import android.content.Context;

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

        MobileCenter.start(this, "393b0fa1-4d5a-4be3-84e9-90fb7528d561",
                Analytics.class, Crashes.class);
    }

    public static Context getContext(){
        return mContext;
    }
}
