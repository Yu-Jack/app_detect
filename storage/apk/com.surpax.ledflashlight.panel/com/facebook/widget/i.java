// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import com.facebook.a.e;
import android.view.ViewGroup;
import com.facebook.a.f;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.FrameLayout;

final class i extends FrameLayout
{
    final /* synthetic */ h a;
    private ImageView b;
    private ImageView c;
    private View d;
    private ImageView e;
    
    public i(final h a, final Context context) {
        this.a = a;
        super(context);
        LayoutInflater.from(this.getContext()).inflate(f.b, (ViewGroup)this);
        this.b = (ImageView)this.findViewById(com.facebook.a.e.f);
        this.c = (ImageView)this.findViewById(com.facebook.a.e.d);
        this.d = this.findViewById(com.facebook.a.e.a);
        this.e = (ImageView)this.findViewById(com.facebook.a.e.b);
    }
    
    public final void a() {
        this.b.setVisibility(0);
        this.c.setVisibility(4);
    }
    
    public final void b() {
        this.b.setVisibility(4);
        this.c.setVisibility(0);
    }
    
    public final void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
    }
}
