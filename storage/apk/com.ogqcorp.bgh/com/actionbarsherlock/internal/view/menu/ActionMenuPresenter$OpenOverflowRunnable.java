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
import android.util.SparseBooleanArray;
import com.actionbarsherlock.view.ActionProvider$SubUiVisibilityListener;
import android.view.View;

class ActionMenuPresenter$OpenOverflowRunnable implements Runnable
{
    private ActionMenuPresenter$OverflowPopup mPopup;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$OpenOverflowRunnable(final ActionMenuPresenter this$0, final ActionMenuPresenter$OverflowPopup mPopup) {
        this.this$0 = this$0;
        this.mPopup = mPopup;
    }
    
    @Override
    public void run() {
        this.this$0.mMenu.changeMenuMode();
        final View view = (View)this.this$0.mMenuView;
        if (view != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
            this.this$0.mOverflowPopup = this.mPopup;
        }
        this.this$0.mPostedOpenRunnable = null;
    }
}
