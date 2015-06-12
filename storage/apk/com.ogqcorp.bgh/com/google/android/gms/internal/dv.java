// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.ArrayList;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.LinkedList;

public class dv
{
    private final dy a;
    private final LinkedList<dw> b;
    private final Object c;
    private final String d;
    private final String e;
    private long f;
    private long g;
    private boolean h;
    private long i;
    private long j;
    private long k;
    private long l;
    
    public dv(final dy a, final String d, final String e) {
        this.c = new Object();
        this.f = -1L;
        this.g = -1L;
        this.h = false;
        this.i = -1L;
        this.j = 0L;
        this.k = -1L;
        this.l = -1L;
        this.a = a;
        this.d = d;
        this.e = e;
        this.b = new LinkedList<dw>();
    }
    
    public dv(final String s, final String s2) {
        this(dy.a(), s, s2);
    }
    
    public void a() {
        synchronized (this.c) {
            if (this.l != -1L && this.g == -1L) {
                this.g = SystemClock.elapsedRealtime();
                this.a.a(this);
            }
            final dy a = this.a;
            dy.d().c();
        }
    }
    
    public void a(final long l) {
        synchronized (this.c) {
            this.l = l;
            if (this.l != -1L) {
                this.a.a(this);
            }
        }
    }
    
    public void a(final ah ah) {
        synchronized (this.c) {
            this.k = SystemClock.elapsedRealtime();
            final dy a = this.a;
            dy.d().a(ah, this.k);
        }
    }
    
    public void a(final boolean b) {
        synchronized (this.c) {
            if (this.l != -1L) {
                this.i = SystemClock.elapsedRealtime();
                if (!b) {
                    this.g = this.i;
                    this.a.a(this);
                }
            }
        }
    }
    
    public void b() {
        synchronized (this.c) {
            if (this.l != -1L) {
                final dw e = new dw();
                e.c();
                this.b.add(e);
                ++this.j;
                final dy a = this.a;
                dy.d().b();
                this.a.a(this);
            }
        }
    }
    
    public void b(final long f) {
        synchronized (this.c) {
            if (this.l != -1L) {
                this.f = f;
                this.a.a(this);
            }
        }
    }
    
    public void b(final boolean h) {
        synchronized (this.c) {
            if (this.l != -1L) {
                this.h = h;
                this.a.a(this);
            }
        }
    }
    
    public void c() {
        synchronized (this.c) {
            if (this.l != -1L && !this.b.isEmpty()) {
                final dw dw = this.b.getLast();
                if (dw.a() == -1L) {
                    dw.b();
                    this.a.a(this);
                }
            }
        }
    }
    
    public Bundle d() {
        final Bundle bundle;
        final ArrayList<Bundle> list;
        synchronized (this.c) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.d);
            bundle.putString("slotid", this.e);
            bundle.putBoolean("ismediation", this.h);
            bundle.putLong("treq", this.k);
            bundle.putLong("tresponse", this.l);
            bundle.putLong("timp", this.g);
            bundle.putLong("tload", this.i);
            bundle.putLong("pcc", this.j);
            bundle.putLong("tfetch", this.f);
            list = new ArrayList<Bundle>();
            final Iterator<dw> iterator = this.b.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().d());
            }
        }
        bundle.putParcelableArrayList("tclick", (ArrayList)list);
        // monitorexit(o)
        return bundle;
    }
}
