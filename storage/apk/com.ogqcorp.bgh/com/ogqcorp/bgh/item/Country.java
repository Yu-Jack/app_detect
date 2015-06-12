// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Country implements Parcelable
{
    public static final Parcelable$Creator<Country> CREATOR;
    String a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Country>() {
            public Country a(final Parcel parcel) {
                return new Country(parcel);
            }
            
            public Country[] a(final int n) {
                return new Country[n];
            }
        };
    }
    
    public Country() {
    }
    
    public Country(final Parcel parcel) {
        this.a = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getCountry() {
        return this.a;
    }
    
    public void setCountry(final String a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
    }
}
