// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import java.util.Locale;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.Button;

public class CapitalizingButton extends Button
{
    private static final boolean IS_GINGERBREAD;
    private static final int[] R_styleable_Button;
    private static final int R_styleable_Button_textAppearance;
    private static final int[] R_styleable_TextAppearance;
    private static final int R_styleable_TextAppearance_textAllCaps;
    private static final boolean SANS_ICE_CREAM;
    private boolean mAllCaps;
    
    static {
        SANS_ICE_CREAM = (Build$VERSION.SDK_INT < 14);
        IS_GINGERBREAD = (Build$VERSION.SDK_INT >= 9);
        R_styleable_Button = new int[] { 16842804 };
        R_styleable_TextAppearance = new int[] { 16843660 };
    }
    
    public CapitalizingButton(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, CapitalizingButton.R_styleable_Button);
        final int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, CapitalizingButton.R_styleable_TextAppearance);
            if (obtainStyledAttributes2 != null) {
                this.mAllCaps = obtainStyledAttributes2.getBoolean(0, true);
                obtainStyledAttributes2.recycle();
            }
        }
    }
    
    public void setTextCompat(final CharSequence text) {
        if (CapitalizingButton.SANS_ICE_CREAM && this.mAllCaps && text != null) {
            if (CapitalizingButton.IS_GINGERBREAD) {
                try {
                    this.setText((CharSequence)text.toString().toUpperCase(Locale.ROOT));
                    return;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    this.setText((CharSequence)text.toString().toUpperCase());
                    return;
                }
            }
            this.setText((CharSequence)text.toString().toUpperCase());
            return;
        }
        this.setText(text);
    }
}
