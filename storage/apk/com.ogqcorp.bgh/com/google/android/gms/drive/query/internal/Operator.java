// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable
{
    public static final Parcelable$Creator<Operator> CREATOR;
    public static final Operator a;
    public static final Operator b;
    public static final Operator c;
    public static final Operator d;
    public static final Operator e;
    public static final Operator f;
    public static final Operator g;
    public static final Operator h;
    public static final Operator i;
    final String j;
    final int k;
    
    static {
        CREATOR = (Parcelable$Creator)new j();
        a = new Operator("=");
        b = new Operator("<");
        c = new Operator("<=");
        d = new Operator(">");
        e = new Operator(">=");
        f = new Operator("and");
        g = new Operator("or");
        h = new Operator("not");
        i = new Operator("contains");
    }
    
    Operator(final int k, final String j) {
        this.k = k;
        this.j = j;
    }
    
    private Operator(final String s) {
        this(1, s);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final Operator operator = (Operator)o;
            if (this.j == null) {
                if (operator.j != null) {
                    return false;
                }
            }
            else if (!this.j.equals(operator.j)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode;
        if (this.j == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.j.hashCode();
        }
        return hashCode + 31;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.query.internal.j.a(this, parcel, n);
    }
}
