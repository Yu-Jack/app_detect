// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

import android.view.ViewTreeObserver;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListAdapter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$dimen;
import android.view.View$OnLongClickListener;
import android.view.View$OnClickListener;
import com.actionbarsherlock.R$styleable;
import android.util.AttributeSet;
import android.os.Build$VERSION;
import com.actionbarsherlock.view.ActionProvider;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.widget.PopupWindow$OnDismissListener;
import android.database.DataSetObserver;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import android.widget.FrameLayout;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;
import android.view.View$MeasureSpec;
import android.content.pm.PackageManager;
import android.widget.ImageView;
import com.actionbarsherlock.R$string;
import com.actionbarsherlock.R$id;
import android.widget.TextView;
import com.actionbarsherlock.R$layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.content.pm.ResolveInfo;
import android.widget.BaseAdapter;

class ActivityChooserView$ActivityChooserViewAdapter extends BaseAdapter
{
    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
    private ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount;
    private boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    final /* synthetic */ ActivityChooserView this$0;
    
    private ActivityChooserView$ActivityChooserViewAdapter(final ActivityChooserView this$0) {
        this.this$0 = this$0;
        this.mMaxActivityCount = 4;
        this.mShowDefaultActivity = true;
    }
    
    public int getActivityCount() {
        return this.mDataModel.getActivityCount();
    }
    
    public int getCount() {
        int activityCount = this.mDataModel.getActivityCount();
        if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
            --activityCount;
        }
        int min = Math.min(activityCount, this.mMaxActivityCount);
        if (this.mShowFooterView) {
            ++min;
        }
        return min;
    }
    
    public ActivityChooserModel getDataModel() {
        return this.mDataModel;
    }
    
    public ResolveInfo getDefaultActivity() {
        return this.mDataModel.getDefaultActivity();
    }
    
    public int getHistorySize() {
        return this.mDataModel.getHistorySize();
    }
    
    public Object getItem(int n) {
        switch (this.getItemViewType(n)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                return null;
            }
            case 0: {
                if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                    ++n;
                }
                return this.mDataModel.getActivity(n);
            }
        }
    }
    
    public long getItemId(final int n) {
        return n;
    }
    
    public int getItemViewType(final int n) {
        if (this.mShowFooterView && n == -1 + this.getCount()) {
            return 1;
        }
        return 0;
    }
    
    public int getMaxActivityCount() {
        return this.mMaxActivityCount;
    }
    
    public boolean getShowDefaultActivity() {
        return this.mShowDefaultActivity;
    }
    
    public View getView(final int n, View view, final ViewGroup viewGroup) {
        switch (this.getItemViewType(n)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 1: {
                if (view == null || view.getId() != 1) {
                    view = LayoutInflater.from(this.this$0.getContext()).inflate(R$layout.abs__activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView)view.findViewById(R$id.abs__title)).setText((CharSequence)this.this$0.mContext.getString(R$string.abs__activity_chooser_view_see_all));
                    break;
                }
                break;
            }
            case 0: {
                if (view == null || view.getId() != R$id.abs__list_item) {
                    view = LayoutInflater.from(this.this$0.getContext()).inflate(R$layout.abs__activity_chooser_view_list_item, viewGroup, false);
                }
                final PackageManager packageManager = this.this$0.mContext.getPackageManager();
                final ImageView imageView = (ImageView)view.findViewById(R$id.abs__icon);
                final ResolveInfo resolveInfo = (ResolveInfo)this.getItem(n);
                imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView)view.findViewById(R$id.abs__title)).setText(resolveInfo.loadLabel(packageManager));
                if (!ActivityChooserView.IS_HONEYCOMB) {
                    break;
                }
                if (this.mShowDefaultActivity && n == 0 && this.mHighlightDefaultActivity) {
                    ActivityChooserView$SetActivated.invoke(view, true);
                    return view;
                }
                ActivityChooserView$SetActivated.invoke(view, false);
                return view;
            }
        }
        return view;
    }
    
    public int getViewTypeCount() {
        return 3;
    }
    
    public int measureContentWidth() {
        int i = 0;
        final int mMaxActivityCount = this.mMaxActivityCount;
        this.mMaxActivityCount = Integer.MAX_VALUE;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int count = this.getCount();
        View view = null;
        int max = 0;
        while (i < count) {
            view = this.getView(i, view, null);
            view.measure(measureSpec, measureSpec2);
            max = Math.max(max, view.getMeasuredWidth());
            ++i;
        }
        this.mMaxActivityCount = mMaxActivityCount;
        return max;
    }
    
    public void setDataModel(final ActivityChooserModel mDataModel) {
        final ActivityChooserModel dataModel = this.this$0.mAdapter.getDataModel();
        while (true) {
            if (dataModel == null || !this.this$0.isShown()) {
                break Label_0036;
            }
            try {
                dataModel.unregisterObserver((Object)this.this$0.mModelDataSetOberver);
                Label_0066: {
                    if ((this.mDataModel = mDataModel) == null || !this.this$0.isShown()) {
                        break Label_0066;
                    }
                    try {
                        mDataModel.registerObserver((Object)this.this$0.mModelDataSetOberver);
                        this.notifyDataSetChanged();
                    }
                    catch (IllegalStateException ex) {}
                }
            }
            catch (IllegalStateException ex2) {
                continue;
            }
            break;
        }
    }
    
    public void setMaxActivityCount(final int mMaxActivityCount) {
        if (this.mMaxActivityCount != mMaxActivityCount) {
            this.mMaxActivityCount = mMaxActivityCount;
            this.notifyDataSetChanged();
        }
    }
    
    public void setShowDefaultActivity(final boolean mShowDefaultActivity, final boolean mHighlightDefaultActivity) {
        if (this.mShowDefaultActivity != mShowDefaultActivity || this.mHighlightDefaultActivity != mHighlightDefaultActivity) {
            this.mShowDefaultActivity = mShowDefaultActivity;
            this.mHighlightDefaultActivity = mHighlightDefaultActivity;
            this.notifyDataSetChanged();
        }
    }
    
    public void setShowFooterView(final boolean mShowFooterView) {
        if (this.mShowFooterView != mShowFooterView) {
            this.mShowFooterView = mShowFooterView;
            this.notifyDataSetChanged();
        }
    }
}
