// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class Assets$CircuitBreaker
{
    boolean broken;
    final /* synthetic */ Assets this$0;
    
    Assets$CircuitBreaker(final Assets this$0) {
        this.this$0 = this$0;
        this.broken = false;
    }
    
    private void breakCircuit() {
        this.broken = true;
    }
    
    private boolean isBroken() {
        return this.broken;
    }
}
