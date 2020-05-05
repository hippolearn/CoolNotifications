package com.sulav.coolnotifications.utils;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.text.TextUtils;
import android.util.LruCache;

public class NotificationImageCache {

    private static NotificationImageCache imageCache;
    private LruCache<String, Bitmap> lruCache;

    private NotificationImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public static synchronized NotificationImageCache getInstance() {
        if (imageCache == null) {
            imageCache = new NotificationImageCache();
        }

        return imageCache;
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if ((!TextUtils.isEmpty(key)) && (bitmap != null)) {
            lruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        if (!TextUtils.isEmpty(key)) {
            return lruCache.get(key);
        }
        return null;
    }
}
