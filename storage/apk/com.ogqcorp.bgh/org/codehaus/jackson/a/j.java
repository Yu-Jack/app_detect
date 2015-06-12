// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import java.io.IOException;
import org.codehaus.jackson.p;
import org.codehaus.jackson.e.f;
import org.codehaus.jackson.l;
import org.codehaus.jackson.b.c;
import org.codehaus.jackson.g.e;
import java.io.InputStream;
import org.codehaus.jackson.e.a;
import org.codehaus.jackson.q;

public final class j extends d
{
    private static final int[] T;
    private static final int[] U;
    protected q M;
    protected final a N;
    protected int[] O;
    protected boolean P;
    protected InputStream Q;
    protected byte[] R;
    protected boolean S;
    private int V;
    
    static {
        T = org.codehaus.jackson.g.e.b();
        U = org.codehaus.jackson.g.e.a();
    }
    
    public j(final c c, final int n, final InputStream q, final q m, final a n2, final byte[] r, final int f, final int g, final boolean s) {
        super(c, n);
        this.O = new int[16];
        this.P = false;
        this.Q = q;
        this.M = m;
        this.N = n2;
        this.R = r;
        this.f = f;
        this.g = g;
        this.S = s;
        if (!org.codehaus.jackson.l.j.a(n)) {
            this.W();
        }
    }
    
    private final f a(final int n, final int n2, final int n3) {
        return this.a(this.O, 0, n, n2, n3);
    }
    
    private final f a(final int n, final int n2, final int n3, final int n4) {
        this.O[0] = n;
        return this.a(this.O, 1, n2, n3, n4);
    }
    
    private final f a(final int[] array, final int n, final int n2) {
        final int n3 = n2 + (-4 + (n << 2));
        int n4;
        if (n2 < 4) {
            n4 = array[n - 1];
            array[n - 1] = n4 << (4 - n2 << 3);
        }
        else {
            n4 = 0;
        }
        char[] value = this.p.k();
        int count = 0;
        int i = 0;
    Label_0375_Outer:
        while (i < n3) {
            int n5 = 0xFF & array[i >> 2] >> (3 - (i & 0x3) << 3);
            int n6 = i + 1;
            while (true) {
                Label_0527: {
                    if (n5 <= 127) {
                        break Label_0527;
                    }
                    int n7;
                    int n8;
                    if ((n5 & 0xE0) == 0xC0) {
                        n7 = (n5 & 0x1F);
                        n8 = 1;
                    }
                    else if ((n5 & 0xF0) == 0xE0) {
                        n7 = (n5 & 0xF);
                        n8 = 2;
                    }
                    else if ((n5 & 0xF8) == 0xF0) {
                        n7 = (n5 & 0x7);
                        n8 = 3;
                    }
                    else {
                        this.l(n5);
                        n7 = (n8 = 1);
                    }
                    if (n6 + n8 > n3) {
                        this.c(" in field name");
                    }
                    final int n9 = array[n6 >> 2] >> (3 - (n6 & 0x3) << 3);
                    ++n6;
                    if ((n9 & 0xC0) != 0x80) {
                        this.m(n9);
                    }
                    n5 = (n7 << 6 | (n9 & 0x3F));
                    if (n8 > 1) {
                        final int n10 = array[n6 >> 2] >> (3 - (n6 & 0x3) << 3);
                        ++n6;
                        if ((n10 & 0xC0) != 0x80) {
                            this.m(n10);
                        }
                        n5 = (n5 << 6 | (n10 & 0x3F));
                        if (n8 > 2) {
                            final int n11 = array[n6 >> 2] >> (3 - (n6 & 0x3) << 3);
                            ++n6;
                            if ((n11 & 0xC0) != 0x80) {
                                this.m(n11 & 0xFF);
                            }
                            n5 = (n5 << 6 | (n11 & 0x3F));
                        }
                    }
                    if (n8 <= 2) {
                        break Label_0527;
                    }
                    final int n12 = n5 - 65536;
                    if (count >= value.length) {
                        value = this.p.n();
                    }
                    final int n13 = count + 1;
                    value[count] = (char)(55296 + (n12 >> 10));
                    final int n14 = 0xDC00 | (n12 & 0x3FF);
                    final int n15 = n6;
                    final int n16 = n13;
                    char[] n17 = value;
                    final int n18 = n14;
                    if (n16 >= n17.length) {
                        n17 = this.p.n();
                    }
                    count = n16 + 1;
                    n17[n16] = (char)n18;
                    i = n15;
                    value = n17;
                    continue Label_0375_Outer;
                }
                char[] n17 = value;
                final int n18 = n5;
                final int n15 = n6;
                final int n16 = count;
                continue;
            }
        }
        final String s = new String(value, 0, count);
        if (n2 < 4) {
            array[n - 1] = n4;
        }
        return this.N.a(s, array, n);
    }
    
    private final f a(int[] a, final int n, final int n2, final int n3) {
        if (n >= a.length) {
            a = a(a, a.length);
            this.O = a;
        }
        final int n4 = n + 1;
        a[n] = n2;
        f f = this.N.a(a, n4);
        if (f == null) {
            f = this.a(a, n4, n3);
        }
        return f;
    }
    
