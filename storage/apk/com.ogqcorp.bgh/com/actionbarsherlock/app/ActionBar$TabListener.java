// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.app;

import android.support.v4.app.FragmentTransaction;

public interface ActionBar$TabListener
{
    void onTabReselected(ActionBar$Tab p0, FragmentTransaction p1);
    
    void onTabSelected(ActionBar$Tab p0, FragmentTransaction p1);
    
    void onTabUnselected(ActionBar$Tab p0, FragmentTransaction p1);
}
