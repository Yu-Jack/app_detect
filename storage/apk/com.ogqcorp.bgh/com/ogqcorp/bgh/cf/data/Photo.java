// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Photo implements Parcelable
{
    public static final Parcelable$Creator<Photo> CREATOR;
    PhotoInfo a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Photo>() {
            public Photo a(final Parcel parcel) {
                return new Photo(parcel);
            }
            
            public Photo[] a(final int n) {
                return new Photo[n];
            }
        };
    }
    
    public Photo() {
    }
    
    public Photo(final Parcel parcel) {
        this.a = (PhotoInfo)parcel.readParcelable(PhotoInfo.class.getClassLoader());
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("photo")
    public PhotoInfo getPhotoInfo() {
        return this.a;
    }
    
    @JsonProperty("photo")
    public void setPhotoInfo(final PhotoInfo a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable((Parcelable)this.a, 0);
    }
}
