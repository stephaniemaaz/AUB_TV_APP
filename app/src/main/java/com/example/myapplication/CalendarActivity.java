package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarActivity extends Activity {

    private CalendarView mCalendar;
    private TextView mEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mCalendar = findViewById(R.id.calendar);
        mEvents = findViewById(R.id.calendar_events);

        mCalendar.setDate(System.currentTimeMillis());

        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int _month,
                                            int dayOfMonth) {
                int month = _month + 1;
                getDateEvent(year, month , dayOfMonth);
            }
        });
    }


    private void getDateEvent(int year, int month, int dayOfMonth) {
        if (year == 2020 && month == 3 && dayOfMonth == 23) {
            mEvents.setText("No Events for 23-3-2020. Stay Home");
        }
    }
}
