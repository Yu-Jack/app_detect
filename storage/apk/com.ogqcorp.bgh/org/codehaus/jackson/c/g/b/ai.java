// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.f.a;

public class ai
{
    public static ad<?> a(final a a, final f f) {
        return new i(a, f);
    }
    
    public static e<?> a(final a a, final boolean b, final ba ba, final f f) {
        return new ak(a, b, ba, f);
    }
    
    public static e<?> a(final a a, final boolean b, final ba ba, final f f, final ad<Object> ad) {
        return new aj(a, b, ba, f, ad);
    }
    
    public static e<?> b(final a a, final boolean b, final ba ba, final f f) {
        return new l(a, b, ba, f);
    }
    
    public static e<?> b(final a a, final boolean b, final ba ba, final f f, final ad<Object> ad) {
        return new d(a, b, ba, f, ad);
    }
}
