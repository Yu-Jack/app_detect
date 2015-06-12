// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.widget.Adapter;
import android.content.DialogInterface;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.R$attr;
import android.graphics.Rect;
import android.content.DialogInterface$OnClickListener;
import android.graphics.drawable.Drawable;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ListAdapter;

class IcsSpinner$DropdownPopup extends IcsListPopupWindow implements IcsSpinner$SpinnerPopup
{
    private ListAdapter mAdapter;
    private CharSequence mHintText;
    final /* synthetic */ IcsSpinner this$0;
    
    public IcsSpinner$DropdownPopup(final IcsSpinner icsSpinner, final Context context, final AttributeSet set, final int n) {
        this.this$0 = icsSpinner;
        super(context, set, 0, n);
        this.setAnchorView((View)icsSpinner);
        this.setModal(true);
        this.setPromptPosition(0);
        this.setOnItemClickListener((AdapterView$OnItemClickListener)new AdapterView$OnItemClickListener() {
            public void onItemClick(final AdapterView adapterView, final View view, final int selection, final long n) {
                IcsSpinner$DropdownPopup.this.this$0.setSelection(selection);
                IcsSpinner$DropdownPopup.this.dismiss();
            }
        });
    }
    
    @Override
    public CharSequence getHintText() {
        return this.mHintText;
    }
    
    @Override
    public void setAdapter(final ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.mAdapter = listAdapter;
    }
    
    @Override
    public void setPromptText(final CharSequence mHintText) {
        this.mHintText = mHintText;
    }
    
    @Override
    public void show() {
        final int paddingLeft = this.this$0.getPaddingLeft();
        if (this.this$0.mDropDownWidth == -2) {
            this.setContentWidth(Math.max(this.this$0.measureContentWidth((SpinnerAdapter)this.mAdapter, this.this$0.getBackground()), this.this$0.getWidth() - paddingLeft - this.this$0.getPaddingRight()));
        }
        else if (this.this$0.mDropDownWidth == -1) {
            this.setContentWidth(this.this$0.getWidth() - paddingLeft - this.this$0.getPaddingRight());
        }
        else {
            this.setContentWidth(this.this$0.mDropDownWidth);
        }
        final Drawable background = this.this$0.getBackground();
        int n = 0;
        if (background != null) {
            background.getPadding(this.this$0.mTempRect);
            n = -this.this$0.mTempRect.left;
        }
        this.setHorizontalOffset(n + paddingLeft);
        this.setInputMethodMode(2);
        super.show();
        this.getListView().setChoiceMode(1);
        this.setSelection(this.this$0.getSelectedItemPosition());
    }
}
