// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.org.codehaus.jackson.annotate;

public enum JsonMethod
{
    ALL("ALL", 6), 
    CREATOR("CREATOR", 2), 
    FIELD("FIELD", 3), 
    GETTER("GETTER", 0), 
    IS_GETTER("IS_GETTER", 4), 
    NONE("NONE", 5), 
    SETTER("SETTER", 1);
    
    private JsonMethod(final String name, final int ordinal) {
    }
}
