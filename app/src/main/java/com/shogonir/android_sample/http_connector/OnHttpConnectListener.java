package com.shogonir.android_sample.http_connector;

/**
 * Created by shogo on 2016/06/23.
 */
public interface OnHttpConnectListener {

    void onHttpConnectResponse (String responseBody);

    void onHttpConnectFailure ();
}
