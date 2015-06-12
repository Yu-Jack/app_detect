// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.org.codehaus.jackson.annotate;

public enum JsonTypeInfo$Id
{
    CLASS("CLASS", 1, "@class"), 
    CUSTOM("CUSTOM", 4, (String)null), 
    MINIMAL_CLASS("MINIMAL_CLASS", 2, "@c"), 
    NAME("NAME", 3, "@type"), 
    NONE("NONE", 0, (String)null);
    
    private final String _defaultPropertyName;
    
    private JsonTypeInfo$Id(final String name, final int ordinal, final String defaultPropertyName) {
        this._defaultPropertyName = defaultPropertyName;
    }
    
    public final String getDefaultPropertyName() {
        return this._defaultPropertyName;
    }
}
