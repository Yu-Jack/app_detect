// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.b;

import a.a.a.c.a;
import a.a.a.c.c;
import a.a.a.e;

public class b
{
    @Deprecated
    public static final b a;
    public static final b b;
    
    static {
        a = new b();
        b = new b();
    }
    
    protected int a(final e e) {
        int length;
        if (e == null) {
            length = 0;
        }
        else {
            length = e.a().length();
            final String b = e.b();
            if (b != null) {
                return length + (3 + b.length());
            }
        }
        return length;
    }
    
    protected int a(final e[] array) {
        int n = 0;
        if (array != null) {
            final int length = array.length;
            n = 0;
            if (length >= 1) {
                final int n2 = 2 * (-1 + array.length);
                final int length2 = array.length;
                n = n2;
                int n3;
                for (int i = 0; i < length2; ++i, n = n3) {
                    n3 = n + this.a(array[i]);
                }
            }
        }
        return n;
    }
    
    public c a(c c, final e e, final boolean b) {
        a.a.a.c.a.a(e, "Name / value pair");
        final int a = this.a(e);
        if (c == null) {
            c = new c(a);
        }
        else {
            c.a(a);
        }
        c.a(e.a());
        final String b2 = e.b();
        if (b2 != null) {
            c.a('=');
            this.a(c, b2, b);
        }
        return c;
    }
    
    public c a(c c, final e[] array, final boolean b) {
        a.a.a.c.a.a(array, "Header parameter array");
        final int a = this.a(array);
        if (c == null) {
            c = new c(a);
        }
        else {
            c.a(a);
        }
        for (int i = 0; i < array.length; ++i) {
            if (i > 0) {
                c.a("; ");
            }
            this.a(c, array[i], b);
        }
        return c;
    }
    
    protected void a(final c c, final String s, boolean a) {
        if (!a) {
            for (int index = 0; index < s.length() && !a; a = this.a(s.charAt(index)), ++index) {}
        }
        int i = 0;
        if (a) {
            c.a('\"');
        }
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (this.b(char1)) {
                c.a('\\');
            }
            c.a(char1);
            ++i;
        }
        if (a) {
            c.a('\"');
        }
    }
    
    protected boolean a(final char ch) {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(ch) >= 0;
    }
    
    protected boolean b(final char ch) {
        return "\"\\".indexOf(ch) >= 0;
    }
}
