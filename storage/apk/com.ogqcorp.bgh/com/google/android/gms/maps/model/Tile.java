// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

import com.google.android.gms.maps.a.b;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Tile implements SafeParcelable
{
    public static final o CREATOR;
    public final int a;
    public final int b;
    public final byte[] c;
    private final int d;
    
    static {
        CREATOR = new o();
    }
    
    Tile(final int d, final int a, final int b, final byte[] c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Tile(final int n, final int n2, final byte[] array) {
        this(1, n, n2, array);
    }
    
    int a() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (com.google.android.gms.maps.a.b.a()) {
            aa.a(this, parcel, n);
            return;
        }
        o.a(this, parcel, n);
    }
}
