// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Section implements Parcelable
{
    public static final Parcelable$Creator<Section> CREATOR;
    String a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Section>() {
            public Section a(final Parcel parcel) {
                return new Section(parcel);
            }
            
            public Section[] a(final int n) {
                return new Section[n];
            }
        };
    }
    
    public Section() {
    }
    
    public Section(final Parcel parcel) {
        this.a = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getName() {
        return this.a;
    }
    
    public void setName(final String a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
    }
}
