// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.app.Notification;

public abstract class NotificationCompat$Style
{
    CharSequence mBigContentTitle;
    NotificationCompat$Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet;
    
    public NotificationCompat$Style() {
        this.mSummaryTextSet = false;
    }
    
    public Notification build() {
        final NotificationCompat$Builder mBuilder = this.mBuilder;
        Notification build = null;
        if (mBuilder != null) {
            build = this.mBuilder.build();
        }
        return build;
    }
    
    public void setBuilder(final NotificationCompat$Builder mBuilder) {
        if (this.mBuilder != mBuilder) {
            this.mBuilder = mBuilder;
            if (this.mBuilder != null) {
                this.mBuilder.setStyle(this);
            }
        }
    }
}
