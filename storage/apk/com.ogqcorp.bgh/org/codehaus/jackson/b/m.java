// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class m extends Writer
{
    protected final c a;
    OutputStream b;
    byte[] c;
    final int d;
    int e;
    int f;
    
    public m(final c a, final OutputStream b) {
        this.f = 0;
        this.a = a;
        this.b = b;
        this.c = a.f();
        this.d = -4 + this.c.length;
        this.e = 0;
    }
    
    private int a(final int i) {
        final int f = this.f;
        this.f = 0;
        if (i < 56320 || i > 57343) {
            throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(f) + ", second 0x" + Integer.toHexString(i) + "; illegal combination");
        }
        return 65536 + (f - 55296 << 10) + (i - 56320);
    }
    
    private void b(final int n) {
        if (n > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(n) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (n < 55296) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(n) + ") to output");
        }
        if (n <= 56319) {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(n) + ")");
        }
        throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(n) + ")");
    }
    
    @Override
    public Writer append(final char c) {
        this.write(c);
        return this;
    }
    
    @Override
    public void close() {
        if (this.b != null) {
            if (this.e > 0) {
                this.b.write(this.c, 0, this.e);
                this.e = 0;
            }
            final OutputStream b = this.b;
            this.b = null;
            final byte[] c = this.c;
            if (c != null) {
                this.c = null;
                this.a.b(c);
            }
            b.close();
            final int f = this.f;
            this.f = 0;
            if (f > 0) {
                this.b(f);
            }
        }
    }
    
    @Override
    public void flush() {
        if (this.b != null) {
            if (this.e > 0) {
                this.b.write(this.c, 0, this.e);
                this.e = 0;
            }
            this.b.flush();
        }
    }
    
    @Override
    public void write(int a) {
        if (this.f > 0) {
            a = this.a(a);
        }
        else if (a >= 55296 && a <= 57343) {
            if (a > 56319) {
                this.b(a);
            }
            this.f = a;
            return;
        }
        if (this.e >= this.d) {
            this.b.write(this.c, 0, this.e);
            this.e = 0;
        }
        if (a < 128) {
            this.c[this.e++] = (byte)a;
            return;
        }
        final int e = this.e;
        int e2;
        if (a < 2048) {
            final byte[] c = this.c;
            final int n = e + 1;
            c[e] = (byte)(0xC0 | a >> 6);
            final byte[] c2 = this.c;
            e2 = n + 1;
            c2[n] = (byte)(0x80 | (a & 0x3F));
        }
        else if (a <= 65535) {
            final byte[] c3 = this.c;
            final int n2 = e + 1;
            c3[e] = (byte)(0xE0 | a >> 12);
            final byte[] c4 = this.c;
            final int n3 = n2 + 1;
            c4[n2] = (byte)(0x80 | (0x3F & a >> 6));
            final byte[] c5 = this.c;
            e2 = n3 + 1;
            c5[n3] = (byte)(0x80 | (a & 0x3F));
        }
        else {
            if (a > 1114111) {
                this.b(a);
            }
            final byte[] c6 = this.c;
            final int n4 = e + 1;
            c6[e] = (byte)(0xF0 | a >> 18);
            final byte[] c7 = this.c;
            final int n5 = n4 + 1;
            c7[n4] = (byte)(0x80 | (0x3F & a >> 12));
            final byte[] c8 = this.c;
            final int n6 = n5 + 1;
            c8[n5] = (byte)(0x80 | (0x3F & a >> 6));
            final byte[] c9 = this.c;
            e2 = n6 + 1;
            c9[n6] = (byte)(0x80 | (a & 0x3F));
        }
        this.e = e2;
    }
    
    @Override
    public void write(final String s) {
        this.write(s, 0, s.length());
    }
    
    @Override
    public void write(final String s, int n, int n2) {
        if (n2 < 2) {
            if (n2 == 1) {
                this.write(s.charAt(n));
            }
            return;
        }
        if (this.f > 0) {
            final int n3 = n + 1;
            final char char1 = s.charAt(n);
            --n2;
            this.write(this.a(char1));
            n = n3;
        }
        int e = this.e;
        final byte[] c = this.c;
        final int d = this.d;
        final int n4 = n2 + n;
        int i = n;
        while (i < n4) {
            if (e >= d) {
                this.b.write(c, 0, e);
                e = 0;
            }
            final int n5 = i + 1;
            final char char2 = s.charAt(i);
            char f = '\0';
            Label_0238: {
                if (char2 < '\u0080') {
                    final int n6 = e + 1;
                    c[e] = (byte)char2;
                    final int n7 = n4 - n5;
                    int n8 = d - n6;
                    if (n7 <= n8) {
                        n8 = n7;
                    }
                    final int n9 = n8 + n5;
                    int n10 = n6;
                    int j;
                    int n11;
                    for (j = n5; j < n9; j = n11) {
                        n11 = j + 1;
                        final char char3 = s.charAt(j);
                        if (char3 >= '\u0080') {
                            e = n10;
                            i = n11;
                            f = char3;
                            break Label_0238;
                        }
                        final int n12 = n10 + 1;
                        c[n10] = (byte)char3;
                        n10 = n12;
                    }
                    final int n13 = n10;
                    i = j;
                    e = n13;
                    continue;
                }
                i = n5;
                f = char2;
            }
            if (f < '\u0800') {
                final int n14 = e + 1;
                c[e] = (byte)('\u00c0' | f >> 6);
                e = n14 + 1;
                c[n14] = (byte)('\u0080' | (f & '?'));
            }
            else if (f < '\ud800' || f > '\udfff') {
                final int n15 = e + 1;
                c[e] = (byte)('\u00e0' | f >> 12);
                final int n16 = n15 + 1;
                c[n15] = (byte)('\u0080' | ('?' & f >> 6));
                e = n16 + 1;
                c[n16] = (byte)('\u0080' | (f & '?'));
            }
            else {
                if (f > '\udbff') {
                    this.e = e;
                    this.b(f);
                }
                this.f = f;
                if (i >= n4) {
                    break;
                }
                final int n17 = i + 1;
                final int a = this.a(s.charAt(i));
                if (a > 1114111) {
                    this.e = e;
                    this.b(a);
                }
                final int n18 = e + 1;
                c[e] = (byte)(0xF0 | a >> 18);
                final int n19 = n18 + 1;
                c[n18] = (byte)(0x80 | (0x3F & a >> 12));
                final int n20 = n19 + 1;
                c[n19] = (byte)(0x80 | (0x3F & a >> 6));
                e = n20 + 1;
                c[n20] = (byte)(0x80 | (a & 0x3F));
                i = n17;
            }
        }
        this.e = e;
    }
    
    @Override
    public void write(final char[] array) {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final char[] array, int n, int n2) {
        if (n2 < 2) {
            if (n2 == 1) {
                this.write(array[n]);
            }
            return;
        }
        if (this.f > 0) {
            final int n3 = n + 1;
            final char c = array[n];
            --n2;
            this.write(this.a(c));
            n = n3;
        }
        int e = this.e;
        final byte[] c2 = this.c;
        final int d = this.d;
        final int n4 = n2 + n;
        int i = n;
        while (i < n4) {
            if (e >= d) {
                this.b.write(c2, 0, e);
                e = 0;
            }
            final int n5 = i + 1;
            final char c3 = array[i];
            char f = '\0';
            Label_0230: {
                if (c3 < '\u0080') {
                    final int n6 = e + 1;
                    c2[e] = (byte)c3;
                    final int n7 = n4 - n5;
                    int n8 = d - n6;
                    if (n7 <= n8) {
                        n8 = n7;
                    }
                    final int n9 = n8 + n5;
                    int n10 = n6;
                    int j;
                    int n11;
                    for (j = n5; j < n9; j = n11) {
                        n11 = j + 1;
                        final char c4 = array[j];
                        if (c4 >= '\u0080') {
                            e = n10;
                            i = n11;
                            f = c4;
                            break Label_0230;
                        }
                        final int n12 = n10 + 1;
                        c2[n10] = (byte)c4;
                        n10 = n12;
                    }
                    final int n13 = n10;
                    i = j;
                    e = n13;
                    continue;
                }
                i = n5;
                f = c3;
            }
            if (f < '\u0800') {
                final int n14 = e + 1;
                c2[e] = (byte)('\u00c0' | f >> 6);
                e = n14 + 1;
                c2[n14] = (byte)('\u0080' | (f & '?'));
            }
            else if (f < '\ud800' || f > '\udfff') {
                final int n15 = e + 1;
                c2[e] = (byte)('\u00e0' | f >> 12);
                final int n16 = n15 + 1;
                c2[n15] = (byte)('\u0080' | ('?' & f >> 6));
                e = n16 + 1;
                c2[n16] = (byte)('\u0080' | (f & '?'));
            }
            else {
                if (f > '\udbff') {
                    this.e = e;
                    this.b(f);
                }
                this.f = f;
                if (i >= n4) {
                    break;
                }
                final int n17 = i + 1;
                final int a = this.a(array[i]);
                if (a > 1114111) {
                    this.e = e;
                    this.b(a);
                }
                final int n18 = e + 1;
                c2[e] = (byte)(0xF0 | a >> 18);
                final int n19 = n18 + 1;
                c2[n18] = (byte)(0x80 | (0x3F & a >> 12));
                final int n20 = n19 + 1;
                c2[n19] = (byte)(0x80 | (0x3F & a >> 6));
                e = n20 + 1;
                c2[n20] = (byte)(0x80 | (a & 0x3F));
                i = n17;
            }
        }
        this.e = e;
    }
}
