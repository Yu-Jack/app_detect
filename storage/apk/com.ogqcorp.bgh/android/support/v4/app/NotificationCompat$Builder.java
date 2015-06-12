// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.os.Build$VERSION;
import android.net.Uri;
import android.widget.RemoteViews;
import android.app.Notification;
import android.graphics.Bitmap;
import android.content.Context;
import android.app.PendingIntent;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
    ArrayList<NotificationCompat$Action> mActions;
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    Context mContext;
    PendingIntent mFullScreenIntent;
    Bitmap mLargeIcon;
    Notification mNotification;
    int mNumber;
    int mPriority;
    int mProgress;
    boolean mProgressIndeterminate;
    int mProgressMax;
    NotificationCompat$Style mStyle;
    CharSequence mSubText;
    RemoteViews mTickerView;
    boolean mUseChronometer;
    
    public NotificationCompat$Builder(final Context mContext) {
        this.mActions = new ArrayList<NotificationCompat$Action>();
        this.mNotification = new Notification();
        this.mContext = mContext;
        this.mNotification.when = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
    }
    
    private void setFlag(final int n, final boolean b) {
        if (b) {
            final Notification mNotification = this.mNotification;
            mNotification.flags |= n;
            return;
        }
        final Notification mNotification2 = this.mNotification;
        mNotification2.flags &= ~n;
    }
    
    public NotificationCompat$Builder addAction(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
        this.mActions.add(new NotificationCompat$Action(n, charSequence, pendingIntent));
        return this;
    }
    
    public Notification build() {
        return NotificationCompat.IMPL.build(this);
    }
    
    @Deprecated
    public Notification getNotification() {
        return NotificationCompat.IMPL.build(this);
    }
    
    public NotificationCompat$Builder setAutoCancel(final boolean b) {
        this.setFlag(16, b);
        return this;
    }
    
    public NotificationCompat$Builder setContent(final RemoteViews contentView) {
        this.mNotification.contentView = contentView;
        return this;
    }
    
    public NotificationCompat$Builder setContentInfo(final CharSequence mContentInfo) {
        this.mContentInfo = mContentInfo;
        return this;
    }
    
    public NotificationCompat$Builder setContentIntent(final PendingIntent mContentIntent) {
        this.mContentIntent = mContentIntent;
        return this;
    }
    
    public NotificationCompat$Builder setContentText(final CharSequence mContentText) {
        this.mContentText = mContentText;
        return this;
    }
    
    public NotificationCompat$Builder setContentTitle(final CharSequence mContentTitle) {
        this.mContentTitle = mContentTitle;
        return this;
    }
    
    public NotificationCompat$Builder setDefaults(final int defaults) {
        this.mNotification.defaults = defaults;
        if ((defaults & 0x4) != 0x0) {
            final Notification mNotification = this.mNotification;
            mNotification.flags |= 0x1;
        }
        return this;
    }
    
    public NotificationCompat$Builder setDeleteIntent(final PendingIntent deleteIntent) {
        this.mNotification.deleteIntent = deleteIntent;
        return this;
    }
    
    public NotificationCompat$Builder setFullScreenIntent(final PendingIntent mFullScreenIntent, final boolean b) {
        this.mFullScreenIntent = mFullScreenIntent;
        this.setFlag(128, b);
        return this;
    }
    
    public NotificationCompat$Builder setLargeIcon(final Bitmap mLargeIcon) {
        this.mLargeIcon = mLargeIcon;
        return this;
    }
    
    public NotificationCompat$Builder setLights(final int ledARGB, final int ledOnMS, final int ledOffMS) {
        int n = 1;
        this.mNotification.ledARGB = ledARGB;
        this.mNotification.ledOnMS = ledOnMS;
        this.mNotification.ledOffMS = ledOffMS;
        int n2;
        if (this.mNotification.ledOnMS != 0 && this.mNotification.ledOffMS != 0) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        final Notification mNotification = this.mNotification;
        final int n3 = 0xFFFFFFFE & this.mNotification.flags;
        if (n2 == 0) {
            n = 0;
        }
        mNotification.flags = (n3 | n);
        return this;
    }
    
    public NotificationCompat$Builder setNumber(final int mNumber) {
        this.mNumber = mNumber;
        return this;
    }
    
    public NotificationCompat$Builder setOngoing(final boolean b) {
        this.setFlag(2, b);
        return this;
    }
    
    public NotificationCompat$Builder setOnlyAlertOnce(final boolean b) {
        this.setFlag(8, b);
        return this;
    }
    
    public NotificationCompat$Builder setPriority(final int mPriority) {
        this.mPriority = mPriority;
        return this;
    }
    
    public NotificationCompat$Builder setProgress(final int mProgressMax, final int mProgress, final boolean mProgressIndeterminate) {
        this.mProgressMax = mProgressMax;
        this.mProgress = mProgress;
        this.mProgressIndeterminate = mProgressIndeterminate;
        return this;
    }
    
    public NotificationCompat$Builder setSmallIcon(final int icon) {
        this.mNotification.icon = icon;
        return this;
    }
    
    public NotificationCompat$Builder setSmallIcon(final int icon, final int iconLevel) {
        this.mNotification.icon = icon;
        this.mNotification.iconLevel = iconLevel;
        return this;
    }
    
    public NotificationCompat$Builder setSound(final Uri sound) {
        this.mNotification.sound = sound;
        this.mNotification.audioStreamType = -1;
        return this;
    }
    
    public NotificationCompat$Builder setSound(final Uri sound, final int audioStreamType) {
        this.mNotification.sound = sound;
        this.mNotification.audioStreamType = audioStreamType;
        return this;
    }
    
    public NotificationCompat$Builder setStyle(final NotificationCompat$Style mStyle) {
        if (this.mStyle != mStyle) {
            this.mStyle = mStyle;
            if (this.mStyle != null) {
                this.mStyle.setBuilder(this);
            }
        }
        return this;
    }
    
    public NotificationCompat$Builder setSubText(final CharSequence mSubText) {
        this.mSubText = mSubText;
        return this;
    }
    
    public NotificationCompat$Builder setTicker(final CharSequence tickerText) {
        this.mNotification.tickerText = tickerText;
        return this;
    }
    
    public NotificationCompat$Builder setTicker(final CharSequence tickerText, final RemoteViews mTickerView) {
        this.mNotification.tickerText = tickerText;
        this.mTickerView = mTickerView;
        return this;
    }
    
    public NotificationCompat$Builder setUsesChronometer(final boolean mUseChronometer) {
        this.mUseChronometer = mUseChronometer;
        return this;
    }
    
    public NotificationCompat$Builder setVibrate(final long[] vibrate) {
        this.mNotification.vibrate = vibrate;
        return this;
    }
    
    public NotificationCompat$Builder setWhen(final long when) {
        this.mNotification.when = when;
        return this;
    }
}
