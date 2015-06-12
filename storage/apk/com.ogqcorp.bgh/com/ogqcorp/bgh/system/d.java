// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import com.ogqcorp.commons.e;
import android.os.AsyncTask;
import java.util.HashMap;

public final class d
{
    private static AsyncTask<Object, Object, Object> a(final String s, final HashMap<String, Object> hashMap) {
        return new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                try {
                    new e().a(s, hashMap, 3000);
                    return null;
                }
                catch (Exception ex) {
                    l.c(ex);
                    return null;
                }
            }
        };
    }
    
    public static final void a(final Object... array) {
        a(o.b().j(), n.c(array)).execute(new Object[0]);
    }
    
    public static final void b(final Object... array) {
        a(o.b().k(), n.d(array)).execute(new Object[0]);
    }
    
    public static final void c(final Object... array) {
        a(o.b().l(), n.e(array)).execute(new Object[0]);
    }
}
