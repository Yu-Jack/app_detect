// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.item;

import org.codehaus.jackson.annotate.JsonProperty;
import java.io.IOException;
import com.ogqcorp.bgh.system.l;
import java.io.File;
import android.content.Context;
import com.ogqcorp.commons.p;
import android.os.Parcel;
import java.util.Set;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Ready implements Parcelable
{
    public static final Parcelable$Creator<Ready> CREATOR;
    String a;
    String b;
    Set<String> c;
    float d;
    float e;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Ready>() {
            public Ready a(final Parcel parcel) {
                return new Ready(parcel);
            }
            
            public Ready[] a(final int n) {
                return new Ready[n];
            }
        };
    }
    
    public Ready() {
        this.d = 0.0f;
        this.e = 0.0f;
    }
    
    public Ready(final Parcel parcel) {
        this.d = 0.0f;
        this.e = 0.0f;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = p.a(parcel);
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
    }
    
    public static Ready a(final Context context) {
        final File file = new File(context.getFilesDir(), "READY");
        try {
            return (Ready)p.a(Ready.class.getClassLoader(), file);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static void a(final Context context, final Ready ready) {
        final File file = new File(context.getFilesDir(), "READY");
        try {
            p.a((Parcelable)ready, file);
        }
        catch (IOException ex) {
            l.b(ex);
        }
    }
    
    public int describeContents() {
        return 0;
    }
    
    public float getAutumnWeight() {
        return this.d;
    }
    
    public String getLatestVersion() {
        return this.b;
    }
    
    @JsonProperty("supportedLocales")
    public Set<String> getSupportedLocalesSet() {
        return this.c;
    }
    
    public String getUpdateUrl() {
        return this.a;
    }
    
    public float getWinterWeight() {
        return this.e;
    }
    
    public void setAutumnWeight(final float d) {
        this.d = d;
    }
    
    public void setLatestVersion(final String b) {
        this.b = b;
    }
    
    @JsonProperty("supportedLocales")
    public void setSupportedLocalesList(final Set<String> c) {
        this.c = c;
    }
    
    public void setUpdateUrl(final String a) {
        this.a = a;
    }
    
    public void setWinterWeight(final float e) {
        this.e = e;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        p.a(parcel, this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
    }
}
