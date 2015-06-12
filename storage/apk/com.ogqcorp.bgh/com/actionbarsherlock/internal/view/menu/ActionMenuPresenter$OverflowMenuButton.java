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
import java.util.Iterator;
import android.view.View;
import java.util.HashSet;
import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import android.content.Context;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import java.util.Set;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import android.widget.ImageButton;

class ActionMenuPresenter$OverflowMenuButton extends ImageButton implements View_HasStateListenerSupport, ActionMenuView$ActionMenuChildView
{
    private final Set<View_OnAttachStateChangeListener> mListeners;
    final /* synthetic */ ActionMenuPresenter this$0;
    
    public ActionMenuPresenter$OverflowMenuButton(final ActionMenuPresenter this$0, final Context context) {
        this.this$0 = this$0;
        super(context, (AttributeSet)null, R$attr.actionOverflowButtonStyle);
        this.mListeners = new HashSet<View_OnAttachStateChangeListener>();
        this.setClickable(true);
        this.setFocusable(true);
        this.setVisibility(0);
        this.setEnabled(true);
    }
    
    public void addOnAttachStateChangeListener(final View_OnAttachStateChangeListener view_OnAttachStateChangeListener) {
        this.mListeners.add(view_OnAttachStateChangeListener);
    }
    
    public boolean needsDividerAfter() {
        return false;
    }
    
    public boolean needsDividerBefore() {
        return false;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Iterator<View_OnAttachStateChangeListener> iterator = this.mListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onViewAttachedToWindow((View)this);
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final Iterator<View_OnAttachStateChangeListener> iterator = this.mListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onViewDetachedFromWindow((View)this);
        }
        if (this.this$0.mOverflowPopup != null) {
            this.this$0.mOverflowPopup.dismiss();
        }
    }
    
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        this.playSoundEffect(0);
        this.this$0.showOverflowMenu();
        return true;
    }
    
    public void removeOnAttachStateChangeListener(final View_OnAttachStateChangeListener view_OnAttachStateChangeListener) {
        this.mListeners.remove(view_OnAttachStateChangeListener);
    }
}
