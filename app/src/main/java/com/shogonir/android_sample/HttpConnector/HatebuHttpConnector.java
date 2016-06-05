package com.shogonir.android_sample.HttpConnector;

import android.os.Handler;
import android.widget.TextView;

/**
 * Created by shogo on 2016/06/05.
 */
public class HatebuHttpConnector extends HttpConnector {

    private TextView mTextView;

    public HatebuHttpConnector (TextView textView) {
        mTextView = textView;
    }

    public void fetchRecentBookmarks () {
        connectHttp("http://b.hatena.ne.jp/shogonir/rss?of=0");
    }

    @Override
    public void onResponseReceived(String responseBody) {
        mTextView.setText(responseBody);
    }
}
