// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class fx$a implements SafeParcelable
{
    public static final he CREATOR;
    final int a;
    final String b;
    final int c;
    
    static {
        CREATOR = new he();
    }
    
    fx$a(final int a, final String b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    fx$a(final String b, final int c) {
        this.a = 1;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        final he creator = fx$a.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final he creator = fx$a.CREATOR;
        he.a(this, parcel, n);
    }
}
