// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.view.KeyEvent;
import android.content.Intent;
import android.content.ComponentName;

public interface Menu
{
    public static final int CATEGORY_ALTERNATIVE = 262144;
    public static final int CATEGORY_CONTAINER = 65536;
    public static final int CATEGORY_MASK = -65536;
    public static final int CATEGORY_SECONDARY = 196608;
    public static final int CATEGORY_SHIFT = 16;
    public static final int CATEGORY_SYSTEM = 131072;
    public static final int FIRST = 1;
    public static final int FLAG_ALWAYS_PERFORM_CLOSE = 2;
    public static final int FLAG_APPEND_TO_GROUP = 1;
    public static final int FLAG_PERFORM_NO_CLOSE = 1;
    public static final int NONE = 0;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT;
    
    MenuItem add(int p0);
    
    MenuItem add(int p0, int p1, int p2, int p3);
    
    MenuItem add(int p0, int p1, int p2, CharSequence p3);
    
    MenuItem add(CharSequence p0);
    
    int addIntentOptions(int p0, int p1, int p2, ComponentName p3, Intent[] p4, Intent p5, int p6, MenuItem[] p7);
    
    SubMenu addSubMenu(int p0);
    
    SubMenu addSubMenu(int p0, int p1, int p2, int p3);
    
    SubMenu addSubMenu(int p0, int p1, int p2, CharSequence p3);
    
    SubMenu addSubMenu(CharSequence p0);
    
    void clear();
    
    void close();
    
    MenuItem findItem(int p0);
    
    MenuItem getItem(int p0);
    
    boolean hasVisibleItems();
    
    boolean isShortcutKey(int p0, KeyEvent p1);
    
    boolean performIdentifierAction(int p0, int p1);
    
    boolean performShortcut(int p0, KeyEvent p1, int p2);
    
    void removeGroup(int p0);
    
    void removeItem(int p0);
    
    void setGroupCheckable(int p0, boolean p1, boolean p2);
    
    void setGroupEnabled(int p0, boolean p1);
    
    void setGroupVisible(int p0, boolean p1);
    
    void setQwertyMode(boolean p0);
    
    int size();
}
