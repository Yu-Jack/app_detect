// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import java.util.Arrays;

public final class a
{
    final String a;
    final boolean b;
    final char c;
    final int d;
    private final int[] e;
    private final char[] f;
    private final byte[] g;
    
    public a(final String a, final String s, final boolean b, final char c, final int d) {
        int i = 0;
        this.e = new int[128];
        this.f = new char[64];
        this.g = new byte[64];
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        final int length = s.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        s.getChars(0, length, this.f, 0);
        Arrays.fill(this.e, -1);
        while (i < length) {
            final char c2 = this.f[i];
            this.g[i] = (byte)c2;
            this.e[c2] = i;
            ++i;
        }
        if (b) {
            this.e[c] = -2;
        }
    }
    
    public a(final a a, final String s, final int n) {
        this(a, s, a.b, a.c, n);
    }
    
    public a(final a a, final String a2, final boolean b, final char c, final int d) {
        this.e = new int[128];
        this.f = new char[64];
        this.g = new byte[64];
        this.a = a2;
        final byte[] g = a.g;
        System.arraycopy(g, 0, this.g, 0, g.length);
        final char[] f = a.f;
        System.arraycopy(f, 0, this.f, 0, f.length);
        final int[] e = a.e;
        System.arraycopy(e, 0, this.e, 0, e.length);
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int a(final int n, final int n2, final byte[] array, final int n3) {
        final int n4 = n3 + 1;
        array[n3] = this.g[0x3F & n >> 18];
        final int n5 = n4 + 1;
        array[n4] = this.g[0x3F & n >> 12];
        if (this.b) {
            final byte b = (byte)this.c;
            final int n6 = n5 + 1;
            byte b2;
            if (n2 == 2) {
                b2 = this.g[0x3F & n >> 6];
            }
            else {
                b2 = b;
            }
            array[n5] = b2;
            final int n7 = n6 + 1;
            array[n6] = b;
            return n7;
        }
        if (n2 == 2) {
            final int n8 = n5 + 1;
            array[n5] = this.g[0x3F & n >> 6];
            return n8;
        }
        return n5;
    }
    
    public int a(final int n, final int n2, final char[] array, final int n3) {
        final int n4 = n3 + 1;
        array[n3] = this.f[0x3F & n >> 18];
        final int n5 = n4 + 1;
        array[n4] = this.f[0x3F & n >> 12];
        if (this.b) {
            final int n6 = n5 + 1;
            char c;
            if (n2 == 2) {
                c = this.f[0x3F & n >> 6];
            }
            else {
                c = this.c;
            }
            array[n5] = c;
            final int n7 = n6 + 1;
            array[n6] = this.c;
            return n7;
        }
        if (n2 == 2) {
            final int n8 = n5 + 1;
            array[n5] = this.f[0x3F & n >> 6];
            return n8;
        }
        return n5;
    }
    
    public int a(final int n, final byte[] array, final int n2) {
        final int n3 = n2 + 1;
        array[n2] = this.g[0x3F & n >> 18];
        final int n4 = n3 + 1;
        array[n3] = this.g[0x3F & n >> 12];
        final int n5 = n4 + 1;
        array[n4] = this.g[0x3F & n >> 6];
        final int n6 = n5 + 1;
        array[n5] = this.g[n & 0x3F];
        return n6;
    }
    
    public int a(final int n, final char[] array, final int n2) {
        final int n3 = n2 + 1;
        array[n2] = this.f[0x3F & n >> 18];
        final int n4 = n3 + 1;
        array[n3] = this.f[0x3F & n >> 12];
        final int n5 = n4 + 1;
        array[n4] = this.f[0x3F & n >> 6];
        final int n6 = n5 + 1;
        array[n5] = this.f[n & 0x3F];
        return n6;
    }
    
    public String a(final byte[] array, final boolean b) {
        final int length = array.length;
        final StringBuilder sb = new StringBuilder(length + (length >> 2) + (length >> 3));
        if (b) {
            sb.append('\"');
        }
        final int n = this.c() >> 2;
        int i = 0;
        final int n2 = length - 3;
        int n3 = n;
        while (i <= n2) {
            final int n4 = i + 1;
            final int n5 = array[i] << 8;
            final int n6 = n4 + 1;
            final int n7 = (n5 | (0xFF & array[n4])) << 8;
            final int n8 = n6 + 1;
            this.a(sb, n7 | (0xFF & array[n6]));
            int n9 = n3 - 1;
            if (n9 <= 0) {
                sb.append('\\');
                sb.append('n');
                n9 = this.c() >> 2;
            }
            n3 = n9;
            i = n8;
        }
        final int n10 = length - i;
        if (n10 > 0) {
            final int n11 = i + 1;
            int n12 = array[i] << 16;
            if (n10 == 2) {
                n12 |= (0xFF & array[n11]) << 8;
            }
            this.a(sb, n12, n10);
        }
        if (b) {
            sb.append('\"');
        }
        return sb.toString();
    }
    
    public void a(final StringBuilder sb, final int n) {
        sb.append(this.f[0x3F & n >> 18]);
        sb.append(this.f[0x3F & n >> 12]);
        sb.append(this.f[0x3F & n >> 6]);
        sb.append(this.f[n & 0x3F]);
    }
    
    public void a(final StringBuilder sb, final int n, final int n2) {
        sb.append(this.f[0x3F & n >> 18]);
        sb.append(this.f[0x3F & n >> 12]);
        if (this.b) {
            char c;
            if (n2 == 2) {
                c = this.f[0x3F & n >> 6];
            }
            else {
                c = this.c;
            }
            sb.append(c);
            sb.append(this.c);
        }
        else if (n2 == 2) {
            sb.append(this.f[0x3F & n >> 6]);
        }
    }
    
    public boolean a() {
        return this.b;
    }
    
    public boolean a(final char c) {
        return c == this.c;
    }
    
    public boolean a(final int n) {
        return n == this.c;
    }
    
    public char b() {
        return this.c;
    }
    
    public int b(final char c) {
        if (c <= '\u007f') {
            return this.e[c];
        }
        return -1;
    }
    
    public int b(final int n) {
        if (n <= 127) {
            return this.e[n];
        }
        return -1;
    }
    
    public int c() {
        return this.d;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
}
