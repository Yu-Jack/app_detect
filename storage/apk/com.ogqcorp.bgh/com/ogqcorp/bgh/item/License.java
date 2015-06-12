// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class License implements Parcelable
{
    public static final Parcelable$Creator<License> CREATOR;
    String a;
    String b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<License>() {
            public License a(final Parcel parcel) {
                return new License(parcel);
            }
            
            public License[] a(final int n) {
                return new License[n];
            }
        };
    }
    
    public License() {
    }
    
    public License(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getLink() {
        return this.b;
    }
    
    public String getType() {
        return this.a;
    }
    
    public void setLink(final String b) {
        this.b = b;
    }
    
    public void setType(final String a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
