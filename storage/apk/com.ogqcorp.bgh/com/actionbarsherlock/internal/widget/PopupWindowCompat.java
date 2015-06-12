// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import java.lang.reflect.AccessibleObject;
import android.view.ViewTreeObserver;
import java.lang.reflect.Field;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.widget.PopupWindow;

public class PopupWindowCompat extends PopupWindow
{
    private static final ViewTreeObserver$OnScrollChangedListener NOP;
    private static final Field superListenerField;
    private ViewTreeObserver$OnScrollChangedListener mSuperScrollListener;
    private ViewTreeObserver mViewTreeObserver;
    
    static {
        AccessibleObject declaredField = null;
        while (true) {
            try {
                declaredField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField.setAccessible(true);
                superListenerField = (Field)declaredField;
                NOP = (ViewTreeObserver$OnScrollChangedListener)new ViewTreeObserver$OnScrollChangedListener() {
                    public void onScrollChanged() {
                    }
                };
            }
            catch (NoSuchFieldException ex) {
                continue;
            }
            break;
        }
    }
    
    public PopupWindowCompat() {
        this.init();
    }
    
    public PopupWindowCompat(final int n, final int n2) {
        super(n, n2);
        this.init();
    }
    
    public PopupWindowCompat(final Context context) {
        super(context);
        this.init();
    }
    
    public PopupWindowCompat(final Context context, final AttributeSet set) {
        super(context, set);
        this.init();
    }
    
    public PopupWindowCompat(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.init();
    }
    
    public PopupWindowCompat(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.init();
    }
    
    public PopupWindowCompat(final View view) {
        super(view);
        this.init();
    }
    
    public PopupWindowCompat(final View view, final int n, final int n2) {
        super(view, n, n2);
        this.init();
    }
    
    public PopupWindowCompat(final View view, final int n, final int n2, final boolean b) {
        super(view, n, n2, b);
        this.init();
    }
    
    private void init() {
        if (PopupWindowCompat.superListenerField == null) {
            return;
        }
        try {
            this.mSuperScrollListener = (ViewTreeObserver$OnScrollChangedListener)PopupWindowCompat.superListenerField.get(this);
            PopupWindowCompat.superListenerField.set(this, PopupWindowCompat.NOP);
        }
        catch (Exception ex) {
            this.mSuperScrollListener = null;
        }
    }
    
    private void registerListener(final View view) {
        if (this.mSuperScrollListener != null) {
            ViewTreeObserver viewTreeObserver;
            if (view.getWindowToken() != null) {
                viewTreeObserver = view.getViewTreeObserver();
            }
            else {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != this.mViewTreeObserver) {
                if (this.mViewTreeObserver != null && this.mViewTreeObserver.isAlive()) {
                    this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
                }
                if ((this.mViewTreeObserver = viewTreeObserver) != null) {
                    viewTreeObserver.addOnScrollChangedListener(this.mSuperScrollListener);
                }
            }
        }
    }
    
    private void unregisterListener() {
        if (this.mSuperScrollListener != null && this.mViewTreeObserver != null) {
            if (this.mViewTreeObserver.isAlive()) {
                this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
            }
            this.mViewTreeObserver = null;
        }
    }
    
    public void dismiss() {
        super.dismiss();
        this.unregisterListener();
    }
    
    public void showAsDropDown(final View view, final int n, final int n2) {
        super.showAsDropDown(view, n, n2);
        this.registerListener(view);
    }
    
    public void showAtLocation(final View view, final int n, final int n2, final int n3) {
        super.showAtLocation(view, n, n2, n3);
        this.unregisterListener();
    }
    
    public void update(final View view, final int n, final int n2) {
        super.update(view, n, n2);
        this.registerListener(view);
    }
    
    public void update(final View view, final int n, final int n2, final int n3, final int n4) {
        super.update(view, n, n2, n3, n4);
        this.registerListener(view);
    }
}
