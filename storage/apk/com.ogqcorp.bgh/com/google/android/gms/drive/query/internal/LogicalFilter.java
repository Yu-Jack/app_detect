// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogicalFilter implements SafeParcelable, a
{
    public static final Parcelable$Creator<LogicalFilter> CREATOR;
    final Operator a;
    final List<FilterHolder> b;
    final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    LogicalFilter(final int c, final Operator a, final List<FilterHolder> b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        g.a(this, parcel, n);
    }
}
