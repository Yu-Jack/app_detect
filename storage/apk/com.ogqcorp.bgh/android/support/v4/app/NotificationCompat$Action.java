// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.app.PendingIntent;

public class NotificationCompat$Action
{
    public PendingIntent actionIntent;
    public int icon;
    public CharSequence title;
    
    public NotificationCompat$Action(final int icon, final CharSequence title, final PendingIntent actionIntent) {
        this.icon = icon;
        this.title = title;
        this.actionIntent = actionIntent;
    }
}
