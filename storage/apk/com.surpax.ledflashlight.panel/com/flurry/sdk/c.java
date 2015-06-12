// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Iterator;
import java.io.DataOutput;
import java.util.HashMap;
import java.io.DataInput;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

public final class c
{
    static final List a;
    private static final String b;
    private final String c;
    private final boolean d;
    private final long e;
    private final Map f;
    
    static {
        b = c.class.getSimpleName();
        a = Arrays.asList("requested", "filled", "unfilled", "rendered", "clicked", "prepared", "adunitMerged", "sendUrlStatusResult", "videoStart", "videoFirstQuartile", "videoMidpoint", "videoThirdQuartile", "videoCompleted", "videoProgressed", "sentToUrl", "adClosed", "adWillClose", "renderFailed", "requestAdComponents", "urlVerified", "capExhausted", "capNotExhausted");
    }
    
    public c(final DataInput dataInput) {
        this.c = dataInput.readUTF();
        this.d = dataInput.readBoolean();
        this.e = dataInput.readLong();
        this.f = new HashMap();
        for (short short1 = dataInput.readShort(), n = 0; n < short1; ++n) {
            this.f.put(dataInput.readUTF(), dataInput.readUTF());
        }
    }
    
    public c(final String s, final boolean d, final long e, final Map f) {
        if (!com.flurry.sdk.c.a.contains(s)) {
            eo.a(com.flurry.sdk.c.b, "AdEvent initialized with unrecognized type: " + s);
        }
        this.c = s;
        this.d = d;
        this.e = e;
        if (f == null) {
            this.f = new HashMap();
            return;
        }
        this.f = f;
    }
    
    public final String a() {
        return this.c;
    }
    
    public final void a(final DataOutput dataOutput) {
        dataOutput.writeUTF(this.c);
        dataOutput.writeBoolean(this.d);
        dataOutput.writeLong(this.e);
        dataOutput.writeShort(this.f.size());
        for (final Map.Entry<String, V> entry : this.f.entrySet()) {
            dataOutput.writeUTF(entry.getKey());
            dataOutput.writeUTF((String)entry.getValue());
        }
    }
    
    public final boolean b() {
        return this.d;
    }
    
    public final long c() {
        return this.e;
    }
    
    public final Map d() {
        return this.f;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof c)) {
                return false;
            }
            final c c = (c)o;
            if (!TextUtils.equals((CharSequence)this.c, (CharSequence)c.c) || this.d != c.d || this.e != c.e || (this.f != c.f && (this.f == null || !this.f.equals(c.f)))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int n = 17;
        if (this.c != null) {
            n = (0x11 | this.c.hashCode());
        }
        if (this.d) {
            n |= 0x1;
        }
        int n2 = (int)(n | this.e);
        if (this.f != null) {
            n2 |= this.f.hashCode();
        }
        return n2;
    }
}
