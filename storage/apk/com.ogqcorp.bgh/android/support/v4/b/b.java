// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import android.os.Parcel;
import android.os.Parcelable$Creator;

class b<T> implements Parcelable$Creator<T>
{
    final c<T> a;
    
    public b(final c<T> a) {
        this.a = a;
    }
    
    public T createFromParcel(final Parcel parcel) {
        return this.a.a(parcel, null);
    }
    
    public T[] newArray(final int n) {
        return this.a.a(n);
    }
}
