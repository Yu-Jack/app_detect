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
import org.codehaus.jackson.g;
import org.codehaus.jackson.q;
import org.codehaus.jackson.g.e;
import org.codehaus.jackson.s;
import org.codehaus.jackson.b.b;
import java.io.Writer;

public final class k extends c
{
    protected static final char[] g;
    protected static final int[] h;
    protected final org.codehaus.jackson.b.c i;
    protected final Writer j;
    protected int[] k;
    protected int l;
    protected b m;
    protected s n;
    protected char[] o;
    protected int p;
    protected int q;
    protected int r;
    protected char[] s;
    
    static {
        g = e.g();
        h = e.f();
    }
    
    public k(final org.codehaus.jackson.b.c i, final int n, final q q, final Writer j) {
        super(n, q);
        this.k = org.codehaus.jackson.a.k.h;
        this.p = 0;
        this.q = 0;
        this.i = i;
        this.j = j;
        this.o = i.h();
        this.r = this.o.length;
        if (this.a(org.codehaus.jackson.g.g)) {
            this.a(127);
        }
    }
    
    private final int a(final char[] dst, final int n, final int n2, char c, final int n3) {
        if (n3 >= 0) {
            if (n > 1 && n < n2) {
                final int n4 = n - 2;
                dst[n4] = '\\';
                dst[n4 + 1] = (char)n3;
                return n4;
            }
            char[] array = this.s;
            if (array == null) {
                array = this.q();
            }
            array[1] = (char)n3;
            this.j.write(array, 0, 2);
            return n;
        }
        else if (n3 != -2) {
            if (n > 5 && n < n2) {
                final int n5 = n - 6;
                final int n6 = n5 + 1;
                dst[n5] = '\\';
                final int n7 = n6 + 1;
                dst[n6] = 'u';
                int n9;
                if (c > '\u00ff') {
                    final char c2 = (char)('\u00ff' & c >> 8);
                    final int n8 = n7 + 1;
                    dst[n7] = org.codehaus.jackson.a.k.g[c2 >> 4];
                    n9 = n8 + 1;
                    dst[n8] = org.codehaus.jackson.a.k.g[c2 & '\u000f'];
                    c &= '\u00ff';
                }
                else {
                    final int n10 = n7 + 1;
                    dst[n7] = '0';
                    n9 = n10 + 1;
                    dst[n10] = '0';
                }
                final int n11 = n9 + 1;
                dst[n9] = org.codehaus.jackson.a.k.g[c >> 4];
                dst[n11] = org.codehaus.jackson.a.k.g[c & '\u000f'];
                return n11 - 5;
            }
            char[] array2 = this.s;
            if (array2 == null) {
                array2 = this.q();
            }
            this.p = this.q;
            if (c > '\u00ff') {
                final char c3 = (char)('\u00ff' & c >> 8);
                final char c4 = (char)(c & '\u00ff');
                array2[10] = org.codehaus.jackson.a.k.g[c3 >> 4];
                array2[11] = org.codehaus.jackson.a.k.g[c3 & '\u000f'];
                array2[12] = org.codehaus.jackson.a.k.g[c4 >> 4];
                array2[13] = org.codehaus.jackson.a.k.g[c4 & '\u000f'];
                this.j.write(array2, 8, 6);
                return n;
            }
            array2[6] = org.codehaus.jackson.a.k.g[c >> 4];
            array2[7] = org.codehaus.jackson.a.k.g[c & '\u000f'];
            this.j.write(array2, 2, 6);
            return n;
        }
        else {
            String str;
            if (this.n == null) {
                str = this.m.a(c).a();
            }
            else {
                str = this.n.a();
                this.n = null;
            }
            final int length = str.length();
            if (n >= length && n < n2) {
                final int dstBegin = n - length;
                str.getChars(0, length, dst, dstBegin);
                return dstBegin;
            }
            this.j.write(str);
            return n;
        }
    }
    
