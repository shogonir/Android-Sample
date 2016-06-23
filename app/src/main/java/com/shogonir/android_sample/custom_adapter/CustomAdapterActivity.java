package com.shogonir.android_sample.custom_adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shogonir.android_sample.R;

public class CustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        FragmentManager fm = getSupportFragmentManager();
        CustomAdapterPagerAdapter adapter = new CustomAdapterPagerAdapter(fm);
        ViewPager viewPager = (ViewPager)findViewById(R.id.custom_adapter_view_adapter);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.custom_adapter_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        for (int i=0; i<3; i++) {
            tabLayout.getTabAt(i).setText("Tab " + i);
        }
    }
}
