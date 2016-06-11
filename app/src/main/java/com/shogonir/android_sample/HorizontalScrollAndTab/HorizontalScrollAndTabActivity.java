package com.shogonir.android_sample.HorizontalScrollAndTab;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shogonir.android_sample.R;

public class HorizontalScrollAndTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll_and_tab);

        insertViewsIntoHorizontalScrollView();
    }

    public void insertViewsIntoHorizontalScrollView () {
        LinearLayout layout = (LinearLayout)findViewById(R.id.horizontal_scroll_layout);
        for (int i=0; i<10; i++) {
            TextView textView = new TextView(this);
            textView.setText("Item " + i);
            int padding = 60;
            textView.setPadding(padding, padding, padding, padding);
            textView.setTextSize(30);
            if (i % 2 == 0) {
                textView.setBackgroundColor(Color.GRAY);
            }
            layout.addView(textView);
        }
    }
}
