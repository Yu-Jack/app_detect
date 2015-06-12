// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

class d<T> implements Parcelable$ClassLoaderCreator<T>
{
    private final c<T> a;
    
    public d(final c<T> a) {
        this.a = a;
    }
    
    public T createFromParcel(final Parcel parcel) {
        return this.a.a(parcel, null);
    }
    
    public T createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }
    
    public T[] newArray(final int n) {
        return this.a.a(n);
    }
}
