// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import com.actionbarsherlock.view.SubMenu;
import java.util.List;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.ComponentName;
import com.actionbarsherlock.view.MenuItem;
import android.view.KeyEvent;
import java.util.ArrayList;
import android.content.Context;
import com.actionbarsherlock.view.Menu;

public class ActionMenu implements Menu
{
    private Context mContext;
    private boolean mIsQwerty;
    private ArrayList<ActionMenuItem> mItems;
    
    public ActionMenu(final Context mContext) {
        this.mContext = mContext;
        this.mItems = new ArrayList<ActionMenuItem>();
    }
    
    private int findItemIndex(final int n) {
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            if (mItems.get(i).getItemId() == n) {
                return i;
            }
        }
        return -1;
    }
    
    private ActionMenuItem findItemWithShortcut(final int n, final KeyEvent keyEvent) {
        final boolean mIsQwerty = this.mIsQwerty;
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final ActionMenuItem actionMenuItem = mItems.get(i);
            char c;
            if (mIsQwerty) {
                c = actionMenuItem.getAlphabeticShortcut();
            }
            else {
                c = actionMenuItem.getNumericShortcut();
            }
            if (n == c) {
                return actionMenuItem;
            }
        }
        return null;
    }
    
    @Override
    public MenuItem add(final int n) {
        return this.add(0, 0, 0, n);
    }
    
    @Override
    public MenuItem add(final int n, final int n2, final int n3, final int n4) {
        return this.add(n, n2, n3, this.mContext.getResources().getString(n4));
    }
    
    @Override
    public MenuItem add(final int n, final int n2, final int index, final CharSequence charSequence) {
        final ActionMenuItem element = new ActionMenuItem(this.getContext(), n, n2, 0, index, charSequence);
        this.mItems.add(index, element);
        return element;
    }
    
    @Override
    public MenuItem add(final CharSequence charSequence) {
        return this.add(0, 0, 0, charSequence);
    }
    
    @Override
    public int addIntentOptions(final int n, final int n2, final int n3, final ComponentName componentName, final Intent[] array, final Intent intent, final int n4, final MenuItem[] array2) {
        final PackageManager packageManager = this.mContext.getPackageManager();
        final List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, array, intent, 0);
        int size;
        if (queryIntentActivityOptions != null) {
            size = queryIntentActivityOptions.size();
        }
        else {
            size = 0;
        }
        if ((n4 & 0x1) == 0x0) {
            this.removeGroup(n);
        }
        for (int i = 0; i < size; ++i) {
            final ResolveInfo resolveInfo = queryIntentActivityOptions.get(i);
            Intent intent2;
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            }
            else {
                intent2 = array[resolveInfo.specificIndex];
            }
            final Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            final MenuItem setIntent = this.add(n, n2, n3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (array2 != null && resolveInfo.specificIndex >= 0) {
                array2[resolveInfo.specificIndex] = setIntent;
            }
        }
        return size;
    }
    
    @Override
    public SubMenu addSubMenu(final int n) {
        return null;
    }
    
    @Override
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final int n4) {
        return null;
    }
    
    @Override
    public SubMenu addSubMenu(final int n, final int n2, final int n3, final CharSequence charSequence) {
        return null;
    }
    
    @Override
    public SubMenu addSubMenu(final CharSequence charSequence) {
        return null;
    }
    
    @Override
    public void clear() {
        this.mItems.clear();
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public MenuItem findItem(final int n) {
        return this.mItems.get(this.findItemIndex(n));
    }
    
    public Context getContext() {
        return this.mContext;
    }
    
    @Override
    public MenuItem getItem(final int index) {
        return this.mItems.get(index);
    }
    
    @Override
    public boolean hasVisibleItems() {
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            if (mItems.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isShortcutKey(final int n, final KeyEvent keyEvent) {
        return this.findItemWithShortcut(n, keyEvent) != null;
    }
    
    @Override
    public boolean performIdentifierAction(final int n, final int n2) {
        final int itemIndex = this.findItemIndex(n);
        return itemIndex >= 0 && this.mItems.get(itemIndex).invoke();
    }
    
    @Override
    public boolean performShortcut(final int n, final KeyEvent keyEvent, final int n2) {
        final ActionMenuItem itemWithShortcut = this.findItemWithShortcut(n, keyEvent);
        return itemWithShortcut != null && itemWithShortcut.invoke();
    }
    
    @Override
    public void removeGroup(final int n) {
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        int size = mItems.size();
        int i = 0;
        while (i < size) {
            if (mItems.get(i).getGroupId() == n) {
                mItems.remove(i);
                --size;
            }
            else {
                ++i;
            }
        }
    }
    
    @Override
    public void removeItem(final int n) {
        this.mItems.remove(this.findItemIndex(n));
    }
    
    @Override
    public void setGroupCheckable(final int n, final boolean checkable, final boolean exclusiveCheckable) {
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final ActionMenuItem actionMenuItem = mItems.get(i);
            if (actionMenuItem.getGroupId() == n) {
                actionMenuItem.setCheckable(checkable);
                actionMenuItem.setExclusiveCheckable(exclusiveCheckable);
            }
        }
    }
    
    @Override
    public void setGroupEnabled(final int n, final boolean enabled) {
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final ActionMenuItem actionMenuItem = mItems.get(i);
            if (actionMenuItem.getGroupId() == n) {
                actionMenuItem.setEnabled(enabled);
            }
        }
    }
    
    @Override
    public void setGroupVisible(final int n, final boolean visible) {
        final ArrayList<ActionMenuItem> mItems = this.mItems;
        for (int size = mItems.size(), i = 0; i < size; ++i) {
            final ActionMenuItem actionMenuItem = mItems.get(i);
            if (actionMenuItem.getGroupId() == n) {
                actionMenuItem.setVisible(visible);
            }
        }
    }
    
    @Override
    public void setQwertyMode(final boolean mIsQwerty) {
        this.mIsQwerty = mIsQwerty;
    }
    
    @Override
    public int size() {
        return this.mItems.size();
    }
}
