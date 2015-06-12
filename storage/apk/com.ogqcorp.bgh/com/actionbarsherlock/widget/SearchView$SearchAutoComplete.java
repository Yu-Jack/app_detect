// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

import android.view.View$MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListAdapter;
import android.os.ResultReceiver;
import android.content.ActivityNotFoundException;
import android.content.pm.ResolveInfo;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Method;
import android.content.ComponentName;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.util.Log;
import android.net.Uri;
import android.content.res.Resources;
import com.actionbarsherlock.R$dimen;
import android.content.res.TypedArray;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnLayoutChangeListener;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.R$id;
import android.view.ViewGroup;
import com.actionbarsherlock.R$layout;
import android.view.LayoutInflater;
import android.os.Build$VERSION;
import android.text.Editable;
import android.widget.AdapterView;
import android.widget.TextView;
import android.support.v4.view.t;
import android.database.Cursor;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.View$OnKeyListener;
import android.support.v4.widget.a;
import android.app.SearchableInfo;
import android.graphics.drawable.Drawable$ConstantState;
import java.util.WeakHashMap;
import android.view.View$OnFocusChangeListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.TextView$OnEditorActionListener;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import android.os.Bundle;
import com.actionbarsherlock.view.CollapsibleActionView;
import android.widget.LinearLayout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.AutoCompleteTextView;

public class SearchView$SearchAutoComplete extends AutoCompleteTextView
{
    private SearchView mSearchView;
    private int mThreshold;
    
    public SearchView$SearchAutoComplete(final Context context) {
        super(context);
        this.mThreshold = this.getThreshold();
    }
    
    public SearchView$SearchAutoComplete(final Context context, final AttributeSet set) {
        super(context, set);
        this.mThreshold = this.getThreshold();
    }
    
    public SearchView$SearchAutoComplete(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mThreshold = this.getThreshold();
    }
    
    private boolean isEmpty() {
        return TextUtils.getTrimmedLength((CharSequence)this.getText()) == 0;
    }
    
    public boolean enoughToFilter() {
        return this.mThreshold <= 0 || super.enoughToFilter();
    }
    
    protected void onFocusChanged(final boolean b, final int n, final Rect rect) {
        super.onFocusChanged(b, n, rect);
        this.mSearchView.onTextFocusChanged();
    }
    
    public boolean onKeyPreIme(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                final KeyEvent$DispatcherState keyDispatcherState = this.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, (Object)this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                final KeyEvent$DispatcherState keyDispatcherState2 = this.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.mSearchView.clearFocus();
                    this.mSearchView.setImeVisibility(false);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(n, keyEvent);
    }
    
    public void onWindowFocusChanged(final boolean b) {
        super.onWindowFocusChanged(b);
        if (b && this.mSearchView.hasFocus() && this.getVisibility() == 0) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).showSoftInput((View)this, 0);
            if (SearchView.isLandscapeMode(this.getContext())) {
                ensureImeVisible(this, true);
            }
        }
    }
    
    public void performCompletion() {
    }
    
    protected void replaceText(final CharSequence charSequence) {
    }
    
    void setSearchView(final SearchView mSearchView) {
        this.mSearchView = mSearchView;
    }
    
    public void setThreshold(final int n) {
        super.setThreshold(n);
        this.mThreshold = n;
    }
}
