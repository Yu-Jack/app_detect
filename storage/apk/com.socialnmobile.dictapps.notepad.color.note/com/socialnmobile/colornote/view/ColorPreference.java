// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.view.View;
import android.app.Dialog;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.preference.DialogPreference;

public class ColorPreference extends DialogPreference
{
    kx a;
    GradientDrawable b;
    
    public ColorPreference(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new kx(this.getContext(), -1, 3);
        this.setDefaultValue((Object)3);
        this.b = (GradientDrawable)this.getContext().getResources().getDrawable(2130837530);
        this.a.a(new yz(this));
    }
    
    private void a(final int n) {
        this.b.setColor(gr.a(this.getContext()).e(n));
        this.a.a(n);
        this.a.a();
    }
    
    public Dialog getDialog() {
        return this.a;
    }
    
    protected void onBindView(final View view) {
        super.onBindView(view);
        final ImageView imageView = (ImageView)view.findViewById(2131624092);
        if (imageView != null) {
            imageView.setImageDrawable((Drawable)this.b);
        }
    }
    
    protected void onSetInitialValue(final boolean b, final Object o) {
        if (b) {
            this.a(this.getPersistedInt(3));
            return;
        }
        this.a((int)o);
    }
    
    protected void showDialog(final Bundle bundle) {
        this.a.show();
    }
}
