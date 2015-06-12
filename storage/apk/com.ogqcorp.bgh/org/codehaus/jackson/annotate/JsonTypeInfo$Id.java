// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.annotate;

public enum JsonTypeInfo$Id
{
    CLASS("@class"), 
    CUSTOM((String)null), 
    MINIMAL_CLASS("@c"), 
    NAME("@type"), 
    NONE((String)null);
    
    private final String _defaultPropertyName;
    
    private JsonTypeInfo$Id(final String defaultPropertyName) {
        this._defaultPropertyName = defaultPropertyName;
    }
    
    public String getDefaultPropertyName() {
        return this._defaultPropertyName;
    }
}
