// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a$d;

final class ga$a extends fz
{
    private final a$d yR;
    
    public ga$a(final a$d a$d) {
        this.yR = (a$d)hm.b(a$d, "Result holder must not be null");
    }
    
    @Override
    public void b(final int n, final int n2) {
        this.yR.a(new ga$b(new Status(n), n2));
    }
}
