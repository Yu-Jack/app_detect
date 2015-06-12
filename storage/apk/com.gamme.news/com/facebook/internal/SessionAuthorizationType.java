// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

public enum SessionAuthorizationType
{
    PUBLISH("PUBLISH", 1), 
    READ("READ", 0);
    
    private SessionAuthorizationType(final String name, final int ordinal) {
    }
}
