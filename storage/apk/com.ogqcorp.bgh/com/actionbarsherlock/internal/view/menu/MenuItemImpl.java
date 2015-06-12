// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.content.ActivityNotFoundException;
import android.util.Log;
import com.actionbarsherlock.view.SubMenu;
import android.view.ViewDebug$CapturedViewProperty;
import com.actionbarsherlock.view.MenuItem$OnActionExpandListener;
import android.view.ContextMenu$ContextMenuInfo;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.actionbarsherlock.view.MenuItem$OnMenuItemClickListener;
import android.view.View;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.MenuItem;

public final class MenuItemImpl implements MenuItem
{
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem$OnMenuItemClickListener mClickListener;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    private MenuBuilder mMenu;
    private ContextMenu$ContextMenuInfo mMenuInfo;
    private MenuItem$OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    
    MenuItemImpl(final MenuBuilder mMenu, final int mGroup, final int mId, final int mCategoryOrder, final int mOrdering, final CharSequence mTitle, final int mShowAsAction) {
        this.mIconResId = 0;
        this.mFlags = 16;
        this.mShowAsAction = 0;
        this.mIsActionViewExpanded = false;
        this.mMenu = mMenu;
        this.mId = mId;
        this.mGroup = mGroup;
        this.mCategoryOrder = mCategoryOrder;
        this.mOrdering = mOrdering;
        this.mTitle = mTitle;
        this.mShowAsAction = mShowAsAction;
    }
    
    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }
    
    @Override
    public boolean collapseActionView() {
        if ((0x8 & this.mShowAsAction) != 0x0) {
            if (this.mActionView == null) {
                return true;
            }
            if (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionCollapse(this)) {
                return this.mMenu.collapseItemActionView(this);
            }
        }
        return false;
    }
    
    @Override
    public boolean expandActionView() {
        return (0x8 & this.mShowAsAction) != 0x0 && this.mActionView != null && (this.mOnActionExpandListener == null || this.mOnActionExpandListener.onMenuItemActionExpand(this)) && this.mMenu.expandItemActionView(this);
    }
    
    @Override
    public ActionProvider getActionProvider() {
        return this.mActionProvider;
    }
    
    @Override
    public View getActionView() {
        if (this.mActionView != null) {
            return this.mActionView;
        }
        if (this.mActionProvider != null) {
            return this.mActionView = this.mActionProvider.onCreateActionView();
        }
        return null;
    }
    
    @Override
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }
    
    Runnable getCallback() {
        return this.mItemCallback;
    }
    
    @Override
    public int getGroupId() {
        return this.mGroup;
    }
    
    @Override
    public Drawable getIcon() {
        if (this.mIconDrawable != null) {
            return this.mIconDrawable;
        }
        if (this.mIconResId != 0) {
            return this.mMenu.getResources().getDrawable(this.mIconResId);
        }
        return null;
    }
    
    @Override
    public Intent getIntent() {
        return this.mIntent;
    }
    
    @ViewDebug$CapturedViewProperty
    @Override
    public int getItemId() {
        return this.mId;
    }
    
    @Override
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }
    
    @Override
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }
    
    @Override
    public int getOrder() {
        return this.mCategoryOrder;
    }
    
    public int getOrdering() {
        return this.mOrdering;
    }
    
    char getShortcut() {
        if (this.mMenu.isQwertyMode()) {
            return this.mShortcutAlphabeticChar;
        }
        return this.mShortcutNumericChar;
    }
    
    String getShortcutLabel() {
        final char shortcut = this.getShortcut();
        if (shortcut == '\0') {
            return "";
        }
        final StringBuilder sb = new StringBuilder(MenuItemImpl.sPrependShortcutLabel);
        switch (shortcut) {
            default: {
                sb.append(shortcut);
                break;
            }
            case 10: {
                sb.append(MenuItemImpl.sEnterShortcutLabel);
                break;
            }
            case 8: {
                sb.append(MenuItemImpl.sDeleteShortcutLabel);
                break;
            }
            case 32: {
                sb.append(MenuItemImpl.sSpaceShortcutLabel);
                break;
            }
        }
        return sb.toString();
    }
    
    @Override
    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }
    
    @ViewDebug$CapturedViewProperty
    @Override
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    @Override
    public CharSequence getTitleCondensed() {
        if (this.mTitleCondensed != null) {
            return this.mTitleCondensed;
        }
        return this.mTitle;
    }
    
    CharSequence getTitleForItemView(final MenuView$ItemView menuView$ItemView) {
        if (menuView$ItemView != null && menuView$ItemView.prefersCondensedTitle()) {
            return this.getTitleCondensed();
        }
        return this.getTitle();
    }
    
    public boolean hasCollapsibleActionView() {
        return (0x8 & this.mShowAsAction) != 0x0 && this.mActionView != null;
    }
    
    @Override
    public boolean hasSubMenu() {
        return this.mSubMenu != null;
    }
    
    public boolean invoke() {
        if ((this.mClickListener == null || !this.mClickListener.onMenuItemClick(this)) && !this.mMenu.dispatchMenuItemSelected(this.mMenu.getRootMenu(), this)) {
            if (this.mItemCallback != null) {
                this.mItemCallback.run();
                return true;
            }
            if (this.mIntent != null) {
                try {
                    this.mMenu.getContext().startActivity(this.mIntent);
                    return true;
                }
                catch (ActivityNotFoundException ex) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", (Throwable)ex);
                }
            }
            if (this.mActionProvider == null || !this.mActionProvider.onPerformDefaultAction()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isActionButton() {
        return (0x20 & this.mFlags) == 0x20;
    }
    
    @Override
    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }
    
    @Override
    public boolean isCheckable() {
        return (0x1 & this.mFlags) == 0x1;
    }
    
    @Override
    public boolean isChecked() {
        return (0x2 & this.mFlags) == 0x2;
    }
    
    @Override
    public boolean isEnabled() {
        return (0x10 & this.mFlags) != 0x0;
    }
    
    public boolean isExclusiveCheckable() {
        return (0x4 & this.mFlags) != 0x0;
    }
    
    @Override
    public boolean isVisible() {
        return (0x8 & this.mFlags) == 0x0;
    }
    
    public boolean requestsActionButton() {
        return (0x1 & this.mShowAsAction) == 0x1;
    }
    
    public boolean requiresActionButton() {
        return (0x2 & this.mShowAsAction) == 0x2;
    }
    
    @Override
    public MenuItem setActionProvider(final ActionProvider mActionProvider) {
        this.mActionView = null;
        this.mActionProvider = mActionProvider;
        this.mMenu.onItemsChanged(true);
        return this;
    }
    
    @Override
    public MenuItem setActionView(final int n) {
        final Context context = this.mMenu.getContext();
        this.setActionView(LayoutInflater.from(context).inflate(n, (ViewGroup)new LinearLayout(context), false));
        return this;
    }
    
    @Override
    public MenuItem setActionView(final View mActionView) {
        this.mActionView = mActionView;
        this.mActionProvider = null;
        if (mActionView != null && mActionView.getId() == -1 && this.mId > 0) {
            mActionView.setId(this.mId);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }
    
    public void setActionViewExpanded(final boolean mIsActionViewExpanded) {
        this.mIsActionViewExpanded = mIsActionViewExpanded;
        this.mMenu.onItemsChanged(false);
    }
    
    @Override
    public MenuItem setAlphabeticShortcut(final char ch) {
        if (this.mShortcutAlphabeticChar == ch) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(ch);
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    public MenuItem setCallback(final Runnable mItemCallback) {
        this.mItemCallback = mItemCallback;
        return this;
    }
    
    @Override
    public MenuItem setCheckable(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = 0xFFFFFFFE & this.mFlags;
        boolean b2;
        if (b) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        this.mFlags = ((b2 ? 1 : 0) | n);
        if (mFlags != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }
    
    @Override
    public MenuItem setChecked(final boolean checkedInt) {
        if ((0x4 & this.mFlags) != 0x0) {
            this.mMenu.setExclusiveItemChecked(this);
            return this;
        }
        this.setCheckedInt(checkedInt);
        return this;
    }
    
    void setCheckedInt(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = 0xFFFFFFFD & this.mFlags;
        int n2;
        if (b) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n2 | n);
        if (mFlags != this.mFlags) {
            this.mMenu.onItemsChanged(false);
        }
    }
    
    @Override
    public MenuItem setEnabled(final boolean b) {
        if (b) {
            this.mFlags |= 0x10;
        }
        else {
            this.mFlags &= 0xFFFFFFEF;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    public void setExclusiveCheckable(final boolean b) {
        final int n = 0xFFFFFFFB & this.mFlags;
        int n2;
        if (b) {
            n2 = 4;
        }
        else {
            n2 = 0;
        }
        this.mFlags = (n2 | n);
    }
    
    @Override
    public MenuItem setIcon(final int mIconResId) {
        this.mIconDrawable = null;
        this.mIconResId = mIconResId;
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    @Override
    public MenuItem setIcon(final Drawable mIconDrawable) {
        this.mIconResId = 0;
        this.mIconDrawable = mIconDrawable;
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    @Override
    public MenuItem setIntent(final Intent mIntent) {
        this.mIntent = mIntent;
        return this;
    }
    
    public void setIsActionButton(final boolean b) {
        if (b) {
            this.mFlags |= 0x20;
            return;
        }
        this.mFlags &= 0xFFFFFFDF;
    }
    
    void setMenuInfo(final ContextMenu$ContextMenuInfo mMenuInfo) {
        this.mMenuInfo = mMenuInfo;
    }
    
    @Override
    public MenuItem setNumericShortcut(final char mShortcutNumericChar) {
        if (this.mShortcutNumericChar == mShortcutNumericChar) {
            return this;
        }
        this.mShortcutNumericChar = mShortcutNumericChar;
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    @Override
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener mOnActionExpandListener) {
        this.mOnActionExpandListener = mOnActionExpandListener;
        return this;
    }
    
    @Override
    public MenuItem setOnMenuItemClickListener(final MenuItem$OnMenuItemClickListener mClickListener) {
        this.mClickListener = mClickListener;
        return this;
    }
    
    @Override
    public MenuItem setShortcut(final char mShortcutNumericChar, final char ch) {
        this.mShortcutNumericChar = mShortcutNumericChar;
        this.mShortcutAlphabeticChar = Character.toLowerCase(ch);
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    @Override
    public void setShowAsAction(final int mShowAsAction) {
        switch (mShowAsAction & 0x3) {
            default: {
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            }
            case 0:
            case 1:
            case 2: {
                this.mShowAsAction = mShowAsAction;
                this.mMenu.onItemActionRequestChanged(this);
            }
        }
    }
    
    @Override
    public MenuItem setShowAsActionFlags(final int showAsAction) {
        this.setShowAsAction(showAsAction);
        return this;
    }
    
    void setSubMenu(final SubMenuBuilder mSubMenu) {
        (this.mSubMenu = mSubMenu).setHeaderTitle(this.getTitle());
    }
    
    @Override
    public MenuItem setTitle(final int n) {
        return this.setTitle(this.mMenu.getContext().getString(n));
    }
    
    @Override
    public MenuItem setTitle(final CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        if (this.mSubMenu != null) {
            this.mSubMenu.setHeaderTitle(charSequence);
        }
        return this;
    }
    
    @Override
    public MenuItem setTitleCondensed(final CharSequence mTitleCondensed) {
        this.mTitleCondensed = mTitleCondensed;
        if (mTitleCondensed == null) {
            final CharSequence mTitle = this.mTitle;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }
    
    @Override
    public MenuItem setVisible(final boolean visibleInt) {
        if (this.setVisibleInt(visibleInt)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return this;
    }
    
    boolean setVisibleInt(final boolean b) {
        final int mFlags = this.mFlags;
        final int n = 0xFFFFFFF7 & this.mFlags;
        int n2;
        if (b) {
            n2 = 0;
        }
        else {
            n2 = 8;
        }
        this.mFlags = (n2 | n);
        final int mFlags2 = this.mFlags;
        boolean b2 = false;
        if (mFlags != mFlags2) {
            b2 = true;
        }
        return b2;
    }
    
    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }
    
    boolean shouldShowShortcut() {
        return this.mMenu.isShortcutsVisible() && this.getShortcut() != '\0';
    }
    
    public boolean showsTextAsAction() {
        return (0x4 & this.mShowAsAction) == 0x4;
    }
    
    @Override
    public String toString() {
        return this.mTitle.toString();
    }
}
