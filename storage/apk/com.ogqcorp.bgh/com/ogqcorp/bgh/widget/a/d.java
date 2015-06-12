// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.util.Log;

public final class d
{
    public static int a(final Throwable t) {
        return Log.e("BGH_WIDGETS", "FATAL ERROR", t);
    }
    
    public static int b(final Throwable t) {
        return Log.e("BGH_WIDGETS", "FOR SAFETY", t);
    }
    
    public static int c(final Throwable t) {
        return Log.e("BGH_WIDGETS", "INTENTIONAL CODE", t);
    }
}
