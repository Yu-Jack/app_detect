// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.content.Context;

public final class bk
{
    private final bt kB;
    private final Object ls;
    private final Context mContext;
    private final ds ne;
    private final bm nf;
    private boolean ng;
    private bp nh;
    
    public bk(final Context mContext, final ds ne, final bt kb, final bm nf) {
        this.ls = new Object();
        this.ng = false;
        this.mContext = mContext;
        this.ne = ne;
        this.kB = kb;
        this.nf = nf;
    }
    
    public bq a(final long n, final long n2) {
        eu.z("Starting mediation.");
        for (final bl bl : this.nf.nr) {
            eu.B("Trying mediation network: " + bl.nl);
            for (final String s : bl.nm) {
                final bq b;
                synchronized (this.ls) {
                    if (this.ng) {
                        return new bq(-1);
                    }
                    this.nh = new bp(this.mContext, s, this.kB, this.nf, bl, this.ne.pX, this.ne.kT, this.ne.kQ);
                    // monitorexit(this.ls)
                    b = this.nh.b(n, n2);
                    if (b.nL == 0) {
                        eu.z("Adapter succeeded.");
                        return b;
                    }
                }
                if (b.nN != null) {
                    et.sv.post((Runnable)new bk$1(this, b));
                }
            }
        }
        return new bq(1);
    }
    
    public void cancel() {
        synchronized (this.ls) {
            this.ng = true;
            if (this.nh != null) {
                this.nh.cancel();
            }
        }
    }
}
