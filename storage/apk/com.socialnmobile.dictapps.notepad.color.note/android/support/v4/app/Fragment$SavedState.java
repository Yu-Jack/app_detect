// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class Fragment$SavedState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    final Bundle a;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    public Fragment$SavedState(final Bundle a) {
        this.a = a;
    }
    
    public Fragment$SavedState(final Parcel parcel) {
        this.a = parcel.readBundle();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeBundle(this.a);
    }
}
