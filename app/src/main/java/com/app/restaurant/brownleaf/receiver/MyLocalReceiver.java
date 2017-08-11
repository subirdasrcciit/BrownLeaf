package com.app.restaurant.brownleaf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.app.restaurant.brownleaf.helper.FoodListHelper;
import com.app.restaurant.brownleaf.parser.MyParser;
import com.app.restaurant.brownleaf.util.Constants;

/**
 * Created by mobilecoe-imac6 on 19/01/17.
 */
public class MyLocalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (action.equals(Constants.RECEIVER_ACTION)) {

            String response = intent.getExtras().getString(Constants.RESPONSE);

            FoodListHelper.getInstance().getNavMenuActivity().onSuccessCallBackFromReceiver(MyParser.getInstance().executeParseJson(response));
        }

    }
}
