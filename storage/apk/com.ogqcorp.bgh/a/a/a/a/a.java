// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a;

import a.a.a.b.b;
import a.a.a.c.c;
import java.util.Locale;
import a.a.a.a;
import a.a.a.e;
import java.nio.charset.Charset;
import java.io.Serializable;

public final class a implements Serializable
{
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    private final String o;
    private final Charset p;
    private final e[] q;
    
    static {
        a = a("application/atom+xml", a.a.a.a.c);
        b = a("application/x-www-form-urlencoded", a.a.a.a.c);
        c = a("application/json", a.a.a.a.a);
        d = a("application/octet-stream", null);
        e = a("application/svg+xml", a.a.a.a.c);
        f = a("application/xhtml+xml", a.a.a.a.c);
        g = a("application/xml", a.a.a.a.c);
        h = a("multipart/form-data", a.a.a.a.c);
        i = a("text/html", a.a.a.a.c);
        j = a("text/plain", a.a.a.a.c);
        k = a("text/xml", a.a.a.a.c);
        l = a("*/*", null);
        m = a.a.a.a.a.j;
        n = a.a.a.a.a.d;
    }
    
    a(final String o, final Charset p2) {
        this.o = o;
        this.p = p2;
        this.q = null;
    }
    
    public static a a(final String s, final Charset charset) {
        final String lowerCase = a.a.a.c.a.a(s, "MIME type").toLowerCase(Locale.US);
        a.a.a.c.a.a(a(lowerCase), "MIME type may not contain reserved characters");
        return new a(lowerCase, charset);
    }
    
    private static boolean a(final String s) {
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\"' || char1 == ',' || char1 == ';') {
                return false;
            }
        }
        return true;
    }
    
    public String a() {
        return this.o;
    }
    
    public Charset b() {
        return this.p;
    }
    
    @Override
    public String toString() {
        final c c = new c(64);
        c.a(this.o);
        if (this.q != null) {
            c.a("; ");
            a.a.a.b.b.b.a(c, this.q, false);
        }
        else if (this.p != null) {
            c.a("; charset=");
            c.a(this.p.name());
        }
        return c.toString();
    }
}
