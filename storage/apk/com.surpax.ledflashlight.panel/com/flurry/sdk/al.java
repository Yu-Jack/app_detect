// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Paint$Style;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.graphics.Typeface;
import android.content.Context;
import android.graphics.RectF;
import android.widget.TextView;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.Path;

public class al
{
    private static int a;
    private static int b;
    private Path c;
    private PathShape d;
    private ShapeDrawable e;
    private TextView f;
    private int g;
    private float h;
    private RectF i;
    private final float j;
    
    public al() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0.0f;
        this.i = null;
        this.j = -90.0f;
        al.a = 3;
        al.b = 1;
    }
    
    public al(final Context context, final int n, final int n2) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 0.0f;
        this.i = null;
        this.j = -90.0f;
        al.a = fc.b(2);
        al.b = fc.b(1);
        this.g = this.a(n, n2);
        this.a(context);
    }
    
    private int a(final int n, final int n2) {
        if (n < n2) {
            return n / 2;
        }
        return n2 / 2;
    }
    
    private void a(final Context context) {
        (this.f = new TextView(context)).setTextColor(-1);
        this.f.setTypeface(Typeface.MONOSPACE);
        this.f.setTextSize(1, 12.0f);
        this.f.setGravity(17);
    }
    
    @SuppressLint({ "NewApi" })
    private void c(final int n) {
        final Drawable b = this.b(n);
        if (Build$VERSION.SDK_INT >= 16) {
            this.f.setBackground(b);
            return;
        }
        this.f.setBackgroundDrawable(b);
    }
    
    private void d(final int n) {
        this.c(n);
    }
    
    private void e(final int i) {
        this.f.setText((CharSequence)Integer.toString(i));
    }
    
    public View a() {
        return (View)this.f;
    }
    
    public void a(final int n) {
        this.h = 360.0f / (n / 1000);
        this.c(n);
    }
    
    public void a(final int n, final boolean b) {
        if (this.f != null) {
            this.c(n);
            this.e(n);
        }
    }
    
    public Drawable b(final int n) {
        (this.i = new RectF()).set((float)al.a, (float)al.a, (float)(this.g - al.a), (float)(this.g - al.a));
        (this.c = new Path()).arcTo(this.i, -90.0f, 1.0f + -n * this.h, false);
        this.d = new PathShape(this.c, (float)this.g, (float)this.g);
        (this.e = new ShapeDrawable((Shape)this.d)).setIntrinsicHeight(2 * this.g);
        this.e.setIntrinsicWidth(2 * this.g);
        this.e.getPaint().setStyle(Paint$Style.STROKE);
        this.e.getPaint().setColor(-1);
        this.e.getPaint().setStrokeWidth((float)al.b);
        this.e.getPaint().setAntiAlias(true);
        final GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setShape(1);
        gradientDrawable.setAlpha(178);
        return (Drawable)new LayerDrawable(new Drawable[] { gradientDrawable, this.e });
    }
}
