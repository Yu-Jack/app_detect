// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class b implements Parcelable$Creator
{
    final c a;
    
    public b(final c a) {
        this.a = a;
    }
    
    public final Object createFromParcel(final Parcel parcel) {
        return this.a.a(parcel, null);
    }
    
    public final Object[] newArray(final int n) {
        return this.a.a(n);
    }
}
