// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import org.codehaus.jackson.g.a;
import org.codehaus.jackson.g.e;
import org.codehaus.jackson.g.d;
import org.codehaus.jackson.g.l;
import java.lang.ref.SoftReference;

public final class e
{
    protected static final ThreadLocal<SoftReference<e>> a;
    private static final char[] e;
    private static final byte[] f;
    protected l b;
    protected d c;
    protected final char[] d;
    
    static {
        e = org.codehaus.jackson.g.e.g();
        f = org.codehaus.jackson.g.e.h();
        a = new ThreadLocal<SoftReference<e>>();
    }
    
    public e() {
        (this.d = new char[6])[0] = '\\';
        this.d[2] = '0';
        this.d[3] = '0';
    }
    
    private int a(final int i, final int j) {
        if (j < 56320 || j > 57343) {
            throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(j) + "; illegal combination");
        }
        return 65536 + (i - 55296 << 10) + (j - 56320);
    }
    
    private int a(int n, final int n2, final d d, final int n3) {
        d.e(n3);
        d.a(92);
        if (n2 < 0) {
            d.a(117);
            if (n > 255) {
                final int n4 = n >> 8;
                d.a(org.codehaus.jackson.b.e.f[n4 >> 4]);
                d.a(org.codehaus.jackson.b.e.f[n4 & 0xF]);
                n &= 0xFF;
            }
            else {
                d.a(48);
                d.a(48);
            }
            d.a(org.codehaus.jackson.b.e.f[n >> 4]);
            d.a(org.codehaus.jackson.b.e.f[n & 0xF]);
        }
        else {
            d.a((byte)n2);
        }
        return d.f();
    }
    
    private int a(final int n, final char[] array) {
        if (n < 0) {
            final int n2 = -(n + 1);
            array[1] = 'u';
            array[4] = org.codehaus.jackson.b.e.e[n2 >> 4];
            array[5] = org.codehaus.jackson.b.e.e[n2 & 0xF];
            return 6;
        }
        array[1] = (char)n;
        return 2;
    }
    
    public static e a() {
        final SoftReference<e> softReference = org.codehaus.jackson.b.e.a.get();
        e referent;
        if (softReference == null) {
            referent = null;
        }
        else {
            referent = softReference.get();
        }
        if (referent == null) {
            referent = new e();
            org.codehaus.jackson.b.e.a.set(new SoftReference<e>(referent));
        }
        return referent;
    }
    
    private void a(final int n) {
        if (n > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(n) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (n < 55296) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(n) + ") to output");
        }
        if (n <= 56319) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(n) + ")");
        }
        throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(n) + ")");
    }
    
    public char[] a(final String s) {
        l b = this.b;
        if (b == null) {
            b = new l(null);
            this.b = b;
        }
        char[] array = b.k();
        final int[] f = org.codehaus.jackson.g.e.f();
        final int length = f.length;
        final int length2 = s.length();
        int n = 0;
        int i = 0;
    Label_0165_Outer:
        while (i < length2) {
            while (true) {
                int a;
                while (true) {
                    final char char1 = s.charAt(i);
                    if (char1 < length && f[char1] != 0) {
                        final int n2 = i + 1;
                        a = this.a(f[s.charAt(i)], this.d);
                        if (n + a > array.length) {
                            final int n3 = array.length - n;
                            if (n3 > 0) {
                                System.arraycopy(this.d, 0, array, n, n3);
                            }
                            array = b.m();
                            n = a - n3;
                            System.arraycopy(this.d, n3, array, 0, n);
                            i = n2;
                            continue Label_0165_Outer;
                        }
                        break;
                    }
                    else {
                        int n4;
                        if (n >= array.length) {
                            array = b.m();
                            n4 = 0;
                        }
                        else {
                            n4 = n;
                        }
                        n = n4 + 1;
                        array[n4] = char1;
                        if (++i >= length2) {
                            break Label_0165_Outer;
                        }
                        continue Label_0165_Outer;
                    }
                }
                System.arraycopy(this.d, 0, array, n, a);
                n += a;
                continue;
            }
        }
        b.a(n);
        return b.g();
    }
    
    public byte[] b(final String s) {
        d c = this.c;
        if (c == null) {
            c = new d(null);
            this.c = c;
        }
        final int length = s.length();
        byte[] array = c.c();
        int a = 0;
        int i = 0;
    Label_0181:
        while (i < length) {
            final int[] f = org.codehaus.jackson.g.e.f();
            int index;
            char char2;
            while (true) {
                final char char1 = s.charAt(i);
                if (char1 > '\u007f' || f[char1] != 0) {
                    if (a >= array.length) {
                        array = c.d();
                        a = 0;
                    }
                    index = i + 1;
                    char2 = s.charAt(i);
                    if (char2 <= '\u007f') {
                        a = this.a(char2, f[char2], c, a);
                        array = c.e();
                        i = index;
                        continue Label_0181;
                    }
                    break;
                }
                else {
                    int n;
                    if (a >= array.length) {
                        array = c.d();
                        n = 0;
                    }
                    else {
                        n = a;
                    }
                    a = n + 1;
                    array[n] = (byte)char1;
                    if (++i >= length) {
                        break Label_0181;
                    }
                    continue;
                }
            }
            int n2;
            byte[] d;
            int n3;
            if (char2 <= '\u07ff') {
                n2 = a + 1;
                array[a] = (byte)('\u00c0' | char2 >> 6);
                final char c2 = (char)('\u0080' | (char2 & '?'));
                d = array;
                n3 = c2;
            }
            else if (char2 < '\ud800' || char2 > '\udfff') {
                final int n4 = a + 1;
                array[a] = (byte)('\u00e0' | char2 >> 12);
                int n5;
                if (n4 >= array.length) {
                    array = c.d();
                    n5 = 0;
                }
                else {
                    n5 = n4;
                }
                n2 = n5 + 1;
                array[n5] = (byte)('\u0080' | ('?' & char2 >> 6));
                final char c3 = (char)('\u0080' | (char2 & '?'));
                d = array;
                n3 = c3;
            }
            else {
                if (char2 > '\udbff') {
                    this.a(char2);
                }
                if (index >= length) {
                    this.a(char2);
                }
                final int n6 = index + 1;
                final int a2 = this.a(char2, s.charAt(index));
                if (a2 > 1114111) {
                    this.a(a2);
                }
                final int n7 = a + 1;
                array[a] = (byte)(0xF0 | a2 >> 18);
                int n8;
                if (n7 >= array.length) {
                    array = c.d();
                    n8 = 0;
                }
                else {
                    n8 = n7;
                }
                final int n9 = n8 + 1;
                array[n8] = (byte)(0x80 | (0x3F & a2 >> 12));
                int n10;
                if (n9 >= array.length) {
                    array = c.d();
                    n10 = 0;
                }
                else {
                    n10 = n9;
                }
                n2 = n10 + 1;
                array[n10] = (byte)(0x80 | (0x3F & a2 >> 6));
                final int n11 = 0x80 | (a2 & 0x3F);
                index = n6;
                final byte[] array2 = array;
                n3 = n11;
                d = array2;
            }
            if (n2 >= d.length) {
                d = c.d();
                n2 = 0;
            }
            final int n12 = n2 + 1;
            d[n2] = (byte)n3;
            array = d;
            i = index;
            a = n12;
        }
        return this.c.d(a);
    }
    
    public byte[] c(final String s) {
        d c = this.c;
        if (c == null) {
            c = new d(null);
            this.c = c;
        }
        final int length = s.length();
        byte[] c2 = c.c();
        int length2 = c2.length;
        int n = 0;
        int i = 0;
        while (i < length) {
            int n2 = i + 1;
            char c3 = s.charAt(i);
            final int n3 = length2;
            byte[] array = c2;
            int n4 = n;
            int n5 = n3;
            while (c3 <= '\u007f') {
                if (n4 >= n5) {
                    array = c.d();
                    n5 = array.length;
                    n4 = 0;
                }
                final int n6 = n4 + 1;
                array[n4] = (byte)c3;
                if (n2 >= length) {
                    final int n7 = n6;
                    return this.c.d(n7);
                }
                final int n8 = n2 + 1;
                c3 = s.charAt(n2);
                n2 = n8;
                n4 = n6;
            }
            int n9;
            if (n4 >= n5) {
                array = c.d();
                n5 = array.length;
                n9 = 0;
            }
            else {
                n9 = n4;
            }
            int n10;
            int n11;
            if (c3 < '\u0800') {
                n10 = n9 + 1;
                array[n9] = (byte)('\u00c0' | c3 >> 6);
                n11 = c3;
                i = n2;
            }
            else if (c3 < '\ud800' || c3 > '\udfff') {
                int n12 = n9 + 1;
                array[n9] = (byte)('\u00e0' | c3 >> 12);
                if (n12 >= n5) {
                    array = c.d();
                    n5 = array.length;
                    n12 = 0;
                }
                final int n13 = n12 + 1;
                array[n12] = (byte)('\u0080' | ('?' & c3 >> 6));
                n10 = n13;
                n11 = c3;
                i = n2;
            }
            else {
                if (c3 > '\udbff') {
                    this.a(c3);
                }
                if (n2 >= length) {
                    this.a(c3);
                }
                final int n14 = n2 + 1;
                final int a = this.a(c3, s.charAt(n2));
                if (a > 1114111) {
                    this.a(a);
                }
                int n15 = n9 + 1;
                array[n9] = (byte)(0xF0 | a >> 18);
                if (n15 >= n5) {
                    array = c.d();
                    n5 = array.length;
                    n15 = 0;
                }
                final int n16 = n15 + 1;
                array[n15] = (byte)(0x80 | (0x3F & a >> 12));
                int n17;
                if (n16 >= n5) {
                    array = c.d();
                    n5 = array.length;
                    n17 = 0;
                }
                else {
                    n17 = n16;
                }
                final int n18 = n17 + 1;
                array[n17] = (byte)(0x80 | (0x3F & a >> 6));
                n10 = n18;
                n11 = a;
                i = n14;
            }
            if (n10 >= n5) {
                array = c.d();
                n5 = array.length;
                n10 = 0;
            }
            final int n19 = n10 + 1;
            array[n10] = (byte)(0x80 | (n11 & 0x3F));
            c2 = array;
            length2 = n5;
            n = n19;
        }
        final int n7 = n;
        return this.c.d(n7);
    }
}
