// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.actionbarsherlock.view.MenuItem;
import com.ogqcorp.commons.t;
import android.os.Bundle;
import android.widget.Toast;
import android.graphics.Bitmap$CompressFormat;
import com.ogqcorp.commons.d;
import android.widget.ImageView;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.item.Effect;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import com.ogqcorp.bgh.system.ac;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ogqcorp.bgh.system.CropView;
import com.ogqcorp.bgh.system.SafeImageView;
import android.app.Activity;
import com.ogqcorp.commons.w;
import com.ogqcorp.bgh.system.e;
import android.graphics.Paint;
import android.graphics.Canvas;
import com.ogqcorp.commons.k;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Parcelable;
import java.io.Serializable;
import android.content.Intent;
import android.content.Context;
import android.graphics.Point;
import com.ogqcorp.bgh.item.Background;
import java.io.File;
import com.ogqcorp.bgh.activity.a.a;

public class AdjustActivity extends a
{
    private File a;
    private File b;
    private Background c;
    private Point d;
    private int e;
    private float f;
    private float g;
    
    public static Intent a(final Context context, final File file, final File file2, final Background background) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)AdjustActivity.class);
        intent.putExtra("KEY_SOURCE_FILE", (Serializable)file);
        intent.putExtra("KEY_RESULT_FILE", (Serializable)file2);
        intent.putExtra("KEY_BACKGROUND", (Parcelable)background);
        return intent;
    }
    
    private Bitmap a(final File file, final RectF rectF, final Point point, final Point point2) {
        final Bitmap b = k.b(file, Bitmap$Config.ARGB_8888, k.a(file, -1, point.y));
        this.a(rectF, b);
        final Bitmap a = k.a(b, Math.round(rectF.left), Math.round(rectF.top), Math.round(0.0f + rectF.width()), Math.round(0.0f + rectF.height()), Bitmap$Config.ARGB_8888);
        if (a != b) {
            b.recycle();
        }
        final Bitmap a2 = k.a(a, point.x, point.y, Bitmap$Config.ARGB_8888, true);
        if (a2 != a) {
            a.recycle();
        }
        if (point.equals((Object)point2)) {
            return a2;
        }
        final Bitmap bitmap = Bitmap.createBitmap(point2.x, point2.y, Bitmap$Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(-16777216);
        canvas.drawBitmap(a2, (point2.x - point.x) / 2.0f, (point2.y - point.y) / 2.0f, (Paint)null);
        a2.recycle();
        return bitmap;
    }
    
    private Point a(final boolean b) {
        if (b && this.g >= this.d.x / this.d.y) {
            return new Point(this.d.x, Math.round(this.d.x / this.g));
        }
        return new Point(Math.round(this.d.y * this.g), this.d.y);
    }
    
    private Point a(final boolean b, Point point) {
        if (com.ogqcorp.bgh.system.e.a((Context)this)) {
            point = new Point(this.d.y, this.d.y);
        }
        else if (b) {
            return this.d;
        }
        return point;
    }
    
    private void a() {
        final w w = new w(this);
        final SafeImageView safeImageView = (SafeImageView)this.findViewById(2131099741);
        final CropView cropView = (CropView)this.findViewById(2131099742);
        final BitmapDrawable a = k.a(this.a, Bitmap$Config.RGB_565, k.a(this.a, this.d.x, -1));
        if (a != null) {
            safeImageView.setImageDrawable((Drawable)a);
            this.a(this.f = a.getBitmap().getWidth() / a.getBitmap().getHeight());
            cropView.setOriginalRatio(this.f);
            if (!com.ogqcorp.bgh.system.e.a((Context)this)) {
                if (this.c != null && this.c.getEffect() != null) {
                    this.a(this.c.getEffect().getCropMode());
                    cropView.a(this.c.getEffect().getCropPosX(), this.c.getEffect().getCropPosY());
                    w.a(2131099747).b(this.c.getEffect().getIsScrollable());
                }
                else if (this.f >= this.d.x / this.d.y * 2.0f) {
                    this.findViewById(2131099744).performClick();
                }
                else {
                    this.findViewById(2131099745).performClick();
                }
            }
            else {
                w.a(2131099744).a(false).a(0.3f);
                this.findViewById(2131099745).performClick();
                w.a(2131099746).a(false).a(0.3f);
            }
        }
        safeImageView.a(this.a, Bitmap$Config.RGB_565);
        if (com.ogqcorp.bgh.system.e.b((Context)this)) {
            w.a(2131099748).c(2131427449).a();
        }
        else if (com.ogqcorp.bgh.system.e.a((Context)this)) {
            w.a(2131099748).c(2131427450).a();
        }
    }
    
    private void a(final float n) {
        final ViewGroup$LayoutParams layoutParams = this.findViewById(2131099740).getLayoutParams();
        layoutParams.width = this.d.x;
        layoutParams.height = (int)(0.5f + this.d.x / n);
        final int height = this.d.y - ac.e((Context)this) - ac.a((Context)this, 260.0f);
        if (layoutParams.height > height) {
            layoutParams.width = (int)(0.5f + n * height);
            layoutParams.height = height;
        }
    }
    
    private void a(final int n) {
        this.findViewById((new int[] { 2131099744, 2131099745, 2131099746 })[n]).performClick();
    }
    
    private void a(final RectF rectF, final Bitmap bitmap) {
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        rectF.set(rectF.left * width, rectF.top * height, rectF.right * width, rectF.bottom * height);
    }
    
    private void a(final View view, final int e, final float n, final boolean b, final boolean b2) {
        final w w = new w(this);
        final int[] array = { 2131099744, 2131099745, 2131099746 };
        for (int length = array.length, i = 0; i < length; ++i) {
            if (w.a(array[i]).b()) {
                w.b(false);
            }
        }
        w.a(view).b(true);
        this.e = e;
        this.g = n;
        ((CropView)this.findViewById(2131099742)).setCropRatio(n);
        final w a = w.a(2131099747).b(b).a(b2);
        float n2;
        if (b2) {
            n2 = 1.0f;
        }
        else {
            n2 = 0.3f;
        }
        a.a(n2);
    }
    
    private boolean b() {
        return this.e == 2 && !new w(this).a(2131099747).c();
    }
    
    private void c() {
        final CropView cropView = (CropView)this.findViewById(2131099742);
        if (cropView != null && this.c != null) {
            Effect effect = this.c.getEffect();
            if (effect == null) {
                effect = new Effect();
            }
            effect.setCropMode(this.e);
            effect.setCropPosX(cropView.getCropRect().left);
            effect.setCropPosY(cropView.getCropRect().top);
            this.c.setEffect(effect);
        }
    }
    
    public void onApply(final View view) {
        final boolean b = this.b();
        final Point a = this.a(b);
        final Point a2 = this.a(b, a);
        l.a("## [APPLY] adjustSize: %s, resultSize: %s", a, a2);
        ac.a((ImageView)this.findViewById(2131099741));
        final RectF cropRect = ((CropView)this.findViewById(2131099742)).getCropRect();
        l.a("## [APPLY] cropRect: %s", cropRect);
        ((d<Object, Progress, Result>)new d<Object, Object, Boolean>() {
            protected Boolean a(final Object... array) {
                try {
                    final Bitmap a = AdjustActivity.this.a(AdjustActivity.this.a, cropRect, a, a2);
                    System.gc();
                    k.a(a, AdjustActivity.this.b, Bitmap$CompressFormat.PNG, 100);
                    a.recycle();
                    System.gc();
                    return true;
                }
                catch (Exception ex) {
                    return null;
                }
            }
            
            protected void a(final Boolean b) {
                super.onPostExecute(b);
                if (AdjustActivity.this.isFinishing()) {
                    return;
                }
                if (b == null) {
                    AdjustActivity.this.a();
                    Toast.makeText((Context)AdjustActivity.this, 2131427480, 1).show();
                    return;
                }
                AdjustActivity.this.c();
                final Intent intent = new Intent();
                intent.putExtra("KEY_CX", a2.x);
                intent.putExtra("KEY_CY", a2.y);
                intent.putExtra("KEY_BACKGROUND", (Parcelable)AdjustActivity.this.c);
                AdjustActivity.this.setResult(-1, intent);
                AdjustActivity.this.finish();
            }
        }).a((Context)this, 2131427462, new Object[0]);
    }
    
    public void onCancel(final View view) {
        this.setResult(0);
        this.finish();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (this.getIntent() == null) {
            this.finish();
            return;
        }
        this.a = (File)this.getIntent().getSerializableExtra("KEY_SOURCE_FILE");
        this.b = (File)this.getIntent().getSerializableExtra("KEY_RESULT_FILE");
        if (this.a == null || this.b == null) {
            this.finish();
            return;
        }
        this.c = (Background)this.getIntent().getParcelableExtra("KEY_BACKGROUND");
        this.setContentView(2130903062);
        this.d = ac.c((Context)this);
        this.a();
    }
    
    @Override
    protected void onDestroy() {
        t.a(this);
        System.gc();
        super.onDestroy();
    }
    
    public void onEntire(final View view) {
        this.a(view, 2, this.f, true, true);
    }
    
    public void onFixed(final View view) {
        this.a(view, 1, 1.0f * this.d.x / this.d.y, false, false);
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.setResult(0);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
    
    public void onStandard(final View view) {
        this.a(view, 0, 2.0f * this.d.x / this.d.y, true, false);
    }
}
