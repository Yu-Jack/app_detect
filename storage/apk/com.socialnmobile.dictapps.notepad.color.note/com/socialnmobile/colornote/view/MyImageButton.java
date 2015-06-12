// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.View$OnLongClickListener;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import android.widget.Toast;
import android.util.AttributeSet;
import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import android.widget.ImageButton;

public class MyImageButton extends ImageButton
{
    CopyOnWriteArrayList a;
    int b;
    boolean c;
    
    public MyImageButton(final Context context) {
        super(context);
        this.a = new CopyOnWriteArrayList();
    }
    
    public MyImageButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new CopyOnWriteArrayList();
    }
    
    public MyImageButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.a = new CopyOnWriteArrayList();
    }
    
    public final void a() {
        final Toast text = Toast.makeText(this.getContext(), this.b, 0);
        text.setGravity(51, this.getLeft() - gw.c(this.getContext(), 120), this.getBottom());
        text.show();
    }
    
    public final void a(final zp e) {
        this.a.add(e);
    }
    
    public final void b(final zp o) {
        this.a.remove(o);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final Iterator<zp> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().a((View)this);
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
    
    public void requestLayout() {
        if (!this.c) {
            super.requestLayout();
        }
    }
    
    public void setBlockLayout(final boolean c) {
        this.c = c;
    }
    
    public void setTitle(final int b) {
        this.b = b;
        if (b == 0) {
            this.setOnLongClickListener((View$OnLongClickListener)null);
            return;
        }
        this.setOnLongClickListener((View$OnLongClickListener)new zs(this));
    }
}
