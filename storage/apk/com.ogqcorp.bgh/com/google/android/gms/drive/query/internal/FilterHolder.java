// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.a;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FilterHolder implements SafeParcelable
{
    public static final Parcelable$Creator<FilterHolder> CREATOR;
    final int a;
    final ComparisonFilter<?> b;
    final FieldOnlyFilter c;
    final LogicalFilter d;
    final NotFilter e;
    final InFilter<?> f;
    final MatchAllFilter g;
    private final a h;
    
    static {
        CREATOR = (Parcelable$Creator)new d();
    }
    
    FilterHolder(final int a, final ComparisonFilter<?> b, final FieldOnlyFilter c, final LogicalFilter d, final NotFilter e, final InFilter<?> f, final MatchAllFilter g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        if (this.b != null) {
            this.h = this.b;
            return;
        }
        if (this.c != null) {
            this.h = this.c;
            return;
        }
        if (this.d != null) {
            this.h = this.d;
            return;
        }
        if (this.e != null) {
            this.h = this.e;
            return;
        }
        if (this.f != null) {
            this.h = this.f;
            return;
        }
        if (this.g != null) {
            this.h = this.g;
            return;
        }
        throw new IllegalArgumentException("At least one filter must be set.");
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.drive.query.internal.d.a(this, parcel, n);
    }
}
