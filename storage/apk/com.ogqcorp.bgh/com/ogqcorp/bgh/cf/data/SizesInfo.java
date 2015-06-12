// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import java.util.ArrayList;
import android.os.Parcel;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class SizesInfo implements Parcelable
{
    public static final Parcelable$Creator<SizesInfo> CREATOR;
    List<Size> a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<SizesInfo>() {
            public SizesInfo a(final Parcel parcel) {
                return new SizesInfo(parcel);
            }
            
            public SizesInfo[] a(final int n) {
                return new SizesInfo[n];
            }
        };
    }
    
    public SizesInfo() {
    }
    
    public SizesInfo(final Parcel parcel) {
        parcel.readTypedList((List)(this.a = new ArrayList<Size>()), (Parcelable$Creator)Size.CREATOR);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("size")
    public List<Size> getSizesList() {
        return this.a;
    }
    
    @JsonProperty("size")
    public void setSizesList(final List<Size> a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeTypedList((List)this.a);
    }
}
