// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.maps.model.LatLng;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ho implements SafeParcelable
{
    public static final Parcelable$Creator<ho> CREATOR;
    final int a;
    private final String b;
    private final LatLng c;
    private final String d;
    private final List<hm> e;
    private final String f;
    private final String g;
    
    static {
        CREATOR = (Parcelable$Creator)new iz();
    }
    
    ho(final int a, final String b, final LatLng c, final String d, final List<hm> c2, final String f, final String g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = new ArrayList<hm>(c2);
        this.f = f;
        this.g = g;
    }
    
    public String a() {
        return this.b;
    }
    
    public LatLng b() {
        return this.c;
    }
    
    public String c() {
        return this.d;
    }
    
    public List<hm> d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String e() {
        return this.f;
    }
    
    public String f() {
        return this.g;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        iz.a(this, parcel, n);
    }
}
