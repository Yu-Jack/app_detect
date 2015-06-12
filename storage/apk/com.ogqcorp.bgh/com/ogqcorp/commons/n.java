// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.util.Log;

public final class n
{
    public static int a(final String format, final Object... args) {
        return Log.d("COMMONS", String.format(format, args));
    }
    
    public static int a(final Throwable t) {
        return Log.e("COMMONS", "FATAL ERROR", t);
    }
    
    public static int b(final Throwable t) {
        return Log.e("COMMONS", "FOR SAFETY", t);
    }
    
    public static int c(final Throwable t) {
        return Log.e("COMMONS", "INTENTIONAL CODE", t);
    }
}
