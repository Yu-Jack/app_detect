// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;

class aw$a extends BufferedOutputStream
{
    private boolean a;
    
    private aw$a(final OutputStream out) {
        super(out);
        this.a = false;
    }
    
    private boolean a() {
        return this.a;
    }
    
    @Override
    public void close() {
        try {
            super.close();
        }
        catch (IOException ex) {
            this.a = true;
            throw ex;
        }
    }
    
    @Override
    public void flush() {
        try {
            super.flush();
        }
        catch (IOException ex) {
            this.a = true;
            throw ex;
        }
    }
    
    @Override
    public void write(final int b) {
        try {
            super.write(b);
        }
        catch (IOException ex) {
            this.a = true;
            throw ex;
        }
    }
    
    @Override
    public void write(final byte[] b) {
        try {
            super.write(b);
        }
        catch (IOException ex) {
            this.a = true;
            throw ex;
        }
    }
    
    @Override
    public void write(final byte[] b, final int off, final int len) {
        try {
            super.write(b, off, len);
        }
        catch (IOException ex) {
            this.a = true;
            throw ex;
        }
    }
}
