// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.view.View$BaseSavedState;

class ActionBarView$SavedState extends View$BaseSavedState
{
    public static final Parcelable$Creator<ActionBarView$SavedState> CREATOR;
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ActionBarView$SavedState>() {
            public ActionBarView$SavedState createFromParcel(final Parcel parcel) {
                return new ActionBarView$SavedState(parcel, null);
            }
            
            public ActionBarView$SavedState[] newArray(final int n) {
                return new ActionBarView$SavedState[n];
            }
        };
    }
    
    private ActionBarView$SavedState(final Parcel parcel) {
        super(parcel);
        this.expandedMenuItemId = parcel.readInt();
        this.isOverflowOpen = (parcel.readInt() != 0);
    }
    
    ActionBarView$SavedState(final Parcelable parcelable) {
        super(parcelable);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.expandedMenuItemId);
        int n2;
        if (this.isOverflowOpen) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        parcel.writeInt(n2);
    }
}
