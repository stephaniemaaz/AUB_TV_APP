package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import timber.log.Timber;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.plant(new Timber.DebugTree());
        setContentView(R.layout.activity_main);
    }

}
