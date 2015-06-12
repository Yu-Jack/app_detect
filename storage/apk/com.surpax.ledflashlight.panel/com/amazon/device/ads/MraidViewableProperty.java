// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MraidViewableProperty extends MraidProperty
{
    private final boolean mViewable;
    
    MraidViewableProperty(final boolean mViewable) {
        this.mViewable = mViewable;
    }
    
    public static MraidViewableProperty createWithViewable(final boolean b) {
        return new MraidViewableProperty(b);
    }
    
    @Override
    public String toJsonPair() {
        final StringBuilder sb = new StringBuilder("viewable: ");
        String str;
        if (this.mViewable) {
            str = "true";
        }
        else {
            str = "false";
        }
        return sb.append(str).toString();
    }
}
