// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.a;
import com.google.android.gms.common.api.d;

public final class gh implements d
{
    private final com.google.android.gms.common.d a;
    
    public gh(final com.google.android.gms.common.d a) {
        this.a = a;
    }
    
    @Override
    public void a(final a a) {
        this.a.a(a);
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof gh) {
            return this.a.equals(((gh)obj).a);
        }
        return this.a.equals(obj);
    }
}
