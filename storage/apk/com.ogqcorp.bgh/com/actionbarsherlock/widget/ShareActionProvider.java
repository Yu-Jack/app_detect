// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

import android.content.Intent;
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

public class ShareActionProvider extends ActionProvider
{
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    private final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel$OnChooseActivityListener mOnChooseActivityListener;
    private final ShareActionProvider$ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    private ShareActionProvider$OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    private String mShareHistoryFileName;
    
    public ShareActionProvider(final Context mContext) {
        super(mContext);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareActionProvider$ShareMenuItemOnMenuItemClickListener(this, null);
        this.mShareHistoryFileName = "share_history.xml";
        this.mContext = mContext;
    }
    
    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener == null) {
            return;
        }
        if (this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new ShareActionProvider$ShareAcitivityChooserModelPolicy(this, null);
        }
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }
    
    @Override
    public boolean hasSubMenu() {
        return true;
    }
    
    @Override
    public View onCreateActionView() {
        final ActivityChooserModel value = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        final ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
        activityChooserView.setActivityChooserModel(value);
        final TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R$attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(this.mContext.getResources().getDrawable(typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R$string.abs__shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R$string.abs__shareactionprovider_share_with);
        return (View)activityChooserView;
    }
    
    @Override
    public void onPrepareSubMenu(final SubMenu subMenu) {
        subMenu.clear();
        final ActivityChooserModel value = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        final PackageManager packageManager = this.mContext.getPackageManager();
        final int activityCount = value.getActivityCount();
        final int min = Math.min(activityCount, this.mMaxShownActivityCount);
        for (int i = 0; i < min; ++i) {
            final ResolveInfo activity = value.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (min < activityCount) {
            final SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.mContext.getString(R$string.abs__activity_chooser_view_see_all));
            for (int j = 0; j < activityCount; ++j) {
                final ResolveInfo activity2 = value.getActivity(j);
                addSubMenu.add(0, j, j, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }
    
    public void setOnShareTargetSelectedListener(final ShareActionProvider$OnShareTargetSelectedListener mOnShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = mOnShareTargetSelectedListener;
        this.setActivityChooserPolicyIfNeeded();
    }
    
    public void setShareHistoryFileName(final String mShareHistoryFileName) {
        this.mShareHistoryFileName = mShareHistoryFileName;
        this.setActivityChooserPolicyIfNeeded();
    }
    
    public void setShareIntent(final Intent intent) {
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(intent);
    }
}
