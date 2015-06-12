// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.graphics.Canvas;
import android.content.res.Configuration;
import com.actionbarsherlock.view.MenuItem;
import android.widget.LinearLayout$LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View$MeasureSpec;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;

public class ActionMenuView extends IcsLinearLayout implements MenuBuilder$ItemInvoker, MenuView
{
    static final int GENERATED_ITEM_PADDING = 4;
    private static final boolean IS_FROYO = false;
    static final int MIN_CELL_SIZE = 56;
    private boolean mFirst;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;
    
    public ActionMenuView(final Context context) {
        this(context, null);
    }
    
    public ActionMenuView(final Context context, final AttributeSet set) {
        super(context, set);
        this.mFirst = true;
        this.setBaselineAligned(false);
        final float density = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int)(56.0f * density);
        this.mGeneratedItemPadding = (int)(density * 4.0f);
    }
    
    static int measureChildForCells(final View view, final int n, final int n2, final int n3, final int n4) {
        final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(n3) - n4, View$MeasureSpec.getMode(n3));
        int cellsUsed;
        if (n2 > 0) {
            view.measure(View$MeasureSpec.makeMeasureSpec(n * n2, Integer.MIN_VALUE), measureSpec);
            final int measuredWidth = view.getMeasuredWidth();
            final int n5 = measuredWidth / n;
            if (measuredWidth % n != 0) {
                cellsUsed = n5 + 1;
            }
            else {
                cellsUsed = n5;
            }
        }
        else {
            cellsUsed = 0;
        }
        ActionMenuItemView actionMenuItemView;
        if (view instanceof ActionMenuItemView) {
            actionMenuItemView = (ActionMenuItemView)view;
        }
        else {
            actionMenuItemView = null;
        }
        final boolean isOverflowButton = actionMenuView$LayoutParams.isOverflowButton;
        boolean expandable = false;
        if (!isOverflowButton) {
            expandable = false;
            if (actionMenuItemView != null) {
                final boolean hasText = actionMenuItemView.hasText();
                expandable = false;
                if (hasText) {
                    expandable = true;
                }
            }
        }
        actionMenuView$LayoutParams.expandable = expandable;
        actionMenuView$LayoutParams.cellsUsed = cellsUsed;
        view.measure(View$MeasureSpec.makeMeasureSpec(cellsUsed * n, 1073741824), measureSpec);
        return cellsUsed;
    }
    
    private void onMeasureExactFormat(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n);
        final int size2 = View$MeasureSpec.getSize(n2);
        final int n3 = this.getPaddingLeft() + this.getPaddingRight();
        final int n4 = this.getPaddingTop() + this.getPaddingBottom();
        final int n5 = size - n3;
        int n6 = n5 / this.mMinCellSize;
        final int n7 = n5 % this.mMinCellSize;
        if (n6 == 0) {
            this.setMeasuredDimension(n5, 0);
            return;
        }
        final int n8 = this.mMinCellSize + n7 / n6;
        int a = 0;
        int a2 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        long n12 = 0L;
        final int childCount = this.getChildCount();
        int n13;
        long n14;
        int n15;
        int n16;
        int n17;
        for (int i = 0; i < childCount; ++i, a2 = n17, a = n15, n6 = n16, n12 = n14, n10 = n13) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() == 8) {
                n13 = n10;
                n14 = n12;
                n15 = a;
                n16 = n6;
                n17 = a2;
            }
            else {
                final boolean b = child instanceof ActionMenuItemView;
                final int n18 = n10 + 1;
                if (b) {
                    child.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                }
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)child.getLayoutParams();
                actionMenuView$LayoutParams.expanded = false;
                actionMenuView$LayoutParams.extraPixels = 0;
                actionMenuView$LayoutParams.cellsUsed = 0;
                actionMenuView$LayoutParams.expandable = false;
                actionMenuView$LayoutParams.leftMargin = 0;
                actionMenuView$LayoutParams.rightMargin = 0;
                actionMenuView$LayoutParams.preventEdgeOffset = (b && ((ActionMenuItemView)child).hasText());
                int n19;
                if (actionMenuView$LayoutParams.isOverflowButton) {
                    n19 = 1;
                }
                else {
                    n19 = n6;
                }
                final int measureChildForCells = measureChildForCells(child, n8, n19, n2, n4);
                final int max = Math.max(a2, measureChildForCells);
                int n20;
                if (actionMenuView$LayoutParams.expandable) {
                    n20 = n9 + 1;
                }
                else {
                    n20 = n9;
                }
                int n21;
                if (actionMenuView$LayoutParams.isOverflowButton) {
                    n21 = 1;
                }
                else {
                    n21 = n11;
                }
                final int n22 = n6 - measureChildForCells;
                final int max2 = Math.max(a, child.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    final long n23 = n12 | 1 << i;
                    n15 = max2;
                    n16 = n22;
                    n9 = n20;
                    n11 = n21;
                    n14 = n23;
                    n17 = max;
                    n13 = n18;
                }
                else {
                    n13 = n18;
                    n17 = max;
                    final long n24 = n12;
                    n15 = max2;
                    n16 = n22;
                    n11 = n21;
                    n9 = n20;
                    n14 = n24;
                }
            }
        }
        final boolean b2 = n11 != 0 && n10 == 2;
        int n25 = 0;
        long n26 = n12;
        while (true) {
            int n41;
            for (int n27 = n6; n9 > 0 && n27 > 0; n27 = n41) {
                int n28 = Integer.MAX_VALUE;
                long n29 = 0L;
                int n30 = 0;
                int n31;
                int cellsUsed;
                for (int j = 0; j < childCount; ++j, n28 = cellsUsed, n30 = n31) {
                    final ActionMenuView$LayoutParams actionMenuView$LayoutParams2 = (ActionMenuView$LayoutParams)this.getChildAt(j).getLayoutParams();
                    if (!actionMenuView$LayoutParams2.expandable) {
                        n31 = n30;
                        cellsUsed = n28;
                    }
                    else if (actionMenuView$LayoutParams2.cellsUsed < n28) {
                        cellsUsed = actionMenuView$LayoutParams2.cellsUsed;
                        n29 = 1 << j;
                        n31 = 1;
                    }
                    else if (actionMenuView$LayoutParams2.cellsUsed == n28) {
                        n29 |= 1 << j;
                        n31 = n30 + 1;
                        cellsUsed = n28;
                    }
                    else {
                        n31 = n30;
                        cellsUsed = n28;
                    }
                }
                final long n32 = n26 | n29;
                if (n30 > n27) {
                    final long k = n32;
                    boolean b3;
                    if (n11 == 0 && n10 == 1) {
                        b3 = true;
                    }
                    else {
                        b3 = false;
                    }
                    int n36 = 0;
                    Label_1141: {
                        if (n27 > 0 && k != 0L && (n27 < n10 - 1 || b3 || a2 > 1)) {
                            float n33 = Long.bitCount(k);
                            while (true) {
                                Label_1250: {
                                    if (b3) {
                                        break Label_1250;
                                    }
                                    if ((0x1L & k) != 0x0L && !((ActionMenuView$LayoutParams)this.getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                                        n33 -= 0.5f;
                                    }
                                    if ((k & 1 << childCount - 1) == 0x0L || ((ActionMenuView$LayoutParams)this.getChildAt(childCount - 1).getLayoutParams()).preventEdgeOffset) {
                                        break Label_1250;
                                    }
                                    final float n34 = n33 - 0.5f;
                                    int n35;
                                    if (n34 > 0.0f) {
                                        n35 = (int)(n27 * n8 / n34);
                                    }
                                    else {
                                        n35 = 0;
                                    }
                                    int l = 0;
                                    n36 = n25;
                                    while (l < childCount) {
                                        int n37;
                                        if ((k & 1 << l) == 0x0L) {
                                            n37 = n36;
                                        }
                                        else {
                                            final View child2 = this.getChildAt(l);
                                            final ActionMenuView$LayoutParams actionMenuView$LayoutParams3 = (ActionMenuView$LayoutParams)child2.getLayoutParams();
                                            if (child2 instanceof ActionMenuItemView) {
                                                actionMenuView$LayoutParams3.extraPixels = n35;
                                                actionMenuView$LayoutParams3.expanded = true;
                                                if (l == 0 && !actionMenuView$LayoutParams3.preventEdgeOffset) {
                                                    actionMenuView$LayoutParams3.leftMargin = -n35 / 2;
                                                }
                                                n37 = 1;
                                            }
                                            else if (actionMenuView$LayoutParams3.isOverflowButton) {
                                                actionMenuView$LayoutParams3.extraPixels = n35;
                                                actionMenuView$LayoutParams3.expanded = true;
                                                actionMenuView$LayoutParams3.rightMargin = -n35 / 2;
                                                n37 = 1;
                                            }
                                            else {
                                                if (l != 0) {
                                                    actionMenuView$LayoutParams3.leftMargin = n35 / 2;
                                                }
                                                if (l != childCount - 1) {
                                                    actionMenuView$LayoutParams3.rightMargin = n35 / 2;
                                                }
                                                n37 = n36;
                                            }
                                        }
                                        ++l;
                                        n36 = n37;
                                    }
                                    break Label_1141;
                                }
                                final float n34 = n33;
                                continue;
                            }
                        }
                        n36 = n25;
                    }
                    if (n36 != 0) {
                        final int measureSpec = View$MeasureSpec.makeMeasureSpec(size2 - n4, mode);
                        for (int n38 = 0; n38 < childCount; ++n38) {
                            final View child3 = this.getChildAt(n38);
                            final ActionMenuView$LayoutParams actionMenuView$LayoutParams4 = (ActionMenuView$LayoutParams)child3.getLayoutParams();
                            if (actionMenuView$LayoutParams4.expanded) {
                                child3.measure(View$MeasureSpec.makeMeasureSpec(n8 * actionMenuView$LayoutParams4.cellsUsed + actionMenuView$LayoutParams4.extraPixels, 1073741824), measureSpec);
                            }
                        }
                    }
                    if (mode == 1073741824) {
                        a = size2;
                    }
                    this.setMeasuredDimension(n5, a);
                    return;
                }
                final int n39 = n28 + 1;
                int n40 = 0;
                n41 = n27;
                long n42 = n32;
                while (n40 < childCount) {
                    final View child4 = this.getChildAt(n40);
                    final ActionMenuView$LayoutParams actionMenuView$LayoutParams5 = (ActionMenuView$LayoutParams)child4.getLayoutParams();
                    int n43;
                    if ((n29 & 1 << n40) == 0x0L) {
                        if (actionMenuView$LayoutParams5.cellsUsed == n39) {
                            n42 |= 1 << n40;
                            n43 = n41;
                        }
                        else {
                            n43 = n41;
                        }
                    }
                    else {
                        if (b2 && actionMenuView$LayoutParams5.preventEdgeOffset && n41 == 1) {
                            child4.setPadding(n8 + this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                        }
                        ++actionMenuView$LayoutParams5.cellsUsed;
                        actionMenuView$LayoutParams5.expanded = true;
                        n43 = n41 - 1;
                    }
                    ++n40;
                    n41 = n43;
                }
                n26 = n42;
                n25 = 1;
            }
            final long k = n26;
            continue;
        }
    }
    
    protected boolean checkLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams != null && viewGroup$LayoutParams instanceof ActionMenuView$LayoutParams;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        return false;
    }
    
    protected ActionMenuView$LayoutParams generateDefaultLayoutParams() {
        final ActionMenuView$LayoutParams actionMenuView$LayoutParams = new ActionMenuView$LayoutParams(-2, -2);
        actionMenuView$LayoutParams.gravity = 16;
        return actionMenuView$LayoutParams;
    }
    
    public ActionMenuView$LayoutParams generateLayoutParams(final AttributeSet set) {
        return new ActionMenuView$LayoutParams(this.getContext(), set);
    }
    
    protected ActionMenuView$LayoutParams generateLayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof ActionMenuView$LayoutParams) {
            final ActionMenuView$LayoutParams actionMenuView$LayoutParams = new ActionMenuView$LayoutParams((ActionMenuView$LayoutParams)viewGroup$LayoutParams);
            if (actionMenuView$LayoutParams.gravity <= 0) {
                actionMenuView$LayoutParams.gravity = 16;
            }
            return actionMenuView$LayoutParams;
        }
        return this.generateDefaultLayoutParams();
    }
    
    public ActionMenuView$LayoutParams generateOverflowButtonLayoutParams() {
        final ActionMenuView$LayoutParams generateDefaultLayoutParams = this.generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }
    
    @Override
    public int getWindowAnimations() {
        return 0;
    }
    
    @Override
    protected boolean hasDividerBeforeChildAt(final int n) {
        if (n == 0) {
            return false;
        }
        final View child = this.getChildAt(n - 1);
        final View child2 = this.getChildAt(n);
        final int childCount = this.getChildCount();
        boolean b = false;
        if (n < childCount) {
            final boolean b2 = child instanceof ActionMenuView$ActionMenuChildView;
            b = false;
            if (b2) {
                b = (false | ((ActionMenuView$ActionMenuChildView)child).needsDividerAfter());
            }
        }
        if (n > 0 && child2 instanceof ActionMenuView$ActionMenuChildView) {
            return b | ((ActionMenuView$ActionMenuChildView)child2).needsDividerBefore();
        }
        return b;
    }
    
    @Override
    public void initialize(final MenuBuilder mMenu) {
        this.mMenu = mMenu;
    }
    
    @Override
    public boolean invokeItem(final MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }
    
    public boolean isExpandedFormat() {
        return this.mFormatItems;
    }
    
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (ActionMenuView.IS_FROYO) {
            super.onConfigurationChanged(configuration);
        }
        this.mPresenter.updateMenuView(false);
        if (this.mPresenter != null && this.mPresenter.isOverflowMenuShowing()) {
            this.mPresenter.hideOverflowMenu();
            this.mPresenter.showOverflowMenu();
        }
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPresenter.dismissPopupMenus();
    }
    
    @Override
    protected void onDraw(final Canvas canvas) {
        if (!ActionMenuView.IS_FROYO && this.mFirst) {
            this.mFirst = false;
            this.requestLayout();
            return;
        }
        super.onDraw(canvas);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (!this.mFormatItems) {
            super.onLayout(b, n, n2, n3, n4);
        }
        else {
            final int childCount = this.getChildCount();
            final int n5 = (n2 + n4) / 2;
            int n6 = 0;
            int n7 = n3 - n - this.getPaddingRight() - this.getPaddingLeft();
            int n8 = 0;
            int n9;
            int n10;
            int n11;
            for (int i = 0; i < childCount; ++i, n6 = n11, n7 = n10, n8 = n9) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() == 8) {
                    n9 = n8;
                    n10 = n7;
                    n11 = n6;
                }
                else {
                    final ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)child.getLayoutParams();
                    if (actionMenuView$LayoutParams.isOverflowButton) {
                        int measuredWidth = child.getMeasuredWidth();
                        if (this.hasDividerBeforeChildAt(i)) {
                            measuredWidth += 0;
                        }
                        final int measuredHeight = child.getMeasuredHeight();
                        final int n12 = this.getWidth() - this.getPaddingRight() - actionMenuView$LayoutParams.rightMargin;
                        final int n13 = n12 - measuredWidth;
                        final int n14 = n5 - measuredHeight / 2;
                        child.layout(n13, n14, n12, measuredHeight + n14);
                        n10 = n7 - measuredWidth;
                        n9 = 1;
                        n11 = n6;
                    }
                    else {
                        final int n15 = n7 - (child.getMeasuredWidth() + actionMenuView$LayoutParams.leftMargin + actionMenuView$LayoutParams.rightMargin);
                        n11 = n6 + 1;
                        final int n16 = n8;
                        n10 = n15;
                        n9 = n16;
                    }
                }
            }
            if (childCount == 1 && n8 == 0) {
                final View child2 = this.getChildAt(0);
                final int measuredWidth2 = child2.getMeasuredWidth();
                final int measuredHeight2 = child2.getMeasuredHeight();
                final int n17 = (n3 - n) / 2 - measuredWidth2 / 2;
                final int n18 = n5 - measuredHeight2 / 2;
                child2.layout(n17, n18, measuredWidth2 + n17, measuredHeight2 + n18);
                return;
            }
            int n19;
            if (n8 != 0) {
                n19 = 0;
            }
            else {
                n19 = 1;
            }
            final int n20 = n6 - n19;
            int b2;
            if (n20 > 0) {
                b2 = n7 / n20;
            }
            else {
                b2 = 0;
            }
            final int max = Math.max(0, b2);
            int paddingLeft = this.getPaddingLeft();
            int n21;
            for (int j = 0; j < childCount; ++j, paddingLeft = n21) {
                final View child3 = this.getChildAt(j);
                final ActionMenuView$LayoutParams actionMenuView$LayoutParams2 = (ActionMenuView$LayoutParams)child3.getLayoutParams();
                if (child3.getVisibility() != 8) {
                    if (actionMenuView$LayoutParams2.isOverflowButton) {
                        n21 = paddingLeft;
                    }
                    else {
                        final int n22 = paddingLeft + actionMenuView$LayoutParams2.leftMargin;
                        final int measuredWidth3 = child3.getMeasuredWidth();
                        final int measuredHeight3 = child3.getMeasuredHeight();
                        final int n23 = n5 - measuredHeight3 / 2;
                        child3.layout(n22, n23, n22 + measuredWidth3, measuredHeight3 + n23);
                        n21 = n22 + (max + (measuredWidth3 + actionMenuView$LayoutParams2.rightMargin));
                    }
                }
                else {
                    n21 = paddingLeft;
                }
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final boolean mFormatItems = this.mFormatItems;
        this.mFormatItems = (View$MeasureSpec.getMode(n) == 1073741824);
        if (mFormatItems != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        final int mode = View$MeasureSpec.getMode(n);
        if (this.mFormatItems && this.mMenu != null && mode != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = mode;
            this.mMenu.onItemsChanged(true);
        }
        if (this.mFormatItems) {
            this.onMeasureExactFormat(n, n2);
            return;
        }
        super.onMeasure(n, n2);
    }
    
    public void setOverflowReserved(final boolean mReserveOverflow) {
        this.mReserveOverflow = mReserveOverflow;
    }
    
    public void setPresenter(final ActionMenuPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }
}
