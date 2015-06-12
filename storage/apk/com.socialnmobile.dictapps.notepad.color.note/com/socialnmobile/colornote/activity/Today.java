// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.text.format.DateUtils;
import android.widget.ListAdapter;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.content.Intent;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.app.Dialog;
import android.database.Cursor;

public class Today extends ThemeActivity
{
    public Cursor a;
    boolean b;
    boolean d;
    Dialog e;
    Dialog f;
    DialogInterface$OnClickListener g;
    DialogInterface$OnCancelListener h;
    DialogInterface$OnCancelListener i;
    
    public Today() {
        this.b = false;
        this.d = false;
        this.g = (DialogInterface$OnClickListener)new ja(this);
        this.h = (DialogInterface$OnCancelListener)new jb(this);
        this.i = (DialogInterface$OnCancelListener)new jc(this);
    }
    
    public final void a(final int n) {
        final Intent intent = new Intent("android.intent.action.INSERT", kf.a);
        intent.putExtra("socialnmobile.intent.extra.TYPE", n);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_TYPE", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_DATE", System.currentTimeMillis());
        this.startActivity(intent);
    }
    
    public final void b(final int n) {
        Object o = null;
        switch (n) {
            case 1: {
                final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this);
                alertDialog$Builder.setTitle(2131230874);
                alertDialog$Builder.setAdapter((ListAdapter)aam.a((Context)this, this.a, 4, false), this.g);
                alertDialog$Builder.setOnCancelListener(this.h);
                alertDialog$Builder.setNeutralButton(2131230854, (DialogInterface$OnClickListener)new jd(this));
                o = alertDialog$Builder.create();
                final ListView listView = ((AlertDialog)o).getListView();
                listView.setBackgroundColor(gr.a((Context)this).n(3));
                listView.setDivider(this.getResources().getDrawable(2130837553));
                final int dimensionPixelSize = this.getResources().getDimensionPixelSize(2131361798);
                listView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                listView.setSelector(2130837654);
                listView.setDrawSelectorOnTop(true);
                ((AlertDialog)o).setCanceledOnTouchOutside(true);
                this.b = true;
                ((AlertDialog)o).setTitle((CharSequence)DateUtils.formatDateTime((Context)this, System.currentTimeMillis(), 32786));
                this.e = (Dialog)o;
                break;
            }
            case 2: {
                o = rh.a((Context)this, new je(this), null).a((Context)this);
                ((Dialog)o).setOnCancelListener(this.i);
                this.d = true;
                this.f = (Dialog)o;
                break;
            }
        }
        ((Dialog)o).show();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a();
    }
    
    protected void onPause() {
        if (this.a != null && !this.a.isClosed()) {
            this.a.close();
            this.a = null;
        }
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        this.a = kg.a((Context)this, System.currentTimeMillis());
        this.b(1);
    }
    
    @Override
    protected void onStop() {
        if (this.d) {
            if (this.f != null) {
                this.f.dismiss();
                this.f = null;
            }
            this.d = false;
        }
        if (this.b) {
            if (this.e != null) {
                this.e.dismiss();
                this.e = null;
            }
            this.b = false;
        }
        super.onStop();
    }
}
