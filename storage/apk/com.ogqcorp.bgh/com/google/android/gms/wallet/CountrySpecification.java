// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable
{
    public static final Parcelable$Creator<CountrySpecification> CREATOR;
    String a;
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
    }
    
    CountrySpecification(final int b, final String a) {
        this.b = b;
        this.a = a;
    }
    
    public int a() {
        return this.b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        c.a(this, parcel, n);
    }
}
