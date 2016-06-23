package com.shogonir.android_sample.http_connector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.shogonir.android_sample.R;

public class HttpConnectorActivity extends AppCompatActivity
        implements OnHttpConnectListener {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connector);

        mTextView = (TextView)findViewById(R.id.http_connector_text);
        HatebuHttpConnector connector = new HatebuHttpConnector(this);
        connector.fetchRecentBookmarks();
    }

    @Override
    public void onHttpConnectResponse(String responseBody) {
        mTextView.setText(responseBody);
    }

    @Override
    public void onHttpConnectFailure() {
        Toast.makeText(
                this,
                getString(R.string.http_connector_connection_failed),
                Toast.LENGTH_SHORT
        ).show();
    }
}
