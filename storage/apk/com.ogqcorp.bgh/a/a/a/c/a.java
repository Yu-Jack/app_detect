// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.c;

public class a
{
    public static int a(final int n, final String str) {
        if (n < 0) {
            throw new IllegalArgumentException(str + " may not be negative");
        }
        return n;
    }
    
    public static <T extends CharSequence> T a(final T t, final String s) {
        if (t == null) {
            throw new IllegalArgumentException(s + " may not be null");
        }
        if (d.a(t)) {
            throw new IllegalArgumentException(s + " may not be blank");
        }
        return t;
    }
    
    public static <T> T a(final T t, final String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        return t;
    }
    
    public static void a(final boolean b, final String s) {
        if (!b) {
            throw new IllegalArgumentException(s);
        }
    }
}
