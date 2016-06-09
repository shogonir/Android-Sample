package com.shogonir.android_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shogonir.android_sample.DragSortList.DragSortListActivity;
import com.shogonir.android_sample.HttpConnector.HttpConnectorActivity;
import com.shogonir.android_sample.ImageItemView.ImageItemViewActivity;

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
        }
    }
}
