package com.example.myapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

// todo: Calendar view with important university events and the option to remind you of the ones you highlight.

public class CalendarActivity extends Activity {

    CalendarView mCalendarView;
    TextView mTextView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_main);
        mCalendarView = findViewById(R.id.calender_main_calendar);
        mTextView = findViewById(R.id.calender_main_date);

        mCalendarView.setOnCapturedPointerListener(new View.OnCapturedPointerListener() {
            @Override
            public boolean onCapturedPointer(View view, MotionEvent event) {
                return false;
            }
        });
    }
}
