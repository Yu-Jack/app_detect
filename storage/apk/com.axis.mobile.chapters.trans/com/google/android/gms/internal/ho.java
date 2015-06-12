// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.R$string;
import com.google.android.gms.R$color;
import android.graphics.Typeface;
import com.google.android.gms.R$drawable;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.Button;

public final class ho extends Button
{
    public ho(final Context context) {
        this(context, null);
    }
    
    public ho(final Context context, final AttributeSet set) {
        super(context, set, 16842824);
    }
    
    private int b(final int i, int n, final int n2) {
        switch (i) {
            default: {
                throw new IllegalStateException("Unknown color scheme: " + i);
            }
            case 1: {
                n = n2;
            }
            case 0: {
                return n;
            }
        }
    }
    
    private void b(final Resources resources, final int i, final int n) {
        int n2 = 0;
        switch (i) {
            default: {
                throw new IllegalStateException("Unknown button size: " + i);
            }
            case 0:
            case 1: {
                n2 = this.b(n, R$drawable.common_signin_btn_text_dark, R$drawable.common_signin_btn_text_light);
                break;
            }
            case 2: {
                n2 = this.b(n, R$drawable.common_signin_btn_icon_dark, R$drawable.common_signin_btn_icon_light);
                break;
            }
        }
        if (n2 == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        this.setBackgroundDrawable(resources.getDrawable(n2));
    }
    
    private void c(final Resources resources) {
        this.setTypeface(Typeface.DEFAULT_BOLD);
        this.setTextSize(14.0f);
        final float density = resources.getDisplayMetrics().density;
        this.setMinHeight((int)(0.5f + density * 48.0f));
        this.setMinWidth((int)(0.5f + density * 48.0f));
    }
    
    private void c(final Resources resources, final int i, final int n) {
        this.setTextColor(resources.getColorStateList(this.b(n, R$color.common_signin_btn_text_dark, R$color.common_signin_btn_text_light)));
        switch (i) {
            default: {
                throw new IllegalStateException("Unknown button size: " + i);
            }
            case 0: {
                this.setText((CharSequence)resources.getString(R$string.common_signin_button_text));
            }
            case 1: {
                this.setText((CharSequence)resources.getString(R$string.common_signin_button_text_long));
            }
            case 2: {
                this.setText((CharSequence)null);
            }
        }
    }
    
    public void a(final Resources resources, final int i, final int j) {
        hm.a(i >= 0 && i < 3, "Unknown button size %d", i);
        hm.a(j >= 0 && j < 2, "Unknown color scheme %s", j);
        this.c(resources);
        this.b(resources, i, j);
        this.c(resources, i, j);
    }
}
