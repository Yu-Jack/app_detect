// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a$d;

final class ga$g extends fz
{
    private final a$d yR;
    
    public ga$g(final a$d a$d) {
        this.yR = (a$d)hm.b(a$d, "Holder must not be null");
    }
    
    @Override
    public void dT() {
        this.yR.a(new Status(0));
    }
}
