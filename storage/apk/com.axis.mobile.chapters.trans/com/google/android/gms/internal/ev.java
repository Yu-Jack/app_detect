// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ev implements SafeParcelable
{
    public static final ew CREATOR;
    public String sw;
    public int sx;
    public int sy;
    public boolean sz;
    public final int versionCode;
    
    static {
        CREATOR = new ew();
    }
    
    public ev(final int i, final int j, final boolean b) {
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
    
    ev(final int versionCode, final String sw, final int sx, final int sy, final boolean sz) {
        this.versionCode = versionCode;
        this.sw = sw;
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ew.a(this, parcel, n);
    }
}
