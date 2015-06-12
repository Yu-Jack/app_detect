// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class AAXParameter$SlotIdParameter extends AAXParameter$IntegerParameter
{
    AAXParameter$SlotIdParameter() {
        super("slotId", "debug.slotId");
    }
    
    @Override
    protected Integer getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return aaxParameter$ParameterData.loiSlot.getAdData().getSlotId();
    }
}
