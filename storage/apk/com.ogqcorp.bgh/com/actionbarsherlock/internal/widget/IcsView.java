// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View;

final class IcsView
{
    public static int getMeasuredStateInt(final View view) {
        return (0xFF000000 & view.getMeasuredWidth()) | (0xFFFFFF00 & view.getMeasuredHeight() >> 16);
    }
}
