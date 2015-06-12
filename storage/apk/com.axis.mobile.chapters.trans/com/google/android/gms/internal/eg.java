// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.ArrayList;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.LinkedList;

public class eg
{
    private final Object ls;
    private boolean qO;
    private final eh rD;
    private final LinkedList rE;
    private final String rF;
    private final String rG;
    private long rH;
    private long rI;
    private long rJ;
    private long rK;
    private long rL;
    private long rM;
    
    public eg(final eh rd, final String rf, final String rg) {
        this.ls = new Object();
        this.rH = -1L;
        this.rI = -1L;
        this.qO = false;
        this.rJ = -1L;
        this.rK = 0L;
        this.rL = -1L;
        this.rM = -1L;
        this.rD = rd;
        this.rF = rf;
        this.rG = rg;
        this.rE = new LinkedList();
    }
    
    public eg(final String s, final String s2) {
        this(eh.bH(), s, s2);
    }
    
    public void bB() {
        synchronized (this.ls) {
            if (this.rM != -1L && this.rI == -1L) {
                this.rI = SystemClock.elapsedRealtime();
                this.rD.a(this);
            }
            final eh rd = this.rD;
            eh.bK().bB();
        }
    }
    
    public void bC() {
        synchronized (this.ls) {
            if (this.rM != -1L) {
                final eg$a e = new eg$a();
                e.bG();
                this.rE.add(e);
                ++this.rK;
                final eh rd = this.rD;
                eh.bK().bC();
                this.rD.a(this);
            }
        }
    }
    
    public void bD() {
        synchronized (this.ls) {
            if (this.rM != -1L && !this.rE.isEmpty()) {
                final eg$a eg$a = this.rE.getLast();
                if (eg$a.bE() == -1L) {
                    eg$a.bF();
                    this.rD.a(this);
                }
            }
        }
    }
    
    public void f(final ai ai) {
        synchronized (this.ls) {
            this.rL = SystemClock.elapsedRealtime();
            final eh rd = this.rD;
            eh.bK().b(ai, this.rL);
        }
    }
    
    public void j(final long rm) {
        synchronized (this.ls) {
            this.rM = rm;
            if (this.rM != -1L) {
                this.rD.a(this);
            }
        }
    }
    
    public void k(final long rh) {
        synchronized (this.ls) {
            if (this.rM != -1L) {
                this.rH = rh;
                this.rD.a(this);
            }
        }
    }
    
    public void n(final boolean b) {
        synchronized (this.ls) {
            if (this.rM != -1L) {
                this.rJ = SystemClock.elapsedRealtime();
                if (!b) {
                    this.rI = this.rJ;
                    this.rD.a(this);
                }
            }
        }
    }
    
    public void o(final boolean qo) {
        synchronized (this.ls) {
            if (this.rM != -1L) {
                this.qO = qo;
                this.rD.a(this);
            }
        }
    }
    
    public Bundle toBundle() {
        final Bundle bundle;
        final ArrayList<Bundle> list;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.rF);
            bundle.putString("slotid", this.rG);
            bundle.putBoolean("ismediation", this.qO);
            bundle.putLong("treq", this.rL);
            bundle.putLong("tresponse", this.rM);
            bundle.putLong("timp", this.rI);
            bundle.putLong("tload", this.rJ);
            bundle.putLong("pcc", this.rK);
            bundle.putLong("tfetch", this.rH);
            list = new ArrayList<Bundle>();
            final Iterator iterator = this.rE.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().toBundle());
            }
        }
        bundle.putParcelableArrayList("tclick", (ArrayList)list);
        // monitorexit(o)
        return bundle;
    }
}
