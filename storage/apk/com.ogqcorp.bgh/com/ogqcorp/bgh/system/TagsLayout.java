// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup;

public final class TagsLayout extends ViewGroup
{
    public TagsLayout(final Context context) {
        super(context);
    }
    
    public TagsLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public TagsLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int a = ac.a(this.getContext(), 7.0f);
        final int a2 = ac.a(this.getContext(), 7.0f);
        this.measureChildren(n, n2);
        final int n3 = resolveSize(0, n) - this.getPaddingRight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        int a3 = 0;
        final int childCount = this.getChildCount();
        int i = 0;
        int max = 0;
        int n4 = paddingTop;
        int paddingLeft2 = paddingLeft;
        while (i < childCount) {
            final View child = this.getChildAt(i);
            int n6;
            int n7;
            int n8;
            if (child.getVisibility() == 8) {
                final int n5 = a3;
                n6 = paddingLeft2;
                n7 = n4;
                n8 = n5;
            }
            else {
                final int measuredWidth = child.getMeasuredWidth();
                final int measuredHeight = child.getMeasuredHeight();
                if (paddingLeft2 + measuredWidth > n3) {
                    paddingLeft2 = this.getPaddingLeft();
                    n4 = a2 + (max + n4);
                    max = 0;
                }
                child.layout(paddingLeft2, n4, paddingLeft2 + measuredWidth, n4 + measuredHeight);
                max = Math.max(max, measuredHeight);
                final int b = a + (paddingLeft2 + measuredWidth);
                final int max2 = Math.max(a3, b);
                n6 = b;
                final int n9 = n4;
                n8 = max2;
                n7 = n9;
            }
            ++i;
            final int n10 = n8;
            n4 = n7;
            paddingLeft2 = n6;
            a3 = n10;
        }
        this.setMeasuredDimension(resolveSize(a3, n), resolveSize(max + n4 + this.getPaddingBottom(), n2));
    }
}
