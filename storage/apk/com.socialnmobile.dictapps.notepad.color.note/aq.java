import android.os.Build$VERSION;
import android.os.Parcelable$Creator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aq
{
    public static Parcelable$Creator a(final as as) {
        if (Build$VERSION.SDK_INT >= 13) {
            au.a(as);
        }
        return (Parcelable$Creator)new ar(as);
    }
}
