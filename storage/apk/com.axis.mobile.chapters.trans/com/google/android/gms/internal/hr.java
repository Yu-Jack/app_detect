// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hr implements SafeParcelable
{
    public static final hs CREATOR;
    public final String GT;
    public final int GU;
    final int xM;
    
    static {
        CREATOR = new hs();
    }
    
    public hr(final int xm, final String gt, final int gu) {
        this.xM = xm;
        this.GT = gt;
        this.GU = gu;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        hs.a(this, parcel, n);
    }
}
