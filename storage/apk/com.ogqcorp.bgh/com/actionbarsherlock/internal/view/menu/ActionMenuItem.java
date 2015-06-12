// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import com.actionbarsherlock.view.MenuItem$OnActionExpandListener;
import com.actionbarsherlock.view.SubMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.View;
import com.actionbarsherlock.view.ActionProvider;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.content.Context;
import com.actionbarsherlock.view.MenuItem$OnMenuItemClickListener;
import com.actionbarsherlock.view.MenuItem;

public class ActionMenuItem implements MenuItem
{
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem$OnMenuItemClickListener mClickListener;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    
    public ActionMenuItem(final Context mContext, final int mGroup, final int mId, final int n, final int mOrdering, final CharSequence mTitle) {
        this.mFlags = 16;
        this.mContext = mContext;
        this.mId = mId;
        this.mGroup = mGroup;
        this.mOrdering = mOrdering;
        this.mTitle = mTitle;
    }
    
    @Override
    public boolean collapseActionView() {
        return false;
    }
    
    @Override
    public boolean expandActionView() {
        return false;
    }
    
    @Override
    public ActionProvider getActionProvider() {
        return null;
    }
    
    @Override
    public View getActionView() {
        return null;
    }
    
    @Override
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }
    
    @Override
    public int getGroupId() {
        return this.mGroup;
    }
    
    @Override
    public Drawable getIcon() {
        return this.mIconDrawable;
    }
    
    @Override
    public Intent getIntent() {
        return this.mIntent;
    }
    
    @Override
    public int getItemId() {
        return this.mId;
    }
    
    @Override
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return null;
    }
    
    @Override
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }
    
    @Override
    public int getOrder() {
        return this.mOrdering;
    }
    
    @Override
    public SubMenu getSubMenu() {
        return null;
    }
    
    @Override
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    @Override
    public CharSequence getTitleCondensed() {
        return this.mTitleCondensed;
    }
    
    @Override
    public boolean hasSubMenu() {
        return false;
    }
    
    public boolean invoke() {
        if (this.mClickListener != null && this.mClickListener.onMenuItemClick(this)) {
            return true;
        }
        if (this.mIntent != null) {
            this.mContext.startActivity(this.mIntent);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isActionViewExpanded() {
        return false;
    }
    
    @Override
    public boolean isCheckable() {
        return (0x1 & this.mFlags) != 0x0;
    }
    
    @Override
    public boolean isChecked() {
        return (0x2 & this.mFlags) != 0x0;
    }
    
    @Override
    public boolean isEnabled() {
        return (0x10 & this.mFlags) != 0x0;
    }
    
    @Override
    public boolean isVisible() {
        return (0x8 & this.mFlags) == 0x0;
    }
    
    @Override
    public MenuItem setActionProvider(final ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MenuItem setActionView(final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MenuItem setActionView(final View view) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MenuItem setAlphabeticShortcut(final char mShortcutAlphabeticChar) {
        this.mShortcutAlphabeticChar = mShortcutAlphabeticChar;
        return this;
    }
    
    @Override
    public MenuItem setCheckable(final boolean b) {
        final int n = 0xFFFFFFFE & this.mFlags;
        boolean b2;
        if (b) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        this.mFlags = ((b2 ? 1 : 0) | n);
        return this;
    }
    
    @Override
    public MenuItem setChecked(final boolean b) {
        final int n = 0xFFFFFFFD & this.mFlags;
        int n2;
        if (b) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n2 | n);
        return this;
    }
    
    @Override
    public MenuItem setEnabled(final boolean b) {
        final int n = 0xFFFFFFEF & this.mFlags;
        int n2;
        if (b) {
            n2 = 16;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n2 | n);
        return this;
    }
    
    public ActionMenuItem setExclusiveCheckable(final boolean b) {
        final int n = 0xFFFFFFFB & this.mFlags;
        int n2;
        if (b) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n2 | n);
        return this;
    }
    
    @Override
    public MenuItem setIcon(final int n) {
        this.mIconDrawable = this.mContext.getResources().getDrawable(n);
        return this;
    }
    
    @Override
    public MenuItem setIcon(final Drawable mIconDrawable) {
        this.mIconDrawable = mIconDrawable;
        return this;
    }
    
    @Override
    public MenuItem setIntent(final Intent mIntent) {
        this.mIntent = mIntent;
        return this;
    }
    
    @Override
    public MenuItem setNumericShortcut(final char mShortcutNumericChar) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        return this;
    }
    
    @Override
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        return this;
    }
    
    @Override
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
        return this;
    }
    
    @Override
    public MenuItem setShortcut(final char mShortcutNumericChar, final char mShortcutAlphabeticChar) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        this.mShortcutAlphabeticChar = mShortcutAlphabeticChar;
        return this;
    }
    
    @Override
    public void setShowAsAction(final int n) {
    }
    
    @Override
    public MenuItem setShowAsActionFlags(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    @Override
    public MenuItem setTitle(final int n) {
        this.mTitle = this.mContext.getResources().getString(n);
        return this;
    }
    
    @Override
    public MenuItem setTitle(final CharSequence mTitle) {
        this.mTitle = mTitle;
        return this;
    }
    
    @Override
    public MenuItem setTitleCondensed(final CharSequence mTitleCondensed) {
        this.mTitleCondensed = mTitleCondensed;
        return this;
    }
    
    @Override
    public MenuItem setVisible(final boolean b) {
        final int n = 0x8 & this.mFlags;
        int n2;
        if (b) {
            n2 = 0;
        }
        else {
            n2 = 8;
        }
        this.mFlags = (n2 | n);
        return this;
    }
}
