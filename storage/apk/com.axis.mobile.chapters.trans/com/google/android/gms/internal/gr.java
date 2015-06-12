// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONObject;
import android.os.SystemClock;

public final class gr
{
    private static final gn BG;
    public static final Object CN;
    private long CJ;
    private long CK;
    private long CL;
    private gq CM;
    
    static {
        BG = new gn("RequestTracker");
        CN = new Object();
    }
    
    public gr(final long cj) {
        this.CJ = cj;
        this.CK = -1L;
        this.CL = 0L;
    }
    
    private void eu() {
        this.CK = -1L;
        this.CM = null;
        this.CL = 0L;
    }
    
    public void a(final long ck, final gq cm) {
        synchronized (gr.CN) {
            final gq cm2 = this.CM;
            final long ck2 = this.CK;
            this.CK = ck;
            this.CM = cm;
            this.CL = SystemClock.elapsedRealtime();
            // monitorexit(gr.CN)
            if (cm2 != null) {
                cm2.n(ck2);
            }
        }
    }
    
    public boolean b(final long n, final int n2, final JSONObject jsonObject) {
        while (true) {
            boolean b = true;
            while (true) {
                synchronized (gr.CN) {
                    if (this.CK != -1L && this.CK == n) {
                        gr.BG.b("request %d completed", this.CK);
                        final gq cm = this.CM;
                        this.eu();
                        // monitorexit(gr.CN)
                        if (cm != null) {
                            cm.a(n, n2, jsonObject);
                        }
                        return b;
                    }
                }
                final gq cm = null;
                b = false;
                continue;
            }
        }
    }
    
    public boolean c(final long n, final int n2) {
        return this.b(n, n2, null);
    }
    
    public void clear() {
        synchronized (gr.CN) {
            if (this.CK != -1L) {
                this.eu();
            }
        }
    }
    
    public boolean d(final long n, final int n2) {
        while (true) {
            boolean b = true;
            long ck = 0L;
            while (true) {
                synchronized (gr.CN) {
                    if (this.CK != -1L && n - this.CL >= this.CJ) {
                        gr.BG.b("request %d timed out", this.CK);
                        ck = this.CK;
                        final gq cm = this.CM;
                        this.eu();
                        // monitorexit(gr.CN)
                        if (cm != null) {
                            cm.a(ck, n2, null);
                        }
                        return b;
                    }
                }
                final gq cm = null;
                b = false;
                continue;
            }
        }
    }
    
    public boolean ev() {
        while (true) {
            synchronized (gr.CN) {
                if (this.CK != -1L) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public boolean p(final long n) {
        while (true) {
            synchronized (gr.CN) {
                if (this.CK != -1L && this.CK == n) {
                    return true;
                }
            }
            return false;
        }
    }
}
