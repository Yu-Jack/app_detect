// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class fc$a implements SafeParcelable
{
    public static final gy CREATOR;
    private final int a;
    private final String b;
    private final List<String> c;
    private final int d;
    private final String e;
    
    static {
        CREATOR = new gy();
    }
    
    fc$a(final int a, final String b, final List<String> list, final int d, final String e) {
        this.c = new ArrayList<String>();
        this.a = a;
        this.b = b;
        this.c.addAll(list);
        this.d = d;
        this.e = e;
    }
    
    public String a() {
        return this.b;
    }
    
    public int b() {
        return this.d;
    }
    
    public String c() {
        return this.e;
    }
    
    public List<String> d() {
        return new ArrayList<String>(this.c);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int e() {
        return this.a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        gy.a(this, parcel, n);
    }
}
