// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.view.View;
import android.widget.TextView;
import android.app.Activity;

public final class x
{
    public static TextView a(final Activity activity, final int n, final CharSequence text) {
        final TextView textView = (TextView)activity.findViewById(n);
        if (textView != null) {
            textView.setText(text);
        }
        return textView;
    }
    
    public static TextView a(final View view, final CharSequence text) {
        if (view instanceof TextView) {
            final TextView textView = (TextView)view;
            textView.setText(text);
            return textView;
        }
        return null;
    }
    
    public static CharSequence a(final View view) {
        if (view instanceof TextView) {
            return ((TextView)view).getText();
        }
        return null;
    }
}
