// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc.a;

import android.view.View$OnClickListener;
import android.widget.ListAdapter;
import android.app.AlertDialog$Builder;
import java.io.IOException;
import com.ogqcorp.bgh.widget.sc.a;
import com.ogqcorp.bgh.widget.a.f;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.ogqcorp.bgh.widget.a.d;
import com.ogqcorp.bgh.widget.a.b;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.app.Activity;

public final class b extends c
{
    public b(final Activity activity) {
        super(activity);
    }
    
    private void b() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.a, 17367057) {
            public View getView(final int n, final View view, final ViewGroup viewGroup) {
                final TextView textView = (TextView)super.getView(n, view, viewGroup);
                final String s = (String)this.getItem(n);
                try {
                    textView.setTypeface(com.ogqcorp.bgh.widget.a.b.a((Context)b.this.a, s));
                    return (View)textView;
                }
                catch (Exception ex) {
                    d.c(ex);
                    return (View)textView;
                }
            }
        };
        final DialogInterface$OnClickListener dialogInterface$OnClickListener = (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                f.a().a((Context)com.ogqcorp.bgh.widget.sc.a.b.this.a, (String)arrayAdapter.getItem(n));
                com.ogqcorp.bgh.widget.sc.a.b.this.c();
                com.ogqcorp.bgh.widget.sc.a.a((Context)com.ogqcorp.bgh.widget.sc.a.b.this.a);
            }
        };
        try {
            final String[] a = com.ogqcorp.bgh.widget.a.b.a((Context)this.a);
            for (int length = a.length, i = 0; i < length; ++i) {
                arrayAdapter.add((Object)a[i]);
            }
        }
        catch (IOException ex) {
            d.b(ex);
        }
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.a);
        alertDialog$Builder.setTitle(com.ogqcorp.bgh.widget.d.widget_sc_font_chooser_title).setAdapter((ListAdapter)arrayAdapter, (DialogInterface$OnClickListener)dialogInterface$OnClickListener);
        alertDialog$Builder.create().show();
    }
    
    private void c() {
        final String a = f.a().a((Context)this.a);
        final TextView textView = (TextView)this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_font);
        textView.setText((CharSequence)a);
        try {
            textView.setTypeface(com.ogqcorp.bgh.widget.a.b.a((Context)this.a, a));
        }
        catch (Exception ex) {
            d.c(ex);
        }
    }
    
    @Override
    public void a() {
        this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_font).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                b.this.b();
            }
        });
        this.c();
    }
}