    private final p a(char[] m, final int n, int n2, final boolean b, final int n3) {
        int n4 = 0;
        boolean b2 = false;
        int n7 = 0;
        int n8 = 0;
        char[] array = null;
        Label_0063: {
            if (n2 == 46) {
                int n5 = n + 1;
                m[n] = (char)n2;
                while (true) {
                    while (this.f < this.g || this.G()) {
                        n2 = (0xFF & this.R[this.f++]);
                        b2 = false;
                        if (n2 >= 48) {
                            b2 = false;
                            if (n2 <= 57) {
                                ++n4;
                                int n6;
                                if (n5 >= m.length) {
                                    m = this.p.m();
                                    n6 = 0;
                                }
                                else {
                                    n6 = n5;
                                }
                                n5 = n6 + 1;
                                m[n6] = (char)n2;
                                continue;
                            }
                        }
                        if (n4 == 0) {
                            this.a(n2, "Decimal point not followed by a digit");
                        }
                        n7 = n4;
                        n8 = n5;
                        array = m;
                        break Label_0063;
                    }
                    b2 = true;
                    continue;
                }
            }
            array = m;
            n8 = n;
            b2 = false;
            n7 = 0;
        }
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        Label_0348: {
            if (n2 == 101 || n2 == 69) {
                if (n8 >= array.length) {
                    array = this.p.m();
                    n8 = 0;
                }
                final int n9 = n8 + 1;
                array[n8] = (char)n2;
                if (this.f >= this.g) {
                    this.F();
                }
                int n10 = 0xFF & this.R[this.f++];
                int n13;
                int n14;
                if (n10 == 45 || n10 == 43) {
                    int n11;
                    if (n9 >= array.length) {
                        array = this.p.m();
                        n11 = 0;
                    }
                    else {
                        n11 = n9;
                    }
                    final int n12 = n11 + 1;
                    array[n11] = (char)n10;
                    if (this.f >= this.g) {
                        this.F();
                    }
                    n10 = (0xFF & this.R[this.f++]);
                    n13 = n12;
                    n14 = 0;
                }
                else {
                    n13 = n9;
                    n14 = 0;
                }
                while (true) {
                    while (n10 <= 57 && n10 >= 48) {
                        ++n14;
                        if (n13 >= array.length) {
                            array = this.p.m();
                            n13 = 0;
                        }
                        final int n15 = n13 + 1;
                        array[n13] = (char)n10;
                        if (this.f >= this.g && !this.G()) {
                            n16 = n14;
                            n17 = 1;
                            n18 = n15;
                            if (n16 == 0) {
                                this.a(n10, "Exponent indicator not followed by a digit");
                            }
                            break Label_0348;
                        }
                        else {
                            n10 = (0xFF & this.R[this.f++]);
                            n13 = n15;
                        }
                    }
                    n17 = (b2 ? 1 : 0);
                    final int n19 = n14;
                    n18 = n13;
                    n16 = n19;
                    continue;
                }
            }
            n17 = (b2 ? 1 : 0);
            n18 = n8;
            n16 = 0;
        }
        if (n17 == 0) {
            --this.f;
        }
        this.p.a(n18);
        return this.b(b, n3, n7, n16);
    }
    
    private final p a(final char[] array, final int n, final boolean b, final int n2) {
        int n3 = n2;
        int n4 = n;
        char[] m = array;
        while (this.f < this.g || this.G()) {
            final int n5 = 0xFF & this.R[this.f++];
            if (n5 > 57 || n5 < 48) {
                if (n5 == 46 || n5 == 101 || n5 == 69) {
                    return this.a(m, n4, n5, b, n3);
                }
                --this.f;
                this.p.a(n4);
                return this.a(b, n3);
            }
            else {
                int n6;
                if (n4 >= m.length) {
                    m = this.p.m();
                    n6 = 0;
                }
                else {
                    n6 = n4;
                }
                n4 = n6 + 1;
                m[n6] = (char)n5;
                ++n3;
            }
        }
        this.p.a(n4);
        return this.a(b, n3);
    }
    
    private final void a(char[] array, int n) {
        final int[] t = j.T;
        final byte[] r = this.R;
    Block_5:
        while (true) {
            int i = this.f;
            if (i >= this.g) {
                this.F();
                i = this.f;
            }
            if (n >= array.length) {
                array = this.p.m();
                n = 0;
            }
            while (i < Math.min(this.g, i + (array.length - n))) {
                final int f = i + 1;
                int n2 = 0xFF & r[i];
                if (t[n2] != 0) {
                    this.f = f;
                    if (n2 == 34) {
                        break Block_5;
                    }
                    switch (t[n2]) {
                        default: {
                            if (n2 < 32) {
                                this.c(n2, "string value");
                                break;
                            }
                            this.k(n2);
                            break;
                        }
                        case 1: {
                            n2 = this.S();
                            break;
                        }
                        case 2: {
                            n2 = this.o(n2);
                            break;
                        }
                        case 3: {
                            if (this.g - this.f >= 2) {
                                n2 = this.q(n2);
                                break;
                            }
                            n2 = this.p(n2);
                            break;
                        }
                        case 4: {
                            final int r2 = this.r(n2);
                            int n3 = n + 1;
                            array[n] = (char)(0xD800 | r2 >> 10);
                            if (n3 >= array.length) {
                                array = this.p.m();
                                n3 = 0;
                            }
                            final int n4 = 0xDC00 | (r2 & 0x3FF);
                            n = n3;
                            n2 = n4;
                            break;
                        }
                    }
                    int n5;
                    if (n >= array.length) {
                        array = this.p.m();
                        n5 = 0;
                    }
                    else {
                        n5 = n;
                    }
                    n = n5 + 1;
                    array[n5] = (char)n2;
                    continue Block_5;
                }
                else {
                    final int n6 = n + 1;
                    array[n] = (char)n2;
                    i = f;
                    n = n6;
                }
            }
            this.f = i;
        }
        this.p.a(n);
    }
    
    public static int[] a(final int[] array, final int n) {
        if (array == null) {
            return new int[n];
        }
        final int length = array.length;
        final int[] array2 = new int[length + n];
        System.arraycopy(array, 0, array2, 0, length);
        return array2;
    }
    
    private final p ae() {
        this.r = false;
        final p o = this.o;
        this.o = null;
        if (o == org.codehaus.jackson.p.d) {
            this.n = this.n.b(this.l, this.m);
        }
        else if (o == org.codehaus.jackson.p.b) {
            this.n = this.n.c(this.l, this.m);
        }
        return this.b = o;
    }
    
    private final int af() {
        int n;
        if (this.f >= this.g && !this.G()) {
            n = 48;
        }
        else {
            n = (0xFF & this.R[this.f]);
            if (n < 48 || n > 57) {
                return 48;
            }
            if (!this.a(org.codehaus.jackson.l.g)) {
                this.b("Leading zeroes not allowed");
            }
            ++this.f;
            if (n == 48) {
                while (this.f < this.g || this.G()) {
                    n = (0xFF & this.R[this.f]);
                    if (n < 48 || n > 57) {
                        return 48;
                    }
                    ++this.f;
                    if (n != 48) {
                        return n;
                    }
                }
            }
        }
        return n;
    }
    
    private final int ag() {
        while (this.f < this.g || this.G()) {
            final int n = 0xFF & this.R[this.f++];
            if (n > 32) {
                if (n != 47) {
                    return n;
                }
                this.ai();
            }
            else {
                if (n == 32) {
                    continue;
                }
                if (n == 10) {
                    this.ad();
                }
                else if (n == 13) {
                    this.ac();
                }
                else {
                    if (n == 9) {
                        continue;
                    }
                    this.c(n);
                }
            }
        }
        throw this.a("Unexpected end-of-input within/between " + this.n.d() + " entries");
    }
    
