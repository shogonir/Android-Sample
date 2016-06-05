package com.shogonir.android_sample.HttpConnector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shogonir.android_sample.R;

import org.w3c.dom.Text;

public class HttpConnectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connector);

        TextView textView = (TextView)findViewById(R.id.http_connector_text);
        HatebuHttpConnector connector = new HatebuHttpConnector(textView);
        connector.fetchRecentBookmarks();
    }
}
