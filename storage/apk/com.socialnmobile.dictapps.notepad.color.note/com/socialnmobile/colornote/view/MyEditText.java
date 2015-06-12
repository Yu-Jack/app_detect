// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.widget.TextView;
import android.os.Build;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.EditText;

public class MyEditText extends EditText
{
    private int a;
    
    public MyEditText(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = 0;
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = false;
        if (sdk_INT >= 14) {
            final boolean equals = Build.BRAND.toLowerCase().equals("samsung");
            b = false;
            if (equals) {
                b = true;
            }
        }
        if (b) {
            jf.a((TextView)this, new zu().a((TextView)this));
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(true, n, n2, n3, n4);
    }
    
    protected void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        super.onTextChanged(charSequence, n, n2, n3);
        if (this.getLayout() != null) {
            final int lineCount = this.getLayout().getLineCount();
            if (this.a != lineCount) {
                this.requestLayout();
                this.a = lineCount;
            }
        }
    }
}
