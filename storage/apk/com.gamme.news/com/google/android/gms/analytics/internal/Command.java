// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class Command implements Parcelable
{
    public static final String APPEND_CACHE_BUSTER = "appendCacheBuster";
    public static final String APPEND_QUEUE_TIME = "appendQueueTime";
    public static final String APPEND_VERSION = "appendVersion";
    public static final Parcelable$Creator<Command> CREATOR;
    private String id;
    private String urlParam;
    private String value;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Command>() {
            public Command createFromParcel(final Parcel parcel) {
                return new Command(parcel);
            }
            
            public Command[] newArray(final int n) {
                return new Command[n];
            }
        };
    }
    
    public Command() {
    }
    
    Command(final Parcel parcel) {
        this.readFromParcel(parcel);
    }
    
    public Command(final String id, final String urlParam, final String value) {
        this.id = id;
        this.urlParam = urlParam;
        this.value = value;
    }
    
    private void readFromParcel(final Parcel parcel) {
        this.id = parcel.readString();
        this.urlParam = parcel.readString();
        this.value = parcel.readString();
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getUrlParam() {
        return this.urlParam;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.id);
        parcel.writeString(this.urlParam);
        parcel.writeString(this.value);
    }
}
