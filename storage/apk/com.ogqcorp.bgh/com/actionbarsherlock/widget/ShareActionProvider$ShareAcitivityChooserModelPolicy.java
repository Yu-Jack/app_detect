// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import com.actionbarsherlock.view.MenuItem$OnMenuItemClickListener;
import com.actionbarsherlock.view.SubMenu;
import com.actionbarsherlock.R$string;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.view.View;
import android.content.Context;
import com.actionbarsherlock.view.ActionProvider;
import android.content.Intent;

class ShareActionProvider$ShareAcitivityChooserModelPolicy implements ActivityChooserModel$OnChooseActivityListener
{
    final /* synthetic */ ShareActionProvider this$0;
    
    private ShareActionProvider$ShareAcitivityChooserModelPolicy(final ShareActionProvider this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean onChooseActivity(final ActivityChooserModel activityChooserModel, final Intent intent) {
        return this.this$0.mOnShareTargetSelectedListener != null && this.this$0.mOnShareTargetSelectedListener.onShareTargetSelected(this.this$0, intent);
    }
}
