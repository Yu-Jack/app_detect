// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

public class NotificationCompat$BigTextStyle extends NotificationCompat$Style
{
    CharSequence mBigText;
    
    public NotificationCompat$BigTextStyle() {
    }
    
    public NotificationCompat$BigTextStyle(final NotificationCompat$Builder builder) {
        this.setBuilder(builder);
    }
    
    public NotificationCompat$BigTextStyle bigText(final CharSequence mBigText) {
        this.mBigText = mBigText;
        return this;
    }
    
    public NotificationCompat$BigTextStyle setBigContentTitle(final CharSequence mBigContentTitle) {
        this.mBigContentTitle = mBigContentTitle;
        return this;
    }
    
    public NotificationCompat$BigTextStyle setSummaryText(final CharSequence mSummaryText) {
        this.mSummaryText = mSummaryText;
        this.mSummaryTextSet = true;
        return this;
    }
}
