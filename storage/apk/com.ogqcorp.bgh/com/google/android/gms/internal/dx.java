// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class dx implements SafeParcelable
{
    public static final eo CREATOR;
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;
    
    static {
        CREATOR = new eo();
    }
    
    public dx(final int i, final int j, final boolean b) {
        final StringBuilder append = new StringBuilder().append("afma-sdk-a-v").append(i).append(".").append(j).append(".");
        String str;
        if (b) {
            str = "0";
        }
        else {
            str = "1";
        }
        this(1, append.append(str).toString(), i, j, b);
    }
    
    dx(final int a, final String b, final int c, final int d, final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        eo.a(this, parcel, n);
    }
}
