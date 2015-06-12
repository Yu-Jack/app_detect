// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b implements SafeParcelable
{
    public static final e CREATOR;
    int a;
    int b;
    long c;
    private final int d;
    
    static {
        CREATOR = new e();
    }
    
    b(final int d, final int a, final int b, final long c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private String a(final int n) {
        switch (n) {
            default: {
                return "STATUS_UNKNOWN";
            }
            case 0: {
                return "STATUS_SUCCESSFUL";
            }
            case 2: {
                return "STATUS_TIMED_OUT_ON_SCAN";
            }
            case 3: {
                return "STATUS_NO_INFO_IN_DATABASE";
            }
            case 4: {
                return "STATUS_INVALID_SCAN";
            }
            case 5: {
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            }
            case 6: {
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            }
            case 7: {
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            }
            case 8: {
                return "STATUS_IN_PROGRESS";
            }
        }
    }
    
    int a() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof b) {
            final b b = (b)o;
            if (this.a == b.a && this.b == b.b && this.c == b.c) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b, this.c);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LocationStatus[cell status: ").append(this.a(this.a));
        sb.append(", wifi status: ").append(this.a(this.b));
        sb.append(", elapsed realtime ns: ").append(this.c);
        sb.append(']');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        e.a(this, parcel, n);
    }
}
