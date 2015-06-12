// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.g;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class InFilter<T> implements SafeParcelable, a
{
    public static final f CREATOR;
    final MetadataBundle a;
    final int b;
    private final g<T> c;
    
    static {
        CREATOR = new f();
    }
    
    InFilter(final int b, final MetadataBundle a) {
        this.b = b;
        this.a = a;
        this.c = (g<T>)(g)e.a(a);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        f.a(this, parcel, n);
    }
}
