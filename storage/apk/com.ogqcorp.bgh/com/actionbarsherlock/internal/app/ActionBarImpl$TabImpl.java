// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.app;

import com.actionbarsherlock.app.ActionBar$OnNavigationListener;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.app.ActionBar$LayoutParams;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet$Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import android.view.ContextThemeWrapper;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.R$bool;
import com.actionbarsherlock.R$id;
import android.app.Dialog;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener;
import java.util.ArrayList;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;
import android.os.Handler;
import com.actionbarsherlock.view.ActionMode$Callback;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import android.content.Context;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import android.app.Activity;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.app.ActionBar;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.actionbarsherlock.app.ActionBar$TabListener;
import com.actionbarsherlock.app.ActionBar$Tab;

public class ActionBarImpl$TabImpl extends ActionBar$Tab
{
    private ActionBar$TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition;
    private Object mTag;
    private CharSequence mText;
    final /* synthetic */ ActionBarImpl this$0;
    
    public ActionBarImpl$TabImpl(final ActionBarImpl this$0) {
        this.this$0 = this$0;
        this.mPosition = -1;
    }
    
    public ActionBar$TabListener getCallback() {
        return this.mCallback;
    }
    
    @Override
    public CharSequence getContentDescription() {
        return this.mContentDesc;
    }
    
    @Override
    public View getCustomView() {
        return this.mCustomView;
    }
    
    @Override
    public Drawable getIcon() {
        return this.mIcon;
    }
    
    @Override
    public int getPosition() {
        return this.mPosition;
    }
    
    @Override
    public Object getTag() {
        return this.mTag;
    }
    
    @Override
    public CharSequence getText() {
        return this.mText;
    }
    
    @Override
    public void select() {
        this.this$0.selectTab(this);
    }
    
    @Override
    public ActionBar$Tab setContentDescription(final int n) {
        return this.setContentDescription(this.this$0.mContext.getResources().getText(n));
    }
    
    @Override
    public ActionBar$Tab setContentDescription(final CharSequence mContentDesc) {
        this.mContentDesc = mContentDesc;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
    
    @Override
    public ActionBar$Tab setCustomView(final int n) {
        return this.setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(n, (ViewGroup)null));
    }
    
    @Override
    public ActionBar$Tab setCustomView(final View mCustomView) {
        this.mCustomView = mCustomView;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
    
    @Override
    public ActionBar$Tab setIcon(final int n) {
        return this.setIcon(this.this$0.mContext.getResources().getDrawable(n));
    }
    
    @Override
    public ActionBar$Tab setIcon(final Drawable mIcon) {
        this.mIcon = mIcon;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
    
    public void setPosition(final int mPosition) {
        this.mPosition = mPosition;
    }
    
    @Override
    public ActionBar$Tab setTabListener(final ActionBar$TabListener mCallback) {
        this.mCallback = mCallback;
        return this;
    }
    
    @Override
    public ActionBar$Tab setTag(final Object mTag) {
        this.mTag = mTag;
        return this;
    }
    
    @Override
    public ActionBar$Tab setText(final int n) {
        return this.setText(this.this$0.mContext.getResources().getText(n));
    }
    
    @Override
    public ActionBar$Tab setText(final CharSequence mText) {
        this.mText = mText;
        if (this.mPosition >= 0) {
            this.this$0.mTabScrollView.updateTab(this.mPosition);
        }
        return this;
    }
}
