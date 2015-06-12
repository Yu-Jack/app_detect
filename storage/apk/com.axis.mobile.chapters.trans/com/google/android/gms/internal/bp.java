// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import android.text.TextUtils;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import android.content.Context;

public final class bp implements bq$a
{
    private final bt kB;
    private final ai lh;
    private final Object ls;
    private final Context mContext;
    private final String nC;
    private final long nD;
    private final bl nE;
    private final al nF;
    private final ev nG;
    private bu nH;
    private int nI;
    
    public bp(final Context mContext, final String s, final bt kb, final bm bm, final bl ne, final ai lh, final al nf, final ev ng) {
        this.ls = new Object();
        this.nI = -2;
        this.mContext = mContext;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(s)) {
            this.nC = this.b(ne);
        }
        else {
            this.nC = s;
        }
        this.kB = kb;
        long ns;
        if (bm.ns != -1L) {
            ns = bm.ns;
        }
        else {
            ns = 10000L;
        }
        this.nD = ns;
        this.nE = ne;
        this.lh = lh;
        this.nF = nf;
        this.nG = ng;
    }
    
    private void a(final long n, final long n2, final long n3, final long n4) {
        while (this.nI == -2) {
            this.b(n, n2, n3, n4);
        }
    }
    
    private void a(final bo bo) {
        try {
            if (this.nG.sy < 4100000) {
                if (this.nF.mf) {
                    this.nH.a(e.h(this.mContext), this.lh, this.nE.nq, bo);
                    return;
                }
                this.nH.a(e.h(this.mContext), this.nF, this.lh, this.nE.nq, bo);
                return;
            }
        }
        catch (RemoteException ex) {
            eu.c("Could not request ad from mediation adapter.", (Throwable)ex);
            this.g(5);
            return;
        }
        if (this.nF.mf) {
            this.nH.a(e.h(this.mContext), this.lh, this.nE.nq, this.nE.nk, bo);
            return;
        }
        this.nH.a(e.h(this.mContext), this.nF, this.lh, this.nE.nq, this.nE.nk, bo);
    }
    
    private bu aP() {
        eu.B("Instantiating mediation adapter: " + this.nC);
        try {
            return this.kB.m(this.nC);
        }
        catch (RemoteException ex) {
            eu.a("Could not instantiate mediation adapter: " + this.nC, (Throwable)ex);
            return null;
        }
    }
    
    private String b(final bl bl) {
        try {
            if (!TextUtils.isEmpty((CharSequence)bl.no) && CustomEvent.class.isAssignableFrom(Class.forName(bl.no, false, bp.class.getClassLoader()))) {
                return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
            }
        }
        catch (ClassNotFoundException ex) {
            eu.D("Could not create custom event adapter.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }
    
    private void b(final long n, final long n2, final long n3, final long n4) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long a = n2 - (elapsedRealtime - n);
        final long b = n4 - (elapsedRealtime - n3);
        if (a <= 0L || b <= 0L) {
            eu.B("Timed out waiting for adapter.");
            this.nI = 3;
            return;
        }
        try {
            this.ls.wait(Math.min(a, b));
        }
        catch (InterruptedException ex) {
            this.nI = -1;
        }
    }
    
    public bq b(final long n, final long n2) {
        synchronized (this.ls) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final bo bo = new bo();
            et.sv.post((Runnable)new bp$1(this, bo));
            this.a(elapsedRealtime, this.nD, n, n2);
            return new bq(this.nE, this.nH, this.nC, bo, this.nI);
        }
    }
    
    public void cancel() {
        synchronized (this.ls) {
            while (true) {
                try {
                    if (this.nH != null) {
                        this.nH.destroy();
                    }
                    this.nI = -1;
                    this.ls.notify();
                }
                catch (RemoteException ex) {
                    eu.c("Could not destroy mediation adapter.", (Throwable)ex);
                    continue;
                }
                break;
            }
        }
    }
    
    @Override
    public void g(final int ni) {
        synchronized (this.ls) {
            this.nI = ni;
            this.ls.notify();
        }
    }
}
