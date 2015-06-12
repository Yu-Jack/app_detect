// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.wallet;

import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Cart implements SafeParcelable
{
    public static final Parcelable$Creator<Cart> CREATOR;
    String a;
    String b;
    ArrayList<LineItem> c;
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    Cart() {
        this.d = 1;
        this.c = new ArrayList<LineItem>();
    }
    
    Cart(final int d, final String a, final String b, final ArrayList<LineItem> c) {
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
        com.google.android.gms.wallet.b.a(this, parcel, n);
    }
}
