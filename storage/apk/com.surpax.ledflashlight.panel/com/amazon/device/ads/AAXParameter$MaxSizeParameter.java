// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$MaxSizeParameter extends AAXParameter$StringParameter
{
    AAXParameter$MaxSizeParameter() {
        super("mxsz", "debug.mxsz");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return aaxParameter$ParameterData.loiSlot.getAdData().getMaxSize();
    }
}
