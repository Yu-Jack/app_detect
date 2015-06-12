// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.PrintWriter;
import java.io.PrintStream;

public abstract class ff implements Runnable
{
    private static final String a;
    PrintStream g;
    PrintWriter h;
    
    static {
        a = ff.class.getSimpleName();
    }
    
    public abstract void a();
    
    @Override
    public final void run() {
        try {
            this.a();
        }
        catch (Throwable t) {
            if (this.g != null) {
                t.printStackTrace(this.g);
            }
            else if (this.h != null) {
                t.printStackTrace(this.h);
            }
            else {
                t.printStackTrace();
            }
            eo.a(6, ff.a, "", t);
        }
    }
}
