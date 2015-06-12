// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import java.lang.ref.WeakReference;
import android.app.Activity;

abstract class d<T extends Activity>
{
    private final WeakReference<T> a;
    
    d(final T referent) {
        this.a = new WeakReference<T>(referent);
    }
    
    protected T a() {
        return this.a.get();
    }
}
