// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class NoOpLogger implements Logger
{
    @Override
    public void d(final String s) {
    }
    
    @Override
    public void d(final String s, final Throwable t) {
    }
    
    @Override
    public void e(final String s) {
    }
    
    @Override
    public void e(final String s, final Throwable t) {
    }
    
    @Override
    public LogLevel getLogLevel() {
        return LogLevel.NONE;
    }
    
    @Override
    public void i(final String s) {
    }
    
    @Override
    public void i(final String s, final Throwable t) {
    }
    
    @Override
    public void setLogLevel(final LogLevel logLevel) {
    }
    
    @Override
    public void v(final String s) {
    }
    
    @Override
    public void v(final String s, final Throwable t) {
    }
    
    @Override
    public void w(final String s) {
    }
    
    @Override
    public void w(final String s, final Throwable t) {
    }
}
