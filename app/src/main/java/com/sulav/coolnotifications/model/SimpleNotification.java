package com.sulav.coolnotifications.model;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.NotificationTarget;
import com.sulav.coolnotifications.R;
import com.sulav.coolnotifications.utils.NotificationConstant;

import org.json.JSONObject;

public class SimpleNotification extends BaseNotification {
    private String launchUrl;
    private String imageUrl;

    public void setLaunchUrl(String launchUrl) {
        this.launchUrl = launchUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLaunchUrl() {
        return launchUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void fill(JSONObject jsonObject) {
        super.fill(jsonObject);

        if (jsonObject != null) {
            this.launchUrl = jsonObject.optString("launchUrl");
            this.imageUrl = jsonObject.optString("imageUrl");
        } else {
            this.launchUrl = "";
            this.imageUrl = "";
        }
    }

    public void post(Context context) {
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.basic_notification);

        remoteViews.setImageViewResource(R.id.remoteview_notification_icon, R.mipmap.ic_launcher);

        remoteViews.setTextViewText(R.id.remoteview_notification_headline, "Headline");
        remoteViews.setTextViewText(R.id.remoteview_notification_short_message, "Short Message");

// build notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, NotificationConstant.CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setContent(remoteViews)
                        .setPriority( NotificationCompat.PRIORITY_MIN);

        final Notification notification = mBuilder.build();

        NotificationTarget notificationTarget = new NotificationTarget(
                context,
                R.id.remoteview_notification_icon,
                remoteViews,
                notification,
                NotificationConstant.NOTIFICATION_ID);

        Glide.with(context.getApplicationContext())
                .asBitmap()
                .load(imageUrl)
                .into(notificationTarget);

// set big content view for newer androids
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = remoteViews;
        }

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NotificationConstant.NOTIFICATION_ID, notification);
    }
}
