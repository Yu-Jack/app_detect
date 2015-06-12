// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ef implements Parcelable
{
    @Deprecated
    public static final Parcelable$Creator<ef> CREATOR;
    private String a;
    private String b;
    private String c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ef>() {
            @Deprecated
            public ef a(final Parcel parcel) {
                return new ef(parcel);
            }
            
            @Deprecated
            public ef[] a(final int n) {
                return new ef[n];
            }
        };
    }
    
    public ef() {
    }
    
    ef(final Parcel parcel) {
        this.a(parcel);
    }
    
    public ef(final String a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Deprecated
    private void a(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
    
    public String a() {
        return this.a;
    }
    
    public String b() {
        return this.c;
    }
    
    @Deprecated
    public int describeContents() {
        return 0;
    }
    
    @Deprecated
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
