// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc.a;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import com.ogqcorp.bgh.widget.d;
import com.ogqcorp.commons.cp.a;
import com.ogqcorp.commons.cp.b;
import android.content.Context;
import com.ogqcorp.bgh.widget.a.f;
import android.app.Activity;

public final class d extends c
{
    public d(final Activity activity) {
        super(activity);
    }
    
    private void b() {
        final a a = new a((Context)this.a, f.a().b((Context)this.a), new b() {
            @Override
            public void a(final a a, final int n) {
                f.a().a((Context)d.this.a, n);
                com.ogqcorp.bgh.widget.sc.a.a((Context)d.this.a);
                d.this.c();
            }
            
            @Override
            public void onCancel(final a a) {
            }
        });
        a.b().setTitle(com.ogqcorp.bgh.widget.d.widget_sc_color_picker_title);
        a.a();
    }
    
    private void c() {
        ((TextView)this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_text_color_colors)).setTextColor(f.a().b((Context)this.a));
    }
    
    @Override
    public void a() {
        this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_text_color_black).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                f.a().a((Context)d.this.a, -16777216);
                com.ogqcorp.bgh.widget.sc.a.a((Context)d.this.a);
                d.this.c();
            }
        });
        this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_text_color_white).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                f.a().a((Context)d.this.a, -1);
                com.ogqcorp.bgh.widget.sc.a.a((Context)d.this.a);
                d.this.c();
            }
        });
        this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_text_color_colors).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                d.this.b();
            }
        });
        this.c();
    }
}
