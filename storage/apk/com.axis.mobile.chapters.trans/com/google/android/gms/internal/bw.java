// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Set;
import java.util.Date;
import com.google.android.gms.ads.mediation.MediationAdRequest;

public final class bw implements MediationAdRequest
{
    private final Date d;
    private final Set f;
    private final boolean g;
    private final int ml;
    private final int nR;
    
    public bw(final Date d, final int ml, final Set f, final boolean g, final int nr) {
        this.d = d;
        this.ml = ml;
        this.f = f;
        this.g = g;
        this.nR = nr;
    }
    
    @Override
    public Date getBirthday() {
        return this.d;
    }
    
    @Override
    public int getGender() {
        return this.ml;
    }
    
    @Override
    public Set getKeywords() {
        return this.f;
    }
    
    @Override
    public boolean isTesting() {
        return this.g;
    }
    
    @Override
    public int taggedForChildDirectedTreatment() {
        return this.nR;
    }
}
