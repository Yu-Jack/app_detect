// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

public interface Logger
{
    void error(Exception p0);
    
    void error(String p0);
    
    LogLevel getLogLevel();
    
    void info(String p0);
    
    void setLogLevel(LogLevel p0);
    
    void verbose(String p0);
    
    void warn(String p0);
    
    public enum LogLevel
    {
        ERROR, 
        INFO, 
        VERBOSE, 
        WARNING;
    }
}
