package com.sulav.coolnotifications;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import com.sulav.coolnotifications.model.SimpleNotification;
import com.sulav.coolnotifications.model.custom.BasicNotification;

import org.json.JSONException;
import org.json.JSONObject;

public class NotificationService extends IntentService {
    private String TAG = "jsonNotificationReceiver";
    public static String JSON_KEY = "JSON_KEY";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public NotificationService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent");
        if (intent != null) {
            Log.i(TAG, "intent not null");
            String jsonString = intent.getStringExtra(JSON_KEY);
            if (jsonString != null) {
                Log.i(TAG, "json not null");
                BasicNotification basicNotification = new BasicNotification();
                try {
                    basicNotification.fill(new JSONObject(jsonString));
                    basicNotification.post(this.getApplicationContext());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
