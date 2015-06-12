// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.maps.model;

public final class m
{
    public float a;
    public float b;
    
    public StreetViewPanoramaOrientation a() {
        return new StreetViewPanoramaOrientation(this.b, this.a);
    }
    
    public m a(final float b) {
        this.b = b;
        return this;
    }
    
    public m b(final float a) {
        this.a = a;
        return this;
    }
}
