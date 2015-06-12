// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fm implements SafeParcelable
{
    public static final fn CREATOR;
    public final int id;
    final int xM;
    final Bundle xY;
    
    static {
        CREATOR = new fn();
    }
    
    fm(final int xm, final int id, final Bundle xy) {
        this.xM = xm;
        this.id = id;
        this.xY = xy;
    }
    
    public int describeContents() {
        final fn creator = fm.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final fn creator = fm.CREATOR;
        fn.a(this, parcel, n);
    }
}
