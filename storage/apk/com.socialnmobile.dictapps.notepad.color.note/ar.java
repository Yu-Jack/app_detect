import android.os.Parcel;
import android.os.Parcelable$Creator;

// 
// Decompiled by Procyon v0.5.29
// 

final class ar implements Parcelable$Creator
{
    final as a;
    
    public ar(final as a) {
        this.a = a;
    }
    
    public final Object createFromParcel(final Parcel parcel) {
        return this.a.a(parcel, null);
    }
    
    public final Object[] newArray(final int n) {
        return this.a.a(n);
    }
}
