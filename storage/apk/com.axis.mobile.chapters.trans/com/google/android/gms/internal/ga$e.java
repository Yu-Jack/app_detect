// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.api.a$d;

final class ga$e extends fz
{
    private final a$d yR;
    
    public ga$e(final a$d a$d) {
        this.yR = (a$d)hm.b(a$d, "Result holder must not be null");
    }
    
    @Override
    public void a(final int n, final DataHolder dataHolder) {
        this.yR.a(new ga$f(n, dataHolder));
    }
}
