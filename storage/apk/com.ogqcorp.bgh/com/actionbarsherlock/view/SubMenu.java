// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.view.View;
import android.graphics.drawable.Drawable;

public interface SubMenu extends Menu
{
    void clearHeader();
    
    MenuItem getItem();
    
    SubMenu setHeaderIcon(int p0);
    
    SubMenu setHeaderIcon(Drawable p0);
    
    SubMenu setHeaderTitle(int p0);
    
    SubMenu setHeaderTitle(CharSequence p0);
    
    SubMenu setHeaderView(View p0);
    
    SubMenu setIcon(int p0);
    
    SubMenu setIcon(Drawable p0);
}
