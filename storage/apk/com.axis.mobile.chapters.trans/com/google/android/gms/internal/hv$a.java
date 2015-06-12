// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hv$a implements SafeParcelable
{
    public static final hx CREATOR;
    final String GZ;
    final int Ha;
    final int versionCode;
    
    static {
        CREATOR = new hx();
    }
    
    hv$a(final int versionCode, final String gz, final int ha) {
        this.versionCode = versionCode;
        this.GZ = gz;
        this.Ha = ha;
    }
    
    hv$a(final String gz, final int ha) {
        this.versionCode = 1;
        this.GZ = gz;
        this.Ha = ha;
    }
    
    public int describeContents() {
        final hx creator = hv$a.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hx creator = hv$a.CREATOR;
        hx.a(this, parcel, n);
    }
}
