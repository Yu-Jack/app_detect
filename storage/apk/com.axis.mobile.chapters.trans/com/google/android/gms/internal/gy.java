// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;
import java.util.Collection;
import android.view.View;

public final class gy
{
    private final View DJ;
    private final gy$a FU;
    
    public gy(final String s, final Collection collection, final int n, final View dj, final String s2) {
        this.FU = new gy$a(s, collection, n, s2);
        this.DJ = dj;
    }
    
    public String fj() {
        return this.FU.fj();
    }
    
    public int fk() {
        return this.FU.fk();
    }
    
    public List fl() {
        return this.FU.fl();
    }
    
    public String[] fm() {
        return this.FU.fl().toArray(new String[0]);
    }
    
    public String fn() {
        return this.FU.fn();
    }
    
    public View fo() {
        return this.DJ;
    }
    
    public String getAccountName() {
        return this.FU.getAccountName();
    }
}
