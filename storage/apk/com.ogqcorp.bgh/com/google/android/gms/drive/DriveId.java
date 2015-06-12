// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.ks;
import com.google.android.gms.drive.internal.y;
import android.util.Base64;
import com.google.android.gms.internal.gz;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveId implements SafeParcelable
{
    public static final Parcelable$Creator<DriveId> CREATOR;
    final int a;
    final String b;
    final long c;
    final long d;
    private volatile String e;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    DriveId(final int a, final String s, final long c, final long d) {
        this.e = null;
        this.a = a;
        this.b = s;
        gz.b(!"".equals(s));
        boolean b = false;
        Label_0058: {
            if (s == null) {
                final long n = lcmp(c, -1L);
                b = false;
                if (n == 0) {
                    break Label_0058;
                }
            }
            b = true;
        }
        gz.b(b);
        this.c = c;
        this.d = d;
    }
    
    public final String a() {
        if (this.e == null) {
            this.e = "DriveId:" + Base64.encodeToString(this.b(), 10);
        }
        return this.e;
    }
    
    final byte[] b() {
        final y y = new y();
        y.a = this.a;
        String b;
        if (this.b == null) {
            b = "";
        }
        else {
            b = this.b;
        }
        y.b = b;
        y.c = this.c;
        y.d = this.d;
        return ks.a(y);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof DriveId) {
            final DriveId driveId = (DriveId)o;
            if (driveId.d != this.d) {
                Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }
            if (driveId.c == -1L && this.c == -1L) {
                return driveId.b.equals(this.b);
            }
            if (driveId.c == this.c) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        if (this.c == -1L) {
            return this.b.hashCode();
        }
        return (String.valueOf(this.d) + String.valueOf(this.c)).hashCode();
    }
    
    @Override
    public String toString() {
        return this.a();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.b.a(this, parcel, n);
    }
}
