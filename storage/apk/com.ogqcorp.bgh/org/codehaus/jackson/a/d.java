// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.m;
import org.codehaus.jackson.h;
import org.codehaus.jackson.a;
import org.codehaus.jackson.b.g;
import org.codehaus.jackson.g.d;
import org.codehaus.jackson.g.l;
import org.codehaus.jackson.p;
import org.codehaus.jackson.b.c;
import java.math.BigInteger;
import java.math.BigDecimal;

public abstract class d extends e
{
    static final BigDecimal A;
    static final BigDecimal B;
    static final BigInteger u;
    static final BigInteger v;
    static final BigInteger w;
    static final BigInteger x;
    static final BigDecimal y;
    static final BigDecimal z;
    protected int C;
    protected int D;
    protected long E;
    protected double F;
    protected BigInteger G;
    protected BigDecimal H;
    protected boolean I;
    protected int J;
    protected int K;
    protected int L;
    protected final c d;
    protected boolean e;
    protected int f;
    protected int g;
    protected long h;
    protected int i;
    protected int j;
    protected long k;
    protected int l;
    protected int m;
    protected f n;
    protected p o;
    protected final l p;
    protected char[] q;
    protected boolean r;
    protected org.codehaus.jackson.g.d s;
    protected byte[] t;
    
    static {
        u = BigInteger.valueOf(-2147483648L);
        v = BigInteger.valueOf(2147483647L);
        w = BigInteger.valueOf(Long.MIN_VALUE);
        x = BigInteger.valueOf(Long.MAX_VALUE);
        y = new BigDecimal(d.w);
        z = new BigDecimal(d.x);
        A = new BigDecimal(d.u);
        B = new BigDecimal(d.v);
    }
    
    protected d(final c d, final int a) {
        this.f = 0;
        this.g = 0;
        this.h = 0L;
        this.i = 1;
        this.j = 0;
        this.k = 0L;
        this.l = 1;
        this.m = 0;
        this.q = null;
        this.r = false;
        this.s = null;
        this.C = 0;
        this.a = a;
        this.d = d;
        this.p = d.d();
        this.n = org.codehaus.jackson.a.f.g();
    }
    
    private final void a(final int n, final char[] array, final int n2, final int n3) {
        final String f = this.p.f();
        try {
            if (org.codehaus.jackson.b.g.a(array, n2, n3, this.I)) {
                this.E = Long.parseLong(f);
                this.C = 2;
                return;
            }
            this.G = new BigInteger(f);
            this.C = 4;
        }
        catch (NumberFormatException ex) {
            this.a("Malformed numeric value '" + f + "'", ex);
        }
    }
    
    private final void e(final int n) {
        Label_0024: {
            if (n != 16) {
                break Label_0024;
            }
            try {
                this.H = this.p.h();
                this.C = 16;
                return;
                this.F = this.p.i();
                this.C = 8;
            }
            catch (NumberFormatException ex) {
                this.a("Malformed numeric value '" + this.p.f() + "'", ex);
            }
        }
    }
    
    public final long C() {
        return this.k;
    }
    
    public final int D() {
        return this.l;
    }
    
    public final int E() {
        final int m = this.m;
        if (m < 0) {
            return m;
        }
        return m + 1;
    }
    
    protected final void F() {
        if (!this.G()) {
            this.U();
        }
    }
    
    protected abstract boolean G();
    
    protected abstract void H();
    
    protected void I() {
        this.p.a();
        final char[] q = this.q;
        if (q != null) {
            this.q = null;
            this.d.c(q);
        }
    }
    
    @Override
    protected void J() {
        if (!this.n.b()) {
            this.c(": expected close marker for " + this.n.d() + " (from " + this.n.a(this.d.a()) + ")");
        }
    }
    
    public org.codehaus.jackson.g.d K() {
        if (this.s == null) {
            this.s = new org.codehaus.jackson.g.d();
        }
        else {
            this.s.a();
        }
        return this.s;
    }
    
    protected void L() {
        if ((0x2 & this.C) != 0x0) {
            final int d = (int)this.E;
            if (d != this.E) {
                this.d("Numeric value (" + this.k() + ") out of range of int");
            }
            this.D = d;
        }
        else if ((0x4 & this.C) != 0x0) {
            if (org.codehaus.jackson.a.d.u.compareTo(this.G) > 0 || org.codehaus.jackson.a.d.v.compareTo(this.G) < 0) {
                this.Q();
            }
            this.D = this.G.intValue();
        }
        else if ((0x8 & this.C) != 0x0) {
            if (this.F < -2.147483648E9 || this.F > 2.147483647E9) {
                this.Q();
            }
            this.D = (int)this.F;
        }
        else if ((0x10 & this.C) != 0x0) {
            if (org.codehaus.jackson.a.d.A.compareTo(this.H) > 0 || org.codehaus.jackson.a.d.B.compareTo(this.H) < 0) {
                this.Q();
            }
            this.D = this.H.intValue();
        }
        else {
            this.W();
        }
        this.C |= 0x1;
    }
    
