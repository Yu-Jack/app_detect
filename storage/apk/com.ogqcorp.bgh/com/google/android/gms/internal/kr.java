// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;

public abstract class kr<M extends kr<M>> extends ks
{
    protected List<ku> e;
    
    @Override
    public void a(final kp kp) {
        int size;
        if (this.e == null) {
            size = 0;
        }
        else {
            size = this.e.size();
        }
        for (int i = 0; i < size; ++i) {
            final ku ku = this.e.get(i);
            kp.e(ku.a);
            kp.b(ku.b);
        }
    }
    
    @Override
    protected int c() {
        int size;
        if (this.e == null) {
            size = 0;
        }
        else {
            size = this.e.size();
        }
        int i = 0;
        int n = 0;
        while (i < size) {
            final ku ku = this.e.get(i);
            n = n + kp.f(ku.a) + ku.b.length;
            ++i;
        }
        return n;
    }
}
