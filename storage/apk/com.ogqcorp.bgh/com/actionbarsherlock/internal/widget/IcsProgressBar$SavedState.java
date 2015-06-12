// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class IcsProgressBar$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<IcsProgressBar$SavedState> CREATOR;
    int progress;
    int secondaryProgress;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<IcsProgressBar$SavedState>() {
            public IcsProgressBar$SavedState createFromParcel(final Parcel parcel) {
                return new IcsProgressBar$SavedState(parcel, null);
            }
            
            public IcsProgressBar$SavedState[] newArray(final int n) {
                return new IcsProgressBar$SavedState[n];
            }
        };
    }
    
    private IcsProgressBar$SavedState(final Parcel parcel) {
        super(parcel);
        this.progress = parcel.readInt();
        this.secondaryProgress = parcel.readInt();
    }
    
    IcsProgressBar$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.progress);
        parcel.writeInt(this.secondaryProgress);
    }
}
