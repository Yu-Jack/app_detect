// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.io.Serializable;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ki implements SafeParcelable
{
    public static final Parcelable$Creator<ki> CREATOR;
    final int a;
    private final int b;
    private final String c;
    private final byte[] d;
    private final String e;
    
    static {
        CREATOR = (Parcelable$Creator)new km();
    }
    
    ki(final int a, final int b, final String c, final byte[] d, final String e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int a() {
        return this.b;
    }
    
    public String b() {
        return this.c;
    }
    
    public byte[] c() {
        return this.d;
    }
    
    public String d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append("MessageEventParcelable[").append(this.b).append(",").append(this.c);
        Serializable value;
        if (this.d == null) {
            value = "null";
        }
        else {
            value = this.d.length;
        }
        return append.append(value).append("]").toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        km.a(this, parcel, n);
    }
}
