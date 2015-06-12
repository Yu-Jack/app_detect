// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.internal.gz;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class RealTimeMessage implements Parcelable
{
    public static final Parcelable$Creator<RealTimeMessage> CREATOR;
    private final String a;
    private final byte[] b;
    private final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<RealTimeMessage>() {
            public RealTimeMessage a(final Parcel parcel) {
                return new RealTimeMessage(parcel, null);
            }
            
            public RealTimeMessage[] a(final int n) {
                return new RealTimeMessage[n];
            }
        };
    }
    
    private RealTimeMessage(final Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }
    
    public RealTimeMessage(final String s, final byte[] array, final int c) {
        this.a = gz.a(s);
        this.b = gz.a(array).clone();
        this.c = c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
    }
}