    protected void M() {
        if ((0x1 & this.C) != 0x0) {
            this.E = this.D;
        }
        else if ((0x4 & this.C) != 0x0) {
            if (org.codehaus.jackson.a.d.w.compareTo(this.G) > 0 || org.codehaus.jackson.a.d.x.compareTo(this.G) < 0) {
                this.R();
            }
            this.E = this.G.longValue();
        }
        else if ((0x8 & this.C) != 0x0) {
            if (this.F < -9.223372036854776E18 || this.F > 9.223372036854776E18) {
                this.R();
            }
            this.E = (long)this.F;
        }
        else if ((0x10 & this.C) != 0x0) {
            if (org.codehaus.jackson.a.d.y.compareTo(this.H) > 0 || org.codehaus.jackson.a.d.z.compareTo(this.H) < 0) {
                this.R();
            }
            this.E = this.H.longValue();
        }
        else {
            this.W();
        }
        this.C |= 0x2;
    }
    
    protected void N() {
        if ((0x10 & this.C) != 0x0) {
            this.G = this.H.toBigInteger();
        }
        else if ((0x2 & this.C) != 0x0) {
            this.G = BigInteger.valueOf(this.E);
        }
        else if ((0x1 & this.C) != 0x0) {
            this.G = BigInteger.valueOf(this.D);
        }
        else if ((0x8 & this.C) != 0x0) {
            this.G = BigDecimal.valueOf(this.F).toBigInteger();
        }
        else {
            this.W();
        }
        this.C |= 0x4;
    }
    
    protected void O() {
        if ((0x10 & this.C) != 0x0) {
            this.F = this.H.doubleValue();
        }
        else if ((0x4 & this.C) != 0x0) {
            this.F = this.G.doubleValue();
        }
        else if ((0x2 & this.C) != 0x0) {
            this.F = this.E;
        }
        else if ((0x1 & this.C) != 0x0) {
            this.F = this.D;
        }
        else {
            this.W();
        }
        this.C |= 0x8;
    }
    
    protected void P() {
        if ((0x8 & this.C) != 0x0) {
            this.H = new BigDecimal(this.k());
        }
        else if ((0x4 & this.C) != 0x0) {
            this.H = new BigDecimal(this.G);
        }
        else if ((0x2 & this.C) != 0x0) {
            this.H = BigDecimal.valueOf(this.E);
        }
        else if ((0x1 & this.C) != 0x0) {
            this.H = BigDecimal.valueOf(this.D);
        }
        else {
            this.W();
        }
        this.C |= 0x10;
    }
    
