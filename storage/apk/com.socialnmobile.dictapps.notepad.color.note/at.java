import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

// 
// Decompiled by Procyon v0.5.29
// 

final class at implements Parcelable$ClassLoaderCreator
{
    private final as a;
    
    public at(final as a) {
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
