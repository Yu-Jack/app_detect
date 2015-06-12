// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gd$b implements SafeParcelable
{
    public static final hl CREATOR;
    final int a;
    final String b;
    final ga$a<?, ?> c;
    
    static {
        CREATOR = new hl();
    }
    
    gd$b(final int a, final String b, final ga$a<?, ?> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    gd$b(final String b, final ga$a<?, ?> c) {
        this.a = 1;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        final hl creator = gd$b.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hl creator = gd$b.CREATOR;
        hl.a(this, parcel, n);
    }
}
