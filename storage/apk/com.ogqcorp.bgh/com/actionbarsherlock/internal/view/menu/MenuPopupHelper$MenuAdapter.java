// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

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
import android.view.LayoutInflater;
import android.content.Context;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnKeyListener;
import android.view.ViewGroup;
import android.view.View;
import java.util.ArrayList;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;

class MenuPopupHelper$MenuAdapter extends BaseAdapter
{
    private MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    final /* synthetic */ MenuPopupHelper this$0;
    
    public MenuPopupHelper$MenuAdapter(final MenuPopupHelper this$0, final MenuBuilder mAdapterMenu) {
        this.this$0 = this$0;
        this.mExpandedIndex = -1;
        this.mAdapterMenu = mAdapterMenu;
        this.registerDataSetObserver((DataSetObserver)new MenuPopupHelper$ExpandedIndexObserver(this$0, null));
        this.findExpandedIndex();
    }
    
    void findExpandedIndex() {
        final MenuItemImpl expandedItem = this.this$0.mMenu.getExpandedItem();
        if (expandedItem != null) {
            final ArrayList<MenuItemImpl> nonActionItems = this.this$0.mMenu.getNonActionItems();
            for (int size = nonActionItems.size(), i = 0; i < size; ++i) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.mExpandedIndex = i;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }
    
    public int getCount() {
        ArrayList<MenuItemImpl> list;
        if (this.this$0.mOverflowOnly) {
            list = this.mAdapterMenu.getNonActionItems();
        }
        else {
            list = this.mAdapterMenu.getVisibleItems();
        }
        if (this.mExpandedIndex < 0) {
            return list.size();
        }
        return -1 + list.size();
    }
    
    public MenuItemImpl getItem(int index) {
        ArrayList<MenuItemImpl> list;
        if (this.this$0.mOverflowOnly) {
            list = this.mAdapterMenu.getNonActionItems();
        }
        else {
            list = this.mAdapterMenu.getVisibleItems();
        }
        if (this.mExpandedIndex >= 0 && index >= this.mExpandedIndex) {
            ++index;
        }
        return list.get(index);
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.this$0.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, viewGroup, false);
        }
        else {
            inflate = view;
        }
        final ListMenuItemView listMenuItemView = (ListMenuItemView)inflate;
        if (this.this$0.mForceShowIcon) {
            ((ListMenuItemView)inflate).setForceShowIcon(true);
        }
        listMenuItemView.initialize(this.getItem(n), 0);
        return inflate;
    }
}
