// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.cp;

import java.util.Locale;
import android.graphics.Color;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.TextView;

public class ColorStatus extends TextView
{
    public ColorStatus(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public ColorStatus(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    private static int a(final int n) {
        if (0.299f * Color.red(n) + 0.587f * Color.green(n) + 0.114f * Color.blue(n) < 127.0f) {
            return -1;
        }
        return -16777216;
    }
    
    public void setBackgroundColor(final int backgroundColor) {
        super.setBackgroundColor(backgroundColor);
        final String upperCase = Integer.toHexString(0xFFFFFF & backgroundColor).toUpperCase(Locale.US);
        this.setText((CharSequence)("#" + (Object)"000000".subSequence(upperCase.length(), 6) + upperCase));
        this.setTextColor(a(backgroundColor));
    }
}
