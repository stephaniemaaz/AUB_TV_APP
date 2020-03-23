package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import timber.log.Timber;

/*
 * Main Activity class that loads {@link MainFragment}.
 */

// LifeCycles

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.plant(new Timber.DebugTree());
        setContentView(R.layout.activity_main);
    }

}
