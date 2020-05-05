package com.sulav.coolnotifications.model.custom;

import android.util.Log;

import com.sulav.coolnotifications.model.SimpleNotification;

import org.json.JSONObject;

public class BasicNotification extends SimpleNotification {
    private final String TAG = "BasicNotification";
    private String smallIconUrl;
    private String appName;
    private String largeIcon;

    public void setSmallIconUrl(String smallIconUrl) {
        this.smallIconUrl = smallIconUrl;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    public String getSmallIconUrl() {
        return smallIconUrl;
    }

    public String getAppName() {
        return appName;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public void fill(JSONObject jsonObject) {

        Log.d(TAG, "fill");
        super.fill(jsonObject);

        if (jsonObject != null) {
            this.smallIconUrl = jsonObject.optString("launchUrl");
            this.appName = jsonObject.optString("imageUrl");
            this.largeIcon = jsonObject.optString("largeIcon");
        } else {
            this.smallIconUrl = "";
            this.appName = "";
            this.largeIcon = "";
        }
    }
}
