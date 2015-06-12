// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

public interface Logger
{
    void d(String p0);
    
    void d(String p0, Throwable p1);
    
    void e(String p0);
    
    void e(String p0, Throwable p1);
    
    LogLevel getLogLevel();
    
    void i(String p0);
    
    void i(String p0, Throwable p1);
    
    void setLogLevel(LogLevel p0);
    
    void v(String p0);
    
    void v(String p0, Throwable p1);
    
    void w(String p0);
    
    void w(String p0, Throwable p1);
    
    public enum LogLevel
    {
        DEBUG, 
        ERROR, 
        INFO, 
        NONE, 
        VERBOSE, 
        WARNING;
    }
}
