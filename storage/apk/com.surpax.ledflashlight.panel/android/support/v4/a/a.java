// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.os.Build$VERSION;
import android.os.Parcelable$Creator;

public final class a
{
    public static Parcelable$Creator a(final c c) {
        if (Build$VERSION.SDK_INT >= 13) {
            new d(c);
        }
        return (Parcelable$Creator)new b(c);
    }
}
