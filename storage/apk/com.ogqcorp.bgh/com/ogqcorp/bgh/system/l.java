// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.util.Log;

public final class l
{
    public static int a(final String format, final Object... args) {
        return Log.i("BGH", String.format(format, args));
    }
    
    public static int a(final Throwable t) {
        return Log.e("BGH", "FATAL ERROR", t);
    }
    
    public static int b(final Throwable t) {
        return Log.e("BGH", "FOR SAFETY", t);
    }
    
    public static int c(final Throwable t) {
        return Log.e("BGH", "INTENTIONAL CODE", t);
    }
}
