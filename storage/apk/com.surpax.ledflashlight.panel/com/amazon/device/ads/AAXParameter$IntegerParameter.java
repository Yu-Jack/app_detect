// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$IntegerParameter extends AAXParameter
{
    AAXParameter$IntegerParameter(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    protected Integer getFromDebugProperties() {
        return DebugProperties.getDebugPropertyAsInteger(this.getDebugName(), null);
    }
    
    @Override
    protected Integer parseFromString(final String s) {
        return Integer.parseInt(s);
    }
}
