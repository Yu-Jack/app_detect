// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.text.TextUtils;
import com.facebook.b.aj;
import java.util.Map;
import java.io.Serializable;

final class v implements Serializable
{
    final w a;
    final a b;
    final String c;
    final String d;
    final p e;
    Map f;
    
    private v(final p e, final w a, final a b, final String c, final String d) {
        this.e = e;
        this.b = b;
        this.c = c;
        this.a = a;
        this.d = d;
    }
    
    static v a(final p p2, final a a) {
        return new v(p2, w.a, a, null, null);
    }
    
    static v a(final p p2, final String s) {
        return new v(p2, w.b, null, s, null);
    }
    
    static v a(final p p3, final String s, final String s2) {
        return a(p3, s, s2, null);
    }
    
    static v a(final p p4, final String s, final String s2, final String s3) {
        return new v(p4, w.c, null, TextUtils.join((CharSequence)": ", (Iterable)aj.b((Object[])new String[] { s, s2 })), s3);
    }
}
