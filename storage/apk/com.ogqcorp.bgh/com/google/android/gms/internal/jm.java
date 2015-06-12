// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jm implements SafeParcelable
{
    public static final Parcelable$Creator<jm> CREATOR;
    String a;
    String b;
    ArrayList<jk> c;
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new kb();
    }
    
    jm() {
        this.d = 1;
        this.c = hr.a();
    }
    
    jm(final int d, final String a, final String b, final ArrayList<jk> c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int a() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        kb.a(this, parcel, n);
    }
}
