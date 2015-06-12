// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Result;

abstract class fy$a implements Result
{
    protected final Object yA;
    private final Status yz;
    
    public fy$a(final Status yz, final Object ya) {
        this.yz = yz;
        this.yA = ya;
    }
    
    @Override
    public Status getStatus() {
        return this.yz;
    }
}
