// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

interface RateLimiter
{
    public static final int DEFAULT_MAX_TOKEN_COUNT = 60;
    public static final long DEFAULT_MILLISECONDS_PER_TOKEN = 2000L;
    
    boolean tokenAvailable();
}
