// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewParent;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.database.DataSetObserver;
import android.content.res.TypedArray;
import android.text.TextUtils$TruncateAt;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import android.widget.TextView;
import android.view.ViewGroup;

public class PagerTitleStrip extends ViewGroup implements bb
{
    private static final int[] n;
    private static final int[] o;
    private static final y q;
    ViewPager a;
    TextView b;
    TextView c;
    TextView d;
    int e;
    private int f;
    private float g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private final x l;
    private WeakReference m;
    private int p;
    
    static {
        n = new int[] { 16842804, 16842901, 16842904, 16842927 };
        o = new int[] { 16843660 };
        if (Build$VERSION.SDK_INT >= 14) {
            q = new aa();
            return;
        }
        q = new z();
    }
    
    public PagerTitleStrip(final Context context, final AttributeSet set) {
        super(context, set);
        this.f = -1;
        this.g = -1.0f;
        this.l = new x(this, (byte)0);
        this.addView((View)(this.b = new TextView(context)));
        this.addView((View)(this.c = new TextView(context)));
        this.addView((View)(this.d = new TextView(context)));
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, PagerTitleStrip.n);
        final int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.b.setTextAppearance(context, resourceId);
            this.c.setTextAppearance(context, resourceId);
            this.d.setTextAppearance(context, resourceId);
        }
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            final float n = dimensionPixelSize;
            this.b.setTextSize(0, n);
            this.c.setTextSize(0, n);
            this.d.setTextSize(0, n);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            final int color = obtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(color);
            this.c.setTextColor(color);
            this.d.setTextColor(color);
        }
        this.i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.e = this.c.getTextColors().getDefaultColor();
        this.p = 153;
        final int n2 = this.p << 24 | (0xFFFFFF & this.e);
        this.b.setTextColor(n2);
        this.d.setTextColor(n2);
        this.b.setEllipsize(TextUtils$TruncateAt.END);
        this.c.setEllipsize(TextUtils$TruncateAt.END);
        this.d.setEllipsize(TextUtils$TruncateAt.END);
        boolean boolean1 = false;
        if (resourceId != 0) {
            final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, PagerTitleStrip.o);
            boolean1 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (boolean1) {
            a(this.b);
            a(this.c);
            a(this.d);
        }
        else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.h = (int)(16.0f * context.getResources().getDisplayMetrics().density);
    }
    
    private void a(final w w, final w referent) {
        if (w != null) {
            w.b(this.l);
            this.m = null;
        }
        if (referent != null) {
            referent.a(this.l);
            this.m = new WeakReference((T)referent);
        }
        if (this.a != null) {
            this.f = -1;
            this.g = -1.0f;
            this.b(this.a.b());
            this.requestLayout();
        }
    }
    
    private static void a(final TextView textView) {
        PagerTitleStrip.q.a(textView);
    }
    
    int a() {
        final Drawable background = this.getBackground();
        int intrinsicHeight = 0;
        if (background != null) {
            intrinsicHeight = background.getIntrinsicHeight();
        }
        return intrinsicHeight;
    }
    
    public void a(final int h) {
        this.h = h;
        this.requestLayout();
    }
    
    void a(final int n, final float g, final boolean b) {
        if (n != this.f) {
            this.a.a();
            this.b(n);
        }
        else if (!b && g == this.g) {
            return;
        }
        this.k = true;
        final int measuredWidth = this.b.getMeasuredWidth();
        final int measuredWidth2 = this.c.getMeasuredWidth();
        final int measuredWidth3 = this.d.getMeasuredWidth();
        final int n2 = measuredWidth2 / 2;
        final int width = this.getWidth();
        final int height = this.getHeight();
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        final int paddingTop = this.getPaddingTop();
        final int paddingBottom = this.getPaddingBottom();
        final int n3 = paddingLeft + n2;
        final int n4 = paddingRight + n2;
        final int n5 = width - n3 - n4;
        float n6 = 0.5f + g;
        if (n6 > 1.0f) {
            --n6;
        }
        final int n7 = width - n4 - (int)(n6 * n5) - n2;
        final int n8 = n7 + measuredWidth2;
        final int baseline = this.b.getBaseline();
        final int baseline2 = this.c.getBaseline();
        final int baseline3 = this.d.getBaseline();
        final int max = Math.max(Math.max(baseline, baseline2), baseline3);
        final int n9 = max - baseline;
        final int n10 = max - baseline2;
        final int n11 = max - baseline3;
        final int max2 = Math.max(Math.max(n9 + this.b.getMeasuredHeight(), n10 + this.c.getMeasuredHeight()), n11 + this.d.getMeasuredHeight());
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        switch (0x70 & this.i) {
            default: {
                n12 = paddingTop + n9;
                n13 = paddingTop + n10;
                n14 = paddingTop + n11;
                break;
            }
            case 16: {
                final int n15 = (height - paddingTop - paddingBottom - max2) / 2;
                n12 = n15 + n9;
                n13 = n15 + n10;
                n14 = n15 + n11;
                break;
            }
            case 80: {
                final int n16 = height - paddingBottom - max2;
                n12 = n16 + n9;
                n13 = n16 + n10;
                n14 = n16 + n11;
                break;
            }
        }
        this.c.layout(n7, n13, n8, n13 + this.c.getMeasuredHeight());
        final int min = Math.min(paddingLeft, n7 - this.h - measuredWidth);
        this.b.layout(min, n12, measuredWidth + min, n12 + this.b.getMeasuredHeight());
        final int max3 = Math.max(width - paddingRight - measuredWidth3, n8 + this.h);
        this.d.layout(max3, n14, max3 + measuredWidth3, n14 + this.d.getMeasuredHeight());
        this.g = g;
        this.k = false;
    }
    
    public final int b() {
        return this.h;
    }
    
    final void b(final int f) {
        this.j = true;
        this.b.setText((CharSequence)null);
        this.c.setText((CharSequence)null);
        this.d.setText((CharSequence)null);
        final int n = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
        final int n2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
        final int measureSpec = View$MeasureSpec.makeMeasureSpec((int)(0.8f * n), Integer.MIN_VALUE);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(n2, Integer.MIN_VALUE);
        this.b.measure(measureSpec, measureSpec2);
        this.c.measure(measureSpec, measureSpec2);
        this.d.measure(measureSpec, measureSpec2);
        this.f = f;
        if (!this.k) {
            this.a(f, this.g, false);
        }
        this.j = false;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final ViewParent parent = this.getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        final ViewPager a = (ViewPager)parent;
        final w a2 = a.a();
        a.a((bf)this.l);
        a.a((be)this.l);
        this.a = a;
        w w;
        if (this.m != null) {
            w = (w)this.m.get();
        }
        else {
            w = null;
        }
        this.a(w, a2);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a(this.a.a(), null);
            this.a.a((bf)null);
            this.a.a((be)null);
            this.a = null;
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        if (this.a != null) {
            final float n5 = fcmpl(this.g, 0.0f);
            float g = 0.0f;
            if (n5 >= 0) {
                g = this.g;
            }
            this.a(this.f, g, true);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        final int size = View$MeasureSpec.getSize(n);
        final int size2 = View$MeasureSpec.getSize(n2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        final int a = this.a();
        final int n3 = this.getPaddingTop() + this.getPaddingBottom();
        final int n4 = size2 - n3;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec((int)(0.8f * size), Integer.MIN_VALUE);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(n4, Integer.MIN_VALUE);
        this.b.measure(measureSpec, measureSpec2);
        this.c.measure(measureSpec, measureSpec2);
        this.d.measure(measureSpec, measureSpec2);
        if (mode2 == 1073741824) {
            this.setMeasuredDimension(size, size2);
            return;
        }
        this.setMeasuredDimension(size, Math.max(a, n3 + this.c.getMeasuredHeight()));
    }
    
    public void requestLayout() {
        if (!this.j) {
            super.requestLayout();
        }
    }
}
