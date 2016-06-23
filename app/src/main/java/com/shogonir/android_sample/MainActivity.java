package com.shogonir.android_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shogonir.android_sample.calendar.CalendarActivity;
import com.shogonir.android_sample.custom_adapter.CustomAdapterActivity;
import com.shogonir.android_sample.drag_sort_list.DragSortListActivity;
import com.shogonir.android_sample.horizontal_scroll_and_tab.HorizontalScrollAndTabActivity;
import com.shogonir.android_sample.http_connector.HttpConnectorActivity;
import com.shogonir.android_sample.image_item_view.ImageItemViewActivity;
import com.shogonir.android_sample.realm.RealmActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListeners();
    }

    public void setOnClickListeners () {
        findViewById(R.id.http_connector).setOnClickListener(this);
        findViewById(R.id.image_item_view).setOnClickListener(this);
        findViewById(R.id.drag_sort_list).setOnClickListener(this);
        findViewById(R.id.horizontal_scroll_and_tab).setOnClickListener(this);
        findViewById(R.id.calendar).setOnClickListener(this);
        findViewById(R.id.custom_adapter).setOnClickListener(this);
        findViewById(R.id.realm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.http_connector :
                startActivity(new Intent(this, HttpConnectorActivity.class));
                break;
            case R.id.image_item_view :
                startActivity(new Intent(this, ImageItemViewActivity.class));
                break;
            case R.id.drag_sort_list :
                startActivity(new Intent(this, DragSortListActivity.class));
                break;
            case R.id.horizontal_scroll_and_tab :
                startActivity(new Intent(this, HorizontalScrollAndTabActivity.class));
                break;
            case R.id.calendar :
                startActivity(new Intent(this, CalendarActivity.class));
                break;
            case R.id.custom_adapter :
                startActivity(new Intent(this, CustomAdapterActivity.class));
                break;
            case R.id.realm :
                startActivity(new Intent(this, RealmActivity.class));
                break;
        }
    }
}
