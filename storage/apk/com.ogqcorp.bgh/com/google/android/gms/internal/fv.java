// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fv implements SafeParcelable
{
    public static final hb CREATOR;
    private final int a;
    private final fx b;
    
    static {
        CREATOR = new hb();
    }
    
    fv(final int a, final fx b) {
        this.a = a;
        this.b = b;
    }
    
    private fv(final fx b) {
        this.a = 1;
        this.b = b;
    }
    
    public static fv a(final hh<?, ?> hh) {
        if (hh instanceof fx) {
            return new fv((fx)hh);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }
    
    int a() {
        return this.a;
    }
    
    fx b() {
        return this.b;
    }
    
    public hh<?, ?> c() {
        if (this.b != null) {
            return this.b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
    
    public int describeContents() {
        final hb creator = fv.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hb creator = fv.CREATOR;
        hb.a(this, parcel, n);
    }
}
