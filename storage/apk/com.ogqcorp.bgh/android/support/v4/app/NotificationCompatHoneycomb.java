// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.app.Notification$Builder;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.app.Notification;
import android.content.Context;

class NotificationCompatHoneycomb
{
    static Notification add(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final CharSequence contentInfo, final RemoteViews remoteViews, final int number, final PendingIntent contentIntent, final PendingIntent pendingIntent, final Bitmap largeIcon) {
        boolean b = true;
        final Notification$Builder setDeleteIntent = new Notification$Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((0x2 & notification.flags) != 0x0 && b).setOnlyAlertOnce((0x8 & notification.flags) != 0x0 && b).setAutoCancel((0x10 & notification.flags) != 0x0 && b).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent);
        if ((0x80 & notification.flags) == 0x0) {
            b = false;
        }
        return setDeleteIntent.setFullScreenIntent(pendingIntent, b).setLargeIcon(largeIcon).setNumber(number).getNotification();
    }
}
