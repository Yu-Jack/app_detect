// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$SlotParameter extends AAXParameter$StringParameter
{
    AAXParameter$SlotParameter() {
        super("slot", "debug.slot");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return aaxParameter$ParameterData.adRequest.getOrientation();
    }
}
