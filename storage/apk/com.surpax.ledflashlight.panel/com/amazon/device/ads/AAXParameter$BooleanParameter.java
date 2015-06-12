// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$BooleanParameter extends AAXParameter
{
    AAXParameter$BooleanParameter(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    protected Boolean getFromDebugProperties() {
        return DebugProperties.getDebugPropertyAsBoolean(this.getDebugName(), null);
    }
    
    @Override
    protected Boolean parseFromString(final String s) {
        return Boolean.parseBoolean(s);
    }
}
