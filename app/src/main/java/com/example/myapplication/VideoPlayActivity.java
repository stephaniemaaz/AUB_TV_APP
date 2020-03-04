package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;
import android.content.Intent;
import android.os.Bundle;

public class VideoPlayActivity extends FragmentActivity {

    public static Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        video = (Video) intent.getSerializableExtra("video");

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new VideoPlayFragment())
                    .commit();
        }
    }
}
