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

public final class yz implements kz
{
    final /* synthetic */ ColorPreference a;
    
    public yz(final ColorPreference a) {
        this.a = a;
    }
    
    @Override
    public final void a(final int n) {
        this.a.a(n);
        ColorPreference.b(this.a, n);
        ColorPreference.a(this.a);
    }
}
