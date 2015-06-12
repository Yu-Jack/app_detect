// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnore;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class User implements Parcelable
{
    public static final Parcelable$Creator<User> CREATOR;
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<User>() {
            public User a(final Parcel parcel) {
                return new User(parcel);
            }
            
            public User[] a(final int n) {
                return new User[n];
            }
        };
    }
    
    public User() {
    }
    
    public User(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonIgnore
    public String getBuddyIconUrl() {
        if (this.e.equals("0")) {
            return "https://www.flickr.com/images/buddyicon.gif";
        }
        if (this.f.equals("9")) {
            return String.format("http://farm%s.staticflickr.com/%s/buddyicons/%s_r.jpg", this.f, this.e, this.a);
        }
        return String.format("http://farm%s.staticflickr.com/%s/buddyicons/%s.jpg", this.f, this.e, this.a);
    }
    
    @JsonProperty("iconfarm")
    public String getIconfarm() {
        return this.f;
    }
    
    @JsonProperty("iconserver")
    public String getIconserver() {
        return this.e;
    }
    
    @JsonProperty("location")
    public String getLocation() {
        if (this.d == null || this.d.isEmpty()) {
            return "Somewhere on Earth";
        }
        return this.d;
    }
    
    @JsonIgnore
    public String getName() {
        if (this.c == null || this.c.isEmpty()) {
            return this.b;
        }
        return this.c;
    }
    
    @JsonProperty("nsid")
    public String getNsid() {
        return this.a;
    }
    
    @JsonProperty("path_alias")
    public String getPathAlias() {
        return this.g;
    }
    
    @JsonProperty("realname")
    public String getRealName() {
        return this.c;
    }
    
    @JsonProperty("username")
    public String getUserName() {
        return this.b;
    }
    
    @JsonProperty("iconfarm")
    public void setIconfarm(final String f) {
        this.f = f;
    }
    
    @JsonProperty("iconserver")
    public void setIconserver(final String e) {
        this.e = e;
    }
    
    @JsonProperty("location")
    public void setLocation(final String d) {
        this.d = d;
    }
    
    @JsonProperty("nsid")
    public void setNsid(final String a) {
        this.a = a;
    }
    
    @JsonProperty("path_alias")
    public void setPathAlias(final String g) {
        this.g = g;
    }
    
    @JsonProperty("realname")
    public void setRealName(final String c) {
        this.c = c;
    }
    
    @JsonProperty("username")
    public void setUserName(final String b) {
        this.b = b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }
}
