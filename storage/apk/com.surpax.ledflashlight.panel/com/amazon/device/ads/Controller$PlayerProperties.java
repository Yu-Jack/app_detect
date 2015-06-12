// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable$Creator;

public class Controller$PlayerProperties extends Controller$ReflectedParcelable
{
    public static final Parcelable$Creator CREATOR;
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public boolean inline;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {
            public final Controller$PlayerProperties createFromParcel(final Parcel parcel) {
                return new Controller$PlayerProperties(parcel);
            }
            
            public final Controller$PlayerProperties[] newArray(final int n) {
                return new Controller$PlayerProperties[n];
            }
        };
    }
    
    public Controller$PlayerProperties() {
        this.autoPlay = true;
        this.showControl = true;
        this.doLoop = false;
        this.audioMuted = false;
        this.startStyle = "normal";
        this.stopStyle = "normal";
    }
    
    public Controller$PlayerProperties(final Parcel parcel) {
        super(parcel);
    }
    
    public boolean doLoop() {
        return this.doLoop;
    }
    
    public boolean doMute() {
        return this.audioMuted;
    }
    
    public boolean exitOnComplete() {
        return this.stopStyle.equalsIgnoreCase("exit");
    }
    
    public boolean isAutoPlay() {
        return this.autoPlay;
    }
    
    public boolean isFullScreen() {
        return this.startStyle.equalsIgnoreCase("fullscreen");
    }
    
    public void muteAudio() {
        this.audioMuted = true;
    }
    
    public void setProperties(final boolean audioMuted, final boolean autoPlay, final boolean showControl, final boolean inline, final boolean doLoop, final String startStyle, final String stopStyle) {
        this.audioMuted = audioMuted;
        this.autoPlay = autoPlay;
        this.showControl = showControl;
        this.inline = inline;
        this.doLoop = doLoop;
        this.startStyle = startStyle;
        this.stopStyle = stopStyle;
    }
    
    public boolean showControl() {
        return this.showControl;
    }
}
