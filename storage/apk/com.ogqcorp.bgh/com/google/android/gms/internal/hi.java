// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hi implements SafeParcelable
{
    public static final iu CREATOR;
    final int a;
    private final String b;
    private final String c;
    
    static {
        CREATOR = new iu();
    }
    
    hi(final int a, final String b, final String c) {
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
        final iu creator = hi.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof hi) {
            final hi hi = (hi)o;
            if (gw.a(this.b, hi.b) && gw.a(this.c, hi.c)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return gw.a(new Object[] { this.b, this.c });
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("mPlaceId", this.b).a("mTag", this.c).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final iu creator = hi.CREATOR;
        iu.a(this, parcel, n);
    }
}
