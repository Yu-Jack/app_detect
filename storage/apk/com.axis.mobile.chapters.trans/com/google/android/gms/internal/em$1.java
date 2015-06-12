// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

class em$1 implements Runnable
{
    final /* synthetic */ em sg;
    
    em$1(final em sg) {
        this.sg = sg;
    }
    
    @Override
    public final void run() {
        this.sg.sf = Thread.currentThread();
        this.sg.bh();
    }
}
