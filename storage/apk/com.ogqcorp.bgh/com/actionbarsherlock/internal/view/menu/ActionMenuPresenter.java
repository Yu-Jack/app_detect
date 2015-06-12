// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import com.actionbarsherlock.view.ActionProvider;
import android.os.Parcelable;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.R$integer;
import android.view.ViewGroup$LayoutParams;
import java.util.ArrayList;
import android.view.View$MeasureSpec;
import android.os.Build$VERSION;
import android.view.ViewGroup;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.R$layout;
import android.content.Context;
import android.view.View;
import android.util.SparseBooleanArray;
import com.actionbarsherlock.view.ActionProvider$SubUiVisibilityListener;

public class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider$SubUiVisibilityListener
{
    private final SparseBooleanArray mActionButtonGroups;
    private ActionMenuPresenter$ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private View mOverflowButton;
    private ActionMenuPresenter$OverflowPopup mOverflowPopup;
    final ActionMenuPresenter$PopupPresenterCallback mPopupPresenterCallback;
    private ActionMenuPresenter$OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;
    
    public ActionMenuPresenter(final Context context) {
        super(context, R$layout.abs__action_menu_layout, R$layout.abs__action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new ActionMenuPresenter$PopupPresenterCallback(this, null);
    }
    
    private View findViewForItem(final MenuItem menuItem) {
        final ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup != null) {
            for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
                final Object child = viewGroup.getChildAt(i);
                if (child instanceof MenuView$ItemView && ((MenuView$ItemView)child).getItemData() == menuItem) {
                    return (View)child;
                }
            }
            return null;
        }
        final Object child = null;
        return (View)child;
    }
    
    public static boolean reserveOverflow(final Context context) {
        if (Build$VERSION.SDK_INT < 14) {
            if (Build$VERSION.SDK_INT < 11) {
                return false;
            }
        }
        else if (ActionMenuPresenter$HasPermanentMenuKey.get(context)) {
            return false;
        }
        return true;
    }
    
    @Override
    public void bindItemView(final MenuItemImpl menuItemImpl, final MenuView$ItemView menuView$ItemView) {
        menuView$ItemView.initialize(menuItemImpl, 0);
        ((ActionMenuItemView)menuView$ItemView).setItemInvoker((MenuBuilder$ItemInvoker)this.mMenuView);
    }
    
    public boolean dismissPopupMenus() {
        return this.hideOverflowMenu() | this.hideSubMenus();
    }
    
    public boolean filterLeftoverView(final ViewGroup viewGroup, final int n) {
        return viewGroup.getChildAt(n) != this.mOverflowButton && super.filterLeftoverView(viewGroup, n);
    }
    
    @Override
    public boolean flagActionItems() {
        final ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
        final int size = visibleItems.size();
        int mMaxItems = this.mMaxItems;
        int mActionItemWidthLimit = this.mActionItemWidthLimit;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        int n = 0;
        int n2 = 0;
        boolean b = false;
        int n3;
        for (int i = 0; i < size; ++i, mMaxItems = n3) {
            final MenuItemImpl menuItemImpl = visibleItems.get(i);
            if (menuItemImpl.requiresActionButton()) {
                ++n;
            }
            else if (menuItemImpl.requestsActionButton()) {
                ++n2;
            }
            else {
                b = true;
            }
            if (this.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                n3 = 0;
            }
            else {
                n3 = mMaxItems;
            }
        }
        if (this.mReserveOverflow && (b || n + n2 > mMaxItems)) {
            --mMaxItems;
        }
        int n4 = mMaxItems - n;
        final SparseBooleanArray mActionButtonGroups = this.mActionButtonGroups;
        mActionButtonGroups.clear();
        int n5;
        int n6;
        if (this.mStrictWidthLimit) {
            n5 = mActionItemWidthLimit / this.mMinCellSize;
            n6 = this.mMinCellSize + mActionItemWidthLimit % this.mMinCellSize / n5;
        }
        else {
            n5 = 0;
            n6 = 0;
        }
        int j = 0;
        int n7 = 0;
        int n8 = n5;
        while (j < size) {
            final MenuItemImpl menuItemImpl2 = visibleItems.get(j);
            int measuredWidth;
            int n10;
            int n11;
            if (menuItemImpl2.requiresActionButton()) {
                final View itemView = this.getItemView(menuItemImpl2, this.mScrapActionButtonView, viewGroup);
                if (this.mScrapActionButtonView == null) {
                    this.mScrapActionButtonView = itemView;
                }
                if (this.mStrictWidthLimit) {
                    n8 -= ActionMenuView.measureChildForCells(itemView, n6, n8, measureSpec, 0);
                }
                else {
                    itemView.measure(measureSpec, measureSpec);
                }
                measuredWidth = itemView.getMeasuredWidth();
                final int n9 = mActionItemWidthLimit - measuredWidth;
                if (n7 != 0) {
                    measuredWidth = n7;
                }
                final int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    mActionButtonGroups.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                n10 = n9;
                n11 = n4;
            }
            else if (menuItemImpl2.requestsActionButton()) {
                final int groupId2 = menuItemImpl2.getGroupId();
                final boolean value = mActionButtonGroups.get(groupId2);
                final boolean b2 = (n4 > 0 || value) && mActionItemWidthLimit > 0 && (!this.mStrictWidthLimit || n8 > 0);
                boolean isActionButton;
                int n14;
                int n15;
                if (b2) {
                    final View itemView2 = this.getItemView(menuItemImpl2, this.mScrapActionButtonView, viewGroup);
                    if (this.mScrapActionButtonView == null) {
                        this.mScrapActionButtonView = itemView2;
                    }
                    boolean b3;
                    int n13;
                    if (this.mStrictWidthLimit) {
                        final int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, n6, n8, measureSpec, 0);
                        final int n12 = n8 - measureChildForCells;
                        b3 = (measureChildForCells != 0 && b2);
                        n13 = n12;
                    }
                    else {
                        itemView2.measure(measureSpec, measureSpec);
                        final boolean b4 = b2;
                        n13 = n8;
                        b3 = b4;
                    }
                    final int measuredWidth2 = itemView2.getMeasuredWidth();
                    mActionItemWidthLimit -= measuredWidth2;
                    if (n7 == 0) {
                        n7 = measuredWidth2;
                    }
                    if (this.mStrictWidthLimit) {
                        boolean b5;
                        if (mActionItemWidthLimit >= 0) {
                            b5 = true;
                        }
                        else {
                            b5 = false;
                        }
                        isActionButton = (b3 & b5);
                        n14 = n7;
                        n15 = n13;
                    }
                    else {
                        boolean b6;
                        if (mActionItemWidthLimit + n7 > 0) {
                            b6 = true;
                        }
                        else {
                            b6 = false;
                        }
                        isActionButton = (b3 & b6);
                        n14 = n7;
                        n15 = n13;
                    }
                }
                else {
                    isActionButton = b2;
                    n14 = n7;
                    n15 = n8;
                }
                int n16;
                if (isActionButton && groupId2 != 0) {
                    mActionButtonGroups.put(groupId2, true);
                    n16 = n4;
                }
                else if (value) {
                    mActionButtonGroups.put(groupId2, false);
                    int n17 = n4;
                    for (int k = 0; k < j; ++k) {
                        final MenuItemImpl menuItemImpl3 = visibleItems.get(k);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                ++n17;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                    n16 = n17;
                }
                else {
                    n16 = n4;
                }
                if (isActionButton) {
                    --n16;
                }
                menuItemImpl2.setIsActionButton(isActionButton);
                measuredWidth = n14;
                n10 = mActionItemWidthLimit;
                final int n18 = n15;
                n11 = n16;
                n8 = n18;
            }
            else {
                measuredWidth = n7;
                n10 = mActionItemWidthLimit;
                n11 = n4;
            }
            ++j;
            mActionItemWidthLimit = n10;
            n4 = n11;
            n7 = measuredWidth;
        }
        return true;
    }
    
    @Override
    public View getItemView(final MenuItemImpl menuItemImpl, View view, final ViewGroup viewGroup) {
        View view2 = menuItemImpl.getActionView();
        if (view2 == null || menuItemImpl.hasCollapsibleActionView()) {
            if (!(view instanceof ActionMenuItemView)) {
                view = null;
            }
            view2 = super.getItemView(menuItemImpl, view, viewGroup);
        }
        int visibility;
        if (menuItemImpl.isActionViewExpanded()) {
            visibility = 8;
        }
        else {
            visibility = 0;
        }
        view2.setVisibility(visibility);
        final ActionMenuView actionMenuView = (ActionMenuView)viewGroup;
        final ViewGroup$LayoutParams layoutParams = view2.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            view2.setLayoutParams((ViewGroup$LayoutParams)actionMenuView.generateLayoutParams(layoutParams));
        }
        return view2;
    }
    
    @Override
    public MenuView getMenuView(final ViewGroup viewGroup) {
        final MenuView menuView = super.getMenuView(viewGroup);
        ((ActionMenuView)menuView).setPresenter(this);
        return menuView;
    }
    
    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
            ((View)this.mMenuView).removeCallbacks((Runnable)this.mPostedOpenRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        final ActionMenuPresenter$OverflowPopup mOverflowPopup = this.mOverflowPopup;
        if (mOverflowPopup != null) {
            mOverflowPopup.dismiss();
            return true;
        }
        return false;
    }
    
    public boolean hideSubMenus() {
        if (this.mActionButtonPopup != null) {
            this.mActionButtonPopup.dismiss();
            return true;
        }
        return false;
    }
    
    @Override
    public void initForMenu(final Context context, final MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        final Resources resources = context.getResources();
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = reserveOverflow(this.mContext);
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = resources.getDisplayMetrics().widthPixels / 2;
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ResourcesCompat.getResources_getInteger(context, R$integer.abs__max_action_buttons);
        }
        int mWidthLimit = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = (View)new ActionMenuPresenter$OverflowMenuButton(this, this.mSystemContext);
                final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(measureSpec, measureSpec);
            }
            mWidthLimit -= this.mOverflowButton.getMeasuredWidth();
        }
        else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = mWidthLimit;
        this.mMinCellSize = (int)(56.0f * resources.getDisplayMetrics().density);
        this.mScrapActionButtonView = null;
    }
    
    public boolean isOverflowMenuShowing() {
        return this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
    }
    
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        this.dismissPopupMenus();
        super.onCloseMenu(menuBuilder, b);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ResourcesCompat.getResources_getInteger(this.mContext, R$integer.abs__max_action_buttons);
            if (this.mMenu != null) {
                this.mMenu.onItemsChanged(true);
            }
        }
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = (ActionMenuPresenter$SavedState)parcelable;
        if (actionMenuPresenter$SavedState.openSubMenuId > 0) {
            final MenuItem item = this.mMenu.findItem(actionMenuPresenter$SavedState.openSubMenuId);
            if (item != null) {
                this.onSubMenuSelected((SubMenuBuilder)item.getSubMenu());
            }
        }
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        final ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.openSubMenuId = this.mOpenSubMenuId;
        return (Parcelable)actionMenuPresenter$SavedState;
    }
    
    @Override
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2;
        for (subMenuBuilder2 = subMenuBuilder; subMenuBuilder2.getParentMenu() != this.mMenu; subMenuBuilder2 = (SubMenuBuilder)subMenuBuilder2.getParentMenu()) {}
        View anchorView = this.findViewForItem(subMenuBuilder2.getItem());
        if (anchorView == null) {
            if (this.mOverflowButton == null) {
                return false;
            }
            anchorView = this.mOverflowButton;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        (this.mActionButtonPopup = new ActionMenuPresenter$ActionButtonSubmenu(this, this.mContext, subMenuBuilder)).setAnchorView(anchorView);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }
    
    @Override
    public void onSubUiVisibilityChanged(final boolean b) {
        if (b) {
            super.onSubMenuSelected(null);
            return;
        }
        this.mMenu.close(false);
    }
    
    public void setExpandedActionViewsExclusive(final boolean mExpandedActionViewsExclusive) {
        this.mExpandedActionViewsExclusive = mExpandedActionViewsExclusive;
    }
    
    public void setItemLimit(final int mMaxItems) {
        this.mMaxItems = mMaxItems;
        this.mMaxItemsSet = true;
    }
    
    public void setReserveOverflow(final boolean mReserveOverflow) {
        this.mReserveOverflow = mReserveOverflow;
        this.mReserveOverflowSet = true;
    }
    
    public void setWidthLimit(final int mWidthLimit, final boolean mStrictWidthLimit) {
        this.mWidthLimit = mWidthLimit;
        this.mStrictWidthLimit = mStrictWidthLimit;
        this.mWidthLimitSet = true;
    }
    
    @Override
    public boolean shouldIncludeItem(final int n, final MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }
    
    public boolean showOverflowMenu() {
        if (this.mReserveOverflow && !this.isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
            this.mPostedOpenRunnable = new ActionMenuPresenter$OpenOverflowRunnable(this, new ActionMenuPresenter$OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
            ((View)this.mMenuView).post((Runnable)this.mPostedOpenRunnable);
            super.onSubMenuSelected(null);
            return true;
        }
        return false;
    }
    
    @Override
    public void updateMenuView(final boolean b) {
        int n = 1;
        super.updateMenuView(b);
        if (this.mMenu != null) {
            final ArrayList<MenuItemImpl> actionItems = this.mMenu.getActionItems();
            for (int size = actionItems.size(), i = 0; i < size; ++i) {
                final ActionProvider actionProvider = actionItems.get(i).getActionProvider();
                if (actionProvider != null) {
                    actionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems;
        if (this.mMenu != null) {
            nonActionItems = this.mMenu.getNonActionItems();
        }
        else {
            nonActionItems = null;
        }
        final boolean mReserveOverflow = this.mReserveOverflow;
        int n2 = 0;
        if (mReserveOverflow) {
            n2 = 0;
            if (nonActionItems != null) {
                final int size2 = nonActionItems.size();
                if (size2 == n) {
                    int n3;
                    if (!nonActionItems.get(0).isActionViewExpanded()) {
                        n3 = n;
                    }
                    else {
                        n3 = 0;
                    }
                    n2 = n3;
                }
                else {
                    if (size2 <= 0) {
                        n = 0;
                    }
                    n2 = n;
                }
            }
        }
        if (n2 != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = (View)new ActionMenuPresenter$OverflowMenuButton(this, this.mSystemContext);
            }
            final ViewGroup viewGroup = (ViewGroup)this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                final ActionMenuView actionMenuView = (ActionMenuView)this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, (ViewGroup$LayoutParams)actionMenuView.generateOverflowButtonLayoutParams());
            }
        }
        else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
        }
        ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
