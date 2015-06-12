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
import android.util.SparseBooleanArray;
import com.actionbarsherlock.view.ActionProvider$SubUiVisibilityListener;
import android.view.View;
import android.content.Context;

class ActionMenuPresenter$OverflowPopup extends MenuPopupHelper
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$OverflowPopup(final ActionMenuPresenter this$0, final Context context, final MenuBuilder menuBuilder, final View view, final boolean b) {
        this.this$0 = this$0;
        super(context, menuBuilder, view, b);
        this.setCallback(this$0.mPopupPresenterCallback);
    }
    
    @Override
    public void onDismiss() {
        super.onDismiss();
        this.this$0.mMenu.close();
        this.this$0.mOverflowPopup = null;
    }
}
