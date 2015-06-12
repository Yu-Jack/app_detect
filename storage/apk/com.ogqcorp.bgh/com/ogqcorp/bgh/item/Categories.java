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

public final class Categories implements Parcelable
{
    public static final Parcelable$Creator<Categories> CREATOR;
    ArrayList<Category> a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Categories>() {
            public Categories a(final Parcel parcel) {
                return new Categories(parcel);
            }
            
            public Categories[] a(final int n) {
                return new Categories[n];
            }
        };
    }
    
    public Categories() {
    }
    
    public Categories(final Parcel parcel) {
        parcel.readTypedList((List)(this.a = new ArrayList<Category>()), (Parcelable$Creator)Category.CREATOR);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("categories")
    public ArrayList<Category> getCategoriesList() {
        return this.a;
    }
    
    @JsonProperty("categories")
    public void setCategoriesList(final ArrayList<Category> a) {
        this.a = a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeTypedList((List)this.a);
    }
}
