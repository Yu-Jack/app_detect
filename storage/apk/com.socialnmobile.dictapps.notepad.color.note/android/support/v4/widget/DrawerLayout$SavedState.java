// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public class DrawerLayout$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator CREATOR;
    int a;
    int b;
    int c;
    
    static {
        CREATOR = (Parcelable$Creator)new df();
    }
    
    public DrawerLayout$SavedState(final Parcel parcel) {
        super(parcel);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.a = parcel.readInt();
    }
    
    public DrawerLayout$SavedState(final Parcelable parcelable) {
        super(parcelable);
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.a);
    }
}
