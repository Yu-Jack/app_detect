// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.graphics.Rect;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ScrollView;

public class EditorScrollView extends ScrollView
{
    public EditorScrollView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public boolean requestChildRectangleOnScreen(final View view, final Rect rect, final boolean b) {
        return super.requestChildRectangleOnScreen(view, rect, true);
    }
}
