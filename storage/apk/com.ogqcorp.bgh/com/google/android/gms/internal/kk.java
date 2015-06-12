// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class kk implements SafeParcelable
{
    public static final Parcelable$Creator<kk> CREATOR;
    final int a;
    private final String b;
    private final String c;
    
    static {
        CREATOR = (Parcelable$Creator)new kn();
    }
    
    kk(final int a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public String a() {
        return this.b;
    }
    
    public String b() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof kk) {
            final kk kk = (kk)o;
            if (kk.b.equals(this.b) && kk.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 37 * (629 + this.b.hashCode()) + this.c.hashCode();
    }
    
    @Override
    public String toString() {
        return "NodeParcelable{" + this.b + "," + this.c + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        kn.a(this, parcel, n);
    }
}
