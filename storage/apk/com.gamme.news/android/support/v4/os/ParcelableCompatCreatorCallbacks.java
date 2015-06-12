// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks<T>
{
    T createFromParcel(Parcel p0, ClassLoader p1);
    
    T[] newArray(int p0);
}
