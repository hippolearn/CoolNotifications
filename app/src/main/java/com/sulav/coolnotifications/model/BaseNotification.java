package com.sulav.coolnotifications.model;

import org.json.JSONObject;

public class BaseNotification {
    private String title;
    private String message;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void fill(JSONObject jsonObject) {
        if (jsonObject != null) {
            this.title = jsonObject.optString("title");
            this.message = jsonObject.optString("message");
        } else {
            this.title = "";
            this.message = "";
        }
    }
}
