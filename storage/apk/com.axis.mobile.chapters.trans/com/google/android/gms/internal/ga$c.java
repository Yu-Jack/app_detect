// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.api.a$d;

final class ga$c extends fz
{
    private final a$d yR;
    
    public ga$c(final a$d a$d) {
        this.yR = (a$d)hm.b(a$d, "Result holder must not be null");
    }
    
    @Override
    public void a(final DataHolder dataHolder) {
        this.yR.a(new ga$d(dataHolder));
    }
}
