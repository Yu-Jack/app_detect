// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.gx;

public class Location$Builder extends gx
{
    private float a;
    private float b;
    
    private Location$Builder() {
        super(Location.SCHEMA$);
    }
    
    public Location$Builder a(final float n) {
        this.a(this.b()[0], n);
        this.a = n;
        this.c()[0] = true;
        return this;
    }
    
    public Location a() {
        try {
            final Location location = new Location();
            float a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (float)this.a(this.b()[0]);
            }
            location.a = a;
            float b;
            if (this.c()[1]) {
                b = this.b;
            }
            else {
                b = (float)this.a(this.b()[1]);
            }
            location.b = b;
            return location;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
    
    public Location$Builder b(final float n) {
        this.a(this.b()[1], n);
        this.b = n;
        this.c()[1] = true;
        return this;
    }
}
