// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

final class dx$2 implements ey$a
{
    final /* synthetic */ String qz;
    
    dx$2(final String qz) {
        this.qz = qz;
    }
    
    @Override
    public void a(final ex ex) {
        final String format = String.format("javascript:%s(%s);", "AFMA_buildAdURL", this.qz);
        eu.C("About to execute: " + format);
        ex.loadUrl(format);
    }
}
