// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$SizeParameter extends AAXParameter$StringParameter
{
    AAXParameter$SizeParameter() {
        super("sz", "debug.size");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return aaxParameter$ParameterData.loiSlot.getAdData().getRequestedAdSize().toString();
    }
}