    private final int ah() {
        while (this.f < this.g || this.G()) {
            final int n = 0xFF & this.R[this.f++];
            if (n > 32) {
                if (n != 47) {
                    return n;
                }
                this.ai();
            }
            else {
                if (n == 32) {
                    continue;
                }
                if (n == 10) {
                    this.ad();
                }
                else if (n == 13) {
                    this.ac();
                }
                else {
                    if (n == 9) {
                        continue;
                    }
                    this.c(n);
                }
            }
        }
        this.J();
        return -1;
    }
    
    private final void ai() {
        if (!this.a(org.codehaus.jackson.l.b)) {
            this.b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.f >= this.g && !this.G()) {
            this.c(" in a comment");
        }
        final int n = 0xFF & this.R[this.f++];
        if (n == 47) {
            this.ak();
            return;
        }
        if (n == 42) {
            this.aj();
            return;
        }
        this.b(n, "was expecting either '*' or '/' for a comment");
    }
    
    private final void aj() {
        final int[] e = org.codehaus.jackson.g.e.e();
    Label_0147:
        while (this.f < this.g || this.G()) {
            final int n = 0xFF & this.R[this.f++];
            final int n2 = e[n];
            if (n2 != 0) {
                switch (n2) {
                    default: {
                        this.k(n);
                        continue;
                    }
                    case 42: {
                        if (this.f >= this.g && !this.G()) {
                            break Label_0147;
                        }
                        if (this.R[this.f] == 47) {
                            ++this.f;
                            return;
                        }
                        continue;
                    }
                    case 10: {
                        this.ad();
                        continue;
                    }
                    case 13: {
                        this.ac();
                        continue;
                    }
                    case 2: {
                        this.s(n);
                        continue;
                    }
                    case 3: {
                        this.t(n);
                        continue;
                    }
                    case 4: {
                        this.u(n);
                        continue;
                    }
                }
            }
        }
        this.c(" in a comment");
    }
    
    private final void ak() {
        final int[] e = org.codehaus.jackson.g.e.e();
    Label_0133:
        while (this.f < this.g || this.G()) {
            final int n = 0xFF & this.R[this.f++];
            final int n2 = e[n];
            if (n2 != 0) {
                switch (n2) {
                    case 4: {
                        this.u(n);
                        continue;
                    }
                    case 3: {
                        this.t(n);
                        continue;
                    }
                    case 2: {
                        this.s(n);
                    }
                    case 42: {
                        continue;
                    }
                    default: {
                        this.k(n);
                        continue;
                    }
                    case 10: {
                        this.ad();
                        break Label_0133;
                    }
                    case 13: {
                        this.ac();
                        return;
                    }
                }
            }
        }
    }
    
    private int al() {
        if (this.f >= this.g) {
            this.F();
        }
        return 0xFF & this.R[this.f++];
    }
    
    private final f b(final int n, final int n2) {
        final f b = this.N.b(n);
        if (b != null) {
            return b;
        }
        this.O[0] = n;
        return this.a(this.O, 1, n2);
    }
    
    private final f b(final int n, final int n2, final int n3) {
        final f a = this.N.a(n, n2);
        if (a != null) {
            return a;
        }
        this.O[0] = n;
        this.O[1] = n2;
        return this.a(this.O, 2, n3);
    }
    
