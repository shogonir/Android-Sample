package com.shogonir.android_sample.http_connector;

import android.widget.TextView;

/**
 * Created by shogo on 2016/06/05.
 */
public class HatebuHttpConnector extends HttpConnector {

    HatebuHttpConnector (OnHttpConnectListener listener) {
        super(listener);
    }

    public void fetchRecentBookmarks () {
        connectHttp("http://b.hatena.ne.jp/shogonir/rss?of=0");
    }
}
