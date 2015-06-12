// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.json.JSONObject;
import com.ogqcorp.commons.p;
import java.util.HashSet;
import android.os.Parcel;
import java.util.Set;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Link implements Parcelable, Comparable<Link>
{
    public static final Parcelable$Creator<Link> CREATOR;
    String a;
    String b;
    String c;
    Set<String> d;
    Set<String> e;
    String f;
    int g;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Link>() {
            public Link a(final Parcel parcel) {
                return new Link(parcel);
            }
            
            public Link[] a(final int n) {
                return new Link[n];
            }
        };
    }
    
    public Link() {
        this.d = new HashSet<String>();
        this.e = new HashSet<String>();
    }
    
    public Link(final Parcel parcel) {
        this.d = new HashSet<String>();
        this.e = new HashSet<String>();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = p.a(parcel);
        this.e = p.a(parcel);
        this.f = parcel.readString();
        this.g = parcel.readInt();
    }
    
    public int a(final Link link) {
        return Integer.valueOf(this.g).compareTo(Integer.valueOf(link.g));
    }
    
    @JsonIgnore
    public String a(String s) {
        final JSONObject jsonObject = new JSONObject(this.b);
        if (!jsonObject.has(s)) {
            s = "en_US";
        }
        return jsonObject.getString(s);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @JsonProperty("blackCountries")
    public Set<String> getBlackCountriesSet() {
        return this.e;
    }
    
    public String getExtra() {
        return this.f;
    }
    
    public int getOrder() {
        return this.g;
    }
    
    public String getTitle() {
        return this.b;
    }
    
    public String getType() {
        return this.a;
    }
    
    public String getUri() {
        return this.c;
    }
    
    @JsonProperty("whiteCountries")
    public Set<String> getWhiteCountriesSet() {
        return this.d;
    }
    
    @JsonProperty("blackCountries")
    public void setBlackCountriesSet(final Set<String> e) {
        this.e = e;
    }
    
    public void setExtra(final String f) {
        this.f = f;
    }
    
    public void setOrder(final int g) {
        this.g = g;
    }
    
    public void setTitle(final String b) {
        this.b = b;
    }
    
    public void setType(final String a) {
        this.a = a;
    }
    
    public void setUri(final String c) {
        this.c = c;
    }
    
    @JsonProperty("whiteCountries")
    public void setWhiteCountriesSet(final Set<String> d) {
        this.d = d;
    }
    
    @Override
    public String toString() {
        try {
            return this.a("en_US");
        }
        catch (Exception ex) {
            return this.a + "_" + this.g;
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        p.a(parcel, this.d);
        p.a(parcel, this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
    }
}
