// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Date;
import android.os.Bundle;

public abstract class bs
{
    static Date a(final Bundle bundle, final String s) {
        if (bundle != null) {
            final long long1 = bundle.getLong(s, Long.MIN_VALUE);
            if (long1 != Long.MIN_VALUE) {
                return new Date(long1);
            }
        }
        return null;
    }
    
    static void a(final Bundle bundle, final String s, final Date date) {
        bundle.putLong(s, date.getTime());
    }
    
    public abstract Bundle a();
    
    public abstract void a(final Bundle p0);
    
    public abstract void b();
}
