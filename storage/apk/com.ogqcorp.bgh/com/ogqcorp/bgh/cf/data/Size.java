// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Size implements Parcelable
{
    public static final Parcelable$Creator<Size> CREATOR;
    String a;
    int b;
    int c;
    String d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Size>() {
            public Size a(final Parcel parcel) {
                return new Size(parcel);
            }
            
            public Size[] a(final int n) {
                return new Size[n];
            }
        };
    }
    
    public Size() {
    }
    
    public Size(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("height")
    public int getHeight() {
        return this.c;
    }
    
    @JsonProperty("label")
    public String getLabel() {
        return this.a;
    }
    
    @JsonProperty("source")
    public String getSource() {
        return this.d;
    }
    
    @JsonProperty("width")
    public int getWidth() {
        return this.b;
    }
    
    @JsonProperty("height")
    public void setHeight(final int c) {
        this.c = c;
    }
    
    @JsonProperty("label")
    public void setLabel(final String a) {
        this.a = a;
    }
    
    @JsonProperty("source")
    public void setSource(final String d) {
        this.d = d;
    }
    
    @JsonProperty("width")
    public void setWidth(final int b) {
        this.b = b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
    }
}
