package com.shogonir.android_sample.horizontal_scroll_and_tab;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shogonir.android_sample.R;

public class HorizontalScrollAndTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll_and_tab);

        insertViewsIntoHorizontalScrollView();

        FragmentManager fm = getSupportFragmentManager();
        HorizontalScrollAndTabPagerAdapter adapter = new HorizontalScrollAndTabPagerAdapter(fm);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tab_view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_tab);
        tabLayout.setupWithViewPager(viewPager);
        for (int i=0; i<3; i++) {
            tabLayout.getTabAt(i).setText("Tab " + (i+1));
        }
    }

    public void insertViewsIntoHorizontalScrollView() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.horizontal_scroll_layout);
        for (int i = 0; i < 10; i++) {
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
