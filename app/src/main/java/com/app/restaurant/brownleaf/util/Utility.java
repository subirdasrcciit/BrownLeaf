package com.app.restaurant.brownleaf.util;

import android.content.Context;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.app.restaurant.brownleaf.BrownLeafApp;
import com.app.restaurant.brownleaf.R;
import com.app.restaurant.brownleaf.customviews.CircleImageView;
import com.app.restaurant.brownleaf.customviews.MyTextView;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class Utility {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static void addTextUnderline(MyTextView txtView) {
        String data = String.valueOf(txtView.getText());
        txtView.setPaintFlags(txtView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        txtView.setText(data);
    }

    public static void addTextUnderline(MyTextView[] textViewArray) {
        for (MyTextView myTextView : textViewArray) {
            MyTextView txtView = myTextView;
            String data = String.valueOf(txtView.getText());
            txtView.setPaintFlags(txtView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            txtView.setText(data);
        }
    }

    public static String getString(int stringId) {
        return BrownLeafApp.getContext().getString(stringId);
    }

    public static String getString(int stringId, String... strings) {
        return BrownLeafApp.getContext().getString(stringId, strings);
    }

    public static void showToast(Context context, String txt) {
        Toast.makeText(context, txt, Toast.LENGTH_LONG).show();
    }

    public static int getIntValueFromString(String valueStr) {

        int value = 0;
        if (!Utility.isEmpty(valueStr)) {

            value = Integer.parseInt(valueStr.trim());

        }
        return value;
    }


    public static String getStringFromList(List lst) {

        String value = "";

        if (lst != null && lst.size() > 0) {

            Gson gson = new Gson();
            value = gson.toJson(lst);

        }
        return value;
    }

    // convert InputStream to String
    public static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    public static int getDrawableFromStringName(String name) {

        int id = -1;
        try {
            id = BrownLeafApp.getContext().getResources().getIdentifier(name, "drawable", BrownLeafApp.getContext().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }

    public static void setCircularImageBorderColor(CircleImageView circleImageView, int borderWidth, int color) {

        try {

            switch (color) {
                case Constants.ORANGE_COLOR:
                    circleImageView.setBorderColor(BrownLeafApp.getContext().getResources().getColor(R.color.orange));
                    break;
                case Constants.ASH_COLOR:
                    circleImageView.setBorderColor(BrownLeafApp.getContext().getResources().getColor(R.color.ash));
                    break;
            }

            circleImageView.setBorderWidth(borderWidth);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
