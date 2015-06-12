// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum LoggingBehavior
{
    APP_EVENTS("APP_EVENTS", 4), 
    CACHE("CACHE", 3), 
    DEVELOPER_ERRORS("DEVELOPER_ERRORS", 5), 
    INCLUDE_ACCESS_TOKENS("INCLUDE_ACCESS_TOKENS", 1), 
    INCLUDE_RAW_RESPONSES("INCLUDE_RAW_RESPONSES", 2);
    
    @Deprecated
    public static final LoggingBehavior INSIGHTS;
    
    REQUESTS("REQUESTS", 0);
    
    static {
        INSIGHTS = LoggingBehavior.APP_EVENTS;
    }
    
    private LoggingBehavior(final String name, final int ordinal) {
    }
}
