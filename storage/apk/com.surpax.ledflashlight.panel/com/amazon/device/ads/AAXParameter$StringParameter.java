// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$StringParameter extends AAXParameter
{
    AAXParameter$StringParameter(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    protected String getFromDebugProperties() {
        return DebugProperties.getDebugPropertyAsString(this.getDebugName(), null);
    }
    
    @Override
    protected String parseFromString(final String s) {
        return s;
    }
}
