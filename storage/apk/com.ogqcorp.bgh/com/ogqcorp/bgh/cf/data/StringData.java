// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class StringData implements Parcelable
{
    public static final Parcelable$Creator<StringData> CREATOR;
    String a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<StringData>() {
            public StringData a(final Parcel parcel) {
                return new StringData(parcel);
            }
            
            public StringData[] a(final int n) {
                return new StringData[n];
            }
        };
    }
    
    public StringData() {
    }
    
    public StringData(final Parcel parcel) {
        this.a = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("_content")
    public String getContent() {
        return this.a;
    }
    
    @JsonProperty("_content")
    public void setContent(final String a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
    }
}
