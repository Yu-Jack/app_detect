// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.model;

import org.json.JSONArray;
import java.util.List;

public interface GraphObjectList<T> extends List<T>
{
     <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> p0);
    
    JSONArray getInnerJSONArray();
}
