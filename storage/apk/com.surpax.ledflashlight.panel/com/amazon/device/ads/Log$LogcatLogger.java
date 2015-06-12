// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;

class Log$LogcatLogger implements ILog
{
    private static final int MAX_LENGTH = 1000;
    
    @Override
    public void d(final String s, final String s2) {
        final Iterator<String> iterator = Log.split(s2, 1000).iterator();
        while (iterator.hasNext()) {
            android.util.Log.d(s, (String)iterator.next());
        }
    }
    
    @Override
    public void d(final String s, final String format, final Object... args) {
        this.d(s, String.format(format, args));
    }
    
    @Override
    public void e(final String s, final String s2) {
        final Iterator<String> iterator = Log.split(s2, 1000).iterator();
        while (iterator.hasNext()) {
            android.util.Log.e(s, (String)iterator.next());
        }
    }
    
    @Override
    public void e(final String s, final String format, final Object... args) {
        this.e(s, String.format(format, args));
    }
    
    @Override
    public void i(final String s, final String s2) {
        final Iterator<String> iterator = Log.split(s2, 1000).iterator();
        while (iterator.hasNext()) {
            android.util.Log.i(s, (String)iterator.next());
        }
    }
    
    @Override
    public void i(final String s, final String format, final Object... args) {
        this.i(s, String.format(format, args));
    }
    
    @Override
    public void v(final String s, final String s2) {
        final Iterator<String> iterator = Log.split(s2, 1000).iterator();
        while (iterator.hasNext()) {
            android.util.Log.v(s, (String)iterator.next());
        }
    }
    
    @Override
    public void v(final String s, final String format, final Object... args) {
        this.v(s, String.format(format, args));
    }
    
    @Override
    public void w(final String s, final String s2) {
        final Iterator<String> iterator = Log.split(s2, 1000).iterator();
        while (iterator.hasNext()) {
            android.util.Log.w(s, (String)iterator.next());
        }
    }
    
    @Override
    public void w(final String s, final String format, final Object... args) {
        this.w(s, String.format(format, args));
    }
}
