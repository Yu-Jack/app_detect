// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.app;

import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.app.ActionBar$LayoutParams;
import java.util.Iterator;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;
import android.app.Activity;
import android.app.ActionBar$OnNavigationListener;
import android.app.ActionBar$OnMenuVisibilityListener;
import com.actionbarsherlock.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.app.ActionBar$TabListener;
import com.actionbarsherlock.app.ActionBar$Tab;

public class ActionBarWrapper$TabWrapper extends ActionBar$Tab implements ActionBar$TabListener
{
    private com.actionbarsherlock.app.ActionBar$TabListener mListener;
    final android.app.ActionBar$Tab mNativeTab;
    private Object mTag;
    final /* synthetic */ ActionBarWrapper this$0;
    
    public ActionBarWrapper$TabWrapper(final ActionBarWrapper this$0, final android.app.ActionBar$Tab mNativeTab) {
        this.this$0 = this$0;
        (this.mNativeTab = mNativeTab).setTag((Object)this);
    }
    
    @Override
    public CharSequence getContentDescription() {
        return this.mNativeTab.getContentDescription();
    }
    
    @Override
    public View getCustomView() {
        return this.mNativeTab.getCustomView();
    }
    
    @Override
    public Drawable getIcon() {
        return this.mNativeTab.getIcon();
    }
    
    @Override
    public int getPosition() {
        return this.mNativeTab.getPosition();
    }
    
    @Override
    public Object getTag() {
        return this.mTag;
    }
    
    @Override
    public CharSequence getText() {
        return this.mNativeTab.getText();
    }
    
    public void onTabReselected(final android.app.ActionBar$Tab actionBar$Tab, final FragmentTransaction fragmentTransaction) {
        if (this.mListener != null) {
            final boolean b = this.this$0.mActivity instanceof FragmentActivity;
            android.support.v4.app.FragmentTransaction disallowAddToBackStack = null;
            if (b) {
                disallowAddToBackStack = ((FragmentActivity)this.this$0.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            }
            this.mListener.onTabReselected(this, disallowAddToBackStack);
            if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
                disallowAddToBackStack.commit();
            }
        }
    }
    
    public void onTabSelected(final android.app.ActionBar$Tab actionBar$Tab, final FragmentTransaction fragmentTransaction) {
        if (this.mListener != null) {
            if (this.this$0.mFragmentTransaction == null && this.this$0.mActivity instanceof FragmentActivity) {
                this.this$0.mFragmentTransaction = ((FragmentActivity)this.this$0.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            }
            this.mListener.onTabSelected(this, this.this$0.mFragmentTransaction);
            if (this.this$0.mFragmentTransaction != null) {
                if (!this.this$0.mFragmentTransaction.isEmpty()) {
                    this.this$0.mFragmentTransaction.commit();
                }
                this.this$0.mFragmentTransaction = null;
            }
        }
    }
    
    public void onTabUnselected(final android.app.ActionBar$Tab actionBar$Tab, final FragmentTransaction fragmentTransaction) {
        if (this.mListener != null) {
            final boolean b = this.this$0.mActivity instanceof FragmentActivity;
            android.support.v4.app.FragmentTransaction disallowAddToBackStack = null;
            if (b) {
                disallowAddToBackStack = ((FragmentActivity)this.this$0.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
                this.this$0.mFragmentTransaction = disallowAddToBackStack;
            }
            this.mListener.onTabUnselected(this, disallowAddToBackStack);
        }
    }
    
    @Override
    public void select() {
        this.mNativeTab.select();
    }
    
    @Override
    public ActionBar$Tab setContentDescription(final int contentDescription) {
        this.mNativeTab.setContentDescription(contentDescription);
        return this;
    }
    
    @Override
    public ActionBar$Tab setContentDescription(final CharSequence contentDescription) {
        this.mNativeTab.setContentDescription(contentDescription);
        return this;
    }
    
    @Override
    public ActionBar$Tab setCustomView(final int customView) {
        this.mNativeTab.setCustomView(customView);
        return this;
    }
    
    @Override
    public ActionBar$Tab setCustomView(final View customView) {
        this.mNativeTab.setCustomView(customView);
        return this;
    }
    
    @Override
    public ActionBar$Tab setIcon(final int icon) {
        this.mNativeTab.setIcon(icon);
        return this;
    }
    
    @Override
    public ActionBar$Tab setIcon(final Drawable icon) {
        this.mNativeTab.setIcon(icon);
        return this;
    }
    
    @Override
    public ActionBar$Tab setTabListener(final com.actionbarsherlock.app.ActionBar$TabListener mListener) {
        final android.app.ActionBar$Tab mNativeTab = this.mNativeTab;
        Object tabListener;
        if (mListener != null) {
            tabListener = this;
        }
        else {
            tabListener = null;
        }
        mNativeTab.setTabListener((ActionBar$TabListener)tabListener);
        this.mListener = mListener;
        return this;
    }
    
    @Override
    public ActionBar$Tab setTag(final Object mTag) {
        this.mTag = mTag;
        return this;
    }
    
    @Override
    public ActionBar$Tab setText(final int text) {
        this.mNativeTab.setText(text);
        return this;
    }
    
    @Override
    public ActionBar$Tab setText(final CharSequence text) {
        this.mNativeTab.setText(text);
        return this;
    }
}
