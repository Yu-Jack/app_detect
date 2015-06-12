// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.model;

public interface GraphPlace extends GraphObject
{
    String getCategory();
    
    String getId();
    
    GraphLocation getLocation();
    
    String getName();
    
    void setCategory(String p0);
    
    void setId(String p0);
    
    void setLocation(GraphLocation p0);
    
    void setName(String p0);
}
