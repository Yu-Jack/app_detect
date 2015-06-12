// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.a;

import java.util.Locale;

public final class a
{
    public static String a() {
        return "http://bgh.ogqcorp.com/author/api/v2/curation/";
    }
    
    public static String a(final String s) {
        return String.format(Locale.US, "http://bgh.ogqcorp.com/author/api/v2/curation/%s/count/", s);
    }
    
    public static String b(final String s) {
        return String.format(Locale.US, "http://bgh.ogqcorp.com/author/api/v2/curation/%s/flickr.photos.getInfo", s);
    }
    
    public static String c(final String s) {
        return String.format(Locale.US, "http://bgh.ogqcorp.com/author/api/v2/curation/%s/flickr.photos.getSizes", s);
    }
}
