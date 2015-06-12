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
import com.actionbarsherlock.R$layout;
import android.util.SparseBooleanArray;
import com.actionbarsherlock.view.ActionProvider$SubUiVisibilityListener;
import com.actionbarsherlock.view.MenuItem;
import android.view.View;
import android.content.Context;

class ActionMenuPresenter$ActionButtonSubmenu extends MenuPopupHelper
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$ActionButtonSubmenu(final ActionMenuPresenter this$0, final Context context, final SubMenuBuilder subMenuBuilder) {
        this.this$0 = this$0;
        super(context, subMenuBuilder);
        if (!((MenuItemImpl)subMenuBuilder.getItem()).isActionButton()) {
            View access$200;
            if (this$0.mOverflowButton == null) {
                access$200 = (View)this$0.mMenuView;
            }
            else {
                access$200 = this$0.mOverflowButton;
            }
            this.setAnchorView(access$200);
        }
        this.setCallback(this$0.mPopupPresenterCallback);
        while (true) {
            for (int size = subMenuBuilder.size(), i = 0; i < size; ++i) {
                final MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    final boolean forceShowIcon = true;
                    this.setForceShowIcon(forceShowIcon);
                    return;
                }
            }
            final boolean forceShowIcon = false;
            continue;
        }
    }
    
    @Override
    public void onDismiss() {
        super.onDismiss();
        this.this$0.mActionButtonPopup = null;
        this.this$0.mOpenSubMenuId = 0;
    }
}