    private final void a(char c, final int n) {
        if (n >= 0) {
            if (this.q >= 2) {
                final int p2 = -2 + this.q;
                this.p = p2;
                final char[] o = this.o;
                final int n2 = p2 + 1;
                o[p2] = '\\';
                this.o[n2] = (char)n;
                return;
            }
            char[] array = this.s;
            if (array == null) {
                array = this.q();
            }
            this.p = this.q;
            array[1] = (char)n;
            this.j.write(array, 0, 2);
        }
        else if (n != -2) {
            if (this.q >= 6) {
                final char[] o2 = this.o;
                final int p3 = -6 + this.q;
                o2[this.p = p3] = '\\';
                final int n3 = p3 + 1;
                o2[n3] = 'u';
                int n5;
                if (c > '\u00ff') {
                    final char c2 = (char)('\u00ff' & c >> 8);
                    final int n4 = n3 + 1;
                    o2[n4] = org.codehaus.jackson.a.k.g[c2 >> 4];
                    n5 = n4 + 1;
                    o2[n5] = org.codehaus.jackson.a.k.g[c2 & '\u000f'];
                    c &= '\u00ff';
                }
                else {
                    final int n6 = n3 + 1;
                    o2[n6] = '0';
                    n5 = n6 + 1;
                    o2[n5] = '0';
                }
                final int n7 = n5 + 1;
                o2[n7] = org.codehaus.jackson.a.k.g[c >> 4];
                o2[n7 + 1] = org.codehaus.jackson.a.k.g[c & '\u000f'];
                return;
            }
            char[] array2 = this.s;
            if (array2 == null) {
                array2 = this.q();
            }
            this.p = this.q;
            if (c > '\u00ff') {
                final char c3 = (char)('\u00ff' & c >> 8);
                final char c4 = (char)(c & '\u00ff');
                array2[10] = org.codehaus.jackson.a.k.g[c3 >> 4];
                array2[11] = org.codehaus.jackson.a.k.g[c3 & '\u000f'];
                array2[12] = org.codehaus.jackson.a.k.g[c4 >> 4];
                array2[13] = org.codehaus.jackson.a.k.g[c4 & '\u000f'];
                this.j.write(array2, 8, 6);
                return;
            }
            array2[6] = org.codehaus.jackson.a.k.g[c >> 4];
            array2[7] = org.codehaus.jackson.a.k.g[c & '\u000f'];
            this.j.write(array2, 2, 6);
        }
        else {
            String str;
            if (this.n == null) {
                str = this.m.a(c).a();
            }
            else {
                str = this.n.a();
                this.n = null;
            }
            final int length = str.length();
            if (this.q >= length) {
                final int n8 = this.q - length;
                this.p = n8;
                str.getChars(0, length, this.o, n8);
                return;
            }
            this.p = this.q;
            this.j.write(str);
        }
    }
    
    private void a(final int n, final int n2) {
        final int n3 = n + this.q;
        final int[] k = this.k;
        final int min = Math.min(k.length, n2 + 1);
    Label_0024:
        while (this.q < n3) {
            do {
                final char c = this.o[this.q];
                int n4;
                if (c < min) {
                    n4 = k[c];
                    if (n4 == 0) {
                        continue;
                    }
                }
                else {
                    if (c <= n2) {
                        continue;
                    }
                    n4 = -1;
                }
                final int n5 = this.q - this.p;
                if (n5 > 0) {
                    this.j.write(this.o, this.p, n5);
                }
                ++this.q;
                this.a(c, n4);
                continue Label_0024;
            } while (++this.q < n3);
            break;
        }
    }
    
