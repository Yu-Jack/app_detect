// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.cast;

import android.os.Parcel;
import java.util.ArrayList;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ApplicationMetadata implements SafeParcelable
{
    public static final Parcelable$Creator<ApplicationMetadata> CREATOR;
    String a;
    String b;
    List<WebImage> c;
    List<String> d;
    String e;
    Uri f;
    private final int g;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    private ApplicationMetadata() {
        this.g = 1;
        this.c = new ArrayList<WebImage>();
        this.d = new ArrayList<String>();
    }
    
    ApplicationMetadata(final int g, final String a, final String b, final List<WebImage> c, final List<String> d, final String e, final Uri f) {
        this.g = g;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    int a() {
        return this.g;
    }
    
    public String b() {
        return this.a;
    }
    
    public String c() {
        return this.b;
    }
    
    public String d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public Uri e() {
        return this.f;
    }
    
    public List<WebImage> f() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.cast.a.a(this, parcel, n);
    }
}