    protected void Q() {
        this.d("Numeric value (" + this.k() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
    }
    
    protected void R() {
        this.d("Numeric value (" + this.k() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
    }
    
    protected char S() {
        throw new UnsupportedOperationException();
    }
    
    protected final int a(final a a, final char c, final int n) {
        if (c != '\\') {
            throw this.b(a, c, n);
        }
        final char s = this.S();
        int b;
        if (s <= ' ' && n == 0) {
            b = -1;
        }
        else {
            b = a.b(s);
            if (b < 0) {
                throw this.b(a, s, n);
            }
        }
        return b;
    }
    
    protected final int a(final a a, final int n, final int n2) {
        if (n != 92) {
            throw this.b(a, n, n2);
        }
        final char s = this.S();
        int b;
        if (s <= ' ' && n2 == 0) {
            b = -1;
        }
        else {
            b = a.b((int)s);
            if (b < 0) {
                throw this.b(a, s, n2);
            }
        }
        return b;
    }
    
    protected IllegalArgumentException a(final a a, final int i, final int n, final String str) {
        String s;
        if (i <= 32) {
            s = "Illegal white space character (code 0x" + Integer.toHexString(i) + ") as character #" + (n + 1) + " of 4-char base64 unit: can only used between units";
        }
        else if (a.a(i)) {
            s = "Unexpected padding character ('" + a.b() + "') as character #" + (n + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        }
        else if (!Character.isDefined(i) || Character.isISOControl(i)) {
            s = "Illegal character (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        else {
            s = "Illegal character '" + (char)i + "' (code 0x" + Integer.toHexString(i) + ") in base64 content";
        }
        if (str != null) {
            s = s + ": " + str;
        }
        return new IllegalArgumentException(s);
    }
    
    protected final p a(final String s, final double f) {
        this.p.a(s);
        this.F = f;
        this.C = 8;
        return org.codehaus.jackson.p.j;
    }
    
    protected final p a(final boolean i, final int j) {
        this.I = i;
        this.J = j;
        this.K = 0;
        this.L = 0;
        this.C = 0;
        return org.codehaus.jackson.p.i;
    }
    
    protected final p a(final boolean b, final int n, final int n2, final int n3) {
        if (n2 < 1 && n3 < 1) {
            return this.a(b, n);
        }
        return this.b(b, n, n2, n3);
    }
    
    protected void a(final int n, final char c) {
        this.d("Unexpected close marker '" + (char)n + "': expected '" + c + "' (for " + this.n.d() + " starting at " + ("" + this.n.a(this.d.a())) + ")");
    }
    
    protected void a(final int n, final String str) {
        String str2 = "Unexpected character (" + org.codehaus.jackson.a.e.d(n) + ") in numeric value";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        this.d(str2);
    }
    
    protected IllegalArgumentException b(final a a, final int n, final int n2) {
        return this.a(a, n, n2, null);
    }
    
    protected final p b(final boolean i, final int j, final int k, final int l) {
        this.I = i;
        this.J = j;
        this.K = k;
        this.L = l;
        this.C = 0;
        return org.codehaus.jackson.p.j;
    }
    
    protected void b(final int n) {
        if (this.b == org.codehaus.jackson.p.i) {
            final char[] e = this.p.e();
            int d = this.p.d();
            final int j = this.J;
            if (this.I) {
                ++d;
            }
            if (j <= 9) {
                int a = org.codehaus.jackson.b.g.a(e, d, j);
                if (this.I) {
                    a = -a;
                }
                this.D = a;
                this.C = 1;
                return;
            }
            if (j <= 18) {
                long b = org.codehaus.jackson.b.g.b(e, d, j);
                if (this.I) {
                    b = -b;
                }
                if (j == 10) {
                    if (this.I) {
                        if (b >= -2147483648L) {
                            this.D = (int)b;
                            this.C = 1;
                            return;
                        }
                    }
                    else if (b <= 2147483647L) {
                        this.D = (int)b;
                        this.C = 1;
                        return;
                    }
                }
                this.E = b;
                this.C = 2;
                return;
            }
            this.a(n, e, d, j);
        }
        else {
            if (this.b == org.codehaus.jackson.p.j) {
                this.e(n);
                return;
            }
            this.d("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
        }
    }
    
    protected void b(final String str) {
        this.d("Invalid numeric value: " + str);
    }
    
    @Override
    public void close() {
        if (this.e) {
            return;
        }
        this.e = true;
        try {
            this.H();
        }
        finally {
            this.I();
        }
    }
    
    @Override
    public String g() {
        if (this.b == org.codehaus.jackson.p.b || this.b == org.codehaus.jackson.p.d) {
            return this.n.i().h();
        }
        return this.n.h();
    }
    
    @Override
    public h h() {
        return new h(this.d.a(), this.C(), this.D(), this.E());
    }
    
    @Override
    public h i() {
        return new h(this.d.a(), this.h + this.f - 1L, this.i, 1 + (this.f - this.j));
    }
    
    @Override
    public boolean o() {
        return this.b == org.codehaus.jackson.p.h || (this.b == org.codehaus.jackson.p.f && this.r);
    }
    
    @Override
    public Number p() {
        if (this.C == 0) {
            this.b(0);
        }
        if (this.b == org.codehaus.jackson.p.i) {
            if ((0x1 & this.C) != 0x0) {
                return this.D;
            }
            if ((0x2 & this.C) != 0x0) {
                return this.E;
            }
            if ((0x4 & this.C) != 0x0) {
                return this.G;
            }
            return this.H;
        }
        else {
            if ((0x10 & this.C) != 0x0) {
                return this.H;
            }
            if ((0x8 & this.C) == 0x0) {
                this.W();
            }
            return this.F;
        }
    }
    
    @Override
    public m q() {
        if (this.C == 0) {
            this.b(0);
        }
        if (this.b == org.codehaus.jackson.p.i) {
            if ((0x1 & this.C) != 0x0) {
                return org.codehaus.jackson.m.a;
            }
            if ((0x2 & this.C) != 0x0) {
                return org.codehaus.jackson.m.b;
            }
            return org.codehaus.jackson.m.c;
        }
        else {
            if ((0x10 & this.C) != 0x0) {
                return org.codehaus.jackson.m.f;
            }
            return org.codehaus.jackson.m.e;
        }
    }
    
    @Override
    public int t() {
        if ((0x1 & this.C) == 0x0) {
            if (this.C == 0) {
                this.b(1);
            }
            if ((0x1 & this.C) == 0x0) {
                this.L();
            }
        }
        return this.D;
    }
    
    @Override
    public long u() {
        if ((0x2 & this.C) == 0x0) {
            if (this.C == 0) {
                this.b(2);
            }
            if ((0x2 & this.C) == 0x0) {
                this.M();
            }
        }
        return this.E;
    }
    
    @Override
    public BigInteger v() {
        if ((0x4 & this.C) == 0x0) {
            if (this.C == 0) {
                this.b(4);
            }
            if ((0x4 & this.C) == 0x0) {
                this.N();
            }
        }
        return this.G;
    }
    
    @Override
    public float w() {
        return (float)this.x();
    }
    
    @Override
    public double x() {
        if ((0x8 & this.C) == 0x0) {
            if (this.C == 0) {
                this.b(8);
            }
            if ((0x8 & this.C) == 0x0) {
                this.O();
            }
        }
        return this.F;
    }
    
    @Override
    public BigDecimal y() {
        if ((0x10 & this.C) == 0x0) {
            if (this.C == 0) {
                this.b(16);
            }
            if ((0x10 & this.C) == 0x0) {
                this.P();
            }
        }
        return this.H;
    }
}
