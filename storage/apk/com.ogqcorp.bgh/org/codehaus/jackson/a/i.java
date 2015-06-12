// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.b.k;
import org.codehaus.jackson.a;
import java.math.BigInteger;
import java.math.BigDecimal;
import org.codehaus.jackson.f;
import org.codehaus.jackson.b.h;
import org.codehaus.jackson.s;
import org.codehaus.jackson.g;
import org.codehaus.jackson.q;
import org.codehaus.jackson.g.e;
import org.codehaus.jackson.b.b;
import java.io.OutputStream;

public class i extends c
{
    static final byte[] g;
    protected static final int[] h;
    private static final byte[] u;
    private static final byte[] v;
    private static final byte[] w;
    protected final org.codehaus.jackson.b.c i;
    protected final OutputStream j;
    protected int[] k;
    protected int l;
    protected b m;
    protected byte[] n;
    protected int o;
    protected final int p;
    protected final int q;
    protected char[] r;
    protected final int s;
    protected boolean t;
    
    static {
        g = e.h();
        u = new byte[] { 110, 117, 108, 108 };
        v = new byte[] { 116, 114, 117, 101 };
        w = new byte[] { 102, 97, 108, 115, 101 };
        h = e.f();
    }
    
    public i(final org.codehaus.jackson.b.c i, final int n, final q q, final OutputStream j) {
        super(n, q);
        this.k = org.codehaus.jackson.a.i.h;
        this.o = 0;
        this.i = i;
        this.j = j;
        this.t = true;
        this.n = i.f();
        this.p = this.n.length;
        this.q = this.p >> 3;
        this.r = i.h();
        this.s = this.r.length;
        if (this.a(org.codehaus.jackson.g.g)) {
            this.a(127);
        }
    }
    
    private final int a(final int n, final char[] array, final int n2, final int n3) {
        if (n >= 55296 && n <= 57343) {
            if (n2 >= n3) {
                this.i("Split surrogate on writeRaw() input (last character)");
            }
            this.a(n, array[n2]);
            return n2 + 1;
        }
        final byte[] n4 = this.n;
        n4[this.o++] = (byte)(0xE0 | n >> 12);
        n4[this.o++] = (byte)(0x80 | (0x3F & n >> 6));
        n4[this.o++] = (byte)(0x80 | (n & 0x3F));
        return n2;
    }
    
    private int a(final byte[] array, final int o, final int n, final byte[] b, final int n2) {
        final int length = b.length;
        int o2 = 0;
        Label_0068: {
            if (o + length <= n) {
                o2 = o;
                break Label_0068;
            }
            this.o = o;
            this.o();
            o2 = this.o;
            if (length <= array.length) {
                System.arraycopy(b, 0, array, o2, length);
                o2 += length;
                break Label_0068;
            }
            this.j.write(b, 0, length);
            return o2;
        }
        if (o2 + n2 * 6 > n) {
            this.o();
            return this.o;
        }
        return o2;
    }
    
    private int a(final byte[] array, final int n, final s s, final int n2) {
        final byte[] c = s.c();
        final int length = c.length;
        if (length > 6) {
            return this.a(array, n, this.p, c, n2);
        }
        System.arraycopy(c, 0, array, n, length);
        return length + n;
    }
    
