// 
// Decompiled by Procyon v0.5.29
// 

package org.a.a.a;

import java.nio.charset.Charset;

public class a
{
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    
    static {
        a = Charset.forName("ISO-8859-1");
        b = Charset.forName("US-ASCII");
        c = Charset.forName("UTF-16");
        d = Charset.forName("UTF-16BE");
        e = Charset.forName("UTF-16LE");
        f = Charset.forName("UTF-8");
    }
    
    public static Charset a(Charset defaultCharset) {
        if (defaultCharset == null) {
            defaultCharset = Charset.defaultCharset();
        }
        return defaultCharset;
    }
}