    private final void a(final char[] array, final int n, final int n2, final int n3) {
        final int n4 = n2 + n;
        final int[] k = this.k;
        final int min = Math.min(k.length, n3 + 1);
        int n5 = 0;
        int i = n;
    Label_0065_Outer:
        while (i < n4) {
            int n6 = i;
            while (true) {
                do {
                    final char c = array[n6];
                    if (c < min) {
                        n5 = k[c];
                        if (n5 == 0) {
                            continue Label_0065_Outer;
                        }
                    }
                    else {
                        if (c <= n3) {
                            continue Label_0065_Outer;
                        }
                        n5 = -1;
                    }
                    final int n7 = n6 - i;
                    if (n7 < 32) {
                        if (n7 + this.q > this.r) {
                            this.o();
                        }
                        if (n7 > 0) {
                            System.arraycopy(array, i, this.o, this.q, n7);
                            this.q += n7;
                        }
                    }
                    else {
                        this.o();
                        this.j.write(array, i, n7);
                    }
                    if (n6 >= n4) {
                        break Label_0065_Outer;
                    }
                    i = n6 + 1;
                    this.b(c, n5);
                    continue Label_0065_Outer;
                } while (++n6 < n4);
                continue;
            }
        }
    }
    
    private final void b(char c, final int n) {
        if (n >= 0) {
            if (2 + this.q > this.r) {
                this.o();
            }
            this.o[this.q++] = '\\';
            this.o[this.q++] = (char)n;
            return;
        }
        if (n != -2) {
            if (2 + this.q > this.r) {
                this.o();
            }
            final int q = this.q;
            final char[] o = this.o;
            final int n2 = q + 1;
            o[q] = '\\';
            final int n3 = n2 + 1;
            o[n2] = 'u';
            int n5;
            if (c > '\u00ff') {
                final char c2 = (char)('\u00ff' & c >> 8);
                final int n4 = n3 + 1;
                o[n3] = org.codehaus.jackson.a.k.g[c2 >> 4];
                n5 = n4 + 1;
                o[n4] = org.codehaus.jackson.a.k.g[c2 & '\u000f'];
                c &= '\u00ff';
            }
            else {
                final int n6 = n3 + 1;
                o[n3] = '0';
                n5 = n6 + 1;
                o[n6] = '0';
            }
            final int q2 = n5 + 1;
            o[n5] = org.codehaus.jackson.a.k.g[c >> 4];
            o[q2] = org.codehaus.jackson.a.k.g[c & '\u000f'];
            this.q = q2;
            return;
        }
        String str;
        if (this.n == null) {
            str = this.m.a(c).a();
        }
        else {
            str = this.n.a();
            this.n = null;
        }
        final int length = str.length();
        if (length + this.q > this.r) {
            this.o();
            if (length > this.r) {
                this.j.write(str);
                return;
            }
        }
        str.getChars(0, length, this.o, this.q);
        this.q += length;
    }
    
    private final void b(final int n, final int n2) {
        int n3 = 0;
        final int[] k = this.k;
        final int min = Math.min(k.length, n2 + 1);
        int n4 = 0;
        int i = 0;
    Label_0059_Outer:
        while (i < n) {
            while (true) {
                do {
                    final char c = this.o[i];
                    int n5;
                    if (c < min) {
                        n5 = k[c];
                        if (n5 == 0) {
                            n3 = n5;
                            continue Label_0059_Outer;
                        }
                    }
                    else {
                        if (c <= n2) {
                            continue Label_0059_Outer;
                        }
                        n5 = -1;
                    }
                    final int n6 = i - n4;
                    if (n6 > 0) {
                        this.j.write(this.o, n4, n6);
                        if (i >= n) {
                            break Label_0059_Outer;
                        }
                    }
                    final int n7 = i + 1;
                    final int a = this.a(this.o, n7, n, c, n5);
                    i = n7;
                    n4 = a;
                    n3 = n5;
                    continue Label_0059_Outer;
                } while (++i < n);
                int n5 = n3;
                continue;
            }
        }
    }
    
