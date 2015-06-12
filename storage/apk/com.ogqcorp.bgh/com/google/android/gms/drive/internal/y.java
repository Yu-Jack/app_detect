// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.ku;
import java.util.List;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.kr;

public final class y extends kr<y>
{
    public int a;
    public String b;
    public long c;
    public long d;
    
    public y() {
        this.a();
    }
    
    public y a() {
        this.a = 1;
        this.b = "";
        this.c = -1L;
        this.d = -1L;
        this.e = null;
        this.f = -1;
        return this;
    }
    
    @Override
    public void a(final kp kp) {
        kp.a(1, this.a);
        kp.a(2, this.b);
        kp.b(3, this.c);
        kp.b(4, this.d);
        super.a(kp);
    }
    
    @Override
    public int b() {
        return this.f = super.b() + kp.b(1, this.a) + kp.b(2, this.b) + kp.c(3, this.c) + kp.c(4, this.d);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof y;
            b = false;
            if (b2) {
                final y y = (y)o;
                final int a = this.a;
                final int a2 = y.a;
                b = false;
                if (a == a2) {
                    if (this.b == null) {
                        final String b3 = y.b;
                        b = false;
                        if (b3 != null) {
                            return b;
                        }
                    }
                    else if (!this.b.equals(y.b)) {
                        return false;
                    }
                    final long n = lcmp(this.c, y.c);
                    b = false;
                    if (n == 0) {
                        final long n2 = lcmp(this.d, y.d);
                        b = false;
                        if (n2 == 0) {
                            if (this.e == null || this.e.isEmpty()) {
                                if (y.e != null) {
                                    final boolean empty = y.e.isEmpty();
                                    b = false;
                                    if (!empty) {
                                        return b;
                                    }
                                }
                                return true;
                            }
                            return this.e.equals(y.e);
                        }
                    }
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (527 + this.a);
        int hashCode;
        if (this.b == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.b.hashCode();
        }
        final int n2 = 31 * (31 * (31 * (hashCode + n) + (int)(this.c ^ this.c >>> 32)) + (int)(this.d ^ this.d >>> 32));
        final List<ku> e = this.e;
        int hashCode2 = 0;
        if (e != null) {
            final boolean empty = this.e.isEmpty();
            hashCode2 = 0;
            if (!empty) {
                hashCode2 = this.e.hashCode();
            }
        }
        return n2 + hashCode2;
    }
}
