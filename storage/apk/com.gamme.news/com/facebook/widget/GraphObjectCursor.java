// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import com.facebook.model.GraphObject;

interface GraphObjectCursor<T extends GraphObject>
{
    boolean areMoreObjectsAvailable();
    
    void close();
    
    int getCount();
    
    T getGraphObject();
    
    int getPosition();
    
    boolean isAfterLast();
    
    boolean isBeforeFirst();
    
    boolean isClosed();
    
    boolean isFirst();
    
    boolean isFromCache();
    
    boolean isLast();
    
    boolean move(int p0);
    
    boolean moveToFirst();
    
    boolean moveToLast();
    
    boolean moveToNext();
    
    boolean moveToPosition(int p0);
    
    boolean moveToPrevious();
}
