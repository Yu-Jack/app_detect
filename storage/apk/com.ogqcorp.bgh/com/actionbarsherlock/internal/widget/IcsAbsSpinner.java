// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.os.Parcelable;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.widget.Adapter;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.database.DataSetObserver;
import android.widget.SpinnerAdapter;

public abstract class IcsAbsSpinner extends IcsAdapterView<SpinnerAdapter>
{
    private static final boolean IS_HONEYCOMB;
    SpinnerAdapter mAdapter;
    boolean mBlockLayoutRequests;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final IcsAbsSpinner$RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;
    
    static {
        IS_HONEYCOMB = (Build$VERSION.SDK_INT >= 11);
    }
    
    public IcsAbsSpinner(final Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new IcsAbsSpinner$RecycleBin(this);
        this.initAbsSpinner();
    }
    
    public IcsAbsSpinner(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public IcsAbsSpinner(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new IcsAbsSpinner$RecycleBin(this);
        this.initAbsSpinner();
    }
    
    private void initAbsSpinner() {
        this.setFocusable(true);
        this.setWillNotDraw(false);
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup$LayoutParams(-1, -2);
    }
    
    @Override
    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }
    
    int getChildHeight(final View view) {
        return view.getMeasuredHeight();
    }
    
    int getChildWidth(final View view) {
        return view.getMeasuredWidth();
    }
    
    @Override
    public int getCount() {
        return this.mItemCount;
    }
    
    @Override
    public View getSelectedView() {
        if (this.mItemCount > 0 && this.mSelectedPosition >= 0) {
            return this.getChildAt(this.mSelectedPosition - this.mFirstPosition);
        }
        return null;
    }
    
    abstract void layout(final int p0, final boolean p1);
    
    protected void onMeasure(final int mWidthMeasureSpec, final int mHeightMeasureSpec) {
        final int mode = View$MeasureSpec.getMode(mWidthMeasureSpec);
        int left = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int paddingRight = this.getPaddingRight();
        final int paddingBottom = this.getPaddingBottom();
        final Rect mSpinnerPadding = this.mSpinnerPadding;
        if (left <= this.mSelectionLeftPadding) {
            left = this.mSelectionLeftPadding;
        }
        mSpinnerPadding.left = left;
        final Rect mSpinnerPadding2 = this.mSpinnerPadding;
        int mSelectionTopPadding;
        if (paddingTop > this.mSelectionTopPadding) {
            mSelectionTopPadding = paddingTop;
        }
        else {
            mSelectionTopPadding = this.mSelectionTopPadding;
        }
        mSpinnerPadding2.top = mSelectionTopPadding;
        final Rect mSpinnerPadding3 = this.mSpinnerPadding;
        int mSelectionRightPadding;
        if (paddingRight > this.mSelectionRightPadding) {
            mSelectionRightPadding = paddingRight;
        }
        else {
            mSelectionRightPadding = this.mSelectionRightPadding;
        }
        mSpinnerPadding3.right = mSelectionRightPadding;
        final Rect mSpinnerPadding4 = this.mSpinnerPadding;
        int mSelectionBottomPadding;
        if (paddingBottom > this.mSelectionBottomPadding) {
            mSelectionBottomPadding = paddingBottom;
        }
        else {
            mSelectionBottomPadding = this.mSelectionBottomPadding;
        }
        mSpinnerPadding4.bottom = mSelectionBottomPadding;
        if (this.mDataChanged) {
            this.handleDataChanged();
        }
        final int selectedItemPosition = this.getSelectedItemPosition();
        while (true) {
            Label_0473: {
                if (selectedItemPosition < 0 || this.mAdapter == null || selectedItemPosition >= this.mAdapter.getCount()) {
                    break Label_0473;
                }
                View view = this.mRecycler.get(selectedItemPosition);
                if (view == null) {
                    view = this.mAdapter.getView(selectedItemPosition, (View)null, (ViewGroup)this);
                }
                if (view != null) {
                    this.mRecycler.put(selectedItemPosition, view);
                }
                if (view == null) {
                    break Label_0473;
                }
                if (view.getLayoutParams() == null) {
                    this.mBlockLayoutRequests = true;
                    view.setLayoutParams(this.generateDefaultLayoutParams());
                    this.mBlockLayoutRequests = false;
                }
                this.measureChild(view, mWidthMeasureSpec, mHeightMeasureSpec);
                int a = this.getChildHeight(view) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
                int a2 = this.getChildWidth(view) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
                final int n = 0;
                if (n != 0) {
                    a = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
                    if (mode == 0) {
                        a2 = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
                    }
                }
                final int max = Math.max(a, this.getSuggestedMinimumHeight());
                final int max2 = Math.max(a2, this.getSuggestedMinimumWidth());
                int n2;
                int n3;
                if (IcsAbsSpinner.IS_HONEYCOMB) {
                    n2 = resolveSizeAndState(max, mHeightMeasureSpec, 0);
                    n3 = resolveSizeAndState(max2, mWidthMeasureSpec, 0);
                }
                else {
                    n2 = resolveSize(max, mHeightMeasureSpec);
                    n3 = resolveSize(max2, mWidthMeasureSpec);
                }
                this.setMeasuredDimension(n3, n2);
                this.mHeightMeasureSpec = mHeightMeasureSpec;
                this.mWidthMeasureSpec = mWidthMeasureSpec;
                return;
            }
            final int n = 1;
            int a2 = 0;
            int a = 0;
            continue;
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final IcsAbsSpinner$SavedState icsAbsSpinner$SavedState = (IcsAbsSpinner$SavedState)parcelable;
        super.onRestoreInstanceState(icsAbsSpinner$SavedState.getSuperState());
        if (icsAbsSpinner$SavedState.selectedId >= 0L) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = icsAbsSpinner$SavedState.selectedId;
            this.mSyncPosition = icsAbsSpinner$SavedState.position;
            this.mSyncMode = 0;
            this.requestLayout();
        }
    }
    
