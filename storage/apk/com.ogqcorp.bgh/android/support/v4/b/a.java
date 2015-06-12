// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import android.os.Build$VERSION;
import android.os.Parcelable$Creator;

public class a
{
    public static <T> Parcelable$Creator<T> a(final c<T> c) {
        if (Build$VERSION.SDK_INT >= 13) {
            e.a(c);
        }
        return (Parcelable$Creator<T>)new b((c<Object>)c);
    }
}
