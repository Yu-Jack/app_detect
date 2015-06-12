// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AAXParameter$TestParameter extends AAXParameter$BooleanParameter
{
    AAXParameter$TestParameter() {
        super("isTest", "debug.test");
    }
    
    @Override
    protected Boolean getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return Settings.getInstance().getBoolean("testingEnabled", null);
    }
}
