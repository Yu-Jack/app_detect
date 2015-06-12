// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.support.v4.b.a;
import android.os.Parcel;
import android.support.v4.b.c;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

public class ViewPager$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<ViewPager$SavedState> CREATOR;
    int a;
    Parcelable b;
    ClassLoader c;
    
    static {
        CREATOR = a.a((c<ViewPager$SavedState>)new c<ViewPager$SavedState>() {
            public ViewPager$SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                return new ViewPager$SavedState(parcel, classLoader);
            }
            
            public ViewPager$SavedState[] b(final int n) {
                return new ViewPager$SavedState[n];
            }
        });
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
