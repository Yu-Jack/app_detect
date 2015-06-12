// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MraidScreenSizeProperty extends MraidProperty
{
    private final int mScreenHeight;
    private final int mScreenWidth;
    
    MraidScreenSizeProperty(final int mScreenWidth, final int mScreenHeight) {
        this.mScreenWidth = mScreenWidth;
        this.mScreenHeight = mScreenHeight;
    }
    
    public static MraidScreenSizeProperty createWithSize(final int n, final int n2) {
        return new MraidScreenSizeProperty(n, n2);
    }
    
    @Override
    public String toJsonPair() {
        return "screenSize: { width: " + this.mScreenWidth + ", height: " + this.mScreenHeight + " }";
    }
}
