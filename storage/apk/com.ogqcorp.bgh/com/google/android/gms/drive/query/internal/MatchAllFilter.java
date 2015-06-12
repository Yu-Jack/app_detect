// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class MatchAllFilter implements SafeParcelable, a
{
    public static final h CREATOR;
    final int a;
    
    static {
        CREATOR = new h();
    }
    
    public MatchAllFilter() {
        this(1);
    }
    
    MatchAllFilter(final int a) {
        this.a = a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        h.a(this, parcel, n);
    }
}
