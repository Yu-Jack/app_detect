// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import org.codehaus.jackson.annotate.JsonProperty;
import java.util.List;
import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Backgrounds implements Parcelable
{
    public static final Parcelable$Creator<Backgrounds> CREATOR;
    ArrayList<Background> a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Backgrounds>() {
            public Backgrounds a(final Parcel parcel) {
                return new Backgrounds(parcel, null);
            }
            
            public Backgrounds[] a(final int n) {
                return new Backgrounds[n];
            }
        };
    }
    
    public Backgrounds() {
    }
    
    private Backgrounds(final Parcel parcel) {
        parcel.readTypedList((List)(this.a = new ArrayList<Background>()), (Parcelable$Creator)Background.CREATOR);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("backgrounds")
    public ArrayList<Background> getBackgroundsList() {
        return this.a;
    }
    
    @JsonProperty("backgrounds")
    public void setBackgroundsList(final ArrayList<Background> a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeTypedList((List)this.a);
    }
}
