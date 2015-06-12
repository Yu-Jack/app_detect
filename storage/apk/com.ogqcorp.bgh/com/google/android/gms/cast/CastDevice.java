// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.cast;

import android.os.Parcel;
import java.util.Collections;
import com.google.android.gms.internal.fb;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.util.ArrayList;
import com.google.android.gms.common.images.WebImage;
import java.util.List;
import java.net.Inet4Address;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CastDevice implements SafeParcelable
{
    public static final Parcelable$Creator<CastDevice> CREATOR;
    String a;
    private final int b;
    private String c;
    private Inet4Address d;
    private String e;
    private String f;
    private String g;
    private int h;
    private List<WebImage> i;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    private CastDevice() {
        this(1, null, null, null, null, null, -1, new ArrayList<WebImage>());
    }
    
    CastDevice(final int b, final String c, final String a, final String e, final String f, final String g, final int h, final List<WebImage> i) {
        this.b = b;
        this.c = c;
        this.a = a;
        while (true) {
            if (this.a == null) {
                break Label_0052;
            }
            try {
                final InetAddress byName = InetAddress.getByName(this.a);
                if (byName instanceof Inet4Address) {
                    this.d = (Inet4Address)byName;
                }
                this.e = e;
                this.f = f;
                this.g = g;
                this.h = h;
                this.i = i;
            }
            catch (UnknownHostException ex) {
                this.d = null;
                continue;
            }
            break;
        }
    }
    
    int a() {
        return this.b;
    }
    
    public String b() {
        return this.c;
    }
    
    public String c() {
        return this.e;
    }
    
    public String d() {
        return this.f;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public String e() {
        return this.g;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof CastDevice)) {
                return false;
            }
            final CastDevice castDevice = (CastDevice)o;
            if (this.b() == null) {
                if (castDevice.b() != null) {
                    return false;
                }
            }
            else if (!fb.a(this.c, castDevice.c) || !fb.a(this.d, castDevice.d) || !fb.a(this.f, castDevice.f) || !fb.a(this.e, castDevice.e) || !fb.a(this.g, castDevice.g) || this.h != castDevice.h || !fb.a(this.i, castDevice.i)) {
                return false;
            }
        }
        return true;
    }
    
    public int f() {
        return this.h;
    }
    
    public List<WebImage> g() {
        return Collections.unmodifiableList((List<? extends WebImage>)this.i);
    }
    
    @Override
    public int hashCode() {
        if (this.c == null) {
            return 0;
        }
        return this.c.hashCode();
    }
    
    @Override
    public String toString() {
        return String.format("\"%s\" (%s)", this.e, this.c);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.cast.b.a(this, parcel, n);
    }
}
