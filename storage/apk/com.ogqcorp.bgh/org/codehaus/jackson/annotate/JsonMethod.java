// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.annotate;

public enum JsonMethod
{
    ALL, 
    CREATOR, 
    FIELD, 
    GETTER, 
    IS_GETTER, 
    NONE, 
    SETTER;
    
    public boolean creatorEnabled() {
        return this == JsonMethod.CREATOR || this == JsonMethod.ALL;
    }
    
    public boolean fieldEnabled() {
        return this == JsonMethod.FIELD || this == JsonMethod.ALL;
    }
    
    public boolean getterEnabled() {
        return this == JsonMethod.GETTER || this == JsonMethod.ALL;
    }
    
    public boolean isGetterEnabled() {
        return this == JsonMethod.IS_GETTER || this == JsonMethod.ALL;
    }
    
    public boolean setterEnabled() {
        return this == JsonMethod.SETTER || this == JsonMethod.ALL;
    }
}