    private final p n(final int n) {
        if (n == 34) {
            this.P = true;
            return this.b = org.codehaus.jackson.p.h;
        }
        switch (n) {
            default: {
                return this.b = this.i(n);
            }
            case 91: {
                this.n = this.n.b(this.l, this.m);
                return this.b = org.codehaus.jackson.p.d;
            }
            case 123: {
                this.n = this.n.c(this.l, this.m);
                return this.b = org.codehaus.jackson.p.b;
            }
            case 93:
            case 125: {
                this.b(n, "expected a value");
            }
            case 116: {
                this.a("true", 1);
                return this.b = org.codehaus.jackson.p.k;
            }
            case 102: {
                this.a("false", 1);
                return this.b = org.codehaus.jackson.p.l;
            }
            case 110: {
                this.a("null", 1);
                return this.b = org.codehaus.jackson.p.m;
            }
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                return this.b = this.e(n);
            }
        }
    }
    
    private final int o(final int n) {
        if (this.f >= this.g) {
            this.F();
        }
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
        return (n & 0x1F) << 6 | (b & 0x3F);
    }
    
    private final int p(final int n) {
        if (this.f >= this.g) {
            this.F();
        }
        final int n2 = n & 0xF;
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
        final int n3 = n2 << 6 | (b & 0x3F);
        if (this.f >= this.g) {
            this.F();
        }
        final byte b2 = this.R[this.f++];
        if ((b2 & 0xC0) != 0x80) {
            this.a(b2 & 0xFF, this.f);
        }
        return n3 << 6 | (b2 & 0x3F);
    }
    
    private final int q(final int n) {
        final int n2 = n & 0xF;
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
        final int n3 = n2 << 6 | (b & 0x3F);
        final byte b2 = this.R[this.f++];
        if ((b2 & 0xC0) != 0x80) {
            this.a(b2 & 0xFF, this.f);
        }
        return n3 << 6 | (b2 & 0x3F);
    }
    
    private final int r(final int n) {
        if (this.f >= this.g) {
            this.F();
        }
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
        final int n2 = (n & 0x7) << 6 | (b & 0x3F);
        if (this.f >= this.g) {
            this.F();
        }
        final byte b2 = this.R[this.f++];
        if ((b2 & 0xC0) != 0x80) {
            this.a(b2 & 0xFF, this.f);
        }
        final int n3 = n2 << 6 | (b2 & 0x3F);
        if (this.f >= this.g) {
            this.F();
        }
        final byte b3 = this.R[this.f++];
        if ((b3 & 0xC0) != 0x80) {
            this.a(b3 & 0xFF, this.f);
        }
        return (n3 << 6 | (b3 & 0x3F)) - 65536;
    }
    
    private final void s(final int n) {
        if (this.f >= this.g) {
            this.F();
        }
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
    }
    
    private final void t(final int n) {
        if (this.f >= this.g) {
            this.F();
        }
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            this.F();
        }
        final byte b2 = this.R[this.f++];
        if ((b2 & 0xC0) != 0x80) {
            this.a(b2 & 0xFF, this.f);
        }
    }
    
    private final void u(final int n) {
        if (this.f >= this.g) {
            this.F();
        }
        final byte b = this.R[this.f++];
        if ((b & 0xC0) != 0x80) {
            this.a(b & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            this.F();
        }
        final byte b2 = this.R[this.f++];
        if ((b2 & 0xC0) != 0x80) {
            this.a(b2 & 0xFF, this.f);
        }
        if (this.f >= this.g) {
            this.F();
        }
        final byte b3 = this.R[this.f++];
        if ((b3 & 0xC0) != 0x80) {
            this.a(b3 & 0xFF, this.f);
        }
    }
    
    @Override
    protected final boolean G() {
        this.h += this.g;
        this.j -= this.g;
        final InputStream q = this.Q;
        boolean b = false;
        if (q != null) {
            final int read = this.Q.read(this.R, 0, this.R.length);
            if (read > 0) {
                this.f = 0;
                this.g = read;
                b = true;
            }
            else {
                this.H();
                b = false;
                if (read == 0) {
                    throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.R.length + " bytes");
                }
            }
        }
        return b;
    }
    
    @Override
    protected void H() {
        if (this.Q != null) {
            if (this.d.c() || this.a(org.codehaus.jackson.l.a)) {
                this.Q.close();
            }
            this.Q = null;
        }
    }
    
    @Override
    protected void I() {
        super.I();
        if (this.S) {
            final byte[] r = this.R;
            if (r != null) {
                this.R = null;
                this.d.a(r);
            }
        }
    }
    
    @Override
    protected final char S() {
        int i = 0;
        if (this.f >= this.g && !this.G()) {
            this.c(" in character escape sequence");
        }
        final byte b = this.R[this.f++];
        switch (b) {
            default: {
                return this.a((char)this.j(b));
            }
            case 98: {
                return '\b';
            }
            case 116: {
                return '\t';
            }
            case 110: {
                return '\n';
            }
            case 102: {
                return '\f';
            }
            case 114: {
                return '\r';
            }
            case 34:
            case 47:
            case 92: {
                return (char)b;
            }
            case 117: {
                int n = 0;
                while (i < 4) {
                    if (this.f >= this.g && !this.G()) {
                        this.c(" in character escape sequence");
                    }
                    final byte b2 = this.R[this.f++];
                    final int a = org.codehaus.jackson.g.e.a(b2);
                    if (a < 0) {
                        this.b(b2, "expected a hex-digit for character escape sequence");
                    }
                    n = (a | n << 4);
                    ++i;
                }
                return (char)n;
            }
        }
    }
    
    protected f X() {
        if (this.f >= this.g && !this.G()) {
            this.c(": was expecting closing '\"' for name");
        }
        final int n = 0xFF & this.R[this.f++];
        if (n == 34) {
            return org.codehaus.jackson.e.a.d();
        }
        return this.a(this.O, 0, 0, n, 0);
    }
    
    protected final f Y() {
        if (this.f >= this.g && !this.G()) {
            this.c(": was expecting closing ''' for name");
        }
        int i = 0xFF & this.R[this.f++];
        if (i == 39) {
            return org.codehaus.jackson.e.a.d();
        }
        int[] array = this.O;
        final int[] u = j.U;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
    Label_0318_Outer:
        while (i != 39) {
            while (true) {
                Label_0663: {
                    if (i == 34 || u[i] == 0) {
                        break Label_0663;
                    }
                    if (i != 92) {
                        this.c(i, "name");
                    }
                    else {
                        i = this.S();
                    }
                    if (i <= 127) {
                        break Label_0663;
                    }
                    int n5;
                    int n6;
                    int n7;
                    if (n >= 4) {
                        if (n3 >= array.length) {
                            array = a(array, array.length);
                            this.O = array;
                        }
                        final int n4 = n3 + 1;
                        array[n3] = n2;
                        n5 = 0;
                        n6 = n4;
                        n7 = 0;
                    }
                    else {
                        final int n8 = n;
                        n7 = n2;
                        n6 = n3;
                        n5 = n8;
                    }
                    int n11;
                    int[] array2;
                    int n12;
                    if (i < 2048) {
                        final int n9 = n7 << 8 | (0xC0 | i >> 6);
                        final int n10 = n5 + 1;
                        n11 = n9;
                        array2 = array;
                        n12 = n10;
                    }
                    else {
                        final int n13 = n7 << 8 | (0xE0 | i >> 12);
                        final int n14 = n5 + 1;
                        int n16;
                        int[] array3;
                        int n17;
                        int n18;
                        if (n14 >= 4) {
                            if (n6 >= array.length) {
                                array = a(array, array.length);
                                this.O = array;
                            }
                            final int n15 = n6 + 1;
                            array[n6] = n13;
                            n16 = n15;
                            array3 = array;
                            n17 = 0;
                            n18 = 0;
                        }
                        else {
                            n18 = n13;
                            n16 = n6;
                            array3 = array;
                            n17 = n14;
                        }
                        n11 = (n18 << 8 | (0x80 | (0x3F & i >> 6)));
                        n12 = n17 + 1;
                        final int n19 = n16;
                        array2 = array3;
                        n6 = n19;
                    }
                    final int n20 = 0x80 | (i & 0x3F);
                    final int n21 = n11;
                    final int n22 = n12;
                    array = array2;
                    final int n23 = n20;
                    int n25;
                    int n26;
                    int[] array4;
                    int n27;
                    if (n22 < 4) {
                        final int n24 = n22 + 1;
                        n25 = (n23 | n21 << 8);
                        n26 = n6;
                        array4 = array;
                        n27 = n24;
                    }
                    else {
                        if (n6 >= array.length) {
                            array = a(array, array.length);
                            this.O = array;
                        }
                        final int n28 = n6 + 1;
                        array[n6] = n21;
                        array4 = array;
                        n27 = 1;
                        n25 = n23;
                        n26 = n28;
                    }
                    if (this.f >= this.g && !this.G()) {
                        this.c(" in field name");
                    }
                    i = (0xFF & this.R[this.f++]);
                    final int n29 = n27;
                    array = array4;
                    n2 = n25;
                    n3 = n26;
                    n = n29;
                    continue Label_0318_Outer;
                }
                final int n21 = n2;
                int n6 = n3;
                final int n22 = n;
                final int n23 = i;
                continue;
            }
        }
        int[] array5;
        int n31;
        if (n > 0) {
            if (n3 >= array.length) {
                array = a(array, array.length);
                this.O = array;
            }
            final int n30 = n3 + 1;
            array[n3] = n2;
            array5 = array;
            n31 = n30;
        }
        else {
            array5 = array;
            n31 = n3;
        }
        final f a = this.N.a(array5, n31);
        if (a == null) {
            return this.a(array5, n31, n);
        }
        return a;
    }
    
    protected void Z() {
        int n = this.f;
        if (n >= this.g) {
            this.F();
            n = this.f;
        }
        final char[] k = this.p.k();
        final int[] t = j.T;
        final int min = Math.min(this.g, n + k.length);
        final byte[] r = this.R;
        int i = n;
        int n2 = 0;
        while (i < min) {
            final int n3 = 0xFF & r[i];
            if (t[n3] != 0) {
                if (n3 == 34) {
                    this.f = i + 1;
                    this.p.a(n2);
                    return;
                }
                break;
            }
            else {
                final int n4 = i + 1;
                final int n5 = n2 + 1;
                k[n2] = (char)n3;
                n2 = n5;
                i = n4;
            }
        }
        this.f = i;
        this.a(k, n2);
    }
    
    protected final String a(final p p) {
        if (p == null) {
            return null;
        }
        switch (j$1.a[p.ordinal()]) {
            default: {
                return p.a();
            }
            case 1: {
                return this.n.h();
            }
            case 2:
            case 3:
            case 4: {
                return this.p.f();
            }
        }
    }
    
    protected final f a(final int n, final int[] array) {
        final int n2 = 0xFF & this.R[this.f++];
        if (array[n2] != 0) {
            if (n2 == 34) {
                return this.b(this.V, n, 1);
            }
            return this.a(this.V, n, n2, 1);
        }
        else {
            final int n3 = n2 | n << 8;
            final int n4 = 0xFF & this.R[this.f++];
            if (array[n4] != 0) {
                if (n4 == 34) {
                    return this.b(this.V, n3, 2);
                }
                return this.a(this.V, n3, n4, 2);
            }
            else {
                final int n5 = n4 | n3 << 8;
                final int n6 = 0xFF & this.R[this.f++];
                if (array[n6] != 0) {
                    if (n6 == 34) {
                        return this.b(this.V, n5, 3);
                    }
                    return this.a(this.V, n5, n6, 3);
                }
                else {
                    final int n7 = n6 | n5 << 8;
                    final int n8 = 0xFF & this.R[this.f++];
                    if (array[n8] == 0) {
                        this.O[0] = this.V;
                        this.O[1] = n7;
                        return this.g(n8);
                    }
                    if (n8 == 34) {
                        return this.b(this.V, n7, 4);
                    }
                    return this.a(this.V, n7, n8, 4);
                }
            }
        }
    }
    
    protected f a(int[] array, int n, int n2, int s, int n3) {
        final int[] u = j.U;
    Label_0215_Outer:
        while (true) {
            while (true) {
                Label_0496: {
                    if (u[s] == 0) {
                        break Label_0496;
                    }
                    if (s == 34) {
                        break;
                    }
                    if (s != 92) {
                        this.c(s, "name");
                    }
                    else {
                        s = this.S();
                    }
                    if (s <= 127) {
                        break Label_0496;
                    }
                    int n4;
                    int[] a;
                    if (n3 >= 4) {
                        if (n >= array.length) {
                            array = a(array, array.length);
                            this.O = array;
                        }
                        n4 = n + 1;
                        array[n] = n2;
                        n3 = 0;
                        n2 = 0;
                        a = array;
                    }
                    else {
                        n4 = n;
                        a = array;
                    }
                    int n7;
                    int[] array2;
                    int n8;
                    if (s < 2048) {
                        final int n5 = n2 << 8 | (0xC0 | s >> 6);
                        final int n6 = n3 + 1;
                        n7 = n5;
                        array2 = a;
                        n8 = n6;
                    }
                    else {
                        final int n9 = n2 << 8 | (0xE0 | s >> 12);
                        final int n10 = n3 + 1;
                        int n12;
                        int[] array3;
                        int n13;
                        int n14;
                        if (n10 >= 4) {
                            if (n4 >= a.length) {
                                a = a(a, a.length);
                                this.O = a;
                            }
                            final int n11 = n4 + 1;
                            a[n4] = n9;
                            n12 = n11;
                            array3 = a;
                            n13 = 0;
                            n14 = 0;
                        }
                        else {
                            n14 = n9;
                            n12 = n4;
                            array3 = a;
                            n13 = n10;
                        }
                        n7 = (n14 << 8 | (0x80 | (0x3F & s >> 6)));
                        n8 = n13 + 1;
                        final int n15 = n12;
                        array2 = array3;
                        n4 = n15;
                    }
                    n2 = (0x80 | (s & 0x3F));
                    n3 = n8;
                    n = n4;
                    int[] a2 = array2;
                    final int n16 = n7;
                    if (n3 < 4) {
                        ++n3;
                        n2 |= n16 << 8;
                        array = a2;
                    }
                    else {
                        if (n >= a2.length) {
                            a2 = a(a2, a2.length);
                            this.O = a2;
                        }
                        final int n17 = n + 1;
                        a2[n] = n16;
                        n3 = 1;
                        n = n17;
                        array = a2;
                    }
                    if (this.f >= this.g && !this.G()) {
                        this.c(" in field name");
                    }
                    s = (0xFF & this.R[this.f++]);
                    continue Label_0215_Outer;
                }
                final int n16 = n2;
                int[] a2 = array;
                n2 = s;
                continue;
            }
        }
        if (n3 > 0) {
            if (n >= array.length) {
                array = a(array, array.length);
                this.O = array;
            }
            final int n18 = n + 1;
            array[n] = n2;
            n = n18;
        }
        f f = this.N.a(array, n);
        if (f == null) {
            f = this.a(array, n, n3);
        }
        return f;
    }
    
    protected p a(int n, final boolean b) {
        double n2 = Double.NEGATIVE_INFINITY;
        if (n == 73) {
            if (this.f >= this.g && !this.G()) {
                this.V();
            }
            n = this.R[this.f++];
            if (n == 78) {
                String str;
                if (b) {
                    str = "-INF";
                }
                else {
                    str = "+INF";
                }
                this.a(str, 3);
                if (this.a(org.codehaus.jackson.l.h)) {
                    if (!b) {
                        n2 = Double.POSITIVE_INFINITY;
                    }
                    return this.a(str, n2);
                }
                this.d("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
            else if (n == 110) {
                String str2;
                if (b) {
                    str2 = "-Infinity";
                }
                else {
                    str2 = "+Infinity";
                }
                this.a(str2, 3);
                if (this.a(org.codehaus.jackson.l.h)) {
                    if (!b) {
                        n2 = Double.POSITIVE_INFINITY;
                    }
                    return this.a(str2, n2);
                }
                this.d("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        this.a(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }
    
    @Override
    public q a() {
        return this.M;
    }
    
    protected void a(final int n, final int f) {
        this.f = f;
        this.m(n);
    }
    
    protected final void a(final String s, int endIndex) {
        do {
            if (this.f >= this.g && !this.G()) {
                this.c(" in a value");
            }
            if (this.R[this.f] != s.charAt(endIndex)) {
                this.a(s.substring(0, endIndex), "'null', 'true', 'false' or NaN");
            }
            ++this.f;
        } while (++endIndex < s.length());
        if (this.f < this.g || this.G()) {
            final int n = 0xFF & this.R[this.f];
            if (n >= 48 && n != 93 && n != 125 && Character.isJavaIdentifierPart((char)this.j(n))) {
                ++this.f;
                this.a(s.substring(0, endIndex), "'null', 'true', 'false' or NaN");
            }
        }
    }
    
    protected void a(final String str, final String str2) {
        final StringBuilder sb = new StringBuilder(str);
        while (this.f < this.g || this.G()) {
            final char c = (char)this.j(this.R[this.f++]);
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            sb.append(c);
        }
        this.d("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }
    
    @Override
    public byte[] a(final org.codehaus.jackson.a obj) {
        if (this.b != org.codehaus.jackson.p.h && (this.b != org.codehaus.jackson.p.g || this.t == null)) {
            this.d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        while (true) {
            Label_0125: {
                if (!this.P) {
                    break Label_0125;
                }
                try {
                    this.t = this.b(obj);
                    this.P = false;
                    return this.t;
                }
                catch (IllegalArgumentException ex) {
                    throw this.a("Failed to decode VALUE_STRING as base64 (" + obj + "): " + ex.getMessage());
                }
            }
            if (this.t == null) {
                final org.codehaus.jackson.g.d k = this.K();
                this.a(this.k(), k, obj);
                this.t = k.b();
                continue;
            }
            continue;
        }
    }
    
    protected void aa() {
        this.P = false;
        final int[] t = j.T;
        final byte[] r = this.R;
    Block_4:
        while (true) {
            int i = this.f;
            int n = this.g;
            if (i >= n) {
                this.F();
                i = this.f;
                n = this.g;
            }
            while (i < n) {
                final int f = i + 1;
                final int n2 = 0xFF & r[i];
                if (t[n2] != 0) {
                    this.f = f;
                    if (n2 == 34) {
                        break Block_4;
                    }
                    switch (t[n2]) {
                        default: {
                            if (n2 < 32) {
                                this.c(n2, "string value");
                                continue Block_4;
                            }
                            this.k(n2);
                            continue Block_4;
                        }
                        case 1: {
                            this.S();
                            continue Block_4;
                        }
                        case 2: {
                            this.s(n2);
                            continue Block_4;
                        }
                        case 3: {
                            this.t(n2);
                            continue Block_4;
                        }
                        case 4: {
                            this.u(n2);
                            continue Block_4;
                        }
                    }
                }
                else {
                    i = f;
                }
            }
            this.f = i;
        }
    }
    
    protected p ab() {
        char[] array = this.p.k();
        final int[] t = j.T;
        final byte[] r = this.R;
        int n = 0;
    Block_5:
        while (true) {
            if (this.f >= this.g) {
                this.F();
            }
            if (n >= array.length) {
                array = this.p.m();
                n = 0;
            }
            final int g = this.g;
            int n2 = this.f + (array.length - n);
            if (n2 >= g) {
                n2 = g;
            }
            while (this.f < n2) {
                final int n3 = 0xFF & r[this.f++];
                if (n3 == 39 || t[n3] != 0) {
                    if (n3 == 39) {
                        break Block_5;
                    }
                    int n4 = 0;
                    Label_0225: {
                        switch (t[n3]) {
                            default: {
                                if (n3 < 32) {
                                    this.c(n3, "string value");
                                }
                                this.k(n3);
                                break;
                            }
                            case 1: {
                                if (n3 != 34) {
                                    n4 = this.S();
                                    break Label_0225;
                                }
                                break;
                            }
                            case 2: {
                                n4 = this.o(n3);
                                break Label_0225;
                            }
                            case 3: {
                                if (this.g - this.f >= 2) {
                                    n4 = this.q(n3);
                                    break Label_0225;
                                }
                                n4 = this.p(n3);
                                break Label_0225;
                            }
                            case 4: {
                                final int r2 = this.r(n3);
                                final int n5 = n + 1;
                                array[n] = (char)(0xD800 | r2 >> 10);
                                if (n5 >= array.length) {
                                    array = this.p.m();
                                    n = 0;
                                }
                                else {
                                    n = n5;
                                }
                                n4 = (0xDC00 | (r2 & 0x3FF));
                                break Label_0225;
                            }
                        }
                        n4 = n3;
                    }
                    int n6;
                    if (n >= array.length) {
                        array = this.p.m();
                        n6 = 0;
                    }
                    else {
                        n6 = n;
                    }
                    n = n6 + 1;
                    array[n6] = (char)n4;
                    break;
                }
                else {
                    final int n7 = n + 1;
                    array[n] = (char)n3;
                    n = n7;
                }
            }
        }
        this.p.a(n);
        return org.codehaus.jackson.p.h;
    }
    
    protected final void ac() {
        if ((this.f < this.g || this.G()) && this.R[this.f] == 10) {
            ++this.f;
        }
        ++this.i;
        this.j = this.f;
    }
    
    protected final void ad() {
        ++this.i;
        this.j = this.f;
    }
    
    @Override
    public p b() {
        this.C = 0;
        if (this.b == org.codehaus.jackson.p.f) {
            return this.ae();
        }
        if (this.P) {
            this.aa();
        }
        int n = this.ah();
        if (n < 0) {
            this.close();
            return this.b = null;
        }
        this.k = this.h + this.f - 1L;
        this.l = this.i;
        this.m = -1 + (this.f - this.j);
        this.t = null;
        if (n == 93) {
            if (!this.n.a()) {
                this.a(n, '}');
            }
            this.n = this.n.i();
            return this.b = org.codehaus.jackson.p.e;
        }
        if (n == 125) {
            if (!this.n.c()) {
                this.a(n, ']');
            }
            this.n = this.n.i();
            return this.b = org.codehaus.jackson.p.c;
        }
        if (this.n.j()) {
            if (n != 44) {
                this.b(n, "was expecting comma to separate " + this.n.d() + " entries");
            }
            n = this.ag();
        }
        if (!this.n.c()) {
            return this.n(n);
        }
        this.n.a(this.f(n).a());
        this.b = org.codehaus.jackson.p.f;
        final int ag = this.ag();
        if (ag != 58) {
            this.b(ag, "was expecting a colon to separate field name and value");
        }
        final int ag2 = this.ag();
        if (ag2 == 34) {
            this.P = true;
            this.o = org.codehaus.jackson.p.h;
            return this.b;
        }
        p o = null;
        switch (ag2) {
            default: {
                o = this.i(ag2);
                break;
            }
            case 91: {
                o = org.codehaus.jackson.p.d;
                break;
            }
            case 123: {
                o = org.codehaus.jackson.p.b;
                break;
            }
            case 93:
            case 125: {
                this.b(ag2, "expected a value");
            }
            case 116: {
                this.a("true", 1);
                o = org.codehaus.jackson.p.k;
                break;
            }
            case 102: {
                this.a("false", 1);
                o = org.codehaus.jackson.p.l;
                break;
            }
            case 110: {
                this.a("null", 1);
                o = org.codehaus.jackson.p.m;
                break;
            }
            case 45:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                o = this.e(ag2);
                break;
            }
        }
        this.o = o;
        return this.b;
    }
    
    protected byte[] b(final org.codehaus.jackson.a a) {
        final org.codehaus.jackson.g.d k = this.K();
        while (true) {
            if (this.f >= this.g) {
                this.F();
            }
            final int n = 0xFF & this.R[this.f++];
            if (n > 32) {
                int n2 = a.b(n);
                if (n2 < 0) {
                    if (n == 34) {
                        return k.b();
                    }
                    n2 = this.a(a, n, 0);
                    if (n2 < 0) {
                        continue;
                    }
                }
                if (this.f >= this.g) {
                    this.F();
                }
                final int n3 = 0xFF & this.R[this.f++];
                int n4 = a.b(n3);
                if (n4 < 0) {
                    n4 = this.a(a, n3, 1);
                }
                final int n5 = n4 | n2 << 6;
                if (this.f >= this.g) {
                    this.F();
                }
                final int n6 = 0xFF & this.R[this.f++];
                int n7 = a.b(n6);
                if (n7 < 0) {
                    if (n7 != -2) {
                        if (n6 == 34 && !a.a()) {
                            k.a(n5 >> 4);
                            return k.b();
                        }
                        n7 = this.a(a, n6, 2);
                    }
                    if (n7 == -2) {
                        if (this.f >= this.g) {
                            this.F();
                        }
                        final int n8 = 0xFF & this.R[this.f++];
                        if (!a.a(n8)) {
                            throw this.a(a, n8, 3, "expected padding character '" + a.b() + "'");
                        }
                        k.a(n5 >> 4);
                        continue;
                    }
                }
                final int n9 = n7 | n5 << 6;
                if (this.f >= this.g) {
                    this.F();
                }
                final int n10 = 0xFF & this.R[this.f++];
                int n11 = a.b(n10);
                if (n11 < 0) {
                    if (n11 != -2) {
                        if (n10 == 34 && !a.a()) {
                            k.b(n9 >> 2);
                            return k.b();
                        }
                        n11 = this.a(a, n10, 3);
                    }
                    if (n11 == -2) {
                        k.b(n9 >> 2);
                        continue;
                    }
                }
                k.c(n11 | n9 << 6);
            }
        }
    }
    
    @Override
    public void close() {
        super.close();
        this.N.b();
    }
    
    protected final p e(final int n) {
        int n2 = 1;
        final char[] k = this.p.k();
        int n3;
        if (n == 45) {
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        int af;
        int n4;
        if (n3 != 0) {
            k[0] = '-';
            if (this.f >= this.g) {
                this.F();
            }
            af = (0xFF & this.R[this.f++]);
            if (af < 48 || af > 57) {
                return this.a(af, n2 != 0);
            }
            n4 = n2;
        }
        else {
            af = n;
            n4 = 0;
        }
        if (af == 48) {
            af = this.af();
        }
        int n5 = n4 + 1;
        k[n4] = (char)af;
        int g = this.f + k.length;
        if (g > this.g) {
            g = this.g;
        }
        while (this.f < g) {
            final int n6 = 0xFF & this.R[this.f++];
            if (n6 < 48 || n6 > 57) {
                if (n6 == 46 || n6 == 101 || n6 == 69) {
                    return this.a(k, n5, n6, n3 != 0, n2);
                }
                --this.f;
                this.p.a(n5);
                return this.a(n3 != 0, n2);
            }
            else {
                ++n2;
                final int n7 = n5 + 1;
                k[n5] = (char)n6;
                n5 = n7;
            }
        }
        return this.a(k, n5, n3 != 0, n2);
    }
    
    protected final f f(final int n) {
        if (n != 34) {
            return this.h(n);
        }
        if (9 + this.f > this.g) {
            return this.X();
        }
        final byte[] r = this.R;
        final int[] u = j.U;
        final int n2 = 0xFF & r[this.f++];
        if (u[n2] == 0) {
            final int n3 = 0xFF & r[this.f++];
            if (u[n3] == 0) {
                final int n4 = n3 | n2 << 8;
                final int n5 = 0xFF & r[this.f++];
                if (u[n5] == 0) {
                    final int n6 = n5 | n4 << 8;
                    final int n7 = 0xFF & r[this.f++];
                    if (u[n7] == 0) {
                        final int v = n7 | n6 << 8;
                        final int n8 = 0xFF & r[this.f++];
                        if (u[n8] == 0) {
                            this.V = v;
                            return this.a(n8, u);
                        }
                        if (n8 == 34) {
                            return this.b(v, 4);
                        }
                        return this.a(v, n8, 4);
                    }
                    else {
                        if (n7 == 34) {
                            return this.b(n6, 3);
                        }
                        return this.a(n6, n7, 3);
                    }
                }
                else {
                    if (n5 == 34) {
                        return this.b(n4, 2);
                    }
                    return this.a(n4, n5, 2);
                }
            }
            else {
                if (n3 == 34) {
                    return this.b(n2, 1);
                }
                return this.a(n2, n3, 1);
            }
        }
        else {
            if (n2 == 34) {
                return org.codehaus.jackson.e.a.d();
            }
            return this.a(0, n2, 0);
        }
    }
    
    protected f g(final int n) {
        final int[] u = j.U;
        int n2 = 2;
        int n3 = n;
        while (this.g - this.f >= 4) {
            final int n4 = 0xFF & this.R[this.f++];
            if (u[n4] != 0) {
                if (n4 == 34) {
                    return this.a(this.O, n2, n3, 1);
                }
                return this.a(this.O, n2, n3, n4, 1);
            }
            else {
                final int n5 = n4 | n3 << 8;
                final int n6 = 0xFF & this.R[this.f++];
                if (u[n6] != 0) {
                    if (n6 == 34) {
                        return this.a(this.O, n2, n5, 2);
                    }
                    return this.a(this.O, n2, n5, n6, 2);
                }
                else {
                    final int n7 = n6 | n5 << 8;
                    final int n8 = 0xFF & this.R[this.f++];
                    if (u[n8] != 0) {
                        if (n8 == 34) {
                            return this.a(this.O, n2, n7, 3);
                        }
                        return this.a(this.O, n2, n7, n8, 3);
                    }
                    else {
                        final int n9 = n8 | n7 << 8;
                        n3 = (0xFF & this.R[this.f++]);
                        if (u[n3] != 0) {
                            if (n3 == 34) {
                                return this.a(this.O, n2, n9, 4);
                            }
                            return this.a(this.O, n2, n9, n3, 4);
                        }
                        else {
                            if (n2 >= this.O.length) {
                                this.O = a(this.O, n2);
                            }
                            final int[] o = this.O;
                            final int n10 = n2 + 1;
                            o[n2] = n9;
                            n2 = n10;
                        }
                    }
                }
            }
        }
        return this.a(this.O, n2, 0, n3, 0);
    }
    
    protected final f h(final int n) {
        if (n == 39 && this.a(org.codehaus.jackson.l.d)) {
            return this.Y();
        }
        if (!this.a(org.codehaus.jackson.l.c)) {
            this.b(n, "was expecting double-quote to start field name");
        }
        final int[] d = org.codehaus.jackson.g.e.d();
        if (d[n] != 0) {
            this.b(n, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        final int[] o = this.O;
        int n2 = 0;
        int n3 = 0;
        int n4 = n;
        int n5 = 0;
        int[] a = o;
        int n7;
        int n8;
        int[] a2;
        int n9;
        while (true) {
            if (n2 < 4) {
                final int n6 = n2 + 1;
                n7 = (n4 | n3 << 8);
                n8 = n5;
                a2 = a;
                n9 = n6;
            }
            else {
                if (n5 >= a.length) {
                    a = a(a, a.length);
                    this.O = a;
                }
                final int n10 = n5 + 1;
                a[n5] = n3;
                a2 = a;
                n9 = 1;
                n7 = n4;
                n8 = n10;
            }
            if (this.f >= this.g && !this.G()) {
                this.c(" in field name");
            }
            final int n11 = 0xFF & this.R[this.f];
            if (d[n11] != 0) {
                break;
            }
            ++this.f;
            n3 = n7;
            n2 = n9;
            a = a2;
            n5 = n8;
            n4 = n11;
        }
        if (n9 > 0) {
            if (n8 >= a2.length) {
                a2 = a(a2, a2.length);
                this.O = a2;
            }
            final int n12 = n8 + 1;
            a2[n8] = n7;
            n8 = n12;
        }
        final f a3 = this.N.a(a2, n8);
        if (a3 == null) {
            return this.a(a2, n8, n9);
        }
        return a3;
    }
    
    protected p i(final int n) {
        switch (n) {
            case 39: {
                if (this.a(org.codehaus.jackson.l.d)) {
                    return this.ab();
                }
                break;
            }
            case 78: {
                this.a("NaN", 1);
                if (this.a(org.codehaus.jackson.l.h)) {
                    return this.a("NaN", Double.NaN);
                }
                this.d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                break;
            }
            case 43: {
                if (this.f >= this.g && !this.G()) {
                    this.V();
                }
                return this.a(0xFF & this.R[this.f++], false);
            }
        }
        this.b(n, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }
    
    protected int j(int n) {
        if (n < 0) {
            int n2;
            if ((n & 0xE0) == 0xC0) {
                n &= 0x1F;
                n2 = 1;
            }
            else if ((n & 0xF0) == 0xE0) {
                n &= 0xF;
                n2 = 2;
            }
            else if ((n & 0xF8) == 0xF0) {
                n &= 0x7;
                n2 = 3;
            }
            else {
                this.l(n & 0xFF);
                n2 = 1;
            }
            final int al = this.al();
            if ((al & 0xC0) != 0x80) {
                this.m(al & 0xFF);
            }
            n = (n << 6 | (al & 0x3F));
            if (n2 > 1) {
                final int al2 = this.al();
                if ((al2 & 0xC0) != 0x80) {
                    this.m(al2 & 0xFF);
                }
                n = (n << 6 | (al2 & 0x3F));
                if (n2 > 2) {
                    final int al3 = this.al();
                    if ((al3 & 0xC0) != 0x80) {
                        this.m(al3 & 0xFF);
                    }
                    n = (n << 6 | (al3 & 0x3F));
                }
            }
        }
        return n;
    }
    
    @Override
    public String k() {
        final p b = this.b;
        if (b == org.codehaus.jackson.p.h) {
            if (this.P) {
                this.P = false;
                this.Z();
            }
            return this.p.f();
        }
        return this.a(b);
    }
    
    protected void k(final int n) {
        if (n < 32) {
            this.c(n);
        }
        this.l(n);
    }
    
    protected void l(final int i) {
        this.d("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }
    
    @Override
    public char[] l() {
        if (this.b == null) {
            return null;
        }
        switch (j$1.a[this.b.ordinal()]) {
            default: {
                return this.b.b();
            }
            case 1: {
                if (!this.r) {
                    final String h = this.n.h();
                    final int length = h.length();
                    if (this.q == null) {
                        this.q = this.d.a(length);
                    }
                    else if (this.q.length < length) {
                        this.q = new char[length];
                    }
                    h.getChars(0, length, this.q, 0);
                    this.r = true;
                }
                return this.q;
            }
            case 2: {
                if (this.P) {
                    this.P = false;
                    this.Z();
                    return this.p.e();
                }
                return this.p.e();
            }
            case 3:
            case 4: {
                return this.p.e();
            }
        }
    }
    
    @Override
    public int m() {
        final p b = this.b;
        int length = 0;
        if (b != null) {
            switch (j$1.a[this.b.ordinal()]) {
                default: {
                    length = this.b.b().length;
                    break;
                }
                case 1: {
                    return this.n.h().length();
                }
                case 2: {
                    if (this.P) {
                        this.P = false;
                        this.Z();
                        return this.p.c();
                    }
                    return this.p.c();
                }
                case 3:
                case 4: {
                    return this.p.c();
                }
            }
        }
        return length;
    }
    
    protected void m(final int i) {
        this.d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }
    
    @Override
    public int n() {
        if (this.b != null) {
            switch (j$1.a[this.b.ordinal()]) {
                case 2: {
                    if (this.P) {
                        this.P = false;
                        this.Z();
                        return this.p.d();
                    }
                    return this.p.d();
                }
                case 3:
                case 4: {
                    return this.p.d();
                }
            }
        }
        return 0;
    }
}
