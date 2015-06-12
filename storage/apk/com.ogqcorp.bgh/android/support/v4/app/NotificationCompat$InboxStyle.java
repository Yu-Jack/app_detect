// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import java.util.ArrayList;

public class NotificationCompat$InboxStyle extends NotificationCompat$Style
{
    ArrayList<CharSequence> mTexts;
    
    public NotificationCompat$InboxStyle() {
        this.mTexts = new ArrayList<CharSequence>();
    }
    
    public NotificationCompat$InboxStyle(final NotificationCompat$Builder builder) {
        this.mTexts = new ArrayList<CharSequence>();
        this.setBuilder(builder);
    }
    
    public NotificationCompat$InboxStyle addLine(final CharSequence e) {
        this.mTexts.add(e);
        return this;
    }
    
    public NotificationCompat$InboxStyle setBigContentTitle(final CharSequence mBigContentTitle) {
        this.mBigContentTitle = mBigContentTitle;
        return this;
    }
    
    public NotificationCompat$InboxStyle setSummaryText(final CharSequence mSummaryText) {
        this.mSummaryText = mSummaryText;
        this.mSummaryTextSet = true;
        return this;
    }
}