    private final void b(final long n) {
        if (23 + this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.o = org.codehaus.jackson.b.h.a(n, this.n, this.o);
        this.n[this.o++] = 34;
    }
    
    private final void b(final byte[] b) {
        final int length = b.length;
        if (length + this.o > this.p) {
            this.o();
            if (length > 512) {
                this.j.write(b, 0, length);
                return;
            }
        }
        System.arraycopy(b, 0, this.n, this.o, length);
        this.o += length;
    }
    
    private final int c(final int n, final int n2) {
        final byte[] n3 = this.n;
        if (n >= 55296 && n <= 57343) {
            final int n4 = n2 + 1;
            n3[n2] = 92;
            final int n5 = n4 + 1;
            n3[n4] = 117;
            final int n6 = n5 + 1;
            n3[n5] = org.codehaus.jackson.a.i.g[0xF & n >> 12];
            final int n7 = n6 + 1;
            n3[n6] = org.codehaus.jackson.a.i.g[0xF & n >> 8];
            final int n8 = n7 + 1;
            n3[n7] = org.codehaus.jackson.a.i.g[0xF & n >> 4];
            final int n9 = n8 + 1;
            n3[n8] = org.codehaus.jackson.a.i.g[n & 0xF];
            return n9;
        }
        final int n10 = n2 + 1;
        n3[n2] = (byte)(0xE0 | n >> 12);
        final int n11 = n10 + 1;
        n3[n10] = (byte)(0x80 | (0x3F & n >> 6));
        final int n12 = n11 + 1;
        n3[n11] = (byte)(0x80 | (n & 0x3F));
        return n12;
    }
    
    private final void c(final int n) {
        if (13 + this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.o = org.codehaus.jackson.b.h.a(n, this.n, this.o);
        this.n[this.o++] = 34;
    }
    
    private final void c(final Object o) {
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.c(o.toString());
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    private final void c(final char[] array, final int n, final int n2) {
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.e(this.r, 0, n2);
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    private int d(int n, final int n2) {
        final byte[] n3 = this.n;
        final int n4 = n2 + 1;
        n3[n2] = 92;
        final int n5 = n4 + 1;
        n3[n4] = 117;
        int n8;
        if (n > 255) {
            final int n6 = 0xFF & n >> 8;
            final int n7 = n5 + 1;
            n3[n5] = org.codehaus.jackson.a.i.g[n6 >> 4];
            n8 = n7 + 1;
            n3[n7] = org.codehaus.jackson.a.i.g[n6 & 0xF];
            n &= 0xFF;
        }
        else {
            final int n9 = n5 + 1;
            n3[n5] = 48;
            n8 = n9 + 1;
            n3[n9] = 48;
        }
        final int n10 = n8 + 1;
        n3[n8] = org.codehaus.jackson.a.i.g[n >> 4];
        final int n11 = n10 + 1;
        n3[n10] = org.codehaus.jackson.a.i.g[n & 0xF];
        return n11;
    }
    
    private final void d(final char[] array, final int n, final int n2) {
        final int p3 = this.p;
        final byte[] n3 = this.n;
        int i = n;
    Label_0015:
        while (i < n2) {
            do {
                final char c = array[i];
                if (c >= '\u0080') {
                    if (3 + this.o >= this.p) {
                        this.o();
                    }
                    final int n4 = i + 1;
                    final char c2 = array[i];
                    if (c2 < '\u0800') {
                        n3[this.o++] = (byte)('\u00c0' | c2 >> 6);
                        n3[this.o++] = (byte)('\u0080' | (c2 & '?'));
                    }
                    else {
                        this.a(c2, array, n4, n2);
                    }
                    i = n4;
                    continue Label_0015;
                }
                if (this.o >= p3) {
                    this.o();
                }
                n3[this.o++] = (byte)c;
            } while (++i < n2);
            break;
        }
    }
    
    private final void e(final char[] array, int n, int i) {
        do {
            final int min = Math.min(this.q, i);
            if (min + this.o > this.p) {
                this.o();
            }
            this.f(array, n, min);
            n += min;
            i -= min;
        } while (i > 0);
    }
    
    private final void f(final char[] array, int i, final int n) {
        final int n2 = n + i;
        int o = this.o;
        final byte[] n3 = this.n;
        final int[] k = this.k;
        while (i < n2) {
            final char c = array[i];
            if (c > '\u007f' || k[c] != 0) {
                break;
            }
            final int n4 = o + 1;
            n3[o] = (byte)c;
            ++i;
            o = n4;
        }
        this.o = o;
        if (i < n2) {
            if (this.m != null) {
                this.i(array, i, n2);
            }
            else {
                if (this.l == 0) {
                    this.g(array, i, n2);
                    return;
                }
                this.h(array, i, n2);
            }
        }
    }
    
    private final void g(final char[] array, int i, final int n) {
        if (this.o + 6 * (n - i) > this.p) {
            this.o();
        }
        int o = this.o;
        final byte[] n2 = this.n;
        final int[] k = this.k;
        while (i < n) {
            final int n3 = i + 1;
            final char c = array[i];
            if (c <= '\u007f') {
                if (k[c] == 0) {
                    final int n4 = o + 1;
                    n2[o] = (byte)c;
                    o = n4;
                    i = n3;
                }
                else {
                    final int n5 = k[c];
                    if (n5 > 0) {
                        final int n6 = o + 1;
                        n2[o] = 92;
                        o = n6 + 1;
                        n2[n6] = (byte)n5;
                        i = n3;
                    }
                    else {
                        o = this.d(c, o);
                        i = n3;
                    }
                }
            }
            else {
                if (c <= '\u07ff') {
                    final int n7 = o + 1;
                    n2[o] = (byte)('\u00c0' | c >> 6);
                    o = n7 + 1;
                    n2[n7] = (byte)('\u0080' | (c & '?'));
                }
                else {
                    o = this.c(c, o);
                }
                i = n3;
            }
        }
        this.o = o;
    }
    
    private final void h(final char[] array, int i, final int n) {
        if (this.o + 6 * (n - i) > this.p) {
            this.o();
        }
        int o = this.o;
        final byte[] n2 = this.n;
        final int[] k = this.k;
        final int l = this.l;
        while (i < n) {
            final int n3 = i + 1;
            final char c = array[i];
            if (c <= '\u007f') {
                if (k[c] == 0) {
                    final int n4 = o + 1;
                    n2[o] = (byte)c;
                    o = n4;
                    i = n3;
                }
                else {
                    final int n5 = k[c];
                    if (n5 > 0) {
                        final int n6 = o + 1;
                        n2[o] = 92;
                        o = n6 + 1;
                        n2[n6] = (byte)n5;
                        i = n3;
                    }
                    else {
                        o = this.d(c, o);
                        i = n3;
                    }
                }
            }
            else if (c > l) {
                o = this.d(c, o);
                i = n3;
            }
            else {
                if (c <= '\u07ff') {
                    final int n7 = o + 1;
                    n2[o] = (byte)('\u00c0' | c >> 6);
                    o = n7 + 1;
                    n2[n7] = (byte)('\u0080' | (c & '?'));
                }
                else {
                    o = this.c(c, o);
                }
                i = n3;
            }
        }
        this.o = o;
    }
    
    private final void i(final char[] array, int i, final int n) {
        if (this.o + 6 * (n - i) > this.p) {
            this.o();
        }
        int o = this.o;
        final byte[] n2 = this.n;
        final int[] k = this.k;
        int l;
        if (this.l <= 0) {
            l = 65535;
        }
        else {
            l = this.l;
        }
        final b m = this.m;
        while (i < n) {
            final int n3 = i + 1;
            final char j = array[i];
            if (j <= '\u007f') {
                if (k[j] == 0) {
                    final int n4 = o + 1;
                    n2[o] = (byte)j;
                    o = n4;
                    i = n3;
                }
                else {
                    final int n5 = k[j];
                    if (n5 > 0) {
                        final int n6 = o + 1;
                        n2[o] = 92;
                        o = n6 + 1;
                        n2[n6] = (byte)n5;
                        i = n3;
                    }
                    else if (n5 == -2) {
                        final s a = m.a(j);
                        if (a == null) {
                            throw new org.codehaus.jackson.e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(j) + ", although was supposed to have one");
                        }
                        o = this.a(n2, o, a, n - n3);
                        i = n3;
                    }
                    else {
                        o = this.d(j, o);
                        i = n3;
                    }
                }
            }
            else if (j > l) {
                o = this.d(j, o);
                i = n3;
            }
            else {
                final s a2 = m.a(j);
                if (a2 != null) {
                    o = this.a(n2, o, a2, n - n3);
                    i = n3;
                }
                else {
                    if (j <= '\u07ff') {
                        final int n7 = o + 1;
                        n2[o] = (byte)('\u00c0' | j >> 6);
                        o = n7 + 1;
                        n2[n7] = (byte)('\u0080' | (j & '?'));
                    }
                    else {
                        o = this.c(j, o);
                    }
                    i = n3;
                }
            }
        }
        this.o = o;
    }
    
    private final void k(final String s) {
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.l(s);
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    private final void l(final String s) {
        final int length = s.length();
        final char[] r = this.r;
        int i = length;
        int srcBegin = 0;
        while (i > 0) {
            final int min = Math.min(this.q, i);
            s.getChars(srcBegin, srcBegin + min, r, 0);
            if (min + this.o > this.p) {
                this.o();
            }
            this.f(r, 0, min);
            srcBegin += min;
            i -= min;
        }
    }
    
    private final void p() {
        if (4 + this.o >= this.p) {
            this.o();
        }
        System.arraycopy(org.codehaus.jackson.a.i.u, 0, this.n, this.o, 4);
        this.o += 4;
    }
    
    @Override
    public f a(int l) {
        if (l < 0) {
            l = 0;
        }
        this.l = l;
        return this;
    }
    
    @Override
    public f a(final b m) {
        this.m = m;
        if (m == null) {
            this.k = org.codehaus.jackson.a.i.h;
            return this;
        }
        this.k = m.a();
        return this;
    }
    
    @Override
    public void a(final char c) {
        if (3 + this.o >= this.p) {
            this.o();
        }
        final byte[] n = this.n;
        if (c <= '\u007f') {
            n[this.o++] = (byte)c;
            return;
        }
        if (c < '\u0800') {
            n[this.o++] = (byte)('\u00c0' | c >> 6);
            n[this.o++] = (byte)('\u0080' | (c & '?'));
            return;
        }
        this.a(c, null, 0, 0);
    }
    
    @Override
    public void a(final double n) {
        if (this.d || ((Double.isNaN(n) || Double.isInfinite(n)) && this.a(org.codehaus.jackson.g.d))) {
            this.b(String.valueOf(n));
            return;
        }
        this.h("write number");
        this.c(String.valueOf(n));
    }
    
    @Override
    public void a(final float n) {
        if (this.d || ((Float.isNaN(n) || Float.isInfinite(n)) && this.a(org.codehaus.jackson.g.d))) {
            this.b(String.valueOf(n));
            return;
        }
        this.h("write number");
        this.c(String.valueOf(n));
    }
    
    protected final void a(final int n, final int n2) {
        final int b = this.b(n, n2);
        if (4 + this.o > this.p) {
            this.o();
        }
        final byte[] n3 = this.n;
        n3[this.o++] = (byte)(0xF0 | b >> 18);
        n3[this.o++] = (byte)(0x80 | (0x3F & b >> 12));
        n3[this.o++] = (byte)(0x80 | (0x3F & b >> 6));
        n3[this.o++] = (byte)(0x80 | (b & 0x3F));
    }
    
    @Override
    public void a(final long n) {
        this.h("write number");
        if (this.d) {
            this.b(n);
            return;
        }
        if (21 + this.o >= this.p) {
            this.o();
        }
        this.o = org.codehaus.jackson.b.h.a(n, this.n, this.o);
    }
    
    @Override
    public final void a(final String s) {
        boolean b = true;
        final int a = this.e.a(s);
        if (a == 4) {
            this.i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (a != (b ? 1 : 0)) {
                b = false;
            }
            this.a(s, b);
            return;
        }
        if (a == (b ? 1 : 0)) {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 44;
        }
        this.j(s);
    }
    
    protected final void a(final String s, final int n) {
        switch (n) {
            default: {
                this.m();
                break;
            }
            case 1: {
                this.a.f(this);
            }
            case 2: {
                this.a.d(this);
            }
            case 3: {
                this.a.a(this);
            }
            case 0: {
                if (this.e.a()) {
                    this.a.g(this);
                    return;
                }
                if (this.e.c()) {
                    this.a.h(this);
                    return;
                }
                break;
            }
        }
    }
    
    @Override
    public final void a(final String s, final String s2) {
        this.a(s);
        this.b(s2);
    }
    
    protected final void a(final String s, final boolean b) {
        if (b) {
            this.a.c(this);
        }
        else {
            this.a.h(this);
        }
        if (this.a(org.codehaus.jackson.g.c)) {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 34;
            final int length = s.length();
            if (length <= this.s) {
                s.getChars(0, length, this.r, 0);
                if (length <= this.q) {
                    if (length + this.o > this.p) {
                        this.o();
                    }
                    this.f(this.r, 0, length);
                }
                else {
                    this.e(this.r, 0, length);
                }
            }
            else {
                this.l(s);
            }
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 34;
            return;
        }
        this.l(s);
    }
    
    @Override
    public void a(final BigDecimal bigDecimal) {
        this.h("write number");
        if (bigDecimal == null) {
            this.p();
            return;
        }
        if (this.d) {
            this.c(bigDecimal);
            return;
        }
        this.c(bigDecimal.toString());
    }
    
    @Override
    public void a(final BigInteger bigInteger) {
        this.h("write number");
        if (bigInteger == null) {
            this.p();
            return;
        }
        if (this.d) {
            this.c(bigInteger);
            return;
        }
        this.c(bigInteger.toString());
    }
    
    @Override
    public void a(final a a, final byte[] array, final int n, final int n2) {
        this.h("write binary value");
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.b(a, array, n, n + n2);
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    @Override
    public final void a(final k k) {
        boolean b = true;
        final int a = this.e.a(k.a());
        if (a == 4) {
            this.i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (a != (b ? 1 : 0)) {
                b = false;
            }
            this.a(k, b);
            return;
        }
        if (a == (b ? 1 : 0)) {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 44;
        }
        this.c(k);
    }
    
    @Override
    public final void a(final s s) {
        boolean b = true;
        final int a = this.e.a(s.a());
        if (a == 4) {
            this.i("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            if (a != (b ? 1 : 0)) {
                b = false;
            }
            this.a(s, b);
            return;
        }
        if (a == (b ? 1 : 0)) {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 44;
        }
        this.c(s);
    }
    
    protected final void a(final s s, final boolean b) {
        if (b) {
            this.a.c(this);
        }
        else {
            this.a.h(this);
        }
        final boolean a = this.a(org.codehaus.jackson.g.c);
        if (a) {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 34;
        }
        this.b(s.d());
        if (a) {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 34;
        }
    }
    
    @Override
    public void a(final boolean b) {
        this.h("write boolean value");
        if (5 + this.o >= this.p) {
            this.o();
        }
        byte[] array;
        if (b) {
            array = org.codehaus.jackson.a.i.v;
        }
        else {
            array = org.codehaus.jackson.a.i.w;
        }
        final int length = array.length;
        System.arraycopy(array, 0, this.n, this.o, length);
        this.o += length;
    }
    
    @Override
    public void a(final char[] array, final int n, final int n2) {
        this.h("write text value");
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        if (n2 <= this.q) {
            if (n2 + this.o > this.p) {
                this.o();
            }
            this.f(array, n, n2);
        }
        else {
            this.e(array, n, n2);
        }
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    protected final int b(final int i, final int j) {
        if (j < 56320 || j > 57343) {
            this.i("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(j));
        }
        return 65536 + (i - 55296 << 10) + (j - 56320);
    }
    
    @Override
    public final void b() {
        this.h("start an array");
        this.e = this.e.h();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 91;
    }
    
    @Override
    public void b(final int n) {
        this.h("write number");
        if (11 + this.o >= this.p) {
            this.o();
        }
        if (this.d) {
            this.c(n);
            return;
        }
        this.o = org.codehaus.jackson.b.h.a(n, this.n, this.o);
    }
    
    @Override
    public void b(final String s) {
        this.h("write text value");
        if (s == null) {
            this.p();
            return;
        }
        final int length = s.length();
        if (length > this.s) {
            this.k(s);
            return;
        }
        s.getChars(0, length, this.r, 0);
        if (length > this.q) {
            this.c(this.r, 0, length);
            return;
        }
        if (length + this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.f(this.r, 0, length);
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    protected void b(final a a, final byte[] array, int i, final int n) {
        final int n2 = n - 3;
        final int n3 = -6 + this.p;
        int n4 = a.c() >> 2;
        while (i <= n2) {
            if (this.o > n3) {
                this.o();
            }
            final int n5 = i + 1;
            final int n6 = array[i] << 8;
            final int n7 = n5 + 1;
            final int n8 = (n6 | (0xFF & array[n5])) << 8;
            i = n7 + 1;
            this.o = a.a(n8 | (0xFF & array[n7]), this.n, this.o);
            if (--n4 <= 0) {
                this.n[this.o++] = 92;
                this.n[this.o++] = 110;
                n4 = a.c() >> 2;
            }
        }
        final int n9 = n - i;
        if (n9 > 0) {
            if (this.o > n3) {
                this.o();
            }
            final int n10 = i + 1;
            int n11 = array[i] << 16;
            if (n9 == 2) {
                n11 |= (0xFF & array[n10]) << 8;
            }
            this.o = a.a(n11, n9, this.n, this.o);
        }
    }
    
    @Override
    public final void b(final s s) {
        this.h("write text value");
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        this.b(s.d());
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    @Override
    public final void b(final char[] array, final int n, final int n2) {
        final int n3 = n2 + (n2 + n2);
        Label_0042: {
            if (n3 + this.o <= this.p) {
                break Label_0042;
            }
            if (this.p >= n3) {
                this.o();
                break Label_0042;
            }
            this.d(array, n, n2);
            return;
        }
        final int n4 = n2 + n;
        int i = n;
    Label_0050:
        while (i < n4) {
            do {
                final char c = array[i];
                if (c > '\u007f') {
                    final int n5 = i + 1;
                    final char c2 = array[i];
                    if (c2 < '\u0800') {
                        this.n[this.o++] = (byte)('\u00c0' | c2 >> 6);
                        this.n[this.o++] = (byte)('\u0080' | (c2 & '?'));
                    }
                    else {
                        this.a(c2, array, n5, n4);
                    }
                    i = n5;
                    continue Label_0050;
                }
                this.n[this.o++] = (byte)c;
            } while (++i < n4);
        }
    }
    
    @Override
    public final void c() {
        if (!this.e.a()) {
            this.i("Current context not an ARRAY but " + this.e.d());
        }
        if (this.a != null) {
            this.a.b(this, this.e.e());
        }
        else {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 93;
        }
        this.e = this.e.j();
    }
    
    @Override
    public void c(final String s) {
        int i = s.length();
        int srcBegin = 0;
        while (i > 0) {
            final char[] r = this.r;
            int length = r.length;
            if (i < length) {
                length = i;
            }
            s.getChars(srcBegin, srcBegin + length, r, 0);
            this.b(r, 0, length);
            srcBegin += length;
            i -= length;
        }
    }
    
    protected final void c(final s s) {
        final byte[] d = s.d();
        if (!this.a(org.codehaus.jackson.g.c)) {
            this.b(d);
            return;
        }
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        final int length = d.length;
        if (1 + (length + this.o) < this.p) {
            System.arraycopy(d, 0, this.n, this.o, length);
            this.o += length;
            this.n[this.o++] = 34;
            return;
        }
        this.b(d);
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    @Override
    public void close() {
        super.close();
        if (this.n != null && this.a(org.codehaus.jackson.g.b)) {
            while (true) {
                final org.codehaus.jackson.a.g h = this.h();
                if (h.a()) {
                    this.c();
                }
                else {
                    if (!h.c()) {
                        break;
                    }
                    this.e();
                }
            }
        }
        this.o();
        if (this.j != null) {
            if (this.i.c() || this.a(org.codehaus.jackson.g.a)) {
                this.j.close();
            }
            else if (this.a(org.codehaus.jackson.g.f)) {
                this.j.flush();
            }
        }
        this.n();
    }
    
    @Override
    public final void d() {
        this.h("start an object");
        this.e = this.e.i();
        if (this.a != null) {
            this.a.b(this);
            return;
        }
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 123;
    }
    
    @Override
    public final void e() {
        if (!this.e.c()) {
            this.i("Current context not an object but " + this.e.d());
        }
        if (this.a != null) {
            this.a.a(this, this.e.e());
        }
        else {
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o++] = 125;
        }
        this.e = this.e.j();
    }
    
    @Override
    public void e(final String s) {
        this.h("write number");
        if (this.d) {
            this.c((Object)s);
            return;
        }
        this.c(s);
    }
    
    @Override
    public void f() {
        this.h("write null value");
        this.p();
    }
    
    @Override
    public final void g() {
        this.o();
        if (this.j != null && this.a(org.codehaus.jackson.g.f)) {
            this.j.flush();
        }
    }
    
    @Override
    protected final void h(final String str) {
        final int k = this.e.k();
        if (k == 5) {
            this.i("Can not " + str + ", expecting field name");
        }
        if (this.a == null) {
            byte b = 0;
            switch (k) {
                default: {
                    return;
                }
                case 1: {
                    b = 44;
                    break;
                }
                case 2: {
                    b = 58;
                    break;
                }
                case 3: {
                    b = 32;
                    break;
                }
            }
            if (this.o >= this.p) {
                this.o();
            }
            this.n[this.o] = b;
            ++this.o;
            return;
        }
        this.a(str, k);
    }
    
    protected final void j(final String s) {
        if (!this.a(org.codehaus.jackson.g.c)) {
            this.l(s);
            return;
        }
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
        final int length = s.length();
        if (length <= this.s) {
            s.getChars(0, length, this.r, 0);
            if (length <= this.q) {
                if (length + this.o > this.p) {
                    this.o();
                }
                this.f(this.r, 0, length);
            }
            else {
                this.e(this.r, 0, length);
            }
        }
        else {
            this.l(s);
        }
        if (this.o >= this.p) {
            this.o();
        }
        this.n[this.o++] = 34;
    }
    
    protected void n() {
        final byte[] n = this.n;
        if (n != null && this.t) {
            this.n = null;
            this.i.b(n);
        }
        final char[] r = this.r;
        if (r != null) {
            this.r = null;
            this.i.b(r);
        }
    }
    
    protected final void o() {
        final int o = this.o;
        if (o > 0) {
            this.o = 0;
            this.j.write(this.n, 0, o);
        }
    }
}
