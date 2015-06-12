// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.widget.ImageView;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.preference.Preference;

public class MyIntentPreference extends Preference
{
    int a;
    
    public MyIntentPreference(final Context context) {
        super(context);
    }
    
    public MyIntentPreference(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public MyIntentPreference(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public final void a(final int a) {
        this.a = a;
    }
    
    protected void onBindView(final View view) {
        super.onBindView(view);
        final ImageView imageView = (ImageView)view.findViewById(2131624093);
        if (this.a != 0) {
            imageView.setImageResource(this.a);
        }
    }
}
