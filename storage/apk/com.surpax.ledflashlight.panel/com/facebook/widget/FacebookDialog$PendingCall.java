// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.os.Parcel;
import android.content.Intent;
import java.util.UUID;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class FacebookDialog$PendingCall implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    private UUID a;
    private Intent b;
    private int c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {};
    }
    
    private FacebookDialog$PendingCall(final Parcel parcel) {
        this.a = UUID.fromString(parcel.readString());
        this.b = (Intent)parcel.readParcelable((ClassLoader)null);
        this.c = parcel.readInt();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a.toString());
        parcel.writeParcelable((Parcelable)this.b, 0);
        parcel.writeInt(this.c);
    }
}
