package com.shogonir.android_sample.Calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.RelativeLayout;

import com.shogonir.android_sample.R;

public class CalendarActivity extends AppCompatActivity
        implements CalendarView.OnDateChangeListener {

    private static final String TAG = "CalendarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: a");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Log.d(TAG, "onCreate: b");
        CalendarView calendarView = (CalendarView)findViewById(R.id.calendar_view);
        Log.d(TAG, "onCreate: " + (calendarView == null));
        calendarView.setOnDateChangeListener(this);
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int mday) {
        Log.d(TAG, String.format("onSelectedDayChange: %d/%d/%d", year, month, mday));
    }
}
