// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable
{
    public static final a CREATOR;
    private final int a;
    private final String b;
    private final int c;
    
    static {
        CREATOR = new a();
    }
    
    public ConnectionInfo(final int a, final String b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.a;
    }
    
    public String b() {
        return this.b;
    }
    
    public int c() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.games.internal.a.a(this, parcel, n);
    }
}
