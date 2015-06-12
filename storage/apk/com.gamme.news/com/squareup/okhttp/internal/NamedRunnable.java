// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

public abstract class NamedRunnable implements Runnable
{
    private final String name;
    
    public NamedRunnable(final String format, final Object... args) {
        this.name = String.format(format, args);
    }
    
    protected abstract void execute();
    
    @Override
    public final void run() {
        final String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            this.execute();
        }
        finally {
            Thread.currentThread().setName(name);
        }
    }
}
