// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class MraidAbstractController
{
    private final MraidView mView;
    
    MraidAbstractController(final MraidView mView) {
        this.mView = mView;
    }
    
    public MraidView getView() {
        return this.mView;
    }
}
