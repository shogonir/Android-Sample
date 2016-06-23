package com.shogonir.android_sample.http_connector;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shogo on 2016/06/05.
 */
public abstract class HttpConnector {

    private Handler mHandler = null;
    private OnHttpConnectListener mListener;

    public HttpConnector (OnHttpConnectListener listener) {
        mHandler = new Handler();
        mListener = listener;
    }

    public void connectHttp (String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListener.onHttpConnectFailure();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseBody = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mListener.onHttpConnectResponse(responseBody);
                    }
                });
            }
        });
    }
}
