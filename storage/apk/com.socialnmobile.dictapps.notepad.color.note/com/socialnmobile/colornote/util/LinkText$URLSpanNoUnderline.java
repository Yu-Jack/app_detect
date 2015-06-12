// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.util;

import android.text.TextPaint;
import android.text.style.URLSpan;

class LinkText$URLSpanNoUnderline extends URLSpan
{
    public LinkText$URLSpanNoUnderline(final String s) {
        super(s);
    }
    
    public void updateDrawState(final TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
