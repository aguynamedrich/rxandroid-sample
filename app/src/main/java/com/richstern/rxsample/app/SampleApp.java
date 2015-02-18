package com.richstern.rxsample.app;

import android.app.Application;

/**
 * Created by rich on 2/16/15.
 */
public class SampleApp extends Application {

    private static RestClient client = null;

    @Override
    public void onCreate() {
        super.onCreate();
        client = new RestClient();
    }

    public static RestClient getClient() { return client; }
}
