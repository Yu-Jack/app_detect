// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.IBinder;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gf;
import java.util.HashSet;

final class gn
{
    final /* synthetic */ gm a;
    private final String b;
    private final go c;
    private final HashSet<gf> d;
    private int e;
    private boolean f;
    private IBinder g;
    private ComponentName h;
    
    public gn(final gm a, final String b) {
        this.a = a;
        this.b = b;
        this.c = new go(this);
        this.d = new HashSet<gf>();
        this.e = 0;
    }
    
    public go a() {
        return this.c;
    }
    
    public void a(final gf e) {
        this.d.add(e);
    }
    
    public void a(final boolean f) {
        this.f = f;
    }
    
    public String b() {
        return this.b;
    }
    
    public void b(final gf o) {
        this.d.remove(o);
    }
    
    public boolean c() {
        return this.f;
    }
    
    public boolean c(final gf o) {
        return this.d.contains(o);
    }
    
    public int d() {
        return this.e;
    }
    
    public boolean e() {
        return this.d.isEmpty();
    }
    
    public IBinder f() {
        return this.g;
    }
    
    public ComponentName g() {
        return this.h;
    }
}
