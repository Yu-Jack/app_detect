// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c;

import com.ogqcorp.bgh.cf.data.Sizes;
import java.util.HashMap;
import org.codehaus.jackson.c.h.h;
import com.ogqcorp.bgh.cf.data.Photo;
import com.a.a.n;
import com.a.a.a.m;
import com.ogqcorp.bgh.cf.c.a.a;
import com.ogqcorp.bgh.cf.c.b.e;
import com.a.a.r;
import com.a.a.s;

public final class a
{
    public static void a(final s<String> s, final r r) {
        e.a().a(new m(0, com.ogqcorp.bgh.cf.c.a.a.a(), s, r));
    }
    
    public static void a(final String s, final s<String> s2, final r r) {
        e.a().a(new m(1, com.ogqcorp.bgh.cf.c.a.a.a(s), s2, r));
    }
    
    public static void b(final String s, final s<String> s2, final r r) {
        e.a().a(new m(3, com.ogqcorp.bgh.cf.c.a.a.a(s), s2, r));
    }
    
    public static void c(final String s, final s<Photo> s2, final r r) {
        e.a().a(new com.ogqcorp.bgh.cf.c.b.a<Object>(0, com.ogqcorp.bgh.cf.c.a.a.b(s), null, false, s2, h.e(Photo.class), r));
    }
    
    public static void d(final String s, final s<Sizes> s2, final r r) {
        e.a().a(new com.ogqcorp.bgh.cf.c.b.a<Object>(0, com.ogqcorp.bgh.cf.c.a.a.c(s), null, false, s2, h.e(Sizes.class), r));
    }
}
