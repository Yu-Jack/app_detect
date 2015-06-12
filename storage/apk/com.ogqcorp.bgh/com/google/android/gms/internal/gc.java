// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.c;

public final class gc implements c
{
    private final com.google.android.gms.common.c a;
    
    public gc(final com.google.android.gms.common.c a) {
        this.a = a;
    }
    
    @Override
    public void a(final int n) {
        this.a.a_();
    }
    
    @Override
    public void a(final Bundle bundle) {
        this.a.a(bundle);
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof gc) {
            return this.a.equals(((gc)obj).a);
        }
        return this.a.equals(obj);
    }
}
