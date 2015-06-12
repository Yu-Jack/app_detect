// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class FragmentTabHost$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<FragmentTabHost$SavedState> CREATOR;
    String curTab;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FragmentTabHost$SavedState>() {
            public FragmentTabHost$SavedState createFromParcel(final Parcel parcel) {
                return new FragmentTabHost$SavedState(parcel, null);
            }
            
            public FragmentTabHost$SavedState[] newArray(final int n) {
                return new FragmentTabHost$SavedState[n];
            }
        };
    }
    
    private FragmentTabHost$SavedState(final Parcel parcel) {
        super(parcel);
        this.curTab = parcel.readString();
    }
    
    FragmentTabHost$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeString(this.curTab);
    }
}
