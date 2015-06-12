// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar
{
    private long a;
    private boolean b;
    private boolean c;
    private boolean d;
    private final Runnable e;
    private final Runnable f;
    
    public ContentLoadingProgressBar(final Context context, final AttributeSet set) {
        super(context, set, 0);
        this.a = -1L;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new Runnable() {
            @Override
            public final void run() {
                ContentLoadingProgressBar.this.b = false;
                ContentLoadingProgressBar.this.a = -1L;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f = new Runnable() {
            @Override
            public final void run() {
                ContentLoadingProgressBar.this.c = false;
                if (!ContentLoadingProgressBar.this.d) {
                    ContentLoadingProgressBar.this.a = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }
    
    private void a() {
        this.removeCallbacks(this.e);
        this.removeCallbacks(this.f);
    }
    
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a();
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a();
    }
}
