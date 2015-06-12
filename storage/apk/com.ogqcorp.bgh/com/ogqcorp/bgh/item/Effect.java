// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Effect implements Parcelable
{
    public static final Parcelable$Creator<Effect> CREATOR;
    int a;
    float b;
    float c;
    boolean d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Effect>() {
            public Effect a(final Parcel parcel) {
                return new Effect(parcel);
            }
            
            public Effect[] a(final int n) {
                return new Effect[n];
            }
        };
    }
    
    public Effect() {
    }
    
    public Effect(final Parcel parcel) {
        boolean d = true;
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        if (parcel.readByte() != (d ? 1 : 0)) {
            d = false;
        }
        this.d = d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int getCropMode() {
        return this.a;
    }
    
    public float getCropPosX() {
        return this.b;
    }
    
    public float getCropPosY() {
        return this.c;
    }
    
    public boolean getIsScrollable() {
        return this.d;
    }
    
    public void setCropMode(final int a) {
        this.a = a;
    }
    
    public void setCropPosX(final float b) {
        this.b = b;
    }
    
    public void setCropPosY(final float c) {
        this.c = c;
    }
    
    public void setIsScrollable(final boolean d) {
        this.d = d;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        boolean b;
        if (this.d) {
            b = true;
        }
        else {
            b = false;
        }
        parcel.writeByte((byte)(byte)(b ? 1 : 0));
    }
}