    public Parcelable onSaveInstanceState() {
        final IcsAbsSpinner$SavedState icsAbsSpinner$SavedState = new IcsAbsSpinner$SavedState(super.onSaveInstanceState());
        icsAbsSpinner$SavedState.selectedId = this.getSelectedItemId();
        if (icsAbsSpinner$SavedState.selectedId >= 0L) {
            icsAbsSpinner$SavedState.position = this.getSelectedItemPosition();
            return (Parcelable)icsAbsSpinner$SavedState;
        }
        icsAbsSpinner$SavedState.position = -1;
        return (Parcelable)icsAbsSpinner$SavedState;
    }
    
    public int pointToPosition(final int n, final int n2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
        }
        for (int i = -1 + this.getChildCount(); i >= 0; --i) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 0) {
                child.getHitRect(rect);
                if (rect.contains(n, n2)) {
                    return i + this.mFirstPosition;
                }
            }
        }
        return -1;
    }
    
    void recycleAllViews() {
        final int childCount = this.getChildCount();
        final IcsAbsSpinner$RecycleBin mRecycler = this.mRecycler;
        final int mFirstPosition = this.mFirstPosition;
        for (int i = 0; i < childCount; ++i) {
            mRecycler.put(mFirstPosition + i, this.getChildAt(i));
        }
    }
    
    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }
    
    void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        this.removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        this.setSelectedPositionInt(-1);
        this.setNextSelectedPositionInt(-1);
        this.invalidate();
    }
    
    @Override
    public void setAdapter(final SpinnerAdapter mAdapter) {
        int nextSelectedPositionInt = -1;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            this.resetList();
        }
        this.mAdapter = mAdapter;
        this.mOldSelectedPosition = nextSelectedPositionInt;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            this.checkFocus();
            this.mDataSetObserver = new IcsAdapterView$AdapterDataSetObserver(this);
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            if (this.mItemCount > 0) {
                nextSelectedPositionInt = 0;
            }
            this.setSelectedPositionInt(nextSelectedPositionInt);
            this.setNextSelectedPositionInt(nextSelectedPositionInt);
            if (this.mItemCount == 0) {
                this.checkSelectionChanged();
            }
        }
        else {
            this.checkFocus();
            this.resetList();
            this.checkSelectionChanged();
        }
        this.requestLayout();
    }
    
    @Override
    public void setSelection(final int nextSelectedPositionInt) {
        this.setNextSelectedPositionInt(nextSelectedPositionInt);
        this.requestLayout();
        this.invalidate();
    }
    
    public void setSelection(final int n, final boolean b) {
        this.setSelectionInt(n, b && this.mFirstPosition <= n && n <= -1 + (this.mFirstPosition + this.getChildCount()));
    }
    
    void setSelectionInt(final int nextSelectedPositionInt, final boolean b) {
        if (nextSelectedPositionInt != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            final int n = nextSelectedPositionInt - this.mSelectedPosition;
            this.setNextSelectedPositionInt(nextSelectedPositionInt);
            this.layout(n, b);
            this.mBlockLayoutRequests = false;
        }
    }
}
