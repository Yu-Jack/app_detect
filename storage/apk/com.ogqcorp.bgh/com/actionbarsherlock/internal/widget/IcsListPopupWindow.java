// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View$OnTouchListener;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.ListView;
import android.view.ViewParent;
import android.widget.AbsListView$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.AbsListView$OnScrollListener;
import android.widget.AdapterView;
import android.view.ContextThemeWrapper;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import android.graphics.Rect;
import android.database.DataSetObserver;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.os.Handler;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.Context;
import android.widget.ListAdapter;

public class IcsListPopupWindow
{
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private ListAdapter mAdapter;
    private Context mContext;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private IcsListPopupWindow$DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private Handler mHandler;
    private final IcsListPopupWindow$ListSelectorHider mHideSelector;
    private AdapterView$OnItemClickListener mItemClickListener;
    private AdapterView$OnItemSelectedListener mItemSelectedListener;
    private int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private final PopupWindowCompat mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final IcsListPopupWindow$ResizePopupRunnable mResizePopupRunnable;
    private final IcsListPopupWindow$PopupScrollListener mScrollListener;
    private Rect mTempRect;
    private final IcsListPopupWindow$PopupTouchInterceptor mTouchInterceptor;
    
    public IcsListPopupWindow(final Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }
    
    public IcsListPopupWindow(final Context mContext, final AttributeSet set, final int n) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new IcsListPopupWindow$ResizePopupRunnable(this, null);
        this.mTouchInterceptor = new IcsListPopupWindow$PopupTouchInterceptor(this, null);
        this.mScrollListener = new IcsListPopupWindow$PopupScrollListener(this, null);
        this.mHideSelector = new IcsListPopupWindow$ListSelectorHider(this, null);
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = mContext;
        (this.mPopup = new PopupWindowCompat(mContext, set, n)).setInputMethodMode(1);
    }
    
    public IcsListPopupWindow(final Context mContext, final AttributeSet set, final int n, final int n2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new IcsListPopupWindow$ResizePopupRunnable(this, null);
        this.mTouchInterceptor = new IcsListPopupWindow$PopupTouchInterceptor(this, null);
        this.mScrollListener = new IcsListPopupWindow$PopupScrollListener(this, null);
        this.mHideSelector = new IcsListPopupWindow$ListSelectorHider(this, null);
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = mContext;
        if (Build$VERSION.SDK_INT < 11) {
            this.mPopup = new PopupWindowCompat((Context)new ContextThemeWrapper(mContext, n2), set, n);
        }
        else {
            this.mPopup = new PopupWindowCompat(mContext, set, n, n2);
        }
        this.mPopup.setInputMethodMode(1);
    }
    
    private int buildDropDown() {
        int orientation = 1;
        int n2;
        if (this.mDropDownList == null) {
            final Context mContext = this.mContext;
            this.mDropDownList = new IcsListPopupWindow$DropDownListView(mContext, !this.mModal && orientation);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable((boolean)(orientation != 0));
            this.mDropDownList.setFocusableInTouchMode((boolean)(orientation != 0));
            this.mDropDownList.setOnItemSelectedListener((AdapterView$OnItemSelectedListener)new AdapterView$OnItemSelectedListener() {
                public void onItemSelected(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
                    if (n != -1) {
                        final IcsListPopupWindow$DropDownListView access$600 = IcsListPopupWindow.this.mDropDownList;
                        if (access$600 != null) {
                            access$600.mListSelectionHidden = false;
                        }
                    }
                }
                
                public void onNothingSelected(final AdapterView<?> adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener((AbsListView$OnScrollListener)this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            final IcsListPopupWindow$DropDownListView mDropDownList = this.mDropDownList;
            final View mPromptView = this.mPromptView;
            Object contentView;
            int n;
            if (mPromptView != null) {
                contentView = new LinearLayout(mContext);
                ((LinearLayout)contentView).setOrientation(orientation);
                final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-1, 0, 1.0f);
                switch (this.mPromptPosition) {
                    case 1: {
                        ((LinearLayout)contentView).addView((View)mDropDownList, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        ((LinearLayout)contentView).addView(mPromptView);
                        break;
                    }
                    case 0: {
                        ((LinearLayout)contentView).addView(mPromptView);
                        ((LinearLayout)contentView).addView((View)mDropDownList, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                        break;
                    }
                }
                mPromptView.measure(View$MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE), 0);
                final LinearLayout$LayoutParams linearLayout$LayoutParams2 = (LinearLayout$LayoutParams)mPromptView.getLayoutParams();
                n = mPromptView.getMeasuredHeight() + linearLayout$LayoutParams2.topMargin + linearLayout$LayoutParams2.bottomMargin;
            }
            else {
                contentView = mDropDownList;
                n = 0;
            }
            this.mPopup.setContentView((View)contentView);
            n2 = n;
        }
        else {
            final ViewGroup viewGroup = (ViewGroup)this.mPopup.getContentView();
            final View mPromptView2 = this.mPromptView;
            if (mPromptView2 != null) {
                final LinearLayout$LayoutParams linearLayout$LayoutParams3 = (LinearLayout$LayoutParams)mPromptView2.getLayoutParams();
                n2 = mPromptView2.getMeasuredHeight() + linearLayout$LayoutParams3.topMargin + linearLayout$LayoutParams3.bottomMargin;
            }
            else {
                n2 = 0;
            }
        }
        final Drawable background = this.mPopup.getBackground();
        int n4;
        if (background != null) {
            background.getPadding(this.mTempRect);
            final int n3 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
            }
            n4 = n3;
        }
        else {
            n4 = 0;
        }
        if (this.mPopup.getInputMethodMode() != 2) {
            orientation = 0;
        }
        final int maxAvailableHeight = this.getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, orientation != 0);
        if (this.mDropDownHeight == -1) {
            return maxAvailableHeight + n4;
        }
        final int measureHeightOfChildren = this.measureHeightOfChildren(0, 0, -1, maxAvailableHeight - n2, -1);
        if (measureHeightOfChildren > 0) {
            n2 += n4;
        }
        return measureHeightOfChildren + n2;
    }
    
    private int getMaxAvailableHeight(final View view, final int n, final boolean b) {
        final Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        final int[] array = new int[2];
        view.getLocationOnScreen(array);
        int n2 = rect.bottom;
        if (b) {
            n2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int max = Math.max(n2 - (array[1] + view.getHeight()) - n, n + (array[1] - rect.top));
        if (this.mPopup.getBackground() != null) {
            this.mPopup.getBackground().getPadding(this.mTempRect);
            max -= this.mTempRect.top + this.mTempRect.bottom;
        }
        return max;
    }
    
    private boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }
    
    private int measureHeightOfChildren(final int n, int i, int n2, int n3, final int n4) {
        final ListAdapter mAdapter = this.mAdapter;
        if (mAdapter != null) {
            int n5 = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
            int dividerHeight;
            if (this.mDropDownList.getDividerHeight() > 0 && this.mDropDownList.getDivider() != null) {
                dividerHeight = this.mDropDownList.getDividerHeight();
            }
            else {
                dividerHeight = 0;
            }
            int n6 = 0;
            if (n2 == -1) {
                n2 = -1 + mAdapter.getCount();
            }
            while (i <= n2) {
                final View view = this.mAdapter.getView(i, (View)null, (ViewGroup)this.mDropDownList);
                if (this.mDropDownList.getCacheColorHint() != 0) {
                    view.setDrawingCacheBackgroundColor(this.mDropDownList.getCacheColorHint());
                }
                this.measureScrapChild(view, i, n);
                if (i > 0) {
                    n5 += dividerHeight;
                }
                n5 += view.getMeasuredHeight();
                if (n5 >= n3) {
                    if (n4 >= 0 && i > n4 && n6 > 0 && n5 != n3) {
                        return n6;
                    }
                    return n3;
                }
                else {
                    if (n4 >= 0 && i >= n4) {
                        n6 = n5;
                    }
                    ++i;
                }
            }
            return n5;
        }
        n3 = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
        return n3;
    }
    
    private void measureScrapChild(final View view, final int n, final int n2) {
        AbsListView$LayoutParams layoutParams = (AbsListView$LayoutParams)view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView$LayoutParams(-1, -2, 0);
            view.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        }
        final int childMeasureSpec = ViewGroup.getChildMeasureSpec(n2, this.mDropDownList.getPaddingLeft() + this.mDropDownList.getPaddingRight(), layoutParams.width);
        final int height = layoutParams.height;
        int n3;
        if (height > 0) {
            n3 = View$MeasureSpec.makeMeasureSpec(height, 1073741824);
        }
        else {
            n3 = View$MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, n3);
    }
    
    public void clearListSelection() {
        final IcsListPopupWindow$DropDownListView mDropDownList = this.mDropDownList;
        if (mDropDownList != null) {
            mDropDownList.mListSelectionHidden = true;
            mDropDownList.requestLayout();
        }
    }
    
    public void dismiss() {
        this.mPopup.dismiss();
        if (this.mPromptView != null) {
            final ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup)parent).removeView(this.mPromptView);
            }
        }
        this.mPopup.setContentView((View)null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks((Runnable)this.mResizePopupRunnable);
    }
    
    public ListView getListView() {
        return this.mDropDownList;
    }
    
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }
    
    public void setAdapter(final ListAdapter mAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new IcsListPopupWindow$PopupDataSetObserver(this, null);
        }
        else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = mAdapter;
        if (this.mAdapter != null) {
            mAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }
    
    public void setAnchorView(final View mDropDownAnchorView) {
        this.mDropDownAnchorView = mDropDownAnchorView;
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        this.mPopup.setBackgroundDrawable(backgroundDrawable);
    }
    
    public void setContentWidth(final int mDropDownWidth) {
        final Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mDropDownWidth = mDropDownWidth + (this.mTempRect.left + this.mTempRect.right);
            return;
        }
        this.mDropDownWidth = mDropDownWidth;
    }
    
    public void setHorizontalOffset(final int mDropDownHorizontalOffset) {
        this.mDropDownHorizontalOffset = mDropDownHorizontalOffset;
    }
    
    public void setInputMethodMode(final int inputMethodMode) {
        this.mPopup.setInputMethodMode(inputMethodMode);
    }
    
    public void setModal(final boolean focusable) {
        this.mModal = true;
        this.mPopup.setFocusable(focusable);
    }
    
    public void setOnDismissListener(final PopupWindow$OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }
    
    public void setOnItemClickListener(final AdapterView$OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
    
    public void setPromptPosition(final int mPromptPosition) {
        this.mPromptPosition = mPromptPosition;
    }
    
    public void setSelection(final int selection) {
        final IcsListPopupWindow$DropDownListView mDropDownList = this.mDropDownList;
        if (this.isShowing() && mDropDownList != null) {
            mDropDownList.mListSelectionHidden = false;
            mDropDownList.setSelection(selection);
            if (mDropDownList.getChoiceMode() != 0) {
                mDropDownList.setItemChecked(selection, true);
            }
        }
    }
    
    public void setVerticalOffset(final int mDropDownVerticalOffset) {
        this.mDropDownVerticalOffset = mDropDownVerticalOffset;
        this.mDropDownVerticalOffsetSet = true;
    }
    
    public void show() {
        int selection = -1;
        int height = this.buildDropDown();
        final boolean inputMethodNotNeeded = this.isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            int n;
            if (this.mDropDownWidth == selection) {
                n = selection;
            }
            else if (this.mDropDownWidth == -2) {
                n = this.mDropDownAnchorView.getWidth();
            }
            else {
                n = this.mDropDownWidth;
            }
            if (this.mDropDownHeight == selection) {
                if (!inputMethodNotNeeded) {
                    height = selection;
                }
                if (inputMethodNotNeeded) {
                    final PopupWindowCompat mPopup = this.mPopup;
                    if (this.mDropDownWidth != selection) {
                        selection = 0;
                    }
                    mPopup.setWindowLayoutMode(selection, 0);
                }
                else {
                    final PopupWindowCompat mPopup2 = this.mPopup;
                    final int mDropDownWidth = this.mDropDownWidth;
                    int n2 = 0;
                    if (mDropDownWidth == selection) {
                        n2 = selection;
                    }
                    mPopup2.setWindowLayoutMode(n2, selection);
                }
            }
            else if (this.mDropDownHeight != -2) {
                height = this.mDropDownHeight;
            }
            this.mPopup.setOutsideTouchable(true);
            this.mPopup.update(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, n, height);
        }
        else {
            int n3;
            if (this.mDropDownWidth == selection) {
                n3 = selection;
            }
            else if (this.mDropDownWidth == -2) {
                this.mPopup.setWidth(this.mDropDownAnchorView.getWidth());
                n3 = 0;
            }
            else {
                this.mPopup.setWidth(this.mDropDownWidth);
                n3 = 0;
            }
            int n4;
            if (this.mDropDownHeight == selection) {
                n4 = selection;
            }
            else if (this.mDropDownHeight == -2) {
                this.mPopup.setHeight(height);
                n4 = 0;
            }
            else {
                this.mPopup.setHeight(this.mDropDownHeight);
                n4 = 0;
            }
            this.mPopup.setWindowLayoutMode(n3, n4);
            this.mPopup.setOutsideTouchable(true);
            this.mPopup.setTouchInterceptor((View$OnTouchListener)this.mTouchInterceptor);
            this.mPopup.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
            this.mDropDownList.setSelection(selection);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                this.clearListSelection();
            }
            if (!this.mModal) {
                this.mHandler.post((Runnable)this.mHideSelector);
            }
        }
    }
}
