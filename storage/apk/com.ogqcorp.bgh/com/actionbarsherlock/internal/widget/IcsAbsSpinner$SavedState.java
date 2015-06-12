// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class IcsAbsSpinner$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<IcsAbsSpinner$SavedState> CREATOR;
    int position;
    long selectedId;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<IcsAbsSpinner$SavedState>() {
            public IcsAbsSpinner$SavedState createFromParcel(final Parcel parcel) {
                return new IcsAbsSpinner$SavedState(parcel, null);
            }
            
            public IcsAbsSpinner$SavedState[] newArray(final int n) {
                return new IcsAbsSpinner$SavedState[n];
            }
        };
    }
    
    private IcsAbsSpinner$SavedState(final Parcel parcel) {
        super(parcel);
        this.selectedId = parcel.readLong();
        this.position = parcel.readInt();
    }
    
    IcsAbsSpinner$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public String toString() {
        return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeLong(this.selectedId);
        parcel.writeInt(this.position);
    }
}
