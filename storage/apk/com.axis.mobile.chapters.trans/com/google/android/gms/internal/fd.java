// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class fd implements Parcelable
{
    @Deprecated
    public static final Parcelable$Creator CREATOR;
    private String mValue;
    private String xG;
    private String xH;
    
    static {
        CREATOR = (Parcelable$Creator)new fd$1();
    }
    
    public fd() {
    }
    
    fd(final Parcel parcel) {
        this.readFromParcel(parcel);
    }
    
    public fd(final String xg, final String xh, final String mValue) {
        this.xG = xg;
        this.xH = xh;
        this.mValue = mValue;
    }
    
    @Deprecated
    private void readFromParcel(final Parcel parcel) {
        this.xG = parcel.readString();
        this.xH = parcel.readString();
        this.mValue = parcel.readString();
    }
    
    @Deprecated
    public int describeContents() {
        return 0;
    }
    
    public String getId() {
        return this.xG;
    }
    
    public String getValue() {
        return this.mValue;
    }
    
    @Deprecated
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.xG);
        parcel.writeString(this.xH);
        parcel.writeString(this.mValue);
    }
}
