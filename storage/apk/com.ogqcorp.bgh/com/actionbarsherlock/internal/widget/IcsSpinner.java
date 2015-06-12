// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.widget.AdapterView$OnItemClickListener;
import android.widget.Adapter;
import android.content.DialogInterface;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.content.res.TypedArray;
import android.widget.ListAdapter;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Rect;
import android.content.DialogInterface$OnClickListener;

public class IcsSpinner extends IcsAbsSpinner implements DialogInterface$OnClickListener
{
    private static final int MAX_ITEMS_MEASURED = 15;
    public static final int MODE_DROPDOWN = 1;
    private boolean mDisableChildrenWhenDisabled;
    int mDropDownWidth;
    private int mGravity;
    private IcsSpinner$SpinnerPopup mPopup;
    private IcsSpinner$DropDownAdapter mTempAdapter;
    private Rect mTempRect;
    
    public IcsSpinner(final Context context) {
        this(context, null);
    }
    
    public IcsSpinner(final Context context, final AttributeSet set) {
        this(context, set, R$attr.actionDropDownStyle);
    }
    
    public IcsSpinner(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mTempRect = new Rect();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.SherlockSpinner, n, 0);
        final IcsSpinner$DropdownPopup mPopup = new IcsSpinner$DropdownPopup(this, context, set, n);
        this.mDropDownWidth = obtainStyledAttributes.getLayoutDimension(4, -2);
        mPopup.setBackgroundDrawable(obtainStyledAttributes.getDrawable(2));
        final int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
        if (dimensionPixelOffset != 0) {
            mPopup.setVerticalOffset(dimensionPixelOffset);
        }
        final int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
        if (dimensionPixelOffset2 != 0) {
            mPopup.setHorizontalOffset(dimensionPixelOffset2);
        }
        this.mPopup = mPopup;
        this.mGravity = obtainStyledAttributes.getInt(0, 17);
        this.mPopup.setPromptText(obtainStyledAttributes.getString(3));
        this.mDisableChildrenWhenDisabled = true;
        obtainStyledAttributes.recycle();
        if (this.mTempAdapter != null) {
            this.mPopup.setAdapter((ListAdapter)this.mTempAdapter);
            this.mTempAdapter = null;
        }
    }
    
    private View makeAndAddView(final int n) {
        if (!this.mDataChanged) {
            final View value = this.mRecycler.get(n);
            if (value != null) {
                this.setUpChild(value);
                return value;
            }
        }
        final View view = this.mAdapter.getView(n, (View)null, (ViewGroup)this);
        this.setUpChild(view);
        return view;
    }
    
    private void setUpChild(final View view) {
        ViewGroup$LayoutParams viewGroup$LayoutParams = view.getLayoutParams();
        if (viewGroup$LayoutParams == null) {
            viewGroup$LayoutParams = this.generateDefaultLayoutParams();
        }
        this.addViewInLayout(view, 0, viewGroup$LayoutParams);
        view.setSelected(this.hasFocus());
        if (this.mDisableChildrenWhenDisabled) {
            view.setEnabled(this.isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, viewGroup$LayoutParams.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, viewGroup$LayoutParams.height));
        final int n = this.mSpinnerPadding.top + (this.getMeasuredHeight() - this.mSpinnerPadding.bottom - this.mSpinnerPadding.top - view.getMeasuredHeight()) / 2;
        view.layout(0, n, 0 + view.getMeasuredWidth(), n + view.getMeasuredHeight());
    }
    
    public int getBaseline() {
        int n = -1;
        View view;
        if (this.getChildCount() > 0) {
            view = this.getChildAt(0);
        }
        else {
            final SpinnerAdapter mAdapter = this.mAdapter;
            view = null;
            if (mAdapter != null) {
                final int count = this.mAdapter.getCount();
                view = null;
                if (count > 0) {
                    view = this.makeAndAddView(0);
                    this.mRecycler.put(0, view);
                    this.removeAllViewsInLayout();
                }
            }
        }
        if (view != null) {
            final int baseline = view.getBaseline();
            if (baseline >= 0) {
                n = baseline + view.getTop();
            }
        }
        return n;
    }
    
    public CharSequence getPrompt() {
        return this.mPopup.getHintText();
    }
    
    @Override
    void layout(final int n, final boolean b) {
        int left = this.mSpinnerPadding.left;
        final int n2 = this.getRight() - this.getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right;
        if (this.mDataChanged) {
            this.handleDataChanged();
        }
        if (this.mItemCount == 0) {
            this.resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            this.setSelectedPositionInt(this.mNextSelectedPosition);
        }
        this.recycleAllViews();
        this.removeAllViewsInLayout();
        this.mFirstPosition = this.mSelectedPosition;
        final View andAddView = this.makeAndAddView(this.mSelectedPosition);
        final int measuredWidth = andAddView.getMeasuredWidth();
        switch (0x7 & this.mGravity) {
            case 1: {
                left = left + n2 / 2 - measuredWidth / 2;
                break;
            }
            case 5: {
                left = left + n2 - measuredWidth;
                break;
            }
        }
        andAddView.offsetLeftAndRight(left);
        this.mRecycler.clear();
        this.invalidate();
        this.checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        this.setNextSelectedPositionInt(this.mSelectedPosition);
    }
    
    int measureContentWidth(final SpinnerAdapter spinnerAdapter, final Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int max = Math.max(0, this.getSelectedItemPosition());
        final int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int max2 = 0;
        int n = 0;
        while (i < min) {
            int itemViewType = spinnerAdapter.getItemViewType(i);
            View view2;
            if (itemViewType != n) {
                view2 = null;
            }
            else {
                itemViewType = n;
                view2 = view;
            }
            view = spinnerAdapter.getView(i, view2, (ViewGroup)this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup$LayoutParams(-2, -2));
            }
            view.measure(measureSpec, measureSpec2);
            max2 = Math.max(max2, view.getMeasuredWidth());
            ++i;
            n = itemViewType;
        }
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            return max2 + (this.mTempRect.left + this.mTempRect.right);
        }
        return max2;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int selection) {
        this.setSelection(selection);
        dialogInterface.dismiss();
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPopup != null && this.mPopup.isShowing()) {
            this.mPopup.dismiss();
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.mInLayout = true;
        this.layout(0, false);
        this.mInLayout = false;
    }
    
    @Override
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.mPopup != null && View$MeasureSpec.getMode(n) == Integer.MIN_VALUE) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.measureContentWidth(this.getAdapter(), this.getBackground())), View$MeasureSpec.getSize(n)), this.getMeasuredHeight());
        }
    }
    
    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.mPopup.isShowing()) {
                this.mPopup.show();
            }
        }
        return performClick;
    }
    
    @Override
    public void setAdapter(final SpinnerAdapter adapter) {
        super.setAdapter(adapter);
        if (this.mPopup != null) {
            this.mPopup.setAdapter((ListAdapter)new IcsSpinner$DropDownAdapter(adapter));
            return;
        }
        this.mTempAdapter = new IcsSpinner$DropDownAdapter(adapter);
    }
    
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        if (this.mDisableChildrenWhenDisabled) {
            for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                this.getChildAt(i).setEnabled(b);
            }
        }
    }
    
    public void setGravity(int mGravity) {
        if (this.mGravity != mGravity) {
            if ((mGravity & 0x7) == 0x0) {
                mGravity |= 0x3;
            }
            this.mGravity = mGravity;
            this.requestLayout();
        }
    }
    
    public void setOnItemClickListener(final AdapterView$OnItemClickListener adapterView$OnItemClickListener) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }
    
    public void setPrompt(final CharSequence promptText) {
        this.mPopup.setPromptText(promptText);
    }
    
    public void setPromptId(final int n) {
        this.setPrompt(this.getContext().getText(n));
    }
}
