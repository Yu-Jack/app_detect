// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class gy$a implements SafeParcelable
{
    public static final hl CREATOR;
    private final int DI;
    private final String DK;
    private final List Ef;
    private final int xM;
    private final String yQ;
    
    static {
        CREATOR = new hl();
    }
    
    gy$a(final int xm, final String yq, final List list, final int di, final String dk) {
        this.Ef = new ArrayList();
        this.xM = xm;
        this.yQ = yq;
        this.Ef.addAll(list);
        this.DI = di;
        this.DK = dk;
    }
    
    public gy$a(final String s, final Collection c, final int n, final String s2) {
        this(3, s, new ArrayList(c), n, s2);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String fj() {
        if (this.yQ != null) {
            return this.yQ;
        }
        return "<<default account>>";
    }
    
    public int fk() {
        return this.DI;
    }
    
    public List fl() {
        return new ArrayList(this.Ef);
    }
    
    public String fn() {
        return this.DK;
    }
    
    public String getAccountName() {
        return this.yQ;
    }
    
    public int getVersionCode() {
        return this.xM;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        hl.a(this, parcel, n);
    }
}
