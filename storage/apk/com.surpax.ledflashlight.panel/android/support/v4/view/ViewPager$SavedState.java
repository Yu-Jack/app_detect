// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.support.v4.a.a;
import android.os.Parcel;
import android.support.v4.a.c;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public class ViewPager$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator CREATOR;
    int a;
    Parcelable b;
    ClassLoader c;
    
    static {
        CREATOR = a.a(new c() {});
    }
    
    ViewPager$SavedState(final Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        if (classLoader == null) {
            classLoader = this.getClass().getClassLoader();
        }
        this.a = parcel.readInt();
        this.b = parcel.readParcelable(classLoader);
        this.c = classLoader;
    }
    
    public ViewPager$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.a);
        parcel.writeParcelable(this.b, n);
    }
}