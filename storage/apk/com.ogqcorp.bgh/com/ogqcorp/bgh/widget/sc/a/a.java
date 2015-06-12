// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc.a;

import android.view.View$OnClickListener;
import com.ogqcorp.bgh.widget.b;
import android.widget.ListAdapter;
import android.app.AlertDialog$Builder;
import com.ogqcorp.bgh.widget.a.a;
import com.ogqcorp.bgh.widget.a.f;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.ArrayAdapter;
import com.ogqcorp.bgh.widget.d;
import android.app.Activity;

public final class a extends c
{
    private static final String[] b;
    
    static {
        b = new String[] { "@NONE", "@PREFERENCES", "@ALARM" };
    }
    
    public a(final Activity activity) {
        super(activity);
    }
    
    private String a(final String anObject) {
        if ("@NONE".equals(anObject)) {
            return this.a.getString(d.widget_sc_click_action_none);
        }
        if ("@PREFERENCES".equals(anObject)) {
            return this.a.getString(d.widget_sc_click_action_preferences);
        }
        if ("@ALARM".equals(anObject)) {
            return this.a.getString(d.widget_sc_click_action_alarm);
        }
        return null;
    }
    
    private void b() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.a, 17367057) {
            public View getView(final int n, final View view, final ViewGroup viewGroup) {
                final TextView textView = (TextView)super.getView(n, view, viewGroup);
                textView.setTextSize(18.0f);
                textView.setText((CharSequence)com.ogqcorp.bgh.widget.sc.a.a.this.a((String)this.getItem(n)));
                return (View)textView;
            }
        };
        final DialogInterface$OnClickListener dialogInterface$OnClickListener = (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                final String anObject = (String)arrayAdapter.getItem(n);
                f.a().b((Context)com.ogqcorp.bgh.widget.sc.a.a.this.a, anObject);
                com.ogqcorp.bgh.widget.sc.a.a.this.c();
                if (!"@PREFERENCES".equals(anObject)) {
                    com.ogqcorp.bgh.widget.sc.a.a.this.d();
                }
            }
        };
        for (final String anObject : a.b) {
            if (!"@ALARM".equals(anObject) || com.ogqcorp.bgh.widget.a.a.a((Context)this.a) != null) {
                arrayAdapter.add((Object)anObject);
            }
        }
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.a);
        alertDialog$Builder.setTitle(d.widget_sc_click_action_chooser_title).setAdapter((ListAdapter)arrayAdapter, (DialogInterface$OnClickListener)dialogInterface$OnClickListener);
        alertDialog$Builder.create().show();
    }
    
    private void c() {
        ((TextView)this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_click_action)).setText((CharSequence)this.a(f.a().f((Context)this.a)));
    }
    
    private void d() {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.a);
        alertDialog$Builder.setTitle(d.widget_sc_name).setMessage(d.widget_sc_alert_silent).setNegativeButton(17039370, (DialogInterface$OnClickListener)null);
        alertDialog$Builder.create().show();
    }
    
    @Override
    public void a() {
        this.a.findViewById(com.ogqcorp.bgh.widget.b.widget_sc_click_action).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                com.ogqcorp.bgh.widget.sc.a.a.this.b();
            }
        });
        this.c();
    }
}
