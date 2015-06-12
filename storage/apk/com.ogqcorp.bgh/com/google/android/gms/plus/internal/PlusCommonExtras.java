// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlusCommonExtras implements SafeParcelable
{
    public static final a CREATOR;
    public static String a;
    private final int b;
    private String c;
    private String d;
    
    static {
        PlusCommonExtras.a = "PlusCommonExtras";
        CREATOR = new a();
    }
    
    public PlusCommonExtras() {
        this.b = 1;
        this.c = "";
        this.d = "";
    }
    
    PlusCommonExtras(final int b, final String c, final String d) {
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int a() {
        return this.b;
    }
    
    public String b() {
        return this.c;
    }
    
    public String c() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof PlusCommonExtras) {
            final PlusCommonExtras plusCommonExtras = (PlusCommonExtras)o;
            if (this.b == plusCommonExtras.b && gw.a(this.c, plusCommonExtras.c) && gw.a(this.d, plusCommonExtras.d)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.b, this.c, this.d);
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("versionCode", this.b).a("Gpsrc", this.c).a("ClientCallingPackage", this.d).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.plus.internal.a.a(this, parcel, n);
    }
}
