// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Author implements Parcelable
{
    public static final Parcelable$Creator<Author> CREATOR;
    int a;
    String b;
    String c;
    String d;
    String e;
    String f;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Author>() {
            public Author a(final Parcel parcel) {
                return new Author(parcel);
            }
            
            public Author[] a(final int n) {
                return new Author[n];
            }
        };
    }
    
    public Author() {
    }
    
    public Author(final Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getDescription() {
        return this.f;
    }
    
    public String getHomepage() {
        return this.d;
    }
    
    public int getId() {
        return this.a;
    }
    
    public String getJob() {
        return this.c;
    }
    
    public String getLocation() {
        return this.e;
    }
    
    public String getName() {
        return this.b;
    }
    
    public void setDescription(final String f) {
        this.f = f;
    }
    
    public void setHomepage(final String d) {
        this.d = d;
    }
    
    public void setId(final int a) {
        this.a = a;
    }
    
    public void setJob(final String c) {
        this.c = c;
    }
    
    public void setLocation(final String e) {
        this.e = e;
    }
    
    public void setName(final String b) {
        this.b = b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
