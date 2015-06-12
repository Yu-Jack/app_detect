// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;

public class at extends as
{
    private final File a;
    private OutputStream b;
    
    public at(final File a) {
        this.a = a;
    }
    
    @Override
    protected OutputStream f() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == null) {
            throw new IOException("No file specified");
        }
        return this.b = new FileOutputStream(this.a);
    }
    
    @Override
    protected void g() {
        fe.a(this.b);
        this.b = null;
    }
    
    @Override
    protected void h() {
        if (this.a == null) {
            return;
        }
        this.a.delete();
    }
}
