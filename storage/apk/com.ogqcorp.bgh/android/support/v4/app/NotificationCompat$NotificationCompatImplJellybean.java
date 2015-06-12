// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import java.util.Iterator;
import android.app.Notification;

class NotificationCompat$NotificationCompatImplJellybean implements NotificationCompat$NotificationCompatImpl
{
    @Override
    public Notification build(final NotificationCompat$Builder notificationCompat$Builder) {
        final NotificationCompatJellybean notificationCompatJellybean = new NotificationCompatJellybean(notificationCompat$Builder.mContext, notificationCompat$Builder.mNotification, notificationCompat$Builder.mContentTitle, notificationCompat$Builder.mContentText, notificationCompat$Builder.mContentInfo, notificationCompat$Builder.mTickerView, notificationCompat$Builder.mNumber, notificationCompat$Builder.mContentIntent, notificationCompat$Builder.mFullScreenIntent, notificationCompat$Builder.mLargeIcon, notificationCompat$Builder.mProgressMax, notificationCompat$Builder.mProgress, notificationCompat$Builder.mProgressIndeterminate, notificationCompat$Builder.mUseChronometer, notificationCompat$Builder.mPriority, notificationCompat$Builder.mSubText);
        for (final NotificationCompat$Action notificationCompat$Action : notificationCompat$Builder.mActions) {
            notificationCompatJellybean.addAction(notificationCompat$Action.icon, notificationCompat$Action.title, notificationCompat$Action.actionIntent);
        }
        if (notificationCompat$Builder.mStyle != null) {
            if (notificationCompat$Builder.mStyle instanceof NotificationCompat$BigTextStyle) {
                final NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = (NotificationCompat$BigTextStyle)notificationCompat$Builder.mStyle;
                notificationCompatJellybean.addBigTextStyle(notificationCompat$BigTextStyle.mBigContentTitle, notificationCompat$BigTextStyle.mSummaryTextSet, notificationCompat$BigTextStyle.mSummaryText, notificationCompat$BigTextStyle.mBigText);
            }
            else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$InboxStyle) {
                final NotificationCompat$InboxStyle notificationCompat$InboxStyle = (NotificationCompat$InboxStyle)notificationCompat$Builder.mStyle;
                notificationCompatJellybean.addInboxStyle(notificationCompat$InboxStyle.mBigContentTitle, notificationCompat$InboxStyle.mSummaryTextSet, notificationCompat$InboxStyle.mSummaryText, notificationCompat$InboxStyle.mTexts);
            }
            else if (notificationCompat$Builder.mStyle instanceof NotificationCompat$BigPictureStyle) {
                final NotificationCompat$BigPictureStyle notificationCompat$BigPictureStyle = (NotificationCompat$BigPictureStyle)notificationCompat$Builder.mStyle;
                notificationCompatJellybean.addBigPictureStyle(notificationCompat$BigPictureStyle.mBigContentTitle, notificationCompat$BigPictureStyle.mSummaryTextSet, notificationCompat$BigPictureStyle.mSummaryText, notificationCompat$BigPictureStyle.mPicture, notificationCompat$BigPictureStyle.mBigLargeIcon, notificationCompat$BigPictureStyle.mBigLargeIconSet);
            }
        }
        return notificationCompatJellybean.build();
    }
}
