// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.MenuItem;
import android.view.View;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.app.Activity;
import android.support.v4.widget.f;
import android.support.v4.view.al;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.InsetDrawable;

class ActionBarDrawerToggle$SlideDrawable extends InsetDrawable implements Drawable$Callback
{
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    final /* synthetic */ ActionBarDrawerToggle this$0;
    
    private ActionBarDrawerToggle$SlideDrawable(final ActionBarDrawerToggle this$0, final Drawable drawable) {
        this.this$0 = this$0;
        super(drawable, 0);
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean mHasMirroring = false;
        if (sdk_INT > 18) {
            mHasMirroring = true;
        }
        this.mHasMirroring = mHasMirroring;
        this.mTmpRect = new Rect();
    }
    
    public void draw(final Canvas canvas) {
        int n = 1;
        this.copyBounds(this.mTmpRect);
        canvas.save();
        int n2;
        if (al.e(this.this$0.mActivity.getWindow().getDecorView()) == n) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0) {
            n = -1;
        }
        final int width = this.mTmpRect.width();
        canvas.translate(-this.mOffset * width * this.mPosition * n, 0.0f);
        if (n2 != 0 && !this.mHasMirroring) {
            canvas.translate((float)width, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }
    
    public float getPosition() {
        return this.mPosition;
    }
    
    public void setOffset(final float mOffset) {
        this.mOffset = mOffset;
        this.invalidateSelf();
    }
    
    public void setPosition(final float mPosition) {
        this.mPosition = mPosition;
        this.invalidateSelf();
    }
}
