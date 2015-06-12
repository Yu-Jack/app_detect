// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WebImage implements SafeParcelable
{
    public static final Parcelable$Creator<WebImage> CREATOR;
    private final int a;
    private final Uri b;
    private final int c;
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new h();
    }
    
    WebImage(final int a, final Uri b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    int a() {
        return this.a;
    }
    
    public Uri b() {
        return this.b;
    }
    
    public int c() {
        return this.c;
    }
    
    public int d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null || !(o instanceof WebImage)) {
                return false;
            }
            final WebImage webImage = (WebImage)o;
            if (!gw.a(this.b, webImage.b) || this.c != webImage.c || this.d != webImage.d) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.b, this.c, this.d);
    }
    
    @Override
    public String toString() {
        return String.format("Image %dx%d %s", this.c, this.d, this.b.toString());
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        h.a(this, parcel, n);
    }
}
