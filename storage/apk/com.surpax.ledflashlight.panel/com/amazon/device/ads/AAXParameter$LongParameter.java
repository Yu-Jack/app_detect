// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$LongParameter extends AAXParameter
{
    AAXParameter$LongParameter(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    protected Long getFromDebugProperties() {
        return DebugProperties.getDebugPropertyAsLong(this.getDebugName(), null);
    }
    
    @Override
    protected Long parseFromString(final String s) {
        return Long.parseLong(s);
    }
}
