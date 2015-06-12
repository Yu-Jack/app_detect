// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.view.InflateException;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import android.util.TypedValue;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$styleable;
import android.util.AttributeSet;
import android.view.View;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import android.util.Log;

class MenuInflater$MenuState
{
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    private ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private boolean itemEnabled;
    private int itemIconResId;
    private int itemId;
    private String itemListenerMethodName;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private boolean itemVisible;
    private Menu menu;
    final /* synthetic */ MenuInflater this$0;
    
    public MenuInflater$MenuState(final MenuInflater this$0, final Menu menu) {
        this.this$0 = this$0;
        this.menu = menu;
        this.resetGroup();
    }
    
    private char getShortcut(final String s) {
        if (s == null) {
            return '\0';
        }
        return s.charAt(0);
    }
    
    private <T> T newInstance(final String s, final Class<?>[] parameterTypes, final Object[] initargs) {
        try {
            return (T)this.this$0.mContext.getClassLoader().loadClass(s).getConstructor(parameterTypes).newInstance(initargs);
        }
        catch (Exception ex) {
            Log.w("MenuInflater", "Cannot instantiate class: " + s, (Throwable)ex);
            return null;
        }
    }
    
    private void setItem(final MenuItem menuItem) {
        int exclusiveCheckable = 1;
        menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= exclusiveCheckable && exclusiveCheckable).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
        if (this.itemShowAsAction >= 0) {
            menuItem.setShowAsAction(this.itemShowAsAction);
        }
        if (this.itemListenerMethodName != null) {
            if (this.this$0.mContext.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new MenuInflater$InflatedOnMenuItemClickListener(this.this$0.mRealOwner, this.itemListenerMethodName));
        }
        if (this.itemCheckable >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl)menuItem).setExclusiveCheckable(exclusiveCheckable != 0);
            }
            else {
                this.menu.setGroupCheckable(this.groupId, exclusiveCheckable != 0, exclusiveCheckable != 0);
            }
        }
        if (this.itemActionViewClassName != null) {
            menuItem.setActionView(this.newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
        }
        else {
            exclusiveCheckable = 0;
        }
        if (this.itemActionViewLayout > 0) {
            if (exclusiveCheckable == 0) {
                menuItem.setActionView(this.itemActionViewLayout);
            }
            else {
                Log.w("MenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        if (this.itemActionProvider != null) {
            menuItem.setActionProvider(this.itemActionProvider);
        }
    }
    
    public void addItem() {
        this.itemAdded = true;
        this.setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem() {
        this.itemAdded = true;
        final SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
        this.setItem(addSubMenu.getItem());
        return addSubMenu;
    }
    
    public boolean hasAddedItem() {
        return this.itemAdded;
    }
    
    public void readGroup(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(set, R$styleable.SherlockMenuGroup);
        this.groupId = obtainStyledAttributes.getResourceId(1, 0);
        this.groupCategory = obtainStyledAttributes.getInt(3, 0);
        this.groupOrder = obtainStyledAttributes.getInt(4, 0);
        this.groupCheckable = obtainStyledAttributes.getInt(5, 0);
        this.groupVisible = obtainStyledAttributes.getBoolean(2, true);
        this.groupEnabled = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }
    
    public void readItem(final AttributeSet set) {
        int n = 1;
        final TypedArray obtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(set, R$styleable.SherlockMenuItem);
        this.itemId = obtainStyledAttributes.getResourceId(2, 0);
        this.itemCategoryOrder = ((obtainStyledAttributes.getInt(5, this.groupCategory) & 0xFFFF0000) | (obtainStyledAttributes.getInt(6, this.groupOrder) & 0xFFFF));
        this.itemTitle = obtainStyledAttributes.getText(7);
        this.itemTitleCondensed = obtainStyledAttributes.getText(8);
        this.itemIconResId = obtainStyledAttributes.getResourceId(0, 0);
        this.itemAlphabeticShortcut = this.getShortcut(obtainStyledAttributes.getString(9));
        this.itemNumericShortcut = this.getShortcut(obtainStyledAttributes.getString(10));
        if (obtainStyledAttributes.hasValue(11)) {
            int itemCheckable;
            if (obtainStyledAttributes.getBoolean(11, false)) {
                itemCheckable = n;
            }
            else {
                itemCheckable = 0;
            }
            this.itemCheckable = itemCheckable;
        }
        else {
            this.itemCheckable = this.groupCheckable;
        }
        this.itemChecked = obtainStyledAttributes.getBoolean(3, false);
        this.itemVisible = obtainStyledAttributes.getBoolean(4, this.groupVisible);
        this.itemEnabled = obtainStyledAttributes.getBoolean(n, this.groupEnabled);
        final TypedValue typedValue = new TypedValue();
        obtainStyledAttributes.getValue(13, typedValue);
        int data;
        if (typedValue.type == 17) {
            data = typedValue.data;
        }
        else {
            data = -1;
        }
        this.itemShowAsAction = data;
        this.itemListenerMethodName = obtainStyledAttributes.getString(12);
        this.itemActionViewLayout = obtainStyledAttributes.getResourceId(14, 0);
        final TypedValue typedValue2 = new TypedValue();
        obtainStyledAttributes.getValue(15, typedValue2);
        String string;
        if (typedValue2.type == 3) {
            string = typedValue2.string.toString();
        }
        else {
            string = null;
        }
        this.itemActionViewClassName = string;
        final TypedValue typedValue3 = new TypedValue();
        obtainStyledAttributes.getValue(16, typedValue3);
        String string2;
        if (typedValue3.type == 3) {
            string2 = typedValue3.string.toString();
        }
        else {
            string2 = null;
        }
        this.itemActionProviderClassName = string2;
        if (this.itemActionProviderClassName == null) {
            n = 0;
        }
        if (n != 0 && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
            this.itemActionProvider = this.newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
        }
        else {
            if (n != 0) {
                Log.w("MenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.itemActionProvider = null;
        }
        obtainStyledAttributes.recycle();
        this.itemAdded = false;
    }
    
    public void resetGroup() {
        this.groupId = 0;
        this.groupCategory = 0;
        this.groupOrder = 0;
        this.groupCheckable = 0;
        this.groupVisible = true;
        this.groupEnabled = true;
    }
}
