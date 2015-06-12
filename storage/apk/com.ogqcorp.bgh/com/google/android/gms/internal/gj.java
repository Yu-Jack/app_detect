// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.a;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Collection;
import android.os.Looper;
import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.d;
import com.google.android.gms.common.api.c;
import java.util.ArrayList;

public final class gj
{
    final ArrayList<c> a;
    private final gl b;
    private final ArrayList<c> c;
    private boolean d;
    private final ArrayList<d> e;
    private final Handler f;
    
    public gj(final Context context, final Looper looper, final gl b) {
        this.c = new ArrayList<c>();
        this.a = new ArrayList<c>();
        this.d = false;
        this.e = new ArrayList<d>();
        this.b = b;
        this.f = new gk(this, looper);
    }
    
    protected void a() {
        synchronized (this.c) {
            this.a(this.b.l());
        }
    }
    
    public void a(final int n) {
        this.f.removeMessages(1);
        synchronized (this.c) {
            this.d = true;
            for (final c o : new ArrayList<c>(this.c)) {
                if (!this.b.n()) {
                    break;
                }
                if (!this.c.contains(o)) {
                    continue;
                }
                o.a(n);
            }
            this.d = false;
        }
    }
    
    public void a(final Bundle bundle) {
        boolean b;
        boolean b2;
        Label_0019_Outer:Label_0047_Outer:
        while (true) {
            b = true;
            while (true) {
            Label_0164:
                while (true) {
                    synchronized (this.c) {
                        if (!this.d) {
                            b2 = b;
                            gz.a(b2);
                            this.f.removeMessages(1);
                            this.d = true;
                            if (this.a.size() == 0) {
                                gz.a(b);
                                for (final c o : new ArrayList<c>(this.c)) {
                                    if (!this.b.n() || !this.b.g()) {
                                        break;
                                    }
                                    if (this.a.contains(o)) {
                                        continue Label_0019_Outer;
                                    }
                                    o.a(bundle);
                                }
                                this.a.clear();
                                this.d = false;
                                return;
                            }
                            break Label_0164;
                        }
                    }
                    b2 = false;
                    continue Label_0047_Outer;
                }
                b = false;
                continue;
            }
        }
    }
    
    public void a(final a a) {
        this.f.removeMessages(1);
        synchronized (this.e) {
            for (final d o : new ArrayList<d>(this.e)) {
                if (!this.b.n()) {
                    return;
                }
                if (!this.e.contains(o)) {
                    continue;
                }
                o.a(a);
            }
        }
    }
    // monitorexit(list)
    
    public void a(final c e) {
        gz.a(e);
        synchronized (this.c) {
            if (this.c.contains(e)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + e + " is already registered");
            }
            else {
                this.c.add(e);
            }
            // monitorexit(this.c)
            if (this.b.g()) {
                this.f.sendMessage(this.f.obtainMessage(1, (Object)e));
            }
        }
    }
    
    public void a(final d e) {
        gz.a(e);
        synchronized (this.e) {
            if (this.e.contains(e)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + e + " is already registered");
            }
            else {
                this.e.add(e);
            }
        }
    }
}
