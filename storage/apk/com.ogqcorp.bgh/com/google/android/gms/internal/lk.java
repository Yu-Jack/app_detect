// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.HashSet;
import android.content.Context;

final class lk
{
    public final lj a;
    public final String b;
    public final Context c;
    public final kw d;
    public final dx e;
    public n f;
    public ed g;
    public ak h;
    public du i;
    public dv j;
    public w k;
    public cq l;
    public eb m;
    private HashSet<dv> n;
    
    public lk(final Context c, final ak h, final String b, final dx e) {
        this.m = null;
        this.n = null;
        if (h.e) {
            this.a = null;
        }
        else {
            (this.a = new lj(c)).setMinimumWidth(h.g);
            this.a.setMinimumHeight(h.d);
            this.a.setVisibility(4);
        }
        this.h = h;
        this.b = b;
        this.c = c;
        this.d = new kw(kj.a(e.b, c));
        this.e = e;
    }
    
    public HashSet<dv> a() {
        return this.n;
    }
    
    public void a(final HashSet<dv> n) {
        this.n = n;
    }
}
