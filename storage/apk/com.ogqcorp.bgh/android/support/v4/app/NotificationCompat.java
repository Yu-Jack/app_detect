// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.os.Build$VERSION;

public class NotificationCompat
{
    public static final int FLAG_HIGH_PRIORITY = 128;
    private static final NotificationCompat$NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = new NotificationCompat$NotificationCompatImplJellybean();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = new NotificationCompat$NotificationCompatImplIceCreamSandwich();
            return;
        }
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = new NotificationCompat$NotificationCompatImplHoneycomb();
            return;
        }
        if (Build$VERSION.SDK_INT >= 9) {
            IMPL = new NotificationCompat$NotificationCompatImplGingerbread();
            return;
        }
        IMPL = new NotificationCompat$NotificationCompatImplBase();
    }
}
