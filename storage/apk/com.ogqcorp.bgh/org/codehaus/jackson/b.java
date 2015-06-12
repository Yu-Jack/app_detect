// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

public final class b
{
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    
    static {
        a = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        b = new a(org.codehaus.jackson.b.a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        c = new a(org.codehaus.jackson.b.a, "PEM", true, '=', 64);
        final StringBuffer sb = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf("+"), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        d = new a("MODIFIED-FOR-URL", sb.toString(), false, '\0', Integer.MAX_VALUE);
    }
    
    public static a a() {
        return org.codehaus.jackson.b.b;
    }
}
