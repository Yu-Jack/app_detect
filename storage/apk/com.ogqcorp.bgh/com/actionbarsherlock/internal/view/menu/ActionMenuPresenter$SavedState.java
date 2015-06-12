// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

class ActionMenuPresenter$SavedState implements Parcelable
{
    public static final Parcelable$Creator<ActionMenuPresenter$SavedState> CREATOR;
    public int openSubMenuId;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ActionMenuPresenter$SavedState>() {
            public ActionMenuPresenter$SavedState createFromParcel(final Parcel parcel) {
                return new ActionMenuPresenter$SavedState(parcel);
            }
            
            public ActionMenuPresenter$SavedState[] newArray(final int n) {
                return new ActionMenuPresenter$SavedState[n];
            }
        };
    }
    
    ActionMenuPresenter$SavedState() {
    }
    
    ActionMenuPresenter$SavedState(final Parcel parcel) {
        this.openSubMenuId = parcel.readInt();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.openSubMenuId);
    }
}
