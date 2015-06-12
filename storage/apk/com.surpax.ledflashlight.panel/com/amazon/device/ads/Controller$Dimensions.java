// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable$Creator;

public class Controller$Dimensions extends Controller$ReflectedParcelable
{
    public static final Parcelable$Creator CREATOR;
    public int height;
    public int width;
    public int x;
    public int y;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {
            public final Controller$Dimensions createFromParcel(final Parcel parcel) {
                return new Controller$Dimensions(parcel);
            }
            
            public final Controller$Dimensions[] newArray(final int n) {
                return new Controller$Dimensions[n];
            }
        };
    }
    
    public Controller$Dimensions() {
        this.x = -1;
        this.y = -1;
        this.width = -1;
        this.height = -1;
    }
    
    public Controller$Dimensions(final Parcel parcel) {
        super(parcel);
    }
}
