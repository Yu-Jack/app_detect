// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public abstract class em
{
    private final Runnable lg;
    private volatile Thread sf;
    
    public em() {
        this.lg = new em$1(this);
    }
    
    public abstract void bh();
    
    public final void cancel() {
        this.onStop();
        if (this.sf != null) {
            this.sf.interrupt();
        }
    }
    
    public abstract void onStop();
    
    public final void start() {
        en.execute(this.lg);
    }
}
