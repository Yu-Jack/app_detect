// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

abstract class o implements Serializable
{
    Map a;
    final /* synthetic */ m b;
    
    o(final m b) {
        this.b = b;
    }
    
    abstract String a();
    
    protected final void a(final String s, final Object o) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        final Map a = this.a;
        String string;
        if (o == null) {
            string = null;
        }
        else {
            string = o.toString();
        }
        a.put(s, string);
    }
    
    boolean a(final int n, final Intent intent) {
        return false;
    }
    
    abstract boolean a(final p p0);
    
    boolean b() {
        return false;
    }
    
    boolean c() {
        return false;
    }
    
    void d() {
    }
}
