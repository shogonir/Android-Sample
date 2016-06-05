package com.shogonir.android_sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shogonir.android_sample.HttpConnector.HttpConnectorActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setOnClickListeners();
    }

    public void setOnClickListeners () {
        findViewById(R.id.http_connector).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.http_connector :
                startActivity(new Intent(this, HttpConnectorActivity.class));
                break;
        }
    }
}
