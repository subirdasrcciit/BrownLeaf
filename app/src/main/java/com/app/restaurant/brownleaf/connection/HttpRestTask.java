package com.app.restaurant.brownleaf.connection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;

import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.helper.FoodListHelper;
import com.app.restaurant.brownleaf.receiver.MyLocalReceiver;
import com.app.restaurant.brownleaf.screens.NavMenuActivity;
import com.app.restaurant.brownleaf.util.Constants;
import com.app.restaurant.brownleaf.util.Utility;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.concurrent.TimeUnit;

/**
 * Created by mobilecoe-imac6 on 18/01/17.
 */
public class HttpRestTask extends AsyncTask<String, Void, String> {

    private final Activity activity;
    private final String loadingMsg;
    private OkHttpClient client = new OkHttpClient();
    private ProgressDialog pDialog;
    private Response apiResponse = null;
    MyLocalReceiver myLocalReceiver;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public HttpRestTask(Activity activity, String loadingMsg) {
        this.activity = activity;
        this.loadingMsg = loadingMsg;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity, R.style.MyProgressDialogTheme);
        if (!Utility.isEmpty(loadingMsg)) {
            pDialog.setMessage(loadingMsg);
        }
        pDialog.setCancelable(true);
        pDialog.setIndeterminateDrawable(activity.getResources().getDrawable(R.drawable.custom_progress_background));
        pDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Large_Inverse);
        pDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                if (client != null) {
                    client.cancel(true);
                }
            }
        });
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        client.setConnectTimeout(15, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(15, TimeUnit.SECONDS);    // socket timeout

        try {

            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();
            apiResponse = client.newCall(request).execute();
            return apiResponse.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        try {
            if (pDialog != null)
                pDialog.dismiss();

            callBroadcastReceiver(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void callBroadcastReceiver(String response) {

        FoodListHelper.getInstance().setNavMenuActivity((NavMenuActivity) activity);
        Intent intent = new Intent(Constants.RECEIVER_ACTION);
        intent.putExtra(Constants.RESPONSE, response);
        activity.sendBroadcast(intent);
    }

}
