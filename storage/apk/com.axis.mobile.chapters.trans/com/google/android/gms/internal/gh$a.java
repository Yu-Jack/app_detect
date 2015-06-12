// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast$ApplicationConnectionResult;

final class gh$a implements Cast$ApplicationConnectionResult
{
    private final ApplicationMetadata Ci;
    private final String Cj;
    private final boolean Ck;
    private final String rR;
    private final Status yz;
    
    public gh$a(final Status status) {
        this(status, null, null, null, false);
    }
    
    public gh$a(final Status yz, final ApplicationMetadata ci, final String cj, final String rr, final boolean ck) {
        this.yz = yz;
        this.Ci = ci;
        this.Cj = cj;
        this.rR = rr;
        this.Ck = ck;
    }
    
    @Override
    public ApplicationMetadata getApplicationMetadata() {
        return this.Ci;
    }
    
    @Override
    public String getApplicationStatus() {
        return this.Cj;
    }
    
    @Override
    public String getSessionId() {
        return this.rR;
    }
    
    @Override
    public Status getStatus() {
        return this.yz;
    }
    
    @Override
    public boolean getWasLaunched() {
        return this.Ck;
    }
}
