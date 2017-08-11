package com.app.restaurant.brownleaf.screens;

import android.os.Bundle;

import com.app.restaurant.brownleaf.BaseActivity;
import com.app.restaurant.brownleaf.R;

public class MyOrderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        setCustomActionBar();
    }

}
