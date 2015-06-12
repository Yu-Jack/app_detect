// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable
{
    public static final Parcelable$Creator<ProxyCard> CREATOR;
    String a;
    String b;
    int c;
    int d;
    private final int e;
    
    static {
        CREATOR = (Parcelable$Creator)new o();
    }
    
    ProxyCard(final int e, final String a, final String b, final int c, final int d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int a() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        o.a(this, parcel, n);
    }
}
