// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import java.io.InputStreamReader;
import org.codehaus.jackson.b.f;
import java.io.ByteArrayInputStream;
import java.io.Reader;
import org.codehaus.jackson.l;
import org.codehaus.jackson.k;
import org.codehaus.jackson.e.d;
import org.codehaus.jackson.e.a;
import org.codehaus.jackson.q;
import java.io.CharConversionException;
import java.io.InputStream;
import org.codehaus.jackson.b.c;

public final class a
{
    protected final c a;
    protected final InputStream b;
    protected final byte[] c;
    protected int d;
    protected boolean e;
    protected int f;
    private int g;
    private int h;
    private final boolean i;
    
    public a(final c a, final InputStream b) {
        this.e = true;
        this.f = 0;
        this.a = a;
        this.b = b;
        this.c = a.e();
        this.g = 0;
        this.h = 0;
        this.d = 0;
        this.i = true;
    }
    
    public a(final c a, final byte[] c, final int g, final int n) {
        this.e = true;
        this.f = 0;
        this.a = a;
        this.b = null;
        this.c = c;
        this.g = g;
        this.h = g + n;
        this.d = -g;
        this.i = false;
    }
    
    private void a(final String str) {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }
    
    private boolean b(final int n) {
        switch (n) {
            case 65279: {
                this.e = true;
                this.g += 4;
                this.f = 4;
                return true;
            }
            case -131072: {
                this.g += 4;
                this.f = 4;
                this.e = false;
                return true;
            }
            case 65534: {
                this.a("2143");
            }
            case -16842752: {
                this.a("3412");
                break;
            }
        }
        final int n2 = n >>> 16;
        if (n2 == 65279) {
            this.g += 2;
            this.f = 2;
            return this.e = true;
        }
        if (n2 == 65534) {
            this.g += 2;
            this.f = 2;
            this.e = false;
            return true;
        }
        if (n >>> 8 == 15711167) {
            this.g += 3;
            this.f = 1;
            return this.e = true;
        }
        return false;
    }
    
    private boolean c(final int n) {
        if (n >> 8 == 0) {
            this.e = true;
        }
        else if ((0xFFFFFF & n) == 0x0) {
            this.e = false;
        }
        else if ((0xFF00FFFF & n) == 0x0) {
            this.a("3412");
        }
        else {
            final int n2 = 0xFFFF00FF & n;
            final boolean b = false;
            if (n2 != 0) {
                return b;
            }
            this.a("2143");
        }
        this.f = 4;
        return true;
    }
    
    private boolean d(final int n) {
        if ((0xFF00 & n) == 0x0) {
            this.e = true;
        }
        else {
            final int n2 = n & 0xFF;
            final boolean b = false;
            if (n2 != 0) {
                return b;
            }
            this.e = false;
        }
        this.f = 2;
        return true;
    }
    
    public org.codehaus.jackson.c a() {
        int n = 1;
        while (true) {
            Label_0122: {
                if (this.a(4)) {
                    final int n2 = this.c[this.g] << 24 | (0xFF & this.c[1 + this.g]) << 16 | (0xFF & this.c[2 + this.g]) << 8 | (0xFF & this.c[3 + this.g]);
                    if (!this.b(n2) && !this.c(n2) && !this.d(n2 >>> 16)) {
                        break Label_0122;
                    }
                }
                else if (!this.a(2) || !this.d((0xFF & this.c[this.g]) << 8 | (0xFF & this.c[1 + this.g]))) {
                    break Label_0122;
                }
                org.codehaus.jackson.c c = null;
                if (n == 0) {
                    c = org.codehaus.jackson.c.a;
                }
                else {
                    switch (this.f) {
                        default: {
                            throw new RuntimeException("Internal error");
                        }
                        case 1: {
                            c = org.codehaus.jackson.c.a;
                            break;
                        }
                        case 2: {
                            if (this.e) {
                                c = org.codehaus.jackson.c.b;
                                break;
                            }
                            c = org.codehaus.jackson.c.c;
                            break;
                        }
                        case 4: {
                            if (this.e) {
                                c = org.codehaus.jackson.c.d;
                                break;
                            }
                            c = org.codehaus.jackson.c.e;
                            break;
                        }
                    }
                }
                this.a.a(c);
                return c;
            }
            n = 0;
            continue;
        }
    }
    
    public k a(final int n, final q q, final org.codehaus.jackson.e.a a, final d d) {
        final org.codehaus.jackson.c a2 = this.a();
        final boolean a3 = l.j.a(n);
        final boolean a4 = l.i.a(n);
        if (a2 == org.codehaus.jackson.c.a && a3) {
            return new j(this.a, n, this.b, q, a.a(a3, a4), this.c, this.g, this.h, this.i);
        }
        return new h(this.a, n, this.b(), q, d.a(a3, a4));
    }
    
    protected boolean a(final int n) {
        int n2 = 1;
        int read;
        for (int i = this.h - this.g; i < n; i += read) {
            if (this.b == null) {
                read = -1;
            }
            else {
                read = this.b.read(this.c, this.h, this.c.length - this.h);
            }
            if (read < n2) {
                n2 = 0;
                break;
            }
            this.h += read;
        }
        return n2 != 0;
    }
    
    public Reader b() {
        final org.codehaus.jackson.c b = this.a.b();
        switch (a$1.a[b.ordinal()]) {
            default: {
                throw new RuntimeException("Internal error");
            }
            case 1:
            case 2: {
                return new org.codehaus.jackson.b.l(this.a, this.b, this.c, this.g, this.h, this.a.b().b());
            }
            case 3:
            case 4:
            case 5: {
                final InputStream b2 = this.b;
                InputStream in;
                if (b2 == null) {
                    in = new ByteArrayInputStream(this.c, this.g, this.h);
                }
                else if (this.g < this.h) {
                    in = new f(this.a, b2, this.c, this.g, this.h);
                }
                else {
                    in = b2;
                }
                return new InputStreamReader(in, b.a());
            }
        }
    }
}
