// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hk implements SafeParcelable
{
    public static final iw CREATOR;
    static final long a;
    final int b;
    private final hg c;
    private final long d;
    private final int e;
    
    static {
        CREATOR = new iw();
        a = TimeUnit.HOURS.toMillis(1L);
    }
    
    public hk(final int b, final hg c, final long d, final int e) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public hg a() {
        return this.c;
    }
    
    public long b() {
        return this.d;
    }
    
    public int c() {
        return this.e;
    }
    
    public int describeContents() {
        final iw creator = hk.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof hk)) {
                return false;
            }
            final hk hk = (hk)o;
            if (!this.c.equals(hk.c) || this.d != hk.d || this.e != hk.e) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.c, this.d, this.e);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("filter", this.c).a("interval", this.d).a("priority", this.e).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final iw creator = hk.CREATOR;
        iw.a(this, parcel, n);
    }
}
