// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import java.util.ArrayList;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.actionbarsherlock.view.MenuItem;
import android.widget.AdapterView;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import android.widget.FrameLayout;
import android.view.View$MeasureSpec;
import android.widget.ListAdapter;
import android.content.res.Resources;
import com.actionbarsherlock.R$dimen;
import com.actionbarsherlock.R$layout;
import android.view.ViewTreeObserver;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnKeyListener;

public class MenuPopupHelper implements View$OnKeyListener, ViewTreeObserver$OnGlobalLayoutListener, AdapterView$OnItemClickListener, PopupWindow$OnDismissListener, View_OnAttachStateChangeListener, MenuPresenter
{
    static final int ITEM_LAYOUT;
    private MenuPopupHelper$MenuAdapter mAdapter;
    private View mAnchorView;
    private Context mContext;
    boolean mForceShowIcon;
    private LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private MenuBuilder mMenu;
    private boolean mOverflowOnly;
    private IcsListPopupWindow mPopup;
    private int mPopupMaxWidth;
    private MenuPresenter$Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;
    
    static {
        ITEM_LAYOUT = R$layout.abs__popup_menu_item_layout;
    }
    
    public MenuPopupHelper(final Context context, final MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false);
    }
    
    public MenuPopupHelper(final Context context, final MenuBuilder menuBuilder, final View view) {
        this(context, menuBuilder, view, false);
    }
    
    public MenuPopupHelper(final Context mContext, final MenuBuilder mMenu, final View mAnchorView, final boolean mOverflowOnly) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mMenu = mMenu;
        this.mOverflowOnly = mOverflowOnly;
        final Resources resources = mContext.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abs__config_prefDialogWidth));
        this.mAnchorView = mAnchorView;
        mMenu.addMenuPresenter(this);
    }
    
    private int measureContentWidth(final ListAdapter listAdapter) {
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int count = listAdapter.getCount();
        int i = 0;
        int n = 0;
        View view = null;
        int max = 0;
        while (i < count) {
            int itemViewType = listAdapter.getItemViewType(i);
            View view2;
            if (itemViewType != n) {
                view2 = null;
            }
            else {
                itemViewType = n;
                view2 = view;
            }
            if (this.mMeasureParent == null) {
                this.mMeasureParent = (ViewGroup)new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.mMeasureParent);
            view.measure(measureSpec, measureSpec2);
            max = Math.max(max, view.getMeasuredWidth());
            ++i;
            n = itemViewType;
        }
        return max;
    }
    
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    public void dismiss() {
        if (this.isShowing()) {
            this.mPopup.dismiss();
        }
    }
    
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        return false;
    }
    
    public boolean flagActionItems() {
        return false;
    }
    
    public int getId() {
        return 0;
    }
    
    public MenuView getMenuView(final ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }
    
    public void initForMenu(final Context context, final MenuBuilder menuBuilder) {
    }
    
    public boolean isShowing() {
        return this.mPopup != null && this.mPopup.isShowing();
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (menuBuilder == this.mMenu) {
            this.dismiss();
            if (this.mPresenterCallback != null) {
                this.mPresenterCallback.onCloseMenu(menuBuilder, b);
            }
        }
    }
    
    public void onDismiss() {
        this.mPopup = null;
        this.mMenu.close();
        if (this.mTreeObserver != null) {
            if (this.mTreeObserver.isAlive()) {
                this.mTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
            }
            this.mTreeObserver = null;
        }
        else if (this.mAnchorView instanceof View_HasStateListenerSupport) {
            ((View_HasStateListenerSupport)this.mAnchorView).removeOnAttachStateChangeListener(this);
        }
    }
    
    public void onGlobalLayout() {
        if (this.isShowing()) {
            final View mAnchorView = this.mAnchorView;
            if (mAnchorView == null || !mAnchorView.isShown()) {
                this.dismiss();
            }
            else if (this.isShowing()) {
                this.mPopup.show();
            }
        }
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        final MenuPopupHelper$MenuAdapter mAdapter = this.mAdapter;
        mAdapter.mAdapterMenu.performItemAction(mAdapter.getItem(n), 0);
    }
    
    public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && n == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
    }
    
    public Parcelable onSaveInstanceState() {
        return null;
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            final MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.mAnchorView, false);
            menuPopupHelper.setCallback(this.mPresenterCallback);
            final int size = subMenuBuilder.size();
            int i = 0;
            while (true) {
                while (i < size) {
                    final MenuItem item = subMenuBuilder.getItem(i);
                    if (item.isVisible() && item.getIcon() != null) {
                        final boolean forceShowIcon = true;
                        menuPopupHelper.setForceShowIcon(forceShowIcon);
                        if (menuPopupHelper.tryShow()) {
                            if (this.mPresenterCallback != null) {
                                this.mPresenterCallback.onOpenSubMenu(subMenuBuilder);
                            }
                            return true;
                        }
                        return false;
                    }
                    else {
                        ++i;
                    }
                }
                final boolean forceShowIcon = false;
                continue;
            }
        }
        return false;
    }
    
    public void onViewAttachedToWindow(final View view) {
        ((View_HasStateListenerSupport)view).removeOnAttachStateChangeListener(this);
        if (this.mPopup != null && this.mTreeObserver == null) {
            (this.mTreeObserver = view.getViewTreeObserver()).addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
        }
    }
    
    public void onViewDetachedFromWindow(final View view) {
    }
    
    public void setAnchorView(final View mAnchorView) {
        this.mAnchorView = mAnchorView;
    }
    
    public void setCallback(final MenuPresenter$Callback mPresenterCallback) {
        this.mPresenterCallback = mPresenterCallback;
    }
    
    public void setForceShowIcon(final boolean mForceShowIcon) {
        this.mForceShowIcon = mForceShowIcon;
    }
    
    public void show() {
        if (!this.tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }
    
    public boolean tryShow() {
        (this.mPopup = new IcsListPopupWindow(this.mContext, null, R$attr.popupMenuStyle)).setOnDismissListener((PopupWindow$OnDismissListener)this);
        this.mPopup.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        this.mAdapter = new MenuPopupHelper$MenuAdapter(this, this.mMenu);
        this.mPopup.setAdapter((ListAdapter)this.mAdapter);
        this.mPopup.setModal(true);
        final View mAnchorView = this.mAnchorView;
        if (mAnchorView != null) {
            if (mAnchorView.getWindowToken() != null) {
                final ViewTreeObserver viewTreeObserver = mAnchorView.getViewTreeObserver();
                if (viewTreeObserver != this.mTreeObserver) {
                    if (this.mTreeObserver != null && this.mTreeObserver.isAlive()) {
                        this.mTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
                    }
                    if ((this.mTreeObserver = viewTreeObserver) != null) {
                        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
                    }
                }
            }
            else if (mAnchorView instanceof View_HasStateListenerSupport) {
                ((View_HasStateListenerSupport)mAnchorView).addOnAttachStateChangeListener(this);
            }
            this.mPopup.setAnchorView(mAnchorView);
            this.mPopup.setContentWidth(Math.min(this.measureContentWidth((ListAdapter)this.mAdapter), this.mPopupMaxWidth));
            this.mPopup.setInputMethodMode(2);
            this.mPopup.show();
            this.mPopup.getListView().setOnKeyListener((View$OnKeyListener)this);
            return true;
        }
        return false;
    }
    
    public void updateMenuView(final boolean b) {
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
