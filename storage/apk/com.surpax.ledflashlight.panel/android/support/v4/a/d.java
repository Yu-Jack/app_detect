// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

final class d implements Parcelable$ClassLoaderCreator
{
    private final c a;
    
    public d(final c a) {
        this.a = a;
    }
    
    public final Object createFromParcel(final Parcel parcel) {
        return this.a.a(parcel, null);
    }
    
    public final Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }
    
    public final Object[] newArray(final int n) {
        return this.a.a(n);
    }
}
