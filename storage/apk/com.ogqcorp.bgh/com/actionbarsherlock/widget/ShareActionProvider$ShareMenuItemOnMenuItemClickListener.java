// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import com.actionbarsherlock.view.SubMenu;
import com.actionbarsherlock.R$string;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.view.View;
import android.content.Context;
import com.actionbarsherlock.view.ActionProvider;
import android.content.Intent;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem$OnMenuItemClickListener;

class ShareActionProvider$ShareMenuItemOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener
{
    final /* synthetic */ ShareActionProvider this$0;
    
    private ShareActionProvider$ShareMenuItemOnMenuItemClickListener(final ShareActionProvider this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean onMenuItemClick(final MenuItem menuItem) {
        final Intent chooseActivity = ActivityChooserModel.get(this.this$0.mContext, this.this$0.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
        if (chooseActivity != null) {
            this.this$0.mContext.startActivity(chooseActivity);
        }
        return true;
    }
}