    private final void b(final long n) {
        if (23 + this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        this.q = org.codehaus.jackson.b.h.a(n, this.o, this.q);
        this.o[this.q++] = '\"';
    }
    
    private final void c(final int n) {
        if (13 + this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        this.q = org.codehaus.jackson.b.h.a(n, this.o, this.q);
        this.o[this.q++] = '\"';
    }
    
    private final void c(final Object o) {
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        this.c(o.toString());
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
    }
    
    private final void c(final char[] array, final int n, final int n2) {
        if (this.m != null) {
            this.d(array, n, n2);
        }
        else {
            if (this.l != 0) {
                this.a(array, n, n2, this.l);
                return;
            }
            final int n3 = n2 + n;
            final int[] k = this.k;
            final int length = k.length;
            int i = n;
            while (i < n3) {
                int n4 = i;
                char c;
                do {
                    c = array[n4];
                } while ((c >= length || k[c] == 0) && ++n4 < n3);
                final int n5 = n4 - i;
                if (n5 < 32) {
                    if (n5 + this.q > this.r) {
                        this.o();
                    }
                    if (n5 > 0) {
                        System.arraycopy(array, i, this.o, this.q, n5);
                        this.q += n5;
                    }
                }
                else {
                    this.o();
                    this.j.write(array, i, n5);
                }
                if (n4 >= n3) {
                    break;
                }
                i = n4 + 1;
                final char c2 = array[n4];
                this.b(c2, k[c2]);
            }
        }
    }
    
    private void d(final int n) {
        final int n2 = n + this.q;
        final int[] k = this.k;
        final int length = k.length;
    Label_0016:
        while (this.q < n2) {
            do {
                final char c = this.o[this.q];
                if (c < length && k[c] != 0) {
                    final int n3 = this.q - this.p;
                    if (n3 > 0) {
                        this.j.write(this.o, this.p, n3);
                    }
                    final char c2 = this.o[this.q++];
                    this.a(c2, k[c2]);
                    continue Label_0016;
                }
            } while (++this.q < n2);
            break;
        }
    }
    
    private final void d(final char[] array, final int n, final int n2) {
        final int n3 = n2 + n;
        final int[] k = this.k;
        int l;
        if (this.l < 1) {
            l = 65535;
        }
        else {
            l = this.l;
        }
        final int min = Math.min(k.length, l + '\u0001');
        final b m = this.m;
        int n4 = 0;
        int i = n;
    Label_0083_Outer:
        while (i < n3) {
            int n5 = i;
            while (true) {
                do {
                    final char c = array[n5];
                    if (c < min) {
                        n4 = k[c];
                        if (n4 == 0) {
                            continue Label_0083_Outer;
                        }
                    }
                    else if (c > l) {
                        n4 = -1;
                    }
                    else {
                        if ((this.n = m.a(c)) == null) {
                            continue Label_0083_Outer;
                        }
                        n4 = -2;
                    }
                    final int n6 = n5 - i;
                    if (n6 < 32) {
                        if (n6 + this.q > this.r) {
                            this.o();
                        }
                        if (n6 > 0) {
                            System.arraycopy(array, i, this.o, this.q, n6);
                            this.q += n6;
                        }
                    }
                    else {
                        this.o();
                        this.j.write(array, i, n6);
                    }
                    if (n5 >= n3) {
                        break Label_0083_Outer;
                    }
                    i = n5 + 1;
                    this.b(c, n4);
                    continue Label_0083_Outer;
                } while (++n5 < n3);
                continue;
            }
        }
    }
    
    private final void e(final int n) {
        final int[] k = this.k;
        final int length = k.length;
        int i = 0;
        int a = 0;
        while (i < n) {
            char c;
            do {
                c = this.o[i];
            } while ((c >= length || k[c] == 0) && ++i < n);
            final int n2 = i - a;
            if (n2 > 0) {
                this.j.write(this.o, a, n2);
                if (i >= n) {
                    break;
                }
            }
            final int n3 = i + 1;
            a = this.a(this.o, n3, n, c, k[c]);
            i = n3;
        }
    }
    
    private void f(final int n) {
        final int n2 = n + this.q;
        final int[] k = this.k;
        int l;
        if (this.l < 1) {
            l = 65535;
        }
        else {
            l = this.l;
        }
        final int min = Math.min(k.length, l + '\u0001');
        final b m = this.m;
    Label_0041:
        while (this.q < n2) {
            do {
                final char c = this.o[this.q];
                int n3;
                if (c < min) {
                    n3 = k[c];
                    if (n3 == 0) {
                        continue;
                    }
                }
                else if (c > l) {
                    n3 = -1;
                }
                else {
                    if ((this.n = m.a(c)) == null) {
                        continue;
                    }
                    n3 = -2;
                }
                final int n4 = this.q - this.p;
                if (n4 > 0) {
                    this.j.write(this.o, this.p, n4);
                }
                ++this.q;
                this.a(c, n3);
                continue Label_0041;
            } while (++this.q < n2);
            break;
        }
    }
    
    private final void g(final int n) {
        int i = 0;
        final int[] k = this.k;
        int l;
        if (this.l < 1) {
            l = 65535;
        }
        else {
            l = this.l;
        }
        final int min = Math.min(k.length, l + '\u0001');
        final b m = this.m;
        int n2 = 0;
        int n3 = 0;
    Label_0073_Outer:
        while (i < n) {
            while (true) {
                do {
                    final char c = this.o[i];
                    int n4;
                    if (c < min) {
                        n4 = k[c];
                        if (n4 == 0) {
                            n3 = n4;
                            continue Label_0073_Outer;
                        }
                    }
                    else if (c > l) {
                        n4 = -1;
                    }
                    else {
                        if ((this.n = m.a(c)) == null) {
                            continue Label_0073_Outer;
                        }
                        n4 = -2;
                    }
                    final int n5 = i - n2;
                    if (n5 > 0) {
                        this.j.write(this.o, n2, n5);
                        if (i >= n) {
                            break Label_0073_Outer;
                        }
                    }
                    final int n6 = i + 1;
                    final int a = this.a(this.o, n6, n, c, n4);
                    i = n6;
                    n2 = a;
                    n3 = n4;
                    continue Label_0073_Outer;
                } while (++i < n);
                int n4 = n3;
                continue;
            }
        }
    }
    
    private void j(final String s) {
        int srcBegin = this.r - this.q;
        s.getChars(0, srcBegin, this.o, this.q);
        this.q += srcBegin;
        this.o();
        int i;
        int r;
        for (i = s.length() - srcBegin; i > this.r; i -= r) {
            r = this.r;
            s.getChars(srcBegin, srcBegin + r, this.o, 0);
            this.p = 0;
            this.q = r;
            this.o();
            srcBegin += r;
        }
        s.getChars(srcBegin, srcBegin + i, this.o, 0);
        this.p = 0;
        this.q = i;
    }
    
    private void k(final String s) {
        final int length = s.length();
        if (length > this.r) {
            this.l(s);
            return;
        }
        if (length + this.q > this.r) {
            this.o();
        }
        s.getChars(0, length, this.o, this.q);
        if (this.m != null) {
            this.f(length);
            return;
        }
        if (this.l != 0) {
            this.a(length, this.l);
            return;
        }
        this.d(length);
    }
    
    private void l(final String s) {
        this.o();
        final int length = s.length();
        int srcBegin = 0;
        do {
            int r = this.r;
            if (srcBegin + r > length) {
                r = length - srcBegin;
            }
            s.getChars(srcBegin, srcBegin + r, this.o, 0);
            if (this.m != null) {
                this.g(r);
            }
            else if (this.l != 0) {
                this.b(r, this.l);
            }
            else {
                this.e(r);
            }
            srcBegin += r;
        } while (srcBegin < length);
    }
    
    private final void p() {
        if (4 + this.q >= this.r) {
            this.o();
        }
        final int q = this.q;
        final char[] o = this.o;
        o[q] = 'n';
        final int n = q + 1;
        o[n] = 'u';
        final int n2 = n + 1;
        o[n2] = 'l';
        final int n3 = n2 + 1;
        o[n3] = 'l';
        this.q = n3 + 1;
    }
    
    private char[] q() {
        return this.s = new char[] { '\\', '\0', '\\', 'u', '0', '0', '\0', '\0', '\\', 'u', '\0', '\0', '\0', '\0' };
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
            this.k = org.codehaus.jackson.a.k.h;
            return this;
        }
        this.k = m.a();
        return this;
    }
    
    @Override
    public void a(final char c) {
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = c;
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
    
    @Override
    public void a(final long n) {
        this.h("write number");
        if (this.d) {
            this.b(n);
            return;
        }
        if (21 + this.q >= this.r) {
            this.o();
        }
        this.q = org.codehaus.jackson.b.h.a(n, this.o, this.q);
    }
    
    @Override
    public final void a(final String s) {
        boolean b = true;
        final int a = this.e.a(s);
        if (a == 4) {
            this.i("Can not write a field name, expecting a value");
        }
        if (a != (b ? 1 : 0)) {
            b = false;
        }
        this.a(s, b);
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
    
    protected void a(final String s, final boolean b) {
        if (this.a != null) {
            this.b(s, b);
            return;
        }
        if (1 + this.q >= this.r) {
            this.o();
        }
        if (b) {
            this.o[this.q++] = ',';
        }
        if (!this.a(org.codehaus.jackson.g.c)) {
            this.k(s);
            return;
        }
        this.o[this.q++] = '\"';
        this.k(s);
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
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
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        this.b(a, array, n, n + n2);
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
    }
    
    @Override
    public final void a(final org.codehaus.jackson.b.k k) {
        boolean b = true;
        final int a = this.e.a(k.a());
        if (a == 4) {
            this.i("Can not write a field name, expecting a value");
        }
        if (a != (b ? 1 : 0)) {
            b = false;
        }
        this.a(k, b);
    }
    
    @Override
    public final void a(final s s) {
        boolean b = true;
        final int a = this.e.a(s.a());
        if (a == 4) {
            this.i("Can not write a field name, expecting a value");
        }
        if (a != (b ? 1 : 0)) {
            b = false;
        }
        this.a(s, b);
    }
    
    public void a(final s s, final boolean b) {
        if (this.a != null) {
            this.b(s, b);
            return;
        }
        if (1 + this.q >= this.r) {
            this.o();
        }
        if (b) {
            this.o[this.q++] = ',';
        }
        final char[] b2 = s.b();
        if (!this.a(org.codehaus.jackson.g.c)) {
            this.b(b2, 0, b2.length);
            return;
        }
        this.o[this.q++] = '\"';
        final int length = b2.length;
        if (1 + (length + this.q) >= this.r) {
            this.b(b2, 0, length);
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = '\"';
            return;
        }
        System.arraycopy(b2, 0, this.o, this.q, length);
        this.q += length;
        this.o[this.q++] = '\"';
    }
    
    @Override
    public void a(final boolean b) {
        this.h("write boolean value");
        if (5 + this.q >= this.r) {
            this.o();
        }
        final int q = this.q;
        final char[] o = this.o;
        int n3;
        if (b) {
            o[q] = 't';
            final int n = q + 1;
            o[n] = 'r';
            final int n2 = n + 1;
            o[n2] = 'u';
            n3 = n2 + 1;
            o[n3] = 'e';
        }
        else {
            o[q] = 'f';
            final int n4 = q + 1;
            o[n4] = 'a';
            final int n5 = n4 + 1;
            o[n5] = 'l';
            final int n6 = n5 + 1;
            o[n6] = 's';
            n3 = n6 + 1;
            o[n3] = 'e';
        }
        this.q = n3 + 1;
    }
    
    @Override
    public void a(final char[] array, final int n, final int n2) {
        this.h("write text value");
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        this.c(array, n, n2);
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
    }
    
    @Override
    public final void b() {
        this.h("start an array");
        this.e = this.e.h();
        if (this.a != null) {
            this.a.e(this);
            return;
        }
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '[';
    }
    
    @Override
    public void b(final int n) {
        this.h("write number");
        if (this.d) {
            this.c(n);
            return;
        }
        if (11 + this.q >= this.r) {
            this.o();
        }
        this.q = org.codehaus.jackson.b.h.a(n, this.o, this.q);
    }
    
    @Override
    public void b(final String s) {
        this.h("write text value");
        if (s == null) {
            this.p();
            return;
        }
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        this.k(s);
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
    }
    
    protected final void b(final String s, final boolean b) {
        if (b) {
            this.a.c(this);
        }
        else {
            this.a.h(this);
        }
        if (this.a(org.codehaus.jackson.g.c)) {
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = '\"';
            this.k(s);
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = '\"';
            return;
        }
        this.k(s);
    }
    
    protected void b(final a a, final byte[] array, int i, final int n) {
        final int n2 = n - 3;
        final int n3 = -6 + this.r;
        int n4 = a.c() >> 2;
        while (i <= n2) {
            if (this.q > n3) {
                this.o();
            }
            final int n5 = i + 1;
            final int n6 = array[i] << 8;
            final int n7 = n5 + 1;
            final int n8 = (n6 | (0xFF & array[n5])) << 8;
            i = n7 + 1;
            this.q = a.a(n8 | (0xFF & array[n7]), this.o, this.q);
            if (--n4 <= 0) {
                this.o[this.q++] = '\\';
                this.o[this.q++] = 'n';
                n4 = a.c() >> 2;
            }
        }
        final int n9 = n - i;
        if (n9 > 0) {
            if (this.q > n3) {
                this.o();
            }
            final int n10 = i + 1;
            int n11 = array[i] << 16;
            if (n9 == 2) {
                n11 |= (0xFF & array[n10]) << 8;
            }
            this.q = a.a(n11, n9, this.o, this.q);
        }
    }
    
    @Override
    public final void b(final s s) {
        this.h("write text value");
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
        final char[] b = s.b();
        final int length = b.length;
        if (length < 32) {
            if (length > this.r - this.q) {
                this.o();
            }
            System.arraycopy(b, 0, this.o, this.q, length);
            this.q += length;
        }
        else {
            this.o();
            this.j.write(b, 0, length);
        }
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '\"';
    }
    
    protected final void b(final s s, final boolean b) {
        if (b) {
            this.a.c(this);
        }
        else {
            this.a.h(this);
        }
        final char[] b2 = s.b();
        if (this.a(org.codehaus.jackson.g.c)) {
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = '\"';
            this.b(b2, 0, b2.length);
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = '\"';
            return;
        }
        this.b(b2, 0, b2.length);
    }
    
    @Override
    public void b(final char[] array, final int n, final int n2) {
        if (n2 < 32) {
            if (n2 > this.r - this.q) {
                this.o();
            }
            System.arraycopy(array, n, this.o, this.q, n2);
            this.q += n2;
            return;
        }
        this.o();
        this.j.write(array, n, n2);
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
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = ']';
        }
        this.e = this.e.j();
    }
    
    @Override
    public void c(final String s) {
        final int length = s.length();
        int n = this.r - this.q;
        if (n == 0) {
            this.o();
            n = this.r - this.q;
        }
        if (n >= length) {
            s.getChars(0, length, this.o, this.q);
            this.q += length;
            return;
        }
        this.j(s);
    }
    
    @Override
    public void close() {
        super.close();
        if (this.o != null && this.a(org.codehaus.jackson.g.b)) {
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
        if (this.q >= this.r) {
            this.o();
        }
        this.o[this.q++] = '{';
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
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q++] = '}';
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
            char c = '\0';
            switch (k) {
                default: {
                    return;
                }
                case 1: {
                    c = ',';
                    break;
                }
                case 2: {
                    c = ':';
                    break;
                }
                case 3: {
                    c = ' ';
                    break;
                }
            }
            if (this.q >= this.r) {
                this.o();
            }
            this.o[this.q] = c;
            ++this.q;
            return;
        }
        this.a(str, k);
    }
    
    protected void n() {
        final char[] o = this.o;
        if (o != null) {
            this.o = null;
            this.i.b(o);
        }
    }
    
    protected final void o() {
        final int n = this.q - this.p;
        if (n > 0) {
            final int p = this.p;
            this.p = 0;
            this.q = 0;
            this.j.write(this.o, p, n);
        }
    }
}
