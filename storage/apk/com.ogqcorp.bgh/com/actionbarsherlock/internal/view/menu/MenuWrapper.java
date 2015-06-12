// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.view.KeyEvent;
import java.util.Map;
import android.content.Intent;
import android.content.ComponentName;
import android.view.SubMenu;
import android.view.MenuItem;
import java.util.WeakHashMap;
import com.actionbarsherlock.view.Menu;

public class MenuWrapper implements Menu
{
    private final WeakHashMap<MenuItem, com.actionbarsherlock.view.MenuItem> mNativeMap;
    private final android.view.Menu mNativeMenu;
    
    public MenuWrapper(final android.view.Menu mNativeMenu) {
        this.mNativeMap = new WeakHashMap<MenuItem, com.actionbarsherlock.view.MenuItem>();
        this.mNativeMenu = mNativeMenu;
    }
    
    private com.actionbarsherlock.view.MenuItem addInternal(final MenuItem key) {
        final MenuItemWrapper value = new MenuItemWrapper(key);
        this.mNativeMap.put(key, value);
        return value;
    }
    
    private com.actionbarsherlock.view.SubMenu addInternal(final SubMenu subMenu) {
        final SubMenuWrapper subMenuWrapper = new SubMenuWrapper(subMenu);
        this.mNativeMap.put(subMenu.getItem(), subMenuWrapper.getItem());
        return subMenuWrapper;
    }
    
    @Override
    public com.actionbarsherlock.view.MenuItem add(final int n) {
        return this.addInternal(this.mNativeMenu.add(n));
    }
    
    @Override
    public com.actionbarsherlock.view.MenuItem add(final int n, final int n2, final int n3, final int n4) {
        return this.addInternal(this.mNativeMenu.add(n, n2, n3, n4));
    }
    
    @Override
    public com.actionbarsherlock.view.MenuItem add(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return this.addInternal(this.mNativeMenu.add(n, n2, n3, charSequence));
    }
    
    @Override
    public com.actionbarsherlock.view.MenuItem add(final CharSequence charSequence) {
        return this.addInternal(this.mNativeMenu.add(charSequence));
    }
    
    @Override
    public int addIntentOptions(final int n, final int n2, final int n3, final ComponentName componentName, final Intent[] array, final Intent intent, final int n4, final com.actionbarsherlock.view.MenuItem[] array2) {
        int n5;
        if (array2 != null) {
            final MenuItem[] array3 = new MenuItem[array2.length];
            n5 = this.mNativeMenu.addIntentOptions(n, n2, n3, componentName, array, intent, n4, array3);
            for (int i = 0; i < array2.length; ++i) {
                array2[i] = new MenuItemWrapper(array3[i]);
            }
        }
        else {
            n5 = this.mNativeMenu.addIntentOptions(n, n2, n3, componentName, array, intent, n4, (MenuItem[])null);
        }
        return n5;
    }
    
    @Override
    public com.actionbarsherlock.view.SubMenu addSubMenu(final int n) {
        return this.addInternal(this.mNativeMenu.addSubMenu(n));
    }
    
    @Override
    public com.actionbarsherlock.view.SubMenu addSubMenu(final int n, final int n2, final int n3, final int n4) {
        return this.addInternal(this.mNativeMenu.addSubMenu(n, n2, n3, n4));
    }
    
    @Override
    public com.actionbarsherlock.view.SubMenu addSubMenu(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return this.addInternal(this.mNativeMenu.addSubMenu(n, n2, n3, charSequence));
    }
    
    @Override
    public com.actionbarsherlock.view.SubMenu addSubMenu(final CharSequence charSequence) {
        return this.addInternal(this.mNativeMenu.addSubMenu(charSequence));
    }
    
    @Override
    public void clear() {
        this.mNativeMap.clear();
        this.mNativeMenu.clear();
    }
    
    @Override
    public void close() {
        this.mNativeMenu.close();
    }
    
    @Override
    public com.actionbarsherlock.view.MenuItem findItem(final int n) {
        return this.findItem(this.mNativeMenu.findItem(n));
    }
    
    public com.actionbarsherlock.view.MenuItem findItem(final MenuItem key) {
        com.actionbarsherlock.view.MenuItem menuItem;
        if (key == null) {
            menuItem = null;
        }
        else {
            menuItem = this.mNativeMap.get(key);
            if (menuItem == null) {
                return this.addInternal(key);
            }
        }
        return menuItem;
    }
    
    @Override
    public com.actionbarsherlock.view.MenuItem getItem(final int n) {
        return this.findItem(this.mNativeMenu.getItem(n));
    }
    
    @Override
    public boolean hasVisibleItems() {
        return this.mNativeMenu.hasVisibleItems();
    }
    
    public void invalidate() {
        if (this.mNativeMap.isEmpty()) {
            return;
        }
        final WeakHashMap<MenuItem, com.actionbarsherlock.view.MenuItem> m = new WeakHashMap<MenuItem, com.actionbarsherlock.view.MenuItem>(this.mNativeMap.size());
        for (int i = 0; i < this.mNativeMenu.size(); ++i) {
            final MenuItem item = this.mNativeMenu.getItem(i);
            m.put(item, this.mNativeMap.get(item));
        }
        this.mNativeMap.clear();
        this.mNativeMap.putAll(m);
    }
    
    @Override
    public boolean isShortcutKey(final int n, final KeyEvent keyEvent) {
        return this.mNativeMenu.isShortcutKey(n, keyEvent);
    }
    
    @Override
    public boolean performIdentifierAction(final int n, final int n2) {
        return this.mNativeMenu.performIdentifierAction(n, n2);
    }
    
    @Override
    public boolean performShortcut(final int n, final KeyEvent keyEvent, final int n2) {
        return this.mNativeMenu.performShortcut(n, keyEvent, n2);
    }
    
    @Override
    public void removeGroup(final int n) {
        for (int i = 0; i < this.mNativeMenu.size(); ++i) {
            final MenuItem item = this.mNativeMenu.getItem(i);
            if (item.getGroupId() == n) {
                this.mNativeMap.remove(item);
            }
        }
        this.mNativeMenu.removeGroup(n);
    }
    
    @Override
    public void removeItem(final int n) {
        this.mNativeMap.remove(this.mNativeMenu.findItem(n));
        this.mNativeMenu.removeItem(n);
    }
    
    @Override
    public void setGroupCheckable(final int n, final boolean b, final boolean b2) {
        this.mNativeMenu.setGroupCheckable(n, b, b2);
    }
    
    @Override
    public void setGroupEnabled(final int n, final boolean b) {
        this.mNativeMenu.setGroupEnabled(n, b);
    }
    
    @Override
    public void setGroupVisible(final int n, final boolean b) {
        this.mNativeMenu.setGroupVisible(n, b);
    }
    
    @Override
    public void setQwertyMode(final boolean qwertyMode) {
        this.mNativeMenu.setQwertyMode(qwertyMode);
    }
    
    @Override
    public int size() {
        return this.mNativeMenu.size();
    }
    
    public android.view.Menu unwrap() {
        return this.mNativeMenu;
    }
}
