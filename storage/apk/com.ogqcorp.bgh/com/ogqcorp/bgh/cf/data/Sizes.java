// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Sizes implements Parcelable
{
    public static final Parcelable$Creator<Sizes> CREATOR;
    SizesInfo a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Sizes>() {
            public Sizes a(final Parcel parcel) {
                return new Sizes(parcel);
            }
            
            public Sizes[] a(final int n) {
                return new Sizes[n];
            }
        };
    }
    
    public Sizes() {
    }
    
    public Sizes(final Parcel parcel) {
        this.a = (SizesInfo)parcel.readParcelable(SizesInfo.class.getClassLoader());
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("sizes")
    public SizesInfo getSizesInfo() {
        return this.a;
    }
    
    @JsonProperty("sizes")
    public void setSizesInfo(final SizesInfo a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable((Parcelable)this.a, 0);
    }
}
