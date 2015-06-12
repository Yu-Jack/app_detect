// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ib$b implements SafeParcelable
{
    public static final ia CREATOR;
    final hy$a Hp;
    final String eM;
    final int versionCode;
    
    static {
        CREATOR = new ia();
    }
    
    ib$b(final int versionCode, final String em, final hy$a hp) {
        this.versionCode = versionCode;
        this.eM = em;
        this.Hp = hp;
    }
    
    ib$b(final String em, final hy$a hp) {
        this.versionCode = 1;
        this.eM = em;
        this.Hp = hp;
    }
    
    public int describeContents() {
        final ia creator = ib$b.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final ia creator = ib$b.CREATOR;
        ia.a(this, parcel, n);
    }
}
