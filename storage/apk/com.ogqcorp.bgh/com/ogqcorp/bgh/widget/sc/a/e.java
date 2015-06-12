// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc.a;

import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import android.view.View;
import android.app.Activity;
import com.ogqcorp.bgh.widget.b;

public final class e extends c
{
    private static final int[] b;
    
    static {
        b = new int[] { com.ogqcorp.bgh.widget.b.widget_sc_font_title, com.ogqcorp.bgh.widget.b.widget_sc_font, com.ogqcorp.bgh.widget.b.widget_sc_text_color_title, com.ogqcorp.bgh.widget.b.widget_sc_text_color, com.ogqcorp.bgh.widget.b.widget_sc_position_title, com.ogqcorp.bgh.widget.b.widget_sc_click_action_title, com.ogqcorp.bgh.widget.b.widget_sc_click_action };
    }
    
    public e(final Activity activity) {
        super(activity);
    }
    
    private void a(final boolean b) {
        final int[] b2 = e.b;
        for (int length = b2.length, i = 0; i < length; ++i) {
            final View viewById = this.a.findViewById(b2[i]);
            int visibility;
            if (b) {
                visibility = 0;
            }
            else {
                visibility = 4;
            }
            viewById.setVisibility(visibility);
        }
    }
    
    @Override
    public void a() {
        this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_position).setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    e.this.a(false);
                    e.this.a.findViewById(com.ogqcorp.bgh.widget.b.background).setBackgroundColor(1713512994);
                }
                else if (motionEvent.getAction() == 1) {
                    e.this.a(true);
                    e.this.a.findViewById(com.ogqcorp.bgh.widget.b.background).setBackgroundColor(-584965598);
                    return false;
                }
                return false;
            }
        });
    }
}
