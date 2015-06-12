// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class SISRegistration$RegisterEventsSISRequestorCallback implements SISRequestorCallback
{
    private final SISRegistration sisRegistration;
    
    public SISRegistration$RegisterEventsSISRequestorCallback(final SISRegistration sisRegistration) {
        this.sisRegistration = sisRegistration;
    }
    
    @Override
    public void onSISCallComplete() {
        this.sisRegistration.registerEvents();
    }
}
