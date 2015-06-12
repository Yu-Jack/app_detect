// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnore;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class PhotoInfo implements Parcelable
{
    public static final Parcelable$Creator<PhotoInfo> CREATOR;
    String a;
    String b;
    User c;
    StringData d;
    StringData e;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PhotoInfo>() {
            public PhotoInfo a(final Parcel parcel) {
                return new PhotoInfo(parcel);
            }
            
            public PhotoInfo[] a(final int n) {
                return new PhotoInfo[n];
            }
        };
    }
    
    public PhotoInfo() {
    }
    
    public PhotoInfo(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (User)parcel.readParcelable(User.class.getClassLoader());
        this.d = (StringData)parcel.readParcelable(StringData.class.getClassLoader());
        this.e = (StringData)parcel.readParcelable(StringData.class.getClassLoader());
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonIgnore
    public String getDescription() {
        return this.e.a;
    }
    
    @JsonProperty("description")
    public StringData getDescriptionContent() {
        return this.e;
    }
    
    @JsonProperty("id")
    public String getId() {
        return this.a;
    }
    
    @JsonProperty("license")
    public String getLicenseCode() {
        return this.b;
    }
    
    @JsonProperty("owner")
    public User getOwner() {
        return this.c;
    }
    
    @JsonIgnore
    public String getPhotoPageUrl() {
        return String.format("http://www.flickr.com/photos/%s/%s/", this.c.g, this.a);
    }
    
    @JsonIgnore
    public String getTitle() {
        return this.d.a;
    }
    
    @JsonProperty("title")
    public StringData getTitleContent() {
        return this.d;
    }
    
    @JsonProperty("description")
    public void setDescriptionContent(final StringData e) {
        this.e = e;
    }
    
    @JsonProperty("id")
    public void setId(final String a) {
        this.a = a;
    }
    
    @JsonProperty("license")
    public void setLicenseCode(final String b) {
        this.b = b;
    }
    
    @JsonProperty("owner")
    public void setOwner(final User c) {
        this.c = c;
    }
    
    @JsonProperty("title")
    public void setTitleContent(final StringData d) {
        this.d = d;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable((Parcelable)this.c, 0);
        parcel.writeParcelable((Parcelable)this.d, 0);
        parcel.writeParcelable((Parcelable)this.e, 0);
    }
}
