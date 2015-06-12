// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplHoneycomb implements NotificationCompat$NotificationCompatImpl
{
    @Override
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder) {
        return NotificationCompatHoneycomb.add(notificationCompat$Builder.mContext, notificationCompat$Builder.mNotification, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mTickerView, notificationCompat$Builder.mNumber, notificationCompat$Builder.mContentIntent, notificationCompat$Builder.mFullScreenIntent, notificationCompat$Builder.mLargeIcon);
    }
}
