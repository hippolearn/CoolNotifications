package com.sulav.coolnotifications.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sulav.coolnotifications.NotificationService;

public class JsonNotificationReceiver extends BroadcastReceiver {
    private String TAG = "jsonNotificationReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive");
        String jsonTest = "{\n" +
                "    \"title\":\"Title here\",\n" +
                "    \"message\":\"The best way to predict the future is to create it\",\n" +
                "    \"imageUrl\":\"New York\"\n" +
                "    \"launchUrl\":\"https://homepages.cae.wisc.edu/~ece533/images/cat.png\"\n" +
                "}";

        Intent svcIntent = new Intent(context, NotificationService.class);
        svcIntent.putExtra(NotificationService.JSON_KEY, jsonTest);
        context.getApplicationContext().startService(svcIntent);
    }
}
