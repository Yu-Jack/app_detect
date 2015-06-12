// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hs implements SafeParcelable
{
    public static final ja CREATOR;
    public final int a;
    public final String b;
    public final String c;
    
    static {
        CREATOR = new ja();
    }
    
    public hs(final int a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int describeContents() {
        final ja creator = hs.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null || !(o instanceof hs)) {
                return false;
            }
            final hs hs = (hs)o;
            if (!this.c.equals(hs.c) || !this.b.equals(hs.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(new Object[] { this.b, this.c });
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("clientPackageName", this.b).a("locale", this.c).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final ja creator = hs.CREATOR;
        ja.a(this, parcel, n);
    }
}
