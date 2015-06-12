// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

class Request$ParcelFileDescriptorWithMimeType implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    private final String a;
    private final ParcelFileDescriptor b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {};
    }
    
    private Request$ParcelFileDescriptorWithMimeType(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readFileDescriptor();
    }
    
    public final String a() {
        return this.a;
    }
    
    public final ParcelFileDescriptor b() {
        return this.b;
    }
    
    public int describeContents() {
        return 1;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeFileDescriptor(this.b.getFileDescriptor());
    }
}
