// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import com.facebook.a.c;
import com.facebook.b.k;
import com.facebook.b.r;
import com.facebook.b.q;
import java.net.URI;
import android.net.Uri$Builder;
import java.net.URISyntaxException;
import com.facebook.b.al;
import android.graphics.BitmapFactory;
import com.facebook.a.d;
import com.facebook.ab;
import com.facebook.b.v;
import com.facebook.ak;
import com.facebook.b.s;
import android.content.res.TypedArray;
import com.facebook.a.h;
import android.view.View;
import android.widget.ImageView$ScaleType;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import com.facebook.b.p;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.widget.FrameLayout;

public class ProfilePictureView extends FrameLayout
{
    public static final String a;
    private String b;
    private int c;
    private int d;
    private boolean e;
    private Bitmap f;
    private ImageView g;
    private int h;
    private p i;
    private g j;
    private Bitmap k;
    
    static {
        a = ProfilePictureView.class.getSimpleName();
    }
    
    public ProfilePictureView(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = 0;
        this.d = 0;
        this.e = true;
        this.h = -1;
        this.k = null;
        this.a(context);
        this.a(set);
    }
    
    public ProfilePictureView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.c = 0;
        this.d = 0;
        this.e = true;
        this.h = -1;
        this.k = null;
        this.a(context);
        this.a(set);
    }
    
    private void a(final Context context) {
        this.removeAllViews();
        (this.g = new ImageView(context)).setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
        this.g.setScaleType(ImageView$ScaleType.CENTER_INSIDE);
        this.addView((View)this.g);
    }
    
    private void a(final Bitmap bitmap) {
        if (this.g != null && bitmap != null) {
            this.f = bitmap;
            this.g.setImageBitmap(bitmap);
        }
    }
    
    private void a(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, com.facebook.a.h.e);
        final int int1 = obtainStyledAttributes.getInt(0, -1);
        switch (int1) {
            default: {
                throw new IllegalArgumentException("Must use a predefined preset size");
            }
            case -4:
            case -3:
            case -2:
            case -1: {
                this.h = int1;
                this.requestLayout();
                this.e = obtainStyledAttributes.getBoolean(1, true);
                obtainStyledAttributes.recycle();
            }
        }
    }
    
    static /* synthetic */ void a(final ProfilePictureView profilePictureView, final s s) {
        if (s.a() == profilePictureView.i) {
            profilePictureView.i = null;
            final Bitmap c = s.c();
            final Exception b = s.b();
            if (b != null) {
                if (profilePictureView.j == null) {
                    v.a(ak.a, 6, ProfilePictureView.a, b.toString());
                    return;
                }
                new ab("Error in downloading profile picture for profileId: " + profilePictureView.b, b);
            }
            else if (c != null) {
                profilePictureView.a(c);
                if (s.d()) {
                    profilePictureView.b(false);
                }
            }
        }
    }
    
    private void a(final boolean b) {
        final boolean a = this.a();
        if (this.b == null || this.b.length() == 0 || (this.d == 0 && this.c == 0)) {
            if (this.k != null) {
                this.a();
                this.a(Bitmap.createScaledBitmap(this.k, this.d, this.c, false));
                return;
            }
            int n;
            if (this.e) {
                n = com.facebook.a.d.e;
            }
            else {
                n = com.facebook.a.d.d;
            }
            this.a(BitmapFactory.decodeResource(this.getResources(), n));
        }
        else if (a || b) {
            this.b(true);
        }
    }
    
    private boolean a() {
        int height = this.getHeight();
        final int width = this.getWidth();
        if (width <= 0 || height <= 0) {
            return false;
        }
        int c = this.c(false);
        if (c != 0) {
            height = c;
        }
        else {
            c = width;
        }
        int c2;
        if (c <= height) {
            if (this.e) {
                c2 = c;
            }
            else {
                c2 = 0;
            }
        }
        else {
            int n;
            if (this.e) {
                n = height;
            }
            else {
                n = 0;
            }
            c = n;
            c2 = height;
        }
        while (true) {
            Label_0116: {
                if (c != this.d) {
                    break Label_0116;
                }
                final int c3 = this.c;
                final boolean b = false;
                if (c2 != c3) {
                    break Label_0116;
                }
                this.d = c;
                this.c = c2;
                return b;
            }
            final boolean b = true;
            continue;
        }
    }
    
    private void b(final boolean b) {
        Context context;
        String b2;
        int max;
        int max2;
        try {
            context = this.getContext();
            b2 = this.b;
            final int d = this.d;
            final int c = this.c;
            al.a(b2, "userId");
            max = Math.max(d, 0);
            max2 = Math.max(c, 0);
            if (max == 0 && max2 == 0) {
                throw new IllegalArgumentException("Either width or height must be greater than 0");
            }
        }
        catch (URISyntaxException ex) {
            v.a(ak.a, 6, ProfilePictureView.a, ex.toString());
            return;
        }
        final Uri$Builder encodedPath = new Uri$Builder().encodedPath(String.format("https://graph.facebook.com/%s/picture", b2));
        if (max2 != 0) {
            encodedPath.appendQueryParameter("height", String.valueOf(max2));
        }
        if (max != 0) {
            encodedPath.appendQueryParameter("width", String.valueOf(max));
        }
        encodedPath.appendQueryParameter("migration_overrides", "{october_2012:true}");
        final p a = new q(context, new URI(encodedPath.toString())).a(b).a(this).a(new r() {
            @Override
            public final void a(final s s) {
                ProfilePictureView.a(ProfilePictureView.this, s);
            }
        }).a();
        if (this.i != null) {
            com.facebook.b.k.b(this.i);
        }
        com.facebook.b.k.a(this.i = a);
    }
    
    private int c(final boolean b) {
        switch (this.h) {
            case -2: {
                final int n = com.facebook.a.c.i;
                return this.getResources().getDimensionPixelSize(n);
            }
            case -3: {
                final int n = com.facebook.a.c.h;
                return this.getResources().getDimensionPixelSize(n);
            }
            case -4: {
                final int n = com.facebook.a.c.g;
                return this.getResources().getDimensionPixelSize(n);
            }
            case -1: {
                if (b) {
                    final int n = com.facebook.a.c.h;
                    return this.getResources().getDimensionPixelSize(n);
                }
                break;
            }
        }
        return 0;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = null;
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.a(false);
    }
    
    protected void onMeasure(int measureSpec, int measureSpec2) {
        boolean b = true;
        final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
        int n = View$MeasureSpec.getSize(measureSpec2);
        final int size = View$MeasureSpec.getSize(measureSpec);
        final int mode = View$MeasureSpec.getMode(measureSpec2);
        boolean b2 = false;
        if (mode != 1073741824) {
            final int height = layoutParams.height;
            b2 = false;
            if (height == -2) {
                n = this.c(b);
                measureSpec2 = View$MeasureSpec.makeMeasureSpec(n, 1073741824);
                b2 = b;
            }
        }
        int c;
        if (View$MeasureSpec.getMode(measureSpec) != 1073741824 && layoutParams.width == -2) {
            c = this.c(b);
            measureSpec = View$MeasureSpec.makeMeasureSpec(c, 1073741824);
        }
        else {
            b = b2;
            c = size;
        }
        if (b) {
            this.setMeasuredDimension(c, n);
            this.measureChildren(measureSpec, measureSpec2);
            return;
        }
        super.onMeasure(measureSpec, measureSpec2);
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
        }
        else {
            final Bundle bundle = (Bundle)parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
            this.b = bundle.getString("ProfilePictureView_profileId");
            this.h = bundle.getInt("ProfilePictureView_presetSize");
            this.e = bundle.getBoolean("ProfilePictureView_isCropped");
            this.d = bundle.getInt("ProfilePictureView_width");
            this.c = bundle.getInt("ProfilePictureView_height");
            this.a((Bitmap)bundle.getParcelable("ProfilePictureView_bitmap"));
            if (bundle.getBoolean("ProfilePictureView_refresh")) {
                this.a(true);
            }
        }
    }
    
    protected Parcelable onSaveInstanceState() {
        final Parcelable onSaveInstanceState = super.onSaveInstanceState();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", onSaveInstanceState);
        bundle.putString("ProfilePictureView_profileId", this.b);
        bundle.putInt("ProfilePictureView_presetSize", this.h);
        bundle.putBoolean("ProfilePictureView_isCropped", this.e);
        bundle.putParcelable("ProfilePictureView_bitmap", (Parcelable)this.f);
        bundle.putInt("ProfilePictureView_width", this.d);
        bundle.putInt("ProfilePictureView_height", this.c);
        bundle.putBoolean("ProfilePictureView_refresh", this.i != null);
        return (Parcelable)bundle;
    }
}
