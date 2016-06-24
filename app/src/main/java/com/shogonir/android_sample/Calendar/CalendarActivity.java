package com.shogonir.android_sample.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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
        Log.d(TAG, "onCreate: " + calendarView.getChildAt(0).getClass().toString());
        //TricolorCalendarView calendarView = new TricolorCalendarView(this);
        Log.d(TAG, "onCreate: " + (calendarView == null));
        calendarView.setOnDateChangeListener(this);

        LinearLayout layout = (LinearLayout)calendarView.getChildAt(0);
        Log.d(TAG, "onCreate: linear child count " + layout.getChildCount());
        Log.d(TAG, "onCreate: child 0 class " + ((TextView)layout.getChildAt(0)).getText().toString());
        LinearLayout layout1 = (LinearLayout)layout.getChildAt(1);
        Log.d(TAG, "onCreate: child 1 class " + ((TextView)layout1.getChildAt(2)).getText());
        Log.d(TAG, "onCreate: child 2 class " + layout.getChildAt(2).getClass().toString());
        Log.d(TAG, "onCreate: child 3 class " + layout.getChildAt(3).getClass().toString());
        ListView listView = (ListView)layout.getChildAt(3);
        Log.d(TAG, "onCreate: list item count " + listView.getAdapter().getCount());

        //RelativeLayout layout = (RelativeLayout)findViewById(R.id.calendar_layout);
        //layout.addView(calendarView);
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int mday) {
        Log.d(TAG, String.format("onSelectedDayChange: %d/%d/%d", year, month, mday));
    }
}
